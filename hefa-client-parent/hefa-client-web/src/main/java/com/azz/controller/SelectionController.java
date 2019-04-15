/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月26日 上午10:57:20
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azz.controller.utils.WebUtils;
import com.azz.core.common.JsonResult;
import com.azz.core.common.QueryPage;
import com.azz.core.common.page.Pagination;
import com.azz.order.api.client.SelectionService;
import com.azz.order.selection.bo.AddSelectionRecordParam;
import com.azz.order.selection.bo.AddToShoppingCartParam;
import com.azz.order.selection.bo.DelSelectionRecordParam;
import com.azz.order.selection.bo.ModuleInitParamsParam;
import com.azz.order.selection.bo.OrderParam;
import com.azz.order.selection.bo.SearchCombinationInitParamsParam;
import com.azz.order.selection.bo.SearchInitParamsParam;
import com.azz.order.selection.bo.SearchInitParamsParamWithSort;
import com.azz.order.selection.bo.SearchSelectionModuleParam;
import com.azz.order.selection.bo.SearchSelectionRecordParam;
import com.azz.order.selection.vo.CombinationDetail;
import com.azz.order.selection.vo.CombinationInfo;
import com.azz.order.selection.vo.CombinationInitParams;
import com.azz.order.selection.vo.InitParams;
import com.azz.order.selection.vo.ModuleDetail;
import com.azz.order.selection.vo.ProductInfomation;
import com.azz.order.selection.vo.ProductPrice;
import com.azz.order.selection.vo.SelectionCaseInfo;
import com.azz.order.selection.vo.SelectionIndexData;
import com.azz.order.selection.vo.SelectionModuleInfo;
import com.azz.order.selection.vo.SelectionRecord;
import com.azz.order.selection.vo.ShoppingCartProductInfo;
import com.azz.platform.merchant.api.ClassificationService;
import com.azz.platform.merchant.pojo.bo.SearchChildClassificationParam;
import com.azz.platform.merchant.pojo.bo.SearchClassificationListParam;
import com.azz.platform.merchant.pojo.vo.ChildClassification;
import com.azz.platform.merchant.pojo.vo.ClassificationList;

/**
 * <P>选型</P>
 * @version 1.0
 * @author 黄智聪  2018年11月26日 上午10:57:20
 */
@RestController
@RequestMapping("/azz/api/client/selection")
public class SelectionController {
	
	@Autowired
	private SelectionService selectionService;
	
	@Autowired
    private ClassificationService classificationService;
	
	/**
	 * <p>查询选型的所有方案列表 1</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2018年11月19日 下午5:57:39
	 */
	@RequestMapping("/getSelectionCaseInfos")
	public JsonResult<Pagination<SelectionCaseInfo>> getSelectionCaseInfos(QueryPage param){
		return selectionService.getSelectionCaseInfos(param);
	}
	
	/**
	 * 
	 * <p>查询初始化参数 2</p>
	 * @param caseCode
	 * @return
	 * @author 黄智聪  2018年11月20日 下午7:32:51
	 */
	@RequestMapping(value = "/getInitParamsByCaseCode",produces="application/json;charset=UTF-8")
	public JsonResult<List<InitParams>> getInitParamsByCaseCode(@RequestBody SearchInitParamsParam param){
		return selectionService.getInitParamsByCaseCode(param);
	}
	
	/**
	 * 
	 * <p>根据参数完善页中选中的参数，获取符合这些参数的产品的公共参数   3</p>
	 * @param caseCode
	 * @return
	 * @author 黄智聪  2018年11月20日 下午7:32:14
	 */
	@RequestMapping(value = "/getCombinationInitParams" ,produces="application/json;charset=UTF-8")
	public JsonResult<List<CombinationInitParams>> getCombinationInitParams(@RequestBody SearchInitParamsParam param){
		return selectionService.getCombinationInitParams(param);
	}
	
	/**
	 * 
	 * <pre>
	 * 		根据参数完善页中选中的参数，获取符合这些参数的产品的公共参数   3.1
	 * </pre>
	 * @param caseCode
	 * @return
	 * @author 黄智聪  2018年11月20日 下午7:32:14
	 */
	@RequestMapping(value = "/getCombinationParams" ,produces="application/json;charset=UTF-8")
	public JsonResult<List<CombinationInitParams>> getCombinationParams(@RequestBody SearchInitParamsParam param){
		return selectionService.getCombinationParams(param);
	}
	
	/**
	 * 
	 * <p>查询推荐组合列表 4</p>
	 * @param caseCode
	 * @return
	 * @author 黄智聪  2018年11月20日 下午7:32:51
	 */
	@RequestMapping(value = "/getCombinationInfos",produces="application/json;charset=UTF-8")
	public JsonResult<Pagination<CombinationInfo>> getCombinationInfos(@RequestBody SearchInitParamsParamWithSort param){
		return selectionService.getCombinationInfos(param);
	}
	
	/**
	 * 
	 * <p>查询推荐组合详情（包含推荐组合的信息、所包含的产品的公共选型参数、产品列表）  5</p>
	 * @param combinationCode
	 * @return
	 * @author 黄智聪  2018年11月22日 下午3:12:23
	 */
	@RequestMapping(value = "/getCombinationDetail",produces="application/json;charset=UTF-8")
	public JsonResult<CombinationDetail> getCombinationDetail(@RequestBody SearchCombinationInitParamsParam searchParam){
		return selectionService.getCombinationDetail(searchParam);
	}
	
	/**
	 * 
	 * <p>根据所选参数查询产品列表  6</p>
	 * @param searchParam
	 * @return
	 * @author 黄智聪  2018年11月22日 下午9:15:42
	 */
	@RequestMapping(value = "/getProductInfos",produces="application/json;charset=UTF-8")
	public JsonResult<List<List<Object>>> getProductInfos(@RequestBody SearchCombinationInitParamsParam searchParam){
		return selectionService.getProductInfos(searchParam);
	}
	
	/**
	 * 
	 * <p>根据产品编码查询该产品的价格信息 7</p>
	 * @param productCode
	 * @return
	 * @author 黄智聪  2018年11月23日 上午11:11:52
	 */
	@RequestMapping("/getProductPrice")
	public JsonResult<ProductPrice> getProductPrice(String productCode){
		return selectionService.getProductPrice(productCode);
	}
	
	/**
	 * 
	 * <p>查询选型记录 8</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2018年11月23日 上午11:11:52
	 */
	@RequestMapping("/getSelectionRecord")
	public JsonResult<Pagination<SelectionRecord>> getSelectionRecord(SearchSelectionRecordParam param){
		param.setClientUserCode(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
		return selectionService.getSelectionRecord(param);
	}
	
	/**
	 * 
	 * <p>保存选型记录 9</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2018年11月23日 下午3:48:46
	 */
	@RequestMapping("/addSelectionRecord")
	public JsonResult<String> addSelectionRecord(AddSelectionRecordParam param){
		param.setClientUserCode(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
		return selectionService.addSelectionRecord(param);
	}
	
	/**
	 * 
	 * <p>删除选型记录 10</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2018年11月23日 下午6:32:17
	 */
	@RequestMapping(value = "/delSelectionRecord",produces="application/json;charset=UTF-8")
	public JsonResult<String> delSelectionRecord(@RequestBody DelSelectionRecordParam param){
		param.setClientUserCode(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
		return selectionService.delSelectionRecord(param);
	}
	
	/**
	 * 
	 * <p>添加产品到购物车 11</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2018年11月23日 下午3:48:46
	 */
	@RequestMapping(value = "/addProductsToShoppingCart",produces="application/json;charset=UTF-8")
	public JsonResult<String> addProductsToShoppingCart(@RequestBody AddToShoppingCartParam param){
		param.setClientUserCode(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
		return selectionService.addProductsToShoppingCart(param);
	}
	
	/**
	 * 
	 * <p>查询购物车产品信息 12</p>
	 * @param clientUserCode
	 * @return
	 * @author 黄智聪  2018年11月23日 下午6:23:58
	 */
	@RequestMapping("/getShoppingCartProductInfos")
	public JsonResult<List<ShoppingCartProductInfo>> getShoppingCartProductInfos(){
		return selectionService.getShoppingCartProductInfos(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
	}
	
	/**
	 * 
	 * <p>移除购物车中的产品 13</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2018年11月23日 下午6:49:03
	 */
	@RequestMapping("/removeShoppingCartProduct")
	public JsonResult<String> removeShoppingCartProduct(Long shoppingCartId){
		return selectionService.removeShoppingCartProduct(shoppingCartId);
	}
	
	/**
	 * 
	 * <p>查询确认订单页面的商品信息 14</p>
	 * @param clientUserCode
	 * @return
	 * @author 黄智聪  2018年11月24日 下午3:03:52
	 */
	@RequestMapping("/getConfirmOrderProductInfos")
	public JsonResult<List<ProductInfomation>> getConfirmOrderProductInfos(){
		return selectionService.getConfirmOrderProductInfos(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
	}
	
	/**
	 * 
	 * <p>查询用户是否能对购物车的产品进行下单操作 15</p>
	 * @param clientUserCode
	 * @return
	 * @author 黄智聪  2018年11月23日 下午6:57:21
	 */
	@RequestMapping("/checkOrderOpt")
	public JsonResult<String> checkOrderOpt(){
		return selectionService.checkOrderOpt(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
	}
	
	/**
	 * 
	 * <p>下单 16</p>
	 * @return
	 * @author 黄智聪  2018年11月24日 上午10:58:45
	 */
	@RequestMapping(value = "/addOrder",produces="application/json;charset=UTF-8")
	public JsonResult<String> addOrder(@RequestBody OrderParam param){
		param.setClientUserCode(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
		return selectionService.addOrder(param);
	}
	
	/********************************************* 选型二期 **********************************************/
	
	/**
	 * 
	 * <p>查询个人中心首页选型记录数据   1</p>
	 * @param clientUserCode
	 * @return
	 * @author 黄智聪  2018年12月18日 下午3:38:50
	 */
	@RequestMapping("/getSelectionIndexData")
	public JsonResult<SelectionIndexData> getSelectionIndexData(){
		return selectionService.getSelectionIndexData(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
	}
	
	/**
	 * 
	 * <p>根据分类编码查询模组列表  2</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2018年12月18日 下午6:13:27
	 */
	@RequestMapping(value = "/getSelectionModuleInfos" ,produces="application/json;charset=UTF-8")
	public JsonResult<Pagination<SelectionModuleInfo>> getSelectionModuleInfos(@RequestBody SearchSelectionModuleParam param){
		return selectionService.getSelectionModuleInfos(param);
	}
	
	/**
	 * 
	 * <p>查询选择三级分类后的初始化参数 3</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2018年12月19日 上午10:50:02
	 */
	@RequestMapping(value= "/getSelectionModuleParams",produces="application/json;charset=UTF-8")
	public JsonResult<List<InitParams>> getSelectionModuleParams(@RequestBody SearchSelectionModuleParam param) {
		return selectionService.getSelectionModuleParams(param);
	}
	
	/**
	 * 
	 * <p>查询模组详情 4</p>
	 * @param moduleCode
	 * @return
	 * @author 黄智聪  2018年12月19日 上午11:40:58
	 */
	@RequestMapping(value = "/getModuleDetail",produces="application/json;charset=UTF-8")
	public JsonResult<ModuleDetail> getModuleDetail(@RequestBody ModuleInitParamsParam param){
		return selectionService.getModuleDetail(param);
	}
	
	/**
	 * <p>获取分类下级的子级分类信息</p>
	 * @param param
	 * @return
	 * @author 彭斌  2018年12月20日 下午1:35:40
	 */
	@RequestMapping("/getClassificationChildPagination")
	public JsonResult<Pagination<ChildClassification>> getClassificationChildPagination(SearchChildClassificationParam param){
	    return classificationService.getClassificationChildPagination(param);
	}
	
	/**
	 * <p>获取一级二级三级分类信息</p>
	 * @param param
	 * @return
	 * @author 彭斌  2018年12月20日 下午1:56:00
	 */
	@RequestMapping(value="getClassificationList")
    public JsonResult<List<ClassificationList>> getClassificationList(SearchClassificationListParam param){
        return classificationService.getClassificationList(param);
    }
	
	/********************************************* 选型二期 **********************************************/

}

