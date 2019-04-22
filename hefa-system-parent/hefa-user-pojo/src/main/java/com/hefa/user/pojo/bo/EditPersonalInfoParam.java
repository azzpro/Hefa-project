/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年12月12日 下午2:43:57
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.user.pojo.bo;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年12月12日 下午2:43:57
 */
@Data
public class EditPersonalInfoParam {

	// 修改类型 1姓名 2手机号 3邮箱 4密码
	@NotNull(message = "请选择需要修改的内容")
	private Integer editType;
	
	private String userName;
	
	private String phoneNumber;
	
	private String email;
	
	private String password;
	
	private String confirmPassword;
	
	private String verificationCode;
	
	private String modifier;
	
}

