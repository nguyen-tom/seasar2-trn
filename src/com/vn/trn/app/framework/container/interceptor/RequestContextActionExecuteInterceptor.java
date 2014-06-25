package com.vn.trn.app.framework.container.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

import com.vn.trn.app.framework.container.RequestContext;


/**
 * RequestContextActionPerformInterceptor
 * RequestContext???RequestProcessor#processActionPerform()???????????????????????????
 */
public class RequestContextActionExecuteInterceptor implements MethodInterceptor {

	/** requestContext */
	private RequestContext requestContext = null;

	/** ??????????????????????????? */
	@SuppressWarnings("rawtypes")
	private Class[] argTypes = { HttpServletRequest.class,
			HttpServletResponse.class, Object.class, ActionForm.class,
			ActionMapping.class };

	/**
	 * ?????????????????????
	 * requestContext??????
	 */
	public RequestContextActionExecuteInterceptor() {
		super();
		// Request, Response??????
		S2Container container = SingletonS2ContainerFactory.getContainer();
		requestContext = (RequestContext) container.getComponent(RequestContext.class);
	}

	/**
	 * ????????????????????????
	 * @param invocation MethodInvocation
	 * @return Object ?????????
	 * @throws Throwable ????????????
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] args = invocation.getArguments();
		// ??????????????????
		if (args.length != argTypes.length) {
			System.err.println(getClass().getName() + ": args.length(" + args.length + ") invalid.");
		}
		for (int i = 0; i < argTypes.length; i++) {
			if (!argTypes[i].isInstance(args[i])) {
				if (args[i] == null) {
					System.err.println(getClass().getName() + ": args[" + i + "] is null.");
				} else {
					System.err.println(getClass().getName() + ": args[" + i
							+ "](" + args[i].getClass().getName() + ") is not "
							+ argTypes[i].getName());
				}
			}
		}
		HttpServletRequest request = (HttpServletRequest) args[0];
		HttpServletResponse response = (HttpServletResponse) args[1];
		Object action = (Object) args[2];
		ActionForm form = (ActionForm) args[3];
		ActionMapping mapping = (ActionMapping) args[4];
		requestContext.setRequest(request);
		requestContext.setResponse(response);
		requestContext.setAction(action);
		requestContext.setActionForm(form);
		requestContext.setActionMapping(mapping);
		Object ret;
		try {
			ret = invocation.proceed();
		} finally {
			requestContext.setRequest(null);
			requestContext.setResponse(null);
			requestContext.setAction(null);
			requestContext.setActionForm(null);
			requestContext.setActionMapping(null);
		}
		return ret;
	}
}