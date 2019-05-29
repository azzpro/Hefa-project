/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月12日 下午4:19:46
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.yeepay;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年11月12日 下午4:19:46
 */
@Data
public class ClientOrderItemInfo {
	
	private String merchantName;
	
	private String productCode;

	private String modulePicUrl;
	
	private String moduleName;
	
	private Date deliveryTime;

	private Integer quantity;
	
	private BigDecimal productPrice;
	
	private BigDecimal productPriceSum;
	
}

