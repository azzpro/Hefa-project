/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月15日 上午9:18:34
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
package com.azz.core.reconstructed.errorcode;

import com.azz.core.reconstructed.base.BaseErrorCode;

/**
 * <P>JSR303校验错误码</P>
 * @version 1.0
 * @author 黄智聪（13510946256）  2018年8月30日 上午11:02:26
 */
public class ValidationErrorCode extends BaseErrorCode{

	/**
	 * [20001]请求参数无效
	 */
	public static final ValidationErrorCode VALIDATION_ERROR_INVALID_REQUEST_PARAM = new ValidationErrorCode(20001, "请求参数无效"); 
	
	/**
	 * [20002]缺少请求参数
	 */
	public static final ValidationErrorCode VALIDATION_ERROR_MISSING_REQUEST_PARAM = new ValidationErrorCode(20002, "缺少请求参数"); 
	
	public ValidationErrorCode(int code, String message) {
		super(code, message);
	}
	
    @Override
    public String getErrorType() {
        return "校验异常";
    }

}

