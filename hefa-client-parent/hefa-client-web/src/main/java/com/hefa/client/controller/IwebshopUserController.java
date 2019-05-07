package com.hefa.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.common.base.JsonResult;
import com.hefa.user.api.MemberUserService;
import com.hefa.user.pojo.bo.CheckVerificationCodeParam;
import com.hefa.user.pojo.bo.UpdataUserPasswd;

/**
 * @author THINK
 * 客户端用户管理
 */
@RestController
@RequestMapping("/hefa/api/client/member")
public class IwebshopUserController {

	@Autowired
	private MemberUserService memberUserService;
	
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
