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
import com.hefa.common.constants.PlatformConstants.DeliveryType;
import com.hefa.common.constants.PlatformConstants.InvoiceStatus;
import com.hefa.common.exception.BusinessException;
import com.hefa.common.exception.ReturnDataException;
import com.hefa.common.exception.ValidationException;
import com.hefa.common.page.Pagination;
import com.hefa.order.mapper.ClientInvoiceLogisticsMapper;
import com.hefa.order.mapper.ClientInvoiceMapper;
import com.hefa.order.mapper.ClientOrderItemMapper;
import com.hefa.order.mapper.ClientOrderMapper;
import com.hefa.order.pojo.ClientInvoice;
import com.hefa.order.pojo.ClientInvoiceLogistics;
import com.hefa.order.pojo.ClientOrder;
import com.hefa.order.pojo.bo.ApproveInvoiceParam;
import com.hefa.order.pojo.bo.RejectInvoiceParam;
import com.hefa.order.pojo.bo.SearchInvoiceInfoParam;
import com.hefa.order.pojo.vo.ExpressCompanyInfo;
import com.hefa.order.pojo.vo.InvoiceDetail;
import com.hefa.order.pojo.vo.InvoiceInfo;
import com.hefa.order.pojo.vo.OrderItemInfo;
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
	private ClientInvoiceLogisticsMapper clientInvoiceLogisticsMapper;
	
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
	 * <p>查询所有快递公司信息</p>
	 * @return
	 * @author 黄智聪  2019年4月25日 上午10:52:36
	 */
	public JsonResult<List<ExpressCompanyInfo>> getExpressCompanys() {
		List<ExpressCompanyInfo> infos = clientInvoiceMapper.getExpressCompanyInfos();
		return JsonResult.successJsonResult(infos);
	}
	
	/**
	 * 
	 * <p>开票通过</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午7:54:06
	 */
	public JsonResult<String> approveInvoice(@RequestBody ApproveInvoiceParam param){
		JSR303ValidateUtils.validateInputParam(param);
		ClientInvoice invoice = this.checkInvoice(param.getInvoiceCode());
		Date nowDate = new Date();
		ClientInvoiceLogistics logisticsRecord = null;
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
			logisticsRecord = ClientInvoiceLogistics.builder()
					.expressCompanyId(expressCompanyId)
					.number(number)
					.deliveryType((byte)DeliveryType.EXPRESS.getValue())
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
			logisticsRecord = ClientInvoiceLogistics.builder()
					.deliveryPerson(deliveryPerson)
					.deliveryPhone(deliveryPhone)
					.deliveryType((byte)DeliveryType.SELF.getValue())
					.build();
		}else {
			throw new ValidationException("配送方式不存在");
		}
		// 修改开票状态 
		ClientInvoice invoiceRecord = ClientInvoice.builder()
				.modifier(param.getModifier())
				.modifyTime(nowDate)
				.invoiceStatus((byte)InvoiceStatus.APPROVED.getValue())
				.id(invoice.getId())
				.build();
		clientInvoiceMapper.updateByPrimaryKeySelective(invoiceRecord);
		// 新增开票快递信息
		logisticsRecord.setCreateTime(nowDate);
		logisticsRecord.setCreator(param.getModifier());
		logisticsRecord.setInvoiceCode(param.getInvoiceCode());
		clientInvoiceLogisticsMapper.insertSelective(logisticsRecord);
		// 修改订单开票状态为已开票
		ClientOrder orderRecord = new ClientOrder();
		orderRecord.setOrderCode(invoice.getOrderCode());
		orderRecord.setInvoiceStatus((byte)1);
		clientOrderMapper.updateByOrderCodeSelective(orderRecord);
		return JsonResult.successJsonResult();
	}
	
	/**
	 * 
	 * <p>开票拒绝</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午7:54:06
	 */
	public JsonResult<String> rejectInvoice(@RequestBody RejectInvoiceParam param){
		JSR303ValidateUtils.validateInputParam(param);
		ClientInvoice invoice = this.checkInvoice(param.getInvoiceCode());
		Date nowDate = new Date();
		// 修改开票状态 
		ClientInvoice invoiceRecord = ClientInvoice.builder()
				.modifier(param.getModifier())
				.modifyTime(nowDate)
				.invoiceStatus((byte)InvoiceStatus.REJECTED.getValue())
				.remark(param.getRemark())
				.id(invoice.getId())
				.build();
		clientInvoiceMapper.updateByPrimaryKeySelective(invoiceRecord);
		
		return JsonResult.successJsonResult();
	}

	/**
	 * 
	 * <p>校验开票信息</p>
	 * @param invoiceCode
	 * @author 黄智聪  2019年4月25日 上午10:29:01
	 */
	private ClientInvoice checkInvoice(String invoiceCode) {
		ClientInvoice invoice = clientInvoiceMapper.selectByCode(invoiceCode);
		if(invoice == null) {
			throw new ReturnDataException("开票记录不存在");
		}
		if(invoice.getInvoiceStatus() != InvoiceStatus.PENDING.getValue()) {
			throw new BusinessException("开票状态异常");
		}
		return invoice;
	}

}

