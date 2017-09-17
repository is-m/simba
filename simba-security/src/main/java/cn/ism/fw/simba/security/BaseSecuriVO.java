package cn.ism.fw.simba.security;

import cn.ism.fw.simba.base.BasePOJO;

/**
 * 安全基础对象
 * @since 2017年9月5日
 * @author Administrator
 */
public abstract class BaseSecuriVO extends BasePOJO {
 
  private static final long serialVersionUID = -4370017162181584449L;
 
  /**
   * 操作编码
   */
  private String code;
  
  /**
   * 操作描述
   */
  private String desc;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
  
  /**
   * 获取权限代码
   * @return
   * @since 2017年9月5日
   * @author Administrator
   */
  public abstract String getPermissionCode();
}
