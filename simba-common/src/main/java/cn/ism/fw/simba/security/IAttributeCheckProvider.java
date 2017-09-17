package cn.ism.fw.simba.security;

/**
 * 属性检查接口
 * 
 * @since 2017年7月22日
 * @author Administrator
 */
public interface IAttributeCheckProvider {

	/**
	 * 检查属性属性是否有访问权限
	 * 
	 * @param attribute
	 *            属性名
	 * @param keyValue
	 *            通过注解key获取到的值，通常放的是业务主键
	 * @return
	 * @since 2017年7月22日
	 * @author Administrator
	 */
	public boolean check(String attribute, Object keyValue);

	/**
	 * 获取校验对象，主要用于根据业务主键来获取当前进行属性检查的对象
	 * 
	 * @param keyValue
	 * @return
	 * @since 2017年7月25日
	 * @author Administrator
	 */
	public Object getCheckObject(Object keyValue);

}
