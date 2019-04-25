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
import com.hefa.user.pojo.bo.AddClientUserSalesmanParam;
import com.hefa.user.pojo.bo.EditClientUserSalesmanParam;
import com.hefa.user.pojo.bo.SearchInvitedUserInfoParam;
import com.hefa.user.pojo.vo.InvitedUserInfo;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月25日 上午11:34:36
 */
@FeignClient("hefa-user-service")
public interface InvitedClientUserService {

	/**
	 * 
	 * <p>新增邀请会员</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午3:07:18
	 */
	@RequestMapping("/hefa/api/platform/invitedUser/addClientUserSalesman")
	JsonResult<String> addClientUserSalesman(@RequestBody AddClientUserSalesmanParam param);
	
	/**
	 * 
	 * <p>修改邀请会员</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午3:07:18
	 */
	@RequestMapping("/hefa/api/platform/invitedUser/editClientUserSalesman")
	JsonResult<String> editClientUserSalesman(@RequestBody EditClientUserSalesmanParam param);
	
	
	/**
	 * 
	 * <p>查询已邀请的会员信息列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午2:18:34
	 */
	@RequestMapping("/hefa/api/platform/invitedUser/getInvitedUserInfos")
	JsonResult<Pagination<InvitedUserInfo>> getInvitedUserInfos(@RequestBody SearchInvitedUserInfoParam param);
	
}

