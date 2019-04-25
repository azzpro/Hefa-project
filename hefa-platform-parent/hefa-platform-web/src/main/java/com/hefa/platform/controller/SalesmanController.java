/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月25日 下午2:45:01
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.platform.utils.WebUtils;
import com.hefa.user.api.SalesmanService;
import com.hefa.user.pojo.bo.AddPlatformUserSalesmanParam;
import com.hefa.user.pojo.bo.EditOrDelPlatformUserSalesmanParam;
import com.hefa.user.pojo.bo.SearchSalesmanInfoParam;
import com.hefa.user.pojo.vo.SalesmanInfo;

/**
 * <P>业务员管理</P>
 * @version 1.0
 * @author 黄智聪  2019年4月25日 下午2:45:01
 */
@RestController
@RequestMapping("/hefa/api/platform/salesman")
public class SalesmanController {
	
	@Autowired
	private SalesmanService salesmanService;

	/**
	 * 
	 * <p>新增业务员</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月23日 下午4:18:20
	 */
	@RequestMapping("/addSalesman")
	public JsonResult<String> addSalesman(AddPlatformUserSalesmanParam param) {
		param.setCreator(WebUtils.getLoginUser().getUserInfo().getUserCode());
		return salesmanService.addSalesman(param);
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
	public JsonResult<String> editOrDelSalesman(EditOrDelPlatformUserSalesmanParam param) {
		param.setModifier(WebUtils.getLoginUser().getUserInfo().getUserCode());
		return salesmanService.editOrDelSalesman(param);
	}
	
	/**
	 * 
	 * <p>查询业务员信息</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午2:18:34
	 */
	@RequestMapping("/getSalesmanInfos")
	public JsonResult<Pagination<SalesmanInfo>> getSalesmanInfos(SearchSalesmanInfoParam param){
		return salesmanService.getSalesmanInfos(param);
	}
	
}

