package com.hefa.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.user.pojo.bo.MemberParam;
import com.hefa.user.pojo.vo.MemberInfo;
import com.hefa.user.service.MemberUserService;

/**
 * @author THINK
 * 会员管理
 */
@RestController
@RequestMapping("/hefa/api/member")
public class MemberUserController {
	
	@Autowired
	private MemberUserService memberUserService;
	
	/**
	 * 
	 * <p>查询会员列表</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/getMemberUserList")
	public JsonResult<Pagination<MemberInfo>> getMemberUserList(@RequestBody MemberParam param){
		return memberUserService.getMemberUserList(param);
	} 
}
