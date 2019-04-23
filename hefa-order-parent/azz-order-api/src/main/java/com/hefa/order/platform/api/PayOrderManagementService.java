package com.hefa.order.platform.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.order.platform.bo.PayOrderListParam;
import com.hefa.order.platform.pojo.ClientPay;

@FeignClient(name = "hefa-order-service")
public interface PayOrderManagementService {

	/**
	 * 获取支付列表
	 * @param param
	 * @return
	 */
	@RequestMapping("/hefa/api/pay/order/getPlatPayOrderList")
	JsonResult<Pagination<ClientPay>> getClientOrderInfoList(@RequestBody PayOrderListParam param);
}
