package cn.ism.fw.simba.util;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class SpringUtil implements ApplicationContextAware, EnvironmentAware {

  private static ApplicationContext ac;

  private static Environment env;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    ac = applicationContext;
  }

  @Override
  public void setEnvironment(Environment environment) {
    env = environment;
  }

  public static ApplicationContext getContext() {
    return ac;
  }

  public static final Environment getEnvironment() {
    return env;
  }
  
  public static void autowireBean(Object bean) {
    ac.getAutowireCapableBeanFactory().autowireBean(bean);
  }

  public static <T> T getBean(Class<T> t) {
    return (T) ac.getBean(t);
  }
  
  public static <T> T getBean(Class<T> t, String name) {
    return (T) ac.getBean(t, name);
  }
  

  public static <T> Map<String, T> getBeansOfType(Class<T> t) {
    return (Map<String, T>) ac.getBeansOfType(t);
  }
  
  public static Collection<Object> getAllBeans() {
    return ac.getBeansOfType(Object.class).values();
  }

  public static <T> T getBeanOfLikeName(Class<T> t, String name) {
    Map<String, T> beanMap = getBeansOfType(t);
    for (Map.Entry<String, T> item : beanMap.entrySet()) {
      if (StringUtil.equals(item.getKey(), name, true)) {
        return item.getValue();
      }
    }
    return null;
  }

  public static String getProperty(String key) {
    return env.getProperty(key);
  }

  public static String getProperty(String key, String defaultValue) {
    return env == null ? defaultValue : env.getProperty(key, defaultValue);
  }
  
  public static String getRequiredProperty(String key) {
    return env.getRequiredProperty(key);
  }

  public static String resolvePlaceholders(String text) {
    return env.resolvePlaceholders(text);
  }

}
