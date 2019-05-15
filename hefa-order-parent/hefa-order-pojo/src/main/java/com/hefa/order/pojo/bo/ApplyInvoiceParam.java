/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月26日 上午11:03:30
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.bo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月26日 上午11:03:30
 */
@Data
public class ApplyInvoiceParam {
	// session中带过来。
    private String userCode;

    // 发票类型
    @NotNull(message = "请选择发票类型")
    private Byte invoiceType;
    
    // 发票抬头
    @NotBlank(message = "请填写发票抬头")
    private String invoiceTitle;

    // 纳税识别号
    @NotBlank(message = "请填写纳税号")
    private String taxIdentificationNumber;
    
    // 公司名称
    @NotBlank(message = "请填写公司名称")
    private String companyName;

    // 开票备注
    private String remark;

    // 收货地址
    @NotBlank(message = "请选择发货地址")
    private String shippingAddressCode;
    
    // 订单编号
    @NotBlank(message = "请选择需开票的订单号")
    private String orderCode;
    
    
/* 以下为增值税用到的信息
    private String creditCode;

    private String bank;

    private String bankAccount;

    private String regAddress;

    private String regTelephone;
*/
}

