package cn.ism.fw.simba.spring.mvc.jsr311;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * JSR 311 PathParam
 * @author Administrator
 *
 */
public class PathParamAttributeMethodProcessor implements HandlerMethodArgumentResolver {

	private static final Logger LOG = LoggerFactory.getLogger(PathParamAttributeMethodProcessor.class);

	@Override
	public boolean supportsParameter(MethodParameter parameter) { 
		return parameter.hasParameterAnnotation(PathParam.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

		// 通过地址栏获取参数
		return null;
	}

}
