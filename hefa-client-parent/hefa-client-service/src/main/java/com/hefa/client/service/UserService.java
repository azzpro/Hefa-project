/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月15日 下午2:10:57
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.client.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.hefa.common.base.JsonResult;
import com.hefa.common.exception.ValidationException;
import com.hefa.pojo.bo.LoginParam;
import com.hefa.pojo.vo.LoginUserInfo;
import com.hefa.utils.JSR303ValidateUtils;


/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月15日 下午2:10:57
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class UserService {

    public JsonResult<LoginUserInfo> login(@RequestBody LoginParam param) {
		JSR303ValidateUtils.validateInputParam(param);
		if(param.getUsername().equals("admin") && param.getPassword().equals("admin")) {
			LoginUserInfo info = new LoginUserInfo();
			info.setGender("男");
			info.setUsername("Cc");
			return JsonResult.successJsonResult(info);
		}else {
			throw new ValidationException("用户名或密码错误");
		}
    }
	
}

