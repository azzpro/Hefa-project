package com.hefa.order.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientInvoice implements Serializable {
    /**
     * id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 开票编码
     *
     * @mbg.generated
     */
    private String invoiceCode;

    /**
     * 关联客户的用户编码
     *
     * @mbg.generated
     */
    private String userCode;

    /**
     * 关联客户订单编码
     *
     * @mbg.generated
     */
    private String orderCode;

    /**
     * 关联开票模板编码
     *
     * @mbg.generated
     */
    private String invoiceTemplateCode;

    /**
     * 关联订单的配送地址编码
     *
     * @mbg.generated
     */
    private String shippingAddressCode;

    /**
     * 开票金额
     *
     * @mbg.generated
     */
    private BigDecimal amount;

    /**
     * 开票数量
     *
     * @mbg.generated
     */
    private Integer quantity;

    /**
     * 状态（0 待审批 1 待开票 2 待签收 3 已拒绝 4 已完成 5 已取消）
     *
     * @mbg.generated
     */
    private Byte invoiceStatus;
    
    private String remark;

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
     * 返回值对应的表列名 client_invoice.id
     *
     * @return 返回值对应 client_invoice.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * id<br/>
     * client_invoice.id
     *
     * @param id 值对应 client_invoice.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 开票编码<br/>
     * 返回值对应的表列名 client_invoice.invoice_code
     *
     * @return 返回值对应 client_invoice.invoice_code
     *
     * @mbg.generated
     */
    public String getInvoiceCode() {
        return invoiceCode;
    }

    /**
     * 开票编码<br/>
     * client_invoice.invoice_code
     *
     * @param invoiceCode 值对应 client_invoice.invoice_code
     *
     * @mbg.generated
     */
    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode == null ? null : invoiceCode.trim();
    }

    /**
     * 关联客户的用户编码<br/>
     * 返回值对应的表列名 client_invoice.user_code
     *
     * @return 返回值对应 client_invoice.user_code
     *
     * @mbg.generated
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * 关联客户的用户编码<br/>
     * client_invoice.user_code
     *
     * @param userCode 值对应 client_invoice.user_code
     *
     * @mbg.generated
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    /**
     * 关联客户订单编码<br/>
     * 返回值对应的表列名 client_invoice.order_code
     *
     * @return 返回值对应 client_invoice.order_code
     *
     * @mbg.generated
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * 关联客户订单编码<br/>
     * client_invoice.order_code
     *
     * @param orderCode 值对应 client_invoice.order_code
     *
     * @mbg.generated
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    /**
     * 关联开票模板编码<br/>
     * 返回值对应的表列名 client_invoice.invoice_template_code
     *
     * @return 返回值对应 client_invoice.invoice_template_code
     *
     * @mbg.generated
     */
    public String getInvoiceTemplateCode() {
        return invoiceTemplateCode;
    }

    /**
     * 关联开票模板编码<br/>
     * client_invoice.invoice_template_code
     *
     * @param invoiceTemplateCode 值对应 client_invoice.invoice_template_code
     *
     * @mbg.generated
     */
    public void setInvoiceTemplateCode(String invoiceTemplateCode) {
        this.invoiceTemplateCode = invoiceTemplateCode == null ? null : invoiceTemplateCode.trim();
    }

    /**
     * 关联订单的配送地址编码<br/>
     * 返回值对应的表列名 client_invoice.shipping_address_code
     *
     * @return 返回值对应 client_invoice.shipping_address_code
     *
     * @mbg.generated
     */
    public String getShippingAddressCode() {
        return shippingAddressCode;
    }

    /**
     * 关联订单的配送地址编码<br/>
     * client_invoice.shipping_address_code
     *
     * @param shippingAddressCode 值对应 client_invoice.shipping_address_code
     *
     * @mbg.generated
     */
    public void setShippingAddressCode(String shippingAddressCode) {
        this.shippingAddressCode = shippingAddressCode == null ? null : shippingAddressCode.trim();
    }

    /**
     * 开票金额<br/>
     * 返回值对应的表列名 client_invoice.amount
     *
     * @return 返回值对应 client_invoice.amount
     *
     * @mbg.generated
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 开票金额<br/>
     * client_invoice.amount
     *
     * @param amount 值对应 client_invoice.amount
     *
     * @mbg.generated
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 开票数量<br/>
     * 返回值对应的表列名 client_invoice.quantity
     *
     * @return 返回值对应 client_invoice.quantity
     *
     * @mbg.generated
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 开票数量<br/>
     * client_invoice.quantity
     *
     * @param quantity 值对应 client_invoice.quantity
     *
     * @mbg.generated
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * 状态（0 待审批 1 待开票 2 待签收 3 已拒绝 4 已完成 5 已取消）<br/>
     * 返回值对应的表列名 client_invoice.invoice_status
     *
     * @return 返回值对应 client_invoice.invoice_status
     *
     * @mbg.generated
     */
    public Byte getInvoiceStatus() {
        return invoiceStatus;
    }

    /**
     * 状态（0 待审批 1 待开票 2 待签收 3 已拒绝 4 已完成 5 已取消）<br/>
     * client_invoice.invoice_status
     *
     * @param invoiceStatus 值对应 client_invoice.invoice_status
     *
     * @mbg.generated
     */
    public void setInvoiceStatus(Byte invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    /**
     * 创建人<br/>
     * 返回值对应的表列名 client_invoice.creator
     *
     * @return 返回值对应 client_invoice.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人<br/>
     * client_invoice.creator
     *
     * @param creator 值对应 client_invoice.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 创建时间<br/>
     * 返回值对应的表列名 client_invoice.create_time
     *
     * @return 返回值对应 client_invoice.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间<br/>
     * client_invoice.create_time
     *
     * @param createTime 值对应 client_invoice.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改人<br/>
     * 返回值对应的表列名 client_invoice.modifier
     *
     * @return 返回值对应 client_invoice.modifier
     *
     * @mbg.generated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人<br/>
     * client_invoice.modifier
     *
     * @param modifier 值对应 client_invoice.modifier
     *
     * @mbg.generated
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 最后修改时间<br/>
     * 返回值对应的表列名 client_invoice.modify_time
     *
     * @return 返回值对应 client_invoice.modify_time
     *
     * @mbg.generated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 最后修改时间<br/>
     * client_invoice.modify_time
     *
     * @param modifyTime 值对应 client_invoice.modify_time
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
        ClientInvoice other = (ClientInvoice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInvoiceCode() == null ? other.getInvoiceCode() == null : this.getInvoiceCode().equals(other.getInvoiceCode()))
            && (this.getUserCode() == null ? other.getUserCode() == null : this.getUserCode().equals(other.getUserCode()))
            && (this.getOrderCode() == null ? other.getOrderCode() == null : this.getOrderCode().equals(other.getOrderCode()))
            && (this.getInvoiceTemplateCode() == null ? other.getInvoiceTemplateCode() == null : this.getInvoiceTemplateCode().equals(other.getInvoiceTemplateCode()))
            && (this.getShippingAddressCode() == null ? other.getShippingAddressCode() == null : this.getShippingAddressCode().equals(other.getShippingAddressCode()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()))
            && (this.getInvoiceStatus() == null ? other.getInvoiceStatus() == null : this.getInvoiceStatus().equals(other.getInvoiceStatus()))
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
        result = prime * result + ((getUserCode() == null) ? 0 : getUserCode().hashCode());
        result = prime * result + ((getOrderCode() == null) ? 0 : getOrderCode().hashCode());
        result = prime * result + ((getInvoiceTemplateCode() == null) ? 0 : getInvoiceTemplateCode().hashCode());
        result = prime * result + ((getShippingAddressCode() == null) ? 0 : getShippingAddressCode().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
        result = prime * result + ((getInvoiceStatus() == null) ? 0 : getInvoiceStatus().hashCode());
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
        sb.append(", userCode=").append(userCode);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", invoiceTemplateCode=").append(invoiceTemplateCode);
        sb.append(", shippingAddressCode=").append(shippingAddressCode);
        sb.append(", amount=").append(amount);
        sb.append(", quantity=").append(quantity);
        sb.append(", invoiceStatus=").append(invoiceStatus);
        sb.append(", creator=").append(creator);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}