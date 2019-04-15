package com.azz.client.pojo;


import java.io.Serializable;
import java.util.Date;

public class PlatformIndexColumn implements Serializable {
    private Long id;

    /**
     * 栏目名称
     *
     * @mbg.generated
     */
    private String columnName;

    /**
     * 栏目图片名称
     *
     * @mbg.generated
     */
    private String columnPicName;

    /**
     * 栏目主图url
     *
     * @mbg.generated
     */
    private String columnPicUrl;

    /**
     * 栏目代码
     *
     * @mbg.generated
     */
    private String columnCode;

    /**
     * 栏目类型(1: 图片展示 2: 文章展示)
     *
     * @mbg.generated
     */
    private Integer columnType;

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
     * 返回值对应的表列名 platform_index_column.id
     *
     * @return 返回值对应 platform_index_column.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * <br/>
     * platform_index_column.id
     *
     * @param id 值对应 platform_index_column.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 栏目名称<br/>
     * 返回值对应的表列名 platform_index_column.column_name
     *
     * @return 返回值对应 platform_index_column.column_name
     *
     * @mbg.generated
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 栏目名称<br/>
     * platform_index_column.column_name
     *
     * @param columnName 值对应 platform_index_column.column_name
     *
     * @mbg.generated
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    /**
     * 栏目图片名称<br/>
     * 返回值对应的表列名 platform_index_column.column_pic_name
     *
     * @return 返回值对应 platform_index_column.column_pic_name
     *
     * @mbg.generated
     */
    public String getColumnPicName() {
        return columnPicName;
    }

    /**
     * 栏目图片名称<br/>
     * platform_index_column.column_pic_name
     *
     * @param columnPicName 值对应 platform_index_column.column_pic_name
     *
     * @mbg.generated
     */
    public void setColumnPicName(String columnPicName) {
        this.columnPicName = columnPicName == null ? null : columnPicName.trim();
    }

    /**
     * 栏目主图url<br/>
     * 返回值对应的表列名 platform_index_column.column_pic_url
     *
     * @return 返回值对应 platform_index_column.column_pic_url
     *
     * @mbg.generated
     */
    public String getColumnPicUrl() {
        return columnPicUrl;
    }

    /**
     * 栏目主图url<br/>
     * platform_index_column.column_pic_url
     *
     * @param columnPicUrl 值对应 platform_index_column.column_pic_url
     *
     * @mbg.generated
     */
    public void setColumnPicUrl(String columnPicUrl) {
        this.columnPicUrl = columnPicUrl == null ? null : columnPicUrl.trim();
    }

    /**
     * 栏目代码<br/>
     * 返回值对应的表列名 platform_index_column.column_code
     *
     * @return 返回值对应 platform_index_column.column_code
     *
     * @mbg.generated
     */
    public String getColumnCode() {
        return columnCode;
    }

    /**
     * 栏目代码<br/>
     * platform_index_column.column_code
     *
     * @param columnCode 值对应 platform_index_column.column_code
     *
     * @mbg.generated
     */
    public void setColumnCode(String columnCode) {
        this.columnCode = columnCode == null ? null : columnCode.trim();
    }

    /**
     * 栏目类型(1: 图片展示 2: 文章展示)<br/>
     * 返回值对应的表列名 platform_index_column.column_type
     *
     * @return 返回值对应 platform_index_column.column_type
     *
     * @mbg.generated
     */
    public Integer getColumnType() {
        return columnType;
    }

    /**
     * 栏目类型(1: 图片展示 2: 文章展示)<br/>
     * platform_index_column.column_type
     *
     * @param columnType 值对应 platform_index_column.column_type
     *
     * @mbg.generated
     */
    public void setColumnType(Integer columnType) {
        this.columnType = columnType;
    }

    /**
     * 创建时间<br/>
     * 返回值对应的表列名 platform_index_column.create_time
     *
     * @return 返回值对应 platform_index_column.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间<br/>
     * platform_index_column.create_time
     *
     * @param createTime 值对应 platform_index_column.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 创建人<br/>
     * 返回值对应的表列名 platform_index_column.creator
     *
     * @return 返回值对应 platform_index_column.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人<br/>
     * platform_index_column.creator
     *
     * @param creator 值对应 platform_index_column.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 最后更新时间<br/>
     * 返回值对应的表列名 platform_index_column.last_modify_time
     *
     * @return 返回值对应 platform_index_column.last_modify_time
     *
     * @mbg.generated
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 最后更新时间<br/>
     * platform_index_column.last_modify_time
     *
     * @param lastModifyTime 值对应 platform_index_column.last_modify_time
     *
     * @mbg.generated
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    /**
     * 修改人<br/>
     * 返回值对应的表列名 platform_index_column.modifier
     *
     * @return 返回值对应 platform_index_column.modifier
     *
     * @mbg.generated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人<br/>
     * platform_index_column.modifier
     *
     * @param modifier 值对应 platform_index_column.modifier
     *
     * @mbg.generated
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 备注<br/>
     * 返回值对应的表列名 platform_index_column.remark
     *
     * @return 返回值对应 platform_index_column.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注<br/>
     * platform_index_column.remark
     *
     * @param remark 值对应 platform_index_column.remark
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
        PlatformIndexColumn other = (PlatformIndexColumn) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getColumnName() == null ? other.getColumnName() == null : this.getColumnName().equals(other.getColumnName()))
            && (this.getColumnPicName() == null ? other.getColumnPicName() == null : this.getColumnPicName().equals(other.getColumnPicName()))
            && (this.getColumnPicUrl() == null ? other.getColumnPicUrl() == null : this.getColumnPicUrl().equals(other.getColumnPicUrl()))
            && (this.getColumnCode() == null ? other.getColumnCode() == null : this.getColumnCode().equals(other.getColumnCode()))
            && (this.getColumnType() == null ? other.getColumnType() == null : this.getColumnType().equals(other.getColumnType()))
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
        result = prime * result + ((getColumnName() == null) ? 0 : getColumnName().hashCode());
        result = prime * result + ((getColumnPicName() == null) ? 0 : getColumnPicName().hashCode());
        result = prime * result + ((getColumnPicUrl() == null) ? 0 : getColumnPicUrl().hashCode());
        result = prime * result + ((getColumnCode() == null) ? 0 : getColumnCode().hashCode());
        result = prime * result + ((getColumnType() == null) ? 0 : getColumnType().hashCode());
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
        sb.append(", columnName=").append(columnName);
        sb.append(", columnPicName=").append(columnPicName);
        sb.append(", columnPicUrl=").append(columnPicUrl);
        sb.append(", columnCode=").append(columnCode);
        sb.append(", columnType=").append(columnType);
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