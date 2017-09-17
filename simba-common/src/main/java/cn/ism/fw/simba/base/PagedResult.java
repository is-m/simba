package cn.ism.fw.simba.base;

import java.util.List;

/**
 * 翻页结果对象
 * 
 * @since 2017年7月22日
 * @author Administrator
 */
public class PagedResult<T> extends BasePOJO {

  private static final long serialVersionUID = 1009300260350690513L;

  /**
   * 翻页属性
   */
  private PageVO page;

  /**
   * 数据结果
   */
  private List<T> result;

  public PageVO getPage() {
    return page;
  }

  public void setPage(PageVO page) {
    this.page = page;
  }

  public List<T> getResult() {
    return result;
  }

  public void setResult(List<T> result) {
    this.result = result;
  }

  public PagedResult() {

  }

  public PagedResult(PageVO page, List<T> result) {
    this.page = page;
    this.result = result;
  }
}
