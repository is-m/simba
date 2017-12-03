package cn.ism.fw.simba.jsr.validation.reader;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

import org.springframework.util.ReflectionUtils;

import cn.ism.fw.simba.util.SpringUtil;

/**
 * 扫描注解相关的类
 * @since 2017年11月28日
 * @author Administrator
 */
public class ValidationFinder {

  public Map<String,Object> get(){
    Collection<Object> allBeans = SpringUtil.getAllBeans();
    
    allBeans.stream().forEach(bean -> {
      Method[] allDeclaredMethods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
      for(Method method : allDeclaredMethods) { 
        method.getParameterAnnotations();
      }
      
      
    });
    
    return null;
  }

}
