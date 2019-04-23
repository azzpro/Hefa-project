package com.hefa.order.platform.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.hefa.order.pojo.vo.OrderItemInfo;

public class PayOrderInfo {

	private String payNumber;
	private String orderMoney;
	private Long orderTime;
	private String orderNumber;
	private BigDecimal grandTotal;
	private Date createTime;
	private String  threePartyNumber;
	private String orderChannelMoney;
	private String orderRealMoney;
	private List<OrderItemInfo> oii;
	public String getPayNumber() {
		return payNumber;
	}
	public void setPayNumber(String payNumber) {
		this.payNumber = payNumber;
	}
	public String getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(String orderMoney) {
		this.orderMoney = orderMoney;
	}
	public Long getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Long orderTime) {
		this.orderTime = orderTime;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public BigDecimal getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getThreePartyNumber() {
		return threePartyNumber;
	}
	public void setThreePartyNumber(String threePartyNumber) {
		this.threePartyNumber = threePartyNumber;
	}
	public String getOrderChannelMoney() {
		return orderChannelMoney;
	}
	public void setOrderChannelMoney(String orderChannelMoney) {
		this.orderChannelMoney = orderChannelMoney;
	}
	public String getOrderRealMoney() {
		return orderRealMoney;
	}
	public void setOrderRealMoney(String orderRealMoney) {
		this.orderRealMoney = orderRealMoney;
	}
	public List<OrderItemInfo> getOii() {
		return oii;
	}
	public void setOii(List<OrderItemInfo> oii) {
		this.oii = oii;
	}
	
	
	
}
