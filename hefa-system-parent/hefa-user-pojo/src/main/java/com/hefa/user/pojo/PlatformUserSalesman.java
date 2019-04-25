package com.hefa.user.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlatformUserSalesman implements Serializable {
    /**
     * 主键id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 平台端用户编码
     *
     * @mbg.generated
     */
    private String platformUserCode;

    /**
     * 业务员编码（推荐人）
     *
     * @mbg.generated
     */
    private String salesmanCode;
    
    private Integer invitedClientUserCount;

    /**
     * 状态 0无效   1有效
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
     * 主键id<br/>
     * 返回值对应的表列名 platform_user_salesman.id
     *
     * @return 返回值对应 platform_user_salesman.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id<br/>
     * platform_user_salesman.id
     *
     * @param id 值对应 platform_user_salesman.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 平台端用户编码<br/>
     * 返回值对应的表列名 platform_user_salesman.platform_user_code
     *
     * @return 返回值对应 platform_user_salesman.platform_user_code
     *
     * @mbg.generated
     */
    public String getPlatformUserCode() {
        return platformUserCode;
    }

    /**
     * 平台端用户编码<br/>
     * platform_user_salesman.platform_user_code
     *
     * @param platformUserCode 值对应 platform_user_salesman.platform_user_code
     *
     * @mbg.generated
     */
    public void setPlatformUserCode(String platformUserCode) {
        this.platformUserCode = platformUserCode == null ? null : platformUserCode.trim();
    }

    /**
     * 业务员编码（推荐人）<br/>
     * 返回值对应的表列名 platform_user_salesman.salesman_code
     *
     * @return 返回值对应 platform_user_salesman.salesman_code
     *
     * @mbg.generated
     */
    public String getSalesmanCode() {
        return salesmanCode;
    }

    /**
     * 业务员编码（推荐人）<br/>
     * platform_user_salesman.salesman_code
     *
     * @param salesmanCode 值对应 platform_user_salesman.salesman_code
     *
     * @mbg.generated
     */
    public void setSalesmanCode(String salesmanCode) {
        this.salesmanCode = salesmanCode == null ? null : salesmanCode.trim();
    }

    /**
     * 状态 0无效   1有效<br/>
     * 返回值对应的表列名 platform_user_salesman.status
     *
     * @return 返回值对应 platform_user_salesman.status
     *
     * @mbg.generated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 状态 0无效   1有效<br/>
     * platform_user_salesman.status
     *
     * @param status 值对应 platform_user_salesman.status
     *
     * @mbg.generated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 创建人<br/>
     * 返回值对应的表列名 platform_user_salesman.creator
     *
     * @return 返回值对应 platform_user_salesman.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人<br/>
     * platform_user_salesman.creator
     *
     * @param creator 值对应 platform_user_salesman.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 创建时间<br/>
     * 返回值对应的表列名 platform_user_salesman.create_time
     *
     * @return 返回值对应 platform_user_salesman.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间<br/>
     * platform_user_salesman.create_time
     *
     * @param createTime 值对应 platform_user_salesman.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改人<br/>
     * 返回值对应的表列名 platform_user_salesman.modifier
     *
     * @return 返回值对应 platform_user_salesman.modifier
     *
     * @mbg.generated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人<br/>
     * platform_user_salesman.modifier
     *
     * @param modifier 值对应 platform_user_salesman.modifier
     *
     * @mbg.generated
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 最后修改时间<br/>
     * 返回值对应的表列名 platform_user_salesman.modify_time
     *
     * @return 返回值对应 platform_user_salesman.modify_time
     *
     * @mbg.generated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 最后修改时间<br/>
     * platform_user_salesman.modify_time
     *
     * @param modifyTime 值对应 platform_user_salesman.modify_time
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
        PlatformUserSalesman other = (PlatformUserSalesman) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlatformUserCode() == null ? other.getPlatformUserCode() == null : this.getPlatformUserCode().equals(other.getPlatformUserCode()))
            && (this.getSalesmanCode() == null ? other.getSalesmanCode() == null : this.getSalesmanCode().equals(other.getSalesmanCode()))
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
        result = prime * result + ((getPlatformUserCode() == null) ? 0 : getPlatformUserCode().hashCode());
        result = prime * result + ((getSalesmanCode() == null) ? 0 : getSalesmanCode().hashCode());
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
        sb.append(", platformUserCode=").append(platformUserCode);
        sb.append(", salesmanCode=").append(salesmanCode);
        sb.append(", status=").append(status);
        sb.append(", creator=").append(creator);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public Integer getInvitedClientUserCount() {
		return invitedClientUserCount;
	}

	public void setInvitedClientUserCount(Integer invitedClientUserCount) {
		this.invitedClientUserCount = invitedClientUserCount;
	}
}