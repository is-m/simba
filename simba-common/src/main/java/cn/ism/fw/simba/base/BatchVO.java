package cn.ism.fw.simba.base;

import java.util.List;

import cn.ism.fw.simba.util.JSONUtil;

/**
 * 批处理类
 * 
 * @since 2017年7月22日
 * @author Administrator
 */
public class BatchVO<T> extends BasePOJO {

  private static final long serialVersionUID = -6398292990242372232L;

  /**
   * 主记录ID
   */
  private String mainId;

  /**
   * 待删除列表
   */
  private List<T> delObjects;

  /**
   * 待添加列表
   */
  private List<T> addObjects;

  /**
   * 带更新类别
   */
  private List<T> updObjects;

  public String getMainId() {
    return mainId;
  }

  public void setMainId(String mainId) {
    this.mainId = mainId;
  }

  public List<T> getDelObjects() {
    return delObjects;
  }

  public void setDelObjects(List<T> delObjects) {
    this.delObjects = delObjects;
  }

  public List<T> getAddObjects() {
    return addObjects;
  }

  public void setAddObjects(List<T> addObjects) {
    this.addObjects = addObjects;
  }

  public List<T> getUpdObjects() {
    return updObjects;
  }

  public void setUpdObjects(List<T> updObjects) {
    this.updObjects = updObjects;
  }

  @Override
  public String toString() {
    return JSONUtil.toJSON(this);
  }
}
