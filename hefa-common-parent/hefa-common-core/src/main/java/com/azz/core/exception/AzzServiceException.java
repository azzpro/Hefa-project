package com.azz.core.exception;



/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年10月13日 上午11:14:23
 */
public class AzzServiceException extends Exception{

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 错误码
	 */
	private String errorCode;
	/**
	 * 错误描述信息
	 */
	private String errorMessage;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public AzzServiceException() {
		super();
	}
	public AzzServiceException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

}
