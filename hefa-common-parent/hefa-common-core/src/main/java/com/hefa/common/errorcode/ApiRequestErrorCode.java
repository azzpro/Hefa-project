/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月16日 下午6:57:17
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.hefa.common.errorcode;

import com.hefa.common.base.BaseErrorCode;

/**
 * <P>
 * 平台用户模块错误码
 * </P>
 * 
 * @version 1.0
 * @author 黄智聪 2018年10月16日 下午6:57:17
 */
public class ApiRequestErrorCode extends BaseErrorCode {


	public static final ApiRequestErrorCode API_REQUEST_ERROR_ILLEGAL_REQUEST = new ApiRequestErrorCode(70001, "非法请求");
	
	public static final ApiRequestErrorCode API_REQUEST_ERROR_NO_LOGIN = new ApiRequestErrorCode(70002, "用户未登录或登录已失效");
	
	public static final ApiRequestErrorCode API_REQUEST_ERROR_OTHER_PLACE_LOGIN = new ApiRequestErrorCode(70003, "账号已在其他地方登录，被迫下线");

	public static final ApiRequestErrorCode API_REQUEST_ERROR_LOGIN_ERROR = new ApiRequestErrorCode(70004, "登录认证出错");

	public ApiRequestErrorCode(int code, String message) {
		super(code, message);
	}

	@Override
	public String getErrorType() {
		return "API请求异常";
	}

}
