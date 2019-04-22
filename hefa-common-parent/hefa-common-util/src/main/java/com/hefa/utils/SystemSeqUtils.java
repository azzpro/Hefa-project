/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年12月7日 上午5:19:04
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.utils;

import com.alibaba.fastjson.JSONObject;
import com.hefa.common.errorcode.SystemErrorCode;
import com.hefa.common.exception.SystemException;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年12月7日 上午5:19:04
 */
public class SystemSeqUtils {
	
	/**
     * 
     * <p>获取序列号   抛异常则是正常的序列号，否则认为是获取失败</p>
     * @param sequence
     * @return
     * @author 刘建麟  2018年12月7日 上午5:17:04
     */
	public static String getSeq(String sequence) {
		try {
			JSONObject json = JSONObject.parseObject(sequence);
			String code = json.getString("code");
			if(StringUtils.isNotBlank(code)) {
				throw new SystemException(SystemErrorCode.SYS_ERROR_SERVICE_NOT_USE);
			}
		}catch (Exception e) {
			return sequence;
		}
		return sequence;
	}

}

