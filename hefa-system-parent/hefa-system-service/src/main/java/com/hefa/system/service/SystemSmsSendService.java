/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月23日 下午5:18:16
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.system.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.hefa.common.base.JsonResult;
import com.hefa.common.constants.SmsConstants;
import com.hefa.common.constants.SmsConstants.SmsCode;
import com.hefa.common.constants.SmsErrorCode;
import com.hefa.common.exception.SmsException;
import com.hefa.common.exception.ValidationException;
import com.hefa.system.bo.SmsCheck;
import com.hefa.system.bo.SmsCodeValidation;
import com.hefa.system.bo.SmsParams;
import com.hefa.system.mapper.SystemMsgLogMapper;
import com.hefa.system.pojo.SystemMsgLog;
import com.hefa.system.vo.SmsInfo;
import com.hefa.utils.CalendarUtil;
import com.hefa.utils.JSR303ValidateUtils;
import com.hefa.utils.RandomStringUtils;
import com.hefa.utils.SmsInfoUtil;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年10月23日 下午5:18:16
 */
@Service
public class SystemSmsSendService {

private static final Logger LOG = LoggerFactory.getLogger(SystemSmsSendService.class);
	
	@Value("${aliyun.accessKeyId}")
	private String accessKeyId;
	
	@Value("${aliyun.accessKeySecret}")
	private String accessKeySecret;
	
	@Value("${aliyun.signName}")
	private String signName;
	
	@Value("${aliyun.product}")
	private String product;
	
	@Value("${aliyun.domain}")
	private String domain;
	
	@Autowired
	private SystemMsgLogMapper smlm;
	
	/**
	 * <p>验证码是否正确</p>
	 * @param sc
	 * @return
	 * @author 刘建麟  2018年11月14日 下午7:00:59
	 */
	public JsonResult<SmsInfo> checkMsgCode(@RequestBody SmsCheck sc){
		JSR303ValidateUtils.validateInputParam(sc);
		SystemMsgLog code = smlm.findMsgLogByPhoneAndCode(Long.parseLong(sc.getPhone()), sc.getCode());
		if(null == code) {
			return new JsonResult<>(new SmsInfo(SmsCode.FAILD.getCode(), SmsCode.FAILD.getDesc()));
		}else {
			return new JsonResult<>(new SmsInfo(SmsCode.SUCCESS.getCode(), SmsCode.SUCCESS.getDesc()));
		}
	}
	
	/**
	 * <p>校验验证码时间是否有效</p>
	 * @param phone
	 * @param sec
	 * @return
	 * @author 刘建麟  2018年11月14日 下午5:30:38
	 */
	 public JsonResult<SmsInfo> checkMsgCodeTime(@RequestBody SmsCodeValidation sv){
		JSR303ValidateUtils.validateInputParam(sv);
		SystemMsgLog findMsgLog = smlm.findMsgLog(Long.parseLong(sv.getPhone()));
		if(null != findMsgLog) {
			if((System.currentTimeMillis()/1000-findMsgLog.getMsgTime().getTime()/1000) < sv.getSec()) {
				return new JsonResult<>(new SmsInfo(SmsCode.SUCCESS.getCode(), SmsCode.SUCCESS.getDesc()));
			}
			return new JsonResult<>(new SmsInfo(SmsCode.FAILD.getCode(), SmsCode.FAILD.getDesc()));
		}
		return new JsonResult<>(new SmsInfo(SmsCode.NO_EXIST.getCode(), SmsCode.NO_EXIST.getDesc()));
	}
	
	/**
	 * <p>发送验证码</p>
	 * @param sms
	 * @return
	 * @author 刘建麟  2018年11月14日 下午5:28:56
	 */
	public JsonResult<String> sendSmsCode(@RequestBody SmsParams sms){
		JSR303ValidateUtils.validateInputParam(sms);
		//发送频率校验
		String today = CalendarUtil.getFormatDateTime(new Date(), "yyyy-MM-dd");
		List<SystemMsgLog> logs = smlm.findMsgLogByPhone(Long.parseLong(sms.getPhone()), today);
		if (!smsSendRole(logs))
			throw new SmsException(SmsErrorCode.BUSINESS_LIMIT_CONTROL);
		SmsConstants smsConstants = SmsInfoUtil.getSmsConstants(sms.getMsgType());
		if(null == smsConstants)
			throw new SmsException(SmsErrorCode.INVALID_PARAMETERS);
		SystemMsgLog sml = new SystemMsgLog();
		if(StringUtils.isNotBlank(sms.getCode())) {
			sml.setMsgCode(sms.getCode());
		}else {
			sml.setMsgCode(RandomStringUtils.generNumCode(6));
		}
		sml.setMsgContent(smsConstants.getMsgContent().replace("${code}", sml.getMsgCode()));
		sml.setMsgPhone(Long.parseLong(sms.getPhone()));
		sml.setMsgTitle(smsConstants.getName());
		sml.setMsgType(sms.getMsgType());
		sml.setMsgPlatform("阿里云短信平台");
		sml.setMsgTime(new Date());
		LOG.info("短信日志======>"+sml.toString());
		int i = smlm.insertSelective(sml);
		if(i == 1) {
			JsonResult<SmsInfo> sms2 = sendSms(sml,smsConstants);
			if(null != sms2 && sms2.getData().getCode().equals("OK")) {
				smlm.updaetSmsStatus(1, sml.getId());
				return JsonResult.successJsonResult();
			}else {
				smlm.updaetSmsStatus(2, sml.getId());
				LOG.error("短信发送错误码====>"+sms2.getData().getCode());
				LOG.error("短信发送错误====>"+sms2.getData().getMsg());
				throw new SmsException(SmsErrorCode.SEND_OF_FAILED);
			}
		}else {
			throw new SmsException(SmsErrorCode.SEND_OF_FAILED);
		}
		
	}
	
	private JsonResult<SmsInfo> sendSms(SystemMsgLog sml,SmsConstants sc) {
		//设置HTTP 超时时间
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		} catch (ClientException e) {
			throw new ValidationException("初始化短信发送失败");
		}
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        //发送手机号
        request.setPhoneNumbers(sml.getMsgPhone()+"");
        //必填:短信签名
        request.setSignName(signName);
        //必填:短信模板
        request.setTemplateCode(sc.getCode());
        if(sc.getType() == 2) {//短信通知
        	//短信验证码
        	request.setTemplateParam("{\"code\":"+sml.getMsgCode()+"}");
        }
        SendSmsResponse sendSmsResponse = null;
        try {
			sendSmsResponse = acsClient.getAcsResponse(request);
		} catch (ServerException e) {
			throw new ValidationException("短信发送异常");
		} catch (ClientException e) {
			throw new ValidationException("短信发送异常");
		}
        if(null == sendSmsResponse || !sendSmsResponse.getCode().equals("OK")) {
        	return new JsonResult<>(new SmsInfo(sendSmsResponse.getCode(),sendSmsResponse.getMessage()));
        }
        return new JsonResult<>(new SmsInfo(sendSmsResponse.getCode(),sendSmsResponse.getMessage()));
	}
	
	private boolean smsSendRole(List<SystemMsgLog> smslogs) {
		boolean b = true;
		if (null == smslogs || smslogs.isEmpty())
			return b;

		// 30秒内限制1条
		Date lastSendTime = smslogs.get(smslogs.size()-1).getMsgTime();
		if ((System.currentTimeMillis() - lastSendTime.getTime()) < 1000l * 30) {
			return false;
		}
		// 1小时内限制10条
		int count = getCountByHour(smslogs);
		if (count > 10) {
			return false;
		}
		// 1天内限制20条
		if (smslogs.size() > 20)
			return false;

		return b;
	}
	private int getCountByHour(List<SystemMsgLog> logs) {
		int n = 0;
		long now = System.currentTimeMillis();
		for (SystemMsgLog log : logs) {
			Date tmp = log.getMsgTime();
			if (now - tmp.getTime() < 1000 * 60 * 60)
				n++;
		}
		return n;
	}
}

