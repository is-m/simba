package cn.ism.fw.simba.sitemap.dao;

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
  List<CatelogVO> findTreeList();

  
}
