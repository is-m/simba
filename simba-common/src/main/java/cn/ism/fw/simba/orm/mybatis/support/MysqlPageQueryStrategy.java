package cn.ism.fw.simba.orm.mybatis.support;

import javax.inject.Named;

import cn.ism.fw.simba.base.PageVO;
import cn.ism.fw.simba.orm.mybatis.PageQueryStrategy;
import cn.ism.fw.simba.util.StringUtil;

@Named
public class MysqlPageQueryStrategy implements PageQueryStrategy {

	@Override
	public String getPagedSql(PageVO page,String sourceSql) { 
		int start = page.getPageStartIndex() - 1;
        return StringUtil.concat(sourceSql," limit ",start,",",page.getPageSize());  
	}

}
