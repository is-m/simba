package cn.ism.fw.simba.context;

/**
 * 系统用户信息
 * 
 * @since 2017年9月25日
 * @author Administrator
 */
public interface UserPrincipal {

  /**
   * 获取用户ID
   * @return
   * @since 2017年10月15日
   * @author Administrator
   */
  public String getId();

  /**
   * 获取用户名
   * @return
   * @since 2017年10月15日
   * @author Administrator
   */
  public String getUsername();

}
