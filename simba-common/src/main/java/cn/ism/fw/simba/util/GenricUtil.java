package cn.ism.fw.simba.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenricUtil {

  public static Class<?> getGenricClass(Class<?> clz,int genricIndex) {
    Type testType=clz.getGenericSuperclass();
    if(testType instanceof ParameterizedType){
      ParameterizedType type=(ParameterizedType)testType; 
      try {
        return (Class<?>)type.getActualTypeArguments()[genricIndex];
      }catch (ClassCastException cce) {
        // 如果存在下面消息
        if(cce.getMessage().contains("TypeVariableImpl cannot be cast to java.lang.Class")) {
          // 可以获取 B extends A<T> 不能获取B<T> extends A<T>，运行时的泛型也是无法获取的
          throw new RuntimeException(String.format("存在泛型参数，但不能获取本身为泛型类型的类的泛型，并且运行时的泛型也是无法获取的"));
        }
        throw cce; 
      } 
    }
    throw new NullPointerException("未找到可用的泛型信息，请检查是否有继承或实现某泛型类");
  }
  
  public static void main(String[] args) {
   D d = new D();
   System.out.println(GenricUtil.getGenricClass(d.getClass(), 0));
  }
  
  public static class Parent<T,K>{
    
  }
  
  public static class C<T> extends Parent<T,Long>{
     
  }
  
  public static class D extends C<String>{
     
  }
  
  
}
