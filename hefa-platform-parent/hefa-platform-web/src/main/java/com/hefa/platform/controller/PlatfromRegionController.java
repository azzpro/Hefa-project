package com.hefa.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.common.base.JsonResult;
import com.hefa.common.exception.ValidationException;
import com.hefa.common.page.Pagination;
import com.hefa.user.api.PlatfromRegionService;
import com.hefa.user.pojo.bo.RegionAdd;
import com.hefa.user.pojo.bo.RegionUserParam;
import com.hefa.user.pojo.vo.RegionUserInfo;
import com.hefa.utils.JSR303ValidateUtils;

/**
 * @author THINK
 * 区域管理
 */
@RestController
@RequestMapping("/hefa/api/region")
public class PlatfromRegionController {

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
	public JsonResult<Pagination<RegionUserInfo>> getRegionList( RegionUserParam param){
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
	public JsonResult<String> addRegion( RegionAdd regionAdd){
		JSR303ValidateUtils.validateInputParam(regionAdd);
		return platfromRegionService.addRegion(regionAdd);
	}
	
	/**
	 * 
	 * <p>售后区域变更 人员变更</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/updateRegionchange")
	public JsonResult<String> updateRegionchange( RegionAdd regionAdd){
		JSR303ValidateUtils.validateInputParam(regionAdd);
		return platfromRegionService.updateRegionchange(regionAdd);
	}
	
	/**
	 * 
	 * <p>售后区域变更 人员变更</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/deleteRegion")
	public JsonResult<String> deleteRegion( Long id){
		if(id == null) {
			throw new ValidationException("输入参数为空");
		}
		return platfromRegionService.deleteRegion(id);
	}
}
