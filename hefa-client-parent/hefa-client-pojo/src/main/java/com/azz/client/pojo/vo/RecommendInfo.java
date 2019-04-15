/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年1月7日 上午11:03:34
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.vo;

import java.util.List;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年1月7日 上午11:03:34
 */
@Data
public class RecommendInfo {
	
	private String recommendCode;
	
	private String recommendName;
	
	private Byte status;
	
	private List<ModuleInfo> moduleInfos;

}

