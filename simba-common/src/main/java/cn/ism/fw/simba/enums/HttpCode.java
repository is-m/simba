package cn.ism.fw.simba.enums;

public enum HttpCode {

	/**
	 * 未认证
	 */
	NO_LOGIN(403), 
	/**
	 * 未鉴权
	 */
	NO_PERMISSION(401),
	/**
	 * 
	 */
	NO_FOUND(404), 
	/**
	 * 内部错误
	 */
	SERVER_ERROR(500);

	private int code;

	public int getCode() {
		return code;
	}

	private HttpCode(int c) {
		code = c;
	}

}
