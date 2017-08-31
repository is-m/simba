package cn.ism.fw.simba.orm.mybatis;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ism.fw.simba.base.PageVO;
import cn.ism.fw.simba.base.PagedResult;
import cn.ism.fw.simba.orm.mybatis.util.SqlHelper;
import cn.ism.fw.simba.util.ReflectUtil;
import cn.ism.fw.simba.util.SpringUtil;

/**
 * 分页插件 应为每加入一个插件都会导致MAP Executor： 、StatementHandler：
 * PameterHandler：、ResultSetHandler：
 * 
 * @since 2017年7月30日
 * @author Administrator
 */
@Intercepts({ @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
		RowBounds.class, ResultHandler.class }) })
public class PageInterceptor implements Interceptor {

	private static final Logger LOG = LoggerFactory.getLogger(PageInterceptor.class);

	protected Properties properties;

	/**
	 * 任何时候，该接口返回值都应该为LIST，否则会提示类型转换的错误
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {

		Executor executor = (Executor) invocation.getTarget();
		Object[] args = invocation.getArgs();
		MappedStatement mappedStatement = (MappedStatement) args[0];
		Object sqlParams = args[1];

		// 获取绑定的SQL
		BoundSql boundSql = mappedStatement.getBoundSql(sqlParams);
		String originalSql = boundSql.getSql().trim();
		// Object parameterObject = boundSql.getParameterObject();

		Configuration mapperConfig = mappedStatement.getConfiguration();
		Connection connection = mapperConfig.getEnvironment().getDataSource().getConnection();
		String currentSqlId = mappedStatement.getId();

		Method execMethod = ReflectUtil.getMethod(currentSqlId);
		if (execMethod == null) {
			return invocation.proceed();
		}

		Class<?> returnType = execMethod.getReturnType();
		LOG.info("pageInterceptor  sqlid:{} , resultType:{}, sql:{}", currentSqlId, returnType.getName(),
				originalSql.replaceAll("\\s+", " "));

		// 如果返回值为 PagedResult 则检查参数中是否有分页参数
		PageVO pageVO = null;
		// 如果非分页
		if (returnType == PagedResult.class) {
			pageVO = this.getPageVO(sqlParams);
			// 如果返回值类型为分页类型，而未包含分页参数则抛出异常
			if (pageVO == null) {
				throw new IllegalArgumentException(
						"not support result type is PagedResult and search condition no exists PageVO api for mybatis interface "
								+ currentSqlId);
			}

			// 获取总记录数
			// 检查是否有自定义的获取总数的Sql
			String countSqlId = currentSqlId + "Count";
			boolean existsCountSqlStatement = mapperConfig.getMappedStatementNames().contains(countSqlId);
			int totalRecord = 0;
			if (existsCountSqlStatement) {
				MappedStatement countSqlStatement = mapperConfig.getMappedStatement(countSqlId);
				List<Object> list = executor.query(countSqlStatement, sqlParams, new RowBounds(), null);
				if (list.size() > 1) {
					throw new TooManyResultsException();
				}
				totalRecord = (int) list.get(0);
			} else {
				String countSql = getCountSql(originalSql);
				totalRecord = SqlHelper.selectOne(countSql, int.class);
			}
			
			pageVO.setTotalRecord(totalRecord);
			LOG.info("page::{}", pageVO.toString());

			List<Object> pageData = null;
			if (totalRecord > 1) {
				String database = prepareAndCheckDatabaseType(connection);
				PageQueryStrategy pqs = SpringUtil.getBeanOfLikeName(PageQueryStrategy.class, database);
				String pageSql = pqs.getPagedSql(pageVO, boundSql.getSql());
				LOG.info("pageSql::{}", pageSql);
				ReflectUtil.setFieldValue(boundSql, "sql", pageSql);
				pageData = totalRecord == 0 ? null
						: executor.query(mappedStatement, sqlParams, RowBounds.DEFAULT, null);
			}

			PagedResult<?> result = new PagedResult<>(pageVO, pageData);
			return Arrays.asList(result);
		}

		return invocation.proceed();
	}

	protected String prepareAndCheckDatabaseType(Connection connection) throws SQLException {
		String productName = connection.getMetaData().getDatabaseProductName();
		LOG.trace("Database productName::{} ", productName);
		productName = productName.toLowerCase();
		return productName;
	}

	private PageVO getPageVO(Object parameter) {
		if (parameter instanceof Map<?, ?>) {
			Map<?, ?> paramMap = (Map<?, ?>) parameter;
			for (Object paramItem : paramMap.values()) {
				if (paramItem instanceof PageVO) {
					return (PageVO) paramItem;
				}
			}
		} else {
			throw new IllegalArgumentException("暂不支持非Map以外的参数类型");
		}
		return null;
	}

	/**
	 * 根据查询SQL获取总记录数SQL
	 * 
	 * @param sql
	 * @return
	 * @since 2017年8月27日
	 * @author Administrator
	 */
	private String getCountSql(String sql) {
		sql = sql.toUpperCase();
		StringBuffer countSql = new StringBuffer();
		countSql.append("SELECT COUNT(1) FROM (");

		// 存在排序则处理排序后在拼接
		int orderPos = sql.indexOf("ORDER BY");
		countSql.append(orderPos < 1 ? sql : sql.substring(0, orderPos));

		countSql.append(") pageCountTab");
		return countSql.toString();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}
