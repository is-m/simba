package cn.ism.fw.simba.security;

import cn.ism.fw.simba.base.BaseVO;

/**
 * 资源
 * @since 2017年8月8日
 * @author Administrator
 */
public class ResourceVO extends BaseVO {
 
	private static final long serialVersionUID = 7216340276893147737L;

	/**
	 * 资源编码
	 */
	private String code;
	
	/**
	 * 资源描述
	 */
	private String desc;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}  
	
}
