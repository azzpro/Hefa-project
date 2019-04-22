/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月14日 下午2:20:05
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hefa.system.pojo.SystemMsgLog;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年11月14日 下午2:20:05
 */
@Mapper
public interface SystemMsgLogMapper {
	
	int insertSelective(SystemMsgLog sml);
	
	List<SystemMsgLog> findMsgLogByPhone(@Param("phone") Long phone,@Param("date") String date);
	
	List<SystemMsgLog> findMsgLogByMail(@Param("mail") String mail,@Param("date") String date);
	
	int updaetSmsStatus(@Param("status") Integer status,@Param("id") Long id);
	
	SystemMsgLog findMsgLog(Long phone );
	
	SystemMsgLog findMailLog(String mail );
	
	SystemMsgLog findMsgLogByMailAndCode(@Param("mail") String mail,@Param("code") String code);
	
	SystemMsgLog findMsgLogByPhoneAndCode(@Param("phone") Long phone,@Param("code") String code);
}

