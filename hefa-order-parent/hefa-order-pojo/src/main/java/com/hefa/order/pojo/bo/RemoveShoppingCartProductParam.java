/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年5月5日 上午10:23:26
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.bo;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年5月5日 上午10:23:26
 */
@Data
public class RemoveShoppingCartProductParam {

	@NotBlank(message = "请选择产品")
	private String selectionRecordCode;
	
	@NotBlank(message = "缺少请求参数")
	private String userCode;
	
}

