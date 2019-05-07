package com.hefa.client.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.client.api.UserService;
import com.hefa.client.util.WebUtils;
import com.hefa.common.base.JsonResult;
import com.hefa.common.constants.UserConstants;
import com.hefa.common.errorcode.ShiroAuthErrorCode;
import com.hefa.common.exception.ShiroAuthException;
import com.hefa.common.exception.SuppressedException;
import com.hefa.pojo.bo.LoginParam;
import com.hefa.pojo.vo.LoginUserInfo;
import com.hefa.user.api.MemberUserService;
import com.hefa.user.pojo.bo.CheckVerificationCodeParam;
import com.hefa.user.pojo.bo.UpdataUserPasswd;
import com.hefa.utils.JSR303ValidateUtils;

/**
 * @author THINK
 * 客户端用户管理
 */
@RestController
@RequestMapping("/hefa/api/client/member")
public class IwebshopUserController {
	
	@Value("${shiro.session.timeout}")
	private Long sessionTimeout;

	@Autowired
	private MemberUserService memberUserService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * <p>
	 * 未登录
	 * </p>
	 * 
	 * @author 黄智聪 2018年10月17日 下午5:50:41
	 */
	@RequestMapping(value = "/noLogin")
	public void notLogin() {
		throw new ShiroAuthException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_NO_LOGIN);
	}

	/**
	 * 
	 * <p>
	 * 无权限
	 * </p>
	 * 
	 * @author 黄智聪 2018年10月17日 下午5:50:51
	 */
	@RequestMapping(value = "/noPermission")
	public void notRole() {
		throw new ShiroAuthException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_NO_PERMISSION);
	}

	/**
	 * 
	 * <p>
	 * 登出
	 * </p>
	 * 
	 * @return
	 * @author 黄智聪 2018年10月17日 下午5:51:01
	 */
	@RequestMapping(value = "/logout")
	public JsonResult<String> logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return JsonResult.successJsonResult();
	}

	/**
	 * 
	 * <p>登录</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年5月7日 下午6:13:33
	 */
	@RequestMapping(value = "/login")
	public JsonResult<LoginUserInfo> login(LoginParam param) {
		JSR303ValidateUtils.validateInputParam(param);
		// 从SecurityUtils里边创建一个 subject
		Subject subject = SecurityUtils.getSubject();
		// 在认证提交前准备 token（令牌）
		UsernamePasswordToken token = new UsernamePasswordToken(param.getUsername(), param.getPassword());
		try {
			// 执行认证登陆
			subject.login(token);
			// 设置登录超时时间
			subject.getSession().setTimeout(sessionTimeout);
		} catch (AuthenticationException e) {
			Throwable[] throwables = e.getSuppressed();
			if (throwables != null && throwables.length != 0) {
				int code = ((SuppressedException) throwables[0]).getCode();
				String msg = ((SuppressedException) throwables[0]).getMessage();
				JsonResult<LoginUserInfo> jr = new JsonResult<>();
				jr.setCode(code);
				jr.setMsg(msg);
				return jr;
			}
			throw new ShiroAuthException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_LOGIN_ERROR, "登录失败,请重试");
		}
		JsonResult<LoginUserInfo> jr = userService.getLoginUser(param.getUsername());
		LoginUserInfo loginUser = jr.getData();
		loginUser.setSessionId(subject.getSession().getId());
		WebUtils.setShiroSessionAttr(UserConstants.LOGIN_USER, loginUser);
		return jr;
	}
	
	/**
	 * 
	 * <p>发送短信验证码</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/client/sendMsg")
	public JsonResult<String> sendMsg( String phone){
		return memberUserService.sendMsg(phone);
	} 
	
	
	/**
	 * 
	 * <p>发送Email验证码</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/client/sendEmail")
	public JsonResult<String> sendEmail( String email){
		return memberUserService.sendEmail(email);
	} 
	
	/**
     * 
     * <p>校验短信验证码</p>
     * @param param
     * @return
     * @author 
     */
    @RequestMapping(value="/client/checkEditVerificationCode")
    public JsonResult<String> checkEditVerificationCode( CheckVerificationCodeParam param) {
    	return memberUserService.checkEditVerificationCode(param);
    }
    
    
    /**
     * 
     * <p>校验邮箱验证码</p>
     * @param param
     * @return
     * @author 
     */
    @RequestMapping(value="/client/checkEmailEditVerificationCode")
    public JsonResult<String> checkEmailEditVerificationCode(String verificationCode,String email) {
    	return memberUserService.checkEmailEditVerificationCode(verificationCode,email);
    }
	
	/**
	 * 
	 * <p>修改密码</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/client/updatePassword")
	public JsonResult<String> updatePassword( UpdataUserPasswd param){
		return memberUserService.updatePassword(param);
	} 
	
	/**
	 * 
	 * <p>客户端 重置密码</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/client/updatePhone")
	public JsonResult<String> updatePhone(String phone,Integer id, String code){
		return memberUserService.updatePhone(phone,id,code);
	} 
	
	/**
	 * 
	 * <p>客户端 重置密码</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/client/updateEmail")
	public JsonResult<String> updateEmail(String email,Integer id, String code){
		return memberUserService.updateEmail(email,id,code);
	} 
}
