/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月26日 下午2:11:16
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.platform.vo;
/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年11月26日 下午2:11:16
 */

public class PayListInfo{
	/**
	 * TODO
	 */
	private String payNumber;//支付单号
	private String orderRealMoney;//到账金额
	private String orderNumber;//订单编号
	private String orderMoney;//支付金额
	private String orderChannelMoney;//渠道费用
	private Long orderTime; //支付时间
	private String isInvoice;//是否开票
	public String getPayNumber() {
		return payNumber;
	}
	public void setPayNumber(String payNumber) {
		this.payNumber = payNumber;
	}
	public String getOrderRealMoney() {
		return orderRealMoney;
	}
	public void setOrderRealMoney(String orderRealMoney) {
		this.orderRealMoney = orderRealMoney;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(String orderMoney) {
		this.orderMoney = orderMoney;
	}
	public String getOrderChannelMoney() {
		return orderChannelMoney;
	}
	public void setOrderChannelMoney(String orderChannelMoney) {
		this.orderChannelMoney = orderChannelMoney;
	}
	public Long getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Long orderTime) {
		this.orderTime = orderTime;
	}
	public String getIsInvoice() {
		return isInvoice;
	}
	public void setIsInvoice(String isInvoice) {
		this.isInvoice = isInvoice;
	}

	
}

