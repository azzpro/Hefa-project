/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月14日 上午11:16:57
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.system.vo;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年11月14日 上午11:16:57
 */
@Data
public class SmsInfo {

	private String code;
	private String msg;
	public SmsInfo(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public SmsInfo() {
		super();
	}
	
	
}

