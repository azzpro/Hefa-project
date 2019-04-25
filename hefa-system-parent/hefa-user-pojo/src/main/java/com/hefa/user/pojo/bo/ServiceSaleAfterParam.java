package com.hefa.user.pojo.bo;

import com.hefa.common.page.QueryPage;

public class ServiceSaleAfterParam extends QueryPage{
	private String startTime;
	private String endTime;
	private String number;
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
