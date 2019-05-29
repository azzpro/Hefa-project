package com.hefa.order.pojo.yeepay;

import java.io.Serializable;

/**
* 商户订单信息
* @author guoyx
* @date:Jun 24, 2013 3:25:29 PM
* @version :1.0
*
*/
public class OrderInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    private String            orderId;             // 商户唯一订单号
    private String            requestDate;             // 商户下单时间
    private String            goodsName;           // 商品名称
    private String            goodsDesc;           // 商品描述
    private String            orderAmount;          // 交易金额 单位为RMB-元
    private String 			  userNo;
    private String            userType;
    private String            timestamp;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
	public String getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", requestDate=" + requestDate + ", goodsName=" + goodsName
				+ ", goodsDesc=" + goodsDesc + ", orderAmount=" + orderAmount + ", userNo=" + userNo + ", userType="
				+ userType + ", timestamp=" + timestamp + "]";
	}


}
