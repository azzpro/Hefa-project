/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月26日 下午3:19:35
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.order.api.client;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.azz.core.common.JsonResult;
import com.azz.core.common.page.Pagination;
import com.azz.order.client.pojo.ClientPay;
import com.azz.order.client.pojo.RetBean;
import com.azz.order.client.pojo.bo.BankBranch;
import com.azz.order.client.pojo.bo.EnterprisereginfoCopy;
import com.azz.order.client.pojo.bo.PageOrder;
import com.azz.order.client.pojo.bo.PayList;
import com.azz.order.client.pojo.bo.Personreginfo;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年11月26日 下午3:19:35
 */
@FeignClient("azz-order-service")
public interface ClientPayService {
	
	/**
	 * <p>分账回调</p>
	 * @author 刘建麟  2018年12月17日 下午6:27:10
	 */
	@RequestMapping(value="/azz/api/pay/divideNotify",method=RequestMethod.POST)
	public JsonResult<RetBean> divideNotify(@RequestParam("responseMsg") String responseMsg,@RequestParam("customerId") String customerId);
	
	/**
	 * <p>支付回调</p>
	 * @author 刘建麟  2018年12月17日 下午6:27:10
	 */
	@RequestMapping(value="/azz/api/pay/payNotify",method=RequestMethod.POST)
	public JsonResult<RetBean> payNotify(@RequestParam("responseMsg") String responseMsg,@RequestParam("customerId") String customerId);
	
	/**
	 * <p>提交支付</p>
	 * @param spp
	 * @return
	 * @author 刘建麟  2018年11月26日 下午3:20:20
	 */
	@RequestMapping(value="/azz/api/pay/submitOrderPay",method=RequestMethod.POST)
	public Map<String,Object> submitOrderPay(@RequestBody PageOrder po);
	
	/**
	 * 获取支行信息
	 * @param request
	 * @param po
	 * @return
	 */
	@RequestMapping("/azz/api/pay/getBankBranchInfo")
	public Map<String,String> getBankBranchInfo(@RequestBody BankBranch bb);
		
	
	/**
	 * <p>支付管理列表</p>
	 * @param param
	 * @return
	 * @author 刘建麟  2018年12月3日 下午2:46:08
	 */
	@RequestMapping("/azz/api/pay/toPayList")
	public JsonResult<Pagination<ClientPay>> toPayList(@RequestBody PayList pl);
	
	/**
	 * <p>
	 * 支付订单详情
	 * </p>
	 * 
	 * @param param
	 * @return
	 * @author 刘建麟 2018年10月31日 上午11:29:49
	 */
	@RequestMapping("/azz/api/pay/getOrderInfo")
	public JsonResult<ClientPay> getOrderInfo(@RequestParam("number") String number) ;
}

