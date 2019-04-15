/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月25日 上午11:23:02
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.bo;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年10月25日 上午11:23:02
 */
@Data
public class EnterpriseAuthParam {

    @NotBlank(message = "客户编码不允许为空")
    private String clientUserCode;
    @NotBlank(message = "本人姓名不允许为空")
    private String clientUserName;
    @NotBlank(message = "公司名称不允许为空")
    private String companyName;
    @NotBlank(message = "信用代码不允许为空")
    private String creditCode;
    @NotBlank(message = "公司电话不允许为空")
    private String companyTel;
    @NotBlank(message = "省代码不允许为空")
    private String proviceCode;
    @NotBlank(message = "请选择省份")
    private String proviceName;
    @NotBlank(message = "市代码不允许为空")
    private String cityCode;
    @NotBlank(message = "请选择市不允许为空")
    private String cityName;
    private String areaCode;
    private String areaName;
    @NotBlank(message = "详细地址不允许为空")
    private String detailAddress;
    @NotEmpty(message = "请上传营业执照")
    private List<TradingCertificate> tradingCertificates;
    
}

