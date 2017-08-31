package cn.ism.fw.simba.util;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class SpringUtil implements ApplicationContextAware {

	private static ApplicationContext ac;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ac = applicationContext;
	}
	
	public static ApplicationContext getContext(){
		return ac;
	}
	
	public static <T> T getBean(Class<T> t,String name){
		return (T) ac.getBean(t,name);
	}
	
	public static <T> Map<String, T> getBeansOfType(Class<T> t){
		return (Map<String, T>) ac.getBeansOfType(t);
	}
	
	public static <T> T getBeanOfLikeName(Class<T> t,String name){
		Map<String, T> beanMap =  getBeansOfType(t);
		for(Map.Entry<String, T> item : beanMap.entrySet()){
			if(StringUtil.equals(item.getKey(), name, true)){
				return item.getValue();
			}
		}
		return null;
	}
}
