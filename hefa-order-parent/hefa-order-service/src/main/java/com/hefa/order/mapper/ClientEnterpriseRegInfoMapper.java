package com.hefa.order.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hefa.order.pojo.yeepay.Enterprisereginfoadd;

@Mapper
public interface ClientEnterpriseRegInfoMapper {

	int updateEnterpriseStatus();
	
	/**
	 * 根据子商编查询 商户详情
	 * @param merchantNo
	 * @return
	 */
	Enterprisereginfoadd selectEnterpriseInfoByMerchantNo(String merchantNo);
	
	/**
	 * 插入子商户入网企业信息
	 * @param eif
	 * @return
	 */
	int insertSelective(Enterprisereginfoadd eif);
	
	/**
	 * 根据商户全称和开卡号 查询状态
	 * @param cn
	 * @param mfn
	 * @return
	 */
	String selectStatusByCardNoAndMerFullName(@Param("cn") String cn,@Param("mfn") String mfn);
}
