package com.azz.controller;

import java.util.Objects;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azz.client.pojo.vo.LoginClientUserInfo;
import com.azz.client.user.api.ClientService;
import com.azz.controller.utils.WebUtils;
import com.azz.core.common.JsonResult;
import com.azz.core.common.errorcode.ShiroAuthErrorCode;
import com.azz.core.constants.ClientConstants;
import com.azz.core.exception.ShiroAuthException;
import com.azz.core.exception.SuppressedException;
import com.azz.core.wx.constants.WxConstants;
import com.azz.system.api.QQLoginService;
import com.azz.system.api.WxLoginService;
import com.azz.system.bo.QQClientRegistParam;
import com.azz.system.bo.QQLoginParam;
import com.azz.system.bo.WxClientRegistParam;
import com.azz.system.bo.WxLoginParam;
import com.azz.system.pojo.ClientWxUser;
import com.azz.system.vo.QQCallBackInfo;
import com.azz.system.vo.WxCallBackInfo;
import com.azz.system.vo.WxInfo;
import com.azz.system.vo.WxLoginInfo;
import com.azz.util.JSR303ValidateUtils;

/**
 * @author THINK
 * QQ登录
 */
@RestController
@RequestMapping("/azz/api/qq")
public class QQLoginController {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private QQLoginService qqLoginService;
	
	@Autowired
	private ClientService clientService;
	
	@Value("${shiro.session.timeout}")
    private Long sessionTimeout;
	
	
	/**
	 * QQ回调
	 * @param code
	 * @param state
	 * @param key
	 * @return
	 */
	@RequestMapping(value="callback",method=RequestMethod.POST)
	public Object callback(@RequestParam("access_token")String access_token,@RequestParam("openid")String openid) {
		log.info("进入QQ 回调");
		JsonResult<WxCallBackInfo> result = qqLoginService.callback(access_token,openid);
		if(Objects.equals(WxConstants.LOGINCODE, result.getData().getCode())) {
			// 从SecurityUtils里边创建一个 subject
			Subject subject = SecurityUtils.getSubject();
			// 在认证提交前准备 token（令牌）
			UsernamePasswordToken token = new UsernamePasswordToken(result.getData().getPhone(),"noUse");
			try {
			    // 执行认证登陆
			    subject.login(token);
			    // 设置登录超时时间
			    subject.getSession().setTimeout(sessionTimeout);
			} catch (AuthenticationException e) {
			    Throwable[] throwables = e.getSuppressed();
			    if(throwables != null && throwables.length != 0) {
			    	int c = ((SuppressedException) throwables[0]).getCode();
				    String msg = ((SuppressedException) throwables[0]).getMessage();
				    JsonResult<LoginClientUserInfo> jr = new JsonResult<>();
				    jr.setCode(c);
				    jr.setMsg(msg);
				    return jr;
			    }
			    throw new ShiroAuthException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_LOGIN_ERROR,"登录失败,请重试");
			}
			JsonResult<LoginClientUserInfo> jsonResult = clientService.getLoginClientUserInfoByPhoneNumber(result.getData().getPhone());
			LoginClientUserInfo loginClientUser = jsonResult.getData();
			loginClientUser.setSessionId(subject.getSession().getId());
			WebUtils.setShiroSessionAttr(ClientConstants.LOGIN_CLIENT_USER, loginClientUser);
			return jsonResult;
		}else {
			return result;
			//throw new ShiroAuthException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_LOGIN_ERROR,"登录失败,请重新扫码");
		}
		
	}
	
	/**
	 * 绑定或者注册
	 * @param wcbi
	 * @return
	 */
	@RequestMapping(value="goBindOrReg",method=RequestMethod.POST)
	public JsonResult<WxCallBackInfo> goBindOrReg( QQCallBackInfo wcbi) {
		return qqLoginService.goBindOrReg(wcbi);
	}
	
	/**
	 * 登录并绑定
	 * @param param
	 * @return
	 */
	@RequestMapping(value="loginAndBind",method=RequestMethod.POST)
	public JsonResult<LoginClientUserInfo> loginAndBind( QQLoginParam param) {
		JSR303ValidateUtils.validate(param);
		// 从SecurityUtils里边创建一个 subject
		Subject subject = SecurityUtils.getSubject();
		// 在认证提交前准备 token（令牌）
		UsernamePasswordToken token = new UsernamePasswordToken(param.getPhoneNumber(), param.getPassword());
		try {
		    // 执行认证登陆
		    subject.login(token);
		    // 设置登录超时时间
		    subject.getSession().setTimeout(sessionTimeout);
		} catch (AuthenticationException e) {
		    Throwable[] throwables = e.getSuppressed();
		    if(throwables != null && throwables.length != 0) {
		    	int code = ((SuppressedException) throwables[0]).getCode();
			    String msg = ((SuppressedException) throwables[0]).getMessage();
			    JsonResult<LoginClientUserInfo> jr = new JsonResult<>();
			    jr.setCode(code);
			    jr.setMsg(msg);
			    return jr;
		    }
		    throw new ShiroAuthException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_LOGIN_ERROR,"登录失败,请重试");
		}
		JsonResult<LoginClientUserInfo> jr = clientService.getLoginClientUserInfoByPhoneNumber(param.getPhoneNumber());
		LoginClientUserInfo loginClientUser = jr.getData();
		loginClientUser.setSessionId(subject.getSession().getId());
		WebUtils.setShiroSessionAttr(ClientConstants.LOGIN_CLIENT_USER, loginClientUser);
		ClientWxUser wsc = new ClientWxUser();
		wsc.setAccess_token(param.getAccessToken());
		wsc.setOpenid(param.getOpenid());
		wsc.setUserCode(loginClientUser.getClientUserInfo().getClientUserCode());
		wsc.setAvatarUrl(param.getAvatarUrl());
		wsc.setNickName(param.getNickName());
		wsc.setPlatformType("QQ");
		qqLoginService.insert(wsc);
		return jr;
	}
	
	/**
	 * 注册并绑定
	 * @param wcrp
	 * @return
	 */
	@RequestMapping(value="regAndBind",method=RequestMethod.POST)
	public JsonResult<LoginClientUserInfo> regAndBind( QQClientRegistParam wcrp) {
		JsonResult<WxLoginInfo> bind = qqLoginService.regAndBind(wcrp);
		if(bind.getData() != null && bind.getData().getCode().equals(WxConstants.REGSUCCESSCODE)) {
			// 从SecurityUtils里边创建一个 subject
			Subject subject = SecurityUtils.getSubject();
			// 在认证提交前准备 token（令牌）
			UsernamePasswordToken token = new UsernamePasswordToken(bind.getData().getPhone(), bind.getData().getPassword());
			try {
			    // 执行认证登陆
			    subject.login(token);
			    // 设置登录超时时间
			    subject.getSession().setTimeout(sessionTimeout);
			} catch (AuthenticationException e) {
			    Throwable[] throwables = e.getSuppressed();
			    if(throwables != null && throwables.length != 0) {
			    	int code = ((SuppressedException) throwables[0]).getCode();
				    String msg = ((SuppressedException) throwables[0]).getMessage();
				    JsonResult<LoginClientUserInfo> jr = new JsonResult<>();
				    jr.setCode(code);
				    jr.setMsg(msg);
				    return jr;
			    }
			    throw new ShiroAuthException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_LOGIN_ERROR,"登录失败,请重试");
			}
			JsonResult<LoginClientUserInfo> jr = clientService.getLoginClientUserInfoByPhoneNumber(bind.getData().getPhone());
			LoginClientUserInfo loginClientUser = jr.getData();
			loginClientUser.setSessionId(subject.getSession().getId());
			WebUtils.setShiroSessionAttr(ClientConstants.LOGIN_CLIENT_USER, loginClientUser);
			return jr;
		}else {
			throw new ShiroAuthException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_LOGIN_ERROR,"登录失败,请重试");
		}
	}
}
