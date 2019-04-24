/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月23日 下午8:44:40
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.bo;

import com.hefa.common.page.QueryPage;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月23日 下午8:44:40
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SearchCommissionOrderInfoParam extends QueryPage{

	private static final long serialVersionUID = 1L;
	
	private String orderStartTime;
	
	private String orderEndTime;
	
	private String searchInput;

}

