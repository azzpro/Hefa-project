package com.hefa.order.pojo;

import java.io.Serializable;
import java.util.Date;

public class ClientInvoiceTemplate implements Serializable {
    /**
     * id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 关联的客户的用户编码
     *
     * @mbg.generated
     */
    private String userCode;

    /**
     * 发票类型（0 普通发票 1 增值税专用发票）
     *
     * @mbg.generated
     */
    private Byte invoiceType;

    /**
     * 发票抬头
     *
     * @mbg.generated
     */
    private String invoiceTitle;

    /**
     * 纳税识别号
     *
     * @mbg.generated
     */
    private String taxIdentificationNumber;

    /**
     * 信用代码
     *
     * @mbg.generated
     */
    private String creditCode;

    /**
     * 单位名称
     *
     * @mbg.generated
     */
    private String companyName;

    /**
     * 开户银行
     *
     * @mbg.generated
     */
    private String bank;

    /**
     * 银行账号
     *
     * @mbg.generated
     */
    private String bankAccount;

    /**
     * 注册地址
     *
     * @mbg.generated
     */
    private String regAddress;

    /**
     * 注册电话
     *
     * @mbg.generated
     */
    private String regTelephone;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * 状态（0 无效 1有效）
     *
     * @mbg.generated
     */
    private Byte status;

    /**
     * 创建人
     *
     * @mbg.generated
     */
    private String creator;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 修改人
     *
     * @mbg.generated
     */
    private String modifier;

    /**
     * 最后修改时间
     *
     * @mbg.generated
     */
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    /**
     * id<br/>
     * 返回值对应的表列名 client_invoice_template.id
     *
     * @return 返回值对应 client_invoice_template.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * id<br/>
     * client_invoice_template.id
     *
     * @param id 值对应 client_invoice_template.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 关联的客户的用户编码<br/>
     * 返回值对应的表列名 client_invoice_template.user_code
     *
     * @return 返回值对应 client_invoice_template.user_code
     *
     * @mbg.generated
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * 关联的客户的用户编码<br/>
     * client_invoice_template.user_code
     *
     * @param userCode 值对应 client_invoice_template.user_code
     *
     * @mbg.generated
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    /**
     * 发票类型（0 普通发票 1 增值税专用发票）<br/>
     * 返回值对应的表列名 client_invoice_template.invoice_type
     *
     * @return 返回值对应 client_invoice_template.invoice_type
     *
     * @mbg.generated
     */
    public Byte getInvoiceType() {
        return invoiceType;
    }

    /**
     * 发票类型（0 普通发票 1 增值税专用发票）<br/>
     * client_invoice_template.invoice_type
     *
     * @param invoiceType 值对应 client_invoice_template.invoice_type
     *
     * @mbg.generated
     */
    public void setInvoiceType(Byte invoiceType) {
        this.invoiceType = invoiceType;
    }

    /**
     * 发票抬头<br/>
     * 返回值对应的表列名 client_invoice_template.invoice_title
     *
     * @return 返回值对应 client_invoice_template.invoice_title
     *
     * @mbg.generated
     */
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    /**
     * 发票抬头<br/>
     * client_invoice_template.invoice_title
     *
     * @param invoiceTitle 值对应 client_invoice_template.invoice_title
     *
     * @mbg.generated
     */
    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    /**
     * 纳税识别号<br/>
     * 返回值对应的表列名 client_invoice_template.tax_identification_number
     *
     * @return 返回值对应 client_invoice_template.tax_identification_number
     *
     * @mbg.generated
     */
    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    /**
     * 纳税识别号<br/>
     * client_invoice_template.tax_identification_number
     *
     * @param taxIdentificationNumber 值对应 client_invoice_template.tax_identification_number
     *
     * @mbg.generated
     */
    public void setTaxIdentificationNumber(String taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber == null ? null : taxIdentificationNumber.trim();
    }

    /**
     * 信用代码<br/>
     * 返回值对应的表列名 client_invoice_template.credit_code
     *
     * @return 返回值对应 client_invoice_template.credit_code
     *
     * @mbg.generated
     */
    public String getCreditCode() {
        return creditCode;
    }

    /**
     * 信用代码<br/>
     * client_invoice_template.credit_code
     *
     * @param creditCode 值对应 client_invoice_template.credit_code
     *
     * @mbg.generated
     */
    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode == null ? null : creditCode.trim();
    }

    /**
     * 单位名称<br/>
     * 返回值对应的表列名 client_invoice_template.company_name
     *
     * @return 返回值对应 client_invoice_template.company_name
     *
     * @mbg.generated
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 单位名称<br/>
     * client_invoice_template.company_name
     *
     * @param companyName 值对应 client_invoice_template.company_name
     *
     * @mbg.generated
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 开户银行<br/>
     * 返回值对应的表列名 client_invoice_template.bank
     *
     * @return 返回值对应 client_invoice_template.bank
     *
     * @mbg.generated
     */
    public String getBank() {
        return bank;
    }

    /**
     * 开户银行<br/>
     * client_invoice_template.bank
     *
     * @param bank 值对应 client_invoice_template.bank
     *
     * @mbg.generated
     */
    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    /**
     * 银行账号<br/>
     * 返回值对应的表列名 client_invoice_template.bank_account
     *
     * @return 返回值对应 client_invoice_template.bank_account
     *
     * @mbg.generated
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * 银行账号<br/>
     * client_invoice_template.bank_account
     *
     * @param bankAccount 值对应 client_invoice_template.bank_account
     *
     * @mbg.generated
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    /**
     * 注册地址<br/>
     * 返回值对应的表列名 client_invoice_template.reg_address
     *
     * @return 返回值对应 client_invoice_template.reg_address
     *
     * @mbg.generated
     */
    public String getRegAddress() {
        return regAddress;
    }

    /**
     * 注册地址<br/>
     * client_invoice_template.reg_address
     *
     * @param regAddress 值对应 client_invoice_template.reg_address
     *
     * @mbg.generated
     */
    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress == null ? null : regAddress.trim();
    }

    /**
     * 注册电话<br/>
     * 返回值对应的表列名 client_invoice_template.reg_telephone
     *
     * @return 返回值对应 client_invoice_template.reg_telephone
     *
     * @mbg.generated
     */
    public String getRegTelephone() {
        return regTelephone;
    }

    /**
     * 注册电话<br/>
     * client_invoice_template.reg_telephone
     *
     * @param regTelephone 值对应 client_invoice_template.reg_telephone
     *
     * @mbg.generated
     */
    public void setRegTelephone(String regTelephone) {
        this.regTelephone = regTelephone == null ? null : regTelephone.trim();
    }

    /**
     * 备注<br/>
     * 返回值对应的表列名 client_invoice_template.remark
     *
     * @return 返回值对应 client_invoice_template.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注<br/>
     * client_invoice_template.remark
     *
     * @param remark 值对应 client_invoice_template.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 状态（0 无效 1有效）<br/>
     * 返回值对应的表列名 client_invoice_template.status
     *
     * @return 返回值对应 client_invoice_template.status
     *
     * @mbg.generated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 状态（0 无效 1有效）<br/>
     * client_invoice_template.status
     *
     * @param status 值对应 client_invoice_template.status
     *
     * @mbg.generated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 创建人<br/>
     * 返回值对应的表列名 client_invoice_template.creator
     *
     * @return 返回值对应 client_invoice_template.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人<br/>
     * client_invoice_template.creator
     *
     * @param creator 值对应 client_invoice_template.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 创建时间<br/>
     * 返回值对应的表列名 client_invoice_template.create_time
     *
     * @return 返回值对应 client_invoice_template.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间<br/>
     * client_invoice_template.create_time
     *
     * @param createTime 值对应 client_invoice_template.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改人<br/>
     * 返回值对应的表列名 client_invoice_template.modifier
     *
     * @return 返回值对应 client_invoice_template.modifier
     *
     * @mbg.generated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人<br/>
     * client_invoice_template.modifier
     *
     * @param modifier 值对应 client_invoice_template.modifier
     *
     * @mbg.generated
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 最后修改时间<br/>
     * 返回值对应的表列名 client_invoice_template.modify_time
     *
     * @return 返回值对应 client_invoice_template.modify_time
     *
     * @mbg.generated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 最后修改时间<br/>
     * client_invoice_template.modify_time
     *
     * @param modifyTime 值对应 client_invoice_template.modify_time
     *
     * @mbg.generated
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ClientInvoiceTemplate other = (ClientInvoiceTemplate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserCode() == null ? other.getUserCode() == null : this.getUserCode().equals(other.getUserCode()))
            && (this.getInvoiceType() == null ? other.getInvoiceType() == null : this.getInvoiceType().equals(other.getInvoiceType()))
            && (this.getInvoiceTitle() == null ? other.getInvoiceTitle() == null : this.getInvoiceTitle().equals(other.getInvoiceTitle()))
            && (this.getTaxIdentificationNumber() == null ? other.getTaxIdentificationNumber() == null : this.getTaxIdentificationNumber().equals(other.getTaxIdentificationNumber()))
            && (this.getCreditCode() == null ? other.getCreditCode() == null : this.getCreditCode().equals(other.getCreditCode()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getBank() == null ? other.getBank() == null : this.getBank().equals(other.getBank()))
            && (this.getBankAccount() == null ? other.getBankAccount() == null : this.getBankAccount().equals(other.getBankAccount()))
            && (this.getRegAddress() == null ? other.getRegAddress() == null : this.getRegAddress().equals(other.getRegAddress()))
            && (this.getRegTelephone() == null ? other.getRegTelephone() == null : this.getRegTelephone().equals(other.getRegTelephone()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserCode() == null) ? 0 : getUserCode().hashCode());
        result = prime * result + ((getInvoiceType() == null) ? 0 : getInvoiceType().hashCode());
        result = prime * result + ((getInvoiceTitle() == null) ? 0 : getInvoiceTitle().hashCode());
        result = prime * result + ((getTaxIdentificationNumber() == null) ? 0 : getTaxIdentificationNumber().hashCode());
        result = prime * result + ((getCreditCode() == null) ? 0 : getCreditCode().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getBank() == null) ? 0 : getBank().hashCode());
        result = prime * result + ((getBankAccount() == null) ? 0 : getBankAccount().hashCode());
        result = prime * result + ((getRegAddress() == null) ? 0 : getRegAddress().hashCode());
        result = prime * result + ((getRegTelephone() == null) ? 0 : getRegTelephone().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userCode=").append(userCode);
        sb.append(", invoiceType=").append(invoiceType);
        sb.append(", invoiceTitle=").append(invoiceTitle);
        sb.append(", taxIdentificationNumber=").append(taxIdentificationNumber);
        sb.append(", creditCode=").append(creditCode);
        sb.append(", companyName=").append(companyName);
        sb.append(", bank=").append(bank);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", regAddress=").append(regAddress);
        sb.append(", regTelephone=").append(regTelephone);
        sb.append(", remark=").append(remark);
        sb.append(", status=").append(status);
        sb.append(", creator=").append(creator);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}