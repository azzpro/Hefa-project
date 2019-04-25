package com.hefa.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.user.pojo.bo.MemberParam;
import com.hefa.user.pojo.vo.MemberInfo;

@FeignClient("hefa-user-service")
public interface MemberUserService {


	/**
	 * 
	 * <p>查询会员列表</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/hefa/api/member/getMemberUserList")
	JsonResult<Pagination<MemberInfo>> getMemberUserList(@RequestBody MemberParam param);
}
