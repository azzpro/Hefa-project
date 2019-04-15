/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月15日 上午9:18:34
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
package com.azz.core.common.errorcode;
/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪（13510946256）  2018年8月30日 上午11:02:26
 */
public class JSR303ErrorCode extends SystemErrorCode{
    
    public JSR303ErrorCode(int code, String message) {
        super(code, message);
    }

    @Override
    public String getErrorType() {
        return "输入参数异常";
    }

}

