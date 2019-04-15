/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月15日 下午2:52:28
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azz.controller.utils.WebUtils;
import com.azz.core.common.JsonResult;
import com.azz.core.common.page.Pagination;
import com.azz.order.api.client.ClientInvoiceService;
import com.azz.order.client.pojo.ClientInvoiceTemplate;
import com.azz.order.client.pojo.bo.AddEditInvoiceTemplateParam;
import com.azz.order.client.pojo.bo.AddInvoiceApplyParam;
import com.azz.order.client.pojo.bo.SearchAddInvoiceApplyParam;
import com.azz.order.client.pojo.bo.SearchClientInvoiceParam;
import com.azz.order.client.pojo.bo.SearchClientOrderParam;
import com.azz.order.client.pojo.bo.SearchInvoiceTemplateParam;
import com.azz.order.client.pojo.bo.SigningInvoiceParam;
import com.azz.order.client.pojo.vo.ClientAddInvoice;
import com.azz.order.client.pojo.vo.ClientInvoiceApplyDetail;
import com.azz.order.client.pojo.vo.ClientInvoiceList;
import com.azz.order.client.pojo.vo.ClientInvoiceTemplateList;
import com.azz.order.client.pojo.vo.ClientOrderItemInfo;

/**
 * <P>发票管理</P>
 * @version 1.0
 * @author 彭斌  2018年11月20日 下午4:08:24
 */
@RestController
@RequestMapping("/azz/api/client/invoice")
public class ClientInvoiceController {
	
	@Autowired
	private ClientInvoiceService clientInvoiceService;

	/**
	 * <p>查询客户发票管理列表</p>
	 * @param param
	 * @return
	 * @author 彭斌  2018年11月20日 下午4:17:24
	 */
	@RequestMapping("/getClientInvoiceList")
	public JsonResult<Pagination<ClientInvoiceList>> getClientInvoiceList(SearchClientInvoiceParam param){
		param.setClientUserCode(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
		return clientInvoiceService.getClientInvoiceList(param);
	}
	
	/**
	 * <p>根据发票类型和客户编码获取所有发票模板信息</p>
	 * @param param
	 * @return
	 * @author 彭斌  2018年11月20日 下午4:17:38
	 */
	@RequestMapping("/getInvoiceTemplateList")
	public JsonResult<List<ClientInvoiceTemplateList>> getInvoiceTemplateList(SearchInvoiceTemplateParam param){
	    param.setClientUserCode(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
	    return clientInvoiceService.getInvoiceTemplateList(param);
	}
	
	/**
	 * <p>获取新增开票申请列表</p>
	 * @param param
	 * @return
	 * @author 彭斌  2018年11月20日 下午4:17:45
	 */
	@RequestMapping("/getInvoiceClientList")
	public JsonResult<Pagination<ClientAddInvoice>> getInvoiceClientList(SearchAddInvoiceApplyParam param){
	    param.setClientUserCode(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
	    return clientInvoiceService.getInvoiceClientList(param);
	}
	
	/**
	 * <p>新增发票申请</p>
	 * @param param
	 * @return
	 * @author 彭斌  2018年11月20日 下午4:17:54
	 */
	@RequestMapping("/addInvoiceApply")
	public JsonResult<String> addInvoiceApply(AddInvoiceApplyParam param){
	    param.setCreator(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
	    return clientInvoiceService.addInvoiceApply(param);
	}
	
	/**
	 * <p>获取客户发票详情</p>
	 * @param invoiceId
	 * @return
	 * @author 彭斌  2018年11月20日 下午4:18:02
	 */
	@RequestMapping("/getClientInvoiceTemplateDetail")
	public JsonResult<ClientInvoiceTemplate> getClientInvoiceTemplateDetail(Long invoiceId){
		return clientInvoiceService.getClientInvoiceTemplateDetail(invoiceId);
	}
	
	/**
	 * <p>发票模板管理新增，编辑操作</p>
	 * @param param
	 * @return
	 * @author 彭斌  2018年11月20日 下午4:18:10
	 */
	@RequestMapping("/addEditInvoiceTemplate")
	public JsonResult<String> addEditInvoiceTemplate(AddEditInvoiceTemplateParam param){
	    param.setClientUserCode(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
		return clientInvoiceService.addEditInvoiceTemplate(param);
	}
	
	/**
	 * <p>删除发票模板</p>
	 * @param id
	 * @return
	 * @author 彭斌  2018年11月21日 上午10:30:27
	 */
	@RequestMapping("/delInvoiceTemplate")
	public JsonResult<String> delInvoiceTemplate(Long id){
	    return clientInvoiceService.delInvoiceTemplate(id, WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
	}
	
	/**
	 * <p>申请详情</p>
	 * @param param
	 * @return
	 * @author 彭斌  2018年11月21日 下午2:07:06
	 */
	@RequestMapping("/getClientInvoiceApplyDetail")
	public JsonResult<ClientInvoiceApplyDetail> getClientInvoiceApplyDetail(SearchAddInvoiceApplyParam param){
	    param.setClientUserCode(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
	    return clientInvoiceService.getClientInvoiceApplyDetail(param);
	}
	
	/**
	 * <p>获取客户订单明细</p>
	 * @param param
	 * @return
	 * @author 彭斌  2018年11月21日 下午4:27:53
	 */
	@RequestMapping("/getClientOrderItems")
	public JsonResult<List<ClientOrderItemInfo>> getClientOrderItems(SearchClientOrderParam param){
	    param.setClientUserCode(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
        return clientInvoiceService.getClientOrderItems(param);
	}
	
	/**
	 * <p>客户确认签收</p>
	 * @param param
	 * @return
	 * @author 彭斌  2018年11月24日 下午1:59:57
	 */
	@RequestMapping("/signingInvoice")
	public JsonResult<String> signingInvoice(SigningInvoiceParam param){
	    param.setClientUserCode(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
	    return clientInvoiceService.signingInvoice(param);
	}
}

