package cn.ism.fw.simba.web.support.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ism.fw.simba.base.IUser;
import cn.ism.fw.simba.util.MimeUtil;

public class SSOUtil {

  public static final String LOCAL_SESSION_USER_KEY = "LOCAL_SESSION_USER_KEY";
  
  private static final String SSO_URL = "http://localhost:8091/webapp/web/page/login.html";

  /**
   * 
   * @return
   * @since 2017年9月17日
   * @author Administrator
   */
  public static IUser getCurrentUser(HttpServletRequest req) {
    HttpSession session = req.getSession();
    if (session != null) {
      return (IUser) session.getAttribute(LOCAL_SESSION_USER_KEY);
    }
    return null;
  }

  /**
   * 跳转到登录页面
   * 
   * @since 2017年9月17日
   * @author Administrator
   * @throws IOException
   */
  public static void redirectSignPage(HttpServletRequest req, HttpServletResponse resp) throws IOException { 
    resp.setContentType(MimeUtil.HTML);
    String redirectJS = String.format("location.href = '%s?redirect='+location.href;", SSO_URL); 
    resp.getWriter().write("//<script>"+redirectJS+"</script> \r\n"); 
    resp.getWriter().write(redirectJS); 
  }

  /**
   * 跳转到登录页面
   * 
   * @since 2017年9月17日
   * @author Administrator
   * @throws IOException
   */
  public static void redirectSignPage(HttpServletRequest req, HttpServletResponse resp, String backUrl) throws IOException {
    resp.setContentType(MimeUtil.HTML);
    String redirectJS = String.format("location.href ='%s?redirect='+ '%s';", SSO_URL,backUrl); 
    resp.getWriter().write("//<script>"+redirectJS+"</script> \r\n"); 
    resp.getWriter().write(redirectJS); 
  }

  /**
   * 跳转到登录页面
   * 
   * @since 2017年9月17日
   * @author Administrator
   * @throws IOException
   */
  public static void redirectMiniSignPage(HttpServletRequest req, HttpServletResponse resp) throws IOException { 
    redirectSignPage(req, resp, req.getRequestURL().toString() + "&mini=true");
  }

}
