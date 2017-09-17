package cn.ism.fw.simba.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectUtil {

	private static final Logger LOG = LoggerFactory.getLogger(ReflectUtil.class);

	public static List<Field> getDeclaredFields(Object o) {
		List<Field> result = CollectionUtil.newList();
		Class<?> tempClass = o.getClass();
		while (tempClass != null) {
			result.addAll(Arrays.asList(tempClass.getDeclaredFields()));
			tempClass = tempClass.getSuperclass();
		}
		return result;
	}

	public static Map<String, Field> getDeclaredFieldMap(Object o) {
		Map<String, Field> result = new HashMap<>();
		Class<?> tempClass = o.getClass();
		while (tempClass != Object.class) {
			for (Field field : tempClass.getDeclaredFields()) {
				String fieldName = field.getName();
				if (!result.containsKey(fieldName)) {
					result.put(fieldName, field);
				}
			}
			tempClass = tempClass.getSuperclass();
		}
		return result;
	}

	public static Field getField(Object obj, String fieldName) {
		for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				Field field = clazz.getDeclaredField(fieldName);
				field.setAccessible(true);
				return field;
			} catch (NoSuchFieldException e) {
			}
		}
		return null;
	}

	public static void setFieldValue(Object obj, String fieldName, String fieldValue) {
		Field field = getField(obj, fieldName);
		if (field != null) {
			try {
				field.set(obj, fieldValue);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				LOG.error(e.getMessage(), e);
			}
		}
	}

	public static Object getFieldValue(Object obj, String fieldName) { 
		Field field = ReflectUtil.getField(obj, fieldName);
		if (field != null) { 
			try {
				return field.get(obj);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				LOG.error(e.getMessage(), e);
			}
		}
		return null;
	}

	/**
	 * 获取方法
	 * 
	 * @param full
	 * @return
	 * @since 2017年8月27日
	 * @author Administrator
	 */
	public static Method getMethod(String full) {
		int dotPos = full.lastIndexOf(".");
		if (dotPos <= 0) {
			throw new IllegalArgumentException("cann't get method for full info:" + full);
		}

		String fullClass = full.substring(0, dotPos);
		String methodName = full.substring(dotPos + 1, full.length());
		System.out.println(fullClass + "  " + methodName);
		try {
			Class<?> clz = Class.forName(fullClass);
			for (Method method : clz.getDeclaredMethods()) {
				if (methodName.equals(method.getName())) {
					return method;
				}
			}
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	/**
	 * 
	 * @param a 比较源
	 * @param b 比较对象
	 * @return b == a || b extends a;
	 */
	public static boolean isType(Class<?> a,Class<?> b){
		if(a == null || b == null) return false; 
	    return a.isAssignableFrom(b);
	}
	
	public static boolean inType(Class<?> a,Class<?>... inArray){
		if(a == null || inArray == null || inArray.length == 0) return false;
		for(Class<?> item : inArray){
			if(isType(item,a )){
				return true;
			}
		}
		return false;
	}
}
