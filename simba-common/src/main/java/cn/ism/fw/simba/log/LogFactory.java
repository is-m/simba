package cn.ism.fw.simba.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFactory {
  /**
   * 获取日志对象
   * @return
   * @since 2018年1月21日
   * @author Administrator
   */
  public static Logger getLogger() {
    try {
      Throwable throwable = new Throwable();
      StackTraceElement[] stackTrace = throwable.getStackTrace();
      String className = stackTrace[1].getClassName();
      return LoggerFactory.getLogger(Class.forName(className));
    } catch (Exception e) {
      throw new RuntimeException("获取日志对象异常", e);
    }
  }
}
