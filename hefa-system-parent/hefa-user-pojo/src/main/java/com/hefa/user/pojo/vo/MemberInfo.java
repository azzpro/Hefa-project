package com.hefa.user.pojo.vo;

public class MemberInfo {
	private String phone; //手机号
	private String RecommendUser;//推荐人姓名
	private String regMail;//注册邮箱
	private String regTime;//注册时间
	private String userCode;//会员编号
	private String username;// 用户名
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRecommendUser() {
		return RecommendUser;
	}
	public void setRecommendUser(String recommendUser) {
		RecommendUser = recommendUser;
	}
	public String getRegMail() {
		return regMail;
	}
	public void setRegMail(String regMail) {
		this.regMail = regMail;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
