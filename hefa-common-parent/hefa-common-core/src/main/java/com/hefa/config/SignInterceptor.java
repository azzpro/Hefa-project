/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月15日 下午3:13:54
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.config;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hefa.common.errorcode.ApiSignErrorCode;
import com.hefa.common.exception.ApiSignException;
import com.hefa.utils.ApiSignUtils;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月15日 下午3:13:54
 */
public class SignInterceptor extends HandlerInterceptorAdapter{
	
	// 请求超时时间  20秒
	private static final Long REQUEST_ALLOWED_TIMEOUT = 20000L;
	
	private static final String KEY = "MKtbZiEa8ZO9KfgY";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String timestampStr = request.getParameter("timestamp");
        long timestamp = this.getSignTime(timestampStr);
        // 1.校验请求时间合法性
        this.validateSignTime(timestamp);
        String signature = request.getParameter("signature");
        String param = request.getParameter("param");
        // 2.校验签名合法性
        this.validateSignature(signature, param, timestamp);
		return true;
	}
	
	/**
     * 
     * <p>获取签名时间</p>
     * @param signTime 签名时间字符串
     * @return
     * @author 黄智聪（13510946256）  2018年8月29日 下午2:02:36
     */
    private long getSignTime(String signTime) {
        try {
            return Long.parseLong(signTime);
        } catch (Exception e) {
            throw new ApiSignException(ApiSignErrorCode.API_SIGN_ERROR_INVALID_TIMESTAMP);
        }
    }
    
    /**
     * 
     * <p>校验请求时间合法性</p>
     * @param timestamp
     * @author 黄智聪（13510946256）  2018年8月29日 下午2:00:33
     */
    private void validateSignTime(long timestamp) {
		// 超过设定时间视为请求超时
		if (isRequestTimeout(timestamp)) {
			throw new ApiSignException(ApiSignErrorCode.API_SIGN_ERROR_REQUEST_TIMEOUT);
		}
    }

    /**
     * 
     * <p>是否请求超时</p>
     * @param timestamp
     * @return
     * @author 黄智聪  2019年4月15日 下午3:58:21
     */
	private boolean isRequestTimeout(long timestamp) {
		// 当前时间戳与请求时的时间戳比较，是否超过规定时间
		return BigDecimal.valueOf(System.currentTimeMillis()).subtract(BigDecimal.valueOf(timestamp))
				.compareTo(BigDecimal.valueOf(REQUEST_ALLOWED_TIMEOUT)) > 0;
	}
    
    /**
     * 
     * <p>校验签名合法性</p>
     * @param signature 签名
     * @param param 请求参数
     * @param signTime 请求参数校验时间
     * @author 黄智聪（13510946256）  2018年8月28日 下午2:22:33
     * @param timestamp 
     */
    private void validateSignature(String signature, String param, long timestamp) {
        if (signature == null) {
            throw new ApiSignException(ApiSignErrorCode.API_SIGN_ERROR_INVALID_SIGNATURE);
        }
        if (param == null) {
            throw new ApiSignException(ApiSignErrorCode.API_SIGN_ERROR_MISSING_REQUEST_PARAM);
        }
        TreeMap<String, Object> sortedParams = new TreeMap<>();
        try {
            JSONObject json = JSON.parseObject(param);// 此处若转换异常，则表示请求方未按照要求的json格式传入
            Set<String> keys = json.keySet();
            for (String key : keys) {
                sortedParams.put(key, json.get(key));
            }
        } catch (Exception e) {
            throw new ApiSignException(ApiSignErrorCode.API_SIGN_ERROR_REQUEST_PARAM_TRANSFORM_FAILED);
        }
        // 我方生成的签名
        String selfSign = ApiSignUtils.getSign(sortedParams, timestamp, KEY);
        if (!signature.equals(selfSign)) {
            throw new ApiSignException(ApiSignErrorCode.API_SIGN_ERROR_INVALID_SIGNATURE);
        }
    }
    
    /*
    public static void main(String[] args) {
		System.out.println(RandomStringUtils.random(16,"qwertyuiopasdfghjklzxcvbnm123465789QWERTYUIOPASDFGHJKLZXCVBNM"));
	}
    */
}

