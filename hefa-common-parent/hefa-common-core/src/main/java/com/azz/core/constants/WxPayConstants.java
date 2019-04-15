/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年12月17日 下午6:08:33
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.core.constants;
/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年12月17日 下午6:08:33
 */
public interface WxPayConstants {
	
	public static final String PAYMENT_INSTITUTION = "微信支付";
	
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
	
	
}

