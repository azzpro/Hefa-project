package com.hefa.user.pojo;

import java.io.Serializable;
import java.util.Date;

public class PlatformPermission implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 权限编号
     *
     * @mbg.generated
     */
    private String permissionCode;

    /**
     * 权限名称
     *
     * @mbg.generated
     */
    private String permissionName;

    /**
     * 上级权限编号
     *
     * @mbg.generated
     */
    private String parentPermissionCode;

    /**
     * 排序
     *
     * @mbg.generated
     */
    private Integer sort;

    /**
     * 等级
     *
     * @mbg.generated
     */
    private Integer level;

    /**
     * 权限对应的url
     *
     * @mbg.generated
     */
    private String pageUrl;
    
    /**
     * 图标
     *
     * @mbg.generated
     */
    private String icon;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * 状态  0无效  1有效
     *
     * @mbg.generated
     */
    private Integer status;

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

    private static final long serialVersionUID = 1L;

    /**
     * 主键<br/>
     * 返回值对应的表列名 platform_permission.id
     *
     * @return 返回值对应 platform_permission.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键<br/>
     * platform_permission.id
     *
     * @param id 值对应 platform_permission.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 权限编号<br/>
     * 返回值对应的表列名 platform_permission.permission_code
     *
     * @return 返回值对应 platform_permission.permission_code
     *
     * @mbg.generated
     */
    public String getPermissionCode() {
        return permissionCode;
    }

    /**
     * 权限编号<br/>
     * platform_permission.permission_code
     *
     * @param permissionCode 值对应 platform_permission.permission_code
     *
     * @mbg.generated
     */
    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    /**
     * 权限名称<br/>
     * 返回值对应的表列名 platform_permission.permission_name
     *
     * @return 返回值对应 platform_permission.permission_name
     *
     * @mbg.generated
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * 权限名称<br/>
     * platform_permission.permission_name
     *
     * @param permissionName 值对应 platform_permission.permission_name
     *
     * @mbg.generated
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    /**
     * 上级权限编号<br/>
     * 返回值对应的表列名 platform_permission.parent_permission_code
     *
     * @return 返回值对应 platform_permission.parent_permission_code
     *
     * @mbg.generated
     */
    public String getParentPermissionCode() {
        return parentPermissionCode;
    }

    /**
     * 上级权限编号<br/>
     * platform_permission.parent_permission_code
     *
     * @param parentPermissionCode 值对应 platform_permission.parent_permission_code
     *
     * @mbg.generated
     */
    public void setParentPermissionCode(String parentPermissionCode) {
        this.parentPermissionCode = parentPermissionCode == null ? null : parentPermissionCode.trim();
    }

    /**
     * 排序<br/>
     * 返回值对应的表列名 platform_permission.sort
     *
     * @return 返回值对应 platform_permission.sort
     *
     * @mbg.generated
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序<br/>
     * platform_permission.sort
     *
     * @param sort 值对应 platform_permission.sort
     *
     * @mbg.generated
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 等级<br/>
     * 返回值对应的表列名 platform_permission.level
     *
     * @return 返回值对应 platform_permission.level
     *
     * @mbg.generated
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 等级<br/>
     * platform_permission.level
     *
     * @param level 值对应 platform_permission.level
     *
     * @mbg.generated
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 权限对应的url<br/>
     * 返回值对应的表列名 platform_permission.page_url
     *
     * @return 返回值对应 platform_permission.page_url
     *
     * @mbg.generated
     */
    public String getPageUrl() {
        return pageUrl;
    }

    /**
     * 权限对应的url<br/>
     * platform_permission.page_url
     *
     * @param pageUrl 值对应 platform_permission.page_url
     *
     * @mbg.generated
     */
    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl == null ? null : pageUrl.trim();
    }

    /**
     * 备注<br/>
     * 返回值对应的表列名 platform_permission.remark
     *
     * @return 返回值对应 platform_permission.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注<br/>
     * platform_permission.remark
     *
     * @param remark 值对应 platform_permission.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 状态  0无效  1有效<br/>
     * 返回值对应的表列名 platform_permission.status
     *
     * @return 返回值对应 platform_permission.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态  0无效  1有效<br/>
     * platform_permission.status
     *
     * @param status 值对应 platform_permission.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * <br/>
     * 返回值对应的表列名 platform_permission.create_time
     *
     * @return 返回值对应 platform_permission.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * <br/>
     * platform_permission.create_time
     *
     * @param createTime 值对应 platform_permission.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 创建人<br/>
     * 返回值对应的表列名 platform_permission.creator
     *
     * @return 返回值对应 platform_permission.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 创建人<br/>
     * platform_permission.creator
     *
     * @param creator 值对应 platform_permission.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 最后修改时间<br/>
     * 返回值对应的表列名 platform_permission.last_modify_time
     *
     * @return 返回值对应 platform_permission.last_modify_time
     *
     * @mbg.generated
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 最后修改时间<br/>
     * platform_permission.last_modify_time
     *
     * @param lastModifyTime 值对应 platform_permission.last_modify_time
     *
     * @mbg.generated
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    /**
     * 修改人<br/>
     * 返回值对应的表列名 platform_permission.modifier
     *
     * @return 返回值对应 platform_permission.modifier
     *
     * @mbg.generated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人<br/>
     * platform_permission.modifier
     *
     * @param modifier 值对应 platform_permission.modifier
     *
     * @mbg.generated
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
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
        PlatformPermission other = (PlatformPermission) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPermissionCode() == null ? other.getPermissionCode() == null : this.getPermissionCode().equals(other.getPermissionCode()))
            && (this.getPermissionName() == null ? other.getPermissionName() == null : this.getPermissionName().equals(other.getPermissionName()))
            && (this.getParentPermissionCode() == null ? other.getParentPermissionCode() == null : this.getParentPermissionCode().equals(other.getParentPermissionCode()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getPageUrl() == null ? other.getPageUrl() == null : this.getPageUrl().equals(other.getPageUrl()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPermissionCode() == null) ? 0 : getPermissionCode().hashCode());
        result = prime * result + ((getPermissionName() == null) ? 0 : getPermissionName().hashCode());
        result = prime * result + ((getParentPermissionCode() == null) ? 0 : getParentPermissionCode().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getPageUrl() == null) ? 0 : getPageUrl().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getLastModifyTime() == null) ? 0 : getLastModifyTime().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", permissionCode=").append(permissionCode);
        sb.append(", permissionName=").append(permissionName);
        sb.append(", parentPermissionCode=").append(parentPermissionCode);
        sb.append(", sort=").append(sort);
        sb.append(", level=").append(level);
        sb.append(", pageUrl=").append(pageUrl);
        sb.append(", icon=").append(icon);
        sb.append(", remark=").append(remark);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", creator=").append(creator);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append(", modifier=").append(modifier);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}