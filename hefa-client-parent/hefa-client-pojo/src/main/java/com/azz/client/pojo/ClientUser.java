package com.azz.client.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientUser implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Long id;

    private String clientUserCode;
    
    private Integer isEnterpriseAuthenticator;

    /**
     * 客户成员姓名
     *
     * @mbg.generated
     */
    private String clientUserName;

    /**
     * 客户的部门id
     *
     * @mbg.generated
     */
    private Long clientDeptId;

    /**
     * 岗位名称
     *
     * @mbg.generated
     */
    private String postName;

    private String phoneNumber;

    /**
     * 密码
     *
     * @mbg.generated
     */
    private String password;

    /**
     * 盐
     *
     * @mbg.generated
     */
    private String salt;

    /**
     * 客户类型   0个人  1企业
     *
     * @mbg.generated
     */
    private Integer clientType;

    /**
     * 邮箱
     *
     * @mbg.generated
     */
    private String email;

    /**
     * 状态  0无效  1有效 2 禁用
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * 头像路径
     *
     * @mbg.generated
     */
    private String clientAvatarUrl;

    /**
     * 登录错误次数
     *
     * @mbg.generated
     */
    private Integer loginErrorsTimes;

    /**
     * 登录ip地址
     *
     * @mbg.generated
     */
    private String loginIp;

    /**
     * 创建人
     *
     * @mbg.generated
     */
    private String creator;

    private Date createTime;

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
     * 返回值对应的表列名 client_user.id
     *
     * @return 返回值对应 client_user.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键<br/>
     * client_user.id
     *
     * @param id 值对应 client_user.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <br/>
     * 返回值对应的表列名 client_user.client_user_code
     *
     * @return 返回值对应 client_user.client_user_code
     *
     * @mbg.generated
     */
    public String getClientUserCode() {
        return clientUserCode;
    }

    /**
     * <br/>
     * client_user.client_user_code
     *
     * @param clientUserCode 值对应 client_user.client_user_code
     *
     * @mbg.generated
     */
    public void setClientUserCode(String clientUserCode) {
        this.clientUserCode = clientUserCode == null ? null : clientUserCode.trim();
    }

    /**
     * 客户成员姓名<br/>
     * 返回值对应的表列名 client_user.client_user_name
     *
     * @return 返回值对应 client_user.client_user_name
     *
     * @mbg.generated
     */
    public String getClientUserName() {
        return clientUserName;
    }

    /**
     * 客户成员姓名<br/>
     * client_user.client_user_name
     *
     * @param clientUserName 值对应 client_user.client_user_name
     *
     * @mbg.generated
     */
    public void setClientUserName(String clientUserName) {
        this.clientUserName = clientUserName == null ? null : clientUserName.trim();
    }

    /**
     * 客户的部门id<br/>
     * 返回值对应的表列名 client_user.client_dept_id
     *
     * @return 返回值对应 client_user.client_dept_id
     *
     * @mbg.generated
     */
    public Long getClientDeptId() {
        return clientDeptId;
    }

    /**
     * 客户的部门id<br/>
     * client_user.client_dept_id
     *
     * @param clientDeptId 值对应 client_user.client_dept_id
     *
     * @mbg.generated
     */
    public void setClientDeptId(Long clientDeptId) {
        this.clientDeptId = clientDeptId;
    }

    /**
     * 岗位名称<br/>
     * 返回值对应的表列名 client_user.post_name
     *
     * @return 返回值对应 client_user.post_name
     *
     * @mbg.generated
     */
    public String getPostName() {
        return postName;
    }

    /**
     * 岗位名称<br/>
     * client_user.post_name
     *
     * @param postName 值对应 client_user.post_name
     *
     * @mbg.generated
     */
    public void setPostName(String postName) {
        this.postName = postName == null ? null : postName.trim();
    }

    /**
     * <br/>
     * 返回值对应的表列名 client_user.phone_number
     *
     * @return 返回值对应 client_user.phone_number
     *
     * @mbg.generated
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * <br/>
     * client_user.phone_number
     *
     * @param phoneNumber 值对应 client_user.phone_number
     *
     * @mbg.generated
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * 密码<br/>
     * 返回值对应的表列名 client_user.password
     *
     * @return 返回值对应 client_user.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码<br/>
     * client_user.password
     *
     * @param password 值对应 client_user.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 盐<br/>
     * 返回值对应的表列名 client_user.salt
     *
     * @return 返回值对应 client_user.salt
     *
     * @mbg.generated
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 盐<br/>
     * client_user.salt
     *
     * @param salt 值对应 client_user.salt
     *
     * @mbg.generated
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 客户类型   0个人  1企业<br/>
     * 返回值对应的表列名 client_user.client_type
     *
     * @return 返回值对应 client_user.client_type
     *
     * @mbg.generated
     */
    public Integer getClientType() {
        return clientType;
    }

    /**
     * 客户类型   0个人  1企业<br/>
     * client_user.client_type
     *
     * @param clientType 值对应 client_user.client_type
     *
     * @mbg.generated
     */
    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }

    /**
     * 邮箱<br/>
     * 返回值对应的表列名 client_user.email
     *
     * @return 返回值对应 client_user.email
     *
     * @mbg.generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱<br/>
     * client_user.email
     *
     * @param email 值对应 client_user.email
     *
     * @mbg.generated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 状态  0无效  1有效 2 禁用<br/>
     * 返回值对应的表列名 client_user.status
     *
     * @return 返回值对应 client_user.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态  0无效  1有效 2 禁用<br/>
     * client_user.status
     *
     * @param status 值对应 client_user.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 备注<br/>
     * 返回值对应的表列名 client_user.remark
     *
     * @return 返回值对应 client_user.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注<br/>
     * client_user.remark
     *
     * @param remark 值对应 client_user.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 头像路径<br/>
     * 返回值对应的表列名 client_user.client_avatar_url
     *
     * @return 返回值对应 client_user.client_avatar_url
     *
     * @mbg.generated
     */
    public String getClientAvatarUrl() {
        return clientAvatarUrl;
    }

    /**
     * 头像路径<br/>
     * client_user.client_avatar_url
     *
     * @param clientAvatarUrl 值对应 client_user.client_avatar_url
     *
     * @mbg.generated
     */
    public void setClientAvatarUrl(String clientAvatarUrl) {
        this.clientAvatarUrl = clientAvatarUrl == null ? null : clientAvatarUrl.trim();
    }

    /**
     * 登录错误次数<br/>
     * 返回值对应的表列名 client_user.login_errors_times
     *
     * @return 返回值对应 client_user.login_errors_times
     *
     * @mbg.generated
     */
    public Integer getLoginErrorsTimes() {
        return loginErrorsTimes;
    }

    /**
     * 登录错误次数<br/>
     * client_user.login_errors_times
     *
     * @param loginErrorsTimes 值对应 client_user.login_errors_times
     *
     * @mbg.generated
     */
    public void setLoginErrorsTimes(Integer loginErrorsTimes) {
        this.loginErrorsTimes = loginErrorsTimes;
    }

    /**
     * 登录ip地址<br/>
     * 返回值对应的表列名 client_user.login_ip
     *
     * @return 返回值对应 client_user.login_ip
     *
     * @mbg.generated
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 登录ip地址<br/>
     * client_user.login_ip
     *
     * @param loginIp 值对应 client_user.login_ip
     *
     * @mbg.generated
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * 创建人<br/>
     * 返回值对应的表列名 client_user.creator
     *
     * @return 返回值对应 client_user.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人<br/>
     * client_user.creator
     *
     * @param creator 值对应 client_user.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * <br/>
     * 返回值对应的表列名 client_user.create_time
     *
     * @return 返回值对应 client_user.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * <br/>
     * client_user.create_time
     *
     * @param createTime 值对应 client_user.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后修改时间<br/>
     * 返回值对应的表列名 client_user.last_modify_time
     *
     * @return 返回值对应 client_user.last_modify_time
     *
     * @mbg.generated
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 最后修改时间<br/>
     * client_user.last_modify_time
     *
     * @param lastModifyTime 值对应 client_user.last_modify_time
     *
     * @mbg.generated
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    /**
     * 修改人<br/>
     * 返回值对应的表列名 client_user.modifier
     *
     * @return 返回值对应 client_user.modifier
     *
     * @mbg.generated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人<br/>
     * client_user.modifier
     *
     * @param modifier 值对应 client_user.modifier
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
        ClientUser other = (ClientUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClientUserCode() == null ? other.getClientUserCode() == null : this.getClientUserCode().equals(other.getClientUserCode()))
            && (this.getClientUserName() == null ? other.getClientUserName() == null : this.getClientUserName().equals(other.getClientUserName()))
            && (this.getClientDeptId() == null ? other.getClientDeptId() == null : this.getClientDeptId().equals(other.getClientDeptId()))
            && (this.getPostName() == null ? other.getPostName() == null : this.getPostName().equals(other.getPostName()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
            && (this.getClientType() == null ? other.getClientType() == null : this.getClientType().equals(other.getClientType()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getClientAvatarUrl() == null ? other.getClientAvatarUrl() == null : this.getClientAvatarUrl().equals(other.getClientAvatarUrl()))
            && (this.getLoginErrorsTimes() == null ? other.getLoginErrorsTimes() == null : this.getLoginErrorsTimes().equals(other.getLoginErrorsTimes()))
            && (this.getLoginIp() == null ? other.getLoginIp() == null : this.getLoginIp().equals(other.getLoginIp()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getClientUserCode() == null) ? 0 : getClientUserCode().hashCode());
        result = prime * result + ((getClientUserName() == null) ? 0 : getClientUserName().hashCode());
        result = prime * result + ((getClientDeptId() == null) ? 0 : getClientDeptId().hashCode());
        result = prime * result + ((getPostName() == null) ? 0 : getPostName().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getClientType() == null) ? 0 : getClientType().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getClientAvatarUrl() == null) ? 0 : getClientAvatarUrl().hashCode());
        result = prime * result + ((getLoginErrorsTimes() == null) ? 0 : getLoginErrorsTimes().hashCode());
        result = prime * result + ((getLoginIp() == null) ? 0 : getLoginIp().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
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
        sb.append(", clientUserCode=").append(clientUserCode);
        sb.append(", clientUserName=").append(clientUserName);
        sb.append(", clientDeptId=").append(clientDeptId);
        sb.append(", postName=").append(postName);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", password=").append(password);
        sb.append(", salt=").append(salt);
        sb.append(", clientType=").append(clientType);
        sb.append(", email=").append(email);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", clientAvatarUrl=").append(clientAvatarUrl);
        sb.append(", loginErrorsTimes=").append(loginErrorsTimes);
        sb.append(", loginIp=").append(loginIp);
        sb.append(", creator=").append(creator);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append(", modifier=").append(modifier);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public Integer getIsEnterpriseAuthenticator() {
        return isEnterpriseAuthenticator;
    }

    public void setIsEnterpriseAuthenticator(Integer isEnterpriseAuthenticator) {
        this.isEnterpriseAuthenticator = isEnterpriseAuthenticator;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}