/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月14日 上午11:22:40
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.common.base.JsonResult;
import com.hefa.system.bo.SmsCheck;
import com.hefa.system.bo.SmsCodeValidation;
import com.hefa.system.bo.SmsParams;
import com.hefa.system.service.SystemSmsSendService;
import com.hefa.system.vo.SmsInfo;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年11月14日 上午11:22:40
 */
@RestController
@RequestMapping("/hefa/api/system")
public class SmsSendController {
	
	@Autowired
	private SystemSmsSendService sendService;
	
	/**
	 * <p>短信发送</p>
	 * @param sms
	 * @return
	 * @author 刘建麟  2018年11月14日 上午11:24:14
	 */
	@RequestMapping("smsSend")
	public JsonResult<String> sendSmsCode(@RequestBody SmsParams sms) {
		return sendService.sendSmsCode(sms);
	}
	
	
	/**
	 * <p>短信验证码时间校验</p>
	 * @param sms
	 * @return
	 * @author 刘建麟  2018年11月14日 上午11:24:14
	 */
	@RequestMapping("validationCode")
	public JsonResult<SmsInfo> checkMsgCodeTime(@RequestBody SmsCodeValidation sms) {
		return sendService.checkMsgCodeTime(sms);
	}
	
	/**
	 * <p>短信验证码时间校验</p>
	 * @param sms
	 * @return
	 * @author 刘建麟  2018年11月14日 上午11:24:14
	 */
	@RequestMapping("checkMsgCode")
	public JsonResult<SmsInfo> checkMsgCode(@RequestBody SmsCheck sms) {
		return sendService.checkMsgCode(sms);
	}
}

