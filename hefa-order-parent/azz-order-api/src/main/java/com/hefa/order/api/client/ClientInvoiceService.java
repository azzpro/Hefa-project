/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月24日 下午5:46:51
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.order.pojo.bo.ApplyInvoiceParam;
import com.hefa.order.pojo.bo.SearchInvoiceInfoParam;
import com.hefa.order.pojo.vo.InvoiceDetail;
import com.hefa.order.pojo.vo.InvoiceInfo;

/**
 * <P>发票业务</P>
 * @version 1.0
 * @author 黄智聪  2019年4月24日 下午5:46:51
 */
@FeignClient(name = "hefa-order-service")
public interface ClientInvoiceService {
	
	/**
	 * 
	 * <p>查询开票信息列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午7:04:36
	 */
	@RequestMapping("/hefa/api/client/invoice/getInvoiceInfos")
	JsonResult<Pagination<InvoiceInfo>> getInvoiceInfos(@RequestBody SearchInvoiceInfoParam param);
	
	/**
	 * 
	 * <p>查询发票详情</p>
	 * @param invoiceCode
	 * @return
	 * @author 黄智聪  2019年4月24日 下午7:00:10
	 */
	@RequestMapping("/hefa/api/client/invoice/getInvoiceDetail")
	JsonResult<InvoiceDetail> getInvoiceDetail(@RequestParam("invoiceCode") String invoiceCode);
	
	/**
	 * 
	 * <p>开票申请</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月26日 上午11:06:28
	 */
	@RequestMapping("/hefa/api/client/invoice/invoiceApply")
	JsonResult<String> invoiceApply(@RequestBody ApplyInvoiceParam param);
	
}

