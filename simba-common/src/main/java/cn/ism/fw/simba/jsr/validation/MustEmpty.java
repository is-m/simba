package cn.ism.fw.simba.jsr.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import cn.ism.fw.simba.util.ObjectUtil;

/**
 * 必须为空
 * 使用时，在方法 {@code @Validated BindingResult result}
 * spring 校验对象，参考 http://blog.csdn.net/miketom155/article/details/45058195
 * 校验使用规则参考下面连接
 * http://jinnianshilongnian.iteye.com/blog/1990081
 * @since 2017年9月25日
 * @author Administrator
 */
@Inherited
@Constraint(validatedBy = {MustEmpty.MustEmptyValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD,METHOD})
public @interface MustEmpty {

  String message() default "必须为空"; // 约束注解验证时的输出消息

  Class<?>[] groups() default { }; // 约束注解在验证时所属的组别

  Class<? extends Payload>[] payload() default {}; // 约束注解的有效负载


  public class MustEmptyValidator implements ConstraintValidator<MustEmpty, Object> {

    @Override
    public void initialize(MustEmpty constraintAnnotation) {
      System.out.println("MustEmptyValidator.initialize::"+constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) { 
      return ObjectUtil.isEmpty(value);
    }

  }
}
