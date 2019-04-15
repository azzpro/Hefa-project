/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月17日 下午3:59:17
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.core.exception;

import com.azz.core.common.errorcode.ShiroAuthErrorCode;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年10月17日 下午3:59:17
 */
public class ShiroAuthException extends BaseException{

    private static final long serialVersionUID = 1033118360269922189L;

    public ShiroAuthException(ShiroAuthErrorCode errorCode) {
	super(errorCode);
    }

    public ShiroAuthException(ShiroAuthErrorCode errorCode, String extraMessage) {
	super(errorCode, extraMessage);
    }
    
}

