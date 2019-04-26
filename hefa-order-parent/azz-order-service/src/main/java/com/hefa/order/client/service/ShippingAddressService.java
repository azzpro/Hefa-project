/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月24日 下午5:46:51
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.client.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.hefa.common.base.JsonResult;
import com.hefa.common.constants.ClientConstants;
import com.hefa.common.constants.PlatformConstants.ShippingAddressStatus;
import com.hefa.common.constants.PlatformConstants.isDefaultShippingAddress;
import com.hefa.common.exception.ValidationException;
import com.hefa.order.mapper.ClientShippingAddressMapper;
import com.hefa.order.pojo.ClientShippingAddress;
import com.hefa.order.pojo.bo.AddShippingAddressParam;
import com.hefa.order.pojo.bo.DelShippingAddressParam;
import com.hefa.order.pojo.bo.EditShippingAddressParam;
import com.hefa.order.pojo.vo.ShippingAddress;
import com.hefa.utils.JSR303ValidateUtils;

/**
 * <P>客户收货地址业务</P>
 * @version 1.0
 * @author 黄智聪  2019年4月24日 下午5:46:51
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ShippingAddressService {
	
	@Autowired
	private ClientShippingAddressMapper clientShippingAddressMapper;
	
	/**
	 * 
	 * <p>查询默认收货地址信息</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	public JsonResult<ShippingAddress> getDefaultShippingAddress(String userCode){
		return JsonResult.successJsonResult(clientShippingAddressMapper.getDefaultShippingAddressByUserCode(userCode));
	}
	
	/**
	 * 
	 * <p>查询收货地址信息</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	public JsonResult<List<ShippingAddress>> getShippingAddressList(String userCode){
		return JsonResult.successJsonResult(clientShippingAddressMapper.getShippingAddressByUserCode(userCode));
	}
	
	/**
	 * 
	 * <p>查询收货地址信息</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	public JsonResult<ShippingAddress> getShippingAddress(String shippingAddressCode){
		ShippingAddress address = clientShippingAddressMapper.getShippingAddressByShippingAddressCode(shippingAddressCode);
		if(address == null) {
			throw new ValidationException("收货地址不存在");
		}
		return JsonResult.successJsonResult(address);
	}
	
	/**
	 * 
	 * <p>新增收货地址信息</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	public JsonResult<String> addShippingAddress(@RequestBody AddShippingAddressParam param){
		// 参数校验
		JSR303ValidateUtils.validateInputParam(param);
		int count = clientShippingAddressMapper.countShippingAddressByUserCode(param.getCreator());
		if(count >= ClientConstants.SHIPPING_ADDRESS_AMOUNT_LIMIT) {
			throw new ValidationException("收货地址不能超过10个");
		}
		// 若为默认地址，将该客户的其他地址改为非默认
		if(isDefaultShippingAddress.YES.getValue() == param.getIsDefault()) {
			clientShippingAddressMapper.setOtherShippingAddressNotDefault(param.getCreator());
		}
		ClientShippingAddress shippingAddressRecord = ClientShippingAddress.builder()
				.addressAlias(param.getAddressAlias())
				.areaCode(param.getAreaCode())
				.areaName(param.getAreaName())
				.cityCode(param.getCityCode())
				.cityName(param.getCityName())
				.userCode(param.getCreator())
				.createTime(new Date())
				.creator(param.getCreator())
				.detailAddress(param.getDetailAddress())
				.isDefault(param.getIsDefault())
				.provinceCode(param.getProvinceCode())
				.provinceName(param.getProvinceName())
				.receiverName(param.getReceiverName())
				.receiverPhoneNumber(param.getReceiverPhoneNumber())
				.build();
		clientShippingAddressMapper.insertSelective(shippingAddressRecord);
		return JsonResult.successJsonResult();
	}
	
	/**
	 * 
	 * <p>修改收货地址信息</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	public JsonResult<String> editShippingAddress(@RequestBody EditShippingAddressParam param){
		// 参数校验
		JSR303ValidateUtils.validateInputParam(param);
		ShippingAddress address = clientShippingAddressMapper.getShippingAddressByShippingAddressCode(param.getShippingAddressCode());
		if(address == null) {
			throw new ValidationException("收货地址不存在");
		}
		// 若为默认地址，将该用户的其他地址改为非默认
		if(isDefaultShippingAddress.YES.getValue() == param.getIsDefault()) {
			clientShippingAddressMapper.setOtherShippingAddressNotDefault(address.getUserCode());
		}
		ClientShippingAddress shippingAddressRecord = ClientShippingAddress.builder()
				.shippingAddressCode(param.getShippingAddressCode())
				.addressAlias(param.getAddressAlias())
				.areaCode(param.getAreaCode())
				.areaName(param.getAreaName())
				.cityCode(param.getCityCode())
				.cityName(param.getCityName())
				.userCode(address.getUserCode())
				.detailAddress(param.getDetailAddress())
				.isDefault(param.getIsDefault())
				.provinceCode(param.getProvinceCode())
				.provinceName(param.getProvinceName())
				.modifier(param.getModifier())
				.modifyTime(new Date())
				.receiverName(param.getReceiverName())
				.receiverPhoneNumber(param.getReceiverPhoneNumber())
				.build();
		clientShippingAddressMapper.updateByPrimaryKeySelective(shippingAddressRecord);
		return JsonResult.successJsonResult();
	}
	
	/**
	 * 
	 * <p>查询收货地址信息</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	public JsonResult<String> delShippingAddress(@RequestBody DelShippingAddressParam param){
		// 参数校验
		JSR303ValidateUtils.validateInputParam(param);
		ClientShippingAddress shippingAddressRecord = ClientShippingAddress.builder()
				.shippingAddressCode(param.getShippingAddressCode())
				.status(ShippingAddressStatus.INVALID.getValue())
				.modifier(param.getModifier())
				.modifyTime(new Date())
				.build();
		clientShippingAddressMapper.updateByPrimaryKeySelective(shippingAddressRecord);
		return JsonResult.successJsonResult();
	}
	
	
}

