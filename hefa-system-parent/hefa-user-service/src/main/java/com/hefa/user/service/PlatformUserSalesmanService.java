/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月23日 下午2:10:25
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.user.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.hefa.common.base.JsonResult;
import com.hefa.user.mapper.PlatformUserSalesmanMapper;
import com.hefa.user.pojo.PlatformUserSalesman;
import com.hefa.user.pojo.bo.AddPlatformUserSalesmanParam;
import com.hefa.utils.JSR303ValidateUtils;

/**
 * <P>平台端用户与业务员的业务</P>
 * @version 1.0
 * @author 黄智聪  2019年4月23日 下午2:10:25
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class PlatformUserSalesmanService {
	
	@Autowired
	private PlatformUserSalesmanMapper platformUserSalesmanMapper;
	
	public JsonResult<String> addSalesman(@RequestBody AddPlatformUserSalesmanParam param) {
		
		JSR303ValidateUtils.validateInputParam(param);
		PlatformUserSalesman record = PlatformUserSalesman.builder()
				.createTime(new Date())
				.creator(param.getCreator())
				.build();
		platformUserSalesmanMapper.insertSelective(record);
		return JsonResult.successJsonResult();
	}

}

