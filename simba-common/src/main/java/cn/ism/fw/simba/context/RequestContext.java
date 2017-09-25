package cn.ism.fw.simba.context;

import cn.ism.fw.simba.context.support.RequestContextManager;

public abstract class RequestContext {

	private UserPrincipal user;

	public UserPrincipal getUser() {
		return user;
	}

	public void setUser(UserPrincipal user) {
		this.user = user;
	}
	
	public static RequestContext getCurrent() throws NoRequestContextException{
		return getCurrent(false);
	}
	
	public static RequestContext getCurrent(boolean allowNull) throws NoRequestContextException{
		RequestContext rc = RequestContextManager.get();
		if(rc == null && !allowNull){
			throw new NoRequestContextException();
		}
		return rc;
	}
}
