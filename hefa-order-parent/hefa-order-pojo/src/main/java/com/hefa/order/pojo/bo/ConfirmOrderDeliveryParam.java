/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年5月16日 下午4:57:02
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.bo;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年5月16日 下午4:57:02
 */
@Data
public class ConfirmOrderDeliveryParam {

	private String userCode;
	
	@NotBlank(message = "请选择订单")
	private String orderCode;
	
}

