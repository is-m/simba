package cn.ism.fw.simba.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {

	/**
	 * 获取异常堆栈
	 * 
	 * @param e
	 * @return
	 * @since 2017年7月28日
	 * @author Administrator
	 */
	public static String getStackTrace(Throwable e) {
		// @see
		// org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(exception);
		// org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace(e);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw, true);
		e.printStackTrace(pw);
		pw.flush();
		sw.flush();
		return sw.toString();
	}
}
