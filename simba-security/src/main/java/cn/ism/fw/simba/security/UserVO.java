package cn.ism.fw.simba.security;

import cn.ism.fw.simba.base.BaseVO;

/**
 * 用户
 * @since 2017年8月8日
 * @author Administrator
 */
public class UserVO extends BaseVO  {

	private static final long serialVersionUID = 5189034420014315333L;

	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 密码
	 */
	private String passwd;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
}
