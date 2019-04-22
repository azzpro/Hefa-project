/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月14日 下午6:58:30
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.system.bo;


import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年11月14日 下午6:58:30
 */
@Data
public class MailCheck {
	@NotBlank(message="邮箱不能为空")
	private String mail;
	@NotBlank(message="验证码不能为空")
	private String code;
}

