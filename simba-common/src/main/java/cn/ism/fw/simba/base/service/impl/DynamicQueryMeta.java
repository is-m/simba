package cn.ism.fw.simba.base.service.impl;

import java.util.HashMap;
import java.util.Map;

import cn.ism.fw.simba.base.PageVO;
import cn.ism.fw.simba.util.ObjectUtil;

/**
 * 动态查询源
 * 
 * 查询列表时，最大只允许返回两百条，超过的请报错，并提示外部调用接口的程序调用分页查询接口，
 * @since 2018年2月10日
 * @author Administrator
 */
public class DynamicQueryMeta extends DynamicMeta {

  /**
   * 过滤条件
   */
  private Map<String, Object> filters= new HashMap<>();

  /**
   * 分页参数
   */
  private PageVO page ;

  /**
   * 排序参数
   */
  private Map<String, String> sort = new HashMap<>();

  /**
   * 关系查询
   */
  private DynamicMeta relationShip;

  /**
   * 需要包含的子属性（关联查询）
   */
  private String[] includes;

  /**
   * 需要哪些字段
   */
  private String[] fields; 
  
  private QueryType queryType;
  
  public Map<String, Object> getFilters() {
    return filters;
  }

  public void setFilters(Map<String, Object> filters) {
    this.filters = filters;
  } 

  public PageVO getPage() {
    return page;
  }

  public void setPage(PageVO page) {
    this.page = page;
  } 

  public Map<String, String> getSort() {
    return sort;
  }

  public void setSort(Map<String, String> sort) {
    this.sort = sort;
  }

  public String[] getFields() {
    return fields;
  }

  public void setFields(String[] fields) {
    this.fields = fields;
  }

  public DynamicMeta getRelationShip() {
    return relationShip;
  }

  public void setRelationShip(DynamicMeta relationShip) {
    this.relationShip = relationShip;
  }

  public String[] getIncludes() {
    return includes;
  }

  public void setIncludes(String[] includes) {
    this.includes = includes;
  }  
  
  public void setQueryType(QueryType queryType) {
    this.queryType = queryType;
  }

  public QueryType getQueryType() {
    return ObjectUtil.nvl(queryType, QueryType.PageList);
  }  
  
  public static enum QueryType {
    /**
     * 详情，
     */
    Detail,
    /**
     * 查询列表
     */
    List,
    /**
     * 分页列表
     */
    PageList
  }
  
  
}
