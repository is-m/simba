package cn.ism.fw.simba.security.service.impl;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.util.Assert;

import cn.ism.fw.simba.security.UserVO;
import cn.ism.fw.simba.security.service.ILoginService;
import cn.ism.fw.simba.security.service.IUserService;
import cn.ism.fw.simba.util.StringUtil;

/**
 * 登录服务
 * 
 * @since 2017年9月25日
 * @author Administrator
 */
@Named
public class LoginService implements ILoginService {

  @Inject
  private IUserService userService;

  @Override
  public UserVO login(String username, String password) {
    Assert.isTrue(StringUtil.notEmptyAll(username,password),"用户名或密码不能为空"); 
    
    // 获取用户
    UserVO userVO = userService.findUserByName(username); 
    
    // 检查数据
    Assert.notNull(userVO,"用户不存在 "+username);
    Assert.isTrue(Objects.equals(userVO.getPasswd(), password),"用户名和密码不匹配"); 
    userVO.setPasswd(null);
    return userVO;
  } 

}
