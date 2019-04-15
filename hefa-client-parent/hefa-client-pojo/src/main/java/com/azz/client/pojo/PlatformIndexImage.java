package com.azz.client.pojo;


import java.io.Serializable;
import java.util.Date;

public class PlatformIndexImage implements Serializable {
    private Long id;

    /**
     * 关联栏目表id
     *
     * @mbg.generated
     */
    private Long indexColumnId;

    /**
     * 主图名称
     *
     * @mbg.generated
     */
    private String picName;

    /**
     * 主图url
     *
     * @mbg.generated
     */
    private String picUrl;

    /**
     * 跳转链接
     *
     * @mbg.generated
     */
    private String jumpLink;

    /**
     * 创建时间
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
     * 最后更新时间
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
     * <br/>
     * 返回值对应的表列名 platform_index_image.id
     *
     * @return 返回值对应 platform_index_image.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * <br/>
     * platform_index_image.id
     *
     * @param id 值对应 platform_index_image.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 关联栏目表id<br/>
     * 返回值对应的表列名 platform_index_image.index_column_id
     *
     * @return 返回值对应 platform_index_image.index_column_id
     *
     * @mbg.generated
     */
    public Long getIndexColumnId() {
        return indexColumnId;
    }

    /**
     * 关联栏目表id<br/>
     * platform_index_image.index_column_id
     *
     * @param indexColumnId 值对应 platform_index_image.index_column_id
     *
     * @mbg.generated
     */
    public void setIndexColumnId(Long indexColumnId) {
        this.indexColumnId = indexColumnId;
    }

    /**
     * 主图名称<br/>
     * 返回值对应的表列名 platform_index_image.pic_name
     *
     * @return 返回值对应 platform_index_image.pic_name
     *
     * @mbg.generated
     */
    public String getPicName() {
        return picName;
    }

    /**
     * 主图名称<br/>
     * platform_index_image.pic_name
     *
     * @param picName 值对应 platform_index_image.pic_name
     *
     * @mbg.generated
     */
    public void setPicName(String picName) {
        this.picName = picName == null ? null : picName.trim();
    }

    /**
     * 主图url<br/>
     * 返回值对应的表列名 platform_index_image.pic_url
     *
     * @return 返回值对应 platform_index_image.pic_url
     *
     * @mbg.generated
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 主图url<br/>
     * platform_index_image.pic_url
     *
     * @param picUrl 值对应 platform_index_image.pic_url
     *
     * @mbg.generated
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    /**
     * 跳转链接<br/>
     * 返回值对应的表列名 platform_index_image.jump_link
     *
     * @return 返回值对应 platform_index_image.jump_link
     *
     * @mbg.generated
     */
    public String getJumpLink() {
        return jumpLink;
    }

    /**
     * 跳转链接<br/>
     * platform_index_image.jump_link
     *
     * @param jumpLink 值对应 platform_index_image.jump_link
     *
     * @mbg.generated
     */
    public void setJumpLink(String jumpLink) {
        this.jumpLink = jumpLink == null ? null : jumpLink.trim();
    }

    /**
     * 创建时间<br/>
     * 返回值对应的表列名 platform_index_image.create_time
     *
     * @return 返回值对应 platform_index_image.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间<br/>
     * platform_index_image.create_time
     *
     * @param createTime 值对应 platform_index_image.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 创建人<br/>
     * 返回值对应的表列名 platform_index_image.creator
     *
     * @return 返回值对应 platform_index_image.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人<br/>
     * platform_index_image.creator
     *
     * @param creator 值对应 platform_index_image.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 最后更新时间<br/>
     * 返回值对应的表列名 platform_index_image.last_modify_time
     *
     * @return 返回值对应 platform_index_image.last_modify_time
     *
     * @mbg.generated
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 最后更新时间<br/>
     * platform_index_image.last_modify_time
     *
     * @param lastModifyTime 值对应 platform_index_image.last_modify_time
     *
     * @mbg.generated
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    /**
     * 修改人<br/>
     * 返回值对应的表列名 platform_index_image.modifier
     *
     * @return 返回值对应 platform_index_image.modifier
     *
     * @mbg.generated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人<br/>
     * platform_index_image.modifier
     *
     * @param modifier 值对应 platform_index_image.modifier
     *
     * @mbg.generated
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 备注<br/>
     * 返回值对应的表列名 platform_index_image.remark
     *
     * @return 返回值对应 platform_index_image.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注<br/>
     * platform_index_image.remark
     *
     * @param remark 值对应 platform_index_image.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        PlatformIndexImage other = (PlatformIndexImage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIndexColumnId() == null ? other.getIndexColumnId() == null : this.getIndexColumnId().equals(other.getIndexColumnId()))
            && (this.getPicName() == null ? other.getPicName() == null : this.getPicName().equals(other.getPicName()))
            && (this.getPicUrl() == null ? other.getPicUrl() == null : this.getPicUrl().equals(other.getPicUrl()))
            && (this.getJumpLink() == null ? other.getJumpLink() == null : this.getJumpLink().equals(other.getJumpLink()))
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
        result = prime * result + ((getIndexColumnId() == null) ? 0 : getIndexColumnId().hashCode());
        result = prime * result + ((getPicName() == null) ? 0 : getPicName().hashCode());
        result = prime * result + ((getPicUrl() == null) ? 0 : getPicUrl().hashCode());
        result = prime * result + ((getJumpLink() == null) ? 0 : getJumpLink().hashCode());
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
        sb.append(", indexColumnId=").append(indexColumnId);
        sb.append(", picName=").append(picName);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", jumpLink=").append(jumpLink);
        sb.append(", createTime=").append(createTime);
        sb.append(", creator=").append(creator);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append(", modifier=").append(modifier);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}