package com.hefa.user.pojo.bo;

import org.hibernate.validator.constraints.NotBlank;

public class RegionAdd {
	@NotBlank(message="成员编码不能为空")
	private String platfromUserCode;//平台用户CODE
	@NotBlank(message="区域不能为空")
	private String regionArea;//区域 区
	public String getPlatfromUserCode() {
		return platfromUserCode;
	}
	public void setPlatfromUserCode(String platfromUserCode) {
		this.platfromUserCode = platfromUserCode;
	}
	public String getRegionArea() {
		return regionArea;
	}
	public void setRegionArea(String regionArea) {
		this.regionArea = regionArea;
	}
	
}
