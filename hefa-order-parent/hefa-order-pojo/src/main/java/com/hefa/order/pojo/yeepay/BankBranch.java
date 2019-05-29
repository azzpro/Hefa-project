package com.hefa.order.pojo.yeepay;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class BankBranch {
	@NotBlank(message="开户银行编码不能为空")
	private String headBankCode;
	@NotBlank(message="开户省编码不能为空")
	private String provinceCode;
	@NotBlank(message="开户市编码不能为空")
	private String cityCode;
}
