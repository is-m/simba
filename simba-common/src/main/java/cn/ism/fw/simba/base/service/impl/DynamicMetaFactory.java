package cn.ism.fw.simba.base.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.Assert;

import cn.ism.fw.simba.base.PageVO;
import cn.ism.fw.simba.base.service.impl.DynamicQueryMeta.QueryType;
import cn.ism.fw.simba.util.IDUtil;
import cn.ism.fw.simba.util.NumberUtil;
import cn.ism.fw.simba.util.RequestUtil;
import cn.ism.fw.simba.util.StringUtil;

public class DynamicMetaFactory {

  public static DynamicQueryMeta getQueryMeta(HttpServletRequest req, HttpServletResponse resp) {
    DynamicQueryMeta meta = new DynamicQueryMeta();
    meta.setRequest(req);
    meta.setResponse(resp);

    String shortUri = RequestUtil.getShortURI(req);

    // 解析路径，/{resource}/{id}/{relation}/{id}/{relation}?use=name,value&include=Role&filter[name]=&sort[name]=asc
    // get api/userGroup
    // 最多只支持两层关系
    String[] paths = shortUri.split("/");
    meta.setResource(paths[2]);
    Map<String, Object> filters = new HashMap<>();
    meta.setFilters(filters);
    parse(req, meta);
    
    String include = req.getParameter("include");
    if(StringUtil.notEmpty(include)) {
      meta.setIncludes(StringUtil.split(include, ",", true));
    }
    
    String field = req.getParameter("field");
    if(StringUtil.notEmpty(field)) {
      meta.setFields(StringUtil.split(field, ",", true));
    }
    
    switch (paths.length) {
      case 3:
        meta.setQueryType(QueryType.PageList);
        break;
      case 4:
        String p4 = paths[3];
        if ("all".equals(p4)) {
          meta.setQueryType(QueryType.List);
        } else if (IDUtil.isID32OrNumber(p4)) {
          meta.setQueryType(QueryType.Detail);
          filters.put("id", p4);
        } else {
          throw new IllegalArgumentException("不支持的操作，请检查请求类型或者参数是否错误");
        }
        break;
      case 5:

        break;
      default:
        throw new IllegalArgumentException("不支持的操作，请检查请求类型或者参数是否错误");
    }

    if (meta.getQueryType() == QueryType.PageList) {
      int curPage = NumberUtil.parse(req.getParameter("curPage"), 1);
      int pageSize = NumberUtil.parse(req.getParameter("pageSize"), 15);
      meta.setPage(new PageVO(curPage, pageSize));
    }

    return meta;
  }


  // matcher.group 函数可以获取括号中的内容，例如 aaa(\\d+) group() 获取 aaa任务数值，group(0) 获取aaa后面的数值
  private static final Pattern filterPattern = Pattern.compile("filter\\[(\\S*)\\]");
  private static final Pattern sortPattern = Pattern.compile("sort\\[(\\S*)\\]");

  private static void parse(HttpServletRequest req, DynamicQueryMeta meta) {
    Map<String, String[]> parameterMap = req.getParameterMap();
    Matcher matcher;
    for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
      String[] value = entry.getValue();
      String queryName = entry.getKey();
      matcher = filterPattern.matcher(queryName);
      if (matcher.find()) {
        Assert.isTrue(matcher.groupCount() == 1, "参数解析错误，不能识别的参数 " + queryName);
        String key = matcher.group(1);
        meta.getFilters().put(key, value);
        continue;
      }

      matcher = sortPattern.matcher(queryName);
      if (matcher.find()) {
        Assert.isTrue(matcher.groupCount() == 1, "参数解析错误，不能识别的参数 " + queryName);
        String key = matcher.group(1);
        meta.getSort().put(key, StringUtil.isEmpty(value[0]) ? "asc" : value[0]);
        continue;
      }
    }
  }
}
