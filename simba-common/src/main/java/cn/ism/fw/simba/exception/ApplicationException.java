package cn.ism.fw.simba.exception;

public abstract class ApplicationException extends RuntimeException implements IHttpCodeProvider {
 
  private static final long serialVersionUID = -6175227735386851610L;

  @Override
  public String getHttpCode() { 
    return "500";
  }
 
}
