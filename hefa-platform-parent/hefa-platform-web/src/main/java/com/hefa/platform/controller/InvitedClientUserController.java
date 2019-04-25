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
import com.hefa.user.api.InvitedClientUserService;
import com.hefa.user.pojo.bo.AddClientUserSalesmanParam;
import com.hefa.user.pojo.bo.EditClientUserSalesmanParam;
import com.hefa.user.pojo.bo.SearchInvitedUserInfoParam;
import com.hefa.user.pojo.vo.InvitedUserInfo;

/**
 * <P>邀请会员管理</P>
 * @version 1.0
 * @author 黄智聪  2019年4月25日 下午2:45:01
 */
@RestController
@RequestMapping("/hefa/api/platform/invitedUser")
public class InvitedClientUserController {
	
	@Autowired
	private InvitedClientUserService invitedClientUserService;

	/**
	 * 
	 * <p>新增邀请会员</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午3:07:18
	 */
	@RequestMapping("/addClientUserSalesman")
	public JsonResult<String> addClientUserSalesman(AddClientUserSalesmanParam param) {
		param.setCreator(WebUtils.getLoginUser().getUserInfo().getUserCode());
		return invitedClientUserService.addClientUserSalesman(param);
	}
	
	/**
	 * 
	 * <p>修改邀请会员</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午3:07:18
	 */
	@RequestMapping("/editClientUserSalesman")
	public JsonResult<String> editClientUserSalesman(EditClientUserSalesmanParam param) {
		param.setModifier(WebUtils.getLoginUser().getUserInfo().getUserCode());
		return invitedClientUserService.editClientUserSalesman(param);
	}
	
	
	/**
	 * 
	 * <p>查询已邀请的会员信息列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午2:18:34
	 */
	@RequestMapping("/getInvitedUserInfos")
	public JsonResult<Pagination<InvitedUserInfo>> getInvitedUserInfos(SearchInvitedUserInfoParam param){
		return invitedClientUserService.getInvitedUserInfos(param);
	}
	
}

