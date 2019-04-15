package com.azz.core.enums;

/**
 * 
 * @Package: com.zmpay.core.enums
 * @ClassName: ResponseApiEnum
 * @Description: TODO 服务接口响应码枚举类 
 * @author sonny
 * @date 2018年4月12日 下午2:13:13
 * @version v1.0
 */
public enum ResponseApiEnum {
	/**
	 * 交易结果未知
	 */
	API_ERROR_CDOE_9997("9997","交易结果未知"),
	/**
	 * 失败
	 */
	API_ERROR_CDOE_9998("9998","失败"),
	/**
	 * 系统异常
	 */
	API_ERROR_CDOE_9999("9999","系统异常"),
	/**
	 * 成功
	 */
	API_ERROR_CDOE_0000("0000","成功"),
	/**
	 * 参数不能为空
	 */
	API_ERROR_CDOE_0001("0001","参数不能为空");
	
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
	private ResponseApiEnum(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
}
