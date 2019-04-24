package com.hefa.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hefa.user.pojo.PlatformUserSalesman;
import com.hefa.user.pojo.bo.SearchSalesmanInfoParam;
import com.hefa.user.pojo.vo.SalesmanInfo;

@Mapper
public interface PlatformUserSalesmanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PlatformUserSalesman record);

    int insertSelective(PlatformUserSalesman record);

    PlatformUserSalesman selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PlatformUserSalesman record);

    int updateByPrimaryKey(PlatformUserSalesman record);
    
    /**
     * 
     * <p>根据平台成员编码统计记录数</p>
     * @param platformUserCode
     * @param id
     * @return
     * @author 黄智聪  2019年4月23日 下午4:55:11
     */
    int countByPlatformUserCode(@Param("platformUserCode")String platformUserCode, @Param("id")Long id);

    /**
     * 
     * <p>根据业务员编码统计记录数</p>
     * @param platformUserCode
     * @return
     * @author 黄智聪  2019年4月23日 下午4:55:11
     */
    int countBySalesmanCode(String salesmanCode);
    
    /**
     * 
     * <p>查询业务员信息</p>
     * @param param
     * @return
     * @author 黄智聪  2019年4月24日 下午2:10:32
     */
    List<SalesmanInfo> getSalesmanInfos(SearchSalesmanInfoParam param);
}