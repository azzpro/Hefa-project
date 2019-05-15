package com.hefa.order.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.hefa.order.pojo.ClientOrderLogistics.ClientOrderLogisticsBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientOrder implements Serializable {
    /**
     * 主键id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 客户订单编号
     *
     * @mbg.generated
     */
    private String orderCode;

    /**
     * 客户编码
     *
     * @mbg.generated
     */
    private String userCode;

    /**
     * 业务员编码（推荐人）
     *
     * @mbg.generated
     */
    private String salesmanCode;

    /**
     * 配送地址编码
     *
     * @mbg.generated
     */
    private String shippingAddressCode;

    /**
     * 下单人名称
     *
     * @mbg.generated
     */
    private String orderCreator;

    /**
     * 交期（天）
     *
     * @mbg.generated
     */
    private Integer deliveryDays;

    /**
     * 订单金额
     *
     * @mbg.generated
     */
    private BigDecimal grandTotal;

    /**
     * 下单的产品数量
     *
     * @mbg.generated
     */
    private Integer productCount;

    /**
     * 订单状态id
     *
     * @mbg.generated
     */
    private Byte orderStatus;

    /**
     * 支付方式 1在线支付  2线下支付
     *
     * @mbg.generated
     */
    private Byte paymentMethod;

    /**
     * 支付状态 1待支付    2支付成功 3支付关闭 4支付失败
     *
     * @mbg.generated
     */
    private Byte paymentStatus;

    /**
     * 支付类型  1微信   2支付宝  3其他 
     *
     * @mbg.generated
     */
    private Byte paymentType;

    /**
     * 开票状态 0未开票  1已开票
     *
     * @mbg.generated
     */
    private Byte invoiceStatus;

    /**
     * 订单备注
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * 状态 0无效 1有效
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
     * 最后修改时间
     *
     * @mbg.generated
     */
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    /**
     * 主键id<br/>
     * 返回值对应的表列名 client_order.id
     *
     * @return 返回值对应 client_order.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id<br/>
     * client_order.id
     *
     * @param id 值对应 client_order.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 客户订单编号<br/>
     * 返回值对应的表列名 client_order.order_code
     *
     * @return 返回值对应 client_order.order_code
     *
     * @mbg.generated
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * 客户订单编号<br/>
     * client_order.order_code
     *
     * @param orderCode 值对应 client_order.order_code
     *
     * @mbg.generated
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    /**
     * 客户id<br/>
     * 返回值对应的表列名 client_order.user_code
     *
     * @return 返回值对应 client_order.user_code
     *
     * @mbg.generated
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * 客户id<br/>
     * client_order.user_code
     *
     * @param userCode 值对应 client_order.user_code
     *
     * @mbg.generated
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    /**
     * 业务员编码（推荐人）<br/>
     * 返回值对应的表列名 client_order.salesman_code
     *
     * @return 返回值对应 client_order.salesman_code
     *
     * @mbg.generated
     */
    public String getSalesmanCode() {
        return salesmanCode;
    }

    /**
     * 业务员编码（推荐人）<br/>
     * client_order.salesman_code
     *
     * @param salesmanCode 值对应 client_order.salesman_code
     *
     * @mbg.generated
     */
    public void setSalesmanCode(String salesmanCode) {
        this.salesmanCode = salesmanCode == null ? null : salesmanCode.trim();
    }

    /**
     * 配送地址编码<br/>
     * 返回值对应的表列名 client_order.order_shipping_code
     *
     * @return 返回值对应 client_order.order_shipping_code
     *
     * @mbg.generated
     */
    public String getShippingAddressCode() {
        return shippingAddressCode;
    }

    /**
     * 配送地址编码<br/>
     * client_order.order_shipping_code
     *
     * @param orderShippingCode 值对应 client_order.order_shipping_code
     *
     * @mbg.generated
     */
    public void setShippingAddressCode(String shippingAddressCode) {
        this.shippingAddressCode = shippingAddressCode == null ? null : shippingAddressCode.trim();
    }

    /**
     * 下单人名称<br/>
     * 返回值对应的表列名 client_order.order_creator
     *
     * @return 返回值对应 client_order.order_creator
     *
     * @mbg.generated
     */
    public String getOrderCreator() {
        return orderCreator;
    }

    /**
     * 下单人名称<br/>
     * client_order.order_creator
     *
     * @param orderCreator 值对应 client_order.order_creator
     *
     * @mbg.generated
     */
    public void setOrderCreator(String orderCreator) {
        this.orderCreator = orderCreator == null ? null : orderCreator.trim();
    }

    /**
     * 交期（天）<br/>
     * 返回值对应的表列名 client_order.delivery_days
     *
     * @return 返回值对应 client_order.delivery_days
     *
     * @mbg.generated
     */
    public Integer getDeliveryDays() {
        return deliveryDays;
    }

    /**
     * 交期（天）<br/>
     * client_order.delivery_days
     *
     * @param deliveryDays 值对应 client_order.delivery_days
     *
     * @mbg.generated
     */
    public void setDeliveryDays(Integer deliveryDays) {
        this.deliveryDays = deliveryDays;
    }

    /**
     * 订单金额<br/>
     * 返回值对应的表列名 client_order.grand_total
     *
     * @return 返回值对应 client_order.grand_total
     *
     * @mbg.generated
     */
    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    /**
     * 订单金额<br/>
     * client_order.grand_total
     *
     * @param grandTotal 值对应 client_order.grand_total
     *
     * @mbg.generated
     */
    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }

    /**
     * 下单的产品数量<br/>
     * 返回值对应的表列名 client_order.product_count
     *
     * @return 返回值对应 client_order.product_count
     *
     * @mbg.generated
     */
    public Integer getProductCount() {
        return productCount;
    }

    /**
     * 下单的产品数量<br/>
     * client_order.product_count
     *
     * @param productCount 值对应 client_order.product_count
     *
     * @mbg.generated
     */
    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    /**
     * 订单状态id<br/>
     * 返回值对应的表列名 client_order.order_status
     *
     * @return 返回值对应 client_order.order_status
     *
     * @mbg.generated
     */
    public Byte getOrderStatus() {
        return orderStatus;
    }

    /**
     * 订单状态id<br/>
     * client_order.order_status
     *
     * @param orderStatus 值对应 client_order.order_status
     *
     * @mbg.generated
     */
    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 支付方式 1在线支付  2线下支付<br/>
     * 返回值对应的表列名 client_order.payment_method
     *
     * @return 返回值对应 client_order.payment_method
     *
     * @mbg.generated
     */
    public Byte getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * 支付方式 1在线支付  2线下支付<br/>
     * client_order.payment_method
     *
     * @param paymentMethod 值对应 client_order.payment_method
     *
     * @mbg.generated
     */
    public void setPaymentMethod(Byte paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * 支付状态 1待支付    2支付成功 3支付关闭 4支付失败<br/>
     * 返回值对应的表列名 client_order.payment_status
     *
     * @return 返回值对应 client_order.payment_status
     *
     * @mbg.generated
     */
    public Byte getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * 支付状态 1待支付    2支付成功 3支付关闭 4支付失败<br/>
     * client_order.payment_status
     *
     * @param paymentStatus 值对应 client_order.payment_status
     *
     * @mbg.generated
     */
    public void setPaymentStatus(Byte paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    /**
     * 支付类型  1微信   2支付宝  3其他 <br/>
     * 返回值对应的表列名 client_order.payment_type
     *
     * @return 返回值对应 client_order.payment_type
     *
     * @mbg.generated
     */
    public Byte getPaymentType() {
        return paymentType;
    }

    /**
     * 支付类型  1微信   2支付宝  3其他 <br/>
     * client_order.payment_type
     *
     * @param paymentType 值对应 client_order.payment_type
     *
     * @mbg.generated
     */
    public void setPaymentType(Byte paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * 开票状态 0未开票  1已开票<br/>
     * 返回值对应的表列名 client_order.invoice_status
     *
     * @return 返回值对应 client_order.invoice_status
     *
     * @mbg.generated
     */
    public Byte getInvoiceStatus() {
        return invoiceStatus;
    }

    /**
     * 开票状态 0未开票  1已开票<br/>
     * client_order.invoice_status
     *
     * @param invoiceStatus 值对应 client_order.invoice_status
     *
     * @mbg.generated
     */
    public void setInvoiceStatus(Byte invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    /**
     * 订单备注<br/>
     * 返回值对应的表列名 client_order.remark
     *
     * @return 返回值对应 client_order.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 订单备注<br/>
     * client_order.remark
     *
     * @param remark 值对应 client_order.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 状态 0无效 1有效<br/>
     * 返回值对应的表列名 client_order.status
     *
     * @return 返回值对应 client_order.status
     *
     * @mbg.generated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 状态 0无效 1有效<br/>
     * client_order.status
     *
     * @param status 值对应 client_order.status
     *
     * @mbg.generated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 创建人<br/>
     * 返回值对应的表列名 client_order.creator
     *
     * @return 返回值对应 client_order.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人<br/>
     * client_order.creator
     *
     * @param creator 值对应 client_order.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 创建时间<br/>
     * 返回值对应的表列名 client_order.create_time
     *
     * @return 返回值对应 client_order.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间<br/>
     * client_order.create_time
     *
     * @param createTime 值对应 client_order.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改人<br/>
     * 返回值对应的表列名 client_order.modifier
     *
     * @return 返回值对应 client_order.modifier
     *
     * @mbg.generated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人<br/>
     * client_order.modifier
     *
     * @param modifier 值对应 client_order.modifier
     *
     * @mbg.generated
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 最后修改时间<br/>
     * 返回值对应的表列名 client_order.modify_time
     *
     * @return 返回值对应 client_order.modify_time
     *
     * @mbg.generated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 最后修改时间<br/>
     * client_order.modify_time
     *
     * @param modifyTime 值对应 client_order.modify_time
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
        ClientOrder other = (ClientOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderCode() == null ? other.getOrderCode() == null : this.getOrderCode().equals(other.getOrderCode()))
            && (this.getUserCode() == null ? other.getUserCode() == null : this.getUserCode().equals(other.getUserCode()))
            && (this.getSalesmanCode() == null ? other.getSalesmanCode() == null : this.getSalesmanCode().equals(other.getSalesmanCode()))
            && (this.getShippingAddressCode() == null ? other.getShippingAddressCode() == null : this.getShippingAddressCode().equals(other.getShippingAddressCode()))
            && (this.getOrderCreator() == null ? other.getOrderCreator() == null : this.getOrderCreator().equals(other.getOrderCreator()))
            && (this.getDeliveryDays() == null ? other.getDeliveryDays() == null : this.getDeliveryDays().equals(other.getDeliveryDays()))
            && (this.getGrandTotal() == null ? other.getGrandTotal() == null : this.getGrandTotal().equals(other.getGrandTotal()))
            && (this.getProductCount() == null ? other.getProductCount() == null : this.getProductCount().equals(other.getProductCount()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getPaymentMethod() == null ? other.getPaymentMethod() == null : this.getPaymentMethod().equals(other.getPaymentMethod()))
            && (this.getPaymentStatus() == null ? other.getPaymentStatus() == null : this.getPaymentStatus().equals(other.getPaymentStatus()))
            && (this.getPaymentType() == null ? other.getPaymentType() == null : this.getPaymentType().equals(other.getPaymentType()))
            && (this.getInvoiceStatus() == null ? other.getInvoiceStatus() == null : this.getInvoiceStatus().equals(other.getInvoiceStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
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
        result = prime * result + ((getOrderCode() == null) ? 0 : getOrderCode().hashCode());
        result = prime * result + ((getUserCode() == null) ? 0 : getUserCode().hashCode());
        result = prime * result + ((getSalesmanCode() == null) ? 0 : getSalesmanCode().hashCode());
        result = prime * result + ((getShippingAddressCode() == null) ? 0 : getShippingAddressCode().hashCode());
        result = prime * result + ((getOrderCreator() == null) ? 0 : getOrderCreator().hashCode());
        result = prime * result + ((getDeliveryDays() == null) ? 0 : getDeliveryDays().hashCode());
        result = prime * result + ((getGrandTotal() == null) ? 0 : getGrandTotal().hashCode());
        result = prime * result + ((getProductCount() == null) ? 0 : getProductCount().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getPaymentMethod() == null) ? 0 : getPaymentMethod().hashCode());
        result = prime * result + ((getPaymentStatus() == null) ? 0 : getPaymentStatus().hashCode());
        result = prime * result + ((getPaymentType() == null) ? 0 : getPaymentType().hashCode());
        result = prime * result + ((getInvoiceStatus() == null) ? 0 : getInvoiceStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
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
        sb.append(", orderCode=").append(orderCode);
        sb.append(", userCode=").append(userCode);
        sb.append(", salesmanCode=").append(salesmanCode);
        sb.append(", shippingAddressCode=").append(shippingAddressCode);
        sb.append(", orderCreator=").append(orderCreator);
        sb.append(", deliveryDays=").append(deliveryDays);
        sb.append(", grandTotal=").append(grandTotal);
        sb.append(", productCount=").append(productCount);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", paymentMethod=").append(paymentMethod);
        sb.append(", paymentStatus=").append(paymentStatus);
        sb.append(", paymentType=").append(paymentType);
        sb.append(", invoiceStatus=").append(invoiceStatus);
        sb.append(", remark=").append(remark);
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