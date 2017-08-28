package cn.ism.fw.simba.specs.support;

/**
 * 安全策略
 * 
 * @since 2017年7月22日
 * @author Administrator
 */
public enum SecurityPolicy {

	/**
	 * 所有用户/包含匿名用户（默认）
	 */
	ALL,

	/**
	 * 能登录系统的
	 */
	Logined, 
	
	/**
	 * 必须拥有权限的
	 */
	Required,
	
	
}
