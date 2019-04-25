package com.hefa.user.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.pagehelper.PageHelper;
import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.user.mapper.PlatformRegionMapper;
import com.hefa.user.mapper.PlatformSaleafterMapper;
import com.hefa.user.mapper.PlatformSaledetailMapper;
import com.hefa.user.mapper.PlatformUserMapper;
import com.hefa.user.pojo.PlatformSaleAfter;
import com.hefa.user.pojo.PlatformSaleDetail;
import com.hefa.user.pojo.PlatformUser;
import com.hefa.user.pojo.bo.ServiceSaleAfterParam;
import com.hefa.user.pojo.bo.UpdateSaleInfo;
import com.hefa.user.pojo.vo.OrderItemInfo;
import com.hefa.user.pojo.vo.SaleAfterInfo;
import com.hefa.user.pojo.vo.ServiceSaleInfo;

@Service
public class PlatfromSaleafterService {

	@Autowired
	private PlatformSaleafterMapper platformSaleafterMapper;
	
	@Autowired
	private PlatformSaledetailMapper platformSaledetailMapper;
	
	@Autowired
	private PlatformRegionMapper platformRegionMapper;
	
	@Autowired
	private PlatformUserMapper platformUserMapper;
	
	
	/**
	 * 获取订单售后列表数据
	 * @param param
	 * @return
	 */
	public JsonResult<Pagination<ServiceSaleInfo>> getSaleAfterList(@RequestBody ServiceSaleAfterParam param){
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		List<ServiceSaleInfo> saleAfterList = platformSaleafterMapper.getSaleAfterList(param);
		return JsonResult.successJsonResult(new Pagination<>(saleAfterList));
	}
	
	/**
	 * 获取订单售后详情
	 * @param param
	 * @return
	 */
	public JsonResult<SaleAfterInfo> getSaleAfterInfo(String serviceName){
		SaleAfterInfo afterInfo = platformSaleafterMapper.getSaleAfterInfo(serviceName);
		List<PlatformSaleDetail> detailList = platformSaledetailMapper.getSaleDetailList(serviceName);
		List<OrderItemInfo> byOrderCode = platformSaleafterMapper.getOrderItemInfosByOrderCode(afterInfo.getOrderCode());
		afterInfo.setPsds(detailList);
		afterInfo.setOii(byOrderCode);
		Optional<Map<String,String>> option = Optional.ofNullable(platformSaleafterMapper.selectAreaNameById(afterInfo.getUserCode()));
		Map<String, String> map = option.orElse(new HashMap<String,String>());
		String str;
		if(!map.isEmpty()) {
			 str = map.get("pname")+map.get("cname")+map.get("aname");
			 String area = platformRegionMapper.selectUserCodeByArea(str);
			 if(!StringUtils.isBlank(area)) {
				 PlatformUser userByCode = platformUserMapper.getUserByCode(area);
				 if(userByCode != null) {
					 afterInfo.setSaleAfterMan(userByCode.getUserName()+"-"+userByCode.getPhoneNumber());
				 }
			 }
		}
		return JsonResult.successJsonResult(afterInfo);
	}
	
	/**
	 * 
	 * <p>添加订单售后</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	public JsonResult<String> insertSaleAfter(@RequestBody PlatformSaleAfter platformSaleAfter){
		platformSaleAfter.setCreateTime(new Date());
		platformSaleAfter.setStatus((byte)0);
		platformSaleAfter.setServiceNumber(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddmmhhssSSS")));
		platformSaleafterMapper.insertSaleAfter(platformSaleAfter);
		PlatformSaleDetail psd = new PlatformSaleDetail();
		psd.setDealintTime(new Date());
		psd.setServiceNumber(platformSaleAfter.getServiceNumber());
		psd.setStatus(platformSaleAfter.getStatus());
		platformSaledetailMapper.insertSaleDetail(psd);
		return JsonResult.successJsonResult();
	}
	
	/**
	 * 
	 * <p>订单售后更新</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	public JsonResult<String> updateSaleAfter(@RequestBody UpdateSaleInfo updateSaleInfo){
		platformSaleafterMapper.updateSaleAfter(updateSaleInfo.getType(), updateSaleInfo.getServiceNumber());
		PlatformSaleDetail psd = new PlatformSaleDetail();
		psd.setDealingMan(updateSaleInfo.getMan());
		psd.setDealintTime(new Date());
		psd.setRemake(updateSaleInfo.getRemake());
		psd.setServiceNumber(updateSaleInfo.getServiceNumber());
		psd.setStatus(updateSaleInfo.getType());
		platformSaledetailMapper.insertSaleDetail(psd);
		return JsonResult.successJsonResult();
	}
	
}
