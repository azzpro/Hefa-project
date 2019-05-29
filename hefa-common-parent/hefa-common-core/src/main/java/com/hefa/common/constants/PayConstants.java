/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年12月17日 下午6:08:33
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.common.constants;
/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年12月17日 下午6:08:33
 */
public interface PayConstants {
	
	public static final String PAYMENT_INSTITUTION = "易宝支付";
	
	public enum Unit{
		SECOND("秒"), MINUTE("分"), HOUR("时"), DAY("天");
		private String prc;

		public String getPrc() {
			return prc;
		}

		public void setPrc(String prc) {
			this.prc = prc;
		}

		private Unit(String prc) {
			this.prc = prc;
		}
		
	}
	
	public enum RegYee{
		businessPic("BP","营业执照"),
		legalBackPic("LBP","法人反面照"),
		legalFrontPic("LFB","法人正面照"),
		openAccountPic("OAP","开户许可照"),
		icpAuthPic("IAP","ICP授权照");
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
		private RegYee(String code,String msg) {
			this.code = code;
			this.msg = msg;
		}
		
	}
	
	public enum Status{
		UR("0","未注册"),RD("1","已注册");
		private String status;
		private String msg;
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		private Status(String status,String msg) {
			this.status = status;
			this.msg = msg;
		}
		
	}
	
	
	public enum PayCode{
		SUCCESS("交易成功","0000","SUCCESS"),
		FAILD("交易失败","9999","FAILD"),
		UPDATEFAILD("订单更新失败","1111","UPDATEFAILD"),
		PAID("订单已支付,请勿重复支付","2222","PAID");
		private String desc;
		private String code;
		private String msg;
		
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
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
		private PayCode(String desc, String code,String msg) {
			this.desc = desc;
			this.code = code;
			this.msg = msg;
		}
		
	}
	
	public enum YeeCode{
		SUCCESS("注册成功","0000","SUCCESS"),
		FAILD("注册失败","9999","FAILD");
		private String desc;
		private String code;
		private String msg;
		
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
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
		private YeeCode(String desc, String code,String msg) {
			this.desc = desc;
			this.code = code;
			this.msg = msg;
		}
		
	}
	
	public enum RegCode{
		SUCCESS("请求成功","0000","SUCCESS"),
		FAILD("请求失败","9999","FAILD");
		private String desc;
		private String code;
		private String msg;
		
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
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
		private RegCode(String desc, String code,String msg) {
			this.desc = desc;
			this.code = code;
			this.msg = msg;
		}
		
	}
	
	
	public enum PayType{
		NCPAY("一键支付","NCPAY"),
		SCCANPAY("用户扫码","SCCANPAY"),
		MSCANPAY("商家扫码","MSCANPAY"),
		EANK("网银支付","EANK"),
		EWALLET("钱包支付","EWALLET"),
		EWALLETH5("钱包H5支付","EWALLETH5"),
		CFL("分期支付","CFL"),
		WECHAT_OPENID("微信公众号","WECHAT_OPENID"),
		POS("POS支付","POS"),
		ZFB_SHH("支付宝生活号","ZFB_SHH"),
		BK_ZF("绑卡支付","BK_ZF"),
		ZF_ZHZF("商户账户支付","ZF_ZHZF"),
		YHKFQ_ZF("银行卡分期","YHKFQ_ZF"),
		GRHYZF("会员账户支付","GRHYZF");
		
		/*WECHAT 微信
		ALIPAY 支付宝
		NET 网银
		NCPAY 快捷
		CFL 分期（马上金融）*/
		
		private String desc;
		private String type;
		
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		private PayType(String desc,String type) {
			this.desc = desc;
			this.type = type;
		}
		
		public static String getDesc(String type) {
			PayType[] values = PayType.values();
			for (PayType payType : values) {
				if(type.equals(payType.getType())) {
					return payType.getDesc();
				}
			}
			return "";
		}
		
	}
	public enum PayPlatForm{
		WECHAT("微信","WECHAT",1),
		ALIPAY("支付宝","ALIPAY",2),
		NET("网银","NET",3),
		NCPAY("快捷","NCPAY",4),
		CFL("分期","CFL",5);
		
		private String desc;
		private String type;
		private Integer num;
		
		public Integer getNum() {
			return num;
		}
		public void setNum(Integer num) {
			this.num = num;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		private PayPlatForm(String desc,String type,Integer num) {
			this.desc = desc;
			this.type = type;
			this.num = num;
		}
		
		public static String getDesc(String type) {
			PayPlatForm[] values = PayPlatForm.values();
			for (PayPlatForm payType : values) {
				if(type.equals(payType.getType())) {
					return payType.getDesc();
				}
			}
			return "";
		}
		
		public static Integer getNum(String type) {
			PayPlatForm[] values = PayPlatForm.values();
			for (PayPlatForm payType : values) {
				if(type.equals(payType.getType())) {
					return payType.getNum();
				}
			}
			return 9;
		}
		
	}
}

