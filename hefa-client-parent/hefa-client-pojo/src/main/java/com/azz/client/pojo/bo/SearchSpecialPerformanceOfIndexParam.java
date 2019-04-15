/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年1月7日 下午1:47:27
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.bo;

import org.hibernate.validator.constraints.NotBlank;

import com.azz.core.common.QueryPage;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 彭斌  2019年1月7日 下午1:47:27
 */
@Data
public class SearchSpecialPerformanceOfIndexParam extends QueryPage{
	
	@NotBlank(message = "请选择专场")
    private String specialPerformanceCode;
	
    private String recommendCode;
}

