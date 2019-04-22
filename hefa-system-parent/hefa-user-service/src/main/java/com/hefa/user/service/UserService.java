/*******************************************************************************
 * Project Key : CPPII Create on 2018年10月14日 上午9:27:50 Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.hefa.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.azz.core.constants.EmailConstants;
import com.azz.core.constants.SmsConstants;
import com.azz.core.constants.SmsConstants.SmsCode;
import com.azz.system.bo.MailCheck;
import com.azz.system.bo.MailCodeValidation;
import com.azz.system.bo.MailParam;
import com.azz.system.bo.SmsCheck;
import com.azz.system.bo.SmsCodeValidation;
import com.azz.system.bo.SmsParams;
import com.azz.system.vo.SmsInfo;
import com.github.pagehelper.PageHelper;
import com.hefa.common.base.BaseException;
import com.hefa.common.base.JsonResult;
import com.hefa.common.base.Password;
import com.hefa.common.constants.PlatformConstants;
import com.hefa.common.constants.PlatformConstants.UserStatus;
import com.hefa.common.errorcode.ShiroAuthErrorCode;
import com.hefa.common.exception.ReturnDataException;
import com.hefa.common.exception.ShiroAuthException;
import com.hefa.common.exception.ValidationException;
import com.hefa.common.page.Pagination;
import com.hefa.user.mapper.PlatformDeptMapper;
import com.hefa.user.mapper.PlatformPermissionMapper;
import com.hefa.user.mapper.PlatformRoleMapper;
import com.hefa.user.mapper.PlatformUserMapper;
import com.hefa.user.mapper.PlatformUserRoleMapper;
import com.hefa.user.pojo.PlatformDept;
import com.hefa.user.pojo.PlatformRole;
import com.hefa.user.pojo.PlatformUser;
import com.hefa.user.pojo.PlatformUserRole;
import com.hefa.user.pojo.bo.AddUserParam;
import com.hefa.user.pojo.bo.CheckVerificationCodeParam;
import com.hefa.user.pojo.bo.EditPasswordParam;
import com.hefa.user.pojo.bo.EditPersonalInfoParam;
import com.hefa.user.pojo.bo.EditUserParam;
import com.hefa.user.pojo.bo.EnableOrDisableOrDelUserParam;
import com.hefa.user.pojo.bo.LoginParam;
import com.hefa.user.pojo.bo.SearchUserParam;
import com.hefa.user.pojo.vo.LoginUserInfo;
import com.hefa.user.pojo.vo.Menu;
import com.hefa.user.pojo.vo.UserInfo;
import com.hefa.user.pojo.vo.UserPermission;
import com.hefa.utils.JSR303ValidateUtils;
import com.hefa.utils.PasswordHelper;
import com.hefa.utils.RandomStringUtils;
import com.hefa.utils.StringUtils;
import com.hefa.utils.SystemSeqUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * <P>
 * TODO
 * </P>
 * 
 * @version 1.0
 * @author 刘建麟 2018年10月14日 上午9:27:50
 */
@Transactional(rollbackFor = Exception.class)
@Service
@Slf4j
public class UserService {

	@Autowired
	private PlatformUserMapper platformUserMapper;

	@Autowired
	private PlatformPermissionMapper platformPermissionMapper;

	@Autowired
	private PlatformDeptMapper platformDeptMapper;

	@Autowired
	private PlatformRoleMapper platformRoleMapper;

	@Autowired
	private PlatformUserRoleMapper platformUserRoleMapper;

	@Autowired
	private DbSequenceService dbSequenceService;

	@Autowired
	private SystemSmsSendService systemSmsSendService;
	
	@Autowired
	private SystemEmailService systemEmailService;

	public JsonResult<String> loginAuth(@RequestBody LoginParam param) {
		log.debug("————身份认证方法————");
		String phoneNumber = param.getPhoneNumber();
		String password = param.getPassword();
		PlatformUser platformUser = platformUserMapper.getUserByPhoneNumber(phoneNumber, null);
		if (platformUser == null) {// 无效用户
			throw new ShiroAuthException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_LOGIN_ERROR, "请输入正确的账号或密码");
		}
		if (platformUser.getStatus() == UserStatus.INVALID.getValue()) {
			throw new ShiroAuthException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_LOGIN_ERROR, "账号已被禁用，请联系管理员解除");
		}
		boolean isRight = PasswordHelper.checkPassword(password, platformUser.getSalt(), platformUser.getPassword());
		if (!isRight) {// 与盐值加密的密码不匹配
			throw new ShiroAuthException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_LOGIN_ERROR, "请输入正确的账号或密码");
		}
		return JsonResult.successJsonResult();
	}

	public JsonResult<LoginUserInfo> getLoginUserInfoByPhoneNumber(String phoneNumber) {
		LoginUserInfo info = new LoginUserInfo();
		UserInfo userInfo = platformUserMapper.getUserInfoByPhoneNumber(phoneNumber);
		List<UserPermission> userPermissions = platformPermissionMapper.getUserPermissionInfoByPhoneNumber(phoneNumber);
		info.setUserInfo(userInfo);
		info.setUserPermissions(userPermissions);
		info.setMenus(generateMenuTree(phoneNumber));
		return JsonResult.successJsonResult(info);
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
	 * <p>修改个人资料</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2018年12月12日 下午2:56:38
	 */
	public JsonResult<String> editPersonalInfo(@RequestBody EditPersonalInfoParam param){
		JSR303ValidateUtils.validateInputParam(param);
		PlatformUser platformUserRecord = null;
		PlatformUser u = null;
		Date nowDate = new Date();
		switch (param.getEditType()) {
		case PersonalEditType.NAME:
			String platformUserName = param.getUserName();
			if(StringUtils.isBlank(platformUserName)) {
				throw new ValidationException("姓名不允许为空");
			}
			platformUserRecord = PlatformUser.builder()
					.userCode(param.getModifier())
					.userName(platformUserName)
					.modifier(param.getModifier())
					.lastModifyTime(nowDate)
					.build();
			break;
		case PersonalEditType.PHONE_NUMBER:
			String phoneNumber = param.getPhoneNumber();
			// 手机格式校验
			if(StringUtils.isBlank(phoneNumber)) {
				throw new ValidationException("手机号不允许为空");
			}
			if (!StringUtils.isPhoneNumber(phoneNumber)) {
				throw new ValidationException("请输入正确的手机号");
			}
			// 手机是否已被客户成员所使用
			u = platformUserMapper.getUserByPhoneNumber(phoneNumber, param.getModifier());
			if (u != null) {
				throw new ValidationException("手机号已被使用，请更改");
			}
			
			// 校验验证码
			CheckVerificationCodeParam checkParam = new CheckVerificationCodeParam();
			checkParam.setPhoneNumber(phoneNumber);
			checkParam.setVerificationCode(param.getVerificationCode());
			this.checkEditVerificationCode(checkParam);

			platformUserRecord = PlatformUser.builder()
					.userCode(param.getModifier())
					.phoneNumber(phoneNumber)
					.modifier(param.getModifier())
					.lastModifyTime(nowDate)
					.build();
			break;
		case PersonalEditType.EMAIL:
			String email = param.getEmail();
			// 邮箱格式校验
			if(StringUtils.isBlank(email)) {
				throw new ValidationException("邮箱不允许为空");
			}
			if (!StringUtils.isEmail(email)) {
				throw new ValidationException("请输入正确的邮箱");
			}
			// 邮箱是否已被客户成员所使用
			u = platformUserMapper.getUserByEmail(email, param.getModifier());
			if (u != null) {
				throw new ValidationException("邮箱已被使用，请更改");
			}
			
			// 校验邮箱验证码
			this.checkEditEmailVerificationCode(param.getVerificationCode(), email);

			platformUserRecord = PlatformUser.builder()
					.userCode(param.getModifier())
					.email(email)
					.modifier(param.getModifier())
					.lastModifyTime(nowDate)
					.build();
			break;
		case PersonalEditType.PASSWORD:
			String password = param.getPassword();
			String confirmPassword = param.getConfirmPassword();
			if(StringUtils.isBlank(password) || StringUtils.isBlank(confirmPassword)) {
				throw new ValidationException("密码或确认密码不允许为空");
			}
			// 密码与确认密码一致性校验
			if (!password.equals(confirmPassword)) {
			    throw new ValidationException("密码与确认密码不一致");
			}
			
			// 生成盐值加密的密码
			Password pwd = PasswordHelper.encryptPasswordByModel(password);
			platformUserRecord = PlatformUser.builder()
					.userCode(param.getModifier())
					.password(pwd.getPassword())
					.salt(pwd.getSalt())
					.modifier(param.getModifier())
					.lastModifyTime(nowDate)
					.build();
			break;
		default:
			throw new ValidationException("修改类型不存在");
		}
		platformUserMapper.updateByUserCode(platformUserRecord);
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
			throw new ValidationException("邮箱验证码发送失败，请重试");
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
	public void checkEditEmailVerificationCode(String verificationCode, String email) {
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
	 * <p>
	 * 根据手机号查询当前用户角色并生成菜单树
	 * </p>
	 * 
	 * @param phoneNumber
	 *            手机号
	 * @return
	 * @author 黄智聪 2018年10月19日 上午10:36:34
	 */
	private List<Menu> generateMenuTree(String phoneNumber) {
		// 根据手机号查询所有一级菜单权限
		List<UserPermission> oneMenuPermissions = platformPermissionMapper
				.getUserPermissionByPhoneNumberAndLevel(phoneNumber, 1);
		// 根据手机号查询所有二级菜单权限
		List<UserPermission> twoMenuPermissions = platformPermissionMapper
				.getUserPermissionByPhoneNumberAndLevel(phoneNumber, 2);
		List<Menu> oneLevelMenus = new ArrayList<>();
		for (UserPermission oneMenuPermission : oneMenuPermissions) {
			// 一级菜单的权限编码
			String oneLevelPermissionCode = oneMenuPermission.getPermissionCode();
			List<Menu> twoLevelMenus = new ArrayList<>();
			for (UserPermission twoMenuPermission : twoMenuPermissions) {
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

	public JsonResult<String> editPassword(@RequestBody EditPasswordParam param) {
		JSR303ValidateUtils.validateInputParam(param);

		// 密码一致性校验
		if (!param.getFirstPassword().equals(param.getSecondPassword())) {
			throw new BaseException(PlatformUserErrorCode.PLATFORM_USER_ERROR_INCONSISTENT_PASSWORD);
		}

		// 根据用户编码获取用户信息
		PlatformUser platformUser = platformUserMapper.getUserByUserCode(param.getUserCode());
		if (platformUser == null) {// 无效用户
			throw new ShiroAuthException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_LOGIN_ERROR, "无效用户");
		}

		// 用户设置的新密码信息
		Password pwd = PasswordHelper.encryptPasswordByModel(param.getSecondPassword());
		platformUser.setPassword(pwd.getPassword());
		platformUser.setSalt(pwd.getSalt());
		platformUser.setModifier(param.getUserInfo().getUserCode());
		platformUser.setLastModifyTime(new Date());

		platformUserMapper.updateByPrimaryKeySelective(platformUser);

		return JsonResult.successJsonResult();
	}

	public JsonResult<String> addUser(@RequestBody AddUserParam param) {
		// 参数校验
		JSR303ValidateUtils.validateInputParam(param);

		PlatformDept dept = platformDeptMapper.selectByDeptCode(param.getDeptCode());
		if (dept == null) {
			throw new ValidationException("部门不存在");
		}
		PlatformRole role = platformRoleMapper.selectByRoleCode(param.getRoleCode());
		if (role == null) {
			throw new ValidationException("角色不存在");
		}
		String email = param.getEmail();
		if (!StringUtils.isBlank(email)) {
			PlatformUser user = platformUserMapper.getUserByEmail(email, null);
			if (user != null) {
				throw new ValidationException("邮箱已存在");
			}
		}
		PlatformUser u = platformUserMapper.getUserByPhoneNumber(param.getPhoneNumber(), null);
		if (u != null) {
			throw new ValidationException("手机号已存在");
		}

		// 随机6位数字密码
		String randomPwd = RandomStringUtils.randomNumeric(6);

		// 生成盐值加密的密码
		Password pwd = PasswordHelper.encryptPasswordByModel(randomPwd);
		Date nowDate = new Date();
		String creator = param.getCreator();
		String code = dbSequenceService.getPlatEmployeeNumber();
		PlatformUser userRecord = PlatformUser.builder().createTime(nowDate).creator(creator).deptId(dept.getId())
				.email(param.getEmail()).password(pwd.getPassword()).phoneNumber(param.getPhoneNumber())
				.postName(param.getPostName()).userCode(SystemSeqUtils.getSeq(code)).userName(param.getUserName())
				.salt(pwd.getSalt()).build();
		platformUserMapper.insertSelective(userRecord);
		// 用户与角色绑定
		PlatformUserRole userRoleRecord = PlatformUserRole.builder().createTime(nowDate).creator(creator)
				.userId(userRecord.getId()).roleId(role.getId()).build();
		platformUserRoleMapper.insertSelective(userRoleRecord);

		try {
			// 发送短信
			this.sendPasswordMsg(param.getPhoneNumber(), randomPwd);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return JsonResult.successJsonResult();
	}

	public JsonResult<String> editUser(@RequestBody EditUserParam param) {
		// 参数校验
		JSR303ValidateUtils.validateInputParam(param);

		PlatformDept dept = platformDeptMapper.selectByDeptCode(param.getDeptCode());
		if (dept == null) {
			throw new ValidationException("部门不存在");
		}
		PlatformRole role = platformRoleMapper.selectByRoleCode(param.getRoleCode());
		if (role == null) {
			throw new ValidationException("角色不存在");
		}
		if (PlatformConstants.PLATFORM_ADMIN_ROLE_NAME.equals(role.getRoleName())) {
			throw new ValidationException("该用户不允许修改");
		}

		String userCode = param.getUserCode();
		PlatformUser user = platformUserMapper.getUserByUserCode(userCode);
		if (user == null) {
			throw new ValidationException("用户不存在");
		}
		String email = param.getEmail();
		if (!StringUtils.isBlank(email)) {
			// 带上用户编码是为了排除当前用户以外是否存在邮箱了
			PlatformUser u = platformUserMapper.getUserByEmail(email, userCode);
			if (u != null) {
				throw new ValidationException("邮箱已存在");
			}
		}
		PlatformUser u = platformUserMapper.getUserByPhoneNumber(param.getPhoneNumber(), userCode);
		if (u != null) {
			// 带上用户编码是为了排除当前用户以外是否存在手机了
			throw new ValidationException("手机号已存在");
		}

		Date nowDate = new Date();
		String modifier = param.getModifier();
		Long userId = user.getId();
		PlatformUser userRecord = PlatformUser.builder().modifier(modifier).lastModifyTime(nowDate).deptId(dept.getId())
				.email(param.getEmail()).phoneNumber(param.getPhoneNumber()).postName(param.getPostName())
				.userName(param.getUserName()).id(userId).build();
		platformUserMapper.updateByPrimaryKeySelective(userRecord);

		// 先删除原先的用户与角色的绑定
		platformUserRoleMapper.deleteByUserId(userId);

		// 重新对用户与角色进行新的绑定
		PlatformUserRole userRoleRecord = PlatformUserRole.builder().createTime(nowDate).creator(modifier)
				.userId(userId).roleId(role.getId()).build();
		platformUserRoleMapper.insertSelective(userRoleRecord);
		return JsonResult.successJsonResult();
	}

	public JsonResult<Pagination<UserInfo>> getUserList(@RequestBody SearchUserParam param) {
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		List<UserInfo> users = platformUserMapper.getUserInfoBySearchParam(param);
		return JsonResult.successJsonResult(new Pagination<>(users));
	}

	public JsonResult<String> enableOrDisableOrDelUser(@RequestBody EnableOrDisableOrDelUserParam param) {
		// 参数校验
		JSR303ValidateUtils.validateInputParam(param);
		int status = param.getStatus();
		this.checkStatusExist(status);
		PlatformUser userRecord = PlatformUser.builder().userCode(param.getUserCode()).status(status)
				.modifier(param.getModifier()).lastModifyTime(new Date()).build();
		platformUserMapper.updateByUserCode(userRecord);
		return JsonResult.successJsonResult();
	}

	public JsonResult<UserInfo> getUserInfo(String userCode) {
		if (StringUtils.isBlank(userCode)) {
			throw new ValidationException("用户编码不允许为空");
		}
		UserInfo userInfo = platformUserMapper.getUserInfoByUserCode(userCode);
		if (userInfo == null) {
			throw new ReturnDataException("无效用户");
		}
		return JsonResult.successJsonResult(userInfo);
	}
	
	/**
	 * 
	 * <p>
	 * 校验是否存在该状态
	 * </p>
	 * 
	 * @param value
	 * @return
	 * @author 黄智聪 2018年10月20日 上午11:29:37
	 */
	public void checkStatusExist(int value) {
		if (!UserStatus.checkStatusExist(value)) {
			throw new ValidationException("用户状态不存在");
		}
	}

}
