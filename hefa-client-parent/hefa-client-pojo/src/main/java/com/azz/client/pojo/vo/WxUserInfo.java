/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年3月14日 下午3:14:20
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
 * @author 黄智聪  2019年3月14日 下午3:14:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxUserInfo {
	
	private String openid;
	
	private String nickname;
	
	private String headimgurl;

}

