/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月13日 下午3:36:00
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.pojo.bo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年11月13日 下午3:36:00
 */
@Data
public class EditShippingAddressParam {
	
	@NotBlank(message = "请选择收货地址")
	private String shippingAddressCode;
	
	@NotBlank(message = "请填写收货人姓名")
	private String receiverName;

	@NotBlank(message = "请填写收货人手机号码")
	private String receiverPhoneNumber;

	private String provinceCode;

	@NotBlank(message = "请选择省")
	private String provinceName;

	private String cityCode;

	@NotBlank(message = "请选择市")
	private String cityName;

	private String areaCode;

	private String areaName;

	@NotBlank(message = "请填写详细地址	")
	private String detailAddress;

	@NotNull(message = "缺少请求参数")
	private Integer isDefault;

	private String addressAlias;
	
	private String modifier;

}

