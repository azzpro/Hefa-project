/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月19日 下午4:55:35
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.bo;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年10月19日 下午4:55:35
 */
@Data
public class EditClientUserParam {
    
    @NotBlank(message = "用户编码不允许为空")
    private String clientUserCode;
    
    @NotBlank(message = "成员姓名不允许为空")
    private String clientUserName;
    
    @NotBlank(message = "手机号不允许为空")
    private String phoneNumber;
    
    private String email;
    
    private String postName;

    @NotBlank(message = "部门编码不允许为空")
    private String deptCode;
    
    @NotBlank(message = "角色编码不允许为空")
    private String roleCode;
    
    private String modifier;
}

