package cn.ism.fw.simba.base;

import java.util.Date;

/**
 * 基础资源对象
 * @since 2017年10月15日
 * @author Administrator
 */
public class BaseResourceVO extends BaseVO {
 
  private static final long serialVersionUID = -4300362743737747771L;

  /**
   * 版本号，用于避免重复提交，或者并发操作问题
   */
  
  private short edition;
  
  /**
   * 创建人
   */ 
  private String createdBy;
  
  /**
   * 创建事件
   */
  private Date creationDate;
  
  /**
   * 最后修改人
   */
  private String lastUpdateBy;
  
  /**
   * 最后修改时间
   */
  private Date lastUpdatedDate;    
  
  public short getEdition() {
    return edition;
  }

  public void setEdition(short edition) {
    this.edition = edition;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  } 

  public String getLastUpdateBy() {
    return lastUpdateBy;
  }

  public void setLastUpdateBy(String lastUpdateBy) {
    this.lastUpdateBy = lastUpdateBy;
  }

  public Date getLastUpdatedDate() {
    return lastUpdatedDate;
  }

  public void setLastUpdatedDate(Date lastUpdatedDate) {
    this.lastUpdatedDate = lastUpdatedDate;
  }
   
  
}
