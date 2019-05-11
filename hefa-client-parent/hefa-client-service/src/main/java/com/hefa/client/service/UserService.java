/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月15日 下午2:10:57
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.client.service;

import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.hefa.client.mapper.UserMapper;
import com.hefa.common.base.JsonResult;
import com.hefa.common.constants.ClientConstants;
import com.hefa.common.errorcode.ApiRequestErrorCode;
import com.hefa.common.exception.ApiRequestException;
import com.hefa.common.exception.ReturnDataException;
import com.hefa.pojo.bo.LoginParam;
import com.hefa.pojo.vo.LoginUserInfo;
import com.hefa.utils.AesUtils;
import com.hefa.utils.JSR303ValidateUtils;
import com.hefa.utils.MD5Encrypt;
import com.hefa.utils.StringUtils;


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
	
	@Autowired
	private StringRedisTemplate redis;
	
	/**
	 * 
	 * <p>合发登录接口</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年5月7日 下午4:32:36
	 */
    public JsonResult<String> login(@RequestBody LoginParam param) {
		JSR303ValidateUtils.validateInputParam(param);
		String username = param.getUsername();
		String password = param.getPassword();
		String md5Password = MD5Encrypt.encryptMD5(password);
		LoginUserInfo loginUser = userMapper.getLoginUser(username, md5Password);
		if (loginUser == null) {
			throw new ApiRequestException(ApiRequestErrorCode.API_REQUEST_ERROR_LOGIN_ERROR, "请输入正确的账号或密码");
		}
		String userInfoJson = JSONObject.toJSONString(loginUser);
		String userToken = null;
		try {
			// userToken加密方式:先用AES加密，然后再用base64编码一次，这样可以去除AES密文中的特殊字符
			userToken = Base64.encodeBase64String(AesUtils.encrypt(userInfoJson, ClientConstants.DEFAULT_ASE_KEY).getBytes());
			String userCode = loginUser.getUserCode();
			// 客户端用户地址
			String currentIpAddress = param.getIpAddress();
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
			throw new ApiRequestException(ApiRequestErrorCode.API_REQUEST_ERROR_LOGIN_ERROR, "请重试");
		}
		//System.out.println("用户token:" + userToken);
		return JsonResult.successJsonResult(userToken);
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

