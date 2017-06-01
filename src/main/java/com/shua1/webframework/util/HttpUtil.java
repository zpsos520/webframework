package com.shua1.webframework.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

public class HttpUtil {
	public static boolean isAjaxRequest(HttpServletRequest request){
		if (request == null) {
			return false;
		}
		String requestType = request.getHeader("X-Requested-With"); 
		if (!StringUtils.isEmpty(requestType) && requestType.equals("XMLHttpRequest")) {
			return true;
		}else{
			return false;
		}
	}
}
