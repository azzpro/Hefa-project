/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月14日 上午10:19:38
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.common.constants;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年11月14日 上午10:19:38
 */
public enum SmsConstants {
	
	ACCOUNT_CREATE_SUCCESS("您的企业将您添加为企业成员，初始密码为：${code}，请登陆平台后及时修改。","账号生成","SMS_152546358",2,1),
	
	CLIENT_REGISTER("您正在注册平台个人客户账户，验证码为：${code}，有效期十分钟，请及时输入。","客户注册","SMS_150861363",2,2),
	
	MERCHANT_REGISTER("您正在注册平台商户账号，验证码为：${code}，有效期十分钟，请及时输入。","商户注册","SMS_150866439",2,3),
	
	CHANGE_DATA("您的资料变更验证码为：${code}，有效期十分钟，请及时输入。","资料变更","SMS_152546363",2,9),
	
	CLIENT_COMPANY_VALIDATE("您正在进行企业客户验证，验证码为：${code}，有效期十分钟，请及时输入。","客户-企业验证","SMS_150866454",2,4),
	
	CLIENT_COMPANY_EXAMINE_SUCCESS("您的企业审批已通过，请及时登陆，体验更加丰富的功能。","客户-企业验证-通过","SMS_150866458",1,5),
	
	CLIENT_COMPANY_EXAMINE_FAIL("您的企业审批暂未通过，请联系在线客服咨询原因后重新登陆提交验证资料。","客户-企业验证-不通过","SMS_150866461",1,6),
	
	MERCHANT_ENTER_EXAMINE_SUCCESS("您的商户入驻审批已通过，请及时登陆，开启智造之旅。","商户入驻审批通过","SMS_150861382",1,7),
	
	MERCHANT_ENTER_EXAMINE_FAIL("您的商户入驻审批暂未通过，请联系在线客服咨询原因，并重新提交验证资料。","商户入驻审批不通过","SMS_150866466",1,8),
	
	WX_REG("恭喜您注册成为爱智造自动化产业平台，初始密码为：${code}，详情咨询微信客服。","微信注册","SMS_156900729",2,10);
	private String msgContent;
	private String name;
	private String code;
	private Integer type;// 1 通知  2短信验证码
	private Integer msgType;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getMsgType() {
		return msgType;
	}
	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}
	
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	private SmsConstants(String msgContent,String name, String code, Integer type,Integer msgType) {
		this.msgContent = msgContent;
		this.code = code;
		this.name = name;
		this.type = type;
		this.msgType = msgType;
	}
	
	public enum SmsCode{
		SUCCESS("成功","0000"),
		FAILD("失败","1111"),
		NO_EXIST("无此短信记录","9999");
		
		private String desc;
		private String code;
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		private SmsCode(String desc, String code) {
			this.desc = desc;
			this.code = code;
		}
		
	}
}

