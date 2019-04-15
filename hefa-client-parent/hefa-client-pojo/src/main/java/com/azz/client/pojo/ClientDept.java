package com.azz.client.pojo;

import java.io.Serializable;
import java.util.Date;

public class ClientDept implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Long id;

    private String companyCode;
    /**
     * 部门编码
     *
     * @mbg.generated
     */
    private String deptCode;

    /**
     * 父级编码
     *
     * @mbg.generated
     */
    private String parentCode;

    /**
     * 部门名称
     *
     * @mbg.generated
     */
    private String deptName;

    /**
     * 描述
     *
     * @mbg.generated
     */
    private String description;

    /**
     * 状态   0无效  1有效 2禁用
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

    
    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * 主键<br/>
     * 返回值对应的表列名 client_dept.id
     *
     * @return 返回值对应 client_dept.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键<br/>
     * client_dept.id
     *
     * @param id 值对应 client_dept.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 部门编码<br/>
     * 返回值对应的表列名 client_dept.dept_code
     *
     * @return 返回值对应 client_dept.dept_code
     *
     * @mbg.generated
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 部门编码<br/>
     * client_dept.dept_code
     *
     * @param deptCode 值对应 client_dept.dept_code
     *
     * @mbg.generated
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    /**
     * 父级编码<br/>
     * 返回值对应的表列名 client_dept.parent_code
     *
     * @return 返回值对应 client_dept.parent_code
     *
     * @mbg.generated
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * 父级编码<br/>
     * client_dept.parent_code
     *
     * @param parentCode 值对应 client_dept.parent_code
     *
     * @mbg.generated
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    /**
     * 部门名称<br/>
     * 返回值对应的表列名 client_dept.dept_name
     *
     * @return 返回值对应 client_dept.dept_name
     *
     * @mbg.generated
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 部门名称<br/>
     * client_dept.dept_name
     *
     * @param deptName 值对应 client_dept.dept_name
     *
     * @mbg.generated
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    /**
     * 描述<br/>
     * 返回值对应的表列名 client_dept.description
     *
     * @return 返回值对应 client_dept.description
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述<br/>
     * client_dept.description
     *
     * @param description 值对应 client_dept.description
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 状态   0无效  1有效 2禁用<br/>
     * 返回值对应的表列名 client_dept.status
     *
     * @return 返回值对应 client_dept.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态   0无效  1有效 2禁用<br/>
     * client_dept.status
     *
     * @param status 值对应 client_dept.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * <br/>
     * 返回值对应的表列名 client_dept.create_time
     *
     * @return 返回值对应 client_dept.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * <br/>
     * client_dept.create_time
     *
     * @param createTime 值对应 client_dept.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 创建人<br/>
     * 返回值对应的表列名 client_dept.creator
     *
     * @return 返回值对应 client_dept.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人<br/>
     * client_dept.creator
     *
     * @param creator 值对应 client_dept.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 最后修改时间<br/>
     * 返回值对应的表列名 client_dept.last_modify_time
     *
     * @return 返回值对应 client_dept.last_modify_time
     *
     * @mbg.generated
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 最后修改时间<br/>
     * client_dept.last_modify_time
     *
     * @param lastModifyTime 值对应 client_dept.last_modify_time
     *
     * @mbg.generated
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    /**
     * 修改人<br/>
     * 返回值对应的表列名 client_dept.modifier
     *
     * @return 返回值对应 client_dept.modifier
     *
     * @mbg.generated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人<br/>
     * client_dept.modifier
     *
     * @param modifier 值对应 client_dept.modifier
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
        ClientDept other = (ClientDept) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDeptCode() == null ? other.getDeptCode() == null : this.getDeptCode().equals(other.getDeptCode()))
            && (this.getParentCode() == null ? other.getParentCode() == null : this.getParentCode().equals(other.getParentCode()))
            && (this.getDeptName() == null ? other.getDeptName() == null : this.getDeptName().equals(other.getDeptName()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
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
        result = prime * result + ((getDeptCode() == null) ? 0 : getDeptCode().hashCode());
        result = prime * result + ((getParentCode() == null) ? 0 : getParentCode().hashCode());
        result = prime * result + ((getDeptName() == null) ? 0 : getDeptName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
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
        sb.append(", deptCode=").append(deptCode);
        sb.append(", parentCode=").append(parentCode);
        sb.append(", deptName=").append(deptName);
        sb.append(", description=").append(description);
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