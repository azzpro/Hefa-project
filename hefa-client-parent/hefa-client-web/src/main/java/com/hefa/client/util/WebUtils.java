/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月18日 下午3:23:27
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.hefa.client.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.hefa.common.constants.ClientConstants;
import com.hefa.pojo.vo.LoginUserInfo;
import com.hefa.utils.AesUtils;

/**
 * <P>
 * TODO
 * </P>
 * 
 * @version 1.0
 * @author 黄智聪 2018年10月18日 下午3:23:27
 */
public class WebUtils {

	/**
	 * 
	 * <p>获取用户信息</p>
	 * @param request
	 * @return
	 * @throws Exception
	 * @author 黄智聪  2019年5月9日 下午2:44:04
	 */
	public static LoginUserInfo getLoginUser() {
		HttpServletRequest request = getHttpServletRequest();
		//String token = request.getHeader(ClientConstants.REQUEST_HEADER_USER_TOKEN_NAME);
		String token = request.getParameter(ClientConstants.REQUEST_HEADER_USER_TOKEN_NAME);
		// 解密顺序：先base64解密，得到AES加密的密文，再AES解密，得到用户信息
		String decodeBase64Str = new String(Base64.decodeBase64(token.getBytes()));
		String userInfoJsonStr = AesUtils.decrypt(decodeBase64Str, ClientConstants.DEFAULT_ASE_KEY);
		LoginUserInfo userInfo = JSONObject.parseObject(userInfoJsonStr, LoginUserInfo.class);
		return userInfo;
	}
	
	public static HttpServletRequest getHttpServletRequest() {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
	    HttpServletRequest request = servletRequestAttributes.getRequest();
	    return request;
	}

}
