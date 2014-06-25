package com.vn.trn.app.logic.impl;

import java.util.ArrayList;
import java.util.List;

import com.vn.trn.app.dto.GreetingDto;
import com.vn.trn.app.dto.ResponseDto;
import com.vn.trn.app.logic.GreetingLogic;

public class GreetingLogicImpl implements GreetingLogic {
    private static final String AM = "am";
    private static final String PM = "pm";

    public List getTimeList () {
        List result = new ArrayList ();
        result.add (AM);
        result.add (PM);
        return result;
    }

    public ResponseDto getGreeting (GreetingDto dto) {
    	String message = null,name = null;
        if (AM.equals (dto.getTime ())) {
             message  = "Good morning Tom";
             name = "Thom Nguyen";
            
        }
        if (PM.equals (dto.getTime ())) {
        	 message  = "Good evening Tom";
             name     = "Tom Nguyen";
        }
        ResponseDto resDto  = new ResponseDto();
        resDto.setMessage(message);
        resDto.setName(name);
        return resDto;
    }
}