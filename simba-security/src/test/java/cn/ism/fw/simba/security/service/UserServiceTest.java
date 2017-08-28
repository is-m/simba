package cn.ism.fw.simba.security.service;

import java.util.Calendar;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import cn.ism.fw.simba.security.UserVO;
import cn.ism.fw.simba.security.service.IUserService;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext-test.xml")  
@ComponentScan("cn.ism")
public class UserServiceTest {

	@Inject
	private IUserService userService;

	@Test
	public void findObj() {
		UserVO vo = new UserVO();
		vo.setUsername("测试" + Calendar.getInstance().getTimeInMillis());
		vo.setPasswd("" + Calendar.getInstance().getTimeInMillis());
		int addUserCount = userService.createObj(vo);
		Assert.assertTrue(addUserCount > 0);
		UserVO user = userService.findObj(vo.getId());
		Assert.assertNotNull(user);
	}

	@Test
	public void createObj() {
		UserVO vo = new UserVO();
		vo.setUsername("测试" + Calendar.getInstance().getTimeInMillis());
		vo.setPasswd("" + Calendar.getInstance().getTimeInMillis());
		int result = userService.createObj(vo);
		Assert.assertTrue(result > 0);
	}
}
