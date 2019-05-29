/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月26日 下午3:09:13
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.client.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.order.client.service.ClientPayService;
import com.hefa.order.platform.bo.PayOrderListParam;
import com.hefa.order.platform.pojo.ClientPay;
import com.hefa.order.platform.vo.PayListInfo;
import com.hefa.order.pojo.yeepay.BankBranch;
import com.hefa.order.pojo.yeepay.PageOrder;
import com.hefa.order.pojo.yeepay.PayList;
import com.hefa.order.pojo.yeepay.RetBean;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年11月26日 下午3:09:13
 */
@RestController
@RequestMapping("/hefa/api/pay")
public class ClientPayController {
	
	@Autowired
	private ClientPayService pps;
	/**
	 * <p>提交支付</p>
	 * @param spp
	 * @return
	 * @author 刘建麟  2018年11月26日 下午3:14:49
	 */
	@RequestMapping(value="submitOrderPay",method=RequestMethod.POST)
	public Map<String,Object> submitOrderPay(@RequestBody PageOrder po){
		return pps.submitOrderPay(po);
	} 
	
	/**
	 * <p>支付管理列表</p>
	 * @param param
	 * @return
	 * @author 刘建麟  2018年12月3日 下午2:46:08
	 */
	@RequestMapping("toPayList")
	public JsonResult<Pagination<PayListInfo>> toPayList(@RequestBody PayOrderListParam pl){
		return pps.searchParamsList(pl);
	}
	
	/**
	 * 支付回调
	 * @param reqStr
	 * @return
	 */
	@RequestMapping("payNotify")
	public JsonResult<RetBean> payNotify(@RequestParam("responseMsg") String responseMsg,@RequestParam("customerId") String customerId) {
		return pps.payNotify(responseMsg,customerId);
	}
	
	/**
	 * 分账回调
	 * @param reqStr
	 * @return
	 */
	@RequestMapping("divideNotify")
	public JsonResult<RetBean> divideNotify(@RequestParam("responseMsg") String responseMsg,@RequestParam("customerId") String customerId) {
		return pps.divideNotify(responseMsg,customerId);
	}
	
	
	/**
	 * 获取支行信息
	 * @param request
	 * @param po
	 * @return
	 */
	@RequestMapping("getBankBranchInfo")
	public Map<String,String> getBankBranchInfo(@RequestBody BankBranch bb){
		return pps.getBankBranchInfo(bb);
	}
	
	/**
	 * <p>
	 * 支付订单详情
	 * </p>
	 * 
	 */
	@RequestMapping("getOrderInfo")
	public JsonResult<ClientPay> getOrderInfo(@RequestParam("number") String number) {
		return pps.getOrderInfo(number);
	}
}

