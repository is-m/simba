package cn.ism.fw.simba.security;

import cn.ism.fw.simba.base.BaseVO;

/**
 * 操作
 * @since 2017年8月8日
 * @author Administrator
 */
public class OperateVO extends BaseVO {
 
	private static final long serialVersionUID = -6779821528432505575L;

	/**
	 * 操作编码
	 */
	private String code;
	
	/**
	 * 操作描述
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
