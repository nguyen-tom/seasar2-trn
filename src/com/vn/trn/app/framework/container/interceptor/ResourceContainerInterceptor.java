package com.vn.trn.app.framework.container.interceptor;

import org.aopalliance.intercept.MethodInvocation;

import com.vn.trn.app.framework.container.RequestContext;
import com.vn.trn.app.framework.container.ResourceContainer;
import com.vn.trn.app.framework.container.impl.RequestContextImpl;

/**
 * ResourceContainer?????????????????????
 */
public class ResourceContainerInterceptor extends BaseInterceptor {

	/** serialVersionUID */
	private static final long serialVersionUID = 671587319542069545L;

	/** requestContext */
	private RequestContext requestContext = null;

	/**
	 * ?????????????????????
	 * requestContext??????
	 */
	public ResourceContainerInterceptor() {
		super();
		// Request, Response??????
// 2013/08/08 m.mochizuki start
//		S2Container container = SingletonS2ContainerFactory.getContainer();
//		requestContext = (RequestContext) container.getComponent(RequestContext.class);
		requestContext = new RequestContextImpl();
		requestContext.setRequest(request);
		requestContext.setResponse(response);
// 2013/08/08 m.mochizuki end
	}

	/**
	 * ????????????????????????
	 * @param invocation MethodInvocation
	 * @return Object ?????????
	 * @throws Throwable ????????????
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// ResourceContainer??????
		ResourceContainer resource = new ResourceContainer();
		requestContext.setResourceContainer(resource);
		Object ret;
		try {
			// Action??????
			ret = invocation.proceed();
		} finally {
			try {
				resource.release();
			} catch (Exception ex) {
				ex = null; // CheckStyle???????????????
			}
			requestContext.setResourceContainer(null);
		}
		return ret;
	}
}