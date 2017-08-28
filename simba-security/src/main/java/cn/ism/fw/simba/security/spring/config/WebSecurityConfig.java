/*package cn.ism.fw.simba.security.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import cn.ism.fw.simba.security.spring.service.impl.UserSecurityService;

@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 允许进入页面前检验
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	public WebSecurityConfig() {
		System.err.println("WebSecurityConfig inited");
	}
	public static final String FILTER_PATHS = "";
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	   *//**
     * 设置用户密码的加密方式为MD5加密
     * @return
     *//*
    @Bean
    public Md5PasswordEncoder passwordEncoder() {
        return new Md5PasswordEncoder();

    }

    *//**
     * 自定义UserDetailsService，从数据库中读取用户信息
     * @return
     *//*
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserSecurityService();
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略css.jq.img等文件
        web.ignoring().antMatchers("/**.html","**.css", "/images/**", "**.js","/third-party/**");
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		super.configure(http);
		http
			.csrf().disable() //HTTP with Disable CSRF
			.authorizeRequests().antMatchers("/assets/**","/images/**","/css/**","/js/**").permitAll()// 无需访问权限
			.antMatchers("/web/**").hasAuthority("ROLE_ADMIN")// admin角色访问权限
			// .antMatchers("").hasAuthority("ROLE_USER")// user角色访问权限
			.anyRequest().authenticated() // all others request authentication
			.and().formLogin().loginPage("/web/page/login.html").permitAll().and().logout().permitAll();
	}

	

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// 将验证过程交给自定义验证工具
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder()); 
	}

}
*/