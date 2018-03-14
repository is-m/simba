package cn.ism.template.webapp.common.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import cn.ism.fw.simba.util.StringUtil;

/**
 * SpringBoot工具类
 * @since 2017年5月7日
 * @author Administrator
 */
public class SpringBootUtil {

	private static final Logger LOG = LoggerFactory.getLogger(SpringBootUtil.class);

	/**
	 * spring profiles 默认为开发，如果在容器中运行，则需要指定环境参数 例如 --spring.profiles.active=prod
	 */ 
	private static final String SPRING_PROFILE_DEFAULT = "--spring.profiles.default=dev";
	
	@SuppressWarnings("unused")
	private static final String SPRING_LOG = "--debug";

	private static ApplicationContext ac = null;

	private void printStartInfo() {
	  
	}
	
	/**
	 * the spring boot application main
	 * 
	 * @param clz
	 * @param args
	 */
	public static void run(Class<?> clz, String... args) {
		ac = SpringApplication.run(clz, StringUtil.merge(args, SPRING_PROFILE_DEFAULT/*,SPRING_LOG*/));

		Environment env = ac.getEnvironment();
		String[] profiles = env.getActiveProfiles();
		String[] activeProfiles = profiles.length > 0 ? profiles : env.getDefaultProfiles();
		String activeProfileString = StringUtils.join(activeProfiles);

		LOG.info("\n\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n"
				   + "Application '{}' is running , current active profiles is [{}]\n\n"
				   + "local : http://localhost:{}{}\n" + "remote: xxxx\n"
				   + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n",
				env.getProperty("spring.application.name"), activeProfileString, env.getProperty("server.port"),
				env.getProperty("server.context-path"));

	}

}
