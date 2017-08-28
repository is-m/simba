package cn.ism.fw.simba.exception;

/**
 * 暂时未支持异常
 * @since 2017年8月27日
 * @author Administrator
 */
public class NoImplementException extends RuntimeException {
 
	private static final long serialVersionUID = -5133944672774792620L;

	public NoImplementException() {
		super();
	}

	public NoImplementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace); 
	}

	public NoImplementException(String message, Throwable cause) {
		super(message, cause); 
	}

	public NoImplementException(String message) {
		super(message); 
	}

	public NoImplementException(Throwable cause) {
		super(cause); 
	}

}
