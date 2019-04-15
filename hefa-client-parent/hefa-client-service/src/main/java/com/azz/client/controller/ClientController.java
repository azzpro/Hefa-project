/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月22日 下午5:18:06
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.azz.client.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azz.client.pojo.bo.AddClientUserParam;
import com.azz.client.pojo.bo.ChangeAvatarParam;
import com.azz.client.pojo.bo.CheckVerificationCodeParam;
import com.azz.client.pojo.bo.ClientRegistParam;
import com.azz.client.pojo.bo.EditClientUserParam;
import com.azz.client.pojo.bo.EditPersonalInfoParam;
import com.azz.client.pojo.bo.EnterpriseAuthParam;
import com.azz.client.pojo.bo.LoginParam;
import com.azz.client.pojo.bo.RemoveClientUserParam;
import com.azz.client.pojo.bo.SearchClientUserParam;
import com.azz.client.pojo.vo.ClientCompanyInfo;
import com.azz.client.pojo.vo.ClientPersonalInfo;
import com.azz.client.pojo.vo.ClientUserInfo;
import com.azz.client.pojo.vo.LoginClientUserInfo;
import com.azz.client.service.ClientService;
import com.azz.core.common.JsonResult;
import com.azz.core.common.page.Pagination;

/**
 * <P>
 * TODO
 * </P>
 * 
 * @version 1.0
 * @author 黄智聪 2018年10月22日 下午5:18:06
 */
@RestController
@RequestMapping("/azz/api/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

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
	@RequestMapping("/loginAuth")
	public JsonResult<String> loginAuth(@RequestBody LoginParam param) {
		return clientService.loginAuth(param);
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
	@RequestMapping("/getLoginClientUserInfoByPhoneNumber")
	public JsonResult<LoginClientUserInfo> getLoginClientUserInfoByPhoneNumber(
			@RequestParam("phoneNumber") String phoneNumber) {
		return clientService.getLoginClientUserInfoByPhoneNumber(phoneNumber);
	}

	@RequestMapping("/getLoginClientUserInfoByOpenid")
	public JsonResult<LoginClientUserInfo> getLoginClientUserInfoByOpenid(
			@RequestParam("openid") String openid) {
		return clientService.getLoginClientUserInfoByOpenid(openid);
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
	@RequestMapping("/clientRegist")
	public JsonResult<String> clientRegist(@RequestBody ClientRegistParam param) {
		return clientService.clientRegist(param);
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
	@RequestMapping("/enterpriseAuth")
	public JsonResult<LoginClientUserInfo> enterpriseAuth(@RequestBody EnterpriseAuthParam param) {
		return clientService.enterpriseAuth(param);
	}

	/**
	 * 
	 * <p>
	 * 新增客户成员
	 * </p>
	 * 
	 * @param param
	 * @return
	 * @author 黄智聪 2018年10月29日 上午11:02:35
	 */
	@RequestMapping("/addClientUser")
	public JsonResult<String> addClientUser(@RequestBody AddClientUserParam param) {
		return clientService.addClientUser(param);
	}

	/**
	 * 
	 * <p>
	 * 编辑客户成员
	 * </p>
	 * 
	 * @param param
	 * @return
	 * @author 黄智聪 2018年10月29日 上午11:02:48
	 */
	@RequestMapping("/editClientUser")
	public JsonResult<String> editClientUser(@RequestBody EditClientUserParam param) {
		return clientService.editClientUser(param);
	}

	/**
	 * 
	 * <p>
	 * 查询客户成员列表
	 * </p>
	 * 
	 * @param param
	 * @return
	 * @author 黄智聪 2018年10月29日 上午11:02:58
	 */
	@RequestMapping("/getClientUserList")
	public JsonResult<Pagination<ClientUserInfo>> getUserList(@RequestBody SearchClientUserParam param) {
		return clientService.getClientUserList(param);
	}

	/**
	 * 
	 * <p>
	 * 移除客户成员
	 * </p>
	 * 
	 * @param param
	 * @return
	 * @author 黄智聪 2018年10月29日 上午11:05:36
	 */
	@RequestMapping("/removeClientUser")
	public JsonResult<String> removeClientUser(@RequestBody RemoveClientUserParam param) {
		return clientService.removeClientUser(param);
	}

	/**
	 * 
	 * <p>
	 * 查询客户成员详情
	 * </p>
	 * 
	 * @param clientUserCode
	 * @return
	 * @author 黄智聪 2018年10月29日 上午11:05:52
	 */
	@RequestMapping("/getClientUserInfo")
	public JsonResult<ClientUserInfo> getClientUserInfo(@RequestParam("clientUserCode") String clientUserCode) {
		return clientService.getClientUserInfo(clientUserCode);
	}

	/**
	 * 
	 * <p>
	 * 查询客户个人资料
	 * </p>
	 * 
	 * @param clientUserCode
	 * @return
	 * @author 黄智聪 2018年10月29日 下午3:30:34
	 */
	@RequestMapping("/getClientPersonalInfo")
	public JsonResult<ClientPersonalInfo> getClientPersonalInfo(@RequestParam("clientUserCode") String clientUserCode) {
		return clientService.getClientPersonalInfo(clientUserCode);
	}

	/**
	 * 
	 * <p>
	 * 更换客户头像
	 * </p>
	 * 
	 * @param webParam
	 * @return
	 * @throws IOException
	 * @author 黄智聪 2018年10月29日 上午11:06:01
	 */
	@RequestMapping("/changeAvatar")
	public JsonResult<String> changeAvatar(@RequestBody ChangeAvatarParam param) {
		return clientService.changeAvatar(param);
	}

	/**
	 * 
	 * <p>
	 * 查询公司资料信息
	 * </p>
	 * 
	 * @param clientUserCode
	 * @return
	 * @author 黄智聪 2018年10月30日 上午2:43:19
	 */
	@RequestMapping("/getClientCompanyInfo")
	public JsonResult<ClientCompanyInfo> getClientCompanyInfo(@RequestParam("clientUserCode") String clientUserCode) {
		return clientService.getClientCompanyInfo(clientUserCode);
	}

	@RequestMapping("/sendVerificationCode")
	public JsonResult<String> sendVerificationCode(@RequestParam("phoneNumber") String phoneNumber) {
		return clientService.sendVerificationCode(phoneNumber);
	}

	/**
	 * 
	 * <p>
	 * 修改个人资料
	 * </p>
	 * 
	 * @param param
	 * @return
	 * @author 黄智聪 2018年12月12日 下午5:43:40
	 */
	@RequestMapping(value = "/editPersonalInfo")
	JsonResult<String> editPersonalInfo(@RequestBody EditPersonalInfoParam param) {
		return clientService.editPersonalInfo(param);
	}

	/**
	 * 
	 * <p>
	 * 发送修改个人信息的邮箱验证码
	 * </p>
	 * 
	 * @param email
	 * @return
	 * @author 黄智聪 2018年12月14日 上午11:37:14
	 */
	@RequestMapping(value = "/sendEditEmailVerificationCode")
	public JsonResult<String> sendEditEmailVerificationCode(@RequestParam("email") String email) {
		return clientService.sendEditEmailVerificationCode(email);
	}

	/**
	 * 
	 * <p>
	 * 发送修改个人信息的验证码
	 * </p>
	 * 
	 * @param phoneNumber
	 * @return
	 * @author 黄智聪 2018年12月12日 下午5:45:42
	 */
	@RequestMapping(value = "/sendEditVerificationCode")
	JsonResult<String> sendEditVerificationCode(@RequestParam("phoneNumber") String phoneNumber) {
		return clientService.sendEditVerificationCode(phoneNumber);
	}

	/**
	 * 
	 * <p>
	 * 校验验证码
	 * </p>
	 * 
	 * @param param
	 * @return
	 * @author 黄智聪 2018年12月12日 下午5:45:46
	 */
	@RequestMapping(value = "/checkEditVerificationCode")
	public JsonResult<String> checkEditVerificationCode(@RequestBody CheckVerificationCodeParam param) {
		return clientService.checkEditVerificationCode(param);
	}
}
