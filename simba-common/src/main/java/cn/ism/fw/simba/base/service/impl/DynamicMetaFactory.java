package cn.ism.fw.simba.base.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ism.fw.simba.util.RequestUtil;

public class DynamicMetaFactory {

  public static DynamicQueryMeta getQueryMeta(HttpServletRequest req,HttpServletResponse resp) {
    DynamicQueryMeta meta = new DynamicQueryMeta();
    meta.setRequest(req);
    meta.setResponse(resp);
    
    String shortUri = RequestUtil.getShortURI(req);
    
    // 解析路径，/{resource}/{id}/{relation}/{id}/{relation}?use=name,value&include=Role&filter[name]=&sort[name]=asc
    // get api/userGroup
    // 最多只支持两层关系
    String[] paths = shortUri.split("/");
    meta.setResource(paths[2]);
    
    return meta;
  }
}
