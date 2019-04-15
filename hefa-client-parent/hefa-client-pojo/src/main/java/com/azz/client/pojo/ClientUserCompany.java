package com.azz.client.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientUserCompany implements Serializable {
    /**
     * id
     *
     * @mbg.generated
     */
    private Long id;
    
    private String companyCode;
    
    private Integer status;

    /**
     * 客户编码
     *
     * @mbg.generated
     */
    private String clientUserCode;

    /**
     * 企业名称
     *
     * @mbg.generated
     */
    private String companyName;

    /**
     * 公司信用代码
     *
     * @mbg.generated
     */
    private String creditCode;

    /**
     * 公司电话
     *
     * @mbg.generated
     */
    private String companyTel;

    /**
     * 第一张公司营业执照名称
     *
     * @mbg.generated
     */
    private String tradingCertificateFirstFileName;

    /**
     * 第一张公司营业执照url
     *
     * @mbg.generated
     */
    private String tradingCertificateFirstFileUrl;

    /**
     * 第二张公司营业执照名称
     *
     * @mbg.generated
     */
    private String tradingCertificateSecondFileName;

    /**
     * 第二张公司营业执照url
     *
     * @mbg.generated
     */
    private String tradingCertificateSecondFileUrl;

    /**
     * 第三张公司营业执照名称
     *
     * @mbg.generated
     */
    private String tradingCertificateThirdFileName;

    /**
     * 第三张公司营业执照url
     *
     * @mbg.generated
     */
    private String tradingCertificateThirdFileUrl;

    /**
     * 注册时间
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 创建人
     *
     * @mbg.generated
     */
    private String creator;

    /**
     * 最后修改时间
     *
     * @mbg.generated
     */
    private Date lastModifyTime;

    /**
     * 修改人
     *
     * @mbg.generated
     */
    private String modifier;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * id<br/>
     * 返回值对应的表列名 client_user_company.id
     *
     * @return 返回值对应 client_user_company.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * id<br/>
     * client_user_company.id
     *
     * @param id 值对应 client_user_company.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    
    /**
     * 客户编码<br/>
     * 返回值对应的表列名 client_user_company.client_user_code
     *
     * @return 返回值对应 client_user_company.client_user_code
     *
     * @mbg.generated
     */
    public String getClientUserCode() {
        return clientUserCode;
    }

    /**
     * 客户编码<br/>
     * client_user_company.client_user_code
     *
     * @param clientUserCode 值对应 client_user_company.client_user_code
     *
     * @mbg.generated
     */
    public void setClientUserCode(String clientUserCode) {
        this.clientUserCode = clientUserCode == null ? null : clientUserCode.trim();
    }

    /**
     * 企业名称<br/>
     * 返回值对应的表列名 client_user_company.company_name
     *
     * @return 返回值对应 client_user_company.company_name
     *
     * @mbg.generated
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 企业名称<br/>
     * client_user_company.company_name
     *
     * @param companyName 值对应 client_user_company.company_name
     *
     * @mbg.generated
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 公司信用代码<br/>
     * 返回值对应的表列名 client_user_company.credit_code
     *
     * @return 返回值对应 client_user_company.credit_code
     *
     * @mbg.generated
     */
    public String getCreditCode() {
        return creditCode;
    }

    /**
     * 公司信用代码<br/>
     * client_user_company.credit_code
     *
     * @param creditCode 值对应 client_user_company.credit_code
     *
     * @mbg.generated
     */
    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode == null ? null : creditCode.trim();
    }

    /**
     * 公司电话<br/>
     * 返回值对应的表列名 client_user_company.company_tel
     *
     * @return 返回值对应 client_user_company.company_tel
     *
     * @mbg.generated
     */
    public String getCompanyTel() {
        return companyTel;
    }

    /**
     * 公司电话<br/>
     * client_user_company.company_tel
     *
     * @param companyTel 值对应 client_user_company.company_tel
     *
     * @mbg.generated
     */
    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel == null ? null : companyTel.trim();
    }

    /**
     * 第一张公司营业执照名称<br/>
     * 返回值对应的表列名 client_user_company.trading_certificate_first_file_name
     *
     * @return 返回值对应 client_user_company.trading_certificate_first_file_name
     *
     * @mbg.generated
     */
    public String getTradingCertificateFirstFileName() {
        return tradingCertificateFirstFileName;
    }

    /**
     * 第一张公司营业执照名称<br/>
     * client_user_company.trading_certificate_first_file_name
     *
     * @param tradingCertificateFirstFileName 值对应 client_user_company.trading_certificate_first_file_name
     *
     * @mbg.generated
     */
    public void setTradingCertificateFirstFileName(String tradingCertificateFirstFileName) {
        this.tradingCertificateFirstFileName = tradingCertificateFirstFileName == null ? null : tradingCertificateFirstFileName.trim();
    }

    /**
     * 第一张公司营业执照url<br/>
     * 返回值对应的表列名 client_user_company.trading_certificate_first_file_url
     *
     * @return 返回值对应 client_user_company.trading_certificate_first_file_url
     *
     * @mbg.generated
     */
    public String getTradingCertificateFirstFileUrl() {
        return tradingCertificateFirstFileUrl;
    }

    /**
     * 第一张公司营业执照url<br/>
     * client_user_company.trading_certificate_first_file_url
     *
     * @param tradingCertificateFirstFileUrl 值对应 client_user_company.trading_certificate_first_file_url
     *
     * @mbg.generated
     */
    public void setTradingCertificateFirstFileUrl(String tradingCertificateFirstFileUrl) {
        this.tradingCertificateFirstFileUrl = tradingCertificateFirstFileUrl == null ? null : tradingCertificateFirstFileUrl.trim();
    }

    /**
     * 第二张公司营业执照名称<br/>
     * 返回值对应的表列名 client_user_company.trading_certificate_second_file_name
     *
     * @return 返回值对应 client_user_company.trading_certificate_second_file_name
     *
     * @mbg.generated
     */
    public String getTradingCertificateSecondFileName() {
        return tradingCertificateSecondFileName;
    }

    /**
     * 第二张公司营业执照名称<br/>
     * client_user_company.trading_certificate_second_file_name
     *
     * @param tradingCertificateSecondFileName 值对应 client_user_company.trading_certificate_second_file_name
     *
     * @mbg.generated
     */
    public void setTradingCertificateSecondFileName(String tradingCertificateSecondFileName) {
        this.tradingCertificateSecondFileName = tradingCertificateSecondFileName == null ? null : tradingCertificateSecondFileName.trim();
    }

    /**
     * 第二张公司营业执照url<br/>
     * 返回值对应的表列名 client_user_company.trading_certificate_second_file_url
     *
     * @return 返回值对应 client_user_company.trading_certificate_second_file_url
     *
     * @mbg.generated
     */
    public String getTradingCertificateSecondFileUrl() {
        return tradingCertificateSecondFileUrl;
    }

    /**
     * 第二张公司营业执照url<br/>
     * client_user_company.trading_certificate_second_file_url
     *
     * @param tradingCertificateSecondFileUrl 值对应 client_user_company.trading_certificate_second_file_url
     *
     * @mbg.generated
     */
    public void setTradingCertificateSecondFileUrl(String tradingCertificateSecondFileUrl) {
        this.tradingCertificateSecondFileUrl = tradingCertificateSecondFileUrl == null ? null : tradingCertificateSecondFileUrl.trim();
    }

    /**
     * 第三张公司营业执照名称<br/>
     * 返回值对应的表列名 client_user_company.trading_certificate_third_file_name
     *
     * @return 返回值对应 client_user_company.trading_certificate_third_file_name
     *
     * @mbg.generated
     */
    public String getTradingCertificateThirdFileName() {
        return tradingCertificateThirdFileName;
    }

    /**
     * 第三张公司营业执照名称<br/>
     * client_user_company.trading_certificate_third_file_name
     *
     * @param tradingCertificateThirdFileName 值对应 client_user_company.trading_certificate_third_file_name
     *
     * @mbg.generated
     */
    public void setTradingCertificateThirdFileName(String tradingCertificateThirdFileName) {
        this.tradingCertificateThirdFileName = tradingCertificateThirdFileName == null ? null : tradingCertificateThirdFileName.trim();
    }

    /**
     * 第三张公司营业执照url<br/>
     * 返回值对应的表列名 client_user_company.trading_certificate_third_file_url
     *
     * @return 返回值对应 client_user_company.trading_certificate_third_file_url
     *
     * @mbg.generated
     */
    public String getTradingCertificateThirdFileUrl() {
        return tradingCertificateThirdFileUrl;
    }

    /**
     * 第三张公司营业执照url<br/>
     * client_user_company.trading_certificate_third_file_url
     *
     * @param tradingCertificateThirdFileUrl 值对应 client_user_company.trading_certificate_third_file_url
     *
     * @mbg.generated
     */
    public void setTradingCertificateThirdFileUrl(String tradingCertificateThirdFileUrl) {
        this.tradingCertificateThirdFileUrl = tradingCertificateThirdFileUrl == null ? null : tradingCertificateThirdFileUrl.trim();
    }

    /**
     * 注册时间<br/>
     * 返回值对应的表列名 client_user_company.create_time
     *
     * @return 返回值对应 client_user_company.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 注册时间<br/>
     * client_user_company.create_time
     *
     * @param createTime 值对应 client_user_company.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 创建人<br/>
     * 返回值对应的表列名 client_user_company.creator
     *
     * @return 返回值对应 client_user_company.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人<br/>
     * client_user_company.creator
     *
     * @param creator 值对应 client_user_company.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 最后修改时间<br/>
     * 返回值对应的表列名 client_user_company.last_modify_time
     *
     * @return 返回值对应 client_user_company.last_modify_time
     *
     * @mbg.generated
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 最后修改时间<br/>
     * client_user_company.last_modify_time
     *
     * @param lastModifyTime 值对应 client_user_company.last_modify_time
     *
     * @mbg.generated
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    /**
     * 修改人<br/>
     * 返回值对应的表列名 client_user_company.modifier
     *
     * @return 返回值对应 client_user_company.modifier
     *
     * @mbg.generated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人<br/>
     * client_user_company.modifier
     *
     * @param modifier 值对应 client_user_company.modifier
     *
     * @mbg.generated
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 备注<br/>
     * 返回值对应的表列名 client_user_company.remark
     *
     * @return 返回值对应 client_user_company.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注<br/>
     * client_user_company.remark
     *
     * @param remark 值对应 client_user_company.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    
    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
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
        ClientUserCompany other = (ClientUserCompany) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompanyCode() == null ? other.getCompanyCode() == null : this.getCompanyCode().equals(other.getCompanyCode()))
            && (this.getClientUserCode() == null ? other.getClientUserCode() == null : this.getClientUserCode().equals(other.getClientUserCode()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getCreditCode() == null ? other.getCreditCode() == null : this.getCreditCode().equals(other.getCreditCode()))
            && (this.getCompanyTel() == null ? other.getCompanyTel() == null : this.getCompanyTel().equals(other.getCompanyTel()))
            && (this.getTradingCertificateFirstFileName() == null ? other.getTradingCertificateFirstFileName() == null : this.getTradingCertificateFirstFileName().equals(other.getTradingCertificateFirstFileName()))
            && (this.getTradingCertificateFirstFileUrl() == null ? other.getTradingCertificateFirstFileUrl() == null : this.getTradingCertificateFirstFileUrl().equals(other.getTradingCertificateFirstFileUrl()))
            && (this.getTradingCertificateSecondFileName() == null ? other.getTradingCertificateSecondFileName() == null : this.getTradingCertificateSecondFileName().equals(other.getTradingCertificateSecondFileName()))
            && (this.getTradingCertificateSecondFileUrl() == null ? other.getTradingCertificateSecondFileUrl() == null : this.getTradingCertificateSecondFileUrl().equals(other.getTradingCertificateSecondFileUrl()))
            && (this.getTradingCertificateThirdFileName() == null ? other.getTradingCertificateThirdFileName() == null : this.getTradingCertificateThirdFileName().equals(other.getTradingCertificateThirdFileName()))
            && (this.getTradingCertificateThirdFileUrl() == null ? other.getTradingCertificateThirdFileUrl() == null : this.getTradingCertificateThirdFileUrl().equals(other.getTradingCertificateThirdFileUrl()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompanyCode() == null) ? 0 : getCompanyCode().hashCode());
        result = prime * result + ((getClientUserCode() == null) ? 0 : getClientUserCode().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getCreditCode() == null) ? 0 : getCreditCode().hashCode());
        result = prime * result + ((getCompanyTel() == null) ? 0 : getCompanyTel().hashCode());
        result = prime * result + ((getTradingCertificateFirstFileName() == null) ? 0 : getTradingCertificateFirstFileName().hashCode());
        result = prime * result + ((getTradingCertificateFirstFileUrl() == null) ? 0 : getTradingCertificateFirstFileUrl().hashCode());
        result = prime * result + ((getTradingCertificateSecondFileName() == null) ? 0 : getTradingCertificateSecondFileName().hashCode());
        result = prime * result + ((getTradingCertificateSecondFileUrl() == null) ? 0 : getTradingCertificateSecondFileUrl().hashCode());
        result = prime * result + ((getTradingCertificateThirdFileName() == null) ? 0 : getTradingCertificateThirdFileName().hashCode());
        result = prime * result + ((getTradingCertificateThirdFileUrl() == null) ? 0 : getTradingCertificateThirdFileUrl().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getLastModifyTime() == null) ? 0 : getLastModifyTime().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", companyCode=").append(companyCode);
        sb.append(", clientUserCode=").append(clientUserCode);
        sb.append(", companyName=").append(companyName);
        sb.append(", creditCode=").append(creditCode);
        sb.append(", companyTel=").append(companyTel);
        sb.append(", tradingCertificateFirstFileName=").append(tradingCertificateFirstFileName);
        sb.append(", tradingCertificateFirstFileUrl=").append(tradingCertificateFirstFileUrl);
        sb.append(", tradingCertificateSecondFileName=").append(tradingCertificateSecondFileName);
        sb.append(", tradingCertificateSecondFileUrl=").append(tradingCertificateSecondFileUrl);
        sb.append(", tradingCertificateThirdFileName=").append(tradingCertificateThirdFileName);
        sb.append(", tradingCertificateThirdFileUrl=").append(tradingCertificateThirdFileUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", creator=").append(creator);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append(", modifier=").append(modifier);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}