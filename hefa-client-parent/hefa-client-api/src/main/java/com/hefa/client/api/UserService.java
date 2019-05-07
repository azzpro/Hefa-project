/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月15日 下午2:10:57
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hefa.common.base.JsonResult;
import com.hefa.pojo.bo.LoginParam;
import com.hefa.pojo.vo.LoginUserInfo;


/**
 * <P>用户业务</P>
 * @version 1.0
 * @author 黄智聪  2019年4月15日 下午2:10:57
 */
@FeignClient(name = "hefa-client-service")
public interface UserService {
	
	/**
	 * 
	 * <p>合发登录接口</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年5月7日 下午4:32:36
	 */
	@RequestMapping("/hefa/api/client/member/login")
    public JsonResult<LoginUserInfo> login(@RequestBody LoginParam param);
    
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
	@RequestMapping("/hefa/api/client/member/loginAuth")
	public JsonResult<String> loginAuth(@RequestBody LoginParam param);
	
	/**
	 * 
	 * <p>查询登录用户信息</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年5月7日 下午5:58:37
	 */
	@RequestMapping("/hefa/api/client/member/getLoginUser")
	public JsonResult<LoginUserInfo> getLoginUser(@RequestParam("username")String username);

}

