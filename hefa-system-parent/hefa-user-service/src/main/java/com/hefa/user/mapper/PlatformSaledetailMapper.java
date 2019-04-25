package com.hefa.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.user.pojo.PlatformSaleDetail;
import com.hefa.user.pojo.bo.ServiceSaleAfterParam;
import com.hefa.user.pojo.vo.ServiceSaleInfo;

@Mapper
public interface PlatformSaledetailMapper {

	/**
	 * 新增订单售后记录
	 * @param psf
	 * @return
	 */
	int insertSaleDetail(PlatformSaleDetail psf);
	
	/**
	 * 获取订单售后记录
	 * @param ssap
	 * @return
	 */
	List<PlatformSaleDetail> getSaleDetailList(String number);
}
