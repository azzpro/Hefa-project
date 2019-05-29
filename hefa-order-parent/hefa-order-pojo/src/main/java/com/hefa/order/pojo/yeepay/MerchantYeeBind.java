package com.hefa.order.pojo.yeepay;

import java.io.Serializable;

import lombok.Data;

@Data
public class MerchantYeeBind implements Serializable	{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9059175068043006806L;
	private Long id;
	private String merchantId;
	private String yeeMerchantNo;
	private Integer bindStatus; 
}
