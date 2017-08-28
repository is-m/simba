package cn.ism.fw.simba.context.support;

import cn.ism.fw.simba.context.RequestContext;

/**
 * 请求上下文管理器
 * @since 2017年8月16日
 * @author Administrator
 */
public final class RequestContextManager {

	private static ThreadLocal<RequestContext> tl = new ThreadLocal<>();
	
	private RequestContextManager(){}
	
	public static void init(RequestContext requestContext){
		tl.set(requestContext);
	}
	
	public static RequestContext get(){
		return tl.get();
	}
	
	public static void destory(){
		if(tl.get() != null){
			tl.remove();
		}
	}
}
