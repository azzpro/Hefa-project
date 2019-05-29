/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月25日 上午11:22:25
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.client.util.WebUtils;
import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.order.api.client.ClientOrderService;
import com.hefa.order.pojo.bo.ConfirmOrderDeliveryParam;
import com.hefa.order.pojo.bo.SearchOrderInfoParam;
import com.hefa.order.pojo.vo.OrderDetail;
import com.hefa.order.pojo.vo.OrderInfo;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月25日 上午11:22:25
 */
@RestController
@RequestMapping("/hefa/api/client/order")
public class OrderController {
	
	@Autowired
	private ClientOrderService orderService;
	
	/**
	 * 
	 * <p>客户确认送达</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年5月16日 下午4:58:38
	 */
	@RequestMapping("/confirmOrderDelivery")
	public JsonResult<String> confirmOrderDelivery(ConfirmOrderDeliveryParam param){
		param.setUserCode(WebUtils.getLoginUser().getUserCode());
		return orderService.confirmOrderDelivery(param);
	}
	
	/**
	 * 
	 * <p>查询订单列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月22日 下午8:11:14
	 */
	@RequestMapping("/getOrderInfos")
	public JsonResult<Pagination<OrderInfo>> getOrderInfos(SearchOrderInfoParam param){
		param.setUserCode(WebUtils.getLoginUser().getUserCode());
		return orderService.getOrderInfos(param);
	}
	
	/**
	 * 
	 * <p>查询订单详情</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月22日 下午8:11:14
	 */
	@RequestMapping("/getOrderDetail")
	public JsonResult<OrderDetail> getOrderDetail(String orderCode){
		return orderService.getOrderDetail(orderCode);
	}
	
	
	/**
	 * 
	 * <p>客户订单是否支付成功</p>
	 * @return
	 * @author 黄智聪  2018年11月26日 下午5:15:27
	 */
	@RequestMapping("/checkClientOrderPaySuccess")
	public JsonResult<String> checkClientOrderPaySuccess(@RequestParam("orderCode")String orderCode){
		return orderService.checkClientOrderPaySuccess(orderCode);
	}

}

