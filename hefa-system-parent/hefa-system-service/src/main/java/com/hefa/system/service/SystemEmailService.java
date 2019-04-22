/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年12月13日 下午1:40:38
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.system.service;

import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.hefa.common.base.JsonResult;
import com.hefa.common.constants.EmailConstants;
import com.hefa.common.constants.SmsConstants.SmsCode;
import com.hefa.common.constants.SmsErrorCode;
import com.hefa.common.exception.SmsException;
import com.hefa.system.bo.MailCheck;
import com.hefa.system.bo.MailCodeValidation;
import com.hefa.system.bo.MailParam;
import com.hefa.system.mapper.SystemMsgLogMapper;
import com.hefa.system.pojo.SystemMsgLog;
import com.hefa.system.vo.SmsInfo;
import com.hefa.utils.CalendarUtil;
import com.hefa.utils.JSR303ValidateUtils;
import com.hefa.utils.RandomStringUtils;
import com.sun.mail.util.MailSSLSocketFactory;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年12月13日 下午1:40:38
 */
@Service
public class SystemEmailService {
	@Autowired
	private SystemMsgLogMapper smlm;
	
	@Value("${email.account}")
	private String account;
	
	@Value("${email.pass}")
	private String pass;
	
	@Value("${email.port}")
	private String port;
	
	@Value("${email.protocol}")
	private String protocol;
	
	@Value("${email.host}")
	private String host;
	
	static class MyAuthenricator extends Authenticator{  
        String u = null;  
        String p = null;  
        public MyAuthenricator(String u,String p){  
            this.u=u;  
            this.p=p;  
        }  
        @Override  
        protected PasswordAuthentication getPasswordAuthentication() {  
            return new PasswordAuthentication(u,p);  
        }  
    }
	
	/**
	 * <p>验证码是否正确</p>
	 * @param sc
	 * @return
	 * @author 刘建麟  2018年11月14日 下午7:00:59
	 */
	public JsonResult<SmsInfo> checkMailCode(@RequestBody MailCheck sc){
		JSR303ValidateUtils.validateInputParam(sc);
		SystemMsgLog code = smlm.findMsgLogByMailAndCode(sc.getMail(), sc.getCode());
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
	 public JsonResult<SmsInfo> validationMailCodeTime(@RequestBody MailCodeValidation sv){
		JSR303ValidateUtils.validateInputParam(sv);
		SystemMsgLog findMsgLog = smlm.findMailLog(sv.getMail());
		if(null != findMsgLog) {
			if((System.currentTimeMillis()/1000-findMsgLog.getMsgTime().getTime()/1000) < sv.getSec()) {
				return new JsonResult<>(new SmsInfo(SmsCode.SUCCESS.getCode(), SmsCode.SUCCESS.getDesc()));
			}
			return new JsonResult<>(new SmsInfo(SmsCode.FAILD.getCode(), SmsCode.FAILD.getDesc()));
		}
		return new JsonResult<>(new SmsInfo(SmsCode.NO_EXIST.getCode(), SmsCode.NO_EXIST.getDesc()));
	}
	
	
	
	public JsonResult<SmsInfo> sendMail(@RequestBody MailParam m){
		JSR303ValidateUtils.validateInputParam(m);
		//发送频率校验
		String today = CalendarUtil.getFormatDateTime(new Date(), "yyyy-MM-dd");
		List<SystemMsgLog> logs = smlm.findMsgLogByMail(m.getTo(), today);
		if (!emailSendRole(logs)) {
			throw new SmsException(SmsErrorCode.BUSINESS_LIMIT_CONTROL);
		}
		SystemMsgLog sml = new SystemMsgLog();
		sml.setMsgCode(RandomStringUtils.generNumCode(6));
		sml.setMsgContent(EmailConstants.EMAIL_CONTENT_PERFIX.replace("${code}", sml.getMsgCode()));
		sml.setMsgMail(m.getTo());
		sml.setMsgTitle(StringUtils.isBlank(m.getSubject())?EmailConstants.EMAIL_SUBJECT:m.getSubject());
		sml.setMsgType(7);
		sml.setMsgPlatform("腾讯企业邮箱");
		sml.setMsgTime(new Date());
		int i = smlm.insertSelective(sml);
		if(i == 1) {
			m.setContent(sml.getMsgContent());
			m.setSubject(sml.getMsgTitle());
			JsonResult<SmsInfo> sms2 = send(m);
			if(null != sms2 && sms2.getData().getCode().equals(EmailConstants.EMAIL_SEND_SUCCESS)) {
				smlm.updaetSmsStatus(1, sml.getId());
				return sms2;
			}else {
				smlm.updaetSmsStatus(2, sml.getId());
				return sms2;
			}
		}else {
			return new JsonResult<>(new SmsInfo(EmailConstants.EMAIL_SEND_FAILED,EmailConstants.EMAIL_SEND_FAILED_MSG));
		}
		
    }
	
	private JsonResult<SmsInfo>  send(MailParam m) {
		Properties prop = new Properties();
        //协议
        prop.setProperty("mail.transport.protocol", protocol);
        //服务器
        prop.setProperty("mail.smtp.host", host);
        //端口
        prop.setProperty("mail.smtp.port", port);
        //使用smtp身份验证
        prop.setProperty("mail.smtp.auth", "true");
        //使用SSL，企业邮箱必需！
        //开启安全协议
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
        } catch (GeneralSecurityException e1) {
        	return new JsonResult<>(new SmsInfo(EmailConstants.EMAIL_SEND_FAILED,EmailConstants.EMAIL_SEND_FAILED_MSG));
        }
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);
        
        Session session = Session.getInstance(prop, new MyAuthenricator(account, pass));
        session.setDebug(true);
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            //发件人
            mimeMessage.setFrom(new InternetAddress(account));  
            //收件人
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(m.getTo()));
            //主题
            if(StringUtils.isNotBlank(m.getSubject())) {
            	mimeMessage.setSubject(m.getSubject());
            }else {
            	mimeMessage.setSubject(EmailConstants.EMAIL_SUBJECT);
            }
            //时间
            mimeMessage.setSentDate(new Date());
            //容器类，可以包含多个MimeBodyPart对象
            Multipart mp = new MimeMultipart();
            //设置邮件内容
            mimeMessage.setContent(mp);
            //仅仅发送文本
            mimeMessage.setText(m.getContent());
            mimeMessage.saveChanges();
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
        	return new JsonResult<>(new SmsInfo(EmailConstants.EMAIL_SEND_FAILED,EmailConstants.EMAIL_SEND_FAILED_MSG));
        }
         return new JsonResult<>(new SmsInfo(EmailConstants.EMAIL_SEND_SUCCESS,EmailConstants.EMAIL_SEND_SUCCESS_MSG));
	}
	
	private boolean emailSendRole(List<SystemMsgLog> smslogs) {
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

