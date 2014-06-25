package com.vn.trn.app.action.impl;

import com.vn.trn.app.action.GreetingAction;
import com.vn.trn.app.dto.GreetingDto;
import com.vn.trn.app.dto.ResponseDto;
import com.vn.trn.app.logic.GreetingLogic;

public class GreetingActionImpl implements GreetingAction {
    private GreetingLogic service;
    private GreetingDto greetingDto;
    private ResponseDto resDto;
    private String greeting;
    
    public String goGreeting () {
    	System.out.println(greetingDto.getTime());
    	resDto  = service.getGreeting (greetingDto);
       
        return SUCCESS;
    }
    public String goLow(){
    	return ERROR;
    }
    public void setGreetingService (GreetingLogic service) {
        this.service = service;
    }

    public GreetingDto getGreetingDto () {
        return greetingDto;
    }
    public ResponseDto getResDto () {
        return resDto;
    }

    public void setGreetingDto (GreetingDto greetingDto) {
        this.greetingDto = greetingDto;
    }

    public String getGreeting () {
        return greeting;
    }
}