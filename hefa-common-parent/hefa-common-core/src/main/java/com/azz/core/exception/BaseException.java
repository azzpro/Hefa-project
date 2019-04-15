/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月15日 上午9:18:34
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.azz.core.exception;

import com.azz.core.common.errorcode.BaseErrorCode;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <P>
 * 异常基类
 * </P>
 * 
 * @version 1.0
 * @author 黄智聪（13510946256） 2018年8月30日 上午11:43:08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 6778479146569083451L;

    private BaseErrorCode errorCode;

    public BaseException(BaseErrorCode errorCode) {
        super(errorCode.toString());
        this.errorCode = errorCode;
    }

    public BaseException(BaseErrorCode errorCode, String extraMessage) {
        super(errorCode.toString() + "," + extraMessage);
        this.errorCode = errorCode;
    }

    public BaseException(BaseErrorCode errorCode, Exception e) {
        super(errorCode.toString(), e);
        this.errorCode = errorCode;
    }

    public BaseException(BaseErrorCode errorCode, String extraMessage, Exception e) {
        super(errorCode.toString() + "," + extraMessage, e);
        this.errorCode = errorCode;
    }

}

