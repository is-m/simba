package cn.ism.fw.simba.sitemap;

import java.util.List;

/**
 * 栏目树
 * @since 2017年9月20日
 * @author Administrator
 */
public class CatelogTreeVO extends CatelogVO { 
  
  /**
   * @author Administrator
   */
  private static final long serialVersionUID = -1340833296393907160L;

  private CatelogTreeVO parent;
  
  private List<CatelogTreeVO> children;

  public CatelogTreeVO getParent() {
    return parent;
  }

  public void setParent(CatelogTreeVO parent) {
    this.parent = parent;
  }

  public List<CatelogTreeVO> getChildren() {
    return children;
  }

  public void setChildren(List<CatelogTreeVO> children) {
    this.children = children;
  } 
  
}
