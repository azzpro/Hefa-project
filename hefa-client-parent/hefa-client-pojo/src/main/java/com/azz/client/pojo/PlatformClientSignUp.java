package com.azz.client.pojo;


import java.io.Serializable;
import java.util.Date;

public class PlatformClientSignUp implements Serializable {
    private Long id;

    /**
     * 关联客户编码
     *
     * @mbg.generated
     */
    private String clientUserCode;

    /**
     * 姓名
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 性别(0 男 1 女)
     *
     * @mbg.generated
     */
    private Integer gender;

    /**
     * 手机
     *
     * @mbg.generated
     */
    private String mobilePhone;

    /**
     * 邮箱
     *
     * @mbg.generated
     */
    private String email;

    /**
     * qq
     *
     * @mbg.generated
     */
    private String qq;

    /**
     * 公司
     *
     * @mbg.generated
     */
    private String company;

    /**
     * 职位
     *
     * @mbg.generated
     */
    private String post;

    /**
     * 状态 0待处理 1已处理
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * 关联文章id
     *
     * @mbg.generated
     */
    private Long articleId;

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
     * 修改时间
     *
     * @mbg.generated
     */
    private Date modifyTime;

    private String remark;
    
    private static final long serialVersionUID = 1L;

    
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * <br/>
     * 返回值对应的表列名 platform_client_sign_up.id
     *
     * @return 返回值对应 platform_client_sign_up.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * <br/>
     * platform_client_sign_up.id
     *
     * @param id 值对应 platform_client_sign_up.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 关联客户编码<br/>
     * 返回值对应的表列名 platform_client_sign_up.client_user_code
     *
     * @return 返回值对应 platform_client_sign_up.client_user_code
     *
     * @mbg.generated
     */
    public String getClientUserCode() {
        return clientUserCode;
    }

    /**
     * 关联客户编码<br/>
     * platform_client_sign_up.client_user_code
     *
     * @param clientUserCode 值对应 platform_client_sign_up.client_user_code
     *
     * @mbg.generated
     */
    public void setClientUserCode(String clientUserCode) {
        this.clientUserCode = clientUserCode == null ? null : clientUserCode.trim();
    }

    /**
     * 姓名<br/>
     * 返回值对应的表列名 platform_client_sign_up.name
     *
     * @return 返回值对应 platform_client_sign_up.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名<br/>
     * platform_client_sign_up.name
     *
     * @param name 值对应 platform_client_sign_up.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 性别(0 男 1 女)<br/>
     * 返回值对应的表列名 platform_client_sign_up.gender
     *
     * @return 返回值对应 platform_client_sign_up.gender
     *
     * @mbg.generated
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 性别(0 男 1 女)<br/>
     * platform_client_sign_up.gender
     *
     * @param gender 值对应 platform_client_sign_up.gender
     *
     * @mbg.generated
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 手机<br/>
     * 返回值对应的表列名 platform_client_sign_up.mobile_phone
     *
     * @return 返回值对应 platform_client_sign_up.mobile_phone
     *
     * @mbg.generated
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 手机<br/>
     * platform_client_sign_up.mobile_phone
     *
     * @param mobilePhone 值对应 platform_client_sign_up.mobile_phone
     *
     * @mbg.generated
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    /**
     * 邮箱<br/>
     * 返回值对应的表列名 platform_client_sign_up.email
     *
     * @return 返回值对应 platform_client_sign_up.email
     *
     * @mbg.generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱<br/>
     * platform_client_sign_up.email
     *
     * @param email 值对应 platform_client_sign_up.email
     *
     * @mbg.generated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * qq<br/>
     * 返回值对应的表列名 platform_client_sign_up.qq
     *
     * @return 返回值对应 platform_client_sign_up.qq
     *
     * @mbg.generated
     */
    public String getQq() {
        return qq;
    }

    /**
     * qq<br/>
     * platform_client_sign_up.qq
     *
     * @param qq 值对应 platform_client_sign_up.qq
     *
     * @mbg.generated
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * 公司<br/>
     * 返回值对应的表列名 platform_client_sign_up.company
     *
     * @return 返回值对应 platform_client_sign_up.company
     *
     * @mbg.generated
     */
    public String getCompany() {
        return company;
    }

    /**
     * 公司<br/>
     * platform_client_sign_up.company
     *
     * @param company 值对应 platform_client_sign_up.company
     *
     * @mbg.generated
     */
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    /**
     * 职位<br/>
     * 返回值对应的表列名 platform_client_sign_up.post
     *
     * @return 返回值对应 platform_client_sign_up.post
     *
     * @mbg.generated
     */
    public String getPost() {
        return post;
    }

    /**
     * 职位<br/>
     * platform_client_sign_up.post
     *
     * @param post 值对应 platform_client_sign_up.post
     *
     * @mbg.generated
     */
    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }

    /**
     * 状态 0待处理 1已处理<br/>
     * 返回值对应的表列名 platform_client_sign_up.status
     *
     * @return 返回值对应 platform_client_sign_up.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态 0待处理 1已处理<br/>
     * platform_client_sign_up.status
     *
     * @param status 值对应 platform_client_sign_up.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 关联文章id<br/>
     * 返回值对应的表列名 platform_client_sign_up.article_id
     *
     * @return 返回值对应 platform_client_sign_up.article_id
     *
     * @mbg.generated
     */
    public Long getArticleId() {
        return articleId;
    }

    /**
     * 关联文章id<br/>
     * platform_client_sign_up.article_id
     *
     * @param articleId 值对应 platform_client_sign_up.article_id
     *
     * @mbg.generated
     */
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    /**
     * 创建人<br/>
     * 返回值对应的表列名 platform_client_sign_up.creator
     *
     * @return 返回值对应 platform_client_sign_up.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人<br/>
     * platform_client_sign_up.creator
     *
     * @param creator 值对应 platform_client_sign_up.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 创建时间<br/>
     * 返回值对应的表列名 platform_client_sign_up.create_time
     *
     * @return 返回值对应 platform_client_sign_up.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间<br/>
     * platform_client_sign_up.create_time
     *
     * @param createTime 值对应 platform_client_sign_up.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改人<br/>
     * 返回值对应的表列名 platform_client_sign_up.modifier
     *
     * @return 返回值对应 platform_client_sign_up.modifier
     *
     * @mbg.generated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人<br/>
     * platform_client_sign_up.modifier
     *
     * @param modifier 值对应 platform_client_sign_up.modifier
     *
     * @mbg.generated
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 修改时间<br/>
     * 返回值对应的表列名 platform_client_sign_up.modify_time
     *
     * @return 返回值对应 platform_client_sign_up.modify_time
     *
     * @mbg.generated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 修改时间<br/>
     * platform_client_sign_up.modify_time
     *
     * @param modifyTime 值对应 platform_client_sign_up.modify_time
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
        PlatformClientSignUp other = (PlatformClientSignUp) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClientUserCode() == null ? other.getClientUserCode() == null : this.getClientUserCode().equals(other.getClientUserCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getMobilePhone() == null ? other.getMobilePhone() == null : this.getMobilePhone().equals(other.getMobilePhone()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
            && (this.getCompany() == null ? other.getCompany() == null : this.getCompany().equals(other.getCompany()))
            && (this.getPost() == null ? other.getPost() == null : this.getPost().equals(other.getPost()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getArticleId() == null ? other.getArticleId() == null : this.getArticleId().equals(other.getArticleId()))
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
        result = prime * result + ((getClientUserCode() == null) ? 0 : getClientUserCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getMobilePhone() == null) ? 0 : getMobilePhone().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getCompany() == null) ? 0 : getCompany().hashCode());
        result = prime * result + ((getPost() == null) ? 0 : getPost().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getArticleId() == null) ? 0 : getArticleId().hashCode());
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
        sb.append(", clientUserCode=").append(clientUserCode);
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", mobilePhone=").append(mobilePhone);
        sb.append(", email=").append(email);
        sb.append(", qq=").append(qq);
        sb.append(", company=").append(company);
        sb.append(", post=").append(post);
        sb.append(", status=").append(status);
        sb.append(", articleId=").append(articleId);
        sb.append(", creator=").append(creator);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}