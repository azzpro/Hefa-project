package com.hefa.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hefa.order.pojo.ClientShoppingCart;
import com.hefa.order.pojo.bo.OrderItem;
import com.hefa.order.pojo.bo.RemoveShoppingCartProductParam;
import com.hefa.order.pojo.vo.ShoppingCartInfo;

@Mapper
public interface ClientShoppingCartMapper {
    int deleteByPrimaryKey(Long id);
    
    int insert(ClientShoppingCart record);

    int insertSelective(ClientShoppingCart record);

    ClientShoppingCart selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientShoppingCart record);

    int updateByPrimaryKey(ClientShoppingCart record);

	ClientShoppingCart selectBySelectionRecordCodeAndClientUserCode(@Param("selectionRecordCode")String selectionRecordCode, @Param("userCode")String userCode);

	/**
	 * 
	 * <p>查询客户购物车信息</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2019年5月5日 上午10:21:01
	 */
	List<ShoppingCartInfo> getShoppingCartInfos(String userCode);
	
	/**
	 * 
	 * <p>移除购物车中的产品</p>
	 * @param selectionRecordCode
	 * @return
	 * @author 黄智聪  2019年5月5日 上午10:28:43
	 */
	int removeShoppingCartRecord(RemoveShoppingCartProductParam param);
	
	/**
     * 
     * <p>查询客户购物车的商品信息</p>
     * @param clientUserCode
     * @param orderItems
     * @return
     * @author 黄智聪  2018年11月24日 下午1:24:54
     */
    List<ShoppingCartInfo> getShoppingCartOrderItems(@Param("userCode") String userCode, @Param("orderItems") List<OrderItem> orderItems);

    /**
     * 
     * <p>清空客户的购物车</p>
     * @param userCode
     * @return
     * @author 黄智聪  2019年5月5日 下午7:35:15
     */
    int deleteShoppingCartByUserCode(String userCode);
    
    /**
     * 
     * <p>购物车中是否存在相同的产品</p>
     * @param selectionRecordCode
     * @return
     * @author 黄智聪  2019年5月6日 下午3:30:36
     */
    Long existSameProduct(String selectionRecordCode);
}