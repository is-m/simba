package cn.ism.fw.simba.security.service;

import cn.ism.fw.simba.security.UserVO;

public interface ILoginService {

  /**
   * 用户登录
   * 
   * @param username 用户名
   * @param password 密码
   * @return
   * @since 2017年9月26日
   * @author Administrator
   */
  public UserVO login(String username, String password);
 
}
