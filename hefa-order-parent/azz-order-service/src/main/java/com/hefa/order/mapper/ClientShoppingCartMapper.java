package com.hefa.order.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hefa.order.pojo.ClientShoppingCart;

@Mapper
public interface ClientShoppingCartMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientShoppingCart record);

    int insertSelective(ClientShoppingCart record);

    ClientShoppingCart selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientShoppingCart record);

    int updateByPrimaryKey(ClientShoppingCart record);

	ClientShoppingCart selectBySelectionRecordCodeAndClientUserCode(@Param("selectionRecordCode")String selectionRecordCode, @Param("userCode")String userCode);
}