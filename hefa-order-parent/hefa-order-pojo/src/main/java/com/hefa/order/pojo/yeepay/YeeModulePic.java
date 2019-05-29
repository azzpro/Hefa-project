/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月1日 下午3:52:39
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.hefa.order.pojo.yeepay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <P>
 * TODO
 * </P>
 * 
 * @version 1.0
 * @author 黄智聪 2018年11月1日 下午3:52:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class YeeModulePic {

	private String fileName;

	private long fileSize;

	private String fileBase64Str;
	
	private String type;

}
