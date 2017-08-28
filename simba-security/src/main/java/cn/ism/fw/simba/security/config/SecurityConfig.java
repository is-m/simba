package cn.ism.fw.simba.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true,exposeProxy=true)
public class SecurityConfig {

}
