package com.hefa.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.order.pojo.ClientOrderItem;
import com.hefa.order.pojo.vo.OrderItemInfo;

@Mapper
public interface ClientOrderItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientOrderItem record);

    int insertSelective(ClientOrderItem record);

    ClientOrderItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientOrderItem record);

    int updateByPrimaryKey(ClientOrderItem record);
    
    /**
     * 
     * <p>查询订单细项</p>
     * @param orderCode
     * @return
     * @author 黄智聪  2019年4月22日 下午8:42:40
     */
    List<OrderItemInfo> getOrderItemInfosByOrderCode(String orderCode);
}