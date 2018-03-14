package cn.ism.fw.simba.util;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 字符串工具类
 * 
 * @since 2017年5月7日
 * @author Administrator
 */
public class StringUtil {

  public static final String MD5 = "MD5";
  public static final String SHA1 = "SHA-1";
  public static final String UTF8 = "UTF-8";
  public static final String USASCII = "US-ASCII";

  public static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();

  /**
   * 数组合并
   * 
   * @param source
   * @param more
   * @return
   * @since 2017年5月7日
   * @author Administrator
   */
  public static String[] merge(String[] source, String... more) {
    int sourceLength = source == null ? 0 : source.length;
    int moreLength = more == null ? 0 : more.length;
    String[] result = new String[sourceLength + moreLength];
    if (result.length > 0) {
      int resultIndex = 0;
      for (String sourceItem : source) {
        result[resultIndex++] = sourceItem;
      }
      for (String moreItem : more) {
        result[resultIndex++] = moreItem;
      }
    }
    return result;
  }

  public static boolean isEmpty(String string) {
    return string == null || string.trim().length() == 0;
  }

  /**
   * 连接字符串
   * 
   * @param array
   * @return
   * @since 2017年8月7日
   * @author Administrator
   */
  public static String join(String... array) {
    if (ObjectUtil.isEmpty(array)) {
      return "";
    }

    StringBuilder sb = new StringBuilder(array[0]);

    for (int i = 1, j = array.length; i < j; i++) {
      sb.append(",").append(array[i]);
    }
    return sb.toString();
  }

  /**
   * 连接字符串
   * 
   * @param array
   * @return
   * @since 2017年8月7日
   * @author Administrator
   */
  public static String concat(Object... array) {
    if (ObjectUtil.isEmpty(array)) {
      return "";
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0, j = array.length; i < j; i++) {
      sb.append(array[i]);
    }
    return sb.toString();
  }

  public static String upper(String string) {
    return isEmpty(string) ? string : string.toUpperCase();
  }

  public static boolean equals(String a, String b, boolean igroneUpperOrLowerCase) {
    if (a == null && b == null)
      return true;
    return a != null ? upper(a).contains(upper(b)) : upper(b).contains(upper(a));
  }

  public static boolean inArray(String[] range, String value) {
    if (value == null)
      return false;

    for (String item : range) {
      if (value.equals(item)) {
        return true;
      }
    }
    return false;
  }

  public static boolean notEmpty(String string) {
    return string != null && string.trim().length() > 0;
  }

  /**
   * 参数非空
   * 
   * @param strings
   * @return
   * @since 2017年9月25日
   * @author Administrator
   */
  public static boolean notEmptyAll(String... strings) {
    for (String string : strings) {
      if (string == null || string.trim().length() == 0) {
        return false;
      }
    }
    return true;
  }
  
  public static String[] split(String source,String splitString,boolean removeEmpty) {
    Assert.notEmpty(source, "参数 source不能为空");
    Assert.notEmpty(splitString, "参数 splitString不能为空");
    List<String> result = new ArrayList<>();
    String[] arr = source.split(splitString);
    for(String str : arr) {
      if(!StringUtil.isEmpty(str)) {
        result.add(str);
      }
    }
    return result.toArray(new String[result.size()]);
  }


  /*
   * begin
   * 下面的工具方法来源于 
   * http://download.igniterealtime.org/smack/dailybuilds/jacoco/org.jivesoftware.smack.util/StringUtils.java.html  
   */
  
  /**
   * Encodes an array of bytes as String representation of hexadecimal.
   *
   * @param bytes an array of bytes to convert to a hex string.
   * @return generated hex string.
   */
  public static String encodeHex(byte[] bytes) {
    char[] hexChars = new char[bytes.length * 2];
    for (int j = 0; j < bytes.length; j++) {
      int v = bytes[j] & 0xFF;
      hexChars[j * 2] = HEX_CHARS[v >>> 4];
      hexChars[j * 2 + 1] = HEX_CHARS[v & 0x0F];
    }
    return new String(hexChars);
  }

  public static byte[] toBytes(String string) {
    try {
      return string.getBytes(UTF8);
    } catch (UnsupportedEncodingException e) {
      throw new IllegalStateException("UTF-8 encoding not supported by platform", e);
    }
  }
  
  /*
   * end
   */
  
  public static String format(String source,Object... params) {
    return MessageFormat.format(source, params);
  }
}
