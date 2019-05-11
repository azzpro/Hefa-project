/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月30日 下午1:54:13
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.client.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.hefa.common.base.JsonResult;
import com.hefa.common.constants.ClientConstants;
import com.hefa.common.constants.PlatformConstants.OrderStatus;
import com.hefa.common.exception.ReturnDataException;
import com.hefa.common.exception.ValidationException;
import com.hefa.common.page.Pagination;
import com.hefa.order.mapper.ClientOrderItemMapper;
import com.hefa.order.mapper.ClientOrderMapper;
import com.hefa.order.mapper.ClientOrderStatusMapper;
import com.hefa.order.mapper.ClientSelectionRecordMapper;
import com.hefa.order.mapper.ClientShippingAddressMapper;
import com.hefa.order.mapper.ClientShoppingCartMapper;
import com.hefa.order.pojo.ClientOrder;
import com.hefa.order.pojo.ClientOrderItem;
import com.hefa.order.pojo.ClientOrderStatus;
import com.hefa.order.pojo.ClientSelectionRecord;
import com.hefa.order.pojo.ClientShippingAddress;
import com.hefa.order.pojo.ClientShoppingCart;
import com.hefa.order.pojo.bo.AddSelectionRecordToShoppingCartParam;
import com.hefa.order.pojo.bo.AddToShoppingCartParam;
import com.hefa.order.pojo.bo.GenerateOrderParam;
import com.hefa.order.pojo.bo.OrderItem;
import com.hefa.order.pojo.bo.RemoveSelectionRecordParam;
import com.hefa.order.pojo.bo.RemoveShoppingCartProductParam;
import com.hefa.order.pojo.bo.SearchSelectionInfoParam;
import com.hefa.order.pojo.vo.ModelInfo;
import com.hefa.order.pojo.vo.PayOrderInfo;
import com.hefa.order.pojo.vo.ProductInfo;
import com.hefa.order.pojo.vo.SelectionProductInfo;
import com.hefa.order.pojo.vo.ShippingAddressInfo;
import com.hefa.order.pojo.vo.ShoppingCartInfo;
import com.hefa.utils.DateUtils;
import com.hefa.utils.JSR303ValidateUtils;
import com.hefa.utils.StringUtils;

/**
 * <P>选型</P>
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
	
	@Autowired
	private ClientOrderMapper clientOrderMapper;

	@Autowired
	private ClientOrderStatusMapper clientOrderStatusMapper;
	
	@Autowired
	private ClientOrderItemMapper clientOrderItemMapper;

	@Autowired
	private ClientShippingAddressMapper clientShippingAddressMapper;
	
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
		int count = clientShippingAddressMapper.existUser(param.getUserCode());
		if(count == 0 ) {
			throw new ReturnDataException("用户记录不存在");
		}
		ProductInfo productInfo = clientSelectionRecordMapper.getProductInfoByProductCode(param.getProductCode(), param.getUserCode());
		if(productInfo == null) {
			throw new ReturnDataException("所选产品记录不存在");
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
		// 购物车中是否存在相同的产品
		Long shoppingCartId = clientShoppingCartMapper.existSameProduct(selectionRecordCode, param.getUserCode());
		if(shoppingCartId != null) {// 若存在，则直接更新购物车中selectionRecordCode为最新的
			ClientShoppingCart shoppingCartRecord = ClientShoppingCart.builder()
					.modifyTime(nowDate)
					.modifier(param.getUserCode())
					.selectionRecordCode(selectionRecordCode)
					.id(shoppingCartId)
					.build();
			clientShoppingCartMapper.updateByPrimaryKeySelective(shoppingCartRecord);
		}else {// 不存在，说明是新的产品，直接加入购物车
			ClientShoppingCart shoppingCartRecord = ClientShoppingCart.builder()
					.createTime(nowDate)
					.creator(param.getUserCode())
					.selectionRecordCode(selectionRecordCode)
					.userCode(param.getUserCode())
					.build();
			clientShoppingCartMapper.insertSelective(shoppingCartRecord);
		}
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
		List<String> selectionRecordCodes = param.getSelectionRecordCodes();
		Date nowDate = new Date();
		for (String selectionRecordCode : selectionRecordCodes) {
			ClientSelectionRecord selectionRecord = clientSelectionRecordMapper.selectByCode(selectionRecordCode);
			if(selectionRecord == null) {
				throw new ReturnDataException("选型记录["+selectionRecordCode+"]不存在");
			}
			// 查询客户选型记录所在的购物车
			ClientShoppingCart record = clientShoppingCartMapper.selectBySelectionRecordCodeAndClientUserCode(selectionRecordCode, param.getUserCode());
			if(record == null) {// 若选型记录未添加至购物车，才将选型记录添加至购物车，否则啥也不干
				ClientShoppingCart shoppingCartRecord = ClientShoppingCart.builder()
						.userCode(param.getUserCode())
						.createTime(nowDate)
						.creator(param.getUserCode())
						.selectionRecordCode(selectionRecordCode)
						.build();
				clientShoppingCartMapper.insertSelective(shoppingCartRecord);
			}
		}
		return JsonResult.successJsonResult();
	}
	
	/**
	 * 
	 * <p>删除选型记录</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年5月5日 下午5:14:00
	 */
	public JsonResult<String> removeSelectionRecord(@RequestBody RemoveSelectionRecordParam param){
		JSR303ValidateUtils.validateInputParam(param);
		ClientSelectionRecord selectionRecord = clientSelectionRecordMapper.selectByCode(param.getSelectionRecordCode());
		if(selectionRecord == null) {
			throw new ReturnDataException("选型记录["+param.getSelectionRecordCode()+"]不存在");
		}
		ClientSelectionRecord record = ClientSelectionRecord.builder()
				.status((byte)0)// 无效状态
				.selectionRecordCode(param.getSelectionRecordCode())
				.modifier(param.getUserCode())
				.modifyTime(new Date())
				.build();
		clientSelectionRecordMapper.updateByCode(record);
		return JsonResult.successJsonResult();
	}
	
	/**
	 * 
	 * <p>查询选型列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月30日 下午6:02:01
	 */
	public JsonResult<Pagination<SelectionProductInfo>> getSelectionInfos(@RequestBody SearchSelectionInfoParam param){
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		List<SelectionProductInfo> infos = clientSelectionRecordMapper.getSelectionInfos(param);
		return JsonResult.successJsonResult(new Pagination<>(infos));
	}
	
	/**
	 * 
	 * <p>查询产品型号详情</p>
	 * @param selectionRecordCode
	 * @return
	 * @author 黄智聪  2019年5月5日 上午10:32:31
	 */
	public JsonResult<ModelInfo> getProductModelInfo(@RequestParam("selectionRecordCode")String selectionRecordCode){
		JSR303ValidateUtils.validateNullOrBlank(selectionRecordCode, "请选择选型记录");
		ModelInfo info = clientSelectionRecordMapper.getProductModelInfo(selectionRecordCode);
		if(info == null) {
			throw new ReturnDataException("选型记录不存在");
		}
		return JsonResult.successJsonResult(info);
	}
	
	/**
	 * 
	 * <p>查询购物车列表</p>
	 * @param userCode
	 * @return
	 * @author 黄智聪  2019年5月5日 上午10:14:23
	 */
	public JsonResult<List<ShoppingCartInfo>> getShoppingCartInfos(@RequestParam("userCode")String userCode){
		List<ShoppingCartInfo> shoppingCartInfos = clientShoppingCartMapper.getShoppingCartInfos(userCode);
		return JsonResult.successJsonResult(shoppingCartInfos);
	}
	
	/**
	 * 
	 * <p>移除购物车中的产品</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年5月5日 上午10:24:36
	 */
	public JsonResult<String> removeShoppingCartProduct(@RequestBody RemoveShoppingCartProductParam param){
		JSR303ValidateUtils.validateInputParam(param);
		ClientSelectionRecord selectionRecord = clientSelectionRecordMapper.selectByCode(param.getSelectionRecordCode());
		if(selectionRecord == null) {
			throw new ReturnDataException("选型记录["+param.getSelectionRecordCode()+"]不存在");
		}
		clientShoppingCartMapper.removeShoppingCartRecord(param);
		return JsonResult.successJsonResult();
	}
	
	/**
	 * 
	 * <p>生成订单信息</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年5月5日 下午5:53:01
	 */
	public JsonResult<PayOrderInfo> generateOrder(@RequestBody GenerateOrderParam param){
		JSR303ValidateUtils.validateInputParam(param);
		String shippingAddressCode = param.getShippingAddressCode();
		ClientShippingAddress shippingAddress = clientShippingAddressMapper.selectByCode(shippingAddressCode);
		if(shippingAddress == null) {
			throw new ValidationException("收货地址不存在");
		}
		String userCode = shippingAddress.getUserCode();
		if(!userCode.equals(param.getUserCode())) {// 非当前登录用户的收货地址
			throw new ValidationException("收货地址无效");
		}
		// 前端传入的商品信息
		List<OrderItem> orderItems = param.getItems();
		// 产品数量
		int productCount = 0;
		// key(productCode):value(productCode对应的数量)
		Map<String,Integer> itemMap = new HashMap<>();
		for (int i = 0; i < orderItems.size(); i++) {
			OrderItem item = orderItems.get(i);
			String productCode = item.getProductCode();
			Integer quantity = item.getQuantity();
			if(StringUtils.isBlank(productCode)) {
				throw new ValidationException("第"+ (i + 1) +"个产品编码为空");
			}
			if(quantity == null) {
				throw new ValidationException("请输入产品[" + productCode + "]的下单数量");
			}
			productCount += quantity;
			itemMap.put(productCode, quantity);
		}
		// 查询客户购物车的商品信息,查出来的价格为商品真正的价格
		List<ShoppingCartInfo> items = clientShoppingCartMapper.getShoppingCartOrderItems(param.getUserCode(), orderItems);
		// 比较前端传入的商品信息与购物车的商品信息是否匹配
		if(items.size() != orderItems.size()) {
			throw new ValidationException("商品信息与购物车商品信息不匹配");
		}
		// 总金额
		BigDecimal grandTotal = BigDecimal.ZERO; 
		for (ShoppingCartInfo item : items) {
			// 每个产品的小计 = 产品单价 * 数量（数量通过itemMap的key：productCode来获取）
			grandTotal = grandTotal.add(item.getPrice().multiply(new BigDecimal(itemMap.get(item.getProductCode()))));
		}
		Date nowDate = new Date();
		// 新增未支付的订单记录
		String orderCode = "HFO" + System.currentTimeMillis(); // TODO
		String salesmanCode = clientOrderMapper.getSalesmanCodeByUserCode(userCode);
		ClientOrder clientOrderRecord = ClientOrder.builder()
				.orderCode(orderCode)
				.userCode(userCode)
				.createTime(nowDate)
				.creator(userCode)
				.orderCreator(param.getUserCode())
				.grandTotal(grandTotal)
				.shippingAddressCode(param.getShippingAddressCode())
				.orderStatus((byte)OrderStatus.NOT_PAID.getValue())
				.remark(param.getRemark())
				.deliveryDays(param.getDeliveryDays())
				.salesmanCode(salesmanCode)
				.productCount(productCount)
				.build();
		clientOrderMapper.insertSelective(clientOrderRecord);
		
		// 新增客户订单状态变更记录
		ClientOrderStatus clientOrderStatusRecord = ClientOrderStatus.builder()
				.createTime(nowDate)
				.creator(param.getUserCode())
				.orderCode(orderCode)
				.orderStatus(OrderStatus.NOT_PAID.getValue())
				.remark("客户下单，生成未支付订单")
				.build();
		clientOrderStatusMapper.insertSelective(clientOrderStatusRecord);
		
		// 插入下单产品细项
		for (ShoppingCartInfo shoppingCartInfo : items) {
			ClientOrderItem clientOrderItemRecord = ClientOrderItem.builder()
					.createTime(nowDate)
					.creator(userCode)
					.orderCode(orderCode)
					.productCode(shoppingCartInfo.getProductCode())
					.productPrice(shoppingCartInfo.getPrice())
					.quantity(itemMap.get(shoppingCartInfo.getProductCode()))
					.specificationInfo(shoppingCartInfo.getSpecificationInfo())
					.build();
			clientOrderItemMapper.insertSelective(clientOrderItemRecord);
		}
		
		// 清空客户的购物车信息
		clientShoppingCartMapper.deleteShoppingCartByUserCode(userCode);
		
		PayOrderInfo payOrderInfo = new PayOrderInfo();
		payOrderInfo.setGrandTotal(grandTotal);
		payOrderInfo.setOrderCode(orderCode);
		Date validTime = DateUtils.addHour(nowDate, ClientConstants.ORDER_VALID_TIME_HOURS);
		payOrderInfo.setValidTime(validTime);
		ShippingAddressInfo shippingAddressInfo = clientOrderMapper.getShippingAddressInfo(shippingAddressCode);
		payOrderInfo.setShippingAddressInfo(shippingAddressInfo);
		return JsonResult.successJsonResult(payOrderInfo);
	}
	/**
	 * 
	 * <p>关闭订单--6小时未支付的待支付订单，状态改为已关闭</p>
	 * @return
	 * @author 黄智聪  2018年11月15日 上午10:38:19
	 */
	public JsonResult<String> closeClientOrders(){
		// 查询6小时未支付的订单编码集合
		List<String> orderCodes = clientOrderMapper.getSixHoursNotPaidOrderCodes();
		Date nowDate = new Date();
		for (String orderCode : orderCodes) {
			// 修改订单状态订单状态为已关闭
			ClientOrder clientOrderRecord = ClientOrder.builder()
					.orderCode(orderCode)
					.orderStatus((byte)OrderStatus.CLOSED.getValue())
					.modifyTime(nowDate)
					.remark("6小时未支付，订单状态改为已关闭")
					.build(); 
			clientOrderMapper.updateByOrderCodeSelective(clientOrderRecord);
			// 新增订单状态变更记录
			ClientOrderStatus clientOrderStatusRecord = ClientOrderStatus.builder()
					.createTime(nowDate)
					.orderCode(orderCode)
					.orderStatus(OrderStatus.CLOSED.getValue())
					.remark("6小时未支付，订单状态改为已关闭")
					.build();
			clientOrderStatusMapper.insertSelective(clientOrderStatusRecord);
		}
		return JsonResult.successJsonResult();
	}
	
	
}

