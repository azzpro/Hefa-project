/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月24日 下午7:39:49
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
 * @author 黄智聪  2019年4月24日 下午7:39:49
 */
@Data
public class ApproveInvoiceParam {
	
	@NotBlank(message = "请选择开票记录")
	private String invoiceCode;
	
	@NotNull(message = "请选择配送方式")
	private Byte deliveryType;
	
	private Integer expressCompanyId;
	
	private String deliveryPerson;
	
	private String deliveryPhone;
	
	private String number;
	
	private String modifier;
}

