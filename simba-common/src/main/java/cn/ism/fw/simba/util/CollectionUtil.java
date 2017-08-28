package cn.ism.fw.simba.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CollectionUtil {

	/**
	 * 判断集合是否为空
	 * @param iterable
	 * @return
	 * @since 2017年7月25日
	 * @author Administrator
	 */
	public static boolean isEmpty(Iterable<?> iterable) {
		return iterable == null || !iterable.iterator().hasNext();
	} 

	/**
	 * 判断Map是否为空
	 * @param map
	 * @return
	 * @since 2017年7月25日
	 * @author Administrator
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		return map == null || map.isEmpty();
	}

	/**
	 * 判断数组是否为空
	 * @param array
	 * @return
	 * @since 2017年7月25日
	 * @author Administrator
	 */
	public static boolean isEmpty(Object array) {
		if(array == null) return true;
		Assert.isFalse(array.getClass().isArray(),"cann't support not array type");
		return Array.getLength(array) == 0;
	}
	
	public static <T> List<T> newList(){
		return new ArrayList<>();
	}
}
