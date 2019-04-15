/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月24日 下午1:24:28
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.azz.client.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.azz.client.mapper.ClientApplyMapper;
import com.azz.client.mapper.ClientDeptMapper;
import com.azz.client.mapper.ClientPermissionMapper;
import com.azz.client.mapper.ClientRoleMapper;
import com.azz.client.mapper.ClientUserCompanyAddressMapper;
import com.azz.client.mapper.ClientUserCompanyMapper;
import com.azz.client.mapper.ClientUserMapper;
import com.azz.client.mapper.ClientUserRoleMapper;
import com.azz.client.pojo.ClientApply;
import com.azz.client.pojo.ClientDept;
import com.azz.client.pojo.ClientRole;
import com.azz.client.pojo.ClientUser;
import com.azz.client.pojo.ClientUserCompany;
import com.azz.client.pojo.ClientUserCompanyAddress;
import com.azz.client.pojo.ClientUserRole;
import com.azz.client.pojo.bo.AddClientUserParam;
import com.azz.client.pojo.bo.Avatar;
import com.azz.client.pojo.bo.ChangeAvatarParam;
import com.azz.client.pojo.bo.CheckVerificationCodeParam;
import com.azz.client.pojo.bo.ClientRegistParam;
import com.azz.client.pojo.bo.EditClientUserParam;
import com.azz.client.pojo.bo.EditPersonalInfoParam;
import com.azz.client.pojo.bo.EnterpriseAuthParam;
import com.azz.client.pojo.bo.LoginParam;
import com.azz.client.pojo.bo.RemoveClientUserParam;
import com.azz.client.pojo.bo.SearchClientUserParam;
import com.azz.client.pojo.bo.TradingCertificate;
import com.azz.client.pojo.vo.ClientCompanyInfo;
import com.azz.client.pojo.vo.ClientPersonalInfo;
import com.azz.client.pojo.vo.ClientUserInfo;
import com.azz.client.pojo.vo.ClientUserPermission;
import com.azz.client.pojo.vo.LoginClientUserInfo;
import com.azz.client.pojo.vo.Menu;
import com.azz.client.pojo.vo.UploadFileInfo;
import com.azz.core.common.JsonResult;
import com.azz.core.common.errorcode.JSR303ErrorCode;
import com.azz.core.common.errorcode.ShiroAuthErrorCode;
import com.azz.core.common.errorcode.SystemErrorCode;
import com.azz.core.common.page.Pagination;
import com.azz.core.constants.ClientConstants;
import com.azz.core.constants.EmailConstants;
import com.azz.core.constants.ClientConstants.IsEnterpriseAuthenticator;
import com.azz.core.constants.ClientConstants.QualificationApplyStatus;
import com.azz.core.constants.ClientConstants.UserStatus;
import com.azz.core.constants.FileConstants;
import com.azz.core.constants.ClientConstants.PersonalEditType;
import com.azz.core.constants.SmsConstants;
import com.azz.core.constants.UserConstants;
import com.azz.core.constants.WxCourseConstants;
import com.azz.core.constants.SmsConstants.SmsCode;
import com.azz.core.constants.UserConstants.ClientType;
import com.azz.core.exception.BaseException;
import com.azz.core.exception.ShiroAuthException;
import com.azz.exception.JSR303ValidationException;
import com.azz.model.Password;
import com.azz.system.api.SystemEmailService;
import com.azz.system.api.SystemImageUploadService;
import com.azz.system.api.SystemSmsSendService;
import com.azz.system.bo.MailCheck;
import com.azz.system.bo.MailCodeValidation;
import com.azz.system.bo.MailParam;
import com.azz.system.bo.SmsCheck;
import com.azz.system.bo.SmsCodeValidation;
import com.azz.system.bo.SmsParams;
import com.azz.system.bo.UploadImageParam;
import com.azz.system.sequence.api.DbSequenceService;
import com.azz.system.vo.SmsInfo;
import com.azz.util.JSR303ValidateUtils;
import com.azz.util.PasswordHelper;
import com.azz.util.RandomStringUtils;
import com.azz.util.StringUtils;
import com.azz.util.SystemSeqUtils;
import com.github.pagehelper.PageHelper;

/**
 * <P>
 * TODO
 * </P>
 * 
 * @version 1.0
 * @author 黄智聪 2018年10月24日 下午1:24:28
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ClientService {

	@Autowired
	private ClientUserMapper clientUserMapper;

	@Autowired
	private ClientUserCompanyMapper clientUserCompanyMapper;

	@Autowired
	private ClientPermissionMapper clientPermissionMapper;

	@Autowired
	private ClientUserCompanyAddressMapper clientUserCompanyAddressMapper;

	@Autowired
	private ClientApplyMapper clientApplyMapper;

	@Autowired
	private ClientDeptMapper clientDeptMapper;

	@Autowired
	private ClientRoleMapper clientRoleMapper;

	@Autowired
	private ClientUserRoleMapper clientUserRoleMapper;

	@Autowired
	private SystemImageUploadService systemImageUploadService;

	@Autowired
	private DbSequenceService dbSequenceService;

	@Autowired
	private SystemSmsSendService systemSmsSendService;
	
	@Autowired
	private SystemEmailService systemEmailService;

	@Autowired
	private StringRedisTemplate redis;
	
	/**
	 * 
	 * <p>
	 * 客户登录认证
	 * </p>
	 * 
	 * @param param
	 * @return
	 * @author 黄智聪 2018年10月23日 下午3:49:33
	 */
	public JsonResult<String> loginAuth(@RequestBody LoginParam param) {
		String phoneNumber = param.getPhoneNumber();
		// 来自于微信课程登录
		if(phoneNumber.startsWith(WxCourseConstants.WX_COURSE_LOGIN_USER_NAME_PREFIX)) {
			// 截取并获取openid
			String openid = phoneNumber.substring(WxCourseConstants.WX_COURSE_LOGIN_USER_NAME_PREFIX.length());
			ClientUser clientUser = clientUserMapper.getClientUserByOpenid(openid);
			if(clientUser == null) {// 若查不到用户信息，说明此用户未绑定过手机，即非客户端用户
				throw new ShiroAuthException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_NOT_BIND_USER);
			}
			return JsonResult.successJsonResult();
		}
		// 其他登录：1.客户端手机号密码登录  2.客户端扫码登录
		ClientUser clientUser = clientUserMapper.getClientUserByPhoneNumber(phoneNumber);
		if (clientUser == null) {// 无效用户
			throw new ShiroAuthException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_LOGIN_ERROR, "请输入正确的账号或密码");
		}
		if (clientUser.getStatus() == UserStatus.INVALID.getValue()) {
			throw new ShiroAuthException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_LOGIN_ERROR, "账号已被禁用，请联系管理员解除");
		}
		String flag = redis.opsForValue().get(param.getPhoneNumber());
		if(!"wxScan".equals(flag)) {// redis能去到对应的微信扫码的flag
			String password = param.getPassword();
			boolean isRight = PasswordHelper.checkPassword(password, clientUser.getSalt(), clientUser.getPassword());
			if (!isRight) {// 与盐值加密的密码不匹配
				throw new ShiroAuthException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_LOGIN_ERROR, "请输入正确的账号或密码");
			}
		}
		return JsonResult.successJsonResult();
	}

	/**
	 * 
	 * <p>
	 * 获取登录客户的用户信息
	 * </p>
	 * 
	 * @param phoneNumber
	 * @return
	 * @author 黄智聪 2018年10月23日 下午4:23:06
	 */
	public JsonResult<LoginClientUserInfo> getLoginClientUserInfoByPhoneNumber(String phoneNumber) {
		LoginClientUserInfo info = new LoginClientUserInfo();
		ClientUserInfo clientUserInfo = clientUserMapper.getClientUserInfoByPhoneNumber(phoneNumber);
		ClientUser user = clientUserMapper.getClientUserByClientUserCode(clientUserInfo.getClientUserCode());
		Long clientUserId = user.getId();
		ClientApply applyRecord = clientApplyMapper.selectLastestApplyRecordByClientUserId(clientUserId);
		if (applyRecord == null) {
			clientUserInfo.setQualificationApplyStatus(QualificationApplyStatus.NOT_APPLY.getValue());
		} else {
			clientUserInfo.setQualificationApplyStatus(applyRecord.getStatus());
		}
		String companyCode = clientUserInfo.getCompanyCode();
		List<ClientUserPermission> clientUserPermissions = clientPermissionMapper
				.getClientUserPermissionInfoByPhoneNumber(companyCode, phoneNumber);
		info.setClientUserInfo(clientUserInfo);
		info.setClientUserPermissions(clientUserPermissions);
		info.setMenus(generateMenuTree(companyCode, phoneNumber));
		return JsonResult.successJsonResult(info);
	}
	
	/**
	 * 
	 * <p>
	 * 获取登录客户的用户信息
	 * </p>
	 * 
	 * @param openid
	 * @return
	 * @author 黄智聪 2018年10月23日 下午4:23:06
	 */
	public JsonResult<LoginClientUserInfo> getLoginClientUserInfoByOpenid(String openid) {
		ClientUser clientUser = clientUserMapper.getClientUserByOpenid(openid);
		if(clientUser == null) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "用户信息不存在");
		}
		return this.getLoginClientUserInfoByPhoneNumber(clientUser.getPhoneNumber());
	}

	/**
	 * 
	 * <p>
	 * 客户注册
	 * </p>
	 * 
	 * @param param
	 * @return
	 * @author 黄智聪 2018年10月22日 下午6:51:03
	 */
	public JsonResult<String> clientRegist(@RequestBody ClientRegistParam param) {
		// 参数校验
		JSR303ValidateUtils.validate(param);
		String password = param.getPassword();
		String confirmPassword = param.getConfirmPassword();
		// 密码与确认密码一致性校验
		if (!password.equals(confirmPassword)) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "密码与确认密码不一致");
		}
		String phoneNumber = param.getPhoneNumber();
		Date nowDate = new Date();
		ClientUser clientUser = clientUserMapper.getClientUserByPhoneNumber(phoneNumber);
		if (clientUser != null) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "手机号已被注册");
		}

		// 校验验证码
		this.checkVerificationCode(phoneNumber, param.getVerificationCode());

		String clientUserCode = dbSequenceService.getClientCustomerNumber();
		// 生成盐值加密的密码
		Password pwd = PasswordHelper.encryptPasswordByModel(password);
		ClientUser clientUserRecord = ClientUser.builder().createTime(nowDate)
				.clientUserCode(SystemSeqUtils.getSeq(clientUserCode)).password(pwd.getPassword())
				.phoneNumber(phoneNumber).salt(pwd.getSalt()).remark("来自客户注册").creator(clientUserCode).build();
		clientUserMapper.insertSelective(clientUserRecord);
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
	public void checkVerificationCode(String phoneNumber, String verificationCode) {
		// 先校验验证码是否已失效
		SmsCodeValidation sv = new SmsCodeValidation();
		sv.setPhone(phoneNumber);
		sv.setSec(ClientConstants.CLIENT_REGIST_SMS_TIME_OUT);
		JsonResult<SmsInfo> jr = systemSmsSendService.checkMsgCodeTime(sv);
		if (jr.getData() == null || !jr.getData().getCode().equals(SmsCode.SUCCESS.getCode())) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "短信验证码已失效，请重新获取");
		}
		// 再校验验证码是否正确
		SmsCheck sc = new SmsCheck();
		sc.setCode(verificationCode);
		sc.setPhone(phoneNumber);
		jr = systemSmsSendService.checkMsgCode(sc);
		if (jr.getData() == null || !jr.getData().getCode().equals(SmsCode.SUCCESS.getCode())) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "验证码错误");
		}
	}

	/**
	 * 
	 * <p>
	 * 企业认证
	 * </p>
	 * 
	 * @param param
	 * @return
	 * @author 黄智聪 2018年10月25日 下午1:40:03
	 */
	public JsonResult<LoginClientUserInfo> enterpriseAuth(@RequestBody EnterpriseAuthParam param) {
		JSR303ValidateUtils.validate(param);
		String clientUserCode = param.getClientUserCode();
		ClientUser user = clientUserMapper.getClientUserByClientUserCode(clientUserCode);
		if (user == null) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "客户不存在");
		}
		// 校验是否已经存在待审核的申请记录
		int applyCount = clientApplyMapper.selectClientUserId(user.getId());
		if (applyCount > 0) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "请勿重复申请");
		}
		String creditCode = param.getCreditCode();
		int count = clientUserCompanyMapper.getCountByCrditCode(creditCode);
		if (count > 0) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "信用代码已存在");
		}
		List<UploadFileInfo> uploadTradingCertificateFileInfos = new ArrayList<>(3);
		// 营业执照最多3个
		List<TradingCertificate> tradingCertificates = param.getTradingCertificates();
		for (int i = 0; i < tradingCertificates.size(); i++) {
			TradingCertificate tradingCertificate = tradingCertificates.get(i);
			String originalFileName = tradingCertificate.getFileName();
			if (StringUtils.isBlank(originalFileName)) {
				throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM,
						"第" + (i + 1) + "个营业执照文件名为空");
			}
			if (tradingCertificate.getFileSize() > ClientConstants.BUSINESS_LICENSE_FILE_SIZE_LIMIT) {
				throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM,
						"第" + (i + 1) + "个营业执照文件大小不能超过20M");
			}
			String filedata = tradingCertificate.getFileBase64Str();
			if (StringUtils.isBlank(filedata)) {
				throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM,
						"第" + (i + 1) + "个营业执照文件内容为空");
			}
			int dotIndex = originalFileName.lastIndexOf(".");
			String fileNameNoSufix = originalFileName.substring(0, dotIndex);
			String sufix = originalFileName.substring(dotIndex + 1, originalFileName.length());
			// 新名称为文件名 + 客户编码 + 第几张
			String newFileName = fileNameNoSufix + "_" + clientUserCode + "_" + (i + 1);
			// 图片url
			 UploadImageParam up = new UploadImageParam();
	    	    up.setBucketname(FileConstants.IMAGE_BUCKETNAME);
	    	    up.setFiledata(filedata);
	    	    up.setFilename(newFileName);
	    	    up.setImagetype(FileConstants.AZZ_TRADING_CERTIFICATE_IMAGE_TYPE);
	    	    up.setPlattype(FileConstants.AZZ_CLIENT);
	    	    up.setSuffix(sufix);
			JsonResult<String> jr = systemImageUploadService.uploadImage(up);
			if (jr.getCode() == SystemErrorCode.SUCCESS.getCode()) {
				UploadFileInfo file = new UploadFileInfo(jr.getData(), originalFileName);
				uploadTradingCertificateFileInfos.add(file);
			} else {
				throw new BaseException(SystemErrorCode.SYS_ERROR_SERVICE_NOT_USE, "营业执照上传失败，请重试");
			}
		}

		String companyCode = dbSequenceService.getClientCompanyNumber();
		Date nowDate = new Date();
		ClientUserCompany clientUserCompanyRecord = ClientUserCompany.builder().clientUserCode(clientUserCode)
				.companyCode(SystemSeqUtils.getSeq(companyCode)).companyName(param.getCompanyName())
				.companyTel(param.getCompanyTel()).creditCode(creditCode).createTime(nowDate).creator(clientUserCode)
				.build();
		if (uploadTradingCertificateFileInfos.size() == 1) {
			clientUserCompanyRecord
					.setTradingCertificateFirstFileName(uploadTradingCertificateFileInfos.get(0).getOriginalFileName());
			clientUserCompanyRecord
					.setTradingCertificateFirstFileUrl(uploadTradingCertificateFileInfos.get(0).getImgUrl());
		}
		if (uploadTradingCertificateFileInfos.size() == 2) {
			clientUserCompanyRecord
					.setTradingCertificateFirstFileName(uploadTradingCertificateFileInfos.get(0).getOriginalFileName());
			clientUserCompanyRecord
					.setTradingCertificateFirstFileUrl(uploadTradingCertificateFileInfos.get(0).getImgUrl());
			clientUserCompanyRecord.setTradingCertificateSecondFileName(
					uploadTradingCertificateFileInfos.get(1).getOriginalFileName());
			clientUserCompanyRecord
					.setTradingCertificateSecondFileUrl(uploadTradingCertificateFileInfos.get(1).getImgUrl());
		}
		if (uploadTradingCertificateFileInfos.size() == 3) {
			clientUserCompanyRecord
					.setTradingCertificateFirstFileName(uploadTradingCertificateFileInfos.get(0).getOriginalFileName());
			clientUserCompanyRecord
					.setTradingCertificateFirstFileUrl(uploadTradingCertificateFileInfos.get(0).getImgUrl());
			clientUserCompanyRecord.setTradingCertificateSecondFileName(
					uploadTradingCertificateFileInfos.get(1).getOriginalFileName());
			clientUserCompanyRecord
					.setTradingCertificateSecondFileUrl(uploadTradingCertificateFileInfos.get(1).getImgUrl());
			clientUserCompanyRecord
					.setTradingCertificateThirdFileName(uploadTradingCertificateFileInfos.get(2).getOriginalFileName());
			clientUserCompanyRecord
					.setTradingCertificateThirdFileUrl(uploadTradingCertificateFileInfos.get(2).getImgUrl());
		}
		clientUserCompanyMapper.insertSelective(clientUserCompanyRecord);

		String provinceName = param.getProviceName();
		String cityName = param.getCityName();
		String areaName = param.getAreaName();
		String detailAddress = param.getDetailAddress();
		ClientUserCompanyAddress clientUserCompanyAddressRecord = ClientUserCompanyAddress.builder()
				.areaCode(param.getAreaCode()).areaName(areaName).companyCode(companyCode).cityCode(param.getCityCode())
				.cityName(cityName).createTime(new Date()).detailAddress(detailAddress)
				.provinceCode(param.getProviceCode()).provinceName(provinceName).createTime(nowDate).build();
		clientUserCompanyAddressMapper.insertSelective(clientUserCompanyAddressRecord);

		ClientUser clientUserRecord = ClientUser.builder().clientUserCode(clientUserCode)
				.clientUserName(param.getClientUserName())
				.isEnterpriseAuthenticator(IsEnterpriseAuthenticator.YES.getValue()).lastModifyTime(nowDate).build();
		clientUserMapper.updateByClientUserCode(clientUserRecord);

		// 完善资料后，需插入申请记录
		ClientApply clientApplyRecord = ClientApply.builder()
				.address(provinceName + cityName + (areaName == null ? "" : areaName) + detailAddress)
				.companyName(param.getCompanyName()).companyTel(param.getCompanyTel()).creditCode(creditCode)
				.clientUserId(user.getId()).clientUserName(param.getClientUserName()).createTime(nowDate)
				.status(QualificationApplyStatus.PENDING.getValue())
				.build();
		if (uploadTradingCertificateFileInfos.size() == 1) {
			clientApplyRecord.setTradingCertificateFirstFileName(uploadTradingCertificateFileInfos.get(0).getOriginalFileName());
			clientApplyRecord.setTradingCertificateFirstFileUrl(uploadTradingCertificateFileInfos.get(0).getImgUrl());
		}
		if (uploadTradingCertificateFileInfos.size() == 2) {
			clientApplyRecord.setTradingCertificateFirstFileName(uploadTradingCertificateFileInfos.get(0).getOriginalFileName());
			clientApplyRecord.setTradingCertificateFirstFileUrl(uploadTradingCertificateFileInfos.get(0).getImgUrl());
			clientApplyRecord.setTradingCertificateSecondFileName(uploadTradingCertificateFileInfos.get(1).getOriginalFileName());
			clientApplyRecord.setTradingCertificateSecondFileUrl(uploadTradingCertificateFileInfos.get(1).getImgUrl());
		}
		if (uploadTradingCertificateFileInfos.size() == 3) {
			clientApplyRecord.setTradingCertificateFirstFileName(uploadTradingCertificateFileInfos.get(0).getOriginalFileName());
			clientApplyRecord.setTradingCertificateFirstFileUrl(uploadTradingCertificateFileInfos.get(0).getImgUrl());
			clientApplyRecord.setTradingCertificateSecondFileName(uploadTradingCertificateFileInfos.get(1).getOriginalFileName());
			clientApplyRecord.setTradingCertificateSecondFileUrl(uploadTradingCertificateFileInfos.get(1).getImgUrl());
			clientApplyRecord.setTradingCertificateThirdFileName(uploadTradingCertificateFileInfos.get(2).getOriginalFileName());
			clientApplyRecord.setTradingCertificateThirdFileUrl(uploadTradingCertificateFileInfos.get(2).getImgUrl());
		}
		clientApplyMapper.insertSelective(clientApplyRecord);
		return this.getLoginClientUserInfoByPhoneNumber(user.getPhoneNumber());
	}

	public JsonResult<String> addClientUser(@RequestBody AddClientUserParam param) {
		// 参数校验
		JSR303ValidateUtils.validate(param);
		ClientDept dept = clientDeptMapper.selectByDeptCode(param.getDeptCode());
		if (dept == null) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "部门不存在");
		}
		ClientRole role = clientRoleMapper.selectByRoleCode(param.getRoleCode());
		if (role == null) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "角色不存在");
		}
		String email = param.getEmail();
		String phoneNumber = param.getPhoneNumber();
		if (!StringUtils.isBlank(email)) {
			ClientUser user = clientUserMapper.getClientUserByEmail(email, null);
			if (user != null) {
				// 判断是否为同一个注册者，不是则认为该邮箱已被注册
				if (!user.getPhoneNumber().equals(phoneNumber)) {
					throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "邮箱已存在");
				}
			}
		}
		ClientUser u = clientUserMapper.getClientUserByPhoneNumberAndClientUserCode(phoneNumber, null);
		if (u == null) {// 手机未被注册过
			// 随机生成6位数密码
			String password = RandomStringUtils.randomNumeric(6);
			// 生成盐值加密的密码
			Password pwd = PasswordHelper.encryptPasswordByModel(password);
			Date nowDate = new Date();
			String creator = param.getCreator();
			String clientUserCode = dbSequenceService.getClientCustomerNumber();
			ClientUser userRecord = ClientUser.builder().createTime(nowDate).creator(creator).clientDeptId(dept.getId())
					.email(param.getEmail()).password(pwd.getPassword()).phoneNumber(phoneNumber)
					.postName(param.getPostName()).clientUserCode(SystemSeqUtils.getSeq(clientUserCode))
					.clientUserName(param.getClientUserName()).salt(pwd.getSalt()).build();
			clientUserMapper.insertSelective(userRecord);

			String companyCode = param.getCompanyCode();
			ClientUserCompany company = clientUserCompanyMapper.selectByCompanyCode(companyCode);
			// 1.为新增的成员绑定公司
			ClientUserCompany clientUserCompanyRecord = ClientUserCompany.builder().createTime(nowDate)
					.clientUserCode(clientUserCode).companyName(company.getCompanyName())
					.companyCode(company.getCompanyCode()).remark("手动新增成员").creator(param.getCreator())
					.companyTel(company.getCompanyTel()).build();
			clientUserCompanyMapper.insertSelective(clientUserCompanyRecord);

			// 2.用户与角色绑定
			ClientUserRole userRoleRecord = ClientUserRole.builder().createTime(nowDate).creator(creator)
					.clientUserId(userRecord.getId()).roleId(role.getId()).build();
			clientUserRoleMapper.insertSelective(userRoleRecord);

			// 发送短信通知成员
			try {
				this.sendPasswordMsg(phoneNumber, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {// 若能根据手机号查询到用户信息，判断是否为企业用户
			if (u.getClientType() == ClientType.ENTERPRISE.getValue()) { // 若为企业用户，则表示已被企业注册
				throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "手机号已存在");
			} else {// 若为个人用户，则将该个人用户绑定为这个客户的成员即可
				Date nowDate = new Date();
				String creator = param.getCreator();
				// 1.将该成员改为企业用户
				ClientUser userRecord = ClientUser.builder().lastModifyTime(nowDate).modifier(creator)
						.clientDeptId(dept.getId()).email(param.getEmail()).clientType(ClientType.ENTERPRISE.getValue())
						.postName(param.getPostName()).clientUserCode(u.getClientUserCode()).id(u.getId())
						.clientUserName(param.getClientUserName()).remark("被企业绑定为客户成员").build();
				clientUserMapper.updateByPrimaryKeySelective(userRecord);

				String companyCode = param.getCompanyCode();
				ClientUserCompany company = clientUserCompanyMapper.selectByCompanyCode(companyCode);
				// 2.为成员重新绑定公司
				ClientUserCompany clientUserCompanyRecord = ClientUserCompany.builder().createTime(nowDate)
						.clientUserCode(u.getClientUserCode()).companyName(company.getCompanyName())
						.companyCode(company.getCompanyCode()).remark("重新为成员绑定公司").creator(param.getCreator())
						.companyTel(company.getCompanyTel()).build();
				clientUserCompanyMapper.insertSelective(clientUserCompanyRecord);

				// 3.用户与角色绑定
				ClientUserRole userRoleRecord = ClientUserRole.builder().createTime(nowDate).creator(creator)
						.clientUserId(u.getId()).roleId(role.getId()).build();
				clientUserRoleMapper.insertSelective(userRoleRecord);
			}
		}
		return JsonResult.successJsonResult();
	}

	public JsonResult<String> editClientUser(@RequestBody EditClientUserParam param) {
		// 参数校验
		JSR303ValidateUtils.validate(param);

		ClientDept dept = clientDeptMapper.selectByDeptCode(param.getDeptCode());
		if (dept == null) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "部门不存在");
		}

		ClientRole role = clientRoleMapper.selectByRoleCode(param.getRoleCode());
		if (role == null) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "角色不存在");
		}

		String clientUserCode = param.getClientUserCode();
		ClientUser user = clientUserMapper.getClientUserByClientUserCode(clientUserCode);
		if (user == null) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "用户不存在");
		}
		if (user.getIsEnterpriseAuthenticator() == IsEnterpriseAuthenticator.YES.getValue()) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "该成员不允许修改");
		}
		String email = param.getEmail();
		if (!StringUtils.isBlank(email)) {
			// 带上用户编码是为了排除当前用户以外是否存在邮箱了
			ClientUser u = clientUserMapper.getClientUserByEmail(email, clientUserCode);
			if (u != null) {
				throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "邮箱已存在");
			}
		}
		ClientUser u = clientUserMapper.getClientUserByPhoneNumberAndClientUserCode(param.getPhoneNumber(),
				clientUserCode);
		if (u != null) {
			// 带上用户编码是为了排除当前用户以外是否存在手机了
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "手机号已存在");
		}

		Date nowDate = new Date();
		String modifier = param.getModifier();
		Long clientUserId = user.getId();
		ClientUser merchantUserRecord = ClientUser.builder().modifier(modifier).lastModifyTime(nowDate)
				.email(param.getEmail()).phoneNumber(param.getPhoneNumber()).postName(param.getPostName())
				.clientUserName(param.getClientUserName()).clientDeptId(dept.getId()).id(clientUserId).build();
		clientUserMapper.updateByPrimaryKeySelective(merchantUserRecord);

		// 先删除原先的用户与角色的绑定
		clientUserRoleMapper.deleteByClientUserId(clientUserId);

		// 重新对用户与角色进行新的绑定
		ClientUserRole userRoleRecord = ClientUserRole.builder().createTime(nowDate).creator(modifier)
				.clientUserId(clientUserId).roleId(role.getId()).build();
		clientUserRoleMapper.insertSelective(userRoleRecord);
		return JsonResult.successJsonResult();
	}

	public JsonResult<Pagination<ClientUserInfo>> getClientUserList(@RequestBody SearchClientUserParam param) {
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		List<ClientUserInfo> users = clientUserMapper.getClientUserInfoBySearchParam(param);
		return JsonResult.successJsonResult(new Pagination<>(users));
	}

	public JsonResult<String> removeClientUser(@RequestBody RemoveClientUserParam param) {
		// 参数校验
		JSR303ValidateUtils.validate(param);
		String clientUserCode = param.getClientUserCode();
		// 1.将客户类型改为个人
		ClientUser clientUserRecord = ClientUser.builder().clientUserCode(clientUserCode).clientDeptId(0L)
				.clientType(ClientType.PERSON.getValue()).modifier(param.getModifier()).lastModifyTime(new Date())
				.build();
		clientUserMapper.updateByClientUserCode(clientUserRecord);

		// 2.删除客户与公司的绑定
		clientUserCompanyMapper.deleteByClientUserCode(clientUserCode);

		ClientUser user = clientUserMapper.getClientUserByClientUserCode(clientUserCode);
		// 3.删除用户与角色的绑定
		clientUserRoleMapper.deleteByClientUserId(user.getId());

		return JsonResult.successJsonResult();
	}

	public JsonResult<ClientUserInfo> getClientUserInfo(String clientUserCode) {
		if (StringUtils.isBlank(clientUserCode)) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "用户编码不允许为空");
		}
		ClientUserInfo userInfo = clientUserMapper.getClientUserInfoByClientUserCode(clientUserCode);
		if (userInfo == null) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "用户不存在");
		}
		return JsonResult.successJsonResult(userInfo);
	}

	public JsonResult<String> changeAvatar(@RequestBody ChangeAvatarParam param) {
		// 参数校验
		JSR303ValidateUtils.validate(param);
		Avatar avatar = param.getAvatar();
		String clientUserCode = param.getClientUserCode();

		String originalFileName = avatar.getFileName();
		if (StringUtils.isBlank(originalFileName)) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "头像文件名为空");
		}
		if (avatar.getFileSize() > ClientConstants.AVATAR_FILE_SIZE_LIMIT) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "头像文件大小不能超过2M");
		}
		String filedata = avatar.getFileBase64Str();
		if (StringUtils.isBlank(filedata)) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "头像文件内容为空");
		}
		int dotIndex = originalFileName.lastIndexOf(".");
		String fileNameNoSufix = originalFileName.substring(0, dotIndex);
		String sufix = originalFileName.substring(dotIndex + 1, originalFileName.length());
		// 新名称为文件名 + 客户编码 + 文件后缀
		String newFileName = fileNameNoSufix + "_" + clientUserCode;

		// 图片url
		UploadImageParam up = new UploadImageParam();
	    up.setBucketname(FileConstants.IMAGE_BUCKETNAME);
	    up.setFiledata(filedata);
	    up.setFilename(newFileName);
	    up.setImagetype(FileConstants.AZZ_AVATAR_IMAGE_TYPE);
	    up.setPlattype(FileConstants.AZZ_CLIENT);
	    up.setSuffix(sufix);
		JsonResult<String> jr = systemImageUploadService.uploadImage(up);
		if (jr.getCode() != SystemErrorCode.SUCCESS.getCode()) {
			throw new BaseException(SystemErrorCode.SYS_ERROR_SERVICE_NOT_USE, "头像上传失败，请重试");
		}

		ClientUser clientUserRecord = ClientUser.builder().clientUserCode(clientUserCode).clientAvatarUrl(jr.getData())
				.lastModifyTime(new Date()).build();
		clientUserMapper.updateByClientUserCode(clientUserRecord);
		return JsonResult.successJsonResult();

	}

	public JsonResult<ClientPersonalInfo> getClientPersonalInfo(String clientUserCode) {
		ClientPersonalInfo info = clientUserMapper.getClientPersonalInfoByClientUserCode(clientUserCode);
		if (info == null) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "客户成员信息不存在");
		}
		return JsonResult.successJsonResult(info);
	}

	public JsonResult<ClientCompanyInfo> getClientCompanyInfo(String clientUserCode) {
		ClientCompanyInfo info = clientUserMapper.getClientCompanyInfoByClientUserCode(clientUserCode);
		if (info == null) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "客户企业信息不存在");
		}
		return JsonResult.successJsonResult(info);
	}
	
	
	/**
	 * 
	 * <p>修改个人资料</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2018年12月12日 下午2:56:38
	 */
	public JsonResult<String> editPersonalInfo(@RequestBody EditPersonalInfoParam param){
		JSR303ValidateUtils.validate(param);
		ClientUser clientUserRecord = null;
		ClientUser u = null;
		Date nowDate = new Date();
		switch (param.getEditType()) {
		case PersonalEditType.NAME:
			String clientUserName = param.getUserName();
			if(StringUtils.isBlank(clientUserName)) {
				throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "姓名不允许为空");
			}
			clientUserRecord = ClientUser.builder()
					.clientUserCode(param.getModifier())
					.clientUserName(clientUserName)
					.modifier(param.getModifier())
					.lastModifyTime(nowDate)
					.build();
			break;
		case PersonalEditType.PHONE_NUMBER:
			String phoneNumber = param.getPhoneNumber();
			// 手机格式校验
			if(StringUtils.isBlank(phoneNumber)) {
				throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "手机号不允许为空");
			}
			if (!StringUtils.isPhoneNumber(phoneNumber)) {
				throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "请输入正确的手机号");
			}
			// 手机是否已被客户成员所使用
			u = clientUserMapper.getClientUserByPhoneNumberAndClientUserCode(phoneNumber, param.getModifier());
			if (u != null) {
				throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "手机号已被使用，请更改");
			}
			
			// 校验验证码
			CheckVerificationCodeParam checkParam = new CheckVerificationCodeParam();
			checkParam.setPhoneNumber(phoneNumber);
			checkParam.setVerificationCode(param.getVerificationCode());
			this.checkEditVerificationCode(checkParam);

			clientUserRecord = ClientUser.builder()
					.clientUserCode(param.getModifier())
					.phoneNumber(phoneNumber)
					.modifier(param.getModifier())
					.lastModifyTime(nowDate)
					.build();
			break;
		case PersonalEditType.EMAIL:
			String email = param.getEmail();
			// 邮箱格式校验
			if(StringUtils.isBlank(email)) {
				throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "邮箱不允许为空");
			}
			if (!StringUtils.isEmail(email)) {
				throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "请输入正确的邮箱");
			}
			// 邮箱是否已被客户成员所使用
			u = clientUserMapper.getClientUserByEmail(email, param.getModifier());
			if (u != null) {
				throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "邮箱已被使用，请更改");
			}
			
			// 校验邮箱验证码
			this.checkEditEmailVerificationCode(param.getVerificationCode(), email);

			clientUserRecord = ClientUser.builder()
					.clientUserCode(param.getModifier())
					.email(email)
					.modifier(param.getModifier())
					.lastModifyTime(nowDate)
					.build();
			break;
		case PersonalEditType.PASSWORD:
			String password = param.getPassword();
			String confirmPassword = param.getConfirmPassword();
			if(StringUtils.isBlank(password) || StringUtils.isBlank(confirmPassword)) {
				throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "密码或确认密码不允许为空");
			}
			// 密码与确认密码一致性校验
			if (!password.equals(confirmPassword)) {
			    throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "密码与确认密码不一致");
			}
			
			// 生成盐值加密的密码
			Password pwd = PasswordHelper.encryptPasswordByModel(password);
			clientUserRecord = ClientUser.builder()
					.clientUserCode(param.getModifier())
					.password(pwd.getPassword())
					.salt(pwd.getSalt())
					.modifier(param.getModifier())
					.lastModifyTime(nowDate)
					.build();
			break;
		default:
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "修改类型不存在");
		}
		clientUserMapper.updateByClientUserCode(clientUserRecord);
		return JsonResult.successJsonResult();
	}
	
	/**
	 * 
	 * <p>校验邮箱验证码</p>
	 * @param verificationCode
	 * @param email
	 * @author 黄智聪  2018年12月12日 下午4:27:39
	 */
	public void checkEditEmailVerificationCode(String verificationCode, String email) {
		// 先校验验证码是否已失效
		JsonResult<SmsInfo> jr = null;
		MailCodeValidation mcv = new MailCodeValidation();
		mcv.setMail(email);
		mcv.setSec(UserConstants.CHANGE_DATA_EMAIL_TIME_OUT);
		jr = systemEmailService.validationMailCodeTime(mcv);
		if (jr.getData() == null || !jr.getData().getCode().equals(EmailConstants.EMAIL_SEND_SUCCESS)) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "邮箱验证码已失效，请重新获取");
		}
		// 再校验邮箱验证码是否正确
		MailCheck mailCheck = new MailCheck();
		mailCheck.setCode(verificationCode);
		mailCheck.setMail(email);
		jr = systemEmailService.checkMailCode(mailCheck);
		if (jr.getData() == null || !jr.getData().getCode().equals(EmailConstants.EMAIL_SEND_SUCCESS)) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "验证码错误");
		}
	}
	
	/**
	 * 
	 * <p>
	 * 发送修改个人信息的验证码
	 * </p>
	 * 
	 * @param phoneNumber
	 * @return
	 * @author 黄智聪 2018年10月22日 下午5:37:30
	 */
	public JsonResult<String> sendEditVerificationCode(String phoneNumber) {
		SmsParams sms = new SmsParams();
		sms.setPhone(phoneNumber);
		sms.setMsgType(SmsConstants.CHANGE_DATA.getMsgType());
		return systemSmsSendService.sendSmsCode(sms);
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
		JSR303ValidateUtils.validate(param);
		String phoneNumber = param.getPhoneNumber();
		String verificationCode = param.getVerificationCode();
		// 先校验验证码是否已失效
		SmsCodeValidation sv = new SmsCodeValidation();
		sv.setPhone(phoneNumber);
		sv.setSec(UserConstants.CHANGE_DATA_SMS_TIME_OUT);
		JsonResult<SmsInfo> jr = systemSmsSendService.checkMsgCodeTime(sv);
		if (jr.getData() == null || !jr.getData().getCode().equals(SmsCode.SUCCESS.getCode())) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "短信验证码已失效，请重新获取");
		}
		// 再校验验证码是否正确
		SmsCheck sc = new SmsCheck();
		sc.setCode(verificationCode);
		sc.setPhone(phoneNumber);
		jr = systemSmsSendService.checkMsgCode(sc);
		if (jr.getData() == null || !jr.getData().getCode().equals(SmsCode.SUCCESS.getCode())) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "验证码错误");
		}
		return JsonResult.successJsonResult();
	}
	
	/**
	 * 
	 * <p>
	 * 发送修改个人信息的邮箱验证码
	 * </p>
	 * 
	 * @param phoneNumber
	 * @return
	 * @author 黄智聪 2018年10月22日 下午5:37:30
	 */
	public JsonResult<String> sendEditEmailVerificationCode(String email) {
		MailParam m = new MailParam();
		m.setTo(email);
		JsonResult<SmsInfo> jr = systemEmailService.sendMail(m);
		if (jr.getData() == null || !jr.getData().getCode().equals(EmailConstants.EMAIL_SEND_SUCCESS)) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "邮箱验证码发送失败，请重试");
		}
		return JsonResult.successJsonResult();
	}
	

	/**
	 * 
	 * <p>
	 * 发送注册验证码
	 * </p>
	 * 
	 * @param phoneNumber
	 * @return
	 * @author 黄智聪 2018年10月22日 下午5:37:30
	 */
	public JsonResult<String> sendVerificationCode(String phoneNumber) {
		SmsParams sms = new SmsParams();
		sms.setPhone(phoneNumber);
		sms.setMsgType(SmsConstants.CLIENT_REGISTER.getMsgType());
		return systemSmsSendService.sendSmsCode(sms);
	}

	// 发送短信通知成员
	private void sendPasswordMsg(String phoneNumber, String password) {
		SmsParams sms = new SmsParams();
		sms.setPhone(phoneNumber);
		sms.setMsgType(SmsConstants.ACCOUNT_CREATE_SUCCESS.getMsgType());
		sms.setCode(password);
		systemSmsSendService.sendSmsCode(sms);
	}

	/**
	 * 
	 * <p>
	 * 根据手机号查询当前客户角色并生成菜单树
	 * </p>
	 * 
	 * @param phoneNumber
	 *            手机号
	 * @return
	 * @author 黄智聪 2018年10月19日 上午10:36:34
	 */
	private List<Menu> generateMenuTree(String companyCode, String phoneNumber) {
		// 根据手机号查询所有一级菜单权限
		List<ClientUserPermission> oneMenuPermissions = clientPermissionMapper
				.getClientUserPermissionByPhoneNumberAndLevel(companyCode, phoneNumber, 1);
		// 根据手机号查询所有二级菜单权限
		List<ClientUserPermission> twoMenuPermissions = clientPermissionMapper
				.getClientUserPermissionByPhoneNumberAndLevel(companyCode, phoneNumber, 2);
		List<Menu> oneLevelMenus = new ArrayList<>();
		for (ClientUserPermission oneMenuPermission : oneMenuPermissions) {
			// 一级菜单的权限编码
			String oneLevelPermissionCode = oneMenuPermission.getPermissionCode();
			List<Menu> twoLevelMenus = new ArrayList<>();
			for (ClientUserPermission twoMenuPermission : twoMenuPermissions) {
				// 二级菜单的父级权限编码
				String twoLevelPermissionCode = twoMenuPermission.getParentPermissionCode();
				if (twoLevelPermissionCode.equals(oneLevelPermissionCode)) {// 一二级菜单进行分类
					Menu twoLevelMenu = new Menu(twoMenuPermission.getPermissionName(), twoMenuPermission.getPageUrl(),
							twoMenuPermission.getIcon(), null);
					twoLevelMenus.add(twoLevelMenu);
				}
			}
			Menu oneLevelMenu = new Menu(oneMenuPermission.getPermissionName(), oneMenuPermission.getPageUrl(),
					oneMenuPermission.getIcon(), twoLevelMenus);
			oneLevelMenus.add(oneLevelMenu);
		}
		return oneLevelMenus;
	}

}
