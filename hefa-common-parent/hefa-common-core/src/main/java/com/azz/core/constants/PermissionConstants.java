/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月19日 下午2:59:26
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.core.constants;

import lombok.Getter;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年10月19日 下午2:59:26
 */
public abstract class PermissionConstants {
    
    public static final String TOP_PARENT_PERMISSION_CODE = "0";
    
    public enum PermissionStatus {
	
	INVALID(0, "无效"),
	
	VALID(1, "有效");
	
	@Getter
	private int value;
	
	@Getter
	private String desc;
	
	PermissionStatus(int value, String desc) {
	    this.value = value;
	    this.desc = desc;
	}
	
    }

}

