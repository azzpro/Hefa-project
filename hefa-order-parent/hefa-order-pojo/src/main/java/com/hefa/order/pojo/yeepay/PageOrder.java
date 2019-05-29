/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年12月17日 下午2:08:35
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.yeepay;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

/**
 * <P>接收页面传递订单参数</P>
 * @version 1.0
 * @author 刘建麟  2018年12月17日 下午2:08:35
 */
@Data
public class PageOrder {
	
	@NotBlank(message="订单编号不能为空")
	private String orderCode;
	private String clientIp;
}

