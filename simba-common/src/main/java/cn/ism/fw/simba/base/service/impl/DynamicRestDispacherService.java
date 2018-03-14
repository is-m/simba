package cn.ism.fw.simba.base.service.impl;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ism.fw.simba.base.PageVO;
import cn.ism.fw.simba.base.PagedResult;
import cn.ism.fw.simba.base.service.IBaseService;
import cn.ism.fw.simba.base.service.impl.DynamicQueryMeta.QueryType;
import cn.ism.fw.simba.log.LogFactory;
import cn.ism.fw.simba.util.JSONUtil;
import cn.ism.fw.simba.util.RequestUtil;

/**
 * 动态Rest开放服务
 * @since 2018年1月21日
 * @author Administrator
 */
@Component
@RestController
@RequestMapping("/api")
public class DynamicRestDispacherService {

  private static final Logger LOG = LogFactory.getLogger();

  @Inject
  private EntityServiceHolder entityServiceHolder;

  public DynamicRestDispacherService() {
    LOG.info("DynamicRestDispacherService inited");
  }

  /**
   * 查询入口
   */
  @GetMapping("/**")
  public Object doGet(HttpServletRequest req, HttpServletResponse resp) {
    String shortUri = RequestUtil.getShortURI(req);
    LOG.info("execute doGet for url = {}", shortUri);


    // 解析路径，/{resource}/{id}/{relation}/{id}/{relation}?use=name,value&include=Role&filter[name]=&sort[name]=asc
    // get api/userGroup
    // 最多只支持两层关系
    DynamicQueryMeta meta = DynamicMetaFactory.getQueryMeta(req, resp);
    LOG.info("获取到的查询参数:{}", meta + "");
    IBaseService entityService = entityServiceHolder.getEntityService(meta.getResource());

    LOG.info("查询参数 {}", meta);
    switch (meta.getQueryType()) {
      case PageList:
        // 解析翻页参数
        PagedResult pageData = entityService.getPageData(meta.getPage(), null);
        return pageData;
      case List:
        return entityService.getAll(null);
      case Detail:
        return entityService.getOne(meta.getFilters().get("id"));
      default:
        throw new IllegalArgumentException("不能识别的操作");
    }
  }

  /**
   * 创建入口
   */
  @PostMapping("/**")
  public Object doPost(HttpServletRequest request, HttpServletResponse resp) {
    String shortUri = RequestUtil.getShortURI(request);
    LOG.info("execute doPost for url = {}", shortUri);

    return null;
  }

  /**
   * 新增入口
   */
  @PutMapping("/**")
  public Object doPut(HttpServletRequest request, HttpServletResponse resp) {
    String shortUri = RequestUtil.getShortURI(request);
    LOG.info("execute doPut for url = {}", shortUri);

    return null;
  }

  /**
   * 删除入口
   */
  @DeleteMapping("/**")
  public Object doDelete(HttpServletRequest request, HttpServletResponse resp) {
    LOG.info("execute doDelete for url = {}", request.getRequestURI());

    return null;
  }

  /**
   * 批量处理入口
   * @param request
   * @param resp
   * @return
   * @since 2018年1月21日
   * @author Administrator
   */
  @PostMapping("/*/batch")
  public Object doBatch(HttpServletRequest request, HttpServletResponse resp) {
    LOG.info("execute DynamicRestDispacherService.doBatch for url = {}", request.getRequestURI());

    return null;
  }

  public class PathPattern {

  }
}
