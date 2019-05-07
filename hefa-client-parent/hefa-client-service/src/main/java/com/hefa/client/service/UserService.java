/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月15日 下午2:10:57
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hefa.client.mapper.UserMapper;
import com.hefa.common.base.JsonResult;
import com.hefa.common.errorcode.ShiroAuthErrorCode;
import com.hefa.common.exception.ReturnDataException;
import com.hefa.common.exception.ShiroAuthException;
import com.hefa.pojo.bo.LoginParam;
import com.hefa.pojo.vo.LoginUserInfo;
import com.hefa.utils.JSR303ValidateUtils;
import com.hefa.utils.MD5Encrypt;


/**
 * <P>用户业务</P>
 * @version 1.0
 * @author 黄智聪  2019年4月15日 下午2:10:57
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 
	 * <p>合发登录接口</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年5月7日 下午4:32:36
	 */
    public JsonResult<LoginUserInfo> login(@RequestBody LoginParam param) {
		JSR303ValidateUtils.validateInputParam(param);
		return null;
    }
    
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
	public JsonResult<String> loginAuth(@RequestBody LoginParam param) {
		String username = param.getUsername();
		String password = param.getPassword();
		String md5Password = MD5Encrypt.encryptMD5(password);
		LoginUserInfo loginUser = userMapper.getLoginUser(username, md5Password);
		if (loginUser == null) {
			throw new ShiroAuthException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_LOGIN_ERROR, "请输入正确的账号或密码");
		}
		return JsonResult.successJsonResult();
	}
	
	/**
	 * 
	 * <p>查询登录用户信息</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年5月7日 下午5:58:37
	 */
	public JsonResult<LoginUserInfo> getLoginUser(@RequestParam("username")String username) {
		LoginUserInfo loginUser = userMapper.getLoginUser(username, null);
		if (loginUser == null) {
			throw new ReturnDataException("用户不存在");
		}
		return JsonResult.successJsonResult(loginUser);
	}

}

