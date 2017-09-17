package cn.ism.fw.simba.base;

import java.io.Serializable;

import cn.ism.fw.simba.util.JSONUtil;
 
 
public class BasePOJO implements Serializable {
   
  private static final long serialVersionUID = 1649968385761776572L;

  @Override
  public String toString() {
    return JSONUtil.toJSON(this);
  }
}
