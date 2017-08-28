package cn.ism.fw.simba.security;

import java.io.Serializable;

public class RoleQueryVO implements Serializable {
 
	private static final long serialVersionUID = -9210483770453749611L;
	
	/**
	 * 用户ID
	 */
	private String userId;
	
	/**
	 * 角色名称
	 */
	private String name;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
