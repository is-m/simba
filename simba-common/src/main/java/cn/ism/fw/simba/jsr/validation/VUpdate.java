package cn.ism.fw.simba.jsr.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.groups.Default;

import org.springframework.validation.annotation.Validated;

import cn.ism.fw.simba.jsr.validation.groups.UpdateGroup;

/**
 * 更新校验
 * 效果同  @Validated({ Default.class, UpdateGroup.class })
 * @since 2017年10月22日
 * @author Administrator
 */
@Validated({ Default.class, UpdateGroup.class })
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface VUpdate {

}
