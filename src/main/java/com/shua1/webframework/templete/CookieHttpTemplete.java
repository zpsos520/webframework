package com.shua1.webframework.templete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;

import com.shua1.common.exception.BusinessException;
import com.shua1.webframework.model.BaseRequest;
import com.shua1.webframework.model.WebUserInfo;

public abstract class CookieHttpTemplete extends HttpTemplete{
	
	private BaseRequest baseRequest;
	
	public CookieHttpTemplete(HttpServletRequest request,HttpServletResponse response,BaseRequest baseRequest){
		super(request, response,true ,null);
		this.setBaseRequest(baseRequest);
	}
	
	public CookieHttpTemplete(HttpServletRequest request,HttpServletResponse response,BaseRequest baseRequest,ModelMap modelMap){
		super(request, response, true ,modelMap);
		this.setBaseRequest(baseRequest);
	}
	
	public CookieHttpTemplete(HttpServletRequest request,HttpServletResponse response,BaseRequest baseRequest,boolean flag,ModelMap modelMap){
		super(request, response,flag,modelMap);
		this.setBaseRequest(baseRequest);
	}

	public WebUserInfo getWebUserInfo() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public BaseRequest getBaseRequest() {
		return baseRequest;
	}

	public void setBaseRequest(BaseRequest baseRequest) {
		this.baseRequest = baseRequest;
	}

}
