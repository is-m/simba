package cn.ism.fw.simba.specs;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 资源权限注解
 * 通常加在服务类和服务方法上
 * @since 2017年7月22日
 * @author Administrator
 */
@Documented
@Retention(RUNTIME)
@Target({ TYPE })
public @interface SResource {

	/**
	 * 模块/功能
	 * @return
	 * @since 2017年7月22日
	 * @author Administrator
	 */
	String code() default "";

	/**
	 * 模块/功能描述
	 * @return
	 * @since 2017年7月22日
	 * @author Administrator
	 */
	String desc() default "";
}
