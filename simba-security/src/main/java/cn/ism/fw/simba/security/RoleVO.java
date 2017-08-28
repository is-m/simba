package cn.ism.fw.simba.security;

import java.util.Set;

import cn.ism.fw.simba.base.BaseVO;

/**
 * 角色
 * @since 2017年8月8日
 * @author Administrator
 */
public class RoleVO extends BaseVO {
 
	private static final long serialVersionUID = 1775735144856710378L;
 
	/**
	 * 角色名称
	 */
	private String name;
	
	/**
	 * 角色说明
	 */
	private String description;
	
	/**
	 * 角色默认页
	 */
	private String defaultPage;
	
	/**
	 * 角色权限
	 * 内容为：ResourceName@OperateName
	 */
	private Set<String> permits;  

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDefaultPage() {
		return defaultPage;
	}

	public void setDefaultPage(String defaultPage) {
		this.defaultPage = defaultPage;
	}

	public Set<String> getPermits() {
		return permits;
	}

	public void setPermits(Set<String> permits) {
		this.permits = permits;
	} 
	
}
