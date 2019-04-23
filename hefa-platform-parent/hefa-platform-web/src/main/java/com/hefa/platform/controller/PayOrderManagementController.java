package com.hefa.platform.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.order.platform.api.PayOrderManagementService;
import com.hefa.order.platform.bo.PayOrderListParam;
import com.hefa.order.platform.pojo.ClientPay;


@RestController
@RequestMapping("/hefa/api/pay/order")
public class PayOrderManagementController {

	
	//logger
	private static final Logger logger = LoggerFactory.getLogger(PayOrderManagementController.class);
	
	@Autowired
	private PayOrderManagementService payOrderManagementService;
	
	/**
	 * 
	 * <p>查询平台客户订单列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2018年11月13日 上午10:54:40
	 */
	@RequestMapping("/getPlatPayOrderList")
	public JsonResult<Pagination<ClientPay>> getClientOrderInfoList(@RequestBody PayOrderListParam param){
		return payOrderManagementService.getClientOrderInfoList(param);
	}
}
