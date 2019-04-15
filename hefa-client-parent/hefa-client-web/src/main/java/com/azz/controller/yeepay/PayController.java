/******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月26日 下午4:09:49
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.controller.yeepay;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.azz.core.common.JsonResult;
import com.azz.order.api.client.ClientPayService;
import com.azz.order.client.pojo.RetBean;
import com.azz.order.client.pojo.bo.BankBranch;
import com.azz.order.client.pojo.bo.Enterprisereginfo;
import com.azz.order.client.pojo.bo.PageOrder;
import com.azz.order.client.pojo.bo.Personreginfo;
import com.azz.util.JSR303ValidateUtils;
import com.azz.util.LLPayUtil;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年11月26日 下午4:09:49
 */
@RestController
@RequestMapping("/azz/api/pay")
public class PayController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ClientPayService pfps;
	
	/**
	 * 提交订单
	 * @param request
	 * @param po
	 * @return
	 */
	@RequestMapping("submitOrderPay")
	public Map<String,Object> submitOrderPay(HttpServletRequest request,PageOrder po){
		po.setClientIp(LLPayUtil.getIpAddr(request));
		Map<String, Object> submitOrderPay = pfps.submitOrderPay(po);
		Set<Entry<String, Object>> entrySet = submitOrderPay.entrySet();
		for (Entry<String, Object> entry : entrySet) {
			log.info("key-->"+entry.getKey()+"::value-->"+entry.getValue());
		}
		return submitOrderPay;
	}
	
	/**
	 * 获取支行信息
	 * @param request
	 * @param po
	 * @return
	 */
	@RequestMapping("getBankBranchInfo")
	public Map<String,String> getBankBranchInfo(BankBranch bb){
		JSR303ValidateUtils.validate(bb);
		return pfps.getBankBranchInfo(bb);
	}
	
	
	/** 支付回调
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="payNotify",method=RequestMethod.POST)
	public void payNotify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String responseMsg = request.getParameter("response");
		String customerId = request.getParameter("customerIdentification");
		log.info("进入支付回调接口");
		log.info("responseMsg---->"+responseMsg);
		log.info("customerId---->"+customerId);
		JsonResult<RetBean> notify = pfps.payNotify(responseMsg,customerId);
		response.getWriter().write(notify.getMsg());
		response.getWriter().flush();
	}
	
	/** 分账回调
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="divideNotify",method=RequestMethod.POST)
	public void divideNotify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String responseMsg = request.getParameter("response");
		String customerId = request.getParameter("customerIdentification");
		log.info("进入分账回调接口");
		log.info("responseMsg---->"+responseMsg);
		log.info("customerId---->"+customerId);
		JsonResult<RetBean> notify = pfps.divideNotify(responseMsg,customerId);
		response.getWriter().write(notify.getMsg());
		response.getWriter().flush();
	}
}