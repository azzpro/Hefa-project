/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年8月30日 上午10:58:40
 * Copyright (c) 2008 - 2011.深圳市齐采科技有限公司版权所有. 粤ICP备16034195号
 * 注意：本内容仅限于深圳市齐采科技服务有限公司内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.common.exception;

import com.hefa.common.base.BaseException;
import com.hefa.common.errorcode.ValidationErrorCode;

/**
 * <P>JSR303校验异常</P>
 * @version 1.0
 * @author 黄智聪（13510946256）  2018年8月30日 上午10:58:40
 */
public class ValidationException extends BaseException{

    private static final long serialVersionUID = -3668174848129201433L;
    
    /**
     * 
     * <p>参数校验异常</p>
     * @param validateMessage
     */
    public ValidationException(String validateMessage) {
        super(ValidationErrorCode.VALIDATION_ERROR_INVALID_REQUEST_PARAM, validateMessage);
    }
    
    /**
     * 
     * <p>其他校验异常</p>
     * @param errorCode
     */
    public ValidationException(ValidationErrorCode errorCode) {
        super(errorCode);
    }
    
}

