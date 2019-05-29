package com.hefa.order.pojo.yeepay;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

/**
 * @author THINK
 * 子商户入网参数【企业】
 */
@Data
public class EnterprisereginfoCopy {
	@NotNull(message = "请上传身份证正面照")
	private YeeModulePic legalFrontPic;
	@NotNull(message = "请上传身份证反面照")
	private YeeModulePic legalBackPic;
	@NotNull(message = "请上传开户许可照")
	private YeeModulePic openAccountPic;
	@NotNull(message = "请上传营业执照")
	private YeeModulePic businessPic;
	@NotNull(message = "请上传ICP授权照")
	private YeeModulePic icpAuthPic;
	@NotBlank(message="商户编码不能为空")
	private String merchantCode;//
	@NotBlank(message="商户全称不能为空")
	private String merFullName;//商户全称
	@NotBlank(message="商户简称不能为空")
	private String merShortName;//商户简称
	@NotBlank(message="证件号不能为空")
	private String merCertNo;//证件号
	@NotBlank(message="证件类型不能为空")
	private String merCertType;//证件类型
	@NotBlank(message="法人姓名不能为空")
	private String legalName;//法人姓名
	@NotBlank(message="法人身份证号不能为空")
	private String legalIdCard;//法人身份证号
	@NotBlank(message="商户联系人姓名不能为空")
	private String merContactName;//商户联系人姓名
	@NotBlank(message="商户联系人手机号不能为空")
	private String merContactPhone;//商户联系人手机号
	private String merContactEmail;//商户联系人邮箱 【非必传】
	private String merLevelfNo;//商户一级分类 【非必传】
	private String merLevelsNo;//商户二级分类 【非必传】
	@NotBlank(message="商户所在省不能为空")
	private String merProvince;//商户所在省
	@NotBlank(message="商户所在市不能为空")
	private String merCity;//商户所在市
	@NotBlank(message="商户所在区不能为空")
	private String merDistrict;//商户所在区
	@NotBlank(message="商户所在详细地址不能为空")
	private String merAddress;//商户所在详细地址
	private String taxRegistCert;//税务登记证编号 【非必传】
	@NotBlank(message="开户许可证编号不能为空")
	private String accountLicense;//开户许可证编号
	private String orgCode;//组织机构代码证 【非必传】
	private String orgCodeExpiry;//组织机构代理证有效期 【非必传】
	private String isOrgCodeLong;//组织机构代码证是否长期有效【非必传】
	@NotBlank(message="结算银行账户不能为空")
	private String cardNo;//结算银行账户
	@NotBlank(message="开户银行编码不能为空")
	private String headBankCode;//开户银行编码
	private String bankCity;//开户市【非必传】
	private String bankProvince;//开户省【非必传】
	private String bankCode;
	private String requestNo;//入网请求号
	private String parentMerchantNo;//代理商编号
	private String businessFunction;//业务功能【非必传】
	private String merAuthorizeType;//授权类型【非必传】
	private String creator;
}
