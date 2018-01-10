package cn.ism.fw.simba.base.dao;

import java.util.List;

import cn.ism.fw.simba.base.PageVO;
import cn.ism.fw.simba.base.PagedResult;

/**
 * 通用dao
 * @since 2017年12月24日
 * @author Administrator
 */
public interface IBaseDao<T,K> {

  /**
   * 创建对象
   * @param t
   * @return
   * @since 2017年12月24日
   * @author Administrator
   */
  public T create(T t);
  
  /**
   * 删除对象
   * @param t
   * @return
   * @since 2017年12月24日
   * @author Administrator
   */
  public int delete(K k);
  
  /**
   * 更新对象
   * @param t
   * @return
   * @since 2017年12月24日
   * @author Administrator
   */
  public T update(T t);
  
  /**
   * 保存对象，不存在创建，存在更新
   * @param t
   * @return
   * @since 2017年12月24日
   * @author Administrator
   */
  public T save(T t);
  
  /**
   * 根据主键获取
   * @param k
   * @since 2017年12月24日
   * @author Administrator
   */
  public T getOne(K k);
  
  /**
   * 按条件分页查询
   * @param page
   * @param condition
   * @return
   * @since 2017年12月24日
   * @author Administrator
   */
  public PagedResult<T> getPageData(PageVO page,T condition);
  
  /**
   * 按条件查询所有
   * @param condition
   * @return
   * @since 2017年12月24日
   * @author Administrator
   */
  public List<T> getAll(T condition);
   
}
