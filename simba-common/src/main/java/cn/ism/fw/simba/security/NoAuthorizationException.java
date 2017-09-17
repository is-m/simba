package cn.ism.fw.simba.security;

import cn.ism.fw.simba.exception.ApplicationException;

public class NoAuthorizationException extends ApplicationException {
 
  private static final long serialVersionUID = 3128461543420825362L;

  @Override
  public String getHttpCode() {
    return "403";
  }
}
