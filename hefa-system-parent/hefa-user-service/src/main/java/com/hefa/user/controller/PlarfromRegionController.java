package com.hefa.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.user.pojo.bo.RegionUserParam;
import com.hefa.user.pojo.vo.RegionUserInfo;
import com.hefa.user.service.PlatfromRegionService;

@RestController
@RequestMapping("/hefa/api/region/")
public class PlarfromRegionController {

	@Autowired
	private PlatfromRegionService platfromRegionService;
	
	/**
	 * 
	 * <p>查询售后区域列表</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/getRegionList")
	public JsonResult<Pagination<RegionUserInfo>> getRegionList(@RequestBody RegionUserParam param){
		return platfromRegionService.getRegionList(param);
	}
	
	/**
	 * 
	 * <p>添加售后区域</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/addRegion")
	public JsonResult<String> addRegion(@RequestParam("")){
		return platfromRegionService.getRegionList(param);
	}
}
