package com.hefa.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hefa.user.pojo.PlatformSaleAfter;
import com.hefa.user.pojo.bo.ServiceSaleAfterParam;
import com.hefa.user.pojo.vo.OrderItemInfo;
import com.hefa.user.pojo.vo.SaleAfterInfo;
import com.hefa.user.pojo.vo.ServiceSaleInfo;

@Mapper
public interface PlatformSaleafterMapper {

	int selectOrderCount(String code);
	
	/**
	 * 新增订单售后
	 * @param psf
	 * @return
	 */
	int insertSaleAfter(PlatformSaleAfter psf);
	
	/**
	 * 更新订单售后状态
	 * @param status
	 * @param id
	 * @return
	 */
	int updateSaleAfter(@Param("status") Byte status,@Param("number") String id);
	
	
	/**
	 * 确认打款
	 * @param status
	 * @param id
	 * @return
	 */
	int updatePayment(@Param("number") String id);
	
	
	/**
	 * 获取订单售后列表
	 * @param ssap
	 * @return
	 */
	List<ServiceSaleInfo> getSaleAfterList(ServiceSaleAfterParam ssap);
	
	
	/**
	 * 获取退款订单列表
	 * @param ssap
	 * @return
	 */
	List<ServiceSaleInfo> getSaleAfterOrderList(ServiceSaleAfterParam ssap);
	/**
	 * 订单售后详情
	 * @param serviceName
	 * @return
	 */
	SaleAfterInfo getSaleAfterInfo(String serviceName);
	
	/**
	 * 退货订单详情
	 * @param serviceName
	 * @return
	 */
	SaleAfterInfo getSaleAfterOrderInfo(String serviceName);
	
	/**
	 * 订单详情
	 * @param orderCode
	 * @return
	 */
	List<OrderItemInfo> getOrderItemInfosByOrderCode(String orderCode);
	
	/**
	 * 根据用户ID 查询 订单地址表 省市区
	 * @param code
	 * @return
	 */
	Map<String,String> selectAreaNameById(String code);
}
