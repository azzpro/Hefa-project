/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月22日 下午5:18:06
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.user.api;
import java.io.IOException;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
import com.azz.core.common.JsonResult;
import com.azz.core.common.page.Pagination;


/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年10月22日 下午5:18:06
 */
@FeignClient("azz-client-service")
public interface ClientService {

    /**
     * 
     * <p>登录认证</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月29日 上午11:07:16
     */
    @RequestMapping("/azz/api/client/loginAuth")
    JsonResult<String> loginAuth(@RequestBody LoginParam param);
    
    /**
     * 
     * <p>查询登录客户信息</p>
     * @param phoneNumber
     * @return
     * @author 黄智聪  2018年10月29日 上午11:07:27
     */
    @RequestMapping("/azz/api/client/getLoginClientUserInfoByPhoneNumber")
    JsonResult<LoginClientUserInfo> getLoginClientUserInfoByPhoneNumber(@RequestParam("phoneNumber")String phoneNumber);
    
    
    /**
     * 
     * <p>查询登录客户信息</p>
     * @param phoneNumber
     * @return
     * @author 黄智聪  2018年10月29日 上午11:07:27
     */
    @RequestMapping("/azz/api/client/getLoginClientUserInfoByOpenid")
    JsonResult<LoginClientUserInfo> getLoginClientUserInfoByOpenid(@RequestParam("openid")String openid);
    
    /*    
    @RequestMapping("/sendVerificationCode")
    JsonResult<Long> sendVerificationCode(String phoneNumber);
    */
    
    /**
     * 
     * <p>客户注册</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月29日 上午11:07:38
     */
    @RequestMapping("/azz/api/client/clientRegist")
    JsonResult<String> clientRegist(@RequestBody ClientRegistParam param);
    
    /**
     * 
     * <p>企业认证</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月23日 下午8:04:27
     * @throws IOException 
     */
    @RequestMapping("/azz/api/client/enterpriseAuth")
    JsonResult<LoginClientUserInfo> enterpriseAuth(@RequestBody EnterpriseAuthParam param);
    
    /**
     * 
     * <p>新增客户成员</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月29日 上午11:02:35
     */
    @RequestMapping("/azz/api/client/addClientUser")
    JsonResult<String> addClientUser(@RequestBody AddClientUserParam param);
    
    /**
     * 
     * <p>编辑客户成员</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月29日 上午11:02:48
     */
    @RequestMapping("/azz/api/client/editClientUser")
    JsonResult<String> editClientUser(@RequestBody EditClientUserParam param);
    
    /**
     * 
     * <p>查询客户成员列表</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月29日 上午11:02:58
     */
    @RequestMapping("/azz/api/client/getClientUserList")
    JsonResult<Pagination<ClientUserInfo>> getClientUserList(@RequestBody SearchClientUserParam param);
    
    /**
     * 
     * <p>移除客户成员</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月29日 上午11:05:36
     */
    @RequestMapping("/azz/api/client/removeClientUser")
    JsonResult<String> removeClientUser(@RequestBody RemoveClientUserParam param);
    
    /**
     * 
     * <p>查询客户成员详情</p>
     * @param clientUserCode
     * @return
     * @author 黄智聪  2018年10月29日 上午11:05:52
     */
    @RequestMapping("/azz/api/client/getClientUserInfo")
    JsonResult<ClientUserInfo> getClientUserInfo(@RequestParam("clientUserCode") String clientUserCode);
    
    /**
     * 
     * <p>查询客户个人资料</p>
     * @param clientUserCode
     * @return
     * @author 黄智聪  2018年10月29日 下午3:30:34
     */
    @RequestMapping("/azz/api/client/getClientPersonalInfo")
    JsonResult<ClientPersonalInfo> getClientPersonalInfo(@RequestParam("clientUserCode") String clientUserCode);
    
    /**
     * 
     * <p>更换客户头像</p>
     * @param webParam
     * @return
     * @throws IOException
     * @author 黄智聪  2018年10月29日 上午11:06:01
     */
    @RequestMapping("/azz/api/client/changeAvatar")
    JsonResult<String> changeAvatar(@RequestBody ChangeAvatarParam param);
    
    /**
     * 
     * <p>查询公司资料信息</p>
     * @param clientUserCode
     * @return
     * @author 黄智聪  2018年10月30日 上午2:43:19
     */
    @RequestMapping("/azz/api/client/getClientCompanyInfo")
    JsonResult<ClientCompanyInfo> getClientCompanyInfo(@RequestParam("clientUserCode") String clientUserCode);

    @RequestMapping("/azz/api/client/sendVerificationCode")
    JsonResult<String> sendVerificationCode(@RequestParam("phoneNumber") String phoneNumber);
    
    /**
     * 
     * <p>修改个人资料</p>
     * @param param
     * @return
     * @author 黄智聪  2018年12月12日 下午5:43:40
     */
    @RequestMapping("/azz/api/client/editPersonalInfo")
    JsonResult<String> editPersonalInfo(@RequestBody EditPersonalInfoParam param);
    
    /**
     * 
     * <p>发送修改个人信息的邮箱验证码</p>
     * @param email
     * @return
     * @author 黄智聪  2018年12月14日 上午11:39:01
     */
    @RequestMapping("/azz/api/client/sendEditEmailVerificationCode")
    JsonResult<String> sendEditEmailVerificationCode(@RequestParam("email")String email);
    
    /**
     * 
     * <p>发送修改个人信息的验证码 </p>
     * @param phoneNumber
     * @return
     * @author 黄智聪  2018年12月12日 下午5:45:42
     */
    @RequestMapping("/azz/api/client/sendEditVerificationCode")
    JsonResult<String> sendEditVerificationCode(@RequestParam("phoneNumber")String phoneNumber);
    
    /**
     * 
     * <p>校验验证码</p>
     * @param param
     * @return
     * @author 黄智聪  2018年12月12日 下午5:45:46
     */
    @RequestMapping("/azz/api/client/checkEditVerificationCode")
    JsonResult<String> checkEditVerificationCode(@RequestBody CheckVerificationCodeParam param);
    
}

