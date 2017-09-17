package cn.ism.fw.simba.base;

public class PageQueryVO<T> extends PageVO {

  private static final long serialVersionUID = -1315440363957720637L;
  
  private T queryVO;

  public T getQueryVO() {
    return queryVO;
  }

  public void setQueryVO(T queryVO) {
    this.queryVO = queryVO;
  }

}
