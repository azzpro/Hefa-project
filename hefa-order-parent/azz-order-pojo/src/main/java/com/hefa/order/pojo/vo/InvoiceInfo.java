/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月24日 下午7:04:19
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月24日 下午7:04:19
 */
@Data
public class InvoiceInfo {
	
	private String invoiceCode;
	private BigDecimal amount;
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd hh:mm:ss")
	private Date invoiceCreateTime;
	private Byte invoiceStatus;
	private String orderCode;
	private Byte invoiceType;
	private String clientUserPhoneNumber;
}

