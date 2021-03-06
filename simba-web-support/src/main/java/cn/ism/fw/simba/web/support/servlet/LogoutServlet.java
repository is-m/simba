package cn.ism.fw.simba.web.support.servlet;

import java.io.IOException;

import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ism.fw.simba.security.SecureOperation;
import cn.ism.fw.simba.security.SecurityPolicy;

@Named("/servlet/logout") 
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = -4428403273902525149L;
	private static final Logger LOG = LoggerFactory.getLogger(LogoutServlet.class);

	@Override
	@SecureOperation(policy=SecurityPolicy.Logined)
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		LOG.info("execute EnviromentServlet doGet");
		//IUser user = RequestContext.getCurrent().getUser();
		/*
		 * if(user == null){ throw new NoAuthenticationException(); }
		 */

		res.getOutputStream().print("workspaceVO=null;");
	}

}
