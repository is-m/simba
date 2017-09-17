package cn.ism.fw.simba.util;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class EnvironmentUtil implements EnvironmentAware {

	public static final String DEV = "dev";
	
	public static final String SIT = "sit";
	
	public static final String UAT = "uat";
	
	public static final String PRO = "production";
	
	private static Environment env;

	@Override
	public void setEnvironment(Environment environment) {
		env = environment;
	} 
	
	public static Environment getEnvironment() {
		return env;
	}  
 
	public static boolean isDev(){
		return StringUtil.inArray(env.getActiveProfiles(), DEV); 
	}
	
	public static boolean isNotProd(){
		return !StringUtil.inArray(env.getActiveProfiles(), PRO);
	}
	
	public static boolean isProd(){
		return StringUtil.inArray(env.getActiveProfiles(), DEV);
	}
}
