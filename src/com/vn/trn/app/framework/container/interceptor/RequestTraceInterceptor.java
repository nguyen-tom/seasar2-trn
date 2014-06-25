package com.vn.trn.app.framework.container.interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

import com.vn.trn.app.framework.container.RequestContext;
import com.vn.trn.app.framework.container.impl.RequestContextImpl;

/**
 * URL????????????enter/leave???????????????Interceptor
 */
public class RequestTraceInterceptor extends BaseInterceptor {

	/** serialVersionUID */
	private static final long serialVersionUID = 671587319542069545L;

	/** Logger(log4j) */
	private static Logger log = Logger.getLogger(RequestTraceInterceptor.class);

	/** requestContext */
	private RequestContext requestContext = null;

	/**
	 * ?????????????????????
	 * requestContext, tigerBNabiAuthManager??????
	 */
	public RequestTraceInterceptor() {
		super();
		// Request, Response??????
// 2013/08/08 m.mochizuki start
//		S2Container container = SingletonS2ContainerFactory.getContainer();
//		requestContext = (RequestContext) container.getComponent(RequestContext.class);
		requestContext = new RequestContextImpl();
		requestContext.setRequest(request);
		requestContext.setResponse(response);
// 2013/08/08 m.mochizuki end
		return;
	}

	/**
	 * ????????????????????????
	 * @param invocation MethodInvocation
	 * @return Object ?????????
	 * @throws Throwable ????????????
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// ServletName??????
		String servletPath = requestContext.getServletName();
		Object ret;
		try {
			log.info("enter " + servletPath + "#"
					+ invocation.getMethod().getName() + "()");
			// Action??????
			ret = invocation.proceed();
		} finally {
			log.info("leave " + servletPath + "#"
					+ invocation.getMethod().getName() + "()");
		}
		return ret;
	}
}