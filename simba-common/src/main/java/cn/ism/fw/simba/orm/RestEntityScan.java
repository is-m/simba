package cn.ism.fw.simba.orm;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.SOURCE;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * RestEntityScanner
 * @since 2018年1月16日
 * @author Administrator
 */
@Retention(SOURCE)
@Target(TYPE)
public @interface RestEntityScan {
  
  /**
   * 扫描的包路径，为空时扫描当前目录下所有子目录
   * @return
   * @since 2018年1月16日
   * @author Administrator
   */
  String value() default "";
  
  /**
   * 指定多个包路径
   * @return
   * @since 2018年1月16日
   * @author Administrator
   */
  String[] basePackages();
}
