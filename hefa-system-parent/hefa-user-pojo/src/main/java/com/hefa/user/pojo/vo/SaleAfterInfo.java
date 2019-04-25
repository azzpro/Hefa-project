package com.hefa.user.pojo.vo;

import java.util.List;

import com.hefa.user.pojo.PlatformSaleDetail;

public class SaleAfterInfo {
	private String returnGoodsNumber;//退货单号
	private String returnGoodsStatus;//退货单状态
	private String returnGoodsMoney;//退货金额
	private String orderCode;//订单编码
	private String saleAfterMan;//售后专员
	private String userName;//用户姓名
	private String userPhone;//用户电话
	private String contactAddress;//联系地址
	private String remake;
	private String userCode;
	private String address;
	private List<PlatformSaleDetail> psds;
	private List<OrderItemInfo> oii;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public List<OrderItemInfo> getOii() {
		return oii;
	}
	public void setOii(List<OrderItemInfo> oii) {
		this.oii = oii;
	}
	public String getReturnGoodsNumber() {
		return returnGoodsNumber;
	}
	public void setReturnGoodsNumber(String returnGoodsNumber) {
		this.returnGoodsNumber = returnGoodsNumber;
	}
	public String getReturnGoodsStatus() {
		return returnGoodsStatus;
	}
	public void setReturnGoodsStatus(String returnGoodsStatus) {
		this.returnGoodsStatus = returnGoodsStatus;
	}
	public String getReturnGoodsMoney() {
		return returnGoodsMoney;
	}
	public void setReturnGoodsMoney(String returnGoodsMoney) {
		this.returnGoodsMoney = returnGoodsMoney;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getSaleAfterMan() {
		return saleAfterMan;
	}
	public void setSaleAfterMan(String saleAfterMan) {
		this.saleAfterMan = saleAfterMan;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	public String getRemake() {
		return remake;
	}
	public void setRemake(String remake) {
		this.remake = remake;
	}
	public List<PlatformSaleDetail> getPsds() {
		return psds;
	}
	public void setPsds(List<PlatformSaleDetail> psds) {
		this.psds = psds;
	}
	
	
}
