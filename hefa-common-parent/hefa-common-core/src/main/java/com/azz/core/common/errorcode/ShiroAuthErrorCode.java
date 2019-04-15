/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月16日 下午6:57:17
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.core.common.errorcode;
/**
 * <P>平台用户模块错误码</P>
 * @version 1.0
 * @author 黄智聪  2018年10月16日 下午6:57:17
 */
public class ShiroAuthErrorCode extends BaseErrorCode{
    
    public static final ShiroAuthErrorCode SHIRO_AUTH_ERROR_NO_LOGIN = new ShiroAuthErrorCode(40001, "用户未登录");
    
    public static final ShiroAuthErrorCode SHIRO_AUTH_ERROR_LOGIN_ERROR = new ShiroAuthErrorCode(40002, "登录认证出错");

    public static final ShiroAuthErrorCode SHIRO_AUTH_ERROR_NO_PERMISSION = new ShiroAuthErrorCode(40003, "用户权限不足");
    
    public static final ShiroAuthErrorCode SHIRO_AUTH_ERROR_NOT_BIND_USER = new ShiroAuthErrorCode(40004, "此openid尚未绑定用户");

    public ShiroAuthErrorCode(int code, String message) {
	super(code, message);
    }
    
    @Override
    public String getErrorType() {
	return "权限认证异常";
    }

}

