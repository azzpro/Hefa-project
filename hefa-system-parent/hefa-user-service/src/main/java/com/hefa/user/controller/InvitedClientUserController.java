/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月25日 上午11:38:31
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
import com.hefa.user.pojo.bo.AddClientUserSalesmanParam;
import com.hefa.user.pojo.bo.EditClientUserSalesmanParam;
import com.hefa.user.pojo.bo.SearchInvitedUserInfoParam;
import com.hefa.user.pojo.vo.InvitedUserInfo;
import com.hefa.user.service.ClientUserSalesmanService;

/**
 * <P>邀请会员管理</P>
 * @version 1.0
 * @author 黄智聪  2019年4月25日 上午11:38:31
 */
@RestController
@RequestMapping("/hefa/api/platform/invitedUser")
public class InvitedClientUserController {
	
	@Autowired
	private ClientUserSalesmanService clientUserSalesmanService;
	
	/**
	 * 
	 * <p>新增邀请会员</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午3:07:18
	 */
	@RequestMapping("/addClientUserSalesman")
	public JsonResult<String> addClientUserSalesman(@RequestBody AddClientUserSalesmanParam param) {
		return clientUserSalesmanService.addClientUserSalesman(param);
	}
	
	/**
	 * 
	 * <p>修改邀请会员</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午3:07:18
	 */
	@RequestMapping("/editClientUserSalesman")
	public JsonResult<String> editClientUserSalesman(@RequestBody EditClientUserSalesmanParam param) {
		return clientUserSalesmanService.editClientUserSalesman(param);
	}
	
	
	/**
	 * 
	 * <p>查询业务员信息</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午2:18:34
	 */
	@RequestMapping("/getSalesmanInfos")
	public JsonResult<Pagination<InvitedUserInfo>> getSalesmanInfos(@RequestBody SearchInvitedUserInfoParam param){
		return clientUserSalesmanService.getSalesmanInfos(param);
	}
	
}

