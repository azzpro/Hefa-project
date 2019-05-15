/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月25日 下午6:54:16
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.bo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月25日 下午6:54:16
 */
@Data
public class ConfirmDeliveryParam {
	
	@NotBlank(message = "请选择订单")
	private String orderCode;
	
	@NotNull(message = "请选择配送方式")
	private Byte deliveryType;
	
	private Integer expressCompanyId;
	
	private String deliveryPerson;
	
	private String deliveryPhone;
	
	private String number;
	
	private String modifier;

}

