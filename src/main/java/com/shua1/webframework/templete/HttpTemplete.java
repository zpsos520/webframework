package com.shua1.webframework.templete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;

import com.shua1.webframework.util.HttpUtil;

public abstract class HttpTemplete extends OperateTemplete{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private boolean flag = true;
	
	
	public HttpTemplete(HttpServletRequest request) {
		this.request = request;
		this.flag = true;
		this.setAjax(HttpUtil.isAjaxRequest(request));
	}

	public HttpTemplete(HttpServletRequest request, boolean flag, ModelMap modelMap) {
		this.request = request;
		this.flag = flag;
		this.setAjax(HttpUtil.isAjaxRequest(request));
		this.setModelMap(modelMap);
	}

	public HttpTemplete(HttpServletRequest request, HttpServletResponse response, boolean flag, ModelMap modelMap) {
		this.request = request;
		this.response = response;
		this.flag = flag;
		this.setAjax(HttpUtil.isAjaxRequest(request));
		this.setModelMap(modelMap);
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
