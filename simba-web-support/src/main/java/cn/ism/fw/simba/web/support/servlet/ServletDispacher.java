package cn.ism.fw.simba.web.support.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ism.fw.simba.util.RequestUtil;
import cn.ism.fw.simba.util.SpringUtil;

/**
 * Servlet 转发器
 * 集中管理servlet（包含权限）
 * @since 2017年8月16日
 * @author Administrator
 */
public class ServletDispacher extends HttpServlet {
 
	private static final long serialVersionUID = 6984194088064838885L;
	
	private static final Logger LOG = LoggerFactory.getLogger(ServletDispacher.class);

	@Override
	public void init(ServletConfig config) throws ServletException {  
		Map<String,Servlet> servletMap = SpringUtil.getContext().getBeansOfType(Servlet.class);
		for(Servlet servlet : servletMap.values()){
			servlet.init(config);
		}
	} 
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = RequestUtil.getShortURI(req);
		LOG.debug("call servlet by short uri : {}",uri);
		Servlet servlet = SpringUtil.getContext().getBean(uri, Servlet.class);
		// 任何需要拦截权限的Servlet必须使用HttpServlet.service方法，否则无法拦截
		servlet.service(req, resp);
	}
	 
}
