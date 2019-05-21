package com.hefa.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.client.util.WebUtils;
import com.hefa.common.base.JsonResult;
import com.hefa.common.exception.ReturnDataException;
import com.hefa.common.page.Pagination;
import com.hefa.user.api.PlatfromSaleAfterService;
import com.hefa.user.pojo.PlatformSaleAfter;
import com.hefa.user.pojo.bo.ServiceSaleAfterParam;
import com.hefa.user.pojo.vo.SaleAfterInfo;
import com.hefa.user.pojo.vo.ServiceSaleInfo;

/**
 * @author THINK
 * 订单售后
 */
@RestController
@RequestMapping("/hefa/api/client/sale")
public class ClientSaleAfterController {

	@Autowired
	private PlatfromSaleAfterService platfromSaleAfterService;
	
	/**
	 * 
	 * <p>查询订单售后列表</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/getSaleAfterList")
	public JsonResult<Pagination<ServiceSaleInfo>> getSaleAfterList( ServiceSaleAfterParam param){
		return platfromSaleAfterService.getSaleAfterList(param);
	}
	
	/**
	 * 
	 * <p>查询退款订单列表</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/getSaleAfterOrderList")
	public JsonResult<Pagination<ServiceSaleInfo>> getSaleAfterOrderList( ServiceSaleAfterParam param){
		return platfromSaleAfterService.getSaleAfterOrderList(param);
	}
	
	/**
	 * 添加订单售后已提供接口，直接调取PlatfromSaleAfterService API 
	 * 参数传递只需要 提供 订单编码 和 提交用户编码
	 * <p>添加订单售后  测试使用</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/insertSaleAfter")
	public JsonResult<String> insertSaleAfter( PlatformSaleAfter platformSaleAfter){
		int i = platfromSaleAfterService.selectOrderCount(platformSaleAfter.getOrderCode());
		if(i >= 1) {
			throw new ReturnDataException("不能重复申请");
		}
		platformSaleAfter.setUserCode(WebUtils.getLoginUser().getUserCode());
		return platfromSaleAfterService.insertSaleAfter(platformSaleAfter);
	}
	
	/**
	 * 
	 * <p>订单售后修改</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	/*@RequestMapping("/updateSaleAfter")
	public JsonResult<String> updateSaleAfter( UpdateSaleInfo updateSaleInfo){
		updateSaleInfo.setMan(WebUtils.getLoginUser().getUserInfo().getUserCode());
		return platfromSaleAfterService.updateSaleAfter(updateSaleInfo);
	}*/
	
	/**
	 * 
	 * <p>订单售后修改</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	/*@RequestMapping("/updatePayment")
	public JsonResult<String> updatePayment( UpdateSaleInfo updateSaleInfo){
		updateSaleInfo.setMan(WebUtils.getLoginUser().getUserInfo().getUserCode());
		return platfromSaleAfterService.updatePayment(updateSaleInfo);
	}*/
	
	/**
	 * 
	 * <p>查询订单售后详情</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/getSaleAfterInfo")
	public JsonResult<SaleAfterInfo> getSaleAfterInfo(@RequestParam("serviceNumber")String serviceNumber){
		return platfromSaleAfterService.getSaleAfterInfo(serviceNumber);
	}
	
	/**
	 * 
	 * <p>查询退款订单售后详情</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/getSaleAfterOrderInfo")
	public JsonResult<SaleAfterInfo> getSaleAfterOrderInfo(@RequestParam("serviceNumber")String serviceNumber){
		return platfromSaleAfterService.getSaleAfterOrderInfo(serviceNumber);
	}
}
