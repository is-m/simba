package cn.ism.fw.simba.specs;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.TYPE_PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import cn.ism.fw.simba.specs.support.IAttributeCheckProvider;

/**
 * 属性权限注解
 * 
 * @since 2017年7月22日
 * @author Administrator
 */
@Documented
@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE, TYPE_PARAMETER })
public @interface SAttribute {

	/**
	 * 属性类型
	 * 
	 * @return
	 * @since 2017年7月22日
	 * @author Administrator
	 */
	String type() default "";

	/**
	 * 属性名
	 * 
	 * @return
	 * @since 2017年7月22日
	 * @author Administrator
	 */
	String attribute();

	/**
	 * 关键属性 取值表达式，用于提供给数据权限检查程序检查用途
	 * 
	 * @return
	 * @since 2017年7月22日
	 * @author Administrator
	 */
	String key() default "";

	/**
	 * 权限检查提供程序实现类 如果系统只有一个实现类时无需指定，如果存在多个实现类时，必须指定为具体的权限提供程序
	 * 
	 * @return
	 * @since 2017年7月22日
	 * @author Administrator
	 */
	Class<? extends IAttributeCheckProvider> provider() default IAttributeCheckProvider.class;
}
