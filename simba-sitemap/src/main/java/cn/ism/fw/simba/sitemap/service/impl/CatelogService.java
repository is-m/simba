package cn.ism.fw.simba.sitemap.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import cn.ism.fw.simba.base.TreeVO;
import cn.ism.fw.simba.base.TreeVO.TreeNodeVO;
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
  public List<CatelogVO> findTreeList(CatelogVO catelogVO) { 
    // TODO:待修改为查询一次后在内存中构造树对象，在树对象里匹配到数据后返回给界面 
     List<CatelogVO> findTreeList = catelogDao.findTreeList(catelogVO); 
     try {
      TreeVO<CatelogVO> treeVO = new TreeVO<>(findTreeList, "id", "parentId", "0");
      System.out.println("---:"+treeVO.getNodes().size());
    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) { 
      e.printStackTrace();
    }
     return findTreeList;
  }

  @Override
  public CatelogVO findById(Serializable id) { 
    return catelogDao.findById(id);
  } 

}
