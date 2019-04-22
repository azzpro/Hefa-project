package com.hefa.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hefa.user.pojo.PlatformUser;
import com.hefa.user.pojo.bo.SearchUserParam;
import com.hefa.user.pojo.vo.UserInfo;

@Mapper
public interface PlatformUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PlatformUser record);

    int insertSelective(PlatformUser record);

    PlatformUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PlatformUser record);

    int updateByUserCode(PlatformUser record);
    
    int updateByPrimaryKey(PlatformUser record);
    
    /**
     * 
     * <p>根据手机号查询用户实体</p>
     * @param phoneNumber 手机号
     * @return
     * @author 黄智聪  2018年10月17日 下午7:14:23
     */
    PlatformUser getUserByPhoneNumber(@Param("phoneNumber") String phoneNumber, @Param("userCode") String userCode);
    
    /**
     * 
     * <p>根据用户id查询用户信息</p>
     * @param userId
     * @return
     * @author 黄智聪  2018年10月17日 下午7:14:20
     */
    UserInfo getUserInfoByPhoneNumber(String phoneNumber);
    
    /**
     * 
     * <p>根据用户编码查询用户信息</p>
     * @param userCode
     * @return
     * @author 黄智聪  2018年10月20日 上午10:51:33
     */
    UserInfo getUserInfoByUserCode(String userCode);
    
    /**
     * <p>根据用户编码查询</p>
     * @param userCode
     * @return
     * @author 彭斌  2018年10月18日 下午5:14:23
     */
    PlatformUser getUserByUserCode(String userCode);

    /**
     * 
     * <p>根据查询条件查询用户信息</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月20日 上午10:10:19
     */
    List<UserInfo> getUserInfoBySearchParam(SearchUserParam param);
    
    /**
     * 
     * <p>根据邮箱查询用户</p>
     * @param email
     * @param userCode
     * @return
     * @author 黄智聪  2018年10月20日 下午3:05:55
     */
    PlatformUser getUserByEmail(@Param("email") String email, @Param("userCode") String userCode);
}