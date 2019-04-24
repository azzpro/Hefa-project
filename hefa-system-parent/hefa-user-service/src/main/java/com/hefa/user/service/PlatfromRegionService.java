package com.hefa.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.pagehelper.PageHelper;
import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.user.mapper.PlatfromRegionMapper;
import com.hefa.user.pojo.bo.RegionUserParam;
import com.hefa.user.pojo.vo.RegionUserInfo;

@Service
public class PlatfromRegionService {

	@Autowired
	private PlatfromRegionMapper platfromRegionMapper;
	
	/**
	 * 获取区域列表数据
	 * @param param
	 * @return
	 */
	public JsonResult<Pagination<RegionUserInfo>> getRegionList(@RequestBody RegionUserParam param){
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		List<RegionUserInfo> list = platfromRegionMapper.getRegionList(param);
		return JsonResult.successJsonResult(new Pagination<>(list));
	}
}
