/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月26日 下午2:11:16
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.yeepay;
/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年11月26日 下午2:11:16
 */

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.hefa.order.pojo.vo.OrderInfo;



public class ClientPay implements Serializable{
	/**
	 * TODO
	 */
	private static final long serialVersionUID = 8646390552957634890L;
	private Long id;
	private String userId; //用户ID(支付发起人)
	private String payNumber;//支付流水号
	private String threePartyNumber;//三方流水号
	private String orderNumber;//订单编号
	private Byte orderStatus;//支付状态 1待支付 2支付成功 3关闭支付
	private String orderType;//支付类型 
	private String orderMoney;//支付金额
	private String orderChannelMoney;//渠道费用
	private Long orderCustomerPhone;//客户联系方式
	private Byte orderMethod;//支付类型 1在线 2线下
	private Long orderTime; //支付时间
	private String orderInfo; //订单描述
	private String orderSettleDate; //清算日期
	private String userreqIp;// 订单发起IP
	private String goodsName;//商品名称
	private Integer busiPartner;//业务类型
	private String payInstruation;
	private String paySuccessDate;
	private OrderInfo coi;
	
	public String getPaySuccessDate() {
		return paySuccessDate;
	}
	public void setPaySuccessDate(String paySuccessDate) {
		this.paySuccessDate = paySuccessDate;
	}
	public OrderInfo getCoi() {
		return coi;
	}
	public void setCoi(OrderInfo coi) {
		this.coi = coi;
	}
	public String getPayInstruation() {
		return payInstruation;
	}
	public void setPayInstruation(String payInstruation) {
		this.payInstruation = payInstruation;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPayNumber() {
		return payNumber;
	}
	public void setPayNumber(String payNumber) {
		this.payNumber = payNumber;
	}
	public String getThreePartyNumber() {
		return threePartyNumber;
	}
	public void setThreePartyNumber(String threePartyNumber) {
		this.threePartyNumber = threePartyNumber;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Byte getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Byte orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
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
	public Long getOrderCustomerPhone() {
		return orderCustomerPhone;
	}
	public void setOrderCustomerPhone(Long orderCustomerPhone) {
		this.orderCustomerPhone = orderCustomerPhone;
	}
	public Byte getOrderMethod() {
		return orderMethod;
	}
	public void setOrderMethod(Byte orderMethod) {
		this.orderMethod = orderMethod;
	}
	public Long getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Long orderTime) {
		this.orderTime = orderTime;
	}
	public String getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}
	public String getOrderSettleDate() {
		return orderSettleDate;
	}
	public void setOrderSettleDate(String orderSettleDate) {
		this.orderSettleDate = orderSettleDate;
	}
	public String getUserreqIp() {
		return userreqIp;
	}
	public void setUserreqIp(String userreqIp) {
		this.userreqIp = userreqIp;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Integer getBusiPartner() {
		return busiPartner;
	}
	public void setBusiPartner(Integer busiPartner) {
		this.busiPartner = busiPartner;
	}
	@Override
	public String toString() {
		return "ClientPay [id=" + id + ", userId=" + userId + ", payNumber=" + payNumber + ", threePartyNumber="
				+ threePartyNumber + ", orderNumber=" + orderNumber + ", orderStatus=" + orderStatus + ", orderType="
				+ orderType + ", orderMoney=" + orderMoney + ", orderChannelMoney=" + orderChannelMoney
				+ ", orderCustomerPhone=" + orderCustomerPhone + ", orderMethod=" + orderMethod + ", orderTime="
				+ orderTime + ", orderInfo=" + orderInfo + ", orderSettleDate=" + orderSettleDate + ", userreqIp="
				+ userreqIp + ", goodsName=" + goodsName + ", busiPartner=" + busiPartner + "]";
	}
	
}

