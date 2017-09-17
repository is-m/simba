package cn.ism.fw.simba.security;

import cn.ism.fw.simba.exception.ApplicationException;

public class NoAuthenticationException extends ApplicationException {
 
  private static final long serialVersionUID = -4676095920075476509L;

  @Override
  public String getHttpCode() {
    return "401";
  }
}
