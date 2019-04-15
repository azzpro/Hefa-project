/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月16日 下午6:57:17
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.core.common.errorcode;
/**
 * <P>平台用户模块错误码</P>
 * @version 1.0
 * @author 黄智聪  2018年10月16日 下午6:57:17
 */
public class SmsErrorCode extends BaseErrorCode{
    
    public static final SmsErrorCode SMS_ERROR_TOO_QUICK = new SmsErrorCode(20001, "短信发送太频繁");
    
    public static final SmsErrorCode SMS_ERROR_TYPE_NOT_EXIST = new SmsErrorCode(20001, "短信类型不存在");
    
    public static final SmsErrorCode SMS_ERROR_SEND_ERROR = new SmsErrorCode(20001, "短信发送失败");
    
    public static final SmsErrorCode SMS_ERROR_MSG_NOT_EXIST = new SmsErrorCode(20001, "无此短信记录");
    
    public SmsErrorCode(int code, String message) {
	super(code, message);
    }

    @Override
    public String getErrorType() {
	return "平台用户异常";
    }

}

