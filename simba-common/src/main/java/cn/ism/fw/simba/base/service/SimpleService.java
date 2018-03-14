package cn.ism.fw.simba.base.service;

import java.util.List;

import cn.ism.fw.simba.base.PageVO;
import cn.ism.fw.simba.base.PagedResult;
import cn.ism.fw.simba.base.dao.IBaseDao;
import cn.ism.fw.simba.base.dao.mybatis.SimpleDao;
import cn.ism.fw.simba.base.service.impl.ResourceEntry;

@SuppressWarnings("rawtypes")
public class SimpleService implements IBaseService {

  private ResourceEntry entry;

  private IBaseDao simpleDao;  
  
  public SimpleService(ResourceEntry entry) {
    setEntry(entry);
  }

  public ResourceEntry getEntry() {
    return entry;
  }

  public void setEntry(ResourceEntry entry) {
    this.entry = entry;
    if(entry != null) {
      simpleDao = new SimpleDao(entry.getResClass());
    }
  }

  @Override
  public Object create(Object t) {
    return simpleDao.create(t);
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
    return simpleDao.getOne(k);
  }

  @Override
  public PagedResult getPageData(PageVO page, Object condition) {
    return simpleDao.getPageData(page, condition);
  }

  @Override
  public List getAll(Object condition) {
    return simpleDao.getAll(condition);
  }


}
