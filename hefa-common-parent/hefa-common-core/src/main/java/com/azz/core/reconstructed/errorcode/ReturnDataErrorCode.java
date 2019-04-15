/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月15日 上午9:18:34
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
package com.azz.core.reconstructed.errorcode;

import com.azz.core.reconstructed.base.BaseErrorCode;

/**
 * 
 * <P>返回数据错误码</P>
 * @version 1.0
 * @author 黄智聪  2019年3月22日 上午11:57:26
 */
public class ReturnDataErrorCode extends BaseErrorCode{
	
	/**
	 * [30001]数据异常
	 */
	public static final ReturnDataErrorCode RETURN_DATA_ERROR_DATA_ABNORMAL = new ReturnDataErrorCode(30001, "数据异常");

	/**
	 * [30002]数据不存在
	 */
	public static final ReturnDataErrorCode RETURN_DATA_ERROR_DATA_NOT_EXIST = new ReturnDataErrorCode(30002, "数据不存在"); 

	/**
	 * [30003]数据已存在
	 */
	public static final ReturnDataErrorCode RETURN_DATA_ERROR_DATA_ALREADY_EXIST = new ReturnDataErrorCode(30003, "数据已存在"); 

	public ReturnDataErrorCode(int code, String message) {
		super(code, message);
	}
	
    @Override
    public String getErrorType() {
        return "返回数据异常";
    }

}

