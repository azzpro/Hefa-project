/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月26日 下午4:03:07
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.vo;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 彭斌  2018年10月26日 下午4:03:07
 */
@Data
public class ClientDeptInfo {
    private Long deptId;
    private Long clientUserCompanyId;
    private String deptCode;
    private String parentCode;
    private String deptName;
    private Integer status;
}

