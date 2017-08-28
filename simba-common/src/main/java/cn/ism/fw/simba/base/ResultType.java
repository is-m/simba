package cn.ism.fw.simba.base;

/**
 * 结果类型枚举
 * 
 * @since 2017年7月29日
 * @author Administrator
 */
public enum ResultType {

	/**
	 * 成功
	 */
	SUCCESS("200", "访问成功"),
	/**
	 * 错误
	 */
	FAILURE("400", "请求错误"),
	/**
	 * 异常
	 */
	EXCEPTION("500", "系统异常");

	private String code;

	private String message;

	private ResultType(String c, String m) {
		c = code;
		message = m;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
