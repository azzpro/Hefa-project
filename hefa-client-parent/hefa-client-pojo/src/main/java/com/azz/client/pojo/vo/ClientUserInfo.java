/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月22日 上午11:18:29
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
 * @author 黄智聪  2018年10月22日 上午11:18:29
 */
@Data
public class ClientUserInfo {
    
    private String clientUserCode;
    
    private String companyName;
    
    private String phoneNumber;
    
    private String postName;
    
    private String clientUserName;
    
    private String email;
    
    private String deptCode;
    
    private String deptName;
    
    private String roleCode;
    
    private String roleName;
    
    private Integer clientType;
    
    private String companyCode;
    
    private Integer isEnterpriseAuthenticator;
    
    private Integer qualificationApplyStatus;
    
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    
    private String status;
    
}

