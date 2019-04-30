/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月30日 下午5:59:17
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.bo;

import org.hibernate.validator.constraints.NotBlank;

import com.hefa.common.page.QueryPage;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月30日 下午5:59:17
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SearchSelectionInfoParam extends QueryPage{
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "缺少请求参数")
	private String userCode;

	private String searchInput;
	
}

