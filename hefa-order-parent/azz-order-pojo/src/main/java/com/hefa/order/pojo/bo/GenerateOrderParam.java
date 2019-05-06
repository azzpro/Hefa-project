/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年5月5日 下午5:45:09
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.bo;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年5月5日 下午5:45:09
 */
@Data
public class GenerateOrderParam {
	
	@NotBlank(message = "缺少请求参数")
	private String userCode;
	
	@NotBlank(message = "请选择收货地址")
	private String shippingAddressCode;

	@NotEmpty(message = "请选择下单产品")
	private List<OrderItem> items;
	
	private Integer deliveryDays;
	
	private String remark;
	
}

