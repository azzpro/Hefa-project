package com.hefa.client.controller;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.hefa.client.api.UserService;
import com.hefa.client.util.WebUtils;
import com.hefa.common.base.JsonResult;
import com.hefa.common.constants.ClientConstants;
import com.hefa.pojo.bo.LoginParam;
import com.hefa.pojo.vo.LoginUserInfo;
import com.hefa.pojo.vo.UserInfo;
import com.hefa.user.api.MemberUserService;
import com.hefa.user.pojo.bo.CheckVerificationCodeParam;
import com.hefa.user.pojo.bo.UpdataUserPasswd;
import com.hefa.utils.AesUtils;
import com.hefa.utils.StringUtils;

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
	
	@Autowired
	private StringRedisTemplate redis;
	
	/**
	 * 
	 * <p>登录</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年5月7日 下午6:13:33
	 */
	@RequestMapping(value = "/login")
	public JsonResult<Map<String, String>> login(LoginParam param) {
		param.setIpAddress(WebUtils.getHttpServletRequest().getRemoteAddr());
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
		memberUserService.updatePhone(phone,id,code);
		LoginUserInfo loginUser = WebUtils.getLoginUser();
		loginUser.setMobile(phone);
		// 替换用户token
		String newUserToken = this.replaceUserToken(loginUser);
		return JsonResult.successJsonResult(newUserToken);
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
		memberUserService.updateEmail(email,id,code);
		LoginUserInfo loginUser = WebUtils.getLoginUser();
		loginUser.setEmail(email);
		// 替换用户token
		String newUserToken = this.replaceUserToken(loginUser);
		return JsonResult.successJsonResult(newUserToken);
	}

	/**
	 * 
	 * <p>替换用户token</p>
	 * @param loginUser
	 * @author 黄智聪  2019年5月16日 下午5:46:51
	 */
	private String replaceUserToken(LoginUserInfo loginUser) {
		String userToken = null;
		try {
			String userInfoJson = JSONObject.toJSONString(loginUser);
			// userToken加密方式:先用AES加密，然后再用base64编码一次，这样可以去除AES密文中的特殊字符
			userToken = Base64.encodeBase64String(AesUtils.encrypt(userInfoJson, ClientConstants.DEFAULT_ASE_KEY).getBytes());
			String userCode = loginUser.getUserCode();
			// 客户端用户地址
			String currentIpAddress = WebUtils.getHttpServletRequest().getRemoteAddr();
			String redisUserIpKey = ClientConstants.LOGIN_USER_TOKEN_REDIS_PREFIX + userCode;
			String redisIpAddress = redis.opsForValue().get(redisUserIpKey);
			// 若当前ip地址与redis存的ip地址不一致，说明是异地登录了，将redis原来的ip删除。
			if(!StringUtils.isBlank(redisIpAddress) && !currentIpAddress.equals(redisIpAddress)) {
				redis.delete(ClientConstants.LOGIN_USER_TOKEN_REDIS_PREFIX + userCode + "_" + redisIpAddress);
			}
			// 当前用户的ip存入redis，以userToken_userCode为key，value是对应的ip地址
			redis.opsForValue().set(redisUserIpKey, currentIpAddress, ClientConstants.LOGIN_USER_TOKEN_REDIS_HOURS_TIME_OUT, TimeUnit.HOURS);
			// 用户token存入redis，以userToken_userCode_ipAddress为key
			String redisUserTokenKey = ClientConstants.LOGIN_USER_TOKEN_REDIS_PREFIX + userCode + "_" + currentIpAddress;
			redis.opsForValue().set(redisUserTokenKey, userToken, ClientConstants.LOGIN_USER_TOKEN_REDIS_HOURS_TIME_OUT, TimeUnit.HOURS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userToken;
	} 
}
