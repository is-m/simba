package cn.ism.fw.simba.sitemap;

import java.io.Serializable;

public class TestVO implements Serializable {

  private static final long serialVersionUID = -3707760265780283682L;
  
  private String id;
  
  /**
   * 测试字段
   */
  private String testField;

  public String getTestField() {
    return testField;
  }

  public void setTestField(String testField) {
    this.testField = testField;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }



}
