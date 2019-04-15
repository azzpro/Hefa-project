package com.azz.client.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.azz.client.pojo.ClientUser;
import com.azz.client.pojo.bo.SearchClientUserParam;
import com.azz.client.pojo.vo.ClientCompanyInfo;
import com.azz.client.pojo.vo.ClientPersonalInfo;
import com.azz.client.pojo.vo.ClientUserInfo;

@Mapper
public interface ClientUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientUser record);

    int insertSelective(ClientUser record);

    ClientUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientUser record);

    int updateByPrimaryKey(ClientUser record);
    
    int updateByClientUserCode(ClientUser record);
    
    ClientUser getClientUserByPhoneNumber(String phoneNumber);
    
    ClientUser getClientUserByOpenid(String openid);
    
    ClientUserInfo getClientUserInfoByPhoneNumber(String phoneNumber);
    
    ClientUser getClientUserByClientUserCode(String clientUserCode);
    
    /**
     * 
     * <p>根据邮箱查询用户</p>
     * @param email
     * @param merchantUserCode
     * @return
     * @author 黄智聪  2018年10月20日 下午3:05:55
     */
    ClientUser getClientUserByEmail(@Param("email") String email, @Param("clientUserCode") String clientUserCode);

    /**
     * 
     * <p>根据手机号查询用户实体</p>
     * @param phoneNumber 手机号
     * @return
     * @author 黄智聪  2018年10月17日 下午7:14:23
     */
    ClientUser getClientUserByPhoneNumberAndClientUserCode(@Param("phoneNumber") String phoneNumber, @Param("clientUserCode") String clientUserCode);
    
    /**
     * 
     * <p>根据查询条件查询用户信息</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月20日 上午10:10:19
     */
    List<ClientUserInfo> getClientUserInfoBySearchParam(SearchClientUserParam param);

    /**
     * 
     * <p>根据用户编码查询用户信息</p>
     * @param clientUserCode
     * @return
     * @author 黄智聪  2018年10月20日 上午10:51:33
     */
    ClientUserInfo getClientUserInfoByClientUserCode(String clientUserCode);
    
    /**
     * 
     * <p>根据用户编码查询客户个人资料</p>
     * @param clientUserCode
     * @return
     * @author 黄智聪  2018年10月20日 上午10:51:33
     */
    ClientPersonalInfo getClientPersonalInfoByClientUserCode(String clientUserCode);
    
    /**
     * 
     * <p>根据用户编码查询公司信息</p>
     * @param clientUserCode
     * @return
     * @author 黄智聪  2018年10月30日 上午2:46:06
     */
    ClientCompanyInfo getClientCompanyInfoByClientUserCode(String clientUserCode);
}