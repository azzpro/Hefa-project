/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月22日 下午7:42:42
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
 * @author 黄智聪  2019年4月22日 下午7:42:42
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SearchInvoiceInfoParam extends QueryPage{
	
	private static final long serialVersionUID = 6042045077002356564L;

	private String startTime;
	
	private String endTime;
	
	private String searchInput;
	
	private Byte invoiceStatus;

}

