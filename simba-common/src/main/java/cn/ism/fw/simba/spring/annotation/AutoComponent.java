package cn.ism.fw.simba.spring.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * 自动组件
 * @author Administrator
 *
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Component
public @interface AutoComponent {

}
