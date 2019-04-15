/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月15日 上午9:18:34
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.hefa.common.base;

import lombok.Getter;

/**
 * <P>
 * 错误码基类
 * </P>
 * 
 * @version 1.0
 * @author 黄智聪（13510946256） 2018年8月29日 上午11:27:01
 */
public abstract class BaseErrorCode {
    
    @Getter
    private int code;

    @Getter
    private String message;
    
    public BaseErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    
    @Override
    public String toString() {
        return "[" + this.code + "]" + this.message;
    }

    /**
     * 
     * <p>获取错误类型</p>
     * @return 错误类型
     * @author 黄智聪（13510946256）  2018年8月30日 上午9:51:32
     */
    public abstract String getErrorType();
    
    
}

