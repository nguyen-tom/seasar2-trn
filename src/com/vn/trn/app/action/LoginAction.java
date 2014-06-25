package com.vn.trn.app.action;

import org.seasar.struts.annotation.tiger.BoolType;
import org.seasar.struts.annotation.tiger.StrutsAction;
import org.seasar.struts.annotation.tiger.StrutsActionForward;

@StrutsAction(path = "/login",
              input = "/login.do?command=error",
              validate = BoolType.FALSE,
              parameter = "command")
public interface LoginAction {
	
    @StrutsActionForward(path = "/WEB-INF/pages/login/login.jsp")
     public static final String LOGIN = "LOGIN";
    
    @StrutsActionForward(path = "/WEB-INF/pages/login/error.jsp")
    public static final String ERROR = "LOGIN";
    
    @StrutsActionForward(path = "/WEB-INF/pages/login/user.jsp")
    public static final String OK = "ok";
	
	public String login();
	
	public String error();
	
	
		
	
}
