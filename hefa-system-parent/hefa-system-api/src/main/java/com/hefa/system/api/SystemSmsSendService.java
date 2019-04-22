/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月23日 下午1:47:30
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.system.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hefa.common.base.JsonResult;
import com.hefa.system.bo.SmsCheck;
import com.hefa.system.bo.SmsCodeValidation;
import com.hefa.system.bo.SmsParams;
import com.hefa.system.vo.SmsInfo;

/**
 * <P>短信发送</P>
 * @version 1.0
 * @author 刘建麟  2018年10月23日 下午1:47:30
 */
@FeignClient("hefa-system-service")
public interface SystemSmsSendService {
	
	
	@RequestMapping(value="/hefa/api/system/smsSend",method=RequestMethod.POST)
	JsonResult<String> sendSmsCode(@RequestBody SmsParams sms);
	
	@RequestMapping(value="/hefa/api/system/validationCode",method=RequestMethod.POST)
	JsonResult<SmsInfo> checkMsgCodeTime(@RequestBody SmsCodeValidation sv);

	@RequestMapping(value="/hefa/api/system/checkMsgCode",method=RequestMethod.POST)
	JsonResult<SmsInfo> checkMsgCode(@RequestBody SmsCheck sc);
}

