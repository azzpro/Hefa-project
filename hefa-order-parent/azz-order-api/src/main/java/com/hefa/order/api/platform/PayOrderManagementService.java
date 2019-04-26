package com.hefa.order.api.platform;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.order.platform.bo.PayOrderListParam;
import com.hefa.order.platform.vo.PayListInfo;
import com.hefa.order.platform.vo.PayOrderInfo;

@FeignClient(name = "hefa-order-service")
public interface PayOrderManagementService {

	/**
	 * 获取支付列表
	 * @param param
	 * @return
	 */
	@RequestMapping("/hefa/api/pay/order/getPlatPayOrderList")
	JsonResult<Pagination<PayListInfo>> getClientOrderInfoList(@RequestBody PayOrderListParam param);
	
	/**
	 * 支付订单详情
	 * @param param
	 * @return
	 */
	@RequestMapping("/hefa/api/pay/order/getPlatPayOrderInfo")
	JsonResult<PayOrderInfo> getPlatPayOrderInfo(@RequestParam("orderNumber") String orderNumber);
}
