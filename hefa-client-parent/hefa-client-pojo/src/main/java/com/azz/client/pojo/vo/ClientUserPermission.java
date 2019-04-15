/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月17日 下午6:03:20
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
 * @author 黄智聪 2018年10月17日 下午6:03:20
 */
@Data
public class ClientUserPermission {
    private String permissionCode;
    private String permissionName;
    private String pageUrl;
    private String parentPermissionCode;
    private String icon;
    private Integer sort;
    private Integer level;

}
