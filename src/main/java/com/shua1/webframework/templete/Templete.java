package com.shua1.webframework.templete;

import com.shua1.common.exception.BusinessException;
import com.shua1.webframework.model.WebUserInfo;

public interface Templete {
	void before() throws BusinessException;
	
	void doSomething(WebUserInfo webUserInfo) throws BusinessException;
	
	WebUserInfo getWebUserInfo() throws BusinessException;
	
	String oprate();
}
