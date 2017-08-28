package cn.ism.fw.simba.sso.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import cn.ism.fw.simba.util.SpringBootUtil;

@SpringBootApplication
public class SsoApplication {

	public static void main(String[] args) {
		SpringBootUtil.run(SsoApplication.class, args);
	}
	
}
