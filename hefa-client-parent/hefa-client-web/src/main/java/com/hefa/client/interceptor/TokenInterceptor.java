/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年5月8日 下午3:00:47
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.client.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.hefa.common.constants.ClientConstants;
import com.hefa.common.errorcode.ApiRequestErrorCode;
import com.hefa.common.exception.ApiRequestException;
import com.hefa.pojo.vo.LoginUserInfo;
import com.hefa.utils.AesUtils;
import com.hefa.utils.StringUtils;
/**
 * <P>校验用户token，用户校验是否登录失效</P>
 * @version 1.0
 * @author 黄智聪  2019年5月8日 下午3:00:47
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

	private StringRedisTemplate redis;
	
	public TokenInterceptor(StringRedisTemplate redis) {
		super();
		this.redis = redis;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		response.setHeader("access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Allow-Headers", "*");
		String token = request.getParameter(ClientConstants.REQUEST_HEADER_USER_TOKEN_NAME);
		//String token = request.getHeader(ClientConstants.REQUEST_HEADER_USER_TOKEN_NAME);
		if(StringUtils.isBlank(token)) {
			throw new ApiRequestException(ApiRequestErrorCode.API_REQUEST_ERROR_ILLEGAL_REQUEST);
		}
		try {
			String ipAddress = request.getRemoteAddr();
			// 解密顺序：先base64解密，得到AES加密的密文，再AES解密，得到用户信息
			String decodeBase64Str = new String(Base64.decodeBase64(token.getBytes()));
			String userInfoJsonStr = AesUtils.decrypt(decodeBase64Str, ClientConstants.DEFAULT_ASE_KEY);
			LoginUserInfo userInfo = JSONObject.parseObject(userInfoJsonStr, LoginUserInfo.class);
			if(userInfo == null) {
				throw new ApiRequestException(ApiRequestErrorCode.API_REQUEST_ERROR_ILLEGAL_REQUEST);
			}
			String userCode = userInfo.getUserCode();
			String redisUserIpKey = ClientConstants.LOGIN_USER_TOKEN_REDIS_PREFIX + userCode;
			String redisUserIpAddress = redis.opsForValue().get(redisUserIpKey);
			if(StringUtils.isBlank(redisUserIpAddress)) {// 说明未登录或登录失效
				throw new ApiRequestException(ApiRequestErrorCode.API_REQUEST_ERROR_NO_LOGIN);
			}
			if(!redisUserIpAddress.equals(ipAddress)) { // 当前ip与redis中存的ip是否一致，不一致认为异地登录，请求无效
				throw new ApiRequestException(ApiRequestErrorCode.API_REQUEST_ERROR_OTHER_PLACE_LOGIN);
			}
			// 校验当前token与redis的token是否一致
			String redisUserTokenKey = ClientConstants.LOGIN_USER_TOKEN_REDIS_PREFIX + userCode + "_" + ipAddress;
			String userToken = redis.opsForValue().get(redisUserTokenKey);
			if(StringUtils.isBlank(userToken)) {// 说明token已失效
				throw new ApiRequestException(ApiRequestErrorCode.API_REQUEST_ERROR_NO_LOGIN);
			}
			if(!token.equals(userToken)) { // 若当前token与redis的token不一致，说明无效请求
				throw new ApiRequestException(ApiRequestErrorCode.API_REQUEST_ERROR_ILLEGAL_REQUEST);
			}
		} catch (Exception e) {// 解密出错或获取用户信息出错，视为用户登录失败
			e.printStackTrace();
			throw e;
		}
		return true;
	}
	
}

