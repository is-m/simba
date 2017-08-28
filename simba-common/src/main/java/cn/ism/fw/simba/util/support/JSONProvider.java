package cn.ism.fw.simba.util.support;

/**
 * JSON 操作接口
 * @since 2017年7月9日
 * @author Administrator
 */
public interface JSONProvider {
	
	public String toJSON(Object o);

	/**
	 * 
	 * @param objectType
	 * @param JSONString
	 * @return
	 * @since 2017年7月9日
	 * @author Administrator
	 */
	public <T> T toObject(String JSONString,Class<?>... classes);
	
}
