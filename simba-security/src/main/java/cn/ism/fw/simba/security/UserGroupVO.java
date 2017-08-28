package cn.ism.fw.simba.security;

import java.util.List;

import cn.ism.fw.simba.base.BaseVO;

/**
 * 用户组
 * @since 2017年8月8日
 * @author Administrator
 */
public class UserGroupVO extends BaseVO {
 
	private static final long serialVersionUID = 4167961113368715535L;
	
	/**
	 * 用户组名称
	 */
	private String name;
	
	/**
	 * 说明
	 */
	private String desc;
	
	/**
	 * 用户列表
	 */
	private List<UserVO> users;
	
	/**
	 * 角色列表
	 */
	private List<RoleVO> roles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<UserVO> getUsers() {
		return users;
	}

	public void setUsers(List<UserVO> users) {
		this.users = users;
	}

	public List<RoleVO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleVO> roles) {
		this.roles = roles;
	} 
	
	
	
}
