package cn.ism.fw.simba.base;

import java.util.UUID;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import cn.ism.fw.simba.jsr.validation.MustEmpty;
import cn.ism.fw.simba.jsr.validation.groups.CreateGroup;
import cn.ism.fw.simba.jsr.validation.groups.UpdateGroup;

/**
 * 基础VO类
 * @since 2017年9月25日
 * @author Administrator
 */
@JsonIgnoreProperties("setId")
public class BaseVO extends BasePOJO {

  private static final long serialVersionUID = -2985566320727450256L;

  @MustEmpty(groups= {CreateGroup.class})
  @NotEmpty(groups= {UpdateGroup.class})
  private String id;

  private boolean setId;

  public String getId() {
    if (id == null || id.trim().length() == 0) {
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

  // @NumberFormat(style=Style.CURRENCY)
  // @NumberFormat(pattern="#,###.00")
  // double amount;

  // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  // Date createTime;
 
}
