package cn.ism.fw.simba.util;

public class NumberUtil {

  /**
   * intParse
   * @param text
   * @param defaultValue
   * @return
   * @since 2018年3月7日
   * @author Administrator
   */
  public static Integer parse(String text, Integer defaultValue) {
    try {
      return Integer.valueOf(text);
    } catch (Exception e) {
      return defaultValue;
    }
  }
  
  public static boolean isNumber(String text) {
    return parse(text,null) != null;
  }
}
