/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年12月13日 下午1:37:56
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.system.bo;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年12月13日 下午1:37:56
 */
@Data
public class MailParam {
	@NotBlank(message="收件人不能为空")
	private String to; //收件人
	private String content;//邮件内容
	private String subject;//主题
}

