/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月22日 下午8:18:15
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月22日 下午8:18:15
 */
@Data
@AllArgsConstructor
public class OrderDetail {
	
	private OrderInfo orderInfo;
	
	private DeliveryInfo deliveryInfo;
	
	private List<OrderItemInfo> orderItems;

}

