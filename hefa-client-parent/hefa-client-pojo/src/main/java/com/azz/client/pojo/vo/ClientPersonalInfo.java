/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月29日 下午3:08:04
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.azz.client.pojo.vo;

import lombok.Data;

/**
 * <P>
 * TODO
 * </P>
 * 
 * @version 1.0
 * @author 黄智聪 2018年10月29日 下午3:08:04
 */
@Data
public class ClientPersonalInfo {

    private String clientUserCode;
    
    private String clientUserName;
    
    private String phoneNumber;
    
    private String email;
    
    private String roleName;
    
    private String companyName;
    
    private String deptName;
    
    private String avatarUrl;
    
}
