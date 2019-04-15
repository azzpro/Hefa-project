package com.azz.core.enums;


/**
 * 
 * @ClassName: ResponseWebEnum
 * @Description: TODO WEB响应消息枚举
 * @author sonny
 * @date 2018年4月11日 上午9:50:27
 * @version v1.0
 */
public enum ResponseWebEnum {
	/*
	 * 失败
	 */
	FAIL("F", "失败"),
	/**
	 * 成功
	 */
	SUCCESS("S", "成功"),
	/**
	 * 错误
	 */
	ERROR("E", "错误");
	
	private String state;
	private String msg;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	private ResponseWebEnum(String state, String msg) {
		this.state = state;
		this.msg = msg;
	}
	
	
	
}
