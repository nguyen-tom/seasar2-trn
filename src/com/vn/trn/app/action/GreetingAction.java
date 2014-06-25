package com.vn.trn.app.action;

import org.seasar.struts.annotation.tiger.BoolType;
import org.seasar.struts.annotation.tiger.StrutsAction;
   

@StrutsAction(path = "/greeting",
              input = "/greeting.do?command=goLow",
              validate = BoolType.FALSE,
              parameter = "command")
		public interface GreetingAction {
		    String SUCCESS = "success";
		    String   ERROR = "error";
		   
		    String goGreeting ();
		    
		    String goLow();
		}