/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月19日 下午3:26:46
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
 * @author 黄智聪  2018年10月19日 下午3:26:46
 */
@Data
public class RoleInfo {
    private String roleCode;
    private String roleName;
    private String remark;
    private String creator;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd hh:mm:ss") //出参
    private Date createTime;
}

