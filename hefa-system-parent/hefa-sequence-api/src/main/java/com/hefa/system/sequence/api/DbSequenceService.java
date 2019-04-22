/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月24日 下午4:20:14
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.system.sequence.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年10月24日 下午4:20:14
 */
@FeignClient("hefa-sequence-service")
public interface DbSequenceService {
	
	
	/**
	 * <p>平台端  员工编号</p>
	 * @return
	 * @author 刘建麟  2018年10月24日 下午4:37:16
	 */
	@RequestMapping(value="/hefa/api/sequence/getPlatEmployeeNumber",method=RequestMethod.GET)
	public String getPlatEmployeeNumber() ;
	
}

