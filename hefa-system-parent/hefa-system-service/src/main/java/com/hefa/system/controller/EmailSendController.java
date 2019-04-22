/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年12月13日 上午10:38:20
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.common.base.JsonResult;
import com.hefa.system.bo.MailCheck;
import com.hefa.system.bo.MailCodeValidation;
import com.hefa.system.bo.MailParam;
import com.hefa.system.service.SystemEmailService;
import com.hefa.system.vo.SmsInfo;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年12月13日 上午10:38:20
 */
@RestController
@RequestMapping("/hefa/api/system")
public class EmailSendController {
	
	@Autowired
	private SystemEmailService ses;
	
	/**
	 * <p>发送邮件</p>
	 * @param m
	 * @return
	 * @author 刘建麟  2018年12月13日 下午2:01:35
	 */
	@RequestMapping("sendMail")
	public JsonResult<SmsInfo> sendMail(@RequestBody MailParam m){
		return ses.sendMail(m);
	}
    
	/**
	 * <p>邮件验证码时间校验</p>
	 * @param sms
	 * @return
	 * @author 刘建麟  2018年11月14日 上午11:24:14
	 */
	@RequestMapping("validationMailCodeTime")
	public JsonResult<SmsInfo> validationMailCodeTime(@RequestBody MailCodeValidation sms) {
		return ses.validationMailCodeTime(sms);
	}
	
	/**
	 * <p>邮件验证码校验</p>
	 * @param sms
	 * @return	
	 * @author 刘建麟  2018年11月14日 上午11:24:14
	 */
	@RequestMapping("checkMailCode")
	public JsonResult<SmsInfo> checkMailCode(@RequestBody MailCheck sms) {
		return ses.checkMailCode(sms);
	}
}

