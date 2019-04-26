/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月15日 下午2:40:55
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.client.service.UserService;
import com.hefa.common.base.JsonResult;
import com.hefa.pojo.bo.LoginParam;
import com.hefa.pojo.vo.LoginUserInfo;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月15日 下午2:40:55
 */
@RestController
@RequestMapping("/api/hefa/client/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public JsonResult<LoginUserInfo> login(LoginParam param) {
		return userService.login(param);
    }
	
}

