package cn.ism.fw.simba.base.dao;

import javax.persistence.Table;

import org.springframework.util.Assert;

import cn.ism.fw.simba.util.StringUtil;

public class EntityMeta {

  private Class<?> entityClass;
  
  private String tableName;

  private String idField;

  private String[] columns; 

  public Class<?> getEntityClass() {
    return entityClass;
  }

  public void setEntityClass(Class<?> entityClass) {
    this.entityClass = entityClass;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public String getIdField() {
    return idField;
  }

  public void setIdField(String idField) {
    this.idField = idField;
  }

  public String[] getColumns() {
    return columns;
  }

  public void setColumns(String[] columns) {
    this.columns = columns;
  }
  

  public static EntityMeta read(Class<?> entityClass) {
    Assert.notNull(entityClass, "entityClass cannot be null or empty");
    Table tableAnnotation = entityClass.getAnnotation(Table.class);
    Assert.notNull(tableAnnotation, "no found JPA annotation (Table) for class " + entityClass.getPackage() + "." + entityClass.getName());
    
    EntityMeta meta = new EntityMeta();
    meta.setEntityClass(entityClass);
    meta.setTableName(StringUtil.isEmpty(tableAnnotation.name()) ? entityClass.getName() : tableAnnotation.name());
    
    
    return meta;
    
  }
}
