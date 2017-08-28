package cn.ism.fw.simba.base;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import cn.ism.fw.simba.util.JSONUtil;

@JsonIgnoreProperties("setId")
@SuppressWarnings("serial")
public class BaseVO implements Serializable {

	private String id;
	
	private boolean setId;

	public String getId() {
		if(id == null || id.trim().length() == 0){
			id = UUID.randomUUID().toString().replaceAll("-", "");
		}
		return id;
	}

	public void setId(String id) {
		setId = true;
		this.id = id;
	}

	public boolean isSetId() {
		return setId;
	}
 
	//@NumberFormat(style=Style.CURRENCY)
	//@NumberFormat(pattern="#,###.00")
	//double amount;
	
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //Date createTime;
	
	@Override
	public String toString() {
		return JSONUtil.toJSON(this);
	}
}
