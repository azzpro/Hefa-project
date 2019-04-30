package com.hefa.order.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.order.pojo.ClientSelectionRecord;
import com.hefa.order.pojo.vo.ProductInfo;

@Mapper
public interface ClientSelectionRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientSelectionRecord record);

    int insertSelective(ClientSelectionRecord record);

    ClientSelectionRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientSelectionRecord record);

    int updateByPrimaryKey(ClientSelectionRecord record);
    
    /**
     * 
     * <p>根据主键查询产品信息</p>
     * @param productCode
     * @return
     * @author 黄智聪  2019年4月30日 下午3:56:01
     */
    ProductInfo getProductInfoByProductCode(String productCode);
}