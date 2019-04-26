package com.hefa.user.service;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.hefa.common.base.JsonResult;
import com.hefa.common.constants.EmailConstants;
import com.hefa.common.constants.SmsConstants;
import com.hefa.common.constants.UserConstants;
import com.hefa.common.constants.SmsConstants.SmsCode;
import com.hefa.common.exception.ValidationException;
import com.hefa.common.page.Pagination;
import com.hefa.system.api.SystemEmailService;
import com.hefa.system.api.SystemSmsSendService;
import com.hefa.system.bo.MailCheck;
import com.hefa.system.bo.MailCodeValidation;
import com.hefa.system.bo.MailParam;
import com.hefa.system.bo.SmsCheck;
import com.hefa.system.bo.SmsCodeValidation;
import com.hefa.system.bo.SmsParams;
import com.hefa.system.vo.SmsInfo;
import com.hefa.user.mapper.MemberUserMapper;
import com.hefa.user.pojo.bo.CheckVerificationCodeParam;
import com.hefa.user.pojo.bo.MemberParam;
import com.hefa.user.pojo.bo.UpdataUserPasswd;
import com.hefa.user.pojo.vo.MemberInfo;
import com.hefa.utils.JSR303ValidateUtils;
import com.hefa.utils.MD5Encrypt;

@Service
public class MemberUserService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberUserService.class);
	
	@Autowired
	private MemberUserMapper memberUserMapper;
	
	@Autowired
	private SystemSmsSendService systemSmsSendService;
	
	@Autowired
	private SystemEmailService systemEmailService;
	/**
	 * 
	 * <p>发送短信验证码</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	public JsonResult<String> sendMsg( String phone){
		SmsParams sms = new SmsParams();
		sms.setPhone(phone);
		//TODO 短信模板
		sms.setMsgType(SmsConstants.CHANGE_DATA.getMsgType());
		return systemSmsSendService.sendSmsCode(sms);
	} 
	
	
	/**
	 * 
	 * <p>发送Email验证码</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	public JsonResult<String> sendEmail( String email){
		MailParam m = new MailParam();
		m.setTo(email);
		JsonResult<SmsInfo> jr = systemEmailService.sendMail(m);
		if (jr.getData() == null || !jr.getData().getCode().equals(EmailConstants.EMAIL_SEND_SUCCESS)) {
			throw new ValidationException("邮箱验证码发送失败，请重试");
		}
		return JsonResult.successJsonResult();
	} 
	
	/**
	 * 
	 * <p>
	 * 校验验证码 
	 * </p>
	 * 
	 * @param param
	 * @return
	 * @author 黄智聪 2018年11月26日 下午7:10:22
	 */
	public JsonResult<String> checkEditVerificationCode(@RequestBody CheckVerificationCodeParam param) {
		JSR303ValidateUtils.validateInputParam(param);
		String phoneNumber = param.getPhoneNumber();
		String verificationCode = param.getVerificationCode();
		// 先校验验证码是否已失效
		SmsCodeValidation sv = new SmsCodeValidation();
		sv.setPhone(phoneNumber);
		sv.setSec(UserConstants.CHANGE_DATA_SMS_TIME_OUT);
		JsonResult<SmsInfo> jr = systemSmsSendService.checkMsgCodeTime(sv);
		if (jr.getData() == null || !jr.getData().getCode().equals(SmsCode.SUCCESS.getCode())) {
			throw new ValidationException("短信验证码已失效，请重新获取");
		}
		// 再校验验证码是否正确
		SmsCheck sc = new SmsCheck();
		sc.setCode(verificationCode);
		sc.setPhone(phoneNumber);
		jr = systemSmsSendService.checkMsgCode(sc);
		if (jr.getData() == null || !jr.getData().getCode().equals(SmsCode.SUCCESS.getCode())) {
			throw new ValidationException("验证码错误");
		}
		return JsonResult.successJsonResult();
	}
	
	/**
	 * 
	 * <p>校验邮箱验证码 </p>
	 * @param verificationCode
	 * @param email
	 * @author 黄智聪  2018年12月12日 下午4:27:39
	 */
	public JsonResult<String> checkEditEmailVerificationCode(String verificationCode, String email) {
		// 先校验验证码是否已失效
		JsonResult<SmsInfo> jr = null;
		MailCodeValidation mcv = new MailCodeValidation();
		mcv.setMail(email);
		mcv.setSec(UserConstants.CHANGE_DATA_EMAIL_TIME_OUT);
		jr = systemEmailService.validationMailCodeTime(mcv);
		if (jr.getData() == null || !jr.getData().getCode().equals(EmailConstants.EMAIL_SEND_SUCCESS)) {
			throw new ValidationException("邮箱验证码已失效，请重新获取");
		}
		// 再校验邮箱验证码是否正确
		MailCheck mailCheck = new MailCheck();
		mailCheck.setCode(verificationCode);
		mailCheck.setMail(email);
		jr = systemEmailService.checkMailCode(mailCheck);
		if (jr.getData() == null || !jr.getData().getCode().equals(EmailConstants.EMAIL_SEND_SUCCESS)) {
			throw new ValidationException("验证码错误");
		}
		return JsonResult.successJsonResult();
	}
	
	/**
	 * 获取会员列表数据
	 * @param param
	 * @return
	 */
	public JsonResult<Pagination<MemberInfo>> getMemberUserList(@RequestBody MemberParam param){
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		List<MemberInfo> infos = memberUserMapper.getMemberUserList(param);
		return JsonResult.successJsonResult(new Pagination<>(infos));
	}
	
	/**
	 * 更新密码
	 * @param up
	 * @return
	 */
	public JsonResult<String> updatePassword(@RequestBody UpdataUserPasswd up){
		if(!Objects.equals(up.getNewPasswd(), up.getReqPasswd())) {
			throw new ValidationException("密码不一致");
		}
		memberUserMapper.updatePassword(up.getId(), MD5Encrypt.encryptMD5(up.getNewPasswd()));
		return JsonResult.successJsonResult();
	}
	
	/**
	 * 更新密码
	 * @param up
	 * @return
	 */
	public JsonResult<String> updatePhone(String phone,Integer id,String code){
		if(StringUtils.isBlank(phone) ||id == null ||StringUtils.isBlank(code)) {
			throw new ValidationException("参数不能为空");
		}
		// 先校验验证码是否已失效
		SmsCodeValidation sv = new SmsCodeValidation();
		sv.setPhone(phone);
		sv.setSec(UserConstants.CHANGE_DATA_SMS_TIME_OUT);
		JsonResult<SmsInfo> jr = systemSmsSendService.checkMsgCodeTime(sv);
		if (jr.getData() == null || !jr.getData().getCode().equals(SmsCode.SUCCESS.getCode())) {
			throw new ValidationException("短信验证码已失效，请重新获取");
		}
		// 再校验验证码是否正确
		SmsCheck sc = new SmsCheck();
		sc.setCode(code);
		sc.setPhone(phone);
		jr = systemSmsSendService.checkMsgCode(sc);
		if (jr.getData() == null || !jr.getData().getCode().equals(SmsCode.SUCCESS.getCode())) {
			throw new ValidationException("验证码错误");
		}
		memberUserMapper.updatePhone(id,phone);
		return JsonResult.successJsonResult();
	}
	
	
	/**
	 * 更新邮箱
	 * @param up
	 * @return
	 */
	public JsonResult<String> updateEmail(String email,Integer id,String code){
		if(StringUtils.isBlank(email) ||id == null ||StringUtils.isBlank(code)) {
			throw new ValidationException("参数不能为空");
		}
		JsonResult<SmsInfo> jr = null;
		MailCodeValidation mcv = new MailCodeValidation();
		mcv.setMail(email);
		mcv.setSec(UserConstants.CHANGE_DATA_EMAIL_TIME_OUT);
		jr = systemEmailService.validationMailCodeTime(mcv);
		if (jr.getData() == null || !jr.getData().getCode().equals(EmailConstants.EMAIL_SEND_SUCCESS)) {
			throw new ValidationException("邮箱验证码已失效，请重新获取");
		}
		// 再校验邮箱验证码是否正确
		MailCheck mailCheck = new MailCheck();
		mailCheck.setCode(code);
		mailCheck.setMail(email);
		jr = systemEmailService.checkMailCode(mailCheck);
		if (jr.getData() == null || !jr.getData().getCode().equals(EmailConstants.EMAIL_SEND_SUCCESS)) {
			throw new ValidationException("验证码错误");
		}
		memberUserMapper.updateEmail(id,email);
		return JsonResult.successJsonResult();
	}
}
