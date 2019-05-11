package com.hefa.client.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.client.api.UserService;
import com.hefa.client.util.WebUtils;
import com.hefa.common.base.JsonResult;
import com.hefa.pojo.bo.LoginParam;
import com.hefa.pojo.vo.LoginUserInfo;
import com.hefa.pojo.vo.UserInfo;
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
	
	@Autowired
	private MemberUserService memberUserService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * <p>登录</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年5月7日 下午6:13:33
	 */
	@RequestMapping(value = "/login")
	public JsonResult<String> login(LoginParam param) {
		param.setIpAddress(WebUtils.getHttpServletRequest().getRemoteAddr());
		JSR303ValidateUtils.validateInputParam(param);
		return userService.login(param);
	}
	
	/**
	 * 
	 * <p>获取用户信息</p>
	 * @return
	 * @author 黄智聪  2019年5月11日 上午10:20:26
	 */
	@RequestMapping(value = "/getUserInfo")
	public JsonResult<UserInfo> getUserInfo(){
		LoginUserInfo loginUserInfo = WebUtils.getLoginUser();
		UserInfo userInfo = new UserInfo();
		BeanUtils.copyProperties(loginUserInfo, userInfo);
		// 该用户信息不包含用户登录时间
		return JsonResult.successJsonResult(userInfo);
	}
	
	/**
	 * 
	 * <p>发送短信验证码</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/sendMsg")
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
	@RequestMapping("/sendEmail")
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
    @RequestMapping(value="/checkEditVerificationCode")
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
    @RequestMapping(value="/checkEmailEditVerificationCode")
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
	@RequestMapping("/updatePassword")
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
	@RequestMapping("/updatePhone")
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
	@RequestMapping("/updateEmail")
	public JsonResult<String> updateEmail(String email,Integer id, String code){
		return memberUserService.updateEmail(email,id,code);
	} 
}
