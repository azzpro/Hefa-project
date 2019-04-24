package com.hefa.order.pojo;

import java.io.Serializable;
import java.util.Date;

public class ClientInvoiceLogistics implements Serializable {
    /**
     * id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 关联的发票编码
     *
     * @mbg.generated
     */
    private String invoiceCode;

    /**
     * 配送方式（0 快递 1 自送）
     *
     * @mbg.generated
     */
    private Byte deliveryType;

    /**
     * 快递公司id
     *
     * @mbg.generated
     */
    private Integer expressCompanyId;

    /**
     * 快递单号
     *
     * @mbg.generated
     */
    private String number;

    /**
     * 配送人
     *
     * @mbg.generated
     */
    private String deliveryPerson;

    /**
     * 配送手机号码
     *
     * @mbg.generated
     */
    private String deliveryPhone;

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
     * id<br/>
     * 返回值对应的表列名 client_invoice_logistics.id
     *
     * @return 返回值对应 client_invoice_logistics.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * id<br/>
     * client_invoice_logistics.id
     *
     * @param id 值对应 client_invoice_logistics.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 关联的发票编码<br/>
     * 返回值对应的表列名 client_invoice_logistics.invoice_code
     *
     * @return 返回值对应 client_invoice_logistics.invoice_code
     *
     * @mbg.generated
     */
    public String getInvoiceCode() {
        return invoiceCode;
    }

    /**
     * 关联的发票编码<br/>
     * client_invoice_logistics.invoice_code
     *
     * @param invoiceCode 值对应 client_invoice_logistics.invoice_code
     *
     * @mbg.generated
     */
    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode == null ? null : invoiceCode.trim();
    }

    /**
     * 配送方式（0 快递 1 自送）<br/>
     * 返回值对应的表列名 client_invoice_logistics.delivery_type
     *
     * @return 返回值对应 client_invoice_logistics.delivery_type
     *
     * @mbg.generated
     */
    public Byte getDeliveryType() {
        return deliveryType;
    }

    /**
     * 配送方式（0 快递 1 自送）<br/>
     * client_invoice_logistics.delivery_type
     *
     * @param deliveryType 值对应 client_invoice_logistics.delivery_type
     *
     * @mbg.generated
     */
    public void setDeliveryType(Byte deliveryType) {
        this.deliveryType = deliveryType;
    }

    /**
     * 快递公司id<br/>
     * 返回值对应的表列名 client_invoice_logistics.express_company_id
     *
     * @return 返回值对应 client_invoice_logistics.express_company_id
     *
     * @mbg.generated
     */
    public Integer getExpressCompanyId() {
        return expressCompanyId;
    }

    /**
     * 快递公司id<br/>
     * client_invoice_logistics.express_company_id
     *
     * @param expressCompanyId 值对应 client_invoice_logistics.express_company_id
     *
     * @mbg.generated
     */
    public void setExpressCompanyId(Integer expressCompanyId) {
        this.expressCompanyId = expressCompanyId;
    }

    /**
     * 快递单号<br/>
     * 返回值对应的表列名 client_invoice_logistics.number
     *
     * @return 返回值对应 client_invoice_logistics.number
     *
     * @mbg.generated
     */
    public String getNumber() {
        return number;
    }

    /**
     * 快递单号<br/>
     * client_invoice_logistics.number
     *
     * @param number 值对应 client_invoice_logistics.number
     *
     * @mbg.generated
     */
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    /**
     * 配送人<br/>
     * 返回值对应的表列名 client_invoice_logistics.delivery_person
     *
     * @return 返回值对应 client_invoice_logistics.delivery_person
     *
     * @mbg.generated
     */
    public String getDeliveryPerson() {
        return deliveryPerson;
    }

    /**
     * 配送人<br/>
     * client_invoice_logistics.delivery_person
     *
     * @param deliveryPerson 值对应 client_invoice_logistics.delivery_person
     *
     * @mbg.generated
     */
    public void setDeliveryPerson(String deliveryPerson) {
        this.deliveryPerson = deliveryPerson == null ? null : deliveryPerson.trim();
    }

    /**
     * 配送手机号码<br/>
     * 返回值对应的表列名 client_invoice_logistics.delivery_phone
     *
     * @return 返回值对应 client_invoice_logistics.delivery_phone
     *
     * @mbg.generated
     */
    public String getDeliveryPhone() {
        return deliveryPhone;
    }

    /**
     * 配送手机号码<br/>
     * client_invoice_logistics.delivery_phone
     *
     * @param deliveryPhone 值对应 client_invoice_logistics.delivery_phone
     *
     * @mbg.generated
     */
    public void setDeliveryPhone(String deliveryPhone) {
        this.deliveryPhone = deliveryPhone == null ? null : deliveryPhone.trim();
    }

    /**
     * 创建人<br/>
     * 返回值对应的表列名 client_invoice_logistics.creator
     *
     * @return 返回值对应 client_invoice_logistics.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人<br/>
     * client_invoice_logistics.creator
     *
     * @param creator 值对应 client_invoice_logistics.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 创建时间<br/>
     * 返回值对应的表列名 client_invoice_logistics.create_time
     *
     * @return 返回值对应 client_invoice_logistics.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间<br/>
     * client_invoice_logistics.create_time
     *
     * @param createTime 值对应 client_invoice_logistics.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改人<br/>
     * 返回值对应的表列名 client_invoice_logistics.modifier
     *
     * @return 返回值对应 client_invoice_logistics.modifier
     *
     * @mbg.generated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人<br/>
     * client_invoice_logistics.modifier
     *
     * @param modifier 值对应 client_invoice_logistics.modifier
     *
     * @mbg.generated
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 最后修改时间<br/>
     * 返回值对应的表列名 client_invoice_logistics.modify_time
     *
     * @return 返回值对应 client_invoice_logistics.modify_time
     *
     * @mbg.generated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 最后修改时间<br/>
     * client_invoice_logistics.modify_time
     *
     * @param modifyTime 值对应 client_invoice_logistics.modify_time
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
        ClientInvoiceLogistics other = (ClientInvoiceLogistics) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInvoiceCode() == null ? other.getInvoiceCode() == null : this.getInvoiceCode().equals(other.getInvoiceCode()))
            && (this.getDeliveryType() == null ? other.getDeliveryType() == null : this.getDeliveryType().equals(other.getDeliveryType()))
            && (this.getExpressCompanyId() == null ? other.getExpressCompanyId() == null : this.getExpressCompanyId().equals(other.getExpressCompanyId()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getDeliveryPerson() == null ? other.getDeliveryPerson() == null : this.getDeliveryPerson().equals(other.getDeliveryPerson()))
            && (this.getDeliveryPhone() == null ? other.getDeliveryPhone() == null : this.getDeliveryPhone().equals(other.getDeliveryPhone()))
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
        result = prime * result + ((getInvoiceCode() == null) ? 0 : getInvoiceCode().hashCode());
        result = prime * result + ((getDeliveryType() == null) ? 0 : getDeliveryType().hashCode());
        result = prime * result + ((getExpressCompanyId() == null) ? 0 : getExpressCompanyId().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getDeliveryPerson() == null) ? 0 : getDeliveryPerson().hashCode());
        result = prime * result + ((getDeliveryPhone() == null) ? 0 : getDeliveryPhone().hashCode());
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
        sb.append(", invoiceCode=").append(invoiceCode);
        sb.append(", deliveryType=").append(deliveryType);
        sb.append(", expressCompanyId=").append(expressCompanyId);
        sb.append(", number=").append(number);
        sb.append(", deliveryPerson=").append(deliveryPerson);
        sb.append(", deliveryPhone=").append(deliveryPhone);
        sb.append(", creator=").append(creator);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}