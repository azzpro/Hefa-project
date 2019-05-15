package com.hefa.order.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientOrderLogistics implements Serializable {
    private Long id;

    /**
     * 关联的订单编号
     *
     * @mbg.generated
     */
    private String orderCode;

    /**
     * 快递公司id
     *
     * @mbg.generated
     */
    private Integer expressCompanyId;

    /**
     * 单号
     *
     * @mbg.generated
     */
    private String number;

    /**
     * 配送方式 0快递 1自送
     *
     * @mbg.generated
     */
    private Integer deliveryType;

    /**
     * 配送人
     *
     * @mbg.generated
     */
    private String deliveryPerson;

    /**
     * 配送人电话
     *
     * @mbg.generated
     */
    private String deliveryPhone;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String remark;

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
     * 修改时间
     *
     * @mbg.generated
     */
    private Date modifyTime;

    /**
     * 修改人
     *
     * @mbg.generated
     */
    private String modifier;

    private static final long serialVersionUID = 1L;

    /**
     * <br/>
     * 返回值对应的表列名 client_order_logistics.id
     *
     * @return 返回值对应 client_order_logistics.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * <br/>
     * client_order_logistics.id
     *
     * @param id 值对应 client_order_logistics.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 关联的订单编号<br/>
     * 返回值对应的表列名 client_order_logistics.order_code
     *
     * @return 返回值对应 client_order_logistics.order_code
     *
     * @mbg.generated
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * 关联的订单编号<br/>
     * client_order_logistics.order_code
     *
     * @param orderCode 值对应 client_order_logistics.order_code
     *
     * @mbg.generated
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    /**
     * 快递公司id<br/>
     * 返回值对应的表列名 client_order_logistics.express_company_id
     *
     * @return 返回值对应 client_order_logistics.express_company_id
     *
     * @mbg.generated
     */
    public Integer getExpressCompanyId() {
        return expressCompanyId;
    }

    /**
     * 快递公司id<br/>
     * client_order_logistics.express_company_id
     *
     * @param expressCompanyId 值对应 client_order_logistics.express_company_id
     *
     * @mbg.generated
     */
    public void setExpressCompanyId(Integer expressCompanyId) {
        this.expressCompanyId = expressCompanyId;
    }

    /**
     * 单号<br/>
     * 返回值对应的表列名 client_order_logistics.number
     *
     * @return 返回值对应 client_order_logistics.number
     *
     * @mbg.generated
     */
    public String getNumber() {
        return number;
    }

    /**
     * 单号<br/>
     * client_order_logistics.number
     *
     * @param number 值对应 client_order_logistics.number
     *
     * @mbg.generated
     */
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    /**
     * 配送方式 0快递 1自送<br/>
     * 返回值对应的表列名 client_order_logistics.delivery_type
     *
     * @return 返回值对应 client_order_logistics.delivery_type
     *
     * @mbg.generated
     */
    public Integer getDeliveryType() {
        return deliveryType;
    }

    /**
     * 配送方式 0快递 1自送<br/>
     * client_order_logistics.delivery_type
     *
     * @param deliveryType 值对应 client_order_logistics.delivery_type
     *
     * @mbg.generated
     */
    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }

    /**
     * 配送人<br/>
     * 返回值对应的表列名 client_order_logistics.delivery_person
     *
     * @return 返回值对应 client_order_logistics.delivery_person
     *
     * @mbg.generated
     */
    public String getDeliveryPerson() {
        return deliveryPerson;
    }

    /**
     * 配送人<br/>
     * client_order_logistics.delivery_person
     *
     * @param deliveryPerson 值对应 client_order_logistics.delivery_person
     *
     * @mbg.generated
     */
    public void setDeliveryPerson(String deliveryPerson) {
        this.deliveryPerson = deliveryPerson == null ? null : deliveryPerson.trim();
    }

    /**
     * 配送人电话<br/>
     * 返回值对应的表列名 client_order_logistics.delivery_phone
     *
     * @return 返回值对应 client_order_logistics.delivery_phone
     *
     * @mbg.generated
     */
    public String getDeliveryPhone() {
        return deliveryPhone;
    }

    /**
     * 配送人电话<br/>
     * client_order_logistics.delivery_phone
     *
     * @param deliveryPhone 值对应 client_order_logistics.delivery_phone
     *
     * @mbg.generated
     */
    public void setDeliveryPhone(String deliveryPhone) {
        this.deliveryPhone = deliveryPhone == null ? null : deliveryPhone.trim();
    }

    /**
     * 备注<br/>
     * 返回值对应的表列名 client_order_logistics.remark
     *
     * @return 返回值对应 client_order_logistics.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注<br/>
     * client_order_logistics.remark
     *
     * @param remark 值对应 client_order_logistics.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 创建时间<br/>
     * 返回值对应的表列名 client_order_logistics.create_time
     *
     * @return 返回值对应 client_order_logistics.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间<br/>
     * client_order_logistics.create_time
     *
     * @param createTime 值对应 client_order_logistics.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 创建人<br/>
     * 返回值对应的表列名 client_order_logistics.creator
     *
     * @return 返回值对应 client_order_logistics.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人<br/>
     * client_order_logistics.creator
     *
     * @param creator 值对应 client_order_logistics.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 修改时间<br/>
     * 返回值对应的表列名 client_order_logistics.modify_time
     *
     * @return 返回值对应 client_order_logistics.modify_time
     *
     * @mbg.generated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 修改时间<br/>
     * client_order_logistics.modify_time
     *
     * @param modifyTime 值对应 client_order_logistics.modify_time
     *
     * @mbg.generated
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 修改人<br/>
     * 返回值对应的表列名 client_order_logistics.modifier
     *
     * @return 返回值对应 client_order_logistics.modifier
     *
     * @mbg.generated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人<br/>
     * client_order_logistics.modifier
     *
     * @param modifier 值对应 client_order_logistics.modifier
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
        ClientOrderLogistics other = (ClientOrderLogistics) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderCode() == null ? other.getOrderCode() == null : this.getOrderCode().equals(other.getOrderCode()))
            && (this.getExpressCompanyId() == null ? other.getExpressCompanyId() == null : this.getExpressCompanyId().equals(other.getExpressCompanyId()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getDeliveryType() == null ? other.getDeliveryType() == null : this.getDeliveryType().equals(other.getDeliveryType()))
            && (this.getDeliveryPerson() == null ? other.getDeliveryPerson() == null : this.getDeliveryPerson().equals(other.getDeliveryPerson()))
            && (this.getDeliveryPhone() == null ? other.getDeliveryPhone() == null : this.getDeliveryPhone().equals(other.getDeliveryPhone()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderCode() == null) ? 0 : getOrderCode().hashCode());
        result = prime * result + ((getExpressCompanyId() == null) ? 0 : getExpressCompanyId().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getDeliveryType() == null) ? 0 : getDeliveryType().hashCode());
        result = prime * result + ((getDeliveryPerson() == null) ? 0 : getDeliveryPerson().hashCode());
        result = prime * result + ((getDeliveryPhone() == null) ? 0 : getDeliveryPhone().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
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
        sb.append(", orderCode=").append(orderCode);
        sb.append(", expressCompanyId=").append(expressCompanyId);
        sb.append(", number=").append(number);
        sb.append(", deliveryType=").append(deliveryType);
        sb.append(", deliveryPerson=").append(deliveryPerson);
        sb.append(", deliveryPhone=").append(deliveryPhone);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", creator=").append(creator);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifier=").append(modifier);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}