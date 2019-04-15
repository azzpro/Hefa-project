package com.azz.client.pojo;

import java.io.Serializable;
import java.util.Date;

public class ClientCompanyAccount implements Serializable {
    private Long id;

    /**
     * 企业id
     *
     * @mbg.generated
     */
    private Long companyId;

    /**
     * 注册时间
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 修改时间
     *
     * @mbg.generated
     */
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    /**
     * <br/>
     * 返回值对应的表列名 client_company_account.id
     *
     * @return 返回值对应 client_company_account.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * <br/>
     * client_company_account.id
     *
     * @param id 值对应 client_company_account.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 企业id<br/>
     * 返回值对应的表列名 client_company_account.company_id
     *
     * @return 返回值对应 client_company_account.company_id
     *
     * @mbg.generated
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 企业id<br/>
     * client_company_account.company_id
     *
     * @param companyId 值对应 client_company_account.company_id
     *
     * @mbg.generated
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 注册时间<br/>
     * 返回值对应的表列名 client_company_account.create_time
     *
     * @return 返回值对应 client_company_account.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 注册时间<br/>
     * client_company_account.create_time
     *
     * @param createTime 值对应 client_company_account.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间<br/>
     * 返回值对应的表列名 client_company_account.modify_time
     *
     * @return 返回值对应 client_company_account.modify_time
     *
     * @mbg.generated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 修改时间<br/>
     * client_company_account.modify_time
     *
     * @param modifyTime 值对应 client_company_account.modify_time
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
        ClientCompanyAccount other = (ClientCompanyAccount) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
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
        sb.append(", companyId=").append(companyId);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}