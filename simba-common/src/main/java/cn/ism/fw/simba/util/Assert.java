package cn.ism.fw.simba.util;

/**
 * 断言异常类
 * 
 * @since 2017年7月25日
 * @author Administrator
 */
public class Assert {

	public static void isTrue(boolean isTrue, String msg,Object... params) {
		if (isTrue)
			throw new IllegalStateException(msg);
	}

	public static void isFalse(boolean isFalse, String msg,Object... params) {
		if (!isFalse)
			throw new IllegalStateException(msg);
	}

	public static void empty(Object o, String msg,Object... params) {
		if (ObjectUtil.isEmpty(o))
			throw new IllegalArgumentException(msg);
	}

	public static void notEmpty(Object o, String msg,Object... params) {
		if (!ObjectUtil.isEmpty(o))
			throw new IllegalArgumentException(msg);
	}
}
