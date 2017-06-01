package com.shua1.common.exception;

public class BaseException extends RuntimeException
{
  private String module;
  private String code;
  private Object[] args;
  private String defaultMessage;
  
  public BaseException(String module, String code, Object[] args, String defaultMessage)
  {
    this.module = module;
    this.code = code;
    this.args = args;
    this.defaultMessage = defaultMessage;
  }
  
  public BaseException(String module, String code, Object[] args)
  {
    this(module, code, args, null);
  }
  
  public BaseException(String module, String defaultMessage)
  {
    this(module, null, null, defaultMessage);
  }
  
  public BaseException(String code, Object[] args)
  {
    this(null, code, args, null);
  }
  
  public BaseException(String defaultMessage)
  {
    this(null, null, null, defaultMessage);
  }
  
  public String getMessage()
  {
    String message = null;
    if ((this.code != null) && (!"".equals(this.code)))
    {
      message = this.code + " : ";
      for (Object object : this.args) {
        message = message + "," + object.toString();
      }
    }
    if (message == null) {
      message = this.defaultMessage;
    }
    return message;
  }
  
  public String getModule()
  {
    return this.module;
  }
  
  public String getCode()
  {
    return this.code;
  }
  
  public Object[] getArgs()
  {
    return this.args;
  }
  
  public String getDefaultMessage()
  {
    return this.defaultMessage;
  }
  
  public String toString()
  {
    return getClass() + "{" + "module='" + this.module + '\'' + ", message='" + getMessage() + '\'' + '}';
  }
}
