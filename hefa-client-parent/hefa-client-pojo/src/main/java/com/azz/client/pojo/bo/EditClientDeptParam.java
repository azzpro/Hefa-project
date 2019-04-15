/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月26日 下午3:37:06
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.bo;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 彭斌  2018年10月26日 下午3:37:06
 */
@Data
public class EditClientDeptParam {
    
    /**
     * 客户企业编码
     */
    @NotNull(message = "客户企业编码不允许为空")
    private String companyCode;
    
    @NotNull(message = "部门编码不允许为空")
    private String deptCode;
    
    private String parentCode;
    
    @NotNull(message = "部门名称不允许为空")
    private String deptName;
    /**
     * 部门状态
     */
    @NotNull(message = "部门状态不允许为空")
    private Integer status ;
    
    private String modifier;
}

