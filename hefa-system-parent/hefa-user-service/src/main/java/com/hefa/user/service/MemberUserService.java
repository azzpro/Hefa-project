package com.hefa.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.pagehelper.PageHelper;
import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.user.mapper.MemberUserMapper;
import com.hefa.user.pojo.bo.MemberParam;
import com.hefa.user.pojo.vo.MemberInfo;

@Service
public class MemberUserService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberUserService.class);
	
	@Autowired
	private MemberUserMapper memberUserMapper;
	
	/**
	 * 获取会员列表数据
	 * @param param
	 * @return
	 */
	public JsonResult<Pagination<MemberInfo>> getMemberUserList(@RequestBody MemberParam param){
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		List<MemberInfo> infos = memberUserMapper.getMemberUserList(param);
		return JsonResult.successJsonResult(new Pagination<>(infos));
	}
}
