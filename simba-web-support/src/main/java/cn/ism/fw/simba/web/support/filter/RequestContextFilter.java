package cn.ism.fw.simba.web.support.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ism.fw.simba.base.ResultVO;
import cn.ism.fw.simba.context.support.RequestContextManager;
import cn.ism.fw.simba.exception.IHttpCodeProvider;
import cn.ism.fw.simba.util.RequestUtil;
import cn.ism.fw.simba.util.StringUtil;
import cn.ism.fw.simba.web.HttpRequestContext;
import cn.ism.fw.simba.web.support.util.SSOUtil;

public class RequestContextFilter implements Filter {

  private static final Logger LOG = LoggerFactory.getLogger(RequestContextFilter.class);

  private static final String[] SIGN_URLS = new String[] {"/servlet/environment"};

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    LOG.debug("request context filter inited");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse resp = (HttpServletResponse) response;
    String threadName = Thread.currentThread().getName();
    try {

      // TODO:暂时未放置用户信息
      HttpRequestContext context = new HttpRequestContext(req);
      RequestContextManager.init(context);

      // 设置当前线程名称
      // 当前线程名称 WebContainer - 主机名:端口 - 当前操作用户 - 时间
      Thread.currentThread().setName(String.format("%s - {hostname - %s", threadName, "unknow"));

      chain.doFilter(request, response);
    } catch (Exception e) {
      handleException(e, req, resp);
    } finally {
      RequestContextManager.destory();
      Thread.currentThread().setName(threadName);
    }
  }

  private void handleException(Throwable t, HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String errorCode = "500";
    if (t instanceof IHttpCodeProvider) {
      errorCode = ((IHttpCodeProvider) t).getHttpCode();
    }

    String shortUrl = RequestUtil.getShortURI(req);
    if ("401".equals(errorCode) && StringUtil.inArray(SIGN_URLS, shortUrl)) {
      SSOUtil.redirectSignPage(req, resp);
      return;
    }

    resp.getWriter().write(ResultVO.EXCEPTION(t).toString());
  }

  @Override
  public void destroy() {
    LOG.debug("request context filter destory.");
  }

}
