/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月23日 下午2:16:45
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.user.pojo.bo;
/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月23日 下午2:16:45
 */

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EditOrDelPlatformUserSalesmanParam {
	
	@NotNull(message = "缺少请求参数")
	private Integer optType;
	
	@NotNull(message = "请选择记录")
	private Long recordId;
	
	private String userCode;
	
	private String modifier;

}

