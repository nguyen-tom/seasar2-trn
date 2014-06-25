package com.vn.trn.app.dao;

import org.seasar.dao.annotation.tiger.Arguments;
import org.seasar.dao.annotation.tiger.S2Dao;

import com.vn.trn.app.dto.UserMasterDto;
import com.vn.trn.app.entity.Entity;

@S2Dao(bean = Entity.class)
public interface UserDao {

	@Arguments({ "user_name", "password" })
	public UserMasterDto getUser(String user_name, String password)
			throws Exception;
}
