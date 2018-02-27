package cn.ism.fw.simba.base.service.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ism.fw.simba.base.PageVO;
import cn.ism.fw.simba.base.service.IBaseService;
import cn.ism.fw.simba.base.service.ServiceEntity;

public class EntityServiceInvorker {
  private static final Logger LOG = LoggerFactory.getLogger(EntityServiceInvorker.class);

  @SuppressWarnings("unchecked")
  public <T> T getInstance(Class<T> cls) {
    MethodProxy invocationHandler = new MethodProxy();
    Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[] {cls}, invocationHandler);
    return (T) newProxyInstance;
  }

  public class MethodProxy implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      // 如果传进来是一个已实现的具体类（本次演示略过此逻辑)
      if (Object.class.equals(method.getDeclaringClass())) {
        try {
          return method.invoke(this, args);
        } catch (Throwable t) {
          t.printStackTrace();
        }
        // 如果传进来的是一个接口（核心)
      } else {
        return call(method, args);
      }
      return null;
    }

    private Object call(Method method, Object[] args) {
      // 查询方法
      if ("getPageData".equals(method.getName())) {
        if (args.length == 2 && PageVO.class.equals(args[0].getClass()) && args[1].getClass().getAnnotation(ServiceEntity.class) != null) {
          
        }
      }
      return null;
    }
  }


}
