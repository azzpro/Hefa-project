/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月22日 下午4:29:03
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.bo;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年10月22日 下午4:29:03
 */
@Data
public class SetRolePermissionParam {

    @NotBlank(message = "角色编码不允许为空")
    private String roleCode;
    
    @NotEmpty(message = "请选择权限")
    private List<String> permissionCodes;
    
    private String creator;
    
}

