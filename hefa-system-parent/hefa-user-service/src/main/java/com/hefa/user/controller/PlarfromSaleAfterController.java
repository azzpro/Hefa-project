package com.hefa.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.user.pojo.PlatformSaleAfter;
import com.hefa.user.pojo.bo.ServiceSaleAfterParam;
import com.hefa.user.pojo.bo.UpdateSaleInfo;
import com.hefa.user.pojo.vo.SaleAfterInfo;
import com.hefa.user.pojo.vo.ServiceSaleInfo;
import com.hefa.user.service.PlatfromSaleafterService;

/**
 * @author THINK
 * 订单售后
 */
@RestController
@RequestMapping("/hefa/api/sale/")
public class PlarfromSaleAfterController {

	@Autowired
	private PlatfromSaleafterService platfromSaleafterService;
	
	/**
	 * 
	 * <p>查询订单售后列表</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/getSaleAfterList")
	public JsonResult<Pagination<ServiceSaleInfo>> getSaleAfterList(@RequestBody ServiceSaleAfterParam param){
		return platfromSaleafterService.getSaleAfterList(param);
	}
	
	/**
	 * 
	 * <p>查询退款订单列表</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/getSaleAfterOrderList")
	public JsonResult<Pagination<ServiceSaleInfo>> getSaleAfterOrderList(@RequestBody ServiceSaleAfterParam param){
		return platfromSaleafterService.getSaleAfterOrderList(param);
	}
	
	/**
	 * 
	 * <p>查询订单售后详情</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/getSaleAfterInfo")
	public JsonResult<SaleAfterInfo> getSaleAfterInfo(@RequestParam("serviceNumber") String serviceNumber){
		return platfromSaleafterService.getSaleAfterInfo(serviceNumber);
	}
	
	/**
	 * 
	 * <p>查询退款订单详情</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/getSaleAfterOrderInfo")
	public JsonResult<SaleAfterInfo> getSaleAfterOrderInfo(@RequestParam("serviceNumber") String serviceNumber){
		return platfromSaleafterService.getSaleAfterOrderInfo(serviceNumber);
	}
	
	/**
	 * 
	 * <p>添加售后区域</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/insertSaleAfter")
	public JsonResult<String> insertSaleAfter(@RequestBody PlatformSaleAfter platformSaleAfter){
		return platfromSaleafterService.insertSaleAfter(platformSaleAfter);
	}
	
	/**
	 * 
	 * <p>售后区域变更 人员变更</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/updateSaleAfter")
	public JsonResult<String> updateSaleAfter(@RequestBody UpdateSaleInfo updateSaleInfo){
		return platfromSaleafterService.updateSaleAfter(updateSaleInfo);
	}
	
	/**
	 * 
	 * <p>确认打款</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/updatePayment")
	public JsonResult<String> updatePayment(@RequestBody UpdateSaleInfo updateSaleInfo){
		return platfromSaleafterService.updatePayment(updateSaleInfo);
	}
	
}
