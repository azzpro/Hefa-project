package com.hefa.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.user.pojo.ClientUserSalesman;

@Mapper
public interface ClientUserSalesmanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientUserSalesman record);

    int insertSelective(ClientUserSalesman record);

    ClientUserSalesman selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientUserSalesman record);

    int updateByPrimaryKey(ClientUserSalesman record);
    
    /**
     * 
     * <p>查询业务员是否绑定会员信息</p>
     * @param salesmanCode
     * @return
     * @author 黄智聪  2019年4月23日 下午5:34:54
     */
    int countBySalesmanCode(String salesmanCode);
}