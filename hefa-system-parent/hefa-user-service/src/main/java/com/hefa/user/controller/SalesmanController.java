/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月25日 上午11:28:53
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.user.pojo.bo.AddPlatformUserSalesmanParam;
import com.hefa.user.pojo.bo.EditOrDelPlatformUserSalesmanParam;
import com.hefa.user.pojo.bo.SearchSalesmanInfoParam;
import com.hefa.user.pojo.vo.SalesmanInfo;
import com.hefa.user.service.PlatformUserSalesmanService;

/**
 * <P>业务员管理</P>
 * @version 1.0
 * @author 黄智聪  2019年4月25日 上午11:28:53
 */
@RestController
@RequestMapping("/hefa/api/platform/salesman")
public class SalesmanController {
	
	@Autowired
	private PlatformUserSalesmanService platformUserSalesmanService;

	/**
	 * 
	 * <p>新增业务员</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月23日 下午4:18:20
	 */
	@RequestMapping("/addSalesman")
	public JsonResult<String> addSalesman(@RequestBody AddPlatformUserSalesmanParam param) {
		return platformUserSalesmanService.addSalesman(param);
	}

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
	@RequestMapping("/editOrDelSalesman")
	public JsonResult<String> editOrDelSalesman(@RequestBody EditOrDelPlatformUserSalesmanParam param) {
		return platformUserSalesmanService.editOrDelSalesman(param);
	}
	
	/**
	 * 
	 * <p>查询业务员信息</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午2:18:34
	 */
	@RequestMapping("/getSalesmanInfos")
	public JsonResult<Pagination<SalesmanInfo>> getSalesmanInfos(@RequestBody SearchSalesmanInfoParam param){
		return platformUserSalesmanService.getSalesmanInfos(param);
	}
}

