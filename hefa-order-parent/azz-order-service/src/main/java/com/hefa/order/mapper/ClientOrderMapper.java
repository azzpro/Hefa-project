package com.hefa.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.order.pojo.ClientOrder;
import com.hefa.order.pojo.bo.SearchOrderInfoParam;
import com.hefa.order.pojo.vo.OrderInfo;

@Mapper
public interface ClientOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientOrder record);

    int insertSelective(ClientOrder record);

    ClientOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientOrder record);

    int updateByPrimaryKey(ClientOrder record);
    
    /**
     * 
     * <p>查询订单列表</p>
     * @param param
     * @return
     * @author 黄智聪  2019年4月22日 下午7:53:40
     */
    List<OrderInfo> getOrderInfos(SearchOrderInfoParam param);
    
    /**
     * 
     * <p>查询订单详情</p>
     * @param orderCode
     * @return
     * @author 黄智聪  2019年4月22日 下午8:35:17
     */
    OrderInfo getOrderInfoByOrderCode(String orderCode);
}