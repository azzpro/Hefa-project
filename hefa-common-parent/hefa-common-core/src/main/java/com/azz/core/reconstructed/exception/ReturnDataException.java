/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年3月22日 上午11:52:58
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.core.reconstructed.exception;

import com.azz.core.reconstructed.base.BaseException;
import com.azz.core.reconstructed.errorcode.ReturnDataErrorCode;

/**
 * <P>返回数据异常</P>
 * @version 1.0
 * @author 黄智聪  2019年3月22日 上午11:52:58
 */
public class ReturnDataException extends BaseException{

	private static final long serialVersionUID = -1490110530058331251L;
	
	/**
	 * 
	 * <p>返回数据异常</p>
	 * @param errorMsg 错误信息
	 */
	public ReturnDataException(String errorMsg) {
		super(ReturnDataErrorCode.RETURN_DATA_ERROR_DATA_ABNORMAL, errorMsg);
	}

	/**
	 * 
	 * <p>返回数据异常</p>
	 * @param errorCode 错误码（ReturnDataErrorCode）
	 * @param dataName  数据名称
	 */
	public ReturnDataException(ReturnDataErrorCode errorCode, String dataName) {
		super(errorCode, dataName, true);
	}
	
}

