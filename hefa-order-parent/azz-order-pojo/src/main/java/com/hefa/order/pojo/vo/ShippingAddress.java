/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月13日 下午2:59:19
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.vo;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年11月13日 下午2:59:19
 */
@Data
public class ShippingAddress {
	
	private String shippingAddressCode;
	
	private String receiverName;
	
	private String userCode;
	
	private String receiverPhoneNumber;
	
    private String provinceCode;

    private String provinceName;

    private String cityCode;

    private String cityName;

    private String areaCode;

    private String areaName;

    private String detailAddress;
	
	private Integer isDefault;
	
	private String addressAlias;

}

