package cn.ism.fw.simba.sitemap.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import cn.ism.fw.simba.security.SecureOperation;
import cn.ism.fw.simba.security.SecureResource;
import cn.ism.fw.simba.sitemap.CatelogVO;
import cn.ism.fw.simba.sitemap.dao.ICatelogDao;
import cn.ism.fw.simba.sitemap.service.ICatelogService;

@Named
@SecureResource(code = "sys.catelog", desc = "系统管理->栏目管理")
public class CatelogService implements ICatelogService {

  @Inject
  private ICatelogDao catelogDao;

  @SecureOperation(code = "", desc = "")
  @Override
  public List<CatelogVO> findList() {
    return null;
  }

  @Override
  public int createObj(CatelogVO vo) {
    return catelogDao.createObj(vo);
  }

  @Override
  public List<CatelogVO> findTreeList() { 
    return catelogDao.findTreeList();
  } 

}
