package cn.ism.template.webapp.common.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ism.fw.simba.security.UserVO;
import cn.ism.fw.simba.security.service.IUserService;

@RestController
@RequestMapping("/api")
public class RestHomeController {

	@Inject
	private IUserService userService;

	@RequestMapping("/hello")
	public String sayHello() {
		return userService.createObj(new UserVO()) + "";
	}

	@RequestMapping("/user/find")
	public UserVO findUser() {
		UserVO user = new UserVO();
		userService.createObj(user);
		return userService.findObj(user.getId());
	}

}
