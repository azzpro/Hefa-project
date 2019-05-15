package com.hefa.order.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientOrderItem implements Serializable {
    /**
     * 主键id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 订单编码
     *
     * @mbg.generated
     */
    private String orderCode;

    /**
     * 所属产品编码
     *
     * @mbg.generated
     */
    private String productCode;
    
    private String productName;

    /**
     * 产品参数名称
     *
     * @mbg.generated
     */
    private String specificationInfo;

    /**
     * 商品价格
     *
     * @mbg.generated
     */
    private BigDecimal productPrice;

    /**
     * 下单数量
     *
     * @mbg.generated
     */
    private Integer quantity;

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
     * 返回值对应的表列名 client_order_item.id
     *
     * @return 返回值对应 client_order_item.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id<br/>
     * client_order_item.id
     *
     * @param id 值对应 client_order_item.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 订单编码<br/>
     * 返回值对应的表列名 client_order_item.order_code
     *
     * @return 返回值对应 client_order_item.order_code
     *
     * @mbg.generated
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * 订单编码<br/>
     * client_order_item.order_code
     *
     * @param orderCode 值对应 client_order_item.order_code
     *
     * @mbg.generated
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    /**
     * 所属产品编码<br/>
     * 返回值对应的表列名 client_order_item.product_code
     *
     * @return 返回值对应 client_order_item.product_code
     *
     * @mbg.generated
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * 所属产品编码<br/>
     * client_order_item.product_code
     *
     * @param productCode 值对应 client_order_item.product_code
     *
     * @mbg.generated
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    /**
     * 产品参数名称<br/>
     * 返回值对应的表列名 client_order_item.specification_info
     *
     * @return 返回值对应 client_order_item.specification_info
     *
     * @mbg.generated
     */
    public String getSpecificationInfo() {
        return specificationInfo;
    }

    /**
     * 产品参数名称<br/>
     * client_order_item.specification_info
     *
     * @param specificationInfo 值对应 client_order_item.specification_info
     *
     * @mbg.generated
     */
    public void setSpecificationInfo(String specificationInfo) {
        this.specificationInfo = specificationInfo == null ? null : specificationInfo.trim();
    }

    /**
     * 商品价格<br/>
     * 返回值对应的表列名 client_order_item.product_price
     *
     * @return 返回值对应 client_order_item.product_price
     *
     * @mbg.generated
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * 商品价格<br/>
     * client_order_item.product_price
     *
     * @param productPrice 值对应 client_order_item.product_price
     *
     * @mbg.generated
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * 下单数量<br/>
     * 返回值对应的表列名 client_order_item.quantity
     *
     * @return 返回值对应 client_order_item.quantity
     *
     * @mbg.generated
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 下单数量<br/>
     * client_order_item.quantity
     *
     * @param quantity 值对应 client_order_item.quantity
     *
     * @mbg.generated
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * 创建人<br/>
     * 返回值对应的表列名 client_order_item.creator
     *
     * @return 返回值对应 client_order_item.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人<br/>
     * client_order_item.creator
     *
     * @param creator 值对应 client_order_item.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 创建时间<br/>
     * 返回值对应的表列名 client_order_item.create_time
     *
     * @return 返回值对应 client_order_item.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间<br/>
     * client_order_item.create_time
     *
     * @param createTime 值对应 client_order_item.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改人<br/>
     * 返回值对应的表列名 client_order_item.modifier
     *
     * @return 返回值对应 client_order_item.modifier
     *
     * @mbg.generated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人<br/>
     * client_order_item.modifier
     *
     * @param modifier 值对应 client_order_item.modifier
     *
     * @mbg.generated
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 最后修改时间<br/>
     * 返回值对应的表列名 client_order_item.modify_time
     *
     * @return 返回值对应 client_order_item.modify_time
     *
     * @mbg.generated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 最后修改时间<br/>
     * client_order_item.modify_time
     *
     * @param modifyTime 值对应 client_order_item.modify_time
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
        ClientOrderItem other = (ClientOrderItem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderCode() == null ? other.getOrderCode() == null : this.getOrderCode().equals(other.getOrderCode()))
            && (this.getProductCode() == null ? other.getProductCode() == null : this.getProductCode().equals(other.getProductCode()))
            && (this.getSpecificationInfo() == null ? other.getSpecificationInfo() == null : this.getSpecificationInfo().equals(other.getSpecificationInfo()))
            && (this.getProductPrice() == null ? other.getProductPrice() == null : this.getProductPrice().equals(other.getProductPrice()))
            && (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()))
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
        result = prime * result + ((getProductCode() == null) ? 0 : getProductCode().hashCode());
        result = prime * result + ((getSpecificationInfo() == null) ? 0 : getSpecificationInfo().hashCode());
        result = prime * result + ((getProductPrice() == null) ? 0 : getProductPrice().hashCode());
        result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
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
        sb.append(", productCode=").append(productCode);
        sb.append(", specificationInfo=").append(specificationInfo);
        sb.append(", productPrice=").append(productPrice);
        sb.append(", quantity=").append(quantity);
        sb.append(", creator=").append(creator);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}