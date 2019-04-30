/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月24日 下午5:46:51
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.client.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
@FeignClient(name = "hefa-client-service")
public interface ShippingAddressService {
	
	/**
	 * 
	 * <p>查询默认收货地址信息</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	@RequestMapping("/hefa/api/client/shippingAddress/getDefaultShippingAddress")
	JsonResult<ShippingAddress> getDefaultShippingAddress(@RequestParam("userCode")String userCode);
	
	/**
	 * 
	 * <p>查询收货地址信息</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	@RequestMapping("/hefa/api/client/shippingAddress/getShippingAddressList")
	JsonResult<List<ShippingAddress>> getShippingAddressList(@RequestParam("userCode")String userCode);
	
	/**
	 * 
	 * <p>查询收货地址信息</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	@RequestMapping("/hefa/api/client/shippingAddress/getShippingAddress")
	JsonResult<ShippingAddress> getShippingAddress(@RequestParam("shippingAddressCode")String shippingAddressCode);
	
	/**
	 * 
	 * <p>新增收货地址信息</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	@RequestMapping("/hefa/api/client/shippingAddress/addShippingAddress")
	JsonResult<String> addShippingAddress(@RequestBody AddShippingAddressParam param);
	
	/**
	 * 
	 * <p>修改收货地址信息</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	@RequestMapping("/hefa/api/client/shippingAddress/editShippingAddress")
	JsonResult<String> editShippingAddress(@RequestBody EditShippingAddressParam param);
	
	/**
	 * 
	 * <p>查询收货地址信息</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	@RequestMapping("/hefa/api/client/shippingAddress/delShippingAddress")
	JsonResult<String> delShippingAddress(@RequestBody DelShippingAddressParam param);
	
}

