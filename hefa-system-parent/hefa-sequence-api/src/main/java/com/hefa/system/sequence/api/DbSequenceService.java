/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月24日 下午4:20:14
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.system.sequence.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年10月24日 下午4:20:14
 */
@FeignClient("hefa-sequence-service")
public interface DbSequenceService {
	
	
	/**
	 * @return
	 * 部门编号
	 */
	@RequestMapping("/hefa/api/sequence/getBMSequenceNo")
	String getBMSequenceNo() ;
		
	
	/**
	 * @return
	 * 开票编号
	 */
	@RequestMapping("/hefa/api/sequence/getKPSequenceNo")
	String getKPSequenceNo() ;
		
	
	/**
	 * @return
	 * 退款编号
	 */
	@RequestMapping("/hefa/api/sequence/getTKSequenceNo")
	String getTKSequenceNo() ;
		
	
	/**
	 * @return
	 * 订单编号
	 */
	@RequestMapping("/hefa/api/sequence/getPOSequenceNo")
	String getPOSequenceNo() ;
		
	
	/**
	 * @return
	 * 支付编号
	 */
	@RequestMapping("/hefa/api/sequence/getZFSequenceNo")
	String getZFSequenceNo() ;
		
	
	/**
	 * @return
	 * 会员编号
	 */
	@RequestMapping("/hefa/api/sequence/getHYSequenceNo")
	String getHYSequenceNo() ;
		
	
	/**
	 * @return
	 * 业务专员编号
	 */
	@RequestMapping("/hefa/api/sequence/getYWSequenceNo")
	String getYWSequenceNo() ;
		
	
	/**
	 * @return
	 * 售后专员编号
	 */
	@RequestMapping("/hefa/api/sequence/getSHSequenceNo")
	String getSHSequenceNo();
		
	
	/**
	 * @return
	 * 成员编号
	 */
	@RequestMapping("/hefa/api/sequence/getCYSequenceNo")
	String getCYSequenceNo() ;
	
	/**
	 * @return
	 * 角色编号
	 */
	@RequestMapping("/hefa/api/sequence/getJSSequenceNo")
	String getJSSequenceNo() ;
	
	/**
	 * @return
	 * 售后区域编号
	 */
	@RequestMapping("/hefa/api/sequence/getQYSequenceNo")
	String getQYSequenceNo() ;
}

