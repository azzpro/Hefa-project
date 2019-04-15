/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月14日 下午4:02:24
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.util;

import com.azz.core.constants.SmsConstants;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年11月14日 下午4:02:24
 */
public class SmsInfoUtil {
	
	public static SmsConstants getSmsConstants(int msgType) {
		SmsConstants[] values = SmsConstants.values();
		for (SmsConstants smsConstants : values) {
			if(smsConstants.getMsgType() != null && smsConstants.getMsgType() == msgType) {
				return smsConstants;
			}
		}
		return null;
	}
}

