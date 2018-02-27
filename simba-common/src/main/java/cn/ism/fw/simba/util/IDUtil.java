package cn.ism.fw.simba.util;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class IDUtil {

  private static final int LENGTH = 32;
  
  /**
   * 32位ID
   * @return
   * @since 2017年8月22日
   * @author Administrator
   */
  public static String newUUID() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }

  public static boolean isID32(String value) {
    return StringUtil.notEmpty(value) && value.length() == 32;
  }

  /**
   * 是否是指定长度的ID
   * @param len
   * @return
   * @since 2018年1月21日
   * @author Administrator
   */
  public static boolean isID(String value, int len) {
    return StringUtil.notEmpty(value) && value.length() == len;
  }
  
  public static boolean isID(String value) {
    return StringUtil.notEmpty(value) && value.length() == LENGTH;
  } 

  /**
   * 22位ID
   * @return
   * @since 2017年8月22日
   * @author Administrator
   */
  public static String newID22() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }

  /**
   * 19位ID生成
   * @return
   * @since 2017年8月22日
   * @author Administrator
   */
  public static String newID19() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }

  /**
   * 指定长度
   * @param length
   * @return
   * @since 2017年8月22日
   * @author Administrator
   */
  public static String newID(int length) {
    StringBuilder sb = new StringBuilder(length);
    SecureRandom random = new SecureRandom();
    for (int i = 0; i < length; i++) {
      sb.append(StringConstant.DIGITS64[random.nextInt(64)]);
    }
    return sb.toString();
  }

  /** 
  * @param args 
  */
  public static void main(String[] args) {
    Set<String> check = new HashSet<String>();

    // 生成2000000个随机字符串，检查是否出现重复
    for (int i = 0; i < 200000000; i++) {
      String s = newID(8);
      if (check.contains(s)) {
        throw new IllegalStateException("Repeated string found : " + s);
      } else {
        if (i % 1000 == 0)
          System.out.println("generated " + i / 1000 + "000 strings.");
        check.add(s);
      }
    }
  }
}
