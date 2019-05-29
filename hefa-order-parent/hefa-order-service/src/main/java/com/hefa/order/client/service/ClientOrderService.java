/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月12日 下午3:14:43
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.client.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.hefa.common.base.JsonResult;
import com.hefa.common.constants.ClientConstants.PayStatus;
import com.hefa.common.constants.PlatformConstants.OrderStatus;
import com.hefa.common.exception.ReturnDataException;
import com.hefa.common.exception.ValidationException;
import com.hefa.common.page.Pagination;
import com.hefa.order.mapper.ClientOrderItemMapper;
import com.hefa.order.mapper.ClientOrderMapper;
import com.hefa.order.mapper.ClientOrderStatusMapper;
import com.hefa.order.pojo.ClientOrder;
import com.hefa.order.pojo.ClientOrderStatus;
import com.hefa.order.pojo.bo.CallBackParam;
import com.hefa.order.pojo.bo.ConfirmOrderDeliveryParam;
import com.hefa.order.pojo.bo.SearchOrderInfoParam;
import com.hefa.order.pojo.vo.OrderDetail;
import com.hefa.order.pojo.vo.OrderInfo;
import com.hefa.order.pojo.vo.OrderItemInfo;
import com.hefa.utils.JSR303ValidateUtils;

/**
 * 
 * <P>订单管理</P>
 * @version 1.0
 * @author 黄智聪  2019年4月22日 下午7:37:02
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ClientOrderService {
	
	@Autowired
	private ClientOrderMapper clientOrderMapper;
	
	@Autowired
	private ClientOrderItemMapper clientOrderItemMapper;
	
	@Autowired
	private ClientOrderStatusMapper clientOrderStatusMapper;
	
	
	
	/**
	 * 
	 * <p>客户确认送达</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年5月16日 下午4:58:38
	 */
	public JsonResult<String> confirmOrderDelivery(@RequestBody ConfirmOrderDeliveryParam param){
		JSR303ValidateUtils.validateInputParam(param);
		OrderInfo orderInfo = clientOrderMapper.getOrderInfoByOrderCode(param.getOrderCode());
		if(orderInfo == null) {
			throw new ReturnDataException("订单不存在");
		}
		int status = orderInfo.getOrderStatus();
		if(OrderStatus.NOT_SIGNED.getValue() != status) {
			throw new ReturnDataException("订单状态异常");
		}
		Date nowDate = new Date();
		ClientOrder record = ClientOrder.builder()
				.orderCode(param.getOrderCode())
				.orderStatus((byte)OrderStatus.COMPLETED.getValue())
				.modifier(param.getUserCode())
				.modifyTime(nowDate)
				.build();
		clientOrderMapper.updateByOrderCodeSelective(record);
		// 新增客户订单状态变更记录
		ClientOrderStatus clientOrderStatusRecord = ClientOrderStatus.builder()
				.createTime(nowDate)
				.creator(param.getUserCode())
				.orderCode(param.getOrderCode())
				.orderStatus(OrderStatus.COMPLETED.getValue())
				.remark("客户确认收货")
				.build();
		clientOrderStatusMapper.insertSelective(clientOrderStatusRecord);
		return JsonResult.successJsonResult();
	}
	
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
	 * <p>订单支付成功后的操作，供支付回调使用</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年5月29日 上午11:10:01
	 */
	public JsonResult<String> clientOrderPaySuccessOpt(@RequestBody CallBackParam param){
		JSR303ValidateUtils.validateInputParam(param);
		String orderCode = param.getOrderCode();
		OrderInfo order = clientOrderMapper.getOrderInfoByOrderCode(orderCode);
		if(order == null) {
			throw new ReturnDataException("订单不存在");
		}
		if(OrderStatus.NOT_PAID.getValue() != order.getOrderStatus()) {
			throw new ReturnDataException("订单状态异常");
		}
		Date nowDate = new Date();
		// 修改订单
		ClientOrder clientOrderRecord = ClientOrder.builder()
				.orderCode(orderCode)
				.orderStatus((byte)OrderStatus.NOT_DELIVERED.getValue())
				.paymentMethod(param.getPayMethod().byteValue())
				.paymentType(param.getOrderType().byteValue())
				.paymentStatus((byte)PayStatus.PAY_SUCCESS.getValue())
				.modifyTime(nowDate)
				.build();
		clientOrderMapper.updateByOrderCodeSelective(clientOrderRecord);
		
		// 新增客户订单状态变更记录
		ClientOrderStatus clientOrderStatusRecord = ClientOrderStatus.builder()
				.createTime(nowDate)
				.orderCode(orderCode)
				.orderStatus(OrderStatus.NOT_DELIVERED.getValue())
				.remark("订单支付成功，生成待发货订单")
				.build();
		clientOrderStatusMapper.insertSelective(clientOrderStatusRecord);
		
		return JsonResult.successJsonResult();
	}
	
	/**
	 * 
	 * <p>客户订单是否支付成功</p>
	 * @return
	 * @author 黄智聪  2018年11月26日 下午5:15:27
	 */
	public JsonResult<String> checkClientOrderPaySuccess(@RequestParam("orderCode")String orderCode){
		JSR303ValidateUtils.validateNullOrBlank(orderCode, "订单编码不能为空");
		OrderInfo order = clientOrderMapper.getOrderInfoByOrderCode(orderCode);
		if(order == null) {
			throw new ReturnDataException("订单不存在");
		}
		int currentOrderStatus = order.getOrderStatus();
		if(OrderStatus.CLOSED.getValue() == currentOrderStatus) {
			throw new ReturnDataException("订单已关闭");
		}
		if(OrderStatus.NOT_PAID.getValue() == currentOrderStatus) {
			throw new ReturnDataException("客户订单未支付");
		}
		return JsonResult.successJsonResult();
	}
	
}

