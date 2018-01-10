package cn.ism.fw.simba.base.dao.mybatis;

import java.util.List;

import javax.persistence.Table;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.core.ResolvableType;

import cn.ism.fw.simba.base.PageVO;
import cn.ism.fw.simba.base.PagedResult;

public abstract class SqlBuilder<T,K> {
  private Table $table;
  
  public SqlBuilder() {
    $table = this.getClass().getDeclaredAnnotation(Table.class);
    if($table == null) {
      ResolvableType resolvableType1 = ResolvableType.forClass(this.getClass());  
      resolvableType1.as(SqlBuilder.class).getGeneric(0);
    }
  }
  
  /**
   * 创建对象
   * @param t
   * @return
   * @since 2017年12月24日
   * @author Administrator
   */
  public String create(T t) {
    return new SQL() {{
      INSERT_INTO("");
    }}.toString();
  }

  /**
   * 删除对象
   * @param t
   * @return
   * @since 2017年12月24日
   * @author Administrator
   */
  public abstract int delete(K k);

  /**
   * 更新对象
   * @param t
   * @return
   * @since 2017年12月24日
   * @author Administrator
   */
  public abstract T update(T t);

  /**
   * 保存对象，不存在创建，存在更新
   * @param t
   * @return
   * @since 2017年12月24日
   * @author Administrator
   */
  public abstract T save(T t);

  /**
   * 根据主键获取
   * @param k
   * @since 2017年12月24日
   * @author Administrator
   */
  public abstract T getOne(K k);

  /**
   * 按条件分页查询
   * @param page
   * @param condition
   * @return
   * @since 2017年12月24日
   * @author Administrator
   */
  public abstract PagedResult<T> getPageData(PageVO page, T condition);

  /**
   * 按条件查询所有
   * @param condition
   * @return
   * @since 2017年12月24日
   * @author Administrator
   */
  public abstract List<T> getAll(T condition);
}
