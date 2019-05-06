/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年5月6日 下午1:50:25
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.order.api.client.SelectionService;
import com.hefa.order.pojo.bo.AddSelectionRecordToShoppingCartParam;
import com.hefa.order.pojo.bo.AddToShoppingCartParam;
import com.hefa.order.pojo.bo.GenerateOrderParam;
import com.hefa.order.pojo.bo.RemoveSelectionRecordParam;
import com.hefa.order.pojo.bo.RemoveShoppingCartProductParam;
import com.hefa.order.pojo.bo.SearchSelectionInfoParam;
import com.hefa.order.pojo.vo.ModelInfo;
import com.hefa.order.pojo.vo.PayOrderInfo;
import com.hefa.order.pojo.vo.SelectionProductInfo;
import com.hefa.order.pojo.vo.ShoppingCartInfo;

/**
 * <P>选型</P>
 * @version 1.0
 * @author 黄智聪  2019年5月6日 下午1:50:25
 */
@RestController
@RequestMapping("/hefa/api/client/selection")
public class SelectionController {
	
	@Autowired
	private SelectionService selectionService;

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
	@RequestMapping("addProductToShoppingCart")
	public JsonResult<String> addProductToShoppingCart(AddToShoppingCartParam param){
		param.setUserCode("2");// TODO
		return selectionService.addProductToShoppingCart(param);
	}
	
	/**
	 * 
	 * <p>从选型列表中选中选型记录加入至购物车</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月30日 下午3:52:37
	 */
	@RequestMapping("addSelectionRecordToShoppingCart")
	public JsonResult<String> addSelectionRecordToShoppingCart(AddSelectionRecordToShoppingCartParam param){
		param.setUserCode("2");// TODO
		return selectionService.addSelectionRecordToShoppingCart(param);
	}
	
	/**
	 * 
	 * <p>删除选型记录</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年5月5日 下午5:14:00
	 */
	@RequestMapping("removeSelectionRecord")
	public JsonResult<String> removeSelectionRecord(RemoveSelectionRecordParam param){
		param.setUserCode("2");// TODO
		return selectionService.removeSelectionRecord(param);
	}
	
	/**
	 * 
	 * <p>查询选型列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月30日 下午6:02:01
	 */
	@RequestMapping("getSelectionInfos")
	public JsonResult<Pagination<SelectionProductInfo>> getSelectionInfos(SearchSelectionInfoParam param){
		param.setUserCode("2");
		return selectionService.getSelectionInfos(param);
	}
	
	/**
	 * 
	 * <p>查询产品型号详情</p>
	 * @param selectionRecordCode
	 * @return
	 * @author 黄智聪  2019年5月5日 上午10:32:31
	 */
	@RequestMapping("getProductModelInfo")
	public JsonResult<ModelInfo> getProductModelInfo(@RequestParam("selectionRecordCode")String selectionRecordCode){
		return selectionService.getProductModelInfo(selectionRecordCode);
	}
	
	/**
	 * 
	 * <p>查询购物车列表</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2019年5月5日 上午10:14:23
	 */
	@RequestMapping("getShoppingCartInfos")
	public JsonResult<List<ShoppingCartInfo>> getShoppingCartInfos(){
		String userCode = "2";// TODO
		return selectionService.getShoppingCartInfos(userCode);
	}
	
	/**
	 * 
	 * <p>移除购物车中的产品</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年5月5日 上午10:24:36
	 */
	@RequestMapping("removeShoppingCartProduct")
	public JsonResult<String> removeShoppingCartProduct(RemoveShoppingCartProductParam param){
		param.setUserCode("2");// TODO
		return selectionService.removeShoppingCartProduct(param);
	}
	
	/**
	 * 
	 * <p>生成订单信息</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年5月5日 下午5:53:01
	 */
	@RequestMapping("generateOrder")
	public JsonResult<PayOrderInfo> generateOrder(GenerateOrderParam param){
		param.setUserCode("2"); // TODO
		return selectionService.generateOrder(param);
	}
	
}

