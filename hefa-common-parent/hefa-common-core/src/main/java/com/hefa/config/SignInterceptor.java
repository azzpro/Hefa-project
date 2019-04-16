/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月15日 下午3:13:54
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.config;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hefa.common.constants.ApiRequestConstants;
import com.hefa.common.constants.ApiRequestConstants.RequiredRequestParam;
import com.hefa.common.errorcode.ApiSignErrorCode;
import com.hefa.common.exception.ApiSignException;
import com.hefa.utils.ApiSignUtils;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月15日 下午3:13:54
 */
public class SignInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Map<?, ?> paramsMap = request.getParameterMap();
		// 1.校验请求参数合法性
		this.validateRequestParams(paramsMap);
		String timestampStr = request.getParameter(RequiredRequestParam.TIMESTAMP.getValue());
        long timestamp = this.getSignTime(timestampStr);
        // 2.校验请求时间合法性
        this.validateTimestamp(timestamp);
        String signature = request.getParameter(RequiredRequestParam.SIGNATURE.getValue());
        // 3.校验签名合法性
        this.validateSignature(signature, timestamp, paramsMap);
		return true;
	}

	/**
	 * 
	 * <p>校验接收的请求参数的合法性</p>
	 * @param paramsMap
	 * @author 黄智聪  2019年4月16日 上午11:12:36
	 */
	private void validateRequestParams(Map<?, ?> paramsMap) {
		if(!RequiredRequestParam.containsRequiredRequestParam(paramsMap)) {
			throw new ApiSignException(ApiSignErrorCode.API_SIGN_ERROR_MISSING_REQUEST_PARAM);
		}
	}
	
	/**
     * 
     * <p>获取签名时间</p>
     * @param timestampStr 签名时间字符串
     * @return
     * @author 黄智聪（13510946256）  2018年8月29日 下午2:02:36
     */
    private long getSignTime(String timestampStr) {
    	if(StringUtils.isEmpty(timestampStr)) {
    		 throw new ApiSignException(ApiSignErrorCode.API_SIGN_ERROR_INVALID_TIMESTAMP);
    	}
        try {
            return Long.parseLong(timestampStr);
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
    private void validateTimestamp(long timestamp) {
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
				.compareTo(BigDecimal.valueOf(ApiRequestConstants.API_REQUEST_ALLOWED_TIMEOUT)) > 0;
	}
    
    /**
     * 
     * <p>校验签名合法性</p>
     * @param signature 签名
     * @param paramsMap 请求参数
     * @param signTime 请求参数校验时间
     * @author 黄智聪（13510946256）  2018年8月28日 下午2:22:33
     * @param timestamp 
     */
    private void validateSignature(String signature, long timestamp, Map<?, ?> paramsMap) {
        if (signature == null) {
            throw new ApiSignException(ApiSignErrorCode.API_SIGN_ERROR_MISSING_REQUEST_PARAM);
        }
        // 将paramsMap转换成TreeMap,使paramsMap的key有序排列
        TreeMap<?, ?> sortedParams = new TreeMap<>(paramsMap);	
        // 需要去除signature参数，去生成我方签名
        sortedParams.remove(RequiredRequestParam.SIGNATURE.getValue());
        // 我方生成的签名
        String selfSign = ApiSignUtils.getSign(sortedParams, timestamp, ApiRequestConstants.API_KEY);
        if (!signature.equals(selfSign)) {
            throw new ApiSignException(ApiSignErrorCode.API_SIGN_ERROR_INVALID_SIGNATURE);
        }
    }
    
}

