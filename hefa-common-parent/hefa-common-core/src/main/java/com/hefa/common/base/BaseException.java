/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月15日 上午9:18:34
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.hefa.common.base;

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
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 6778479146569083451L;

    private BaseErrorCode errorCode;

    /**
     * 
     * <p>基础异常</p>
     * @param errorCode  错误码
     * @param extraMessage 额外错误信息
     */
    public BaseException(BaseErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    
    /**
     * 
     * <p>基础异常，额外信息默认后置</p>
     * @param errorCode  错误码
     * @param extraMessage 额外错误信息
     */
    public BaseException(BaseErrorCode errorCode, String extraMessage) {
        this(errorCode, extraMessage, false);
    }
    
    /**
     * 
     * <p>基础异常，带上其他异常</p>
     * @param errorCode  错误码
     * @param extraMessage 额外错误信息
     */
    public BaseException(BaseErrorCode errorCode, Exception e) {
        super(errorCode.getMessage(), e);
        this.errorCode = errorCode;
    }
    
	/**
	 * 
	 * <p>基础异常，带上其他异常</p>
	 * @param errorCode  错误码
	 * @param extraMessage  额外错误信息
	 * @param e 其他异常
	 */
	public BaseException(BaseErrorCode errorCode, String extraMessage, Exception e) {
        this(errorCode, extraMessage, e, false);
        this.errorCode = errorCode;
    }

    /**
     * 
     * <p>基础异常</p>
     * @param errorCode  错误码
     * @param extraMessage 额外错误信息
     * @param isExtraMessagePreposition  额外信息是否前置，默认后置
     */
	public BaseException(BaseErrorCode errorCode, String extraMessage, boolean isExtraMessagePreposition) {
		super(isExtraMessagePreposition ? ("[" + extraMessage+ "]" + errorCode.getMessage())
				: (errorCode.getMessage() + "[" + extraMessage + "]"));
		this.errorCode = errorCode;
	}
	
	/**
	 * 
	 * <p>基础异常</p>
	 * @param errorCode  错误码
	 * @param extraMessage 额外错误信息
	 * @param e 其他异常
	 * @param isExtraMessagePreposition  额外信息是否前置，默认后置
	 */
    public BaseException(BaseErrorCode errorCode, String extraMessage, Exception e, boolean isExtraMessagePreposition) {
        super(isExtraMessagePreposition ? ("[" + extraMessage + "]" + errorCode.getMessage())
				: (errorCode.getMessage() + "[" + extraMessage + "]"), e);
        this.errorCode = errorCode;
    }

}

