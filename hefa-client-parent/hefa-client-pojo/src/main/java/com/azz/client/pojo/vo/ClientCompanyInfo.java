/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月30日 上午2:29:59
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年10月30日 上午2:29:59
 */
@Data
public class ClientCompanyInfo {
    
    private String clientUserCode;
    
    private Integer companyStatus;
    
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    
    private String companyName;
    
    private String companyTel;
    
    private String creditCode;
    
    private String address;
    
    private String tradingCertificateFirstFileName;
    
    private String tradingCertificateFirstFileUrl;
    
    private String tradingCertificateSecondFileName;
    
    private String tradingCertificateSecondFileUrl;
    
    private String tradingCertificateThirdFileName;
    
    private String tradingCertificateThirdFileUrl;

}

