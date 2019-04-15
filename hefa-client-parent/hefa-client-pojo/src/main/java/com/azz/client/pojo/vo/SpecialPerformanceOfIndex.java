/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年1月9日 下午5:48:37
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.vo;

import java.util.List;

import com.azz.core.common.page.Pagination;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年1月9日 下午5:48:37
 */
@Data
public class SpecialPerformanceOfIndex {
	
	private String specialPerformanceCode;
	
	private String specialPerformanceName;
	
	private String specialPerformanceMainPicName;
	
	private String specialPerformanceMainPicUrl;
	
	private String specialPerformanceBgPicUrl;
	
	private List<RecommendInfo> recommends;
	
	private Pagination<ModuleInfo> moduleInfos;

}

