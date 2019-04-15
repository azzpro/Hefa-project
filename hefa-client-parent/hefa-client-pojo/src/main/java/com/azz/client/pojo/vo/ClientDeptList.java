/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月26日 下午8:17:59
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 彭斌  2018年10月26日 下午8:17:59
 */
@Data
public class ClientDeptList {
    /**
     * 部门编码
     *
     * @mbg.generated
     */
    private String deptCode;

    /**
     * 部门名称
     *
     * @mbg.generated
     */
    private String deptName;


    /**
     * 状态   0无效  1有效
     *
     * @mbg.generated
     */
    private Integer status;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;

    /**
     * 创建人
     *
     * @mbg.generated
     */
    private String creator;

    /**
     * 父级编码
     */
    private String parentCode;
    
}

