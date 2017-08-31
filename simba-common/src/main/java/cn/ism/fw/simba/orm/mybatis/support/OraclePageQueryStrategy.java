package cn.ism.fw.simba.orm.mybatis.support;

import javax.inject.Named;

import cn.ism.fw.simba.base.PageVO;
import cn.ism.fw.simba.orm.mybatis.PageQueryStrategy;
import cn.ism.fw.simba.util.StringUtil;

@Named
public class OraclePageQueryStrategy implements PageQueryStrategy {

	@Override
	public String getPagedSql(PageVO page, String sourceSql) {  
	    int start = page.getPageStartIndex();
	    int end = start + page.getPageSize();
		return StringUtil.concat("select * from ( select u.*, rownum rn from (",sourceSql,") u where rownum < ",end,") where u.rn >= ",start);
	}

}
