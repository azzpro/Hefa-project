package com.hefa.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.user.pojo.bo.RegionAdd;
import com.hefa.user.pojo.bo.RegionUserParam;
import com.hefa.user.pojo.vo.RegionUserInfo;

@FeignClient("hefa-user-service")
public interface PlatfromRegionService {

	/**
	 * 
	 * <p>查询售后区域列表</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/hefa/api/region/getRegionList")
	JsonResult<Pagination<RegionUserInfo>> getRegionList(@RequestBody RegionUserParam param);
	
	/**
	 * 添加区域
	 * @param regionAdd
	 * @return
	 */
	@RequestMapping("/hefa/api/region/addRegion")
	public JsonResult<String> addRegion(@RequestBody RegionAdd regionAdd);
	
	/**
	 * 
	 * <p>售后区域变更 人员变更</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/hefa/api/region/updateRegionchange")
	public JsonResult<String> updateRegionchange(@RequestBody RegionAdd regionAdd);
	
	/**
	 * 
	 * <p>售后区域人员删除</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/hefa/api/region/deleteRegion")
	public JsonResult<String> deleteRegion(@RequestParam("id") Long id);
}
