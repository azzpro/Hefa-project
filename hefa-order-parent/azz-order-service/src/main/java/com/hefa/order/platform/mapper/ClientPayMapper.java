/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月26日 下午2:18:55
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.platform.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.order.platform.bo.PayOrderListParam;
import com.hefa.order.platform.pojo.ClientPay;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年11月26日 下午2:18:55
 */
@Mapper
public interface ClientPayMapper {
	/**
	 * <p>插入支付</p>
	 * @param pp
	 * @return
	 * @author 刘建麟  2018年11月26日 下午2:30:31
	 */
	int insertPay(ClientPay pp);
	
	/**
	 * <p>支付列表</p>
	 * @param pl
	 * @return
	 * @author 刘建麟  2018年12月3日 下午2:58:46
	 */
	List<ClientPay> selectPayList(PayOrderListParam pl);
	
	/**
	 * 查询订单是否已支付
	 * @param map
	 * @return
	 */
	int selectOrderStatus(Map<String,Object> map);
	
	/**
	 * 更新订单状态
	 * @param map
	 * @return
	 */
	int updateOrderByNumber(Map<String,Object> map);
	
	/**
	 * 查询订单号
	 * @param no_order
	 * @return
	 */
	String selectOrderCode(String no_order);
	
	/**
	 * @param order_number
	 * @return
	 */
	List<ClientPay> selectOrder(String order_number);
	
	/**
	 * @param number
	 * @return
	 */
	ClientPay selectPayInfoByPayNumber(String number);
}

