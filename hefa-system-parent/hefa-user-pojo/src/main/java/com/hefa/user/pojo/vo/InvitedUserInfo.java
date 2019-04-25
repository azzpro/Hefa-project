/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月24日 下午1:53:27
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.user.pojo.vo;

import java.util.Date;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月24日 下午1:53:27
 */
@Data
public class InvitedUserInfo {
	
	private Long recordId;
	private String mobile;
	private Date createTime;
	private String salesman;
	private Integer orderCount;

}

