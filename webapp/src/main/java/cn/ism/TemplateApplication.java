package cn.ism;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

import cn.ism.template.webapp.common.util.SpringBootUtil;

@EnableAspectJAutoProxy(proxyTargetClass=true)
@ImportResource(locations={"classpath:config/applicationContext.xml"})
@SpringBootApplication
@MapperScan({"cn.ism.fw.simba.security.dao","cn.ism.fw.simba.sitemap.dao"})
public class TemplateApplication implements ServletContextInitializer {
	
	private static final Logger LOG = LoggerFactory.getLogger(TemplateApplication.class);

	public static void main(String[] args) {
		SpringBootUtil.run(TemplateApplication.class, args);
	}

	/**
	 * 编码的方式动态添加servlet,filter,listen
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	/*	ServletRegistration.Dynamic servlet =  servletContext.addServlet("serlvetA", new HttpServlet() { 
			private static final long serialVersionUID = -5156026792255133095L;

			@Override
			public void init() throws ServletException {
				LOG.info("init onStartup servlet ");
			}
		});
		servlet.addMapping("/test/*");
		servlet.setLoadOnStartup(1);*/
	} 
	
	/**
	 * ServletRegistrationBean,FilterRegistrationBean,ServletListenerRegistrationBean
	 * @return
	 * @since 2017年8月13日
	 * @author Administrator
	 */
	/*@Bean
	public ServletRegistrationBean annoServlet(){
		ServletRegistrationBean bean= new ServletRegistrationBean(new HttpServlet() { 
			private static final long serialVersionUID = 653295509297905325L;

			@Override
			public void init() throws ServletException {
				LOG.info("init annotation reg servlet ");
			}
		},"/annotation/*");
		bean.setLoadOnStartup(1);
		return bean;
	}*/
}
