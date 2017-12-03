package cn.ism.fw.simba.sitemap.dao;

import java.io.Serializable;
import java.util.List;

import cn.ism.fw.simba.sitemap.CatelogVO;

public interface ICatelogDao {

  int createObj(CatelogVO vo);

  /**
   * 获取树列表
   * @return
   * @since 2017年10月30日
   * @author Administrator
   */
  List<CatelogVO> findTreeList(CatelogVO catelogVO);

  /**
   * 根据ID查询
   * @param id
   * @return
   * @since 2017年11月6日
   * @author Administrator
   */
  CatelogVO findById(Serializable id); 

  
}
