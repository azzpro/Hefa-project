/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月17日 下午6:03:48
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.user.pojo.vo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年10月17日 下午6:03:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserInfo implements Serializable{
    
    private static final long serialVersionUID = 2804715212693351455L;
    
    private Serializable sessionId;

    private UserInfo userInfo;
    
    private List<UserPermission> userPermissions;

    private List<Menu> menus;
    
}

