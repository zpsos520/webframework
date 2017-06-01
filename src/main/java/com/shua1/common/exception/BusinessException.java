package com.shua1.common.exception;

import com.shau1.constant.error.ErrorBaseEnum;

public class BusinessException extends Exception
{
  private static final long serialVersionUID = 1852959379290665613L;
  private String code;
  private String msg;
  
  public BusinessException() {}
  
  public BusinessException(ErrorBaseEnum error)
  {
    super(error.getMsg());
    this.msg = error.getMsg();
    this.code = error.getCode();
  }
  
  public BusinessException(ErrorBaseEnum error, String message)
  {
    super(error.getMsg() + " : " + message);
    this.msg = (error.getMsg() + " : " + message);
    this.code = error.getCode();
  }
  
  public BusinessException(String code, String message)
  {
    super(message);
    this.msg = message;
    this.code = code;
  }
  
  public BusinessException(Throwable cause)
  {
    super(cause);
  }
  
  public BusinessException(String message, Throwable cause)
  {
    super(message, cause);
    this.msg = message;
  }
  
  public BusinessException(String code, String message, Throwable cause)
  {
    super(message, cause);
    this.msg = message;
    this.code = code;
  }
  
  public String getCode()
  {
    return this.code;
  }
  
  public void setCode(String code)
  {
    this.code = code;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public void setMsg(String msg)
  {
    this.msg = msg;
  }
}
