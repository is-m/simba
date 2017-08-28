package cn.ism.fw.simba.base;

import cn.ism.fw.simba.util.JSONUtil;

/**
 * 消息结果
 * @since 2017年7月28日
 * @author Administrator
 */
public class ResultVO<T> {

	/**
	 * 响应代码
	 */
	private String code;

	/**
	 * 响应消息 请求成功
	 */
	private String msg;

	/**
	 * 响应数据
	 */
	private T data;

	/**
	 * 响应详情 例如消息可能只是提示无访问权限，或者系统异常，此处可以具体描述消息提示的原因
	 */
	private String detail;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public ResultVO() {

	}
	
	public ResultVO(String code, String msg, T data, String detail) {
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.detail = detail;
	}
	
	public ResultVO(String code, String msg, T data) {
		this(code,msg,data,null);
	}
	
	public ResultVO(String code, String msg) {
		this(code,msg,null,null);
	}
	
	public ResultVO(ResultType type){
		this(type.getCode(),type.getMessage(),null,null);
	}
	
	public ResultVO(ResultType type,T data){
		this(type.getCode(),type.getMessage(),data,null);
	}
	
	public ResultVO(ResultType type,String detail){
		this(type.getCode(),type.getMessage(),null,detail);
	}
	
	public ResultVO(ResultType type,T data,String detail){
		this(type.getCode(),type.getMessage(),data,detail);
	}

	public static <T> ResultVO<T> SUCCESS(T data){ 
		return new ResultVO<>(ResultType.SUCCESS,data);
	}
	
	@Override
	public String toString() { 
		return JSONUtil.toJSON(this);
	}
}
