package com.hefa.order.platform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.pagehelper.PageHelper;
import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.order.platform.bo.PayOrderListParam;
import com.hefa.order.platform.mapper.ClientPayMapper;
import com.hefa.order.platform.pojo.ClientPay;

/**
 * @author THINK
 * 订单管理service
 */
@Service
public class PayOrderManagementService {
	
	@Autowired
	private ClientPayMapper clientPayMapper;
	
	/**
	 * 获取支付列表数据
	 * @param param
	 * @return
	 */
	public JsonResult<Pagination<ClientPay>> getPlatPayOrderList(@RequestBody PayOrderListParam param){
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		List<ClientPay> infos = clientPayMapper.selectPayList(param);
		return JsonResult.successJsonResult(new Pagination<>(infos));
	}
	
}
