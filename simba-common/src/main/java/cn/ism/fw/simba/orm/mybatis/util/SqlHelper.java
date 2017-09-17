package cn.ism.fw.simba.orm.mybatis.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionTemplate;

import cn.ism.fw.simba.util.SpringUtil;

/**
 * 该类实现主要是拷贝的 SqlMapper 的代码，但是修改了SqlSession改成使用SqlSessionTemplate
 * http://git.oschina.net/free/EntityMapper
 * 实际上mybaits 有一个类型安全的SQL构造程序
 * @author Administrator
 *
 */
public class SqlHelper { 

	private static MSUtils msUtils;
	
	static {
		msUtils = new MSUtils(getSqlSessionTemplate().getConfiguration());
	}

	/**
	 * 使用该类，会自动关闭链接
	 * @return
	 * @since 2017年8月27日
	 * @author Administrator
	 * @see org.mybatis.spring.SqlSessionTemplate$$SqlSessionInterceptor invoke
	 */
	public static SqlSessionTemplate getSqlSessionTemplate() {
		return SpringUtil.getContext().getBean(SqlSessionTemplate.class);  
	}

	/**
	 * 获取List中最多只有一个的数据
	 *
	 * @param list List结果
	 * @param <T>  泛型类型
	 * @return
	 */
	private static <T> T getOne(List<T> list) {
		if (list.size() == 1) {
			return list.get(0);
		} else if (list.size() > 1) {
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + list.size());
		} else {
			return null;
		}
	}

	/**
	 * 查询返回一个结果，多个结果时抛出异常
	 *
	 * @param sql 执行的sql
	 * @return
	 */
	public static  Map<String, Object> selectOne(String sql) {
		List<Map<String, Object>> list = selectList(sql);
		return getOne(list);
	}

	/**
	 * 查询返回一个结果，多个结果时抛出异常
	 *
	 * @param sql   执行的sql
	 * @param value 参数
	 * @return
	 */
	public static Map<String, Object> selectOne(String sql, Object value) {
		List<Map<String, Object>> list = selectList(sql, value);
		return getOne(list);
	}

	/**
	 * 查询返回一个结果，多个结果时抛出异常
	 *
	 * @param sql        执行的sql
	 * @param resultType 返回的结果类型
	 * @param <T>        泛型类型
	 * @return
	 */
	public static <T> T selectOne(String sql, Class<T> resultType) {
		List<T> list = selectList(sql, resultType);
		return getOne(list);
	}

	/**
	 * 查询返回一个结果，多个结果时抛出异常
	 *
	 * @param sql        执行的sql
	 * @param value      参数
	 * @param resultType 返回的结果类型
	 * @param <T>        泛型类型
	 * @return
	 */
	public static <T> T selectOne(String sql, Object value, Class<T> resultType) {
		List<T> list = selectList(sql, value, resultType);
		return getOne(list);
	}

	/**
	 * 查询返回List<Map<String, Object>>
	 *
	 * @param sql 执行的sql
	 * @return
	 */
	public static List<Map<String, Object>> selectList(String sql) {
		String msId = msUtils.select(sql);
		return getSqlSessionTemplate().selectList(msId);
	}

	/**
	 * 查询返回List<Map<String, Object>>
	 *
	 * @param sql   执行的sql
	 * @param value 参数
	 * @return
	 */
	public static List<Map<String, Object>> selectList(String sql, Object value) {
		Class<?> parameterType = value != null ? value.getClass() : null;
		String msId = msUtils.selectDynamic(sql, parameterType);
		return getSqlSessionTemplate().selectList(msId, value);
	}

	/**
	 * 查询返回指定的结果类型
	 *
	 * @param sql        执行的sql
	 * @param resultType 返回的结果类型
	 * @param <T>        泛型类型
	 * @return
	 */
	public static <T> List<T> selectList(String sql, Class<T> resultType) {
		String msId;
		if (resultType == null) {
			msId = msUtils.select(sql);
		} else {
			msId = msUtils.select(sql, resultType);
		}
		return getSqlSessionTemplate().selectList(msId);
	}

	/**
	 * 查询返回指定的结果类型
	 *
	 * @param sql        执行的sql
	 * @param value      参数
	 * @param resultType 返回的结果类型
	 * @param <T>        泛型类型
	 * @return
	 */
	public static <T> List<T> selectList(String sql, Object value, Class<T> resultType) {
		String msId;
		Class<?> parameterType = value != null ? value.getClass() : null;
		if (resultType == null) {
			msId = msUtils.selectDynamic(sql, parameterType);
		} else {
			msId = msUtils.selectDynamic(sql, parameterType, resultType);
		}
		return getSqlSessionTemplate().selectList(msId, value);
	}

	/**
	 * 插入数据
	 *
	 * @param sql 执行的sql
	 * @return
	 */
	public static int insert(String sql) {
		String msId = msUtils.insert(sql);
		return getSqlSessionTemplate().insert(msId);
	}

	/**
	 * 插入数据
	 *
	 * @param sql   执行的sql
	 * @param value 参数
	 * @return
	 */
	public static int insert(String sql, Object value) {
		Class<?> parameterType = value != null ? value.getClass() : null;
		String msId = msUtils.insertDynamic(sql, parameterType);
		return getSqlSessionTemplate().insert(msId, value);
	}

	/**
	 * 更新数据
	 *
	 * @param sql 执行的sql
	 * @return
	 */
	public static int update(String sql) {
		String msId = msUtils.update(sql);
		return getSqlSessionTemplate().update(msId);
	}

	/**
	 * 更新数据
	 *
	 * @param sql   执行的sql
	 * @param value 参数
	 * @return
	 */
	public static int update(String sql, Object value) {
		Class<?> parameterType = value != null ? value.getClass() : null;
		String msId = msUtils.updateDynamic(sql, parameterType);
		return getSqlSessionTemplate().update(msId, value);
	}

	/**
	 * 删除数据
	 *
	 * @param sql 执行的sql
	 * @return
	 */
	public static int delete(String sql) {
		String msId = msUtils.delete(sql);
		return getSqlSessionTemplate().delete(msId);
	}

	/**
	 * 删除数据
	 *
	 * @param sql   执行的sql
	 * @param value 参数
	 * @return
	 */
	public static int delete(String sql, Object value) {
		Class<?> parameterType = value != null ? value.getClass() : null;
		String msId = msUtils.deleteDynamic(sql, parameterType);
		return getSqlSessionTemplate().delete(msId, value);
	}

	private static class MSUtils {
		private Configuration configuration;
		private LanguageDriver languageDriver;

		@SuppressWarnings("deprecation")
		private MSUtils(Configuration configuration) {
			this.configuration = configuration;
			languageDriver = configuration.getDefaultScriptingLanuageInstance();
		}

		/**
		 * 创建MSID
		 *
		 * @param sql 执行的sql
		 * @param sql 执行的sqlCommandType
		 * @return
		 */
		private String newMsId(String sql, SqlCommandType sqlCommandType) {
			StringBuilder msIdBuilder = new StringBuilder(sqlCommandType.toString());
			msIdBuilder.append(".").append(sql.hashCode());
			return msIdBuilder.toString();
		}

		/**
		 * 是否已经存在该ID
		 *
		 * @param msId
		 * @return
		 */
		private boolean hasMappedStatement(String msId) {
			return configuration.hasStatement(msId, false);
		}

		/**
		 * 创建一个查询的MS
		 *
		 * @param msId
		 * @param sqlSource  执行的sqlSource
		 * @param resultType 返回的结果类型
		 */
		private void newSelectMappedStatement(String msId, SqlSource sqlSource, final Class<?> resultType) {
			MappedStatement ms = new MappedStatement.Builder(configuration, msId, sqlSource, SqlCommandType.SELECT).resultMaps(new ArrayList<ResultMap>() {
				 
				private static final long serialVersionUID = 1L;

				{
					add(new ResultMap.Builder(configuration, "defaultResultMap", resultType, new ArrayList<ResultMapping>(0)).build());
				}
			}).build();
			// 缓存
			configuration.addMappedStatement(ms);
		}

		/**
		 * 创建一个简单的MS
		 *
		 * @param msId
		 * @param sqlSource      执行的sqlSource
		 * @param sqlCommandType 执行的sqlCommandType
		 */
		private void newUpdateMappedStatement(String msId, SqlSource sqlSource, SqlCommandType sqlCommandType) {
			MappedStatement ms = new MappedStatement.Builder(configuration, msId, sqlSource, sqlCommandType).resultMaps(new ArrayList<ResultMap>() {
				 
				private static final long serialVersionUID = -6826732493856128447L;

				{
					add(new ResultMap.Builder(configuration, "defaultResultMap", int.class, new ArrayList<ResultMapping>(0)).build());
				}
			}).build();
			// 缓存
			configuration.addMappedStatement(ms);
		}

		private String select(String sql) {
			String msId = newMsId(sql, SqlCommandType.SELECT);
			if (hasMappedStatement(msId)) {
				return msId;
			}
			StaticSqlSource sqlSource = new StaticSqlSource(configuration, sql);
			newSelectMappedStatement(msId, sqlSource, Map.class);
			return msId;
		}

		private String selectDynamic(String sql, Class<?> parameterType) {
			String msId = newMsId(sql + parameterType, SqlCommandType.SELECT);
			if (hasMappedStatement(msId)) {
				return msId;
			}
			SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, parameterType);
			newSelectMappedStatement(msId, sqlSource, Map.class);
			return msId;
		}

		private String select(String sql, Class<?> resultType) {
			String msId = newMsId(resultType + sql, SqlCommandType.SELECT);
			if (hasMappedStatement(msId)) {
				return msId;
			}
			StaticSqlSource sqlSource = new StaticSqlSource(configuration, sql);
			newSelectMappedStatement(msId, sqlSource, resultType);
			return msId;
		}

		private String selectDynamic(String sql, Class<?> parameterType, Class<?> resultType) {
			String msId = newMsId(resultType + sql + parameterType, SqlCommandType.SELECT);
			if (hasMappedStatement(msId)) {
				return msId;
			}
			SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, parameterType);
			newSelectMappedStatement(msId, sqlSource, resultType);
			return msId;
		}

		private String insert(String sql) {
			String msId = newMsId(sql, SqlCommandType.INSERT);
			if (hasMappedStatement(msId)) {
				return msId;
			}
			StaticSqlSource sqlSource = new StaticSqlSource(configuration, sql);
			newUpdateMappedStatement(msId, sqlSource, SqlCommandType.INSERT);
			return msId;
		}

		private String insertDynamic(String sql, Class<?> parameterType) {
			String msId = newMsId(sql + parameterType, SqlCommandType.INSERT);
			if (hasMappedStatement(msId)) {
				return msId;
			}
			SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, parameterType);
			newUpdateMappedStatement(msId, sqlSource, SqlCommandType.INSERT);
			return msId;
		}

		private String update(String sql) {
			String msId = newMsId(sql, SqlCommandType.UPDATE);
			if (hasMappedStatement(msId)) {
				return msId;
			}
			StaticSqlSource sqlSource = new StaticSqlSource(configuration, sql);
			newUpdateMappedStatement(msId, sqlSource, SqlCommandType.UPDATE);
			return msId;
		}

		private String updateDynamic(String sql, Class<?> parameterType) {
			String msId = newMsId(sql + parameterType, SqlCommandType.UPDATE);
			if (hasMappedStatement(msId)) {
				return msId;
			}
			SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, parameterType);
			newUpdateMappedStatement(msId, sqlSource, SqlCommandType.UPDATE);
			return msId;
		}

		private String delete(String sql) {
			String msId = newMsId(sql, SqlCommandType.DELETE);
			if (hasMappedStatement(msId)) {
				return msId;
			}
			StaticSqlSource sqlSource = new StaticSqlSource(configuration, sql);
			newUpdateMappedStatement(msId, sqlSource, SqlCommandType.DELETE);
			return msId;
		}

		private String deleteDynamic(String sql, Class<?> parameterType) {
			String msId = newMsId(sql + parameterType, SqlCommandType.DELETE);
			if (hasMappedStatement(msId)) {
				return msId;
			}
			SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, parameterType);
			newUpdateMappedStatement(msId, sqlSource, SqlCommandType.DELETE);
			return msId;
		}
	}

}
