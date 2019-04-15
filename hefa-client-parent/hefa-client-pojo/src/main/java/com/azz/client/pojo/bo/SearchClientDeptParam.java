/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月16日 下午8:22:21
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.bo;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 彭斌  2018年10月16日 下午8:22:21
 */
@Data
public class SearchClientDeptParam{

    @NotNull(message = "客户企业编码不允许为空")
    private String companyCode;
    
    /**
     * 部门编码名称
     *
     * @mbg.generated
     */
    private String deptNameCode;
    
    
}

