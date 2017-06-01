package com.shua1.webframework.templete;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.ModelMap;

import com.shau1.constant.error.BaseErrorCode;
import com.shua1.common.exception.BusinessException;
import com.shua1.common.util.JsonUtil;
import com.shua1.webframework.model.BaseResponse;
import com.shua1.webframework.model.WebUserInfo;

public abstract class OperateTemplete implements Templete{
	private Map<String, Object> resultMap;
	private String result;
	private BaseResponse baseResponse;
	private boolean isAjax;
	private String htmlUrl;
	private ModelMap modelMap;
	
	public OperateTemplete() {
		this.resultMap = new HashMap<String, Object>();
		this.result = null;
		this.baseResponse = null;
		isAjax=true;
		this.htmlUrl=null;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public BaseResponse getBaseResponse() {
		return this.baseResponse;
	}

	public void setBaseResponse(BaseResponse baseResponse) {
		this.baseResponse = baseResponse;
	}

	public void put(String key, Object value) {
		if (modelMap != null) {
			this.modelMap.put(key, value);
		}else{
			this.resultMap.put(key, value);
		}
	}

	public void put(Map<String, Object> objMap) {
		if (objMap == null) {
			return;
		}
		if (modelMap != null) {
			this.modelMap.putAll(objMap);
		}else {
			this.resultMap.putAll(objMap);
		}
		
	}
	
	public String oprate(){
		this.result = null;
		this.baseResponse = null;
		try {
			WebUserInfo user = getWebUserInfo();
			before();
			doSomething(user);
			if (!isAjax) {
				return htmlUrl;
			}
			this.resultMap.put("retCode", BaseErrorCode.BaseErrorEnum.E0_SUCCESS.getCode());
			this.resultMap.put("retMsg", "ok");
		} catch (BusinessException e) {
			e.printStackTrace();
			this.resultMap.put("retCode", e.getCode());
			this.resultMap.put("retMsg", e.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			this.resultMap.put("retCode", BaseErrorCode.BaseErrorEnum.E_1_FAIL_SYS.getCode());
			this.resultMap.put("retMsg",
					(e.getMessage() == null) ? new Date().toString() + ": " + e.getClass() : e.getMessage());
		}

		if (this.baseResponse != null) {
			if ((this.baseResponse.getRetCode() == null) || ("".equals(this.baseResponse.getRetCode()))) {
				this.baseResponse.setRetCode(BaseErrorCode.BaseErrorEnum.E0_SUCCESS.getCode());
				this.baseResponse.setRetMsg("ok");
			}
			return JsonUtil.objectToJson(this.baseResponse);
		}
		if ((this.result != null) && (!("".equals(this.result)))) {
			return this.result;
		}
		return JsonUtil.objectToJson(this.resultMap);
	}

	public boolean isAjax() {
		return isAjax;
	}

	public void setAjax(boolean isAjax) {
		this.isAjax = isAjax;
	}

	public String getHtmlUrl() {
		return htmlUrl;
	}

	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

	public ModelMap getModelMap() {
		return modelMap;
	}

	public void setModelMap(ModelMap modelMap) {
		this.modelMap = modelMap;
	}
}
