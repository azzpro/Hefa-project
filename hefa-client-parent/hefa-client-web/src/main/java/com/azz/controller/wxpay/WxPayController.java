/******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月26日 下午4:09:49
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.controller.wxpay;

import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.azz.core.common.JsonResult;
import com.azz.order.api.client.WxPayService;
import com.azz.order.client.wx.bo.WxPayOrderInfo;
import com.azz.util.HttpClientUtil;
import com.azz.util.LLPayUtil;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年11月26日 下午4:09:49
 */
@RestController
@RequestMapping("/azz/api/wx/pay")
public class WxPayController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WxPayService wx;
	
	/**
	 * 微信支付提交订单
	 * @param request
	 * @param po
	 * @return
	 */
	@RequestMapping("submitWxOrderPay")
	public Map<String,String> submitWxOrderPay(HttpServletRequest request,WxPayOrderInfo po){
		po.setIp(LLPayUtil.getIpAddrD(request));
		Map<String, String> submitOrderPay = wx.submitOrderPay(po);
		return submitOrderPay;
	}
	
	
	
	/** 支付回调
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="callback",method=RequestMethod.POST)
	public void callback(HttpServletRequest request,HttpServletResponse response) {
		log.info("进入微信支付回调");
		InputStream is = null;
		try {
			is = request.getInputStream();
			String xml = HttpClientUtil.InputStream2String(is);
			String callback = wx.callback(xml);
			response.getWriter().write(callback);
			response.getWriter().flush();
			is.close();
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
}