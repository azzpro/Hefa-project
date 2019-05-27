/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月22日 下午8:19:53
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.user.pojo.vo;

import java.math.BigDecimal;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月22日 下午8:19:53
 */
@Data
public class OrderItemInfo {

	private String productCode;
	
	private String productName;
	
	private String productModelNo;

    private String specificationInfo;

    private BigDecimal productPrice;

    private Integer quantity;
    
    private BigDecimal productTip;
	
	private BigDecimal productDiscount;
    
    private BigDecimal totalDiscountProductPrice;
    
}

