/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月15日 上午9:18:34
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
package com.hefa.common.errorcode;

import com.hefa.common.base.BaseErrorCode;

/**
 * <P>系统错误码</P>
 * @version 1.0
 * @author 黄智聪（13510946256）  2018年8月29日 下午5:32:33
 */
public class SystemErrorCode extends BaseErrorCode {
    
    public static final SystemErrorCode SUCCESS = new SystemErrorCode(0, "SUCCESS");
    
    public static final SystemErrorCode SYS_ERROR_UNKNOWN = new SystemErrorCode(10000, "未知错误");
       
    public SystemErrorCode(int code, String message) {
        super(code, message);
    }

    @Override
    public String getErrorType() {
        return "系统异常";
    }
}

