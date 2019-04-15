/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月15日 下午2:52:28
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.azz.controller.utils.WebUtils;
import com.azz.core.common.JsonResult;
import com.azz.core.common.page.Pagination;
import com.azz.order.api.client.ClientOrderService;
import com.azz.order.client.pojo.bo.AddShippingAddressParam;
import com.azz.order.client.pojo.bo.DelShippingAddressParam;
import com.azz.order.client.pojo.bo.EditShippingAddressParam;
import com.azz.order.client.pojo.bo.SearchClientOrderParam;
import com.azz.order.client.pojo.bo.SignForm;
import com.azz.order.client.pojo.bo.UploadSignFormParam;
import com.azz.order.client.pojo.bo.UploadSignFormWebParam;
import com.azz.order.client.pojo.vo.ClientOrderDetail;
import com.azz.order.client.pojo.vo.ClientOrderInfo;
import com.azz.order.client.pojo.vo.ShippingAddress;
import com.azz.util.Base64;
import com.azz.util.JSR303ValidateUtils;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年11月15日 下午2:52:28
 */
@RestController
@RequestMapping("/azz/api/client/order")
public class ClientOrderController {
	
	@Autowired
	private ClientOrderService clientOrderService;

	/**
	 * 
	 * <p>查询客户端订单列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2018年11月13日 上午10:54:40
	 */
	@RequestMapping("/getClientOrderInfoList")
	public JsonResult<Pagination<ClientOrderInfo>> getClientOrderInfoList(SearchClientOrderParam param){
		param.setClientUserCode(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
		return clientOrderService.getClientOrderInfoList(param);
	}
	
	/**
	 * 
	 * <p>查询客户订单详情</p>
	 * @param clientOrderCode
	 * @return
	 * @author 黄智聪  2018年11月13日 上午10:56:03
	 */
	@RequestMapping("/getClientOrderDetail")
	public JsonResult<ClientOrderDetail> getClientOrderDetail(String clientOrderCode){
		return clientOrderService.getClientOrderDetail(clientOrderCode);
	}
	
	/**
	 * 
	 * <p>查询收货地址信息</p>
	 * @param clientUserCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	@RequestMapping("/getShippingAddressList")
	public JsonResult<List<ShippingAddress>> getShippingAddressList(){
		return clientOrderService.getShippingAddressList(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
	}
	
	/**
	 * 
	 * <p>查询默认收货地址信息</p>
	 * @param clientUserCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	@RequestMapping("/getDefaultShippingAddress")
	public JsonResult<ShippingAddress> getDefaultShippingAddress(){
		return clientOrderService.getDefaultShippingAddress(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
	}
	
	/**
	 * 
	 * <p>查询收货地址信息</p>
	 * @param clientUserCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	@RequestMapping("/getShippingAddress")
	public JsonResult<ShippingAddress> getShippingAddress(Long shippingId){
		return clientOrderService.getShippingAddress(shippingId);
	}
	
	/**
	 * 
	 * <p>新增收货地址信息</p>
	 * @param clientUserCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	@RequestMapping("/addShippingAddress")
	public JsonResult<String> addShippingAddress(AddShippingAddressParam param){
		param.setCreator(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
		return clientOrderService.addShippingAddress(param);
	}
	
	/**
	 * 
	 * <p>修改收货地址信息</p>
	 * @param clientUserCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	@RequestMapping("/editShippingAddress")
	public JsonResult<String> editShippingAddress(EditShippingAddressParam param){
		param.setModifier(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
		return clientOrderService.editShippingAddress(param);
	}
	
	/**
	 * 
	 * <p>查询收货地址信息</p>
	 * @param clientUserCode
	 * @return
	 * @author 黄智聪  2018年11月13日 下午2:58:08
	 */
	@RequestMapping("/delShippingAddress")
	public JsonResult<String> delShippingAddress(DelShippingAddressParam param){
		param.setModifier(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
		return clientOrderService.delShippingAddress(param);
	}
	
	/**
	 * 
	 * <p>校验客户订单是否能执行签收操作</p>
	 * @param clientOrderCode
	 * @return
	 * @author 黄智聪  2018年11月15日 上午10:27:31
	 */
	@RequestMapping("/checkSignOperation")
	public JsonResult<String> checkSignOperation(String clientOrderCode){
		return clientOrderService.checkSignOperation(clientOrderCode);
	}
	
	/**
	 * 
	 * <p>上传签收单</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2018年11月14日 上午10:55:45
	 * @throws IOException 
	 */
	@RequestMapping("/uploadSignForm")
	public JsonResult<String> uploadSignForm(UploadSignFormWebParam webParam) throws IOException{
		JSR303ValidateUtils.validate(webParam);
		UploadSignFormParam param = new UploadSignFormParam();
		BeanUtils.copyProperties(webParam, param);
		List<SignForm> signForms = new ArrayList<>();
		for (MultipartFile signFormFile : webParam.getSignFormFiles()) {
			SignForm signForm = new SignForm(signFormFile.getOriginalFilename(),
					signFormFile.getSize(), Base64.encode(signFormFile.getBytes()));
			signForms.add(signForm);
		}
		param.setSignForms(signForms);
		param.setCreator(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
		return clientOrderService.uploadSignForm(param);
	}
	
	/**
	 * 
	 * <p>关闭订单--6小时未支付的待支付订单，状态改为已关闭</p>
	 * @return
	 * @author 黄智聪  2018年11月15日 上午10:38:19
	 */
	/*
	@RequestMapping("/closeClientOrders")
	public JsonResult<String> closeClientOrders(){
		return clientOrderService.closeClientOrders(); 
	}
	*/
	
	/**
	 * 
	 * <p>客户订单是否支付成功</p>
	 * @param clientOrderCode
	 * @return
	 * @author 黄智聪  2018年12月1日 下午3:12:45
	 */
	@RequestMapping("/checkClientOrderPaySuccess")
	public JsonResult<String> checkClientOrderPaySuccess(String clientOrderCode){
		return clientOrderService.checkClientOrderPaySuccess(clientOrderCode); 
	}
	
	
}

