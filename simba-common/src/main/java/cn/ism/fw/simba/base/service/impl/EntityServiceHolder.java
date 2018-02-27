package cn.ism.fw.simba.base.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import cn.ism.fw.simba.base.service.IBaseService;
import cn.ism.fw.simba.base.service.ServiceEntity;
import cn.ism.fw.simba.base.service.SimpleService;
import cn.ism.fw.simba.log.LogFactory;
import cn.ism.fw.simba.util.ClassScanner;
import cn.ism.fw.simba.util.ObjectUtil;

@Component
public class EntityServiceHolder {

  private static final Logger LOG = LogFactory.getLogger();

  private static Map<String, ResourceEntry> resourceMap = new HashMap<>();

  public void addResourceMapping(String resource, ResourceEntry entry) {
    if (resourceMap.containsKey(resource)) {
      LOG.warn("replace contains resource for key {}", resource);
    }
    resourceMap.put(resource, entry);
  }

  @PostConstruct
  public void register() { 
    Set<Class<?>> classes = ClassScanner.scan("cn.ism.fw", ServiceEntity.class);
    for (Class<?> clz : classes) { 
      ServiceEntity serviceEntity = clz.getAnnotation(ServiceEntity.class);
      String name = ObjectUtil.nvl(serviceEntity.name(), clz.getName());
      LOG.info("register entity serivce for {},and mapping name is {}" ,clz,name);
      resourceMap.put(name, new ResourceEntry(clz, String.class));
    } 
  }

  @SuppressWarnings("rawtypes")
  public IBaseService getEntityService(String resource) {
    Assert.isTrue(resourceMap.containsKey(resource), "no found resource mapping for key " + resource);
    ResourceEntry entry = resourceMap.get(resource);
    return new SimpleService(entry);
  }
}
