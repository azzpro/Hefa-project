package com.hefa.order.platform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.pagehelper.PageHelper;
import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.order.mapper.ClientOrderItemMapper;
import com.hefa.order.platform.bo.PayOrderListParam;
import com.hefa.order.platform.mapper.ClientPayMapper;
import com.hefa.order.platform.vo.PayListInfo;
import com.hefa.order.platform.vo.PayOrderInfo;
import com.hefa.order.pojo.vo.OrderItemInfo;

/**
 * @author THINK
 * 订单管理service
 */
@Service
public class PayOrderManagementService {
	
	@Autowired
	private ClientPayMapper clientPayMapper;
	
	@Autowired
	private ClientOrderItemMapper clientOrderItemMapper;
	
	/**
	 * 获取支付列表数据
	 * @param param
	 * @return
	 */
	public JsonResult<Pagination<PayListInfo>> getPlatPayOrderList(@RequestBody PayOrderListParam param){
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		List<PayListInfo> infos = clientPayMapper.selectPayList(param);
		return JsonResult.successJsonResult(new Pagination<>(infos));
	}
	
	/**
	 * 获取支付列表数据
	 * @param param
	 * @return
	 */
	public JsonResult<PayOrderInfo> getPlatPayOrderInfo(String orderNumber){
		PayOrderInfo selectPlatPayOrderInfo = clientPayMapper.selectPlatPayOrderInfo(orderNumber);
		List<OrderItemInfo> orderItemInfosByOrderCode = clientOrderItemMapper.getOrderItemInfosByOrderCode(orderNumber);
		selectPlatPayOrderInfo.setOii(orderItemInfosByOrderCode);
		return JsonResult.successJsonResult(selectPlatPayOrderInfo);
	}
	
}
