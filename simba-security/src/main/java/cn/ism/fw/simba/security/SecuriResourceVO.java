package cn.ism.fw.simba.security;

import java.util.List;

import cn.ism.fw.simba.security.util.SecuriConstant;

/**
 * 资源
 * 
 * @since 2017年8月8日
 * @author Administrator
 */
public class SecuriResourceVO extends BaseSecuriVO {

  private static final long serialVersionUID = 7216340276893147737L;

  /**
   * 资源编码
   */
  private String code;

  /**
   * 资源描述
   */
  private String desc;

  /**
   * 资源操作列表
   */
  private List<SecuriOperateVO> operations;

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

  public List<SecuriOperateVO> getOperations() {
    return operations;
  }

  public void setOperations(List<SecuriOperateVO> operations) {
    this.operations = operations;
  }

  @Override
  public String getPermissionCode() {
    return String.format("%s%s", SecuriConstant.PERMISSION_SYS_PIX, getCode());
  }

}
