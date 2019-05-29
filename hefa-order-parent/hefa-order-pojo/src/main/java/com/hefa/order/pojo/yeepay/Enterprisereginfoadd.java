package com.hefa.order.pojo.yeepay;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author THINK
 * 子商户入网参数【企业】
 */
public class Enterprisereginfoadd implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5766525263314272861L;
	private Long id;
	private String merchantNo;//子商户编码
	private String merFullName;//商户全称
	private String merShortName;//商户简称
	private String merCertNo;//证件号
	private String merCertType;//证件类型
	private String legalName;//法人姓名
	private String legalIdCard;//法人身份证号
	private String merContactName;//商户联系人姓名
	private String merContactPhone;//商户联系人手机号
	private String merContactEmail;//商户联系人邮箱 【非必传】
	private String merLevelfNo;//商户一级分类 【非必传】
	private String merLevelsNo;//商户二级分类 【非必传】
	private String merProvince;//商户所在省
	private String merCity;//商户所在市
	private String merDistrict;//商户所在区
	private String merAddress;//商户所在详细地址
	private String taxRegistCert;//税务登记证编号 【非必传】
	private String accountLicense;//开户许可证编号
	private String orgCode;//组织机构代码证 【非必传】
	private String orgCodeExpiry;//组织机构代理证有效期 【非必传】
	private String isOrgCodeLong;//组织机构代码证是否长期有效【非必传】
	private String cardNo;//结算银行账户
	private String headBankCode;//开户银行编码
	private String bankCity;//开户市【非必传】
	private String bankCode;//开户支行编码
	private String bankProvince;//开户省【非必传】
	private String productInfo;//开通产品信息【非必传】
	private String requestNo;//入网请求号
	private String parentMerchantNo;//代理商编号
	private String businessFunction;//业务功能【非必传】
	private String merAuthorizeType;//授权类型【非必传】
	private String status;//0 未注册 1已注册
	private String legalFrontPic;//法人正面身份证照
	private String legalBackPic;//法人反面身份证照
	private String openAccountPic;//开户许可照片
	private String businessPic;//4证合一
	private String icpAuthPic;//ICP 授权许可照片
	private String creator;
	private Date createTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public String getMerFullName() {
		return merFullName;
	}
	public void setMerFullName(String merFullName) {
		this.merFullName = merFullName;
	}
	public String getMerShortName() {
		return merShortName;
	}
	public void setMerShortName(String merShortName) {
		this.merShortName = merShortName;
	}
	public String getMerCertNo() {
		return merCertNo;
	}
	public void setMerCertNo(String merCertNo) {
		this.merCertNo = merCertNo;
	}
	public String getMerCertType() {
		return merCertType;
	}
	public void setMerCertType(String merCertType) {
		this.merCertType = merCertType;
	}
	public String getLegalName() {
		return legalName;
	}
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
	public String getLegalIdCard() {
		return legalIdCard;
	}
	public void setLegalIdCard(String legalIdCard) {
		this.legalIdCard = legalIdCard;
	}
	public String getMerContactName() {
		return merContactName;
	}
	public void setMerContactName(String merContactName) {
		this.merContactName = merContactName;
	}
	public String getMerContactPhone() {
		return merContactPhone;
	}
	public void setMerContactPhone(String merContactPhone) {
		this.merContactPhone = merContactPhone;
	}
	public String getMerContactEmail() {
		return merContactEmail;
	}
	public void setMerContactEmail(String merContactEmail) {
		this.merContactEmail = merContactEmail;
	}
	public String getMerLevelfNo() {
		return merLevelfNo;
	}
	public void setMerLevelfNo(String merLevelfNo) {
		this.merLevelfNo = merLevelfNo;
	}
	public String getMerLevelsNo() {
		return merLevelsNo;
	}
	public void setMerLevelsNo(String merLevelsNo) {
		this.merLevelsNo = merLevelsNo;
	}
	public String getMerProvince() {
		return merProvince;
	}
	public void setMerProvince(String merProvince) {
		this.merProvince = merProvince;
	}
	public String getMerCity() {
		return merCity;
	}
	public void setMerCity(String merCity) {
		this.merCity = merCity;
	}
	public String getMerDistrict() {
		return merDistrict;
	}
	public void setMerDistrict(String merDistrict) {
		this.merDistrict = merDistrict;
	}
	public String getMerAddress() {
		return merAddress;
	}
	public void setMerAddress(String merAddress) {
		this.merAddress = merAddress;
	}
	public String getTaxRegistCert() {
		return taxRegistCert;
	}
	public void setTaxRegistCert(String taxRegistCert) {
		this.taxRegistCert = taxRegistCert;
	}
	public String getAccountLicense() {
		return accountLicense;
	}
	public void setAccountLicense(String accountLicense) {
		this.accountLicense = accountLicense;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getOrgCodeExpiry() {
		return orgCodeExpiry;
	}
	public void setOrgCodeExpiry(String orgCodeExpiry) {
		this.orgCodeExpiry = orgCodeExpiry;
	}
	public String getIsOrgCodeLong() {
		return isOrgCodeLong;
	}
	public void setIsOrgCodeLong(String isOrgCodeLong) {
		this.isOrgCodeLong = isOrgCodeLong;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getHeadBankCode() {
		return headBankCode;
	}
	public void setHeadBankCode(String headBankCode) {
		this.headBankCode = headBankCode;
	}
	public String getBankCity() {
		return bankCity;
	}
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankProvince() {
		return bankProvince;
	}
	public void setBankProvince(String bankProvince) {
		this.bankProvince = bankProvince;
	}
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	public String getParentMerchantNo() {
		return parentMerchantNo;
	}
	public void setParentMerchantNo(String parentMerchantNo) {
		this.parentMerchantNo = parentMerchantNo;
	}
	public String getBusinessFunction() {
		return businessFunction;
	}
	public void setBusinessFunction(String businessFunction) {
		this.businessFunction = businessFunction;
	}
	public String getMerAuthorizeType() {
		return merAuthorizeType;
	}
	public void setMerAuthorizeType(String merAuthorizeType) {
		this.merAuthorizeType = merAuthorizeType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLegalFrontPic() {
		return legalFrontPic;
	}
	public void setLegalFrontPic(String legalFrontPic) {
		this.legalFrontPic = legalFrontPic;
	}
	public String getLegalBackPic() {
		return legalBackPic;
	}
	public void setLegalBackPic(String legalBackPic) {
		this.legalBackPic = legalBackPic;
	}
	public String getOpenAccountPic() {
		return openAccountPic;
	}
	public void setOpenAccountPic(String openAccountPic) {
		this.openAccountPic = openAccountPic;
	}
	public String getBusinessPic() {
		return businessPic;
	}
	public void setBusinessPic(String businessPic) {
		this.businessPic = businessPic;
	}
	public String getIcpAuthPic() {
		return icpAuthPic;
	}
	public void setIcpAuthPic(String icpAuthPic) {
		this.icpAuthPic = icpAuthPic;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
