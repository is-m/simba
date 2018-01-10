package cn.ism.fw.simba.base;

import java.io.Serializable;
import java.util.HashMap;

import cn.ism.fw.simba.util.ExceptionUtil;

/**
 * 消息结果
 * 
 * @since 2017年7月28日
 * @author Administrator
 */
public class ResultVO extends BasePOJO {

  private static final long serialVersionUID = -8681658011740210741L;

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
  private Object data;

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

  public ResultVO msg(String msg) {
    setMsg(msg);
    return this;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
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

  public ResultVO(String code, String msg, Object data, String detail) {
    this.code = code;
    this.msg = msg;
    this.data = data;
    this.detail = detail;
  }

  public ResultVO(String code, String msg, Object data) {
    this(code, msg, data, null);
  }

  public ResultVO(String code, String msg) {
    this(code, msg, null, null);
  }

  public ResultVO(ResultType type) {
    this(type.getCode(), type.getMessage(), null, null);
  }

  public ResultVO(ResultType type, Object data) {
    this(type.getCode(), type.getMessage(), data, null);
  }

  public ResultVO(ResultType type, String detail) {
    this(type.getCode(), type.getMessage(), null, detail);
  }

  public ResultVO(ResultType type, Serializable data, String detail) {
    this(type.getCode(), type.getMessage(), data, detail);
  }

  public static ResultVO SUCCESS(Object data) {
    return new ResultVO(ResultType.SUCCESS, data);
  }
  
  public static ResultVO SUCCESS() {
    return new ResultVO(ResultType.SUCCESS, null);
  }

  public static ResultVO SUCCESS(int modifyCount) {
    HashMap<String, Object> data = new HashMap<>();
    data.put("modifyCount", modifyCount);
    data.put("totalCount", modifyCount);
    return new ResultVO(ResultType.SUCCESS, data);
  }

  public static ResultVO ERROR_PARAMS(Object error) {
    return new ResultVO(ResultType.ERROR_PARAMS, error);
  }


  public static ResultVO EXCEPTION(Throwable t) {
    return new ResultVO(ResultType.EXCEPTION, ExceptionUtil.getStackTrace(t)).msg(t.getMessage());
  }
}
