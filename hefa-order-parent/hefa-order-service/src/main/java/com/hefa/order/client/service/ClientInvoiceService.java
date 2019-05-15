/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月24日 下午5:46:51
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.client.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.hefa.common.base.JsonResult;
import com.hefa.common.constants.PlatformConstants.InvoiceStatus;
import com.hefa.common.constants.PlatformConstants.Invoicetype;
import com.hefa.common.constants.PlatformConstants.OrderStatus;
import com.hefa.common.exception.ReturnDataException;
import com.hefa.common.exception.ValidationException;
import com.hefa.common.page.Pagination;
import com.hefa.order.mapper.ClientInvoiceMapper;
import com.hefa.order.mapper.ClientInvoiceTemplateMapper;
import com.hefa.order.mapper.ClientOrderItemMapper;
import com.hefa.order.mapper.ClientOrderMapper;
import com.hefa.order.mapper.ClientShippingAddressMapper;
import com.hefa.order.pojo.ClientInvoice;
import com.hefa.order.pojo.ClientInvoiceTemplate;
import com.hefa.order.pojo.ClientShippingAddress;
import com.hefa.order.pojo.bo.ApplyInvoiceParam;
import com.hefa.order.pojo.bo.SearchInvoiceInfoParam;
import com.hefa.order.pojo.vo.InvoiceDetail;
import com.hefa.order.pojo.vo.InvoiceInfo;
import com.hefa.order.pojo.vo.OrderInfo;
import com.hefa.order.pojo.vo.OrderItemInfo;
import com.hefa.system.sequence.api.DbSequenceService;
import com.hefa.utils.JSR303ValidateUtils;
import com.hefa.utils.StringUtils;

/**
 * <P>发票业务</P>
 * @version 1.0
 * @author 黄智聪  2019年4月24日 下午5:46:51
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ClientInvoiceService {
	
	@Autowired
	private ClientInvoiceMapper clientInvoiceMapper;
	
	@Autowired
	private ClientOrderMapper clientOrderMapper;
	
	@Autowired
	private ClientOrderItemMapper clientOrderItemMapper;

	@Autowired
	private ClientShippingAddressMapper clientShippingAddressMapper;
	
	@Autowired
	private ClientInvoiceTemplateMapper clientInvoiceTemplateMapper;
	
	@Autowired
	DbSequenceService dbSequenceService;
	
	/**
	 * 
	 * <p>查询开票信息列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午7:04:36
	 */
	public JsonResult<Pagination<InvoiceInfo>> getInvoiceInfos(@RequestBody SearchInvoiceInfoParam param){
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		List<InvoiceInfo> infos = clientInvoiceMapper.getInvoiceInfos(param);
		return JsonResult.successJsonResult(new Pagination<>(infos));
	}
	
	/**
	 * 
	 * <p>查询发票详情</p>
	 * @param invoiceCode
	 * @return
	 * @author 黄智聪  2019年4月24日 下午7:00:10
	 */
	public JsonResult<InvoiceDetail> getInvoiceDetail(@RequestParam("invoiceCode") String invoiceCode){
		if(StringUtils.isBlank(invoiceCode)) {
			throw new ValidationException("开票编码不能为空");
		}
		InvoiceDetail detail = clientInvoiceMapper.getInvoiceDetail(invoiceCode);
		if(detail == null) {
			throw new ReturnDataException("开票信息不存在");
		}
		List<OrderItemInfo> orderItems = clientOrderItemMapper.getOrderItemInfosByOrderCode(detail.getOrderCode());
		detail.setOrderItemInfos(orderItems);
		return JsonResult.successJsonResult(detail);
	}
	
	/**
	 * 
	 * <p>开票申请</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月26日 上午11:06:28
	 */
	public JsonResult<String> invoiceApply(@RequestBody ApplyInvoiceParam param){
		OrderInfo orderInfo = this.checkApplyInvoiceParam(param);
		Date nowDate = new Date();
		String invoiceTemplateCode = "IT" + System.currentTimeMillis();
		String invoiceCode = dbSequenceService.getKPSequenceNo();
		ClientInvoice invoiceRecord = ClientInvoice.builder()
				.amount(orderInfo.getGrandTotal())
				.createTime(nowDate)
				.creator(param.getUserCode())
				.invoiceCode(invoiceCode)
				.invoiceStatus((byte)InvoiceStatus.PENDING.getValue())
				.invoiceTemplateCode(invoiceTemplateCode)
				.orderCode(param.getOrderCode())
				.quantity(1)
				.remark(param.getRemark())
				.shippingAddressCode(param.getShippingAddressCode())
				.userCode(param.getUserCode())
				.build();
		clientInvoiceMapper.insertSelective(invoiceRecord);
		ClientInvoiceTemplate invoiceTemplateRecord = ClientInvoiceTemplate.builder()
				.companyName(param.getCompanyName())
				.creator(param.getUserCode())
				.createTime(nowDate)
				.invoiceTemplateCode(invoiceTemplateCode)
				.invoiceTitle(param.getInvoiceTitle())
				.invoiceType(param.getInvoiceType())
				.userCode(param.getUserCode())
				.taxIdentificationNumber(param.getTaxIdentificationNumber())
				.build();
		clientInvoiceTemplateMapper.insertSelective(invoiceTemplateRecord);
		return JsonResult.successJsonResult();
	}

	/**
	 * 
	 * <p>校验开票信息</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月26日 下午1:44:14
	 */
	private OrderInfo checkApplyInvoiceParam(ApplyInvoiceParam param) {
		JSR303ValidateUtils.validateInputParam(param);
		if(!Invoicetype.checkStatusExist(param.getInvoiceType())) {
			throw new ValidationException("发票类型不存在");
		}
		// 校验订单是否存在、状态是否为已完成
		OrderInfo orderInfo = clientOrderMapper.getOrderInfoByOrderCode(param.getOrderCode());
		if(orderInfo == null) {
			throw new ReturnDataException("订单不存在");
		}
		if(orderInfo.getOrderStatus() != OrderStatus.COMPLETED.getValue()) {
			throw new ReturnDataException("订单状态异常，无法开票");
		}
		// 查询是否存在除已拒绝以外的开票记录
		int count = clientInvoiceMapper.isOrderExistInvoiceRecord(param.getOrderCode());
		if(count > 0 ) {
			throw new ReturnDataException("该订单已存在审批中的开票记录或已开票，请勿重复申请");
		}
		ClientShippingAddress shippingAddress = clientShippingAddressMapper.selectByCode(param.getShippingAddressCode());
		if(shippingAddress == null) {
			throw new ReturnDataException("收货地址不存在");
		}
		return orderInfo;
	}
	
}

