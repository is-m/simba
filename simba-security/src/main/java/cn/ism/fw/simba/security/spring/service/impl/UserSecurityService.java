/*package cn.ism.fw.simba.security.spring.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.ism.fw.simba.security.RoleQueryVO;
import cn.ism.fw.simba.security.RoleVO;
import cn.ism.fw.simba.security.UserVO;
import cn.ism.fw.simba.security.dao.IRoleDao;
import cn.ism.fw.simba.security.dao.IUserDao;

@Named
public class UserSecurityService implements UserDetailsService {

	@Inject
	private IUserDao userDao;
	
	private IRoleDao roleDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		UserVO user = userDao.findUserByName(username);
		if(user == null){
			throw new UsernameNotFoundException(username);
		} 
		
		// TODO:待从后台获取角色还是怎么样
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		//authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		RoleQueryVO roleQueryVO = new RoleQueryVO();
		roleQueryVO.setUserId(user.getId());
		List<RoleVO> roles = roleDao.findList(roleQueryVO);
		for(RoleVO roleVO : roles){ 
			authorities.add(new SimpleGrantedAuthority(roleVO.getName()));
		}
		
		User u = new User(user.getUsername(),user.getPasswd(),authorities);
		return u;
	}

}
*/