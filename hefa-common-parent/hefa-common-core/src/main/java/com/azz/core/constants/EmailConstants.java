/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年12月13日 下午1:43:55
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.core.constants;
/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年12月13日 下午1:43:55
 */
public class EmailConstants {
	
	public static final String EMAIL_SUBJECT = "爱智造平台验证码邮件";
	
	public static final String EMAIL_SEND_SUCCESS = "0000";
	
	public static final String EMAIL_SEND_FAILED = "9999";
	
	public static final String EMAIL_SEND_FAILED_MSG = "邮件发送失败";
	
	public static final String EMAIL_SEND_SUCCESS_MSG = "邮件发送成功";
	
	public static final String EMAIL_CONTENT_PERFIX = "尊敬的爱智造用户，您的验证码为：${code}";
}

