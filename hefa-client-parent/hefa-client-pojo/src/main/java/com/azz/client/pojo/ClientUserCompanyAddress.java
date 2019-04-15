package com.azz.client.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientUserCompanyAddress implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Long id;

    private String companyCode;

    /**
     * 省编码
     *
     * @mbg.generated
     */
    private String provinceCode;

    /**
     * 省名称
     *
     * @mbg.generated
     */
    private String provinceName;

    /**
     * 市编码
     *
     * @mbg.generated
     */
    private String cityCode;

    /**
     * 市名称
     *
     * @mbg.generated
     */
    private String cityName;

    /**
     * 区编码
     *
     * @mbg.generated
     */
    private String areaCode;

    /**
     * 区名称
     *
     * @mbg.generated
     */
    private String areaName;

    /**
     * 详细地址
     *
     * @mbg.generated
     */
    private String detailAddress;

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
    private Date lastModifyTime;

    private static final long serialVersionUID = 1L;

    /**
     * 主键<br/>
     * 返回值对应的表列名 client_user_company_address.id
     *
     * @return 返回值对应 client_user_company_address.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键<br/>
     * client_user_company_address.id
     *
     * @param id 值对应 client_user_company_address.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * 省编码<br/>
     * 返回值对应的表列名 client_user_company_address.province_code
     *
     * @return 返回值对应 client_user_company_address.province_code
     *
     * @mbg.generated
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * 省编码<br/>
     * client_user_company_address.province_code
     *
     * @param provinceCode 值对应 client_user_company_address.province_code
     *
     * @mbg.generated
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * 省名称<br/>
     * 返回值对应的表列名 client_user_company_address.province_name
     *
     * @return 返回值对应 client_user_company_address.province_name
     *
     * @mbg.generated
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * 省名称<br/>
     * client_user_company_address.province_name
     *
     * @param provinceName 值对应 client_user_company_address.province_name
     *
     * @mbg.generated
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    /**
     * 市编码<br/>
     * 返回值对应的表列名 client_user_company_address.city_code
     *
     * @return 返回值对应 client_user_company_address.city_code
     *
     * @mbg.generated
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 市编码<br/>
     * client_user_company_address.city_code
     *
     * @param cityCode 值对应 client_user_company_address.city_code
     *
     * @mbg.generated
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 市名称<br/>
     * 返回值对应的表列名 client_user_company_address.city_name
     *
     * @return 返回值对应 client_user_company_address.city_name
     *
     * @mbg.generated
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 市名称<br/>
     * client_user_company_address.city_name
     *
     * @param cityName 值对应 client_user_company_address.city_name
     *
     * @mbg.generated
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * 区编码<br/>
     * 返回值对应的表列名 client_user_company_address.area_code
     *
     * @return 返回值对应 client_user_company_address.area_code
     *
     * @mbg.generated
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 区编码<br/>
     * client_user_company_address.area_code
     *
     * @param areaCode 值对应 client_user_company_address.area_code
     *
     * @mbg.generated
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    /**
     * 区名称<br/>
     * 返回值对应的表列名 client_user_company_address.area_name
     *
     * @return 返回值对应 client_user_company_address.area_name
     *
     * @mbg.generated
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 区名称<br/>
     * client_user_company_address.area_name
     *
     * @param areaName 值对应 client_user_company_address.area_name
     *
     * @mbg.generated
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    /**
     * 详细地址<br/>
     * 返回值对应的表列名 client_user_company_address.detail_address
     *
     * @return 返回值对应 client_user_company_address.detail_address
     *
     * @mbg.generated
     */
    public String getDetailAddress() {
        return detailAddress;
    }

    /**
     * 详细地址<br/>
     * client_user_company_address.detail_address
     *
     * @param detailAddress 值对应 client_user_company_address.detail_address
     *
     * @mbg.generated
     */
    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
    }

    /**
     * 创建时间<br/>
     * 返回值对应的表列名 client_user_company_address.create_time
     *
     * @return 返回值对应 client_user_company_address.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间<br/>
     * client_user_company_address.create_time
     *
     * @param createTime 值对应 client_user_company_address.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 创建人<br/>
     * 返回值对应的表列名 client_user_company_address.creator
     *
     * @return 返回值对应 client_user_company_address.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人<br/>
     * client_user_company_address.creator
     *
     * @param creator 值对应 client_user_company_address.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 修改人<br/>
     * 返回值对应的表列名 client_user_company_address.modifier
     *
     * @return 返回值对应 client_user_company_address.modifier
     *
     * @mbg.generated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人<br/>
     * client_user_company_address.modifier
     *
     * @param modifier 值对应 client_user_company_address.modifier
     *
     * @mbg.generated
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 修改时间<br/>
     * 返回值对应的表列名 client_user_company_address.last_modify_time
     *
     * @return 返回值对应 client_user_company_address.last_modify_time
     *
     * @mbg.generated
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 修改时间<br/>
     * client_user_company_address.last_modify_time
     *
     * @param lastModifyTime 值对应 client_user_company_address.last_modify_time
     *
     * @mbg.generated
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
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
        ClientUserCompanyAddress other = (ClientUserCompanyAddress) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProvinceCode() == null ? other.getProvinceCode() == null : this.getProvinceCode().equals(other.getProvinceCode()))
            && (this.getProvinceName() == null ? other.getProvinceName() == null : this.getProvinceName().equals(other.getProvinceName()))
            && (this.getCityCode() == null ? other.getCityCode() == null : this.getCityCode().equals(other.getCityCode()))
            && (this.getCityName() == null ? other.getCityName() == null : this.getCityName().equals(other.getCityName()))
            && (this.getAreaCode() == null ? other.getAreaCode() == null : this.getAreaCode().equals(other.getAreaCode()))
            && (this.getAreaName() == null ? other.getAreaName() == null : this.getAreaName().equals(other.getAreaName()))
            && (this.getDetailAddress() == null ? other.getDetailAddress() == null : this.getDetailAddress().equals(other.getDetailAddress()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProvinceCode() == null) ? 0 : getProvinceCode().hashCode());
        result = prime * result + ((getProvinceName() == null) ? 0 : getProvinceName().hashCode());
        result = prime * result + ((getCityCode() == null) ? 0 : getCityCode().hashCode());
        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());
        result = prime * result + ((getAreaCode() == null) ? 0 : getAreaCode().hashCode());
        result = prime * result + ((getAreaName() == null) ? 0 : getAreaName().hashCode());
        result = prime * result + ((getDetailAddress() == null) ? 0 : getDetailAddress().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getLastModifyTime() == null) ? 0 : getLastModifyTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", provinceCode=").append(provinceCode);
        sb.append(", provinceName=").append(provinceName);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", cityName=").append(cityName);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", areaName=").append(areaName);
        sb.append(", detailAddress=").append(detailAddress);
        sb.append(", createTime=").append(createTime);
        sb.append(", creator=").append(creator);
        sb.append(", modifier=").append(modifier);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}