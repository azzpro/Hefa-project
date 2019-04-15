/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月16日 下午8:22:21
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
 * @author 彭斌  2018年10月16日 下午8:22:21
 */
@Data
public class AddClientDeptParam {

    /**
     * 部门名称
     *
     * @mbg.generated
     */
    @NotBlank(message = "部门名称不允许为空")
    private String deptName;

    /**
     * 上级部门编码
     *
     * @mbg.generated
     */
    private String parentCode;
    
    /**
     * 部门状态
     */
    @NotNull(message = "部门状态不允许为空")
    private Integer status;
    
    /**
     * 创建人
     */
    private String creator;
    
    /**
     * 客户企业编码
     */
    private String companyCode;
}

