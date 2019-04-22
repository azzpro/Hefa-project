/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月19日 下午2:54:24
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.user.pojo.bo;
/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年10月19日 下午2:54:24
 */

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class DelRoleParam {

    @NotBlank(message = "角色编码不允许为空")
    private String roleCode;
    
    private String modifier;
    
}

