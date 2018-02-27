package cn.ism.fw.simba.base.service;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Restful 实体，标注了该注解的实体类默认实现标准的Rest增删改查RestApi
 * @since 2018年1月16日
 * @author Administrator
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(TYPE)
public @interface ServiceEntity {

  String value() default "";
  
  String name() default "";
  
  RestOperate operate() default RestOperate.CRUD ; 
  
  public enum RestOperate {
    /**
     * 增删改查
     */
    CRUD,
    /**
     * 增删改
     */
    CUD,
    /**
     * 查
     */
    R
  }
}
