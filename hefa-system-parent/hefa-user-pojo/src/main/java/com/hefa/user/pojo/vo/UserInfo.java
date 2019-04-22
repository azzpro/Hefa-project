/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月17日 下午6:55:35
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.user.pojo.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年10月17日 下午6:55:35
 */
@Data
public class UserInfo {
    
    private String userCode;

    private String userName;

    private String nickname;

    private String phoneNumber;

    private String email;

    private String gender;

    private String deptName;
    
    private String deptCode;

    private String postName;

    private String status;

    private String roleCode;
    
    private String roleName;
    
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;

}

