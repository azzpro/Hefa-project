/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月15日 下午7:46:22
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.azz.core.common.config;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.azz.core.common.JsonResult;
import com.azz.core.common.errorcode.BaseErrorCode;
import com.azz.core.common.errorcode.SystemErrorCode;
import com.azz.core.exception.BaseException;
import com.azz.core.reconstructed.errorcode.ValidationErrorCode;

import lombok.extern.slf4j.Slf4j;

/**
 * <Pre>
 * 统一异常处理配置
 *    注意：要用到此方法的统一异常捕获的话，需要将启动类放置于com.azz下，异常统一捕获才会生效。
 *    （因为这样才能被springboot扫描到）
 * </Pre>
 * 
 * @version 1.0
 * @author 黄智聪 2018年10月15日 下午7:46:22
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerConfig {

	/**
	 * 
	 * <p>
	 * 处理异常
	 * </p>
	 * 
	 * @param e
	 * @return
	 * @author 黄智聪（13510946256） 2018年8月31日 下午1:56:18
	 * @throws Exception
	 */
	@ExceptionHandler(Exception.class)
	public JsonResult<String> handleException(Exception e) throws Exception {
		JsonResult<String> errorResult = new JsonResult<>();
		int code = 0;
		String detailMessage = "";
		if (e instanceof com.azz.core.exception.BaseException) {
			BaseException baseException = (BaseException) e;
			BaseErrorCode errorCode = baseException.getErrorCode();
			code = errorCode.getCode();
			detailMessage = e.getMessage();
			log.error(detailMessage, e);
		} else if (e instanceof com.azz.core.reconstructed.base.BaseException) {// 重构后的异常捕获
			com.azz.core.reconstructed.base.BaseException baseException = (com.azz.core.reconstructed.base.BaseException) e;
			com.azz.core.reconstructed.base.BaseErrorCode errorCode = baseException.getErrorCode();
			code = errorCode.getCode();
			detailMessage = e.getMessage();
			log.error(detailMessage, e);
		} else if (e instanceof MissingServletRequestParameterException) {// spring缺少请求参数异常
			code = ValidationErrorCode.VALIDATION_ERROR_INVALID_REQUEST_PARAM.getCode();
			detailMessage = ValidationErrorCode.VALIDATION_ERROR_MISSING_REQUEST_PARAM.getMessage() + "["
					+ ((MissingServletRequestParameterException) e).getParameterName() + "]";
			log.error(detailMessage, e);
		} else {// 其他异常均视为系统未知错误
			BaseErrorCode errorCode = SystemErrorCode.SYS_ERROR_UNKNOWN;
			code = errorCode.getCode();
			detailMessage = errorCode.getMessage();
			log.error(detailMessage, e);
		}
		errorResult.setCode(code);
		errorResult.setMsg(detailMessage);
		return errorResult;
	}

}
