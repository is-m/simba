package cn.ism.fw.simba.base.service;

import java.lang.reflect.Method;

import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import cn.ism.fw.simba.util.SpringUtil;

public class ServiceEntityProcessor {
/*
  public static void test() {
    RequestMappingHandlerMapping requestMappingHandlerMapping=SpringUtil.getBean(RequestMappingHandlerMapping.class);
 
    Method getMappingForMethod =ReflectionUtils.findMethod(RequestMappingHandlerMapping.class, "getMappingForMethod",Method.class,Class.class);
    getMappingForMethod.setAccessible(true);
    
    requestMappingHandlerMapping.
    
    RequestMappingInfo mapping_info = (RequestMappingInfo) getMappingForMethod.invoke(requestMappingHandlerMapping, m_d,entry.getValue());
    requestMappingHandlerMapping.registerMapping(mapping_info, entry.getValue().newInstance(),m_d);


  }*/
}
