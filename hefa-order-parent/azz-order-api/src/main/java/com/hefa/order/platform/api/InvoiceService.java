/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月12日 下午3:14:43
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.platform.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.order.pojo.bo.ApproveInvoiceParam;
import com.hefa.order.pojo.bo.RejectInvoiceParam;
import com.hefa.order.pojo.bo.SearchInvoiceInfoParam;
import com.hefa.order.pojo.vo.ExpressCompanyInfo;
import com.hefa.order.pojo.vo.InvoiceDetail;
import com.hefa.order.pojo.vo.InvoiceInfo;

/**
 * 
 * <P>开票管理</P>
 * @version 1.0
 * @author 黄智聪  2019年4月22日 下午7:37:02
 */
@FeignClient(name = "hefa-order-service")
public interface InvoiceService {
	
	/**
	 * 
	 * <p>查询开票信息列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午7:04:36
	 */
	@RequestMapping("/hefa/api/platform/invoice/getInvoiceInfos")
	JsonResult<Pagination<InvoiceInfo>> getInvoiceInfos(@RequestBody SearchInvoiceInfoParam param);
	
	/**
	 * 
	 * <p>查询发票详情</p>
	 * @param invoiceCode
	 * @return
	 * @author 黄智聪  2019年4月24日 下午7:00:10
	 */
	@RequestMapping("/hefa/api/platform/invoice/getInvoiceDetail")
	JsonResult<InvoiceDetail> getInvoiceDetail(@RequestParam("invoiceCode") String invoiceCode);
	
	/**
	 * 
	 * <p>查询所有快递公司信息</p>
	 * @return
	 * @author 黄智聪  2019年4月25日 上午10:52:36
	 */
	@RequestMapping("/hefa/api/platform/invoice/getExpressCompanys")
	JsonResult<List<ExpressCompanyInfo>> getExpressCompanys() ;
	
	/**
	 * 
	 * <p>开票通过</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午7:54:06
	 */
	@RequestMapping("/hefa/api/platform/invoice/approveInvoice")
	JsonResult<String> approveInvoice(@RequestBody ApproveInvoiceParam param);
	
	/**
	 * 
	 * <p>开票拒绝</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午7:54:06
	 */
	@RequestMapping("/hefa/api/platform/invoice/rejectInvoice")
	JsonResult<String> rejectInvoice(@RequestBody RejectInvoiceParam param);
}

