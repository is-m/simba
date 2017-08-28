package cn.ism.fw.simba.util.support;

/**
 * NULL 
 * @since 2017年8月6日
 * @author Administrator
 */
public final class Null {

	public static final Null VALUE = new Null();
	
	private Null(){ } 
	
	@Override
	public boolean equals(Object obj) {
		return obj == null || obj instanceof Null;
	}
	
}
