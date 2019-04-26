package com.hefa.user.pojo.bo;

import org.hibernate.validator.constraints.NotBlank;

public class UpdataUserPasswd {

	private Integer id;
	@NotBlank(message = "新密码不允许为空")
	private String newPasswd;
	@NotBlank(message = "确认密码不允许为空")
	private String reqPasswd;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNewPasswd() {
		return newPasswd;
	}
	public void setNewPasswd(String newPasswd) {
		this.newPasswd = newPasswd;
	}
	public String getReqPasswd() {
		return reqPasswd;
	}
	public void setReqPasswd(String reqPasswd) {
		this.reqPasswd = reqPasswd;
	}
	
	
}
