package cn.ism.fw.simba.jsr.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.SOURCE;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import javax.validation.groups.Default;

import cn.ism.fw.simba.util.ObjectUtil;

/**
 * 必须为空
 * 使用时，在方法 {@code @Validated BindingResult result}
 * spring 校验对象，参考 http://blog.csdn.net/miketom155/article/details/45058195
 * @since 2017年9月25日
 * @author Administrator
 */
@Constraint(validatedBy = {MustEmpty.MustEmptyValidator.class})
@Retention(SOURCE)
@Target({FIELD,METHOD})
public @interface MustEmpty {

  String message() default "必须为空"; // 约束注解验证时的输出消息

  Class<?>[] groups() default {Default.class}; // 约束注解在验证时所属的组别

  Class<? extends Payload>[] payload() default {}; // 约束注解的有效负载


  public class MustEmptyValidator implements ConstraintValidator<MustEmpty, Object> {

    @Override
    public void initialize(MustEmpty constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
      return ObjectUtil.isEmpty(value);
    }

  }
}
