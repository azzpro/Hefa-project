/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月24日 下午5:46:51
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.platform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.hefa.common.base.JsonResult;
import com.hefa.common.constants.PlatformConstants.DeliveryType;
import com.hefa.common.exception.ReturnDataException;
import com.hefa.common.exception.ValidationException;
import com.hefa.common.page.Pagination;
import com.hefa.order.mapper.ClientInvoiceMapper;
import com.hefa.order.mapper.ClientOrderItemMapper;
import com.hefa.order.pojo.bo.ApproveInvoiceParam;
import com.hefa.order.pojo.bo.SearchInvoiceInfoParam;
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
public class InvoiceService {
	
	@Autowired
	private ClientInvoiceMapper clientInvoiceMapper;
	
	@Autowired
	private ClientOrderItemMapper clientOrderItemMapper;
	
	/**
	 * 
	 * <p>查询发票列表</p>
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
	 * <p>开票通过</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午7:54:06
	 */
	public JsonResult<String> approveInvoice(@RequestBody ApproveInvoiceParam param){
		JSR303ValidateUtils.validateInputParam(param);
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
			
			// TODO 
			
		}else if(DeliveryType.SELF.getValue() == param.getDeliveryType()) {
			String deliveryPerson = param.getDeliveryPerson();
			if(StringUtils.isBlank(deliveryPerson)) {
				throw new ValidationException("请填写配送人员姓名");
			}
			String deliveryPhone = param.getDeliveryPhone();
			if(StringUtils.isBlank(deliveryPhone)) {
				throw new ValidationException("请填写配送人员联系方式");
			}
			
			// TODO 
			
			
		}else {
			throw new ValidationException("配送方式不存在");
		}
		return JsonResult.successJsonResult();
	}
	

}

