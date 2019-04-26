package com.hefa.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.user.pojo.bo.CheckVerificationCodeParam;
import com.hefa.user.pojo.bo.MemberParam;
import com.hefa.user.pojo.bo.UpdataUserPasswd;
import com.hefa.user.pojo.vo.MemberInfo;

@FeignClient("hefa-user-service")
public interface MemberUserService {


	/**
	 * 
	 * <p>查询会员列表</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/hefa/api/member/getMemberUserList")
	JsonResult<Pagination<MemberInfo>> getMemberUserList(@RequestBody MemberParam param);
	
	/**
	 * 
	 * <p>客户端 重置密码</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/hefa/api/client/updatePassword")
	 JsonResult<String> updatePassword(@RequestBody UpdataUserPasswd param);
	
	
	/**
	 * 
	 * <p>客户端 重置手机号码</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/hefa/api/client/updatePhone")
	JsonResult<String> updatePhone(@RequestParam("phone") String phone,@RequestParam("id") Integer id,@RequestParam("code") String code);
	
	/**
	 * 
	 * <p>客户端 重置邮箱</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/hefa/api/client/updateEmail")
	JsonResult<String> updateEmail(@RequestParam("email") String email,@RequestParam("id") Integer id,@RequestParam("code") String code);
	
	/**
	 * 发送短信
	 * @param phone
	 * @return
	 */
	@RequestMapping("/hefa/api/client/sendMsg")
	 JsonResult<String> sendMsg(@RequestParam("phone") String phone);
	
	/**
	 * 发送邮箱
	 * @param phone
	 * @return
	 */
	@RequestMapping("/hefa/api/client/sendEmail")
	 JsonResult<String> sendEmail(@RequestParam("email") String email);
	
	
	/**
     * 
     * <p>校验邮箱验证码</p>
     * @param param
     * @return
     * @author 黄智聪  2018年12月12日 下午5:45:46
     */
    @RequestMapping(value="/hefa/api/client/checkEmailEditVerificationCode")
    JsonResult<String> checkEmailEditVerificationCode(@RequestParam("verificationCode")String verificationCode,@RequestParam("email") String email);
	
	/**
     * 
     * <p>校验短信验证码</p>
     * @param param
     * @return
     * @author 黄智聪  2018年12月12日 下午5:45:46
     */
    @PostMapping("/hefa/api/client/checkEditVerificationCode")
    JsonResult<String> checkEditVerificationCode(@RequestBody CheckVerificationCodeParam param);
}
