package com.hefa.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.user.pojo.PlatformSaleAfter;
import com.hefa.user.pojo.bo.ServiceSaleAfterParam;
import com.hefa.user.pojo.bo.UpdateSaleInfo;
import com.hefa.user.pojo.vo.SaleAfterInfo;
import com.hefa.user.pojo.vo.ServiceSaleInfo;

@FeignClient("hefa-user-service")
public interface PlatfromSaleAfterService {

	/**
	 * 
	 * <p>查询订单售后列表</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/hefa/api/sale/getSaleAfterList")
	public JsonResult<Pagination<ServiceSaleInfo>> getSaleAfterList(@RequestBody ServiceSaleAfterParam param);
	
	/**
	 * 
	 * <p>添加售后区域</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/hefa/api/sale/insertSaleAfter")
	public JsonResult<String> insertSaleAfter(@RequestBody PlatformSaleAfter platformSaleAfter);
	
	/**
	 * 
	 * <p>售后区域变更 人员变更</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/hefa/api/sale/updateSaleAfter")
	public JsonResult<String> updateSaleAfter(@RequestBody UpdateSaleInfo updateSaleInfo);
	
	/**
	 * 
	 * <p>查询订单售后详情</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	@RequestMapping("/hefa/api/sale/getSaleAfterInfo")
	public JsonResult<SaleAfterInfo> getSaleAfterInfo(@RequestParam("serviceNumber") String serviceNumber);
}
