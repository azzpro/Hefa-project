/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年12月12日 下午3:54:22
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.bo;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年12月12日 下午3:54:22
 */
@Data
public class CheckVerificationCodeParam {
	
	@NotBlank(message = "验证码不允许为空")
	private String verificationCode;
	
	@NotBlank(message = "手机号不允许为空")
	private String phoneNumber;

}

