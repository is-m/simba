package cn.ism.fw.simba.web.support.servlet;

import java.io.IOException;

import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ism.fw.simba.context.UserPrincipal;
import cn.ism.fw.simba.context.RequestContext;
import cn.ism.fw.simba.security.SecureOperation;
import cn.ism.fw.simba.security.SecurityPolicy;
import cn.ism.fw.simba.util.MimeUtil;

@Named("/servlet/rebuidSession") 
public class RebuildSessionServlet extends HttpServlet {

	private static final long serialVersionUID = -4428403273902525149L;
	private static final Logger LOG = LoggerFactory.getLogger(RebuildSessionServlet.class);

	@Override
	@SecureOperation(policy=SecurityPolicy.Logined)
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		LOG.info("execute EnviromentServlet doGet");
		UserPrincipal user = RequestContext.getCurrent().getUser(); 
		resp.setContentType(MimeUtil.HTML);
		resp.getOutputStream().print("//<script>parent.rebuildSession && parent.rebuildSession('"+user.getUsername()+"')</script>\r\n");
	}

}
