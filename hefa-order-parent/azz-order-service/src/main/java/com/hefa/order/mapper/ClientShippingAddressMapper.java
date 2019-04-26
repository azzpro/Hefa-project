package com.hefa.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.order.pojo.ClientShippingAddress;
import com.hefa.order.pojo.vo.ShippingAddress;

@Mapper
public interface ClientShippingAddressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientShippingAddress record);

    int insertSelective(ClientShippingAddress record);

    ClientShippingAddress selectByPrimaryKey(Long id);
    
    ClientShippingAddress selectByCode(String shippingAddressCode);

    int updateByPrimaryKeySelective(ClientShippingAddress record);

    int updateByPrimaryKey(ClientShippingAddress record);
    
    /**
     * 
     * <p>根据客户编码查询默认收货地址</p>
     * @param userCode
     * @return
     * @author 黄智聪  2018年11月13日 下午3:28:37
     */
    ShippingAddress getDefaultShippingAddressByUserCode(String userCode);
    
    /**
     * 
     * <p>根据客户编码查询收货地址列表</p>
     * @param userCode
     * @return
     * @author 黄智聪  2018年11月13日 下午3:28:37
     */
    List<ShippingAddress> getShippingAddressByUserCode(String userCode);
    
    /**
     * 
     * <p>查询当前客户的收货地址数量</p>
     * @param userCode
     * @return
     * @author 黄智聪  2018年11月13日 下午5:13:18
     */
    int countShippingAddressByUserCode(String userCode);
    
    /**
     * 
     * <p>将客户的其他收货地址设置成非默认</p>
     * @param userCode
     * @return
     * @author 黄智聪  2018年11月13日 下午6:03:11
     */
    int setOtherShippingAddressNotDefault(String userCode);
    
    /**
     * 
     * <p>查询收货地址</p>
     * @param userCode
     * @return
     * @author 黄智聪  2018年11月13日 下午3:28:37
     */
    ShippingAddress getShippingAddressByShippingAddressCode(String shippingAddressCode);
}