package com.hefa.order.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.order.platform.service.InvoiceService;
import com.hefa.order.pojo.bo.ApproveInvoiceParam;
import com.hefa.order.pojo.bo.RejectInvoiceParam;
import com.hefa.order.pojo.bo.SearchInvoiceInfoParam;
import com.hefa.order.pojo.vo.ExpressCompanyInfo;
import com.hefa.order.pojo.vo.InvoiceDetail;
import com.hefa.order.pojo.vo.InvoiceInfo;

/**
 * 
 * <P>开票</P>
 * @version 1.0
 * @author 黄智聪  2019年4月25日 上午11:15:25
 */
@RestController
@RequestMapping("/hefa/api/platform/invoice")
public class ClientInvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	
	/**
	 * 
	 * <p>查询开票信息列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午7:04:36
	 */
	@RequestMapping("/getInvoiceInfos")
	public JsonResult<Pagination<InvoiceInfo>> getInvoiceInfos(@RequestBody SearchInvoiceInfoParam param){
		return invoiceService.getInvoiceInfos(param);
	}
	
	/**
	 * 
	 * <p>查询发票详情</p>
	 * @param invoiceCode
	 * @return
	 * @author 黄智聪  2019年4月24日 下午7:00:10
	 */
	@RequestMapping("/getInvoiceDetail")
	public JsonResult<InvoiceDetail> getInvoiceDetail(@RequestParam("invoiceCode") String invoiceCode){
		return invoiceService.getInvoiceDetail(invoiceCode);
	}
	
	/**
	 * 
	 * <p>查询所有快递公司信息</p>
	 * @return
	 * @author 黄智聪  2019年4月25日 上午10:52:36
	 */
	@RequestMapping("/getExpressCompanys")
	public JsonResult<List<ExpressCompanyInfo>> getExpressCompanys() {
		return invoiceService.getExpressCompanys();
	}
	
	/**
	 * 
	 * <p>开票通过</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午7:54:06
	 */
	@RequestMapping("/approveInvoice")
	public JsonResult<String> approveInvoice(@RequestBody ApproveInvoiceParam param){
		return invoiceService.approveInvoice(param);
	}
	
	/**
	 * 
	 * <p>开票拒绝</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午7:54:06
	 */
	@RequestMapping("/rejectInvoice")
	public JsonResult<String> rejectInvoice(@RequestBody RejectInvoiceParam param){
		return invoiceService.rejectInvoice(param);
	}

}
