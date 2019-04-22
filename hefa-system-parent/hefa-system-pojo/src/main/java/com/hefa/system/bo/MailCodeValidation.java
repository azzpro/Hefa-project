/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月14日 下午5:32:44
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.system.bo;
/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年11月14日 下午5:32:44
 */

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class MailCodeValidation {
	
	@NotBlank(message="邮箱不能为空")
	private String mail;
	@NotNull(message="时间间隔不能为空")
	private Long sec;
}

