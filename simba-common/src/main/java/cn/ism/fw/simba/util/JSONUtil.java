package cn.ism.fw.simba.util;

import cn.ism.fw.simba.util.support.FastJSONProvider;
import cn.ism.fw.simba.util.support.JSONProvider;
import cn.ism.fw.simba.util.support.JacksonProvider;

/**
 * JSON 工具类
 * @since 2017年7月25日
 * @author Administrator
 */
public class JSONUtil {

	private static JSONProvider util;

	static {
		// 判断加载哪个提供程序
		try {
			Class.forName("com.fasterxml.jackson.databind.ObjectMapper");
			util = new JacksonProvider();
		} catch (ClassNotFoundException e) {
			util = new FastJSONProvider();
		}

		if (util == null) {
			throw new RuntimeException("未找到可用的Json提供程序");
		}
	}

	public static String toJSON(Object o) {
		return util.toJSON(o);
	}

	public static <T> T toObject(String JSONString, Class<?>... classes) {
		return util.toObject(JSONString, classes);
	}
}
