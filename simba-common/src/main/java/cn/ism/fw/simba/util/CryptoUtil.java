package cn.ism.fw.simba.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密/解密工具类
 * 
 * @since 2017年9月25日
 * @author Administrator
 */
public class CryptoUtil {

  /*
   * begin copy of
   * http://download.igniterealtime.org/smack/dailybuilds/jacoco/org.jivesoftware.smack.util/MD5.
   * java.html
   */

  /**
   * Used by the hash method.
   */
  private static MessageDigest MD5_DIGEST;
  static {
    try {
      MD5_DIGEST = MessageDigest.getInstance(StringUtil.MD5);
    } catch (NoSuchAlgorithmException e) {
      // Smack wont be able to function normally if this exception is thrown, wrap it into
      // an ISE and make the user aware of the problem.
      throw new IllegalStateException(e);
    }
  }

  public static synchronized byte[] bytes(byte[] bytes) {
    return MD5_DIGEST.digest(bytes);
  }

  public static byte[] bytes(String string) {
    return bytes(StringUtil.toBytes(string));
  }

  public static String hex(byte[] bytes) {
    return StringUtil.encodeHex(bytes(bytes));
  }

  public static String hex(String string) {
    return hex(StringUtil.toBytes(string));
  }

  /*
   * end
   */


}
