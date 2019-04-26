package com.hefa.user.pojo.vo;

import java.math.BigDecimal;

public class ServiceSaleInfo {
	private String serviceNumber;
	private String orderCode;
	private BigDecimal money;
	private String appleTime;
	private Byte status;
	private Long id;
	private Byte instatus;
	
	public Byte getInstatus() {
		return instatus;
	}
	public void setInstatus(Byte instatus) {
		this.instatus = instatus;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getServiceNumber() {
		return serviceNumber;
	}
	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public String getAppleTime() {
		return appleTime;
	}
	public void setAppleTime(String appleTime) {
		this.appleTime = appleTime;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	
}
