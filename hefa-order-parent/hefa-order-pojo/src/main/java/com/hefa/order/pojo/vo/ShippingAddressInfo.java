/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年5月6日 下午1:35:05
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.vo;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年5月6日 下午1:35:05
 */
@Data
public class ShippingAddressInfo {

	private String receiverName;
	
	private String receiverPhoneNumber;
	
    private String provinceName;

    private String cityName;

    private String areaName;

    private String detailAddress;
    
}

