/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年5月27日 下午2:38:23
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.bo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年5月27日 下午2:38:23
 */
@Data
public class GetSelectionProductInfoParam {

	@NotBlank(message = "请选择产品")
	private String productCode;
	
	@Min(value = 1, message = "数量至少为1")
	@NotNull(message = "请输入产品数量")
	private Integer quantity;
	
}

