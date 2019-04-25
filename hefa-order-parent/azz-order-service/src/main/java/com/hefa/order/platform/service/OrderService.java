/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月12日 下午3:14:43
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.platform.service;

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
import com.hefa.common.constants.PlatformConstants.DeliveryType;
import com.hefa.common.constants.PlatformConstants.OrderStatus;
import com.hefa.common.exception.BusinessException;
import com.hefa.common.exception.ReturnDataException;
import com.hefa.common.exception.ValidationException;
import com.hefa.common.page.Pagination;
import com.hefa.order.mapper.ClientInvoiceMapper;
import com.hefa.order.mapper.ClientOrderItemMapper;
import com.hefa.order.mapper.ClientOrderLogisticsMapper;
import com.hefa.order.mapper.ClientOrderMapper;
import com.hefa.order.mapper.ClientOrderStatusMapper;
import com.hefa.order.pojo.ClientOrder;
import com.hefa.order.pojo.ClientOrderLogistics;
import com.hefa.order.pojo.ClientOrderStatus;
import com.hefa.order.pojo.bo.ConfirmDeliveryParam;
import com.hefa.order.pojo.bo.SearchCommissionOrderInfoParam;
import com.hefa.order.pojo.bo.SearchOrderInfoParam;
import com.hefa.order.pojo.vo.CommissionOrderInfo;
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
public class OrderService {
	
	@Autowired
	private ClientOrderMapper clientOrderMapper;
	
	@Autowired
	private ClientOrderItemMapper clientOrderItemMapper;
	
	@Autowired
	private ClientOrderStatusMapper clientOrderStatusMapper;
	
	@Autowired
	private ClientOrderLogisticsMapper clientOrderLogisticsMapper;
	
	@Autowired
	private ClientInvoiceMapper clientInvoiceMapper;
	
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
	 * <p>确认发货</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月22日 下午8:11:14
	 */
	public JsonResult<String> confirmDelivery(@RequestBody ConfirmDeliveryParam param) {
		JSR303ValidateUtils.validateInputParam(param);
		OrderInfo order = this.checkDeliveryInfo(param.getOrderCode());
		Date nowDate = new Date();
		ClientOrderLogistics logisticsRecord = null;
		if(DeliveryType.EXPRESS.getValue() == param.getDeliveryType()) {
			String number = param.getNumber();
			if(StringUtils.isBlank(number)) {
				throw new ValidationException("请填写快递单号");
			}
			Integer expressCompanyId = param.getExpressCompanyId();
			if(expressCompanyId == null) {
				throw new ValidationException("请选择快递公司");
			}
			int count = clientInvoiceMapper.existExpressCompany(expressCompanyId);
			if(count == 0) {
				throw new ReturnDataException("快递公司不存在");
			}
			// 开票快递信息
			logisticsRecord = ClientOrderLogistics.builder()
					.expressCompanyId(expressCompanyId)
					.number(number)
					.deliveryType(DeliveryType.EXPRESS.getValue())
					.build();
		}else if(DeliveryType.SELF.getValue() == param.getDeliveryType()) {
			String deliveryPerson = param.getDeliveryPerson();
			if(StringUtils.isBlank(deliveryPerson)) {
				throw new ValidationException("请填写配送人员姓名");
			}
			String deliveryPhone = param.getDeliveryPhone();
			if(StringUtils.isBlank(deliveryPhone)) {
				throw new ValidationException("请填写配送人员联系方式");
			}
			// 开票快递信息
			logisticsRecord = ClientOrderLogistics.builder()
					.deliveryPerson(deliveryPerson)
					.deliveryPhone(deliveryPhone)
					.deliveryType(DeliveryType.SELF.getValue())
					.build();
		}else {
			throw new ValidationException("配送方式不存在");
		}
		
		// 修改订单状态 
		ClientOrder orderRecord = ClientOrder.builder()
				.modifier(param.getModifier())
				.modifyTime(nowDate)
				.orderStatus((byte)OrderStatus.NOT_SIGNED.getValue())
				.orderCode(order.getOrderCode())
				.build();
		clientOrderMapper.updateByOrderCodeSelective(orderRecord);
		
		// 修改订单状态变更表
		ClientOrderStatus orderStatusRecord = ClientOrderStatus.builder()
				.createTime(nowDate)
				.creator(param.getModifier())
				.orderCode(order.getOrderCode())
				.orderStatus(OrderStatus.NOT_SIGNED.getValue())
				.remark("订单发货，订单状态改为待签收")
				.build();
		
		clientOrderStatusMapper.insertSelective(orderStatusRecord);
		
		// 新增开票快递信息
		logisticsRecord.setCreateTime(nowDate);
		logisticsRecord.setCreator(param.getModifier());
		logisticsRecord.setOrderCode(order.getOrderCode());
		clientOrderLogisticsMapper.insertSelective(logisticsRecord);
		
		return JsonResult.successJsonResult();
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
	
	/**
	 * 
	 * <p>校验发货信息</p>
	 * @param invoiceCode
	 * @author 黄智聪  2019年4月25日 上午10:29:01
	 */
	private OrderInfo checkDeliveryInfo(String orderCode) {
		OrderInfo order = clientOrderMapper.getOrderInfoByOrderCode(orderCode);
		if(order == null) {
			throw new ReturnDataException("订单不存在");
		}
		if(order.getOrderStatus() != OrderStatus.NOT_DELIVERED.getValue()) {
			throw new BusinessException("订单状态异常");
		}
		return order;
	}

}

