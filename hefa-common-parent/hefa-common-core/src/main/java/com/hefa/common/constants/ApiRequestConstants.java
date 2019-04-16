/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月16日 上午10:00:36
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.common.constants;

import java.util.Map;
import java.util.Set;

import lombok.Getter;

/**
 * <P>API请求常量</P>
 * @version 1.0
 * @author 黄智聪  2019年4月16日 上午10:00:36
 */
public abstract class ApiRequestConstants {

	/**
	 * 双方规定的加签用到的key
	 */
	public static final String API_KEY = "MKtbZiEa8ZO9KfgY";
	
	// TODO
	// 请求超时时间  20秒
	//private static final Long REQUEST_ALLOWED_TIMEOUT = 20000L;
	public static final Long API_REQUEST_ALLOWED_TIMEOUT = 30000000000L;
	
	
	/**
	 * 
	 * <P>必选请求参数</P>
	 * @version 1.0
	 * @author 黄智聪  2019年4月16日 上午10:19:04
	 */
	public enum RequiredRequestParam{
		
		/**
		 * 时间戳
		 */
		TIMESTAMP("timestamp"),
		
		/**
		 * 签名
		 */
		SIGNATURE("signature");
		
		@Getter
		private String value;
		
		RequiredRequestParam(String value) {
			this.value = value;
		}
		
		/**
		 * 
		 * <p>是否包含RequiredRequestParam的属性</p>
		 * @param paramsMap 接收的请求参数
		 * @return
		 * @author 黄智聪  2019年4月16日 上午10:22:04
		 */
		public static boolean containsRequiredRequestParam(Map<?, ?> paramsMap) {
			if(paramsMap == null) {
				return false;
			}
			Set<?> paramkeys = paramsMap.keySet();
			RequiredRequestParam[] values = RequiredRequestParam.values();
			for (RequiredRequestParam param : values) {
				// 若接收的请求参数不包含必选请求参数，说明缺少请求参数
				if(!paramkeys.contains(param.getValue())) {
					return false;
				}
			}
			return true;
		}
		
		
	}
	

}

