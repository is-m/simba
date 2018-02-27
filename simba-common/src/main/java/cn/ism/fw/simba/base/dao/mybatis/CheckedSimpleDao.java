package cn.ism.fw.simba.base.dao.mybatis;

import java.util.List;

import org.springframework.util.Assert;

import cn.ism.fw.simba.base.PageVO;
import cn.ism.fw.simba.base.PagedResult;
import cn.ism.fw.simba.base.dao.IBaseDao;

public class CheckedSimpleDao implements IBaseDao {

  private SimpleDao dao;

  private void valid(Object t) {
    Assert.isTrue(t == null || t.getClass().equals(dao.getMeta().getEntityClass()), "类型不匹配"); 
  }

  @Override
  public Object create(Object t) { 
    return dao.create(t);
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
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object getOne(Object k) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public PagedResult getPageData(PageVO page, Object condition) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List getAll(Object condition) {
    // TODO Auto-generated method stub
    return null;
  }

}
