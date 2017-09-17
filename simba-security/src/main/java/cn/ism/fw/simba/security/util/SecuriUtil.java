package cn.ism.fw.simba.security.util;

import cn.ism.fw.simba.util.Assert;

public class SecuriUtil {

  /**
   * 根据权限点获取父权限点
   * @param permissionCode
   * @return
   * @since 2017年9月5日
   * @author Administrator
   */
  public static String getParentPermissionCode(String permissionCode) {
    Assert.empty(permissionCode, "permissionCode not be null or empty");

    int lastSplitPos = permissionCode.lastIndexOf(SecuriConstant.SPLITTER);
    Assert.isTrue(lastSplitPos < 4, "not parent of permissionCode::{0}", permissionCode);

    return permissionCode.substring(0, lastSplitPos);
  }
}
