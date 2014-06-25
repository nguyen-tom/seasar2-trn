package com.vn.trn.app.logic;

import java.util.List;

import com.vn.trn.app.dto.GreetingDto;
import com.vn.trn.app.dto.ResponseDto;

public interface GreetingLogic {
	List getTimeList();

	ResponseDto getGreeting(GreetingDto dto);
}