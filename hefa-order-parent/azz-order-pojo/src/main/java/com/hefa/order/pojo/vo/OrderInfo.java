/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月22日 下午7:40:01
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.vo;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月22日 下午7:40:01
 */
@Data
public class OrderInfo {
	
	private String orderCode;

	private Byte orderStatus;
	
	private Integer productCount;
	
	private BigDecimal grandTotal;
	
	private Date orderTime;
	
	private String salesman;
	
	private Integer deliveryDays; 
	
	private String afterSaleCode;
	
	private String remark;
	
	private String provinceName;
	
	private String cityName;
	
	private String areaName;
	
	private String detailAddress;
	
	private String receiverName;
	
	private String receiverPhoneNumber;
	
	private String deliveryPerson;
	
	private String deliveryPhone;
	
	private Byte deliveryType;
	
	private String number;
	
	private String expressCompanyName;
	
}

