package cn.ism.fw.simba.security;

import cn.ism.fw.simba.security.util.SecuriConstant;

/**
 * 操作
 * 
 * @since 2017年8月8日
 * @author Administrator
 */
public class SecuriOperateVO extends BaseSecuriVO {

  private static final long serialVersionUID = -6779821528432505575L;

  /**
   * 操作编码
   */
  private String code;

  /**
   * 操作描述
   */
  private String desc;

  /**
   * 资源操作列表
   */
  private SecuriResourceVO resourceVO;

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

  public SecuriResourceVO getResourceVO() {
    return resourceVO;
  }

  /**
   * 设置该类参数时，请使用浅拷贝副本对象，防止后续转JSON的时候出现死循环
   * @param resourceVO
   * @since 2017年9月5日
   * @author Administrator
   */
  public void setResourceVO(SecuriResourceVO resourceVO) { 
    this.resourceVO = resourceVO;
  }

  @Override
  public String getPermissionCode() {
    if (resourceVO == null) {
      return String.format("%s%s", SecuriConstant.PERMISSION_SYS_NR_PIX, code);
    }
    return String.format("%s%s%s", resourceVO.getPermissionCode(), SecuriConstant.SPLITTER, code);
  }


}
