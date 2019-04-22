package com.hefa.user.pojo;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlatformRolePermission implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 角色id
     *
     * @mbg.generated
     */
    private Long roleId;

    /**
     * 权限id
     *
     * @mbg.generated
     */
    private Long permissionId;

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
     * 返回值对应的表列名 platform_role_permission.id
     *
     * @return 返回值对应 platform_role_permission.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键<br/>
     * platform_role_permission.id
     *
     * @param id 值对应 platform_role_permission.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 角色id<br/>
     * 返回值对应的表列名 platform_role_permission.role_id
     *
     * @return 返回值对应 platform_role_permission.role_id
     *
     * @mbg.generated
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 角色id<br/>
     * platform_role_permission.role_id
     *
     * @param roleId 值对应 platform_role_permission.role_id
     *
     * @mbg.generated
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 权限id<br/>
     * 返回值对应的表列名 platform_role_permission.permission_id
     *
     * @return 返回值对应 platform_role_permission.permission_id
     *
     * @mbg.generated
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * 权限id<br/>
     * platform_role_permission.permission_id
     *
     * @param permissionId 值对应 platform_role_permission.permission_id
     *
     * @mbg.generated
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * <br/>
     * 返回值对应的表列名 platform_role_permission.create_time
     *
     * @return 返回值对应 platform_role_permission.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * <br/>
     * platform_role_permission.create_time
     *
     * @param createTime 值对应 platform_role_permission.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 创建人<br/>
     * 返回值对应的表列名 platform_role_permission.creator
     *
     * @return 返回值对应 platform_role_permission.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人<br/>
     * platform_role_permission.creator
     *
     * @param creator 值对应 platform_role_permission.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 最后修改时间<br/>
     * 返回值对应的表列名 platform_role_permission.last_modify_time
     *
     * @return 返回值对应 platform_role_permission.last_modify_time
     *
     * @mbg.generated
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 最后修改时间<br/>
     * platform_role_permission.last_modify_time
     *
     * @param lastModifyTime 值对应 platform_role_permission.last_modify_time
     *
     * @mbg.generated
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    /**
     * 修改人<br/>
     * 返回值对应的表列名 platform_role_permission.modifier
     *
     * @return 返回值对应 platform_role_permission.modifier
     *
     * @mbg.generated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人<br/>
     * platform_role_permission.modifier
     *
     * @param modifier 值对应 platform_role_permission.modifier
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
        PlatformRolePermission other = (PlatformRolePermission) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getPermissionId() == null ? other.getPermissionId() == null : this.getPermissionId().equals(other.getPermissionId()))
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
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getPermissionId() == null) ? 0 : getPermissionId().hashCode());
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
        sb.append(", roleId=").append(roleId);
        sb.append(", permissionId=").append(permissionId);
        sb.append(", createTime=").append(createTime);
        sb.append(", creator=").append(creator);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append(", modifier=").append(modifier);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}