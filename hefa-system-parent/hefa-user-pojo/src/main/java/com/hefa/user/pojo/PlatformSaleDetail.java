package com.hefa.user.pojo;

import java.util.Date;

public class PlatformSaleDetail {
	private Long id;
	private String serviceNumber;
	private String dealingMan;
	private Byte status;
	private Date dealintTime;
	private String remake;
	private String time;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	public String getDealingMan() {
		return dealingMan;
	}
	public void setDealingMan(String dealingMan) {
		this.dealingMan = dealingMan;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public Date getDealintTime() {
		return dealintTime;
	}
	public void setDealintTime(Date dealintTime) {
		this.dealintTime = dealintTime;
	}
	public String getRemake() {
		return remake;
	}
	public void setRemake(String remake) {
		this.remake = remake;
	}
	
}
