/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月22日 下午7:40:01
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.vo;

import java.math.BigDecimal;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月22日 下午7:40:01
 */
@Data
public class ExportOrderInfo {
	
	private String orderCode;

	private String username;
	
	private BigDecimal grandTotal;

	private String orderTime;
	
	private String salesman;
	
	private String deptName;
	
}

