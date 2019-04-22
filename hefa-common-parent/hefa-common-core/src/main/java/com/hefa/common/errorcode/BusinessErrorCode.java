/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月15日 上午9:18:34
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
package com.hefa.common.errorcode;

import com.hefa.common.base.BaseErrorCode;

/**
 * 
 * <P>返回数据错误码</P>
 * @version 1.0
 * @author 黄智聪  2019年3月22日 上午11:57:26
 */
public class BusinessErrorCode extends BaseErrorCode{
	
	/**
	 * [40001]业务逻辑异常
	 */
	public static final BusinessErrorCode BUSINESS_ERROR_LOGIC_ABNORMAL = new BusinessErrorCode(40001, "业务逻辑异常");

	public BusinessErrorCode(int code, String message) {
		super(code, message);
	}
	
    @Override
    public String getErrorType() {
        return "业务异常";
    }

}
		
