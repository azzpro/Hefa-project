/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月14日 下午4:39:15
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.exception;

import com.azz.core.common.errorcode.BaseErrorCode;
import com.azz.core.exception.BaseException;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年11月14日 下午4:39:15
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SmsException extends BaseException{
	private String msg;
	/**
	 * TODO
	 */
	private static final long serialVersionUID = 8284662165929215826L;

	public SmsException(BaseErrorCode errorCode) {
		super(errorCode);
	}

}

