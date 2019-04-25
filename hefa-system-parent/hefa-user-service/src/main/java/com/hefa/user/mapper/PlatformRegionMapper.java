package com.hefa.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.user.pojo.PlatformRegion;
import com.hefa.user.pojo.bo.RegionUserParam;
import com.hefa.user.pojo.vo.RegionUserInfo;

@Mapper
public interface PlatformRegionMapper {
	
	String selectUserCodeByArea(String name);
	
	/**
	 * 获取售后区域列表
	 * @return
	 */
	List<RegionUserInfo> getRegionList(RegionUserParam param);
	
	/**
	 * 保存区域
	 * @param pr
	 * @return
	 */
	int insertRegion(PlatformRegion pr);
	
	/**
	 * 修改+
	 * @param pr
	 * @return
	 */
	int updateRegion(PlatformRegion pr);
	
	/**
	 * 删除+
	 * @param pr
	 * @return
	 */
	int deleteRegion(Long id);
}
