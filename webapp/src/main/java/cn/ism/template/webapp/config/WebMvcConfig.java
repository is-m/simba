/*package cn.ism.template.webapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter { 
	
	*//**
	 * 允许跨域配置
	 *//*
	@Override
	public void addCorsMappings(CorsRegistry registry) { 
		super.addCorsMappings(registry);
		registry.addMapping("/**").allowedOrigins("http://localhost:3000");
	}
}
*/