/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月30日 下午1:54:13
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.client.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.hefa.common.base.JsonResult;
import com.hefa.common.exception.ValidationException;
import com.hefa.order.mapper.ClientSelectionRecordMapper;
import com.hefa.order.mapper.ClientShoppingCartMapper;
import com.hefa.order.pojo.ClientSelectionRecord;
import com.hefa.order.pojo.ClientShoppingCart;
import com.hefa.order.pojo.bo.AddSelectionRecordToShoppingCartParam;
import com.hefa.order.pojo.bo.AddToShoppingCartParam;
import com.hefa.order.pojo.vo.ProductInfo;
import com.hefa.utils.JSR303ValidateUtils;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月30日 下午1:54:13
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class SelectionService {
	
	@Autowired
	private ClientShoppingCartMapper clientShoppingCartMapper;
	
	@Autowired
	private ClientSelectionRecordMapper clientSelectionRecordMapper;
	
	/**
	 * 
	 * <pre>
	 * 	添加产品到购物车
	 * 		1.生成相应的选型记录（若有相同选型记录，则替换原来的选型记录）
	 * 		2.加入购物车
	 * </pre>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月30日 下午3:45:24
	 */
	public JsonResult<String> addProductToShoppingCart(@RequestBody AddToShoppingCartParam param){
		JSR303ValidateUtils.validateInputParam(param);
		ProductInfo productInfo = clientSelectionRecordMapper.getProductInfoByProductCode(param.getProductCode());
		if(productInfo == null) {
			throw new ValidationException("所选产品记录不存在");
		}
		Date nowDate = new Date();
		String selectionRecordCode = null;
		ClientSelectionRecord selectionRecord = ClientSelectionRecord.builder()
				.price(productInfo.getPrice())
				.productCode(productInfo.getProductCode())
				.productModelNo(productInfo.getProductModelNo())
				.productName(productInfo.getProductName())
				.specificationInfo(productInfo.getSpecificationInfo())
				.build();
		// 1.生成相应的选型记录
		// 如果没有相应选型记录，则新增一条选型记录
		if(productInfo.getSelectionRecordId() == null) {
			selectionRecordCode = "SR" + System.currentTimeMillis();
			selectionRecord.setCreateTime(nowDate);
			selectionRecord.setCreator(param.getUserCode());
			selectionRecord.setUserCode(param.getUserCode());
			selectionRecord.setSelectionRecordCode(selectionRecordCode);
			clientSelectionRecordMapper.insertSelective(selectionRecord);
		}else {// 如果有相应选型记录，则修改相应选型记录，将原数据刷新为最新产品信息
			selectionRecordCode = productInfo.getSelectionRecordCode();
			selectionRecord.setId(productInfo.getSelectionRecordId());
			selectionRecord.setModifyTime(nowDate);
			selectionRecord.setModifier(param.getUserCode());
			clientSelectionRecordMapper.updateByPrimaryKeySelective(selectionRecord);
		}
		// 2.加入购物车
		ClientShoppingCart shoppingCartRecord = ClientShoppingCart.builder()
				.createTime(nowDate)
				.creator(param.getUserCode())
				.selectionRecordCode(selectionRecordCode)
				.userCode(param.getUserCode())
				.build();
		clientShoppingCartMapper.insertSelective(shoppingCartRecord);
		
		return JsonResult.successJsonResult();
	}
	
	/**
	 * 
	 * <p>从选型列表中选中选型记录加入至购物车</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月30日 下午3:52:37
	 */
	public JsonResult<String> addSelectionRecordToShoppingCart(@RequestBody AddSelectionRecordToShoppingCartParam param){
		JSR303ValidateUtils.validateInputParam(param);
		
		
		
		
		return JsonResult.successJsonResult();
	}

}

