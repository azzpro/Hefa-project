package com.hefa.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.order.pojo.ClientSelectionRecord;
import com.hefa.order.pojo.bo.SearchSelectionInfoParam;
import com.hefa.order.pojo.vo.ProductInfo;
import com.hefa.order.pojo.vo.SelectionProductInfo;

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
    
    /**
     * 
     * <p>查询客户选型记录</p>
     * @param param
     * @return
     * @author 黄智聪  2019年4月30日 下午6:10:21
     */
    List<SelectionProductInfo> getSelectionInfos(SearchSelectionInfoParam param);
}