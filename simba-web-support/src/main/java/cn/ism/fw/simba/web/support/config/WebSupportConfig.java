package cn.ism.fw.simba.web.support.config;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import cn.ism.fw.simba.web.support.filter.RequestContextFilter;
import cn.ism.fw.simba.web.support.filter.SsoFilter;
import cn.ism.fw.simba.web.support.servlet.ServletDispacher;

@Configuration
public class WebSupportConfig implements ServletContextInitializer {

	private static final Logger LOG = LoggerFactory.getLogger(WebSupportConfig.class);
	
	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		LOG.info("init web support configuration");
		EnumSet<DispatcherType> types = EnumSet.allOf(DispatcherType.class);
		Map<String,String> ssoConfig = new HashMap<>();
		
		// 加载 sso filter
		FilterRegistration.Dynamic sso = sc.addFilter("ssoFilter", new SsoFilter());
		sso.setInitParameters(ssoConfig);
		sso.addMappingForUrlPatterns(types, true, "/*");
		LOG.info("sso fitler added!");
		
		// 加载 requestContext filter
		FilterRegistration.Dynamic rc = sc.addFilter("requestContextFilters", new RequestContextFilter());
		rc.addMappingForUrlPatterns(types, true, "/*");
		LOG.info("request context fitler added!");
		
		// 加载servletDispacher
		ServletRegistration.Dynamic sd = sc.addServlet("servletDispacher", new ServletDispacher());
		sd.addMapping("/servlet/*");
		LOG.info("servlet disapcher servlet added!");
	}

	
}
