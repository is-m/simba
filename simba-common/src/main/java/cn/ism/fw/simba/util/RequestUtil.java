package cn.ism.fw.simba.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求工具类
 * @since 2017年8月16日
 * @author Administrator
 */
public class RequestUtil {

	private static final String KEY_SHORT_URI = "KEY_SHORT_URI";
	
	public static String getShortURI(HttpServletRequest req){
		String shortURI = (String) req.getAttribute(KEY_SHORT_URI);
		
		if(shortURI == null){
			String uri = req.getRequestURI();
			System.out.println("short uri:"+uri);
			String contextPath = req.getContextPath();
			if(uri.indexOf(contextPath) == 0){
				uri = uri.substring(contextPath.length());
			}
			shortURI= uri;
			req.setAttribute(KEY_SHORT_URI, uri);
			
		}
		return shortURI;
	}
}
