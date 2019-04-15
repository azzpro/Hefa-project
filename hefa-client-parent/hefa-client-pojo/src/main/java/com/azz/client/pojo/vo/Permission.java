/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月22日 下午8:05:31
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年10月22日 下午8:05:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
    
    private Long permissionId;
    
    private String permissionCode;
    
    private String parentPermissionCode;
    
    private String permissionName;
    
    private Integer level;
    
    /**
     *  是否选中  默认否
     */
    private int isSelected = 0;

}

