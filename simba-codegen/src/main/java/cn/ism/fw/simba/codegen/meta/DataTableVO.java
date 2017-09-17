package cn.ism.fw.simba.codegen.meta;

import java.util.List;

public class DataTableVO {

  private String tableName;
  
  private List<DataFieldVO> fields;

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public List<DataFieldVO> getFields() {
    return fields;
  }

  public void setFields(List<DataFieldVO> fields) {
    this.fields = fields;
  }
  
  
  
}
