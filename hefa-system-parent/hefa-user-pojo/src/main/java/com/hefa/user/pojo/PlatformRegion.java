package com.hefa.user.pojo;

import java.util.Date;

public class PlatformRegion {
	private Long id;
	private String platfromUserCode;//平台用户CODE
	private String regionProvince;//区域省
	private String regionCity;//区域市
	private String regionArea;//区域 区
	private String regionCode;//区域售后专员编码
	private Date regionCreatime;//创建时间
	private Date regionModifytime;//修改时间
	private Byte status;//状态1 正常 2删除
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlatfromUserCode() {
		return platfromUserCode;
	}
	public void setPlatfromUserCode(String platfromUserCode) {
		this.platfromUserCode = platfromUserCode;
	}
	public String getRegionProvince() {
		return regionProvince;
	}
	public void setRegionProvince(String regionProvince) {
		this.regionProvince = regionProvince;
	}
	public String getRegionCity() {
		return regionCity;
	}
	public void setRegionCity(String regionCity) {
		this.regionCity = regionCity;
	}
	public String getRegionArea() {
		return regionArea;
	}
	public void setRegionArea(String regionArea) {
		this.regionArea = regionArea;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public Date getRegionCreatime() {
		return regionCreatime;
	}
	public void setRegionCreatime(Date regionCreatime) {
		this.regionCreatime = regionCreatime;
	}
	public Date getRegionModifytime() {
		return regionModifytime;
	}
	public void setRegionModifytime(Date regionModifytime) {
		this.regionModifytime = regionModifytime;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	
}
