package cn.ism.fw.simba.base.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import cn.ism.fw.simba.log.LogFactory;
import cn.ism.fw.simba.util.SpringUtil;

/**
 * 服务实体注册类
 * 用于动态注册服务实体
 * 需要使用@Import({ServiceEntityRegister.class})导入该类
 * @since 2018年1月21日
 * @author Administrator
 */
public class ServiceEntityRegister implements ResourceLoaderAware {

  private static final Logger LOG = LogFactory.getLogger();
  private ResourceLoader resourceLoader;

  @Override
  public void setResourceLoader(ResourceLoader resourceLoader) {
    this.resourceLoader = resourceLoader;
  }


  public void registerMapping() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    RequestMappingHandlerMapping requestMappingHandlerMapping = SpringUtil.getBean(RequestMappingHandlerMapping.class);

    Method getMappingForMethod = ReflectionUtils.findMethod(RequestMappingHandlerMapping.class, "getMappingForMethod", Method.class, Class.class);
    getMappingForMethod.setAccessible(true);
    Class<?> serviceClass = DynamicRestDispacherService.class;
    RequestMapping classMapping = serviceClass.getAnnotation(RequestMapping.class);
    if (classMapping != null) {
      LOG.info("dynamic register mapping init");
      String classPath = classMapping.path()[0];

      Method[] methods = serviceClass.getMethods();
      for (int i = 0; i < methods.length; i++) {
        RequestMapping mapping = methods[i].getAnnotation(RequestMapping.class);
        if (mapping != null) {
          LOG.info("dynamic register mapping for path {} ", classPath, mapping.path());
          RequestMappingInfo requestMappingInfo =
              (RequestMappingInfo) getMappingForMethod.invoke(requestMappingHandlerMapping, methods[i], serviceClass);
          requestMappingHandlerMapping.registerMapping(requestMappingInfo, SpringUtil.getBean(DynamicRestDispacherService.class), methods[i]);
        }

      }
    }



  }
}
