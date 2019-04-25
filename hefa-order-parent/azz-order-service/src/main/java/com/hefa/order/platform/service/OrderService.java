/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月12日 下午3:14:43
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.platform.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.hefa.common.base.JsonResult;
import com.hefa.common.exception.ReturnDataException;
import com.hefa.common.exception.ValidationException;
import com.hefa.common.page.Pagination;
import com.hefa.order.mapper.ClientOrderItemMapper;
import com.hefa.order.mapper.ClientOrderMapper;
import com.hefa.order.pojo.bo.SearchCommissionOrderInfoParam;
import com.hefa.order.pojo.bo.SearchOrderInfoParam;
import com.hefa.order.pojo.vo.CommissionOrderInfo;
import com.hefa.order.pojo.vo.OrderDetail;
import com.hefa.order.pojo.vo.OrderInfo;
import com.hefa.order.pojo.vo.OrderItemInfo;

/**
 * 
 * <P>订单管理</P>
 * @version 1.0
 * @author 黄智聪  2019年4月22日 下午7:37:02
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class OrderService {
	
	@Autowired
	ClientOrderMapper clientOrderMapper;
	
	@Autowired
	ClientOrderItemMapper clientOrderItemMapper;
	
	/**
	 * 
	 * <p>查询订单列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月22日 下午8:11:14
	 */
	public JsonResult<Pagination<OrderInfo>> getOrderInfos(@RequestBody SearchOrderInfoParam param){
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		List<OrderInfo> orderInfos = clientOrderMapper.getOrderInfos(param);
		return JsonResult.successJsonResult(new Pagination<>(orderInfos));
	}
	
	/**
	 * 
	 * <p>查询订单详情</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月22日 下午8:11:14
	 */
	public JsonResult<OrderDetail> getOrderDetail(@RequestParam("orderCode") String orderCode){
		if(StringUtils.isBlank(orderCode)) {
			throw new ValidationException("订单编码不能为空");
		}
		OrderInfo orderInfo = clientOrderMapper.getOrderInfoByOrderCode(orderCode);
		if(orderInfo == null) {
			throw new ReturnDataException("订单不存在");
		}
		List<OrderItemInfo> orderItems = clientOrderItemMapper.getOrderItemInfosByOrderCode(orderCode);
		return JsonResult.successJsonResult(new OrderDetail(orderInfo, orderItems));
	}
	
	/**
	 * 
	 * <p>查询分佣订单列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午4:43:33
	 */
	public JsonResult<Pagination<CommissionOrderInfo>> getCommissionOrderInfos(@RequestBody SearchCommissionOrderInfoParam param){
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		List<CommissionOrderInfo> orderInfos = clientOrderMapper.getCommissionOrderInfos(param);
		return JsonResult.successJsonResult(new Pagination<>(orderInfos));
	}
	
	/**
	 * 
	 * <p>导出分佣订单</p>
	 * @return
	 * @author 黄智聪  2019年4月24日 下午4:46:23
	 */
	public JsonResult<String> exportCommissionOrder(){
		return JsonResult.successJsonResult();
	}

}

