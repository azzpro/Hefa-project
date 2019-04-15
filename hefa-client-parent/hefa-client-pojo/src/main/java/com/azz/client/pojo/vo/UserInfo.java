/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年3月14日 下午3:41:32
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.vo;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年3月14日 下午3:41:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
	
	private LoginClientUserInfo clientUserInfo;
	
	private WxUserInfo wxUserInfo;

}

