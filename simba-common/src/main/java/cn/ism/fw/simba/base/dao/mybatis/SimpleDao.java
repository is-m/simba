package cn.ism.fw.simba.base.dao.mybatis;

import java.util.List;

import cn.ism.fw.simba.base.PageVO;
import cn.ism.fw.simba.base.PagedResult;
import cn.ism.fw.simba.base.dao.EntityMeta;
import cn.ism.fw.simba.base.dao.IBaseDao;
import cn.ism.fw.simba.orm.mybatis.util.SqlHelper;
import cn.ism.fw.simba.util.StringUtil;

public class SimpleDao implements IBaseDao<Object, Object> {
  
  private EntityMeta meta; 

  public EntityMeta getMeta() {
    return meta;
  } 

  public SimpleDao(Class<?> entityClass) {  
    meta = EntityMeta.read(entityClass);
  }

  @Override
  public Object create(Object t) { 
    return null;
  }

  @Override
  public int delete(Object k) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Object update(Object t) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object save(Object t) { 
    return null;
  }

  @Override
  public Object getOne(Object k) {
    String findByIdSql = StringUtil.format("select * from {0} where {1}='{2}'", meta.getTableName(),meta.getIdField(),k);
    return SqlHelper.selectOne(findByIdSql, meta.getEntityClass());
  }

  @Override
  public PagedResult<Object> getPageData(PageVO page, Object condition) {  
    String baseSql = StringUtil.format("select * from {0}", meta.getTableName());
    
    String totalSql = StringUtil.format("select count(*) from ({0}) t",baseSql);
    int total = SqlHelper.selectOne(totalSql, Integer.class);
    page.setTotalRecord(total);
    
    String pagedSql = StringUtil.format("select * from ({0}) t limit {1},{2}", baseSql,page.getPageStartIndex()-1,page.getPageEndIndex());
    @SuppressWarnings("unchecked")
    List<Object> data = (List<Object>) SqlHelper.selectList(pagedSql,meta.getEntityClass());
    
    return new PagedResult<>(page,data);
  }

  @Override
  public List getAll(Object condition) {
    String baseSql = StringUtil.format("select * from {0}", meta.getTableName());
    return SqlHelper.selectList(baseSql,meta.getEntityClass());
  }

}
