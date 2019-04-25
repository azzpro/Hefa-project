/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月25日 上午11:34:36
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.user.pojo.bo.AddPlatformUserSalesmanParam;
import com.hefa.user.pojo.bo.EditOrDelPlatformUserSalesmanParam;
import com.hefa.user.pojo.bo.SearchSalesmanInfoParam;
import com.hefa.user.pojo.vo.SalesmanInfo;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月25日 上午11:34:36
 */
@FeignClient("hefa-user-service")
public interface SalesmanService {

	/**
	 * 
	 * <p>新增业务员</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月23日 下午4:18:20
	 */
	@RequestMapping("/hefa/api/platform/salesman/addSalesman")
	JsonResult<String> addSalesman(@RequestBody AddPlatformUserSalesmanParam param);

	/**
	 * 
	 * <p>
	 * 编辑或删除业务员
	 * </p>
	 * 
	 * @param param
	 * @return
	 * @author 黄智聪 2019年4月23日 下午4:18:20
	 */
	@RequestMapping("/hefa/api/platform/salesman/editOrDelSalesman")
	JsonResult<String> editOrDelSalesman(@RequestBody EditOrDelPlatformUserSalesmanParam param);
	
	/**
	 * 
	 * <p>查询业务员信息</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午2:18:34
	 */
	@RequestMapping("/hefa/api/platform/salesman/getSalesmanInfos")
	JsonResult<Pagination<SalesmanInfo>> getSalesmanInfos(@RequestBody SearchSalesmanInfoParam param);
	
}

