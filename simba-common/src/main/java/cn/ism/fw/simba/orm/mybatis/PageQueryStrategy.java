package cn.ism.fw.simba.orm.mybatis;

import cn.ism.fw.simba.base.PageVO;

public interface PageQueryStrategy {

	/**
	 * 获取翻页后的SQL
	 * @param sourceSql
	 * @return
	 */
	public String getPagedSql(PageVO page,String sourceSql);
}
