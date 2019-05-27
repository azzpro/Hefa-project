/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年5月27日 上午11:50:38
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.vo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年5月27日 上午11:50:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectionProduct {

	private BigDecimal productTip;
	
	private BigDecimal productDiscount;
	
	private BigDecimal totalDiscountProductPrice;
	
}

