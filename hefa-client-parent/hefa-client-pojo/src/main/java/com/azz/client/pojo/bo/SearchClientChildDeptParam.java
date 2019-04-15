/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月27日 下午2:17:22
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.bo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 彭斌  2018年10月27日 下午2:17:22
 */
@Data
public class SearchClientChildDeptParam {
    @NotNull(message = "客户企业编码不允许为空")
    private String companyCode;
    @NotBlank(message = "父级编码不允许为空")
    private String parentCode;
}

