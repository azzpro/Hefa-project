/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月14日 下午1:57:08
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.common.constants;
/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年11月14日 下午1:57:08
 */
public enum SmsErrorCode {
	
	RAM_PERMISSION_DENY("isp.RAM_PERMISSION_DENY","RAM权限DENY"),
	
	OUT_OF_SERVICE("isv.OUT_OF_SERVICE","业务停机"),
	
	SEND_OF_FAILED("isv.OUT_OF_SERVICE","发送失败"),
	
	PRODUCT_UN_SUBSCRIPT("isv.PRODUCT_UN_SUBSCRIPT","未开通云通信产品的阿里云客户"),
	
	PRODUCT_UNSUBSCRIBE("isv.PRODUCT_UNSUBSCRIBE","产品未开通"),
	
	ACCOUNT_NOT_EXISTS("isv.ACCOUNT_NOT_EXISTS","账户不存在"),
	
	ACCOUNT_ABNORMAL("isv.ACCOUNT_ABNORMAL","账户异常"),
	
	SMS_TEMPLATE_ILLEGAL("isv.SMS_TEMPLATE_ILLEGAL","短信模版不合法"),
	
	SMS_SIGNATURE_ILLEGAL("isv.SMS_SIGNATURE_ILLEGAL","短信签名不合法"),
	
	INVALID_PARAMETERS("isv.INVALID_PARAMETERS","参数异常"),
	
	SYSTEM_ERROR("isp.SYSTEM_ERROR","isp.SYSTEM_ERROR"),
	
	MOBILE_NUMBER_ILLEGAL("isv.MOBILE_NUMBER_ILLEGAL","非法手机号"),
	
	MOBILE_COUNT_OVER_LIMIT("isv.MOBILE_COUNT_OVER_LIMIT","手机号码数量超过限制"),
	
	TEMPLATE_MISSING_PARAMETERS("isv.TEMPLATE_MISSING_PARAMETERS","模版缺少变量"),
	
	BUSINESS_LIMIT_CONTROL("isv.BUSINESS_LIMIT_CONTROL","业务限流"),
	
	INVALID_JSON_PARAM("isv.INVALID_JSON_PARAM","JSON参数不合法，只接受字符串值"),
	
	BLACK_KEY_CONTROL_LIMIT("isv.BLACK_KEY_CONTROL_LIMIT","黑名单管控"),
	
	PARAM_LENGTH_LIMIT("isv.PARAM_LENGTH_LIMIT","参数超出长度限制"),
	
	PARAM_NOT_SUPPORT_URL("isv.PARAM_NOT_SUPPORT_URL","不支持URL"),
	
	AMOUNT_NOT_ENOUGH("isv.AMOUNT_NOT_ENOUGH","账户余额不足"),
	
	TEMPLATE_PARAMS_ILLEGAL("isv.TEMPLATE_PARAMS_ILLEGAL","模版变量里包含非法关键字"),
	
	SIGNATUREDOESNOTMATCH("SignatureDoesNotMatch","Specified signature is not matched with our calculatio"),
	
	INVALIDTIMESTAMP_EXPIRED("InvalidTimeStamp.Expired","Specified time stamp or date value is expired."),
	
	SIGNATURENONCEUSED("SignatureNonceUsed","Specified signature nonce was used already."),
	
	INVALIDVERSION("InvalidVersion","Specified parameter Version is not valid."),
	
	INVALIDACTION_NOTFOUND("InvalidAction.NotFound","Specified api is not found, please check your url and method");
	
	private String code;
	private String msg;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	private SmsErrorCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	
}

