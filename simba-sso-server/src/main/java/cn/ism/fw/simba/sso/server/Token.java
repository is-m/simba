package cn.ism.fw.simba.sso.server;

import cn.ism.fw.simba.util.IDUtil;

public class Token {

	private String token = IDUtil.newUUID();

	private int userId; // 用户唯一标识ID 
	private String username; //用户登录名 
	private String ssoClient; //来自登录请求的某应用系统标识
	private String globalId; //本次登录成功的全局会话sessionId 

	@Override
	public String toString() {
		return this.token;
	}
}
