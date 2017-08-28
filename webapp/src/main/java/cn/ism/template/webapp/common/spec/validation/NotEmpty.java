package cn.ism.template.webapp.common.spec.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import cn.ism.template.webapp.common.spec.Order;
import cn.ism.template.webapp.common.spec.OrderPriority;

@Retention(RUNTIME)
@Target(FIELD)
@Order(OrderPriority.Hight)
@Constraint(validatedBy={})
public @interface NotEmpty {

	String message() default "not empty";
	 
}
