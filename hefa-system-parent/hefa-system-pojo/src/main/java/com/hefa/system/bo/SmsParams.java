/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月14日 上午11:04:21
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.system.bo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年11月14日 上午11:04:21
 */
@Data
public class SmsParams {
	
	@NotBlank(message="手机号码不能为空")
	private String phone;
	@NotNull(message="短信类型不能为空")
	private Integer msgType;
	
	private String code;
}

