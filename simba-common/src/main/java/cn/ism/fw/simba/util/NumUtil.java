package cn.ism.fw.simba.util;

/**
 * 数值工具类
 * @since 2017年7月29日
 * @author Administrator
 */
public class NumUtil {

	public static int divides(int a,int b){ 
		return (a % b > 0 ? 1 : 0) + a / b;
	}
}
