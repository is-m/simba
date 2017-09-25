package cn.ism.fw.simba.security.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.ism.fw.simba.context.UserPrincipal;

public class LoginUtil {

  public static final String LOCAL_LOGIN_USER = "LOCAL_SESSION_USER_KEY";
  
  public static UserPrincipal getCurrentUser(HttpServletRequest request) { 
    HttpSession session = request.getSession(false); 
    return session == null ? null : (UserPrincipal) session.getAttribute(LOCAL_LOGIN_USER);
  }
}
