package cn.ism.fw.simba.security;

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
     * 入口方法存在权限则允许整个方法链被访问
     */
	Basic,
	
	/**
	 * 必须检查权限
	 */
	Required,
	
	
}
