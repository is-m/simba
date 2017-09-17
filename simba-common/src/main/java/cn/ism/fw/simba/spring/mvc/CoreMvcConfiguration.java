/*package cn.ism.fw.simba.spring.mvc;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration 
public class CoreMvcConfiguration extends WebMvcConfigurationSupport  {

	private static final Logger LOG = LoggerFactory.getLogger(CoreMvcConfiguration.class);
  
	 
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		LOG.debug("add argument resolvers");

		List<HandlerMethodArgumentResolver> resolvers = Arrays.asList(new PageQueryHandlerMethodArgumentResolver());
		LOG.debug("add argument resolvers size::{}", resolvers.size());

		argumentResolvers.addAll(resolvers);
		LOG.debug("add argument resolvers success");
	}
}
*/