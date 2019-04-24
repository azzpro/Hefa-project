package com.hefa.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.user.pojo.ClientUserSalesman;
import com.hefa.user.pojo.bo.SearchInvitedUserInfoParam;
import com.hefa.user.pojo.vo.InvitedUserInfo;

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
    
    /**
     * 
     * <p>查询客户端用户是否已经绑定了业务员</p>
     * @param userCode
     * @return
     * @author 黄智聪  2019年4月24日 下午3:34:05
     */
    int countByUserCode(String userCode);
    
    /**
     * 
     * <p>查询已邀请会员信息</p>
     * @param param
     * @return
     * @author 黄智聪  2019年4月24日 下午4:08:42
     */
    List<InvitedUserInfo> getInvitedUserInfos(SearchInvitedUserInfoParam param);
}