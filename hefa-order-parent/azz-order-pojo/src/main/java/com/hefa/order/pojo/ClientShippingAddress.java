package com.hefa.order.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientShippingAddress implements Serializable {
    /**
     * 主键id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 订单发货地址编码
     *
     * @mbg.generated
     */
    private String shippingAddressCode;

    /**
     * 客户编码
     *
     * @mbg.generated
     */
    private String userCode;

    /**
     * 收货人
     *
     * @mbg.generated
     */
    private String receiverName;

    /**
     * 收货人手机号
     *
     * @mbg.generated
     */
    private String receiverPhoneNumber;

    /**
     * 地址别名
     *
     * @mbg.generated
     */
    private String addressAlias;

    /**
     * 是否为默认地址 0否  1是
     *
     * @mbg.generated
     */
    private Integer isDefault;

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
     * 状态  0无效  1有效
     *
     * @mbg.generated
     */
    private Integer status;

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
     * 返回值对应的表列名 client_shipping_address.id
     *
     * @return 返回值对应 client_shipping_address.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id<br/>
     * client_shipping_address.id
     *
     * @param id 值对应 client_shipping_address.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 订单发货地址编码<br/>
     * 返回值对应的表列名 client_shipping_address.shipping_address_code
     *
     * @return 返回值对应 client_shipping_address.shipping_address_code
     *
     * @mbg.generated
     */
    public String getShippingAddressCode() {
        return shippingAddressCode;
    }

    /**
     * 订单发货地址编码<br/>
     * client_shipping_address.shipping_address_code
     *
     * @param shippingAddressCode 值对应 client_shipping_address.shipping_address_code
     *
     * @mbg.generated
     */
    public void setShippingAddressCode(String shippingAddressCode) {
        this.shippingAddressCode = shippingAddressCode == null ? null : shippingAddressCode.trim();
    }

    /**
     * 客户编码<br/>
     * 返回值对应的表列名 client_shipping_address.user_code
     *
     * @return 返回值对应 client_shipping_address.user_code
     *
     * @mbg.generated
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * 客户编码<br/>
     * client_shipping_address.user_code
     *
     * @param userCode 值对应 client_shipping_address.user_code
     *
     * @mbg.generated
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    /**
     * 收货人<br/>
     * 返回值对应的表列名 client_shipping_address.receiver_name
     *
     * @return 返回值对应 client_shipping_address.receiver_name
     *
     * @mbg.generated
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * 收货人<br/>
     * client_shipping_address.receiver_name
     *
     * @param receiverName 值对应 client_shipping_address.receiver_name
     *
     * @mbg.generated
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    /**
     * 收货人手机号<br/>
     * 返回值对应的表列名 client_shipping_address.receiver_phone_number
     *
     * @return 返回值对应 client_shipping_address.receiver_phone_number
     *
     * @mbg.generated
     */
    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    /**
     * 收货人手机号<br/>
     * client_shipping_address.receiver_phone_number
     *
     * @param receiverPhoneNumber 值对应 client_shipping_address.receiver_phone_number
     *
     * @mbg.generated
     */
    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber == null ? null : receiverPhoneNumber.trim();
    }

    /**
     * 地址别名<br/>
     * 返回值对应的表列名 client_shipping_address.address_alias
     *
     * @return 返回值对应 client_shipping_address.address_alias
     *
     * @mbg.generated
     */
    public String getAddressAlias() {
        return addressAlias;
    }

    /**
     * 地址别名<br/>
     * client_shipping_address.address_alias
     *
     * @param addressAlias 值对应 client_shipping_address.address_alias
     *
     * @mbg.generated
     */
    public void setAddressAlias(String addressAlias) {
        this.addressAlias = addressAlias == null ? null : addressAlias.trim();
    }

    /**
     * 是否为默认地址 0否  1是<br/>
     * 返回值对应的表列名 client_shipping_address.is_default
     *
     * @return 返回值对应 client_shipping_address.is_default
     *
     * @mbg.generated
     */
    public Integer getIsDefault() {
        return isDefault;
    }

    /**
     * 是否为默认地址 0否  1是<br/>
     * client_shipping_address.is_default
     *
     * @param isDefault 值对应 client_shipping_address.is_default
     *
     * @mbg.generated
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 省编码<br/>
     * 返回值对应的表列名 client_shipping_address.province_code
     *
     * @return 返回值对应 client_shipping_address.province_code
     *
     * @mbg.generated
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * 省编码<br/>
     * client_shipping_address.province_code
     *
     * @param provinceCode 值对应 client_shipping_address.province_code
     *
     * @mbg.generated
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * 省名称<br/>
     * 返回值对应的表列名 client_shipping_address.province_name
     *
     * @return 返回值对应 client_shipping_address.province_name
     *
     * @mbg.generated
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * 省名称<br/>
     * client_shipping_address.province_name
     *
     * @param provinceName 值对应 client_shipping_address.province_name
     *
     * @mbg.generated
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    /**
     * 市编码<br/>
     * 返回值对应的表列名 client_shipping_address.city_code
     *
     * @return 返回值对应 client_shipping_address.city_code
     *
     * @mbg.generated
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 市编码<br/>
     * client_shipping_address.city_code
     *
     * @param cityCode 值对应 client_shipping_address.city_code
     *
     * @mbg.generated
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 市名称<br/>
     * 返回值对应的表列名 client_shipping_address.city_name
     *
     * @return 返回值对应 client_shipping_address.city_name
     *
     * @mbg.generated
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 市名称<br/>
     * client_shipping_address.city_name
     *
     * @param cityName 值对应 client_shipping_address.city_name
     *
     * @mbg.generated
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * 区编码<br/>
     * 返回值对应的表列名 client_shipping_address.area_code
     *
     * @return 返回值对应 client_shipping_address.area_code
     *
     * @mbg.generated
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 区编码<br/>
     * client_shipping_address.area_code
     *
     * @param areaCode 值对应 client_shipping_address.area_code
     *
     * @mbg.generated
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    /**
     * 区名称<br/>
     * 返回值对应的表列名 client_shipping_address.area_name
     *
     * @return 返回值对应 client_shipping_address.area_name
     *
     * @mbg.generated
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 区名称<br/>
     * client_shipping_address.area_name
     *
     * @param areaName 值对应 client_shipping_address.area_name
     *
     * @mbg.generated
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    /**
     * 详细地址<br/>
     * 返回值对应的表列名 client_shipping_address.detail_address
     *
     * @return 返回值对应 client_shipping_address.detail_address
     *
     * @mbg.generated
     */
    public String getDetailAddress() {
        return detailAddress;
    }

    /**
     * 详细地址<br/>
     * client_shipping_address.detail_address
     *
     * @param detailAddress 值对应 client_shipping_address.detail_address
     *
     * @mbg.generated
     */
    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
    }

    /**
     * 状态  0无效  1有效<br/>
     * 返回值对应的表列名 client_shipping_address.status
     *
     * @return 返回值对应 client_shipping_address.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态  0无效  1有效<br/>
     * client_shipping_address.status
     *
     * @param status 值对应 client_shipping_address.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 创建人<br/>
     * 返回值对应的表列名 client_shipping_address.creator
     *
     * @return 返回值对应 client_shipping_address.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人<br/>
     * client_shipping_address.creator
     *
     * @param creator 值对应 client_shipping_address.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 创建时间<br/>
     * 返回值对应的表列名 client_shipping_address.create_time
     *
     * @return 返回值对应 client_shipping_address.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间<br/>
     * client_shipping_address.create_time
     *
     * @param createTime 值对应 client_shipping_address.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改人<br/>
     * 返回值对应的表列名 client_shipping_address.modifier
     *
     * @return 返回值对应 client_shipping_address.modifier
     *
     * @mbg.generated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人<br/>
     * client_shipping_address.modifier
     *
     * @param modifier 值对应 client_shipping_address.modifier
     *
     * @mbg.generated
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 最后修改时间<br/>
     * 返回值对应的表列名 client_shipping_address.modify_time
     *
     * @return 返回值对应 client_shipping_address.modify_time
     *
     * @mbg.generated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 最后修改时间<br/>
     * client_shipping_address.modify_time
     *
     * @param modifyTime 值对应 client_shipping_address.modify_time
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
        ClientShippingAddress other = (ClientShippingAddress) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getShippingAddressCode() == null ? other.getShippingAddressCode() == null : this.getShippingAddressCode().equals(other.getShippingAddressCode()))
            && (this.getUserCode() == null ? other.getUserCode() == null : this.getUserCode().equals(other.getUserCode()))
            && (this.getReceiverName() == null ? other.getReceiverName() == null : this.getReceiverName().equals(other.getReceiverName()))
            && (this.getReceiverPhoneNumber() == null ? other.getReceiverPhoneNumber() == null : this.getReceiverPhoneNumber().equals(other.getReceiverPhoneNumber()))
            && (this.getAddressAlias() == null ? other.getAddressAlias() == null : this.getAddressAlias().equals(other.getAddressAlias()))
            && (this.getIsDefault() == null ? other.getIsDefault() == null : this.getIsDefault().equals(other.getIsDefault()))
            && (this.getProvinceCode() == null ? other.getProvinceCode() == null : this.getProvinceCode().equals(other.getProvinceCode()))
            && (this.getProvinceName() == null ? other.getProvinceName() == null : this.getProvinceName().equals(other.getProvinceName()))
            && (this.getCityCode() == null ? other.getCityCode() == null : this.getCityCode().equals(other.getCityCode()))
            && (this.getCityName() == null ? other.getCityName() == null : this.getCityName().equals(other.getCityName()))
            && (this.getAreaCode() == null ? other.getAreaCode() == null : this.getAreaCode().equals(other.getAreaCode()))
            && (this.getAreaName() == null ? other.getAreaName() == null : this.getAreaName().equals(other.getAreaName()))
            && (this.getDetailAddress() == null ? other.getDetailAddress() == null : this.getDetailAddress().equals(other.getDetailAddress()))
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
        result = prime * result + ((getShippingAddressCode() == null) ? 0 : getShippingAddressCode().hashCode());
        result = prime * result + ((getUserCode() == null) ? 0 : getUserCode().hashCode());
        result = prime * result + ((getReceiverName() == null) ? 0 : getReceiverName().hashCode());
        result = prime * result + ((getReceiverPhoneNumber() == null) ? 0 : getReceiverPhoneNumber().hashCode());
        result = prime * result + ((getAddressAlias() == null) ? 0 : getAddressAlias().hashCode());
        result = prime * result + ((getIsDefault() == null) ? 0 : getIsDefault().hashCode());
        result = prime * result + ((getProvinceCode() == null) ? 0 : getProvinceCode().hashCode());
        result = prime * result + ((getProvinceName() == null) ? 0 : getProvinceName().hashCode());
        result = prime * result + ((getCityCode() == null) ? 0 : getCityCode().hashCode());
        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());
        result = prime * result + ((getAreaCode() == null) ? 0 : getAreaCode().hashCode());
        result = prime * result + ((getAreaName() == null) ? 0 : getAreaName().hashCode());
        result = prime * result + ((getDetailAddress() == null) ? 0 : getDetailAddress().hashCode());
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
        sb.append(", shippingAddressCode=").append(shippingAddressCode);
        sb.append(", userCode=").append(userCode);
        sb.append(", receiverName=").append(receiverName);
        sb.append(", receiverPhoneNumber=").append(receiverPhoneNumber);
        sb.append(", addressAlias=").append(addressAlias);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", provinceCode=").append(provinceCode);
        sb.append(", provinceName=").append(provinceName);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", cityName=").append(cityName);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", areaName=").append(areaName);
        sb.append(", detailAddress=").append(detailAddress);
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