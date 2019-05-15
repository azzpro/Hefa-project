package com.hefa.order.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.order.client.service.ClientOrderService;
import com.hefa.order.pojo.bo.SearchOrderInfoParam;
import com.hefa.order.pojo.vo.OrderDetail;
import com.hefa.order.pojo.vo.OrderInfo;

/**
 * 
 * <P>订单</P>
 * @version 1.0
 * @author 黄智聪  2019年4月25日 上午11:15:40
 */
@RestController
@RequestMapping("/hefa/api/client/order")
public class ClientOrderController {
	
	@Autowired
	private ClientOrderService orderService;
	
	
	/**
	 * 
	 * <p>查询订单列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月22日 下午8:11:14
	 */
	@RequestMapping("/getOrderInfos")
	public JsonResult<Pagination<OrderInfo>> getOrderInfos(@RequestBody SearchOrderInfoParam param){
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
	public JsonResult<OrderDetail> getOrderDetail(@RequestParam("orderCode") String orderCode){
		return orderService.getOrderDetail(orderCode);
	}
	
}
