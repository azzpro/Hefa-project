package com.azz.client.pojo;


import java.io.Serializable;
import java.util.Date;

public class PlatformSpecialPerformance implements Serializable {
    /**
     * 主键id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 专场编码
     *
     * @mbg.generated
     */
    private String specialPerformanceCode;

    /**
     * 专场名称
     *
     * @mbg.generated
     */
    private String specialPerformanceName;

    /**
     * 专场主图url
     *
     * @mbg.generated
     */
    private String specialPerformanceMainPicUrl;

    /**
     * 专场主图名称
     *
     * @mbg.generated
     */
    private String specialPerformanceMainPicName;

    /**
     * 专场背景图url
     *
     * @mbg.generated
     */
    private String specialPerformanceBgPicUrl;

    /**
     * 专场背景图名称
     *
     * @mbg.generated
     */
    private String specialPerformanceBgPicName;

    /**
     * 专场链接
     *
     * @mbg.generated
     */
    private String specialPerformanceLink;

    /**
     * 模组数量
     *
     * @mbg.generated
     */
    private Long moduleNumber;

    /**
     * 产品数量
     *
     * @mbg.generated
     */
    private Long productNumber;

    /**
     * 访问数量
     *
     * @mbg.generated
     */
    private Long interviewNumber;

    /**
     * 状态  删除0  上架1  下架2  
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
     * 修改时间
     *
     * @mbg.generated
     */
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    /**
     * 主键id<br/>
     * 返回值对应的表列名 platform_special_performance.id
     *
     * @return 返回值对应 platform_special_performance.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id<br/>
     * platform_special_performance.id
     *
     * @param id 值对应 platform_special_performance.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 专场编码<br/>
     * 返回值对应的表列名 platform_special_performance.special_performance_code
     *
     * @return 返回值对应 platform_special_performance.special_performance_code
     *
     * @mbg.generated
     */
    public String getSpecialPerformanceCode() {
        return specialPerformanceCode;
    }

    /**
     * 专场编码<br/>
     * platform_special_performance.special_performance_code
     *
     * @param specialPerformanceCode 值对应 platform_special_performance.special_performance_code
     *
     * @mbg.generated
     */
    public void setSpecialPerformanceCode(String specialPerformanceCode) {
        this.specialPerformanceCode = specialPerformanceCode == null ? null : specialPerformanceCode.trim();
    }

    /**
     * 专场名称<br/>
     * 返回值对应的表列名 platform_special_performance.special_performance_name
     *
     * @return 返回值对应 platform_special_performance.special_performance_name
     *
     * @mbg.generated
     */
    public String getSpecialPerformanceName() {
        return specialPerformanceName;
    }

    /**
     * 专场名称<br/>
     * platform_special_performance.special_performance_name
     *
     * @param specialPerformanceName 值对应 platform_special_performance.special_performance_name
     *
     * @mbg.generated
     */
    public void setSpecialPerformanceName(String specialPerformanceName) {
        this.specialPerformanceName = specialPerformanceName == null ? null : specialPerformanceName.trim();
    }

    /**
     * 专场主图url<br/>
     * 返回值对应的表列名 platform_special_performance.special_performance_main_pic_url
     *
     * @return 返回值对应 platform_special_performance.special_performance_main_pic_url
     *
     * @mbg.generated
     */
    public String getSpecialPerformanceMainPicUrl() {
        return specialPerformanceMainPicUrl;
    }

    /**
     * 专场主图url<br/>
     * platform_special_performance.special_performance_main_pic_url
     *
     * @param specialPerformanceMainPicUrl 值对应 platform_special_performance.special_performance_main_pic_url
     *
     * @mbg.generated
     */
    public void setSpecialPerformanceMainPicUrl(String specialPerformanceMainPicUrl) {
        this.specialPerformanceMainPicUrl = specialPerformanceMainPicUrl == null ? null : specialPerformanceMainPicUrl.trim();
    }

    /**
     * 专场主图名称<br/>
     * 返回值对应的表列名 platform_special_performance.special_performance_main_pic_name
     *
     * @return 返回值对应 platform_special_performance.special_performance_main_pic_name
     *
     * @mbg.generated
     */
    public String getSpecialPerformanceMainPicName() {
        return specialPerformanceMainPicName;
    }

    /**
     * 专场主图名称<br/>
     * platform_special_performance.special_performance_main_pic_name
     *
     * @param specialPerformanceMainPicName 值对应 platform_special_performance.special_performance_main_pic_name
     *
     * @mbg.generated
     */
    public void setSpecialPerformanceMainPicName(String specialPerformanceMainPicName) {
        this.specialPerformanceMainPicName = specialPerformanceMainPicName == null ? null : specialPerformanceMainPicName.trim();
    }

    /**
     * 专场背景图url<br/>
     * 返回值对应的表列名 platform_special_performance.special_performance_bg_pic_url
     *
     * @return 返回值对应 platform_special_performance.special_performance_bg_pic_url
     *
     * @mbg.generated
     */
    public String getSpecialPerformanceBgPicUrl() {
        return specialPerformanceBgPicUrl;
    }

    /**
     * 专场背景图url<br/>
     * platform_special_performance.special_performance_bg_pic_url
     *
     * @param specialPerformanceBgPicUrl 值对应 platform_special_performance.special_performance_bg_pic_url
     *
     * @mbg.generated
     */
    public void setSpecialPerformanceBgPicUrl(String specialPerformanceBgPicUrl) {
        this.specialPerformanceBgPicUrl = specialPerformanceBgPicUrl == null ? null : specialPerformanceBgPicUrl.trim();
    }

    /**
     * 专场背景图名称<br/>
     * 返回值对应的表列名 platform_special_performance.special_performance_bg_pic_name
     *
     * @return 返回值对应 platform_special_performance.special_performance_bg_pic_name
     *
     * @mbg.generated
     */
    public String getSpecialPerformanceBgPicName() {
        return specialPerformanceBgPicName;
    }

    /**
     * 专场背景图名称<br/>
     * platform_special_performance.special_performance_bg_pic_name
     *
     * @param specialPerformanceBgPicName 值对应 platform_special_performance.special_performance_bg_pic_name
     *
     * @mbg.generated
     */
    public void setSpecialPerformanceBgPicName(String specialPerformanceBgPicName) {
        this.specialPerformanceBgPicName = specialPerformanceBgPicName == null ? null : specialPerformanceBgPicName.trim();
    }

    /**
     * 专场链接<br/>
     * 返回值对应的表列名 platform_special_performance.special_performance_link
     *
     * @return 返回值对应 platform_special_performance.special_performance_link
     *
     * @mbg.generated
     */
    public String getSpecialPerformanceLink() {
        return specialPerformanceLink;
    }

    /**
     * 专场链接<br/>
     * platform_special_performance.special_performance_link
     *
     * @param specialPerformanceLink 值对应 platform_special_performance.special_performance_link
     *
     * @mbg.generated
     */
    public void setSpecialPerformanceLink(String specialPerformanceLink) {
        this.specialPerformanceLink = specialPerformanceLink == null ? null : specialPerformanceLink.trim();
    }

    /**
     * 模组数量<br/>
     * 返回值对应的表列名 platform_special_performance.module_number
     *
     * @return 返回值对应 platform_special_performance.module_number
     *
     * @mbg.generated
     */
    public Long getModuleNumber() {
        return moduleNumber;
    }

    /**
     * 模组数量<br/>
     * platform_special_performance.module_number
     *
     * @param moduleNumber 值对应 platform_special_performance.module_number
     *
     * @mbg.generated
     */
    public void setModuleNumber(Long moduleNumber) {
        this.moduleNumber = moduleNumber;
    }

    /**
     * 产品数量<br/>
     * 返回值对应的表列名 platform_special_performance.product_number
     *
     * @return 返回值对应 platform_special_performance.product_number
     *
     * @mbg.generated
     */
    public Long getProductNumber() {
        return productNumber;
    }

    /**
     * 产品数量<br/>
     * platform_special_performance.product_number
     *
     * @param productNumber 值对应 platform_special_performance.product_number
     *
     * @mbg.generated
     */
    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    /**
     * 访问数量<br/>
     * 返回值对应的表列名 platform_special_performance.interview_number
     *
     * @return 返回值对应 platform_special_performance.interview_number
     *
     * @mbg.generated
     */
    public Long getInterviewNumber() {
        return interviewNumber;
    }

    /**
     * 访问数量<br/>
     * platform_special_performance.interview_number
     *
     * @param interviewNumber 值对应 platform_special_performance.interview_number
     *
     * @mbg.generated
     */
    public void setInterviewNumber(Long interviewNumber) {
        this.interviewNumber = interviewNumber;
    }

    /**
     * 状态  删除0  上架1  下架2  <br/>
     * 返回值对应的表列名 platform_special_performance.status
     *
     * @return 返回值对应 platform_special_performance.status
     *
     * @mbg.generated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 状态  删除0  上架1  下架2  <br/>
     * platform_special_performance.status
     *
     * @param status 值对应 platform_special_performance.status
     *
     * @mbg.generated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 创建人<br/>
     * 返回值对应的表列名 platform_special_performance.creator
     *
     * @return 返回值对应 platform_special_performance.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人<br/>
     * platform_special_performance.creator
     *
     * @param creator 值对应 platform_special_performance.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 创建时间<br/>
     * 返回值对应的表列名 platform_special_performance.create_time
     *
     * @return 返回值对应 platform_special_performance.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间<br/>
     * platform_special_performance.create_time
     *
     * @param createTime 值对应 platform_special_performance.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改人<br/>
     * 返回值对应的表列名 platform_special_performance.modifier
     *
     * @return 返回值对应 platform_special_performance.modifier
     *
     * @mbg.generated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人<br/>
     * platform_special_performance.modifier
     *
     * @param modifier 值对应 platform_special_performance.modifier
     *
     * @mbg.generated
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 修改时间<br/>
     * 返回值对应的表列名 platform_special_performance.modify_time
     *
     * @return 返回值对应 platform_special_performance.modify_time
     *
     * @mbg.generated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 修改时间<br/>
     * platform_special_performance.modify_time
     *
     * @param modifyTime 值对应 platform_special_performance.modify_time
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
        PlatformSpecialPerformance other = (PlatformSpecialPerformance) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSpecialPerformanceCode() == null ? other.getSpecialPerformanceCode() == null : this.getSpecialPerformanceCode().equals(other.getSpecialPerformanceCode()))
            && (this.getSpecialPerformanceName() == null ? other.getSpecialPerformanceName() == null : this.getSpecialPerformanceName().equals(other.getSpecialPerformanceName()))
            && (this.getSpecialPerformanceMainPicUrl() == null ? other.getSpecialPerformanceMainPicUrl() == null : this.getSpecialPerformanceMainPicUrl().equals(other.getSpecialPerformanceMainPicUrl()))
            && (this.getSpecialPerformanceMainPicName() == null ? other.getSpecialPerformanceMainPicName() == null : this.getSpecialPerformanceMainPicName().equals(other.getSpecialPerformanceMainPicName()))
            && (this.getSpecialPerformanceBgPicUrl() == null ? other.getSpecialPerformanceBgPicUrl() == null : this.getSpecialPerformanceBgPicUrl().equals(other.getSpecialPerformanceBgPicUrl()))
            && (this.getSpecialPerformanceBgPicName() == null ? other.getSpecialPerformanceBgPicName() == null : this.getSpecialPerformanceBgPicName().equals(other.getSpecialPerformanceBgPicName()))
            && (this.getSpecialPerformanceLink() == null ? other.getSpecialPerformanceLink() == null : this.getSpecialPerformanceLink().equals(other.getSpecialPerformanceLink()))
            && (this.getModuleNumber() == null ? other.getModuleNumber() == null : this.getModuleNumber().equals(other.getModuleNumber()))
            && (this.getProductNumber() == null ? other.getProductNumber() == null : this.getProductNumber().equals(other.getProductNumber()))
            && (this.getInterviewNumber() == null ? other.getInterviewNumber() == null : this.getInterviewNumber().equals(other.getInterviewNumber()))
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
        result = prime * result + ((getSpecialPerformanceCode() == null) ? 0 : getSpecialPerformanceCode().hashCode());
        result = prime * result + ((getSpecialPerformanceName() == null) ? 0 : getSpecialPerformanceName().hashCode());
        result = prime * result + ((getSpecialPerformanceMainPicUrl() == null) ? 0 : getSpecialPerformanceMainPicUrl().hashCode());
        result = prime * result + ((getSpecialPerformanceMainPicName() == null) ? 0 : getSpecialPerformanceMainPicName().hashCode());
        result = prime * result + ((getSpecialPerformanceBgPicUrl() == null) ? 0 : getSpecialPerformanceBgPicUrl().hashCode());
        result = prime * result + ((getSpecialPerformanceBgPicName() == null) ? 0 : getSpecialPerformanceBgPicName().hashCode());
        result = prime * result + ((getSpecialPerformanceLink() == null) ? 0 : getSpecialPerformanceLink().hashCode());
        result = prime * result + ((getModuleNumber() == null) ? 0 : getModuleNumber().hashCode());
        result = prime * result + ((getProductNumber() == null) ? 0 : getProductNumber().hashCode());
        result = prime * result + ((getInterviewNumber() == null) ? 0 : getInterviewNumber().hashCode());
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
        sb.append(", specialPerformanceCode=").append(specialPerformanceCode);
        sb.append(", specialPerformanceName=").append(specialPerformanceName);
        sb.append(", specialPerformanceMainPicUrl=").append(specialPerformanceMainPicUrl);
        sb.append(", specialPerformanceMainPicName=").append(specialPerformanceMainPicName);
        sb.append(", specialPerformanceBgPicUrl=").append(specialPerformanceBgPicUrl);
        sb.append(", specialPerformanceBgPicName=").append(specialPerformanceBgPicName);
        sb.append(", specialPerformanceLink=").append(specialPerformanceLink);
        sb.append(", moduleNumber=").append(moduleNumber);
        sb.append(", productNumber=").append(productNumber);
        sb.append(", interviewNumber=").append(interviewNumber);
        sb.append(", status=").append(status);
        sb.append(", creator=").append(creator);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}