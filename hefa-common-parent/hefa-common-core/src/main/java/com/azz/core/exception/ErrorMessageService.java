package com.azz.core.exception;


/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年10月13日 上午11:14:04
 */
public interface ErrorMessageService {
	
	
	/**
	 * <p>TODO</p>
	 * @param errorCode
	 * @return
	 * @author 刘建麟  2018年10月13日 上午11:14:07
	 */
	String selectByErrorCode(String errorCode); 
}
