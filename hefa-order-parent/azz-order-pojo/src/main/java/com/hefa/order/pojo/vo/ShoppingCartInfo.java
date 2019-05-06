/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年5月5日 上午10:11:31
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.vo;

import java.math.BigDecimal;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年5月5日 上午10:11:31
 */
@Data
public class ShoppingCartInfo {
	
	private String selectionRecordCode;
	
	private String productCode;
	
	private String productModelNo;
	
	private String productName;
	
	private BigDecimal price;
	
	private String specificationInfo;
	
}

