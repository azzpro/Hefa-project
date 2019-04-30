/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月23日 下午5:28:15
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.bo;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年11月23日 下午5:28:15
 */
@Data
public class AddToShoppingCartParam {
	
	@NotBlank(message = "缺少请求参数")
	private String userCode;
	
	@NotBlank(message = "请选择加入购物车的产品")
	private String productCode;

}

