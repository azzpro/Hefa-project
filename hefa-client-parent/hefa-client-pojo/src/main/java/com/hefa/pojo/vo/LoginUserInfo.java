/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月15日 下午2:32:37
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.pojo.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月15日 下午2:32:37
 */
@Data
public class LoginUserInfo {
	private String userCode;
	private String username;
	private String trueName;
	private String telephone;
	private String mobile;
	private String sex;
	private Date birthday;
	private String qq;
	private String email;
	
	private Serializable sessionId;
}

