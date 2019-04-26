/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月12日 下午3:14:43
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.order.pojo.bo.SearchOrderInfoParam;
import com.hefa.order.pojo.vo.OrderDetail;
import com.hefa.order.pojo.vo.OrderInfo;

/**
 * 
 * <P>订单管理</P>
 * @version 1.0
 * @author 黄智聪  2019年4月22日 下午7:37:02
 */
@FeignClient(name = "hefa-order-service")
public interface ClientOrderService {
	
	/**
	 * 
	 * <p>查询订单列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月22日 下午8:11:14
	 */
	@RequestMapping("/hefa/api/client/order/getOrderInfos")
	JsonResult<Pagination<OrderInfo>> getOrderInfos(@RequestBody SearchOrderInfoParam param);
	
	/**
	 * 
	 * <p>查询订单详情</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月22日 下午8:11:14
	 */
	@RequestMapping("/hefa/api/client/order/getOrderDetail")
	JsonResult<OrderDetail> getOrderDetail(@RequestParam("orderCode") String orderCode);
	
	
}

