package com.hefa.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
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
}
