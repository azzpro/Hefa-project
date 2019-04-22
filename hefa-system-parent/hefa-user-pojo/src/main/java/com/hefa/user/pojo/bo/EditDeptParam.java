/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月17日 上午11:14:59
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.user.pojo.bo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

/**
 * <P>部门信息修改</P>
 * @version 1.0
 * @author 彭斌  2018年10月17日 上午11:14:59
 */
@Data
public class EditDeptParam {

    /**
     * 部门名称
     *
     * @mbg.generated
     */
    @NotBlank(message = "部门名称不允许为空")
    private String deptName;

    /**
     * 部门编码
     *
     * @mbg.generated
     */
    @NotBlank(message = "部门编码不允许为空")
    private String deptCode;
    
    /**
     * 上级部门编码
     */
    @NotBlank(message = "上级编码不允许为空")
    private String parentCode;
    
    /**
     * 状态   0无效  1有效
     *
     * @mbg.generated
     */
    @NotNull(message = "状态不允许为空")
    private Integer status;

    /**
     * 修改人
     */
    private String modifier;
}

