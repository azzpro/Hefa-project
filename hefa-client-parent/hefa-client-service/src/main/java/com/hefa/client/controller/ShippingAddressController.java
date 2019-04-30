/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月24日 下午5:46:51
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.client.service.ShippingAddressService;
import com.hefa.common.base.JsonResult;
import com.hefa.pojo.bo.AddShippingAddressParam;
import com.hefa.pojo.bo.DelShippingAddressParam;
import com.hefa.pojo.bo.EditShippingAddressParam;
import com.hefa.pojo.vo.ShippingAddress;

/**
 * <P>客户收货地址业务</P>
 * @version 1.0
 * @author 黄智聪  2019年4月24日 下午5:46:51
 */
@RestController
@RequestMapping("/hefa/api/client/shippingAddress")
public class ShippingAddressController {
	
	@Autowired
	private ShippingAddressService shippingAddressService;
	
	/**
	 * 
	 * <p>查询默认收货地址信息</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	@RequestMapping("/getDefaultShippingAddress")
	public JsonResult<ShippingAddress> getDefaultShippingAddress(@RequestParam("userCode")String userCode){
		return shippingAddressService.getDefaultShippingAddress(userCode);
	}
	
	/**
	 * 
	 * <p>查询收货地址信息</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	@RequestMapping("/getShippingAddressList")
	public JsonResult<List<ShippingAddress>> getShippingAddressList(@RequestParam("userCode")String userCode){
		return shippingAddressService.getShippingAddressList(userCode);
	}
	
	/**
	 * 
	 * <p>查询收货地址信息</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	@RequestMapping("/getShippingAddress")
	public JsonResult<ShippingAddress> getShippingAddress(@RequestParam("shippingAddressCode")String shippingAddressCode){
		return shippingAddressService.getShippingAddress(shippingAddressCode);
	}
	
	/**
	 * 
	 * <p>新增收货地址信息</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	@RequestMapping("/addShippingAddress")
	public JsonResult<String> addShippingAddress(@RequestBody AddShippingAddressParam param){
		return shippingAddressService.addShippingAddress(param);
	}
	
	/**
	 * 
	 * <p>修改收货地址信息</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	@RequestMapping("/editShippingAddress")
	public JsonResult<String> editShippingAddress(@RequestBody EditShippingAddressParam param){
		return shippingAddressService.editShippingAddress(param);
	}
	
	/**
	 * 
	 * <p>查询收货地址信息</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	@RequestMapping("/delShippingAddress")
	public JsonResult<String> delShippingAddress(@RequestBody DelShippingAddressParam param){
		return shippingAddressService.delShippingAddress(param);
	}
	
}

