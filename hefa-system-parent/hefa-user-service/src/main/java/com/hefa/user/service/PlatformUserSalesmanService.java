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
import com.hefa.common.constants.PlatformConstants.PlatformUserSalesmanRecordStatus;
import com.hefa.common.exception.BusinessException;
import com.hefa.common.exception.ReturnDataException;
import com.hefa.common.page.Pagination;
import com.hefa.user.mapper.ClientUserSalesmanMapper;
import com.hefa.user.mapper.PlatformUserMapper;
import com.hefa.user.mapper.PlatformUserSalesmanMapper;
import com.hefa.user.pojo.PlatformUser;
import com.hefa.user.pojo.PlatformUserSalesman;
import com.hefa.user.pojo.bo.AddPlatformUserSalesmanParam;
import com.hefa.user.pojo.bo.EditOrDelPlatformUserSalesmanParam;
import com.hefa.user.pojo.bo.SearchSalesmanInfoParam;
import com.hefa.user.pojo.vo.SalesmanInfo;
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
	
	@Autowired
	private ClientUserSalesmanMapper clientUserSalesmanMapper;
	
	@Autowired
	private PlatformUserMapper platformUserMapper;
	
	/**
	 * 
	 * <p>新增业务员</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月23日 下午4:18:20
	 */
	public JsonResult<String> addSalesman(@RequestBody AddPlatformUserSalesmanParam param) {
		JSR303ValidateUtils.validateInputParam(param);
		// 校验平台成员是否能新增为业务员
		this.checkPlatformUser(param.getUserCode(), null);
		String salesmanCode = "S" + System.currentTimeMillis(); // TODO
		PlatformUserSalesman record = PlatformUserSalesman.builder()
				.createTime(new Date())
				.creator(param.getCreator())
				.platformUserCode(param.getUserCode())
				.invitedClientUserCount(0)
				.salesmanCode(salesmanCode)
				.build();
		platformUserSalesmanMapper.insertSelective(record);
		return JsonResult.successJsonResult();
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
	public JsonResult<String> editOrDelSalesman(@RequestBody EditOrDelPlatformUserSalesmanParam param) {
		JSR303ValidateUtils.validateInputParam(param);
		PlatformUserSalesman record = platformUserSalesmanMapper.selectByPrimaryKey(param.getRecordId());
		if (record == null) {
			throw new ReturnDataException("业务员记录不存在");
		}
		int optType = param.getOptType();
		Long id = record.getId();
		String salesmanCode = record.getSalesmanCode();
		PlatformUserSalesman updateRecord = null;
		switch (optType) {
		case 1: // 编辑
			// 若为编辑，则需要查询除自己以外，平台成员编码是否已被其他业务员所绑定了
			this.checkPlatformUser(param.getUserCode(), id);
			updateRecord = PlatformUserSalesman.builder().id(id).modifier(param.getModifier()).modifyTime(new Date())
					.platformUserCode(param.getUserCode()).build();
			platformUserSalesmanMapper.updateByPrimaryKeySelective(updateRecord);
			break;
		case 2: // 删除
			// 校验业务员是否能删除
			this.checkSalesman(salesmanCode);
			updateRecord = PlatformUserSalesman.builder().id(id).modifier(param.getModifier()).modifyTime(new Date())
					.status((byte) PlatformUserSalesmanRecordStatus.INVALID.getValue()).build();
			platformUserSalesmanMapper.updateByPrimaryKeySelective(updateRecord);
			break;
		default:
			break;
		}
		return JsonResult.successJsonResult();
	}
	
	/**
	 * 
	 * <p>查询业务员信息</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午2:18:34
	 */
	public JsonResult<Pagination<SalesmanInfo>> getSalesmanInfos(@RequestBody SearchSalesmanInfoParam param){
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		List<SalesmanInfo> infos = platformUserSalesmanMapper.getSalesmanInfos(param);
		return JsonResult.successJsonResult(new Pagination<>(infos));
	}

	/**
	 * 
	 * <p>校验业务员是否能删除</p>
	 * @param salesmanCode
	 * @author 黄智聪  2019年4月23日 下午5:37:33
	 */
	private void checkSalesman(String salesmanCode) {
		int count = clientUserSalesmanMapper.countBySalesmanCode(salesmanCode);
		if(count > 0) {
			throw new BusinessException("业务人员存在绑定的会员信息，请变更后在进行删除");
		}
	}
	
	/**
	 * 
	 * <pre>校验平台成员是否能新增为业务员：
	 *	若为编辑，则需要查询除自己以外，
	 *	平台成员编码是否已被其他业务员所绑定了，需要传入id
	 *  </pre>
	 * @param platformUserCode
	 * @author 黄智聪  2019年4月23日 下午5:02:43
	 */
	private void checkPlatformUser(String platformUserCode, Long id) {
		PlatformUser platformUser = platformUserMapper.getUserByUserCode(platformUserCode);
		if(platformUser == null) {
			throw new ReturnDataException("成员编码不存在");
		}
		int count = platformUserSalesmanMapper.countByPlatformUserCode(platformUserCode, id);
		if(count > 0) {
			throw new BusinessException("该成员已绑定业务员");
		}
	}

}

