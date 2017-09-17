package cn.ism.fw.simba.spring.mvc.jsr311;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import cn.ism.fw.simba.spring.annotation.AutoComponent;
import cn.ism.fw.simba.util.ReflectUtil;

/**
 * 上下文属性处理器
 * 
 * @author Administrator
 *
 */
public class ContextAttributeMethodProcessor implements HandlerMethodArgumentResolver {

	private static final Logger LOG = LoggerFactory.getLogger(ContextAttributeMethodProcessor.class);

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// 是否存在注解 && 是否和目标类型匹配
		return parameter.hasParameterAnnotation(Context.class)
				&& ReflectUtil.inType(parameter.getParameterType(), ServletRequest.class, ServletResponse.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		LOG.debug("ContextAttributeMethodProcessor.resolveArgument::{}",parameter.getParameterName());
		boolean isRequest = ReflectUtil.isType(ServletRequest.class, parameter.getParameterType());
		return isRequest ? webRequest.getNativeRequest(HttpServletRequest.class)
				: webRequest.getNativeResponse(HttpServletResponse.class);
	}

}
