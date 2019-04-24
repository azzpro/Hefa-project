/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月23日 下午2:10:25
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.user.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.pagehelper.PageHelper;
import com.hefa.common.base.JsonResult;
import com.hefa.common.exception.ReturnDataException;
import com.hefa.common.page.Pagination;
import com.hefa.user.mapper.ClientUserSalesmanMapper;
import com.hefa.user.mapper.MemberUserMapper;
import com.hefa.user.mapper.PlatformUserSalesmanMapper;
import com.hefa.user.pojo.ClientUserSalesman;
import com.hefa.user.pojo.bo.AddClientUserSalesmanParam;
import com.hefa.user.pojo.bo.EditClientUserSalesmanParam;
import com.hefa.user.pojo.bo.SearchInvitedUserInfoParam;
import com.hefa.user.pojo.vo.InvitedUserInfo;
import com.hefa.utils.JSR303ValidateUtils;

/**
 * <P>客户端用户与业务员业务</P>
 * @version 1.0
 * @author 黄智聪  2019年4月23日 下午2:10:25
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ClientUserSalesmanService {
	
	@Autowired
	private ClientUserSalesmanMapper clientUserSalesmanMapper;
	
	@Autowired
	private PlatformUserSalesmanMapper platformUserSalesmanMapper;
	
	@Autowired
	private MemberUserMapper memberUserMapper;

	/**
	 * 
	 * <p>新增邀请会员</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午3:07:18
	 */
	public JsonResult<String> addClientUserSalesman(@RequestBody AddClientUserSalesmanParam param) {
		JSR303ValidateUtils.validateInputParam(param);
		// 业务员是否存在
		int count = platformUserSalesmanMapper.countBySalesmanCode(param.getSalesmanCode());
		if(count == 0 ) {
			throw new ReturnDataException("业务员记录不存在");
		}
		count = memberUserMapper.countUserById(param.getUserCode());
		if(count == 0 ) {
			throw new ReturnDataException("会员不存在");
		}
		count = clientUserSalesmanMapper.countByUserCode(param.getUserCode() + "");
		if(count > 0) {
			throw new ReturnDataException("会员已为邀请成员，请去变更关联的业务员信息");
		}
		ClientUserSalesman record = ClientUserSalesman.builder()
				.createTime(new Date())
				.creator(param.getCreator())
				.salesmanCode(param.getSalesmanCode())
				.userCode(param.getUserCode() + "")
				.build();
		clientUserSalesmanMapper.insertSelective(record);
		
		return JsonResult.successJsonResult();
	}
	
	/**
	 * 
	 * <p>修改邀请会员</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午3:07:18
	 */
	public JsonResult<String> editClientUserSalesman(@RequestBody EditClientUserSalesmanParam param) {
		JSR303ValidateUtils.validateInputParam(param);
		ClientUserSalesman record = clientUserSalesmanMapper.selectByPrimaryKey(param.getId());
		if(record == null) {
			throw new ReturnDataException("所选记录不存在");
		}
		// 业务员是否存在
		int count = platformUserSalesmanMapper.countBySalesmanCode(param.getSalesmanCode());
		if(count == 0 ) {
			throw new ReturnDataException("业务员记录不存在");
		}
		ClientUserSalesman updateRecord = ClientUserSalesman.builder()
				.id(param.getId())
				.salesmanCode(param.getSalesmanCode())
				.modifier(param.getModifier())
				.modifyTime(new Date())
				.build();
		clientUserSalesmanMapper.updateByPrimaryKeySelective(updateRecord);
		return JsonResult.successJsonResult();
	}
	
	
	/**
	 * 
	 * <p>查询业务员信息</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午2:18:34
	 */
	public JsonResult<Pagination<InvitedUserInfo>> getSalesmanInfos(@RequestBody SearchInvitedUserInfoParam param){
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		List<InvitedUserInfo> infos = clientUserSalesmanMapper.getInvitedUserInfos(param);
		return JsonResult.successJsonResult(new Pagination<>(infos));
	}
	
}

