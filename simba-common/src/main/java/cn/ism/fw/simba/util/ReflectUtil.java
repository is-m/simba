package cn.ism.fw.simba.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ReflectUtil {

	public static List<Field> getDeclaredFields(Object o){ 
		List<Field> result = CollectionUtil.newList(); 
		Class<?> tempClass=o.getClass();
		while(tempClass != null){ 
			result.addAll(Arrays.asList(tempClass.getDeclaredFields()));
			tempClass = tempClass.getSuperclass();
		}
		return result;
	}
	 
	/**
	 * 获取方法
	 * @param full
	 * @return
	 * @since 2017年8月27日
	 * @author Administrator
	 */
	public static Method getMethod(String full){
		int dotPos = full.lastIndexOf(".");
		if(dotPos <= 0){
			throw new IllegalArgumentException("cann't get method for full info:"+full);
		}
		
		String fullClass = full.substring(0,dotPos);
		String methodName = full.substring(dotPos+1,full.length());
		System.out.println(fullClass+"  "+methodName);
		try {
			Class<?> clz = Class.forName(fullClass);
			for(Method method : clz.getDeclaredMethods()){
				if(methodName.equals(method.getName())){
					return method;
				}
			}
			return null;
		} catch (ClassNotFoundException e) { 
			return null;
		}
	}
	 
}
