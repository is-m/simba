package cn.ism.fw.simba.base;

import java.io.Serializable;

import cn.ism.fw.simba.util.JSONUtil;

/**
 * 基础类
 * 注意：如果存在树结构的子类，在toString时，需要检查是否存在循环引用
 * @since 2017年9月25日
 * @author Administrator
 */
public class BasePOJO implements Serializable {

  private static final long serialVersionUID = 1649968385761776572L;

  @Override
  public String toString() {
    return JSONUtil.toJSON(this);
  }
}
