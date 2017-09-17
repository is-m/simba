package cn.ism.fw.simba.security.util;

public class SecuriConstant {

  /**
   * 权限分隔符
   */
  public static final String SPLITTER = "::";

  /**
   * 未知的资源
   */
  public static final String NO_RESOURCE = "UNKNOW_RESOURCE";

  /**
   * 创建类型：系统
   */
  public static final String CREATE_TYPE_SYS = "SYS";

  /**
   * 创建类型：用户
   */
  public static final String CREATE_TYPE_USR = "USR";

  /**
   * 权限节点前缀
   */
  public static final String PERMISSION_SYS_PIX = CREATE_TYPE_SYS + SPLITTER;

  /**
   * 无资源权限节点前缀
   */
  public static final String PERMISSION_SYS_NR_PIX = PERMISSION_SYS_PIX + NO_RESOURCE + SPLITTER;

}
