package com.hefa.order.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.order.platform.service.OrderService;
import com.hefa.order.pojo.bo.SearchCommissionOrderInfoParam;
import com.hefa.order.pojo.bo.SearchOrderInfoParam;
import com.hefa.order.pojo.vo.CommissionOrderInfo;
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
	private OrderService orderService;
	
	
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
	
	/**
	 * 
	 * <p>查询分佣订单列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午4:43:33
	 */
	@RequestMapping("/getCommissionOrderInfos")
	public JsonResult<Pagination<CommissionOrderInfo>> getCommissionOrderInfos(@RequestBody SearchCommissionOrderInfoParam param){
		return orderService.getCommissionOrderInfos(param);
	}
	
	/**
	 * 
	 * <p>导出分佣订单</p>
	 * @return
	 * @author 黄智聪  2019年4月24日 下午4:46:23
	 */
	@RequestMapping("/exportCommissionOrder")
	public JsonResult<String> exportCommissionOrder(){
		return orderService.exportCommissionOrder();
	}
}
