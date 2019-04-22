/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月20日 下午3:46:49
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.common.exception;

import com.hefa.common.base.BaseException;
import com.hefa.common.errorcode.BusinessErrorCode;

/**
 * <P>业务异常</P>
 * @version 1.0
 * @author 黄智聪  2019年4月20日 下午3:46:49
 */
public class BusinessException extends BaseException{

	private static final long serialVersionUID = -8224597370593594969L;

	public BusinessException(String message) {
		super(BusinessErrorCode.BUSINESS_ERROR_LOGIC_ABNORMAL, message);
	}

}

