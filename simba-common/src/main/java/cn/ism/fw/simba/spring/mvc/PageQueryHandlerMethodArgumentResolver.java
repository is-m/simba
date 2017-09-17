package cn.ism.fw.simba.spring.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import cn.ism.fw.simba.base.PageVO;
import cn.ism.fw.simba.spring.annotation.AutoComponent;

@AutoComponent
public class PageQueryHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	private static final Logger LOG = LoggerFactory.getLogger(PageQueryHandlerMethodArgumentResolver.class);
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) { 
		return parameter.getParameterType() == PageVO.class;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		LOG.debug("resolveArgument");
		return null;
	}

}
