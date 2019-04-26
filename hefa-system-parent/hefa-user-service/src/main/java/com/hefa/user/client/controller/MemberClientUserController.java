package com.hefa.user.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.user.pojo.bo.CheckVerificationCodeParam;
import com.hefa.user.pojo.bo.MemberParam;
import com.hefa.user.pojo.bo.UpdataUserPasswd;
import com.hefa.user.pojo.vo.MemberInfo;
import com.hefa.user.service.MemberUserService;

/**
 * @author THINK
 * 会员管理
 */
@RestController
@RequestMapping("/hefa/api/client")
public class MemberClientUserController {
	
	@Autowired
	private MemberUserService memberUserService;
	
	
	/**
	 * 
	 * <p>发送短信验证码</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("sendMsg")
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
	@RequestMapping("sendEmail")
	public JsonResult<String> sendEmail( String email){
		return memberUserService.sendEmail(email);
	} 
	
	/**
     * 
     * <p>校验验证码</p>
     * @param param
     * @return
     * @author 黄智聪  2018年12月12日 下午5:45:46
     */
    @RequestMapping("checkEditVerificationCode")
    public JsonResult<String> checkEditVerificationCode(@RequestBody CheckVerificationCodeParam param) {
    	return memberUserService.checkEditVerificationCode(param);
    }
    
    /**
     * 
     * <p>校验邮箱验证码</p>
     * @param param
     * @return
     * @author 黄智聪  2018年12月12日 下午5:45:46
     */
    @RequestMapping("checkEmailEditVerificationCode")
    public JsonResult<String> checkEmailEditVerificationCode(@RequestParam("verificationCode")String verificationCode,@RequestParam("email") String email) {
    	return memberUserService.checkEditEmailVerificationCode(verificationCode,email);
    }
	
	
	/**
	 * 
	 * <p>客户端 重置密码</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("updatePassword")
	public JsonResult<String> updatePassword(@RequestBody UpdataUserPasswd param){
		return memberUserService.updatePassword(param);
	} 
	
	/**
	 * 
	 * <p>客户端 重置手机号码</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("updatePhone")
	public JsonResult<String> updatePhone(@RequestParam("phone") String phone,@RequestParam("id") Integer id,@RequestParam("code") String code){
		return memberUserService.updatePhone(phone,id,code);
	} 
	
	/**
	 * 
	 * <p>客户端 重置邮箱</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("updateEmail")
	public JsonResult<String> updateEmail(@RequestParam("email") String email,@RequestParam("id") Integer id,@RequestParam("code") String code){
		return memberUserService.updateEmail(email,id,code);
	} 
}
