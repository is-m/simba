package cn.ism.fw.simba.security;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 资源权限注解
 * 通常加在服务类和服务方法上，其中安全策略默认为需要检查权限
 * @since 2017年7月22日
 * @author Administrator
 */
@Documented
@Retention(RUNTIME)
@Target({ METHOD })
public @interface SecureOperation {

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

	/**
	 * 安全策略
	 * 在服务类上标注时，可不加policy
	 * @return
	 * @since 2017年7月22日
	 * @author Administrator
	 */
	SecurityPolicy policy() default SecurityPolicy.Required;
}
