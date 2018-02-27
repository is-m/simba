package cn.ism.fw.simba.base.service.impl;

public class ResourceEntry {

  private Class<?> resClass;
  
  private Class<?> idClass;

  public Class<?> getResClass() {
    return resClass;
  }

  public void setResClass(Class<?> resClass) {
    this.resClass = resClass;
  }

  public Class<?> getIdClass() {
    return idClass;
  }

  public void setIdClass(Class<?> idClass) {
    this.idClass = idClass;
  }
  
  public ResourceEntry() {
    
  }

  public ResourceEntry(Class<?> resClass, Class<?> idClass) { 
    this.resClass = resClass;
    this.idClass = idClass;
  }
  
  
}
