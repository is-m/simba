package cn.ism.fw.simba.orm;

/**
 * 未实现异常
 * 
 * @since 2017年7月25日
 * @author Administrator
 */
public class NoImplementException extends RuntimeException {

	private static final long serialVersionUID = 3074770631732034414L;

	public NoImplementException() {
		super("no implements!");
	}
}
