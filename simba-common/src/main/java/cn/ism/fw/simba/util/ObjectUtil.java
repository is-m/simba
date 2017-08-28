package cn.ism.fw.simba.util;

import java.util.Map;

/**
 * 对象工具类
 * 
 * @since 2017年5月7日
 * @author Administrator
 */
public class ObjectUtil {

	/**
	 * 
	 * @param source
	 * @param defaultValue
	 * @return
	 * @since 2017年5月7日
	 * @author Administrator
	 */
	public static <T> T nvl(T source, T defaultValue) {
		return source == null ? defaultValue : source;
	}

	public static boolean isEmpty(Object o) {
		if (o == null)
			return true;
		if (o instanceof String)
			return StringUtil.isEmpty((String) o);
		if (o instanceof Iterable<?>)
			return CollectionUtil.isEmpty((Iterable<?>) o);
		if (o instanceof Map<?, ?>)
			return CollectionUtil.isEmpty((Map<?, ?>) o);
		if (o.getClass().isArray())
			return CollectionUtil.isEmpty(o);
		return false;
	}

}
