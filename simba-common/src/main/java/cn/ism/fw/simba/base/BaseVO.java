package cn.ism.fw.simba.base;

import java.util.UUID;

import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import cn.ism.fw.simba.context.RequestContext;
import cn.ism.fw.simba.jsr.validation.MustEmpty;
import cn.ism.fw.simba.jsr.validation.groups.CreateGroup;
import cn.ism.fw.simba.jsr.validation.groups.UpdateGroup;

/**
 * 基础VO类
 * 
 * @since 2017年9月25日
 * @author Administrator
 */
@JsonIgnoreProperties({"setId","currentUserId"})
@JsonInclude(Include.NON_NULL)
public class BaseVO extends BasePOJO {

  private static final long serialVersionUID = -2985566320727450256L;

  @Id
  @MustEmpty(groups = {CreateGroup.class})
  @NotEmpty(groups = {UpdateGroup.class})
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

  public String getCurrentUserId() {
    try {
      return RequestContext.getCurrent().getUser().getId();
    } catch (Exception e) {
      return "null";
    }
  }

  // @NumberFormat(style=Style.CURRENCY)
  // @NumberFormat(pattern="#,###.00")
  // double amount;

  // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  // Date createTime;

}
