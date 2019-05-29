/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年11月26日 下午3:15:10
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.hefa.order.client.service;
/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年11月26日 下午3:15:10
 */

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.hefa.common.base.JsonResult;
import com.hefa.common.constants.ClientConstants;
import com.hefa.common.constants.ClientConstants.PayMethod;
import com.hefa.common.constants.ClientConstants.PayStatus;
import com.hefa.common.constants.FileConstantsYeepay;
import com.hefa.common.constants.MerchantConstants;
import com.hefa.common.constants.PayConstants;
import com.hefa.common.constants.PayConstants.PayCode;
import com.hefa.common.constants.PayConstants.RegCode;
import com.hefa.common.constants.PayConstants.YeeCode;
import com.hefa.common.constants.PlatformConstants.OrderStatus;
import com.hefa.common.errorcode.SystemErrorCode;
import com.hefa.common.exception.ValidationException;
import com.hefa.common.page.Pagination;
import com.hefa.order.mapper.ClientEnterpriseRegInfoMapper;
import com.hefa.order.mapper.MerchantYeeBindMapper;
import com.hefa.order.platform.bo.PayOrderListParam;
import com.hefa.order.platform.mapper.ClientPayMapper;
import com.hefa.order.platform.pojo.ClientPay;
import com.hefa.order.platform.vo.PayListInfo;
import com.hefa.order.pojo.bo.CallBackParam;
import com.hefa.order.pojo.vo.OrderDetail;
import com.hefa.order.pojo.vo.OrderInfo;
import com.hefa.order.pojo.yeepay.BankBranch;
import com.hefa.order.pojo.yeepay.EnterprisereginfoCopy;
import com.hefa.order.pojo.yeepay.Enterprisereginfoadd;
import com.hefa.order.pojo.yeepay.MerchantYeeBind;
import com.hefa.order.pojo.yeepay.PageOrder;
import com.hefa.order.pojo.yeepay.RetBean;
import com.hefa.order.pojo.yeepay.YeeModulePic;
import com.hefa.system.api.SystemImageUploadService;
import com.hefa.system.bo.UploadImageParam;
import com.hefa.utils.DateUtils;
import com.hefa.utils.DecimalUtil;
import com.hefa.utils.JSR303ValidateUtils;
import com.hefa.utils.LLPayUtil;

import net.sf.json.JSONObject;

@Service
public class ClientPayService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Value("${yeepay.notify-url}")
	private String notifyUrl;

	@Value("${yeepay.regEn-notify-url}")
	private String regEnNotifyUrl;
	
	@Value("${yeepay.cashWithdralwal-notify-url}")
	private String cashWithdralwalNotifyUrl;
	
	@Value("${yeepay.divide_notify_url}")
	private String divideNotifyUrl;
	
	//支付成功回调页面地址，yml 文件#为注释符号，故写在代码中
	private static final String redirectUrl = "http://c.izz2025.com/main.html#!model/model-paymentOK.html";
	
	@Autowired
	private ClientPayMapper ppm;
	
	@Autowired
	private MerchantYeeBindMapper mybMapper;

	@Autowired
	private ClientOrderService cos;

	@Autowired
	private SelectionService selectService;

	@Autowired
	private ClientEnterpriseRegInfoMapper clientEnterpriseRegInfoMapper;

	@Autowired
	private SystemImageUploadService systemImageUploadService;
	
	//@Autowired
	//private PlatformClientOrderService platformClientOrderService;
	
	//@Autowired
	//private MerchantWithdrawDepositApplyMapper merchantWithdrawDepositApplyMapper;
	
	//@Autowired
	//private ClientOrderPersonalMapper clientOrderPersonalMapper;

	public static String REQUEST_PREFIX = "YOP_ENREG";
	
	/**
	 * <p>
	 * 支付订单详情
	 * </p>
	 * 
	 * @param param
	 * @return
	 * @author 刘建麟 2018年10月31日 上午11:29:49
	 */
	public JsonResult<ClientPay> getOrderInfo(String number) {
		ClientPay payNumber = ppm.selectPayInfoByPayNumber(number);
		// 判断该订单是否处于待支付 并且未失效
		JsonResult<OrderDetail> detail = cos.getOrderDetail(number);
		OrderInfo orderInfo = detail.getData().getOrderInfo();
		payNumber.setCoi(orderInfo);
		return JsonResult.successJsonResult(payNumber);
	}
	
	/**
	 * 提交易宝支付
	 * @param po
	 * @return
	 */
	@Transactional
	public Map<String, Object> submitOrderPay(@RequestBody PageOrder po) {
		List<ClientPay> selectOrder = ppm.selectOrder(po.getOrderCode());
		if (!selectOrder.isEmpty() && selectOrder.size() > 1) {
			throw new ValidationException("支付订单不唯一");
		}
		if (!selectOrder.isEmpty() && selectOrder.get(0).getOrderStatus() != PayStatus.NOT_PAID.getValue()) {
			throw new ValidationException( "支付订单状态异常");
		}
		// 判断该订单是否处于待支付 并且未失效
		JsonResult<OrderDetail> detail = cos.getOrderDetail(po.getOrderCode());
		OrderInfo orderInfo = detail.getData().getOrderInfo();
		if (detail == null || orderInfo == null) {
			throw new ValidationException("客户订单不存在");
		}
		if (OrderStatus.NOT_PAID.getValue() != orderInfo.getOrderStatus()) {
			throw new ValidationException("客户订单状态异常");
		}
		// 订单失效时间为订单创建时间 + 6小时
		Date orderDeadTime = DateUtils.addHour(orderInfo.getOrderTime(), ClientConstants.ORDER_VALID_TIME_HOURS);
		// 失效时间 < 当前时间，订单视为失效
		if (DecimalUtil.lt(new BigDecimal(orderDeadTime.getTime()), new BigDecimal(System.currentTimeMillis()))) {
			throw new ValidationException("订单已失效，请重新下单");
		}
		
		// 根据客户订单编码查询所关联的商户编码
		/*List<String> merchantCodes = clientOrderPersonalMapper.getMerchantCodesByClientOrderCode(po.getOrderCode());
		List<MerchantOrderInfoParam> moips = new ArrayList<>();
		for (String merchantCode : merchantCodes) {
			MerchantOrderInfoParam moip = new MerchantOrderInfoParam();
			moip.setMerchantCode(merchantCode);
			moip.setRemark("系统自动拆分成商户订单");
			moips.add(moip);
		}*/
		// 拆分客户订单生成商户订单
		/*AllocateClientOrderParam acop = new AllocateClientOrderParam();
		acop.setClientOrderCode(po.getOrderCode());
		acop.setInfos(moips);
		acop.setAllocatePerson("admin");
		JsonResult<String> results = platformClientOrderService.allocateClientOrder(acop);
		if(results.getCode() != com.azz.core.reconstructed.errorcode.SystemErrorCode.SUCCESS.getCode()) {
			throw new ReturnDataException("客户订单拆分出错");
		}
		JsonResult<AllocatedMerchantOrderInfo> res = platformClientOrderService.getGeneratedMerchantOrderInfo(po.getOrderCode());
		if(res.getCode() != com.azz.core.reconstructed.errorcode.SystemErrorCode.SUCCESS.getCode()) {
			throw new ReturnDataException("客户订单拆分信息查询出错");
		}
		//组装分账信息
		List<DivideDetail> ldds = new ArrayList<>();
		List<MerchantOrderInfo> merchantOrderInfos = res.getData().getMerchantOrderInfos();
		for (MerchantOrderInfo merchantOrderInfo : merchantOrderInfos) {
			ldds.add(new DivideDetail(mybMapper.selectBindByMerchantNo(merchantOrderInfo.getMerchantCode()).getYeeMerchantNo(), merchantOrderInfo.getMerchantName(), merchantOrderInfo.getEachMerchantGrandTotal().toPlainString()));
		}
		JSONArray divideDetail= JSONArray.parseArray(JSON.toJSONString(ldds));*/
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 创建订单
		com.hefa.order.pojo.yeepay.OrderInfo order = createOrder(orderInfo);
		if (null == order) {
			return null;
		}
		String appId = "";
		String openId = "";
		String clientId = "";
		String goodsParamExt = "{\"goodsName\":\"" + order.getGoodsName() + "\",\"goodsDesc\":\"" + order.getGoodsDesc()
				+ "\"}";
		String industryParamExt = "{\"bizSource\":\"" + "" + "\",\"bizEntity\":\"" + "" + "\"}";
		String ext = "{\"appId\":\"" + appId + "\",\"openId\":\"" + openId + "\",\"clientId\":\"" + clientId + "\"}";
		Map<String, String> params = new HashMap<>();
		params.put("orderId", order.getOrderId()); // 商户订单编号
		params.put("orderAmount", order.getOrderAmount()); // 订单金额
		params.put("parentMerchantNo", YeepayService.getParentMerchantNo());
		params.put("merchantNo", YeepayService.getMerchantNo());
		params.put("timeoutExpress", "360"); // 订单有效期 可以不传
		params.put("timeoutExpressType", PayConstants.Unit.MINUTE.getPrc());
		params.put("requestDate", order.getRequestDate()); // 请求时间
		params.put("redirectUrl", redirectUrl); // 页面回调地址 可以不传
		params.put("notifyUrl", notifyUrl); // 回调地址
		params.put("industryParamExt", industryParamExt);
		params.put("goodsParamExt", goodsParamExt);
		params.put("paymentParamExt", "");
		params.put("memo", "");
		params.put("riskParamExt", "");
		params.put("csUrl", "");
		params.put("assureType", "");
		params.put("assurePeriod", "");
		//params.put("fundProcessType", "SPLIT_ACCOUNT_IN");//分账
		//params.put("divideDetail", divideDetail.toString());
		//params.put("divideNotifyUrl", divideNotifyUrl);
		params.put("fundProcessType", "");//分账
		params.put("divideDetail", "");
		params.put("divideNotifyUrl", "");
		params.put("timeoutNotifyUrl", "");
		Set<Entry<String, String>> entrySet = params.entrySet();
		for (Entry<String, String> entry : entrySet) {
			log.info("key--->:" + entry.getKey() + ":::value--->:" + entry.getValue());
		}
		Map<String, String> result = new HashMap<>();
		String uri = YeepayService.getUrl(YeepayService.TRADEORDER_URL);
		try {
			result = YeepayService.requestYOP(params, uri, YeepayService.TRADEORDER, YeepayService.TRADEORDER_HMAC);
		} catch (IOException e1) {
			e1.printStackTrace();
			resultMap.put("code", PayCode.FAILD.getCode());
			resultMap.put("msg", PayCode.FAILD.getDesc());
			return resultMap;
		}

		String token = result.get("token");
		String codeRe = result.get("code");
		if (!"OPR00000".equals(codeRe)) {
			String message = result.get("message");
			log.info("支付返回消息----->" + message);
			resultMap.put("code", PayCode.FAILD.getCode());
			resultMap.put("msg", PayCode.FAILD.getDesc());
			return resultMap;
		}

		params.put("merchantNo", YeepayService.getMerchantNo());
		params.put("token", token);
		params.put("timestamp", order.getTimestamp());
		params.put("userNo", order.getUserNo());
		params.put("userType", order.getUserType());
		params.put("directPayType", "");
		params.put("cardType", "");
		params.put("ext", ext);
		Set<Entry<String, String>> entrySet1 = params.entrySet();
		for (Entry<String, String> entry : entrySet1) {
			log.info("key1--->:" + entry.getKey() + ":::value1--->:" + entry.getValue());
		}
		String url = "";
		try {
			url = YeepayService.getUrl(params);

		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("code", PayCode.FAILD.getCode());
			resultMap.put("msg", PayCode.FAILD.getDesc());
			return resultMap;
		}
		if (StringUtils.isNotBlank(url)) {
			log.info("url---->" + url);
			ClientPay clientPay = new ClientPay();
			clientPay.setUserCode(orderInfo.getUserCode());
			clientPay.setOrderMoney(orderInfo.getGrandTotal().toPlainString());
			clientPay.setUserreqIp(po.getClientIp());
			clientPay.setGoodsName(order.getGoodsName());
			clientPay.setOrderCustomerPhone(1L);
			// clientPay.setOrderChannelMoney();//渠道费
			clientPay.setOrderNumber(orderInfo.getOrderCode());
			clientPay.setOrderTime(Long.parseLong(LLPayUtil.getCurrentDateTimeStr()));
			clientPay.setOrderStatus((byte) PayStatus.NOT_PAID.getValue());// 支付状态 默认待支付
			clientPay.setPayNumber(order.getOrderId()); // 订单流水号
			clientPay.setPayInstruation(PayConstants.PAYMENT_INSTITUTION);// 支付机构
			int i = ppm.insertPay(clientPay);
			if (i != 1) {
				resultMap.put("code", PayCode.FAILD.getCode());
				resultMap.put("msg", PayCode.FAILD.getDesc());
				return resultMap;
			}
			resultMap.put("code", PayCode.SUCCESS.getCode());
			resultMap.put("msg", url);
			return resultMap;
		} else {
			resultMap.put("code", PayCode.FAILD.getCode());
			resultMap.put("msg", PayCode.FAILD.getDesc());
			return resultMap;
		}

	}

	/**
	 * 子商户入网注册 【企业】
	 * 
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> regMerchantYeeEnterpriseAccount(@RequestBody EnterprisereginfoCopy po) throws Exception {
		Map<String,String> resultMap = new HashMap<String,String>();
		Map<String, String> result = new HashMap<>();
		JSR303ValidateUtils.validateInputParam(po);
		YeeModulePic businessPic = po.getBusinessPic();
		YeeModulePic openAccountPic = po.getOpenAccountPic();
		YeeModulePic icpAuthPic = po.getIcpAuthPic();
		YeeModulePic legalFrontPic = po.getLegalFrontPic();
		YeeModulePic legalBackPic = po.getLegalBackPic();
		List<YeeModulePic> yps = new ArrayList<YeeModulePic>();
		yps.add(businessPic);
		yps.add(openAccountPic);
		yps.add(icpAuthPic);
		yps.add(legalFrontPic);
		yps.add(legalBackPic);
		Map<String, String> uploadModulePic = uploadModulePic(yps, po.getMerShortName());
		JSONArray array = new JSONArray();
		Set<Entry<String, String>> entrySet = null;
		if (!uploadModulePic.isEmpty()) {
			 entrySet = uploadModulePic.entrySet();
			for (Entry<String, String> entry : entrySet) {
				log.info("上传图片url---->"+entry.getKey()+":::"+entry.getValue());
			}
			Map<String, String> upload = upload(uploadModulePic.get(legalFrontPic.getType()));
			Map<String, String> upload1 = upload(uploadModulePic.get(legalBackPic.getType()));
			Map<String, String> upload2 = upload(uploadModulePic.get(openAccountPic.getType()));
			Map<String, String> upload3 = upload(uploadModulePic.get(businessPic.getType()));
			Map<String, String> upload4 = upload(uploadModulePic.get(businessPic.getType()));
			Map<String, String> upload5 = upload(uploadModulePic.get(businessPic.getType()));
			Map<String, String> upload6 = upload(uploadModulePic.get(businessPic.getType()));
			Map<String, String> upload7 = upload(uploadModulePic.get(icpAuthPic.getType()));
			Map<String, String> param = new HashMap<String, String>();
			Map<String, String> param1 = new HashMap<String, String>();
			Map<String, String> param2 = new HashMap<String, String>();
			Map<String, String> param3 = new HashMap<String, String>();
			Map<String, String> param4 = new HashMap<String, String>();
			Map<String, String> param5 = new HashMap<String, String>();
			Map<String, String> param6 = new HashMap<String, String>();
			Map<String, String> param7 = new HashMap<String, String>();
			if (!upload.isEmpty() && "REG00000".equals(upload.get("returnCode"))) {
				param.put("quaType", "IDCARD_FRONT");
				param.put("quaUrl", upload.get("merQualUrl"));
			}
			if (!upload1.isEmpty() && "REG00000".equals(upload1.get("returnCode"))) {
				param1.put("quaType", "IDCARD_BACK");
				param1.put("quaUrl", upload1.get("merQualUrl"));
			}
			if (!upload2.isEmpty() && "REG00000".equals(upload2.get("returnCode"))) {
				param2.put("quaType", "OP_BANK_CODE");
				param2.put("quaUrl", upload2.get("merQualUrl"));
			}
			if (!upload3.isEmpty() && "REG00000".equals(upload3.get("returnCode"))) {
				param3.put("quaType", "CORP_CODE");
				param3.put("quaUrl", upload3.get("merQualUrl"));
			}
			if (!upload4.isEmpty() && "REG00000".equals(upload4.get("returnCode"))) {
				param4.put("quaType", "TAX_CODE");
				param4.put("quaUrl", upload4.get("merQualUrl"));
			}
			if (!upload5.isEmpty() && "REG00000".equals(upload5.get("returnCode"))) {
				param5.put("quaType", "ORG_CODE");
				param5.put("quaUrl", upload5.get("merQualUrl"));
			}
			if (!upload6.isEmpty() && "REG00000".equals(upload6.get("returnCode"))) {
				param6.put("quaType", "UNI_CREDIT_CODE");
				param6.put("quaUrl", upload6.get("merQualUrl"));
			}
			if (!upload7.isEmpty() && "REG00000".equals(upload7.get("returnCode"))) {
				param7.put("quaType", "ICP_AUTHORIZED");
				param7.put("quaUrl", upload7.get("merQualUrl"));
			}
			JSONObject jsonObject = JSONObject.fromObject(param);
			JSONObject jsonObject1 = JSONObject.fromObject(param1);
			JSONObject jsonObject2 = JSONObject.fromObject(param2);
			JSONObject jsonObject3 = JSONObject.fromObject(param3);
			JSONObject jsonObject4 = JSONObject.fromObject(param4);
			JSONObject jsonObject5 = JSONObject.fromObject(param5);
			JSONObject jsonObject6 = JSONObject.fromObject(param6);
			JSONObject jsonObject7 = JSONObject.fromObject(param7);
			array.add(jsonObject.toString());
			array.add(jsonObject1.toString());
			array.add(jsonObject2.toString());
			array.add(jsonObject3.toString());
			array.add(jsonObject4.toString());
			array.add(jsonObject5.toString());
			array.add(jsonObject6.toString());
			array.add(jsonObject7.toString());
			array.toArray();
	}else {
		resultMap.put("code", RegCode.FAILD.getCode());
		resultMap.put("msg", RegCode.FAILD.getDesc());
		return resultMap;
	}
	if(null!=po && array.size() > 0){
		//String status = clientEnterpriseRegInfoMapper.selectStatusByCardNoAndMerFullName(po.getCardNo(),po.getMerFullName());
	//if(StringUtils.isNotBlank(status) && Objects.equals(status,PayConstants.Status.UR.getStatus())) {
		// 状态不为空 并且 未注册
		Map<String, String> params = new HashMap<>();
		params.put("merFullName",po.getMerFullName());
		params.put("merShortName",po.getMerShortName());
		params.put("merCertNo",po.getMerCertNo());
		params.put("merCertType",po.getMerCertType());
		params.put("legalName",po.getLegalName());
		params.put("legalIdCard",po.getLegalIdCard());
		params.put("merContactName",po.getMerContactName());
		params.put("merContactPhone",po.getMerContactPhone());
		if(StringUtils.isBlank(po.getMerContactEmail())){
			params.put("merContactEmail", "");
		}else{
			params.put("merContactEmail", po.getMerContactEmail());
		}if(StringUtils.isBlank(po.getMerLevelfNo())){
			params.put("merLevel1No", "");
		}else{
			params.put("merLevel1No", po.getMerLevelfNo());
		}if(StringUtils.isBlank(po.getMerLevelsNo())){
			params.put("merLevel2No", "");
		}else{
			params.put("merLevel2No", po.getMerLevelsNo());
		}
		params.put("merProvince",po.getMerProvince());
		params.put("merCity",po.getMerCity());
		params.put("merDistrict",po.getMerDistrict());
		params.put("merAddress",po.getMerAddress());
		if(StringUtils.isBlank(po.getTaxRegistCert())){
			params.put("taxRegistCert", "");
		}else{
			params.put("taxRegistCert", po.getTaxRegistCert());
		}
		params.put("accountLicense",po.getAccountLicense());
		if(StringUtils.isBlank(po.getOrgCode())){
			params.put("orgCode", "");
		}else{
			params.put("orgCode", po.getOrgCode());
		}
		if(StringUtils.isBlank(po.getOrgCodeExpiry())){
			params.put("orgCodeExpiry", "");
		}else{
			params.put("orgCodeExpiry", po.getOrgCodeExpiry());
		}
		if(StringUtils.isBlank(po.getIsOrgCodeLong())){
			params.put("isOrgCodeLong", "");
		}else{
			params.put("isOrgCodeLong", po.getIsOrgCodeLong());
		}
		params.put("cardNo",po.getCardNo());
		params.put("headBankCode",po.getHeadBankCode());
		params.put("bankCode",po.getBankCode());
		if(StringUtils.isBlank(po.getBankProvince())){
			params.put("bankProvince", "");
		}else{
			params.put("bankProvince", po.getBankProvince());
		}if(StringUtils.isBlank(po.getBankCity())){
			params.put("bankCity", "");
		}else{
			params.put("bankCity", po.getBankCity());
		}
		String str = "{\"payProductMap\":{\"ONE_KEY_PAY_DEBIT\":{\"dsPayBankMap\":{\"BANK_PAY_WAP\":{\"rateType\":\"PERCENTAGE\",\"rate\":\"0.6\"}}},\"ONE_KEY_PAY_CREDIT\":{\"dsPayBankMap\":{\"BANK_PAY_WAP\":{\"rateType\":\"PERCENTAGE\",\"rate\":\"0.6\"}}},\"B2C_PAY\":{\"dsPayBankMap\":{\"NET_BANK\":{\"rateType\":\"PERCENTAGE\",\"rate\":\"0.3\"}}},\"B2B_PAY\":{\"dsPayBankMap\":{\"NET_BANK\":{\"rateType\":\"ONEPAY\",\"rate\":\"10\"}}},\"USER_SCAN_PAY\":{\"dsPayBankMap\":{\"WECHAT_ATIVE_SCAN\":{\"rateType\":\"PERCENTAGE\",\"rate\":\"0.6\"},\"ALIPAY\":{\"rateType\":\"PERCENTAGE\",\"rate\":\"0.6\"}}}},\"payScenarioMap\":{\"WEB_ACCESS\":{\"webUrl\":\"http://www.izz2025.com\",\"icp\":\"18144663\"}}}";
		JSONObject productInfo = JSONObject.fromObject(str);
		params.put("productInfo",productInfo.toString());
		params.put("fileInfo",array.toString());
		LocalDateTime now = LocalDateTime.now();
		String string = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		params.put("requestNo",REQUEST_PREFIX+string);
		params.put("parentMerchantNo",YeepayService.getParentMerchantNo());
		params.put("notifyUrl",regEnNotifyUrl);
		if(StringUtils.isBlank(po.getMerAuthorizeType())){
			params.put("merAuthorizeType", "");
	    }else{
	    	params.put("merAuthorizeType", po.getMerAuthorizeType());
		}
		if(StringUtils.isBlank(po.getBusinessFunction())){
			params.put("businessFunction", "");
		}else{
			params.put("businessFunction", po.getBusinessFunction());
	    }
		log.info("子商户入网注册参数----->"+com.alibaba.fastjson.JSONObject.toJSONString(params));
		String uri = YeepayService.getUrl(YeepayService.ENTERPRISE_URL);
		
		try{
			result = YeepayService.requestYOP(params, uri, YeepayService.ENTERPRISE);
		}catch(IOException e){
			e.printStackTrace();
			result.put("code", RegCode.FAILD.getCode());
			result.put("msg", RegCode.FAILD.getDesc());
			return result;
		}
		String merchantNo = result.get("merchantNo"); // 商户编号
		String returnMsg = result.get("returnMsg"); // 返回信息
		String returnCode = result.get("returnCode"); // 返回CODE
		String requestNo = result.get("requestNo"); // 入网请求号
		String parentMerchantNo = result.get("parentMerchantNo"); // 代理商编号
		String externalId = result.get("externalId"); // 入网流水号
		log.info("【merchantNo】--->"+merchantNo+"【returnMsg】--->"+returnMsg+"【returnCode】--->"+returnCode+"【requestNo】--->"+requestNo+"【parentMerchantNo】--->"+parentMerchantNo+"【externalId】--->"+externalId);
		if(returnCode.equals("REG00000")) {
			Enterprisereginfoadd ef = new Enterprisereginfoadd();
			ef.setStatus(PayConstants.Status.UR.getStatus());//状态通过回调更新
			ef.setMerFullName(params.get("merFullName"));
			ef.setMerShortName(params.get("merShortName"));
			ef.setMerCertNo(params.get("merCertNo"));
			ef.setMerCertType(params.get("merCertType"));
			ef.setLegalName(params.get("legalName"));
			ef.setLegalIdCard(params.get("legalIdCard"));
			ef.setMerContactName(params.get("merContactName"));
			ef.setMerContactPhone(params.get("merContactPhone"));
			ef.setMerContactEmail(params.get("merContactEmail"));
			ef.setMerLevelfNo(params.get("merLevel1No"));
			ef.setMerLevelsNo(params.get("merLevel2No"));
			ef.setMerProvince(params.get("merProvince"));
			ef.setMerCity(params.get("merCity"));
			ef.setMerDistrict(params.get("merDistrict"));
			ef.setMerAddress(params.get("merAddress"));
			ef.setTaxRegistCert(params.get("taxRegistCert"));
			ef.setOrgCode(params.get("orgCode"));
			ef.setAccountLicense(params.get("accountLicense"));
			ef.setOrgCodeExpiry(params.get("orgCodeExpiry"));
			ef.setIsOrgCodeLong(params.get("isOrgCodeLong"));
			ef.setCardNo(params.get("cardNo"));
			ef.setHeadBankCode(params.get("headBankCode"));
			ef.setBankCode(params.get("bankCode"));
			ef.setProductInfo(params.get("productInfo"));
			ef.setRequestNo(params.get("requestNo"));
			ef.setParentMerchantNo(params.get("parentMerchantNo"));
			ef.setBankProvince(params.get("bankProvince"));
			ef.setBankCity(params.get("bankCity"));
			ef.setMerAuthorizeType(params.get("merAuthorizeType"));
			ef.setBusinessFunction(params.get("businessFunction"));
			ef.setMerchantNo(merchantNo);
			for (Entry<String, String> entry : entrySet) {
				if(entry.getKey().equals(PayConstants.RegYee.legalFrontPic.getCode())) {
					ef.setLegalFrontPic(entry.getValue());
				}
				if(entry.getKey().equals(PayConstants.RegYee.legalBackPic.getCode())) {
					ef.setLegalBackPic(entry.getValue());
				}
				if(entry.getKey().equals(PayConstants.RegYee.icpAuthPic.getCode())) {
					ef.setIcpAuthPic(entry.getValue());
				}
				if(entry.getKey().equals(PayConstants.RegYee.openAccountPic.getCode())) {
					ef.setOpenAccountPic(entry.getValue());
				}
				if(entry.getKey().equals(PayConstants.RegYee.businessPic.getCode())) {
					ef.setBusinessPic(entry.getValue());
				}
			}
			int insertSelective = clientEnterpriseRegInfoMapper.insertSelective(ef);
			if(insertSelective != 1) {
				resultMap.put("code", RegCode.FAILD.getCode());
				resultMap.put("msg", RegCode.FAILD.getDesc());
				return resultMap;
			}
			MerchantYeeBind myb = new MerchantYeeBind();
			myb.setMerchantId(po.getMerchantCode());
			myb.setYeeMerchantNo(merchantNo);
			int insertBind = mybMapper.insertBind(myb);
			if(insertBind != 1) {
				resultMap.put("code", RegCode.FAILD.getCode());
				resultMap.put("msg", "商户编号绑定失败");
				return resultMap;
			}
			resultMap.put("code", RegCode.SUCCESS.getCode());
			resultMap.put("msg", RegCode.SUCCESS.getDesc());
			return resultMap;
		}else {
				resultMap.put("code", RegCode.FAILD.getCode());
				resultMap.put("msg", returnMsg);
				return resultMap;
		}
		}else {
			resultMap.put("code", PayCode.FAILD.getCode());
			resultMap.put("msg", "参数不正确");
			return resultMap;
		}
	}

	
	/**
	 * 易宝提现
	 */
	//public Map<String,String> cashWithdrawal(CashWithdrawal ca) {
		//Map<String,String> result = new HashMap<String,String>();
		//Map<String,String> params = new HashMap<String,String>();
		//根据订单号去查询提现金额
		//com.azz.order.finance.pojo.vo.OrderInfo info = merchantWithdrawDepositApplyMapper.getWithdrawDepositApplyOrderInfo(ca.getOrderId());
		
		//if(info != null) {
			//if(WithdrawDepositApplyStatus.PENDING.getValue() != info.getStatus()) {
			//	result.put("code", "9999");
			//	result.put("msg", "提现单号状态出错");
			//	return result;
			//}
			//if(info.getTotalOrderMoney().compareTo(BigDecimal.ZERO) == 0) {
			//	result.put("code", "9999");
			//	result.put("msg", "提现金额不能为0");
			//	return result;
			//}
			//根据商户编号去查询易宝商户编号
			//MerchantYeeBind yeeBind = mybMapper.selectBindByMerchantNo(ca.getMerchantCode());
			//params.put("customerNumber", yeeBind.getYeeMerchantNo());//商户编号
			//params.put("customerNumber", "10027243789");
			//params.put("amount", "145.01");
			//params.put("orderId", "20190314105445");
			//params.put("amount", info.getTotalOrderMoney().toPlainString());//提现金额
			//params.put("orderId", ca.getOrderId());//商户订单号20190314105445
			//params.put("cashType", WithdralwalContants.CASHTYPEONE);//提现类型 D1
			//params.put("feeType", WithdralwalContants.FEETYPETARGET);//计费类型
			//params.put("leaveWord", "");
			//params.put("bankCardId", "");
			//params.put("notifyUrl", cashWithdralwalNotifyUrl);//提现回调
			//Set<Entry<String, String>> es = params.entrySet();
			//for (Entry<String, String> entry : es) {
			//	log.info("提现参数---->"+entry.getKey()+":::"+entry.getValue());
			//}
			//Map<String, String> re = new HashMap<>();
			//String uri = YeepayService.getUrl(YeepayService.CASHWITHDRALWAL_URL);
			//try {
				//re = YeepayService.requestYOP(params, uri, YeepayService.CASHWITHDRALWALKEY, YeepayService.CASHWITHDRALWALKEY);
			//} catch (IOException e1) {
			//	e1.printStackTrace();
			//	result.put("code", "9999");
			//	result.put("msg", "提现失败");
			//	return result;
			//}
			//Set<Entry<String, String>> entrySet = re.entrySet();
		//	for (Entry<String, String> entry : entrySet) {
			//	log.info("提现返回---->"+entry.getKey()+":::"+entry.getValue());
			//}
		//}else {
			
		//}
		
		/*MerchantWithdrawDepositApply applyInfo = merchantWithdrawDepositApplyMapper.selectByApplyCode(applyCode);
		if(applyInfo == null) {
			throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "提款申请记录不存在");
		}
		MerchantWithdrawDepositApply record = MerchantWithdrawDepositApply.builder()
				.id(applyInfo.getId())
				.modifier(param.getMerchantUserCode())
				.modifyTime(new Date())
				.status((byte)WithdrawDepositApplyStatus.NOT_PAID_WITH.getValue())
				.build();
		merchantWithdrawDepositApplyMapper.updateByPrimaryKeySelective(record);
		*/
		//return result;
	//}
	
	/**
	 * 易宝商户入网回调
	 * @param result
	 */
	public JsonResult<RetBean> regEnterpriseNotify(String responseMsg,String customerId){
		log.info("进入商户入网异步处理......");
		RetBean retBean = new RetBean();
		if (StringUtils.isBlank(responseMsg) || StringUtils.isBlank(customerId)) {
			retBean.setRet_code(YeeCode.FAILD.getCode());
			retBean.setRet_msg(YeeCode.FAILD.getDesc());
			return new JsonResult<>(retBean);
		}
		log.info("接收商户入网异步通知数据：【" + responseMsg + "】:【" + customerId + "】");
		Map<String, String> callback = YeepayService.callback(responseMsg);
		Set<Entry<String, String>> entrySet = callback.entrySet();
		for (Entry<String, String> entry : entrySet) {
			log.info("回调处理结果--->" + entry.getKey() + "::--value---->" + entry.getValue());
		}
		String agentNo = callback.get("agentNo");// 主商编
		String merNo = callback.get("merNo"); // 子商编
		String externalId = callback.get("externalId");//易宝流水号
		String requestNo = callback.get("requestNo");// 请求单号
		String merFullName = callback.get("merFullName");// 商户全称
		String merNetInStatus = callback.get("merNetInStatus");// 状态
		log.info("商户全称:{},商户入网返回状态:{}",merFullName,merNetInStatus);
		if (StringUtils.isNotBlank(merNetInStatus) && merNetInStatus.equals("PROCESS_SUCCESS")) {
			//更新商户状态
			int i = clientEnterpriseRegInfoMapper.updateEnterpriseStatus();
			if(1 != i) {
				retBean.setRet_code(YeeCode.FAILD.getCode());
				retBean.setRet_msg(YeeCode.FAILD.getDesc());
				return new JsonResult<>(retBean);
			}
			List<MerchantYeeBind> selectBindByYeeNo = mybMapper.selectBindByYeeNo(merNo);
			if(selectBindByYeeNo.isEmpty()) {
				retBean.setRet_code(YeeCode.FAILD.getCode());
				retBean.setRet_msg(YeeCode.FAILD.getDesc());
				return new JsonResult<>(retBean);
			}
			boolean flag = false;
			for (MerchantYeeBind merchantYeeBind : selectBindByYeeNo) {
				if(merchantYeeBind.getBindStatus() == 1) {
					flag = true;
				}
			}
			if(!flag) {
				int bind = mybMapper.updateBind(merNo);
				if(bind != 1) {
					retBean.setRet_code(YeeCode.FAILD.getCode());
					retBean.setRet_msg(YeeCode.FAILD.getDesc());
					return new JsonResult<>(retBean);
				}
			}
			retBean.setRet_code(YeeCode.SUCCESS.getCode());
			retBean.setRet_msg(YeeCode.SUCCESS.getDesc());
			return new JsonResult<>(retBean);
		} else {
			retBean.setRet_code(YeeCode.FAILD.getCode());
			retBean.setRet_msg(YeeCode.FAILD.getDesc());
			return new JsonResult<>(retBean);
		}

	}
	
	
	

	/**
	 * 易宝提现回调
	 * @param result
	 */
	/*public JsonResult<RetBean> cashWithdrawalCallback(String responseMsg,String customerId){
		log.info("进入商户提现异步处理......");
		RetBean retBean = new RetBean();
		if (StringUtils.isBlank(responseMsg) || StringUtils.isBlank(customerId)) {
			retBean.setRet_code(YeeCode.FAILD.getCode());
			retBean.setRet_msg(YeeCode.FAILD.getDesc());
			return new JsonResult<>(retBean);
		}
		log.info("接收商户提现异步通知数据：【" + responseMsg + "】:【" + customerId + "】");
		Map<String, String> callback = YeepayService.callback(responseMsg);
		Set<Entry<String, String>> entrySet = callback.entrySet();
		for (Entry<String, String> entry : entrySet) {
			log.info("回调处理结果--->" + entry.getKey() + "::--value---->" + entry.getValue());
		}
		String customerNumber = callback.get("customerNumber");// 商户编号
		String groupNumber = callback.get("groupNumber"); //系统商编号
		String orderId = callback.get("orderId");//提现订单号
		String cashType = callback.get("cashType");//提现类型
		String bankAccountNo = callback.get("bankAccountNo");//提现账户
		String bankAccountName = callback.get("bankAccountName");//提现账户名称
		String bankName = callback.get("bankName");//开户银行名称
		String bankCardType = callback.get("bankCardType");//提现账户类型
		String amount = callback.get("amount");//提现金额
		String realAmount = callback.get("realAmount");//实际到账金额
		String fee = callback.get("fee");//提现手续费
		String feeType = callback.get("feeType");//手续费类型
		String requestDate = callback.get("requestDate");//请求时间
		String finishTime = callback.get("finishTime");//终态时间
		String transferStatusCode = callback.get("transferStatusCode");//提现状态码
		String bankTrxStatusCode = callback.get("bankTrxStatusCode");//银行状态码
		log.info("提现订单号:{},提现账户:{},提现金额:{},实际到账金额:{},提现手续费:{},提现状态码:{},银行状态码:{}",orderId,bankAccountNo,amount,realAmount,fee,transferStatusCode,bankTrxStatusCode);
		return null;
	}
	*/
	
	
	/**
	 * 获取支行信息
	 * @param bb
	 * @return
	 */
	public Map<String,String> getBankBranchInfo(@RequestBody BankBranch bb){
		Map<String, String> branchInfo = new HashMap<String,String>();
		try {
			branchInfo = YeepayService.getBankBranchInfo(bb.getHeadBankCode(), bb.getProvinceCode(), bb.getCityCode());
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return branchInfo;
	}

	/**
	 * 文件上传
	 * @param responseMsg
	 * @param customerId
	 * @return
	 * @throws Exception 
	 */
	private Map<String,String> upload(String url) throws Exception {
		log.info("上传图片url------------>"+url);
		String fileType = "IMAGE";
		Map<String, String> result = YeepayService.uploadUrlStream(fileType, url);
		Set<Entry<String, String>> entrySet = result.entrySet();
		for (Entry<String, String> entry : entrySet) {
			log.info("返回KEY---->"+entry.getKey()+":::"+entry.getValue());
		}
		return result;
	}

	public JsonResult<RetBean> payNotify(String responseMsg, String customerId) {
		log.info("进入支付异步处理......");
		RetBean retBean = new RetBean();
		if (StringUtils.isBlank(responseMsg) || StringUtils.isBlank(customerId)) {
			retBean.setRet_code(PayCode.FAILD.getCode());
			retBean.setRet_msg(PayCode.FAILD.getDesc());
			return new JsonResult<>(retBean);
		}
		log.info("接收支付异步通知数据：【" + responseMsg + "】:【" + customerId + "】");
		Map<String, String> callback = YeepayService.callback(responseMsg);
		Set<Entry<String, String>> entrySet = callback.entrySet();
		for (Entry<String, String> entry : entrySet) {
			log.info("回调处理结果--->" + entry.getKey() + "::--value---->" + entry.getValue());
		}
		String result = callback.get("status");// SUCCESS 成功
		String platformType = callback.get("platformType"); // 支付方式
		String paymentProduct = callback.get("paymentProduct");// 支付产品
		String orderId = callback.get("orderId");// 订单号
		String payAmount = callback.get("payAmount");// 实付金额
		String uniqueOrderNo = callback.get("uniqueOrderNo");// 三方流水号
		String requestDate = callback.get("requestDate");// 下单时间
		String paySuccessDate = callback.get("paySuccessDate");// 支付完成时间
		if (StringUtils.isNotBlank(result) && result.equals("SUCCESS")) {
			// 校验订单是否支付成功
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("no_order", orderId);
			map.put("money_order", payAmount);
			if (getOrderStatus(map)) {
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("order_status", (byte) PayStatus.PAY_SUCCESS.getValue());
				map1.put("order_info", "");
				map1.put("order_type", PayConstants.PayType.getDesc(paymentProduct) + "::"
						+ PayConstants.PayPlatForm.getDesc(platformType));
				map1.put("pay_success_date", paySuccessDate);
				map1.put("three_party_number", uniqueOrderNo);
				map1.put("pay_number", orderId);
				int number = ppm.updateOrderByNumber(map1);
				if (number != 1) {
					retBean.setRet_code(PayCode.UPDATEFAILD.getCode());
					retBean.setRet_msg(PayCode.UPDATEFAILD.getDesc());
					return new JsonResult<>(retBean);
				}
				String orderCode = ppm.selectOrderCode(orderId);
				CallBackParam cbp = new CallBackParam();
				cbp.setOrderCode(orderCode);
				cbp.setPayMethod(PayMethod.ONLINE.getValue());
				cbp.setOrderType(PayConstants.PayPlatForm.getNum(platformType));
				cos.clientOrderPaySuccessOpt(cbp);
				retBean.setRet_code(PayCode.SUCCESS.getCode());
				retBean.setRet_msg(PayCode.SUCCESS.getDesc());
				return new JsonResult<>(retBean);
			} else {
				retBean.setRet_code(PayCode.PAID.getCode());
				retBean.setRet_msg(PayCode.PAID.getDesc());
				return new JsonResult<>(retBean);
			}
		} else {
			retBean.setRet_code(PayCode.FAILD.getCode());
			retBean.setRet_msg(PayCode.FAILD.getDesc());
			return new JsonResult<>(retBean);
		}

	}

	public JsonResult<RetBean> divideNotify(String responseMsg, String customerId) {
		log.info("进入分账异步处理......");
		RetBean retBean = new RetBean();
		if (StringUtils.isBlank(responseMsg) || StringUtils.isBlank(customerId)) {
			retBean.setRet_code(PayCode.FAILD.getCode());
			retBean.setRet_msg(PayCode.FAILD.getDesc());
			return new JsonResult<>(retBean);
		}
		log.info("接收分账异步通知数据：【" + responseMsg + "】:【" + customerId + "】");
		Map<String, String> callback = YeepayService.callback(responseMsg);
		Set<Entry<String, String>> entrySet = callback.entrySet();
		for (Entry<String, String> entry : entrySet) {
			log.info("回调处理结果--->" + entry.getKey() + "::--value---->" + entry.getValue());
		}
		String parentMerchantNo = callback.get("parentMerchantNo");// 主商编
		String merchantNo = callback.get("merchantNo"); // 子商编
		String orderId = callback.get("orderId");// 订单号
		String uniqueOrderNo = callback.get("uniqueOrderNo");// 三方流水号
		String divideRequestId = callback.get("divideRequestId");//商户分账请求号
		String divideStatus = callback.get("divideStatus");// 分账状态 SUCCESS 成功
		String divideDetail = callback.get("divideDetail");//分账详情
		
		if (StringUtils.isNotBlank(divideStatus) && divideStatus.equals("SUCCESS")) {
			// 校验订单是否支付成功
			/*Map<String, Object> map = new HashMap<String, Object>();
			map.put("no_order", orderId);
			map.put("money_order", payAmount);
			if (getOrderStatus(map)) {
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("order_status", (byte) PayStatus.PAY_SUCCESS.getValue());
				map1.put("order_info", "");
				map1.put("order_type", PayConstants.PayType.getDesc(paymentProduct) + "::"
						+ PayConstants.PayPlatForm.getDesc(platformType));
				map1.put("pay_success_date", paySuccessDate);
				map1.put("three_party_number", uniqueOrderNo);
				map1.put("pay_number", orderId);
				int number = ppm.updateOrderByNumber(map1);
				if (number != 1) {
					retBean.setRet_code(PayCode.UPDATEFAILD.getCode());
					retBean.setRet_msg(PayCode.UPDATEFAILD.getDesc());
					return new JsonResult<>(retBean);
				}
				String orderCode = ppm.selectOrderCode(orderId);
				CallBackParam cbp = new CallBackParam();
				cbp.setClientOrderCode(orderCode);
				cbp.setPayMethod(PayMethod.ONLINE.getValue());
				cbp.setOrderType(PayConstants.PayPlatForm.getNum(platformType));
				selectService.clientOrderPaySuccessOpt(cbp);
				retBean.setRet_code(PayCode.SUCCESS.getCode());
				retBean.setRet_msg(PayCode.SUCCESS.getDesc());
				return new JsonResult<>(retBean);
			} else {
				retBean.setRet_code(PayCode.PAID.getCode());
				retBean.setRet_msg(PayCode.PAID.getDesc());
				return new JsonResult<>(retBean);
			}*/
		} else {
			retBean.setRet_code(PayCode.FAILD.getCode());
			retBean.setRet_msg(PayCode.FAILD.getDesc());
			return new JsonResult<>(retBean);
		}
		return null;

	}

	
	/**
	 * <p>
	 * 支付列表
	 * </p>
	 * 
	 * @param param
	 * @return
	 * @author 刘建麟 2018年10月31日 上午11:29:49
	 */
	public JsonResult<Enterprisereginfoadd> enterpriseInfo(String merchantCode) {
		MerchantYeeBind merchantNo = mybMapper.selectBindByMerchantNo(merchantCode);
		if(merchantNo == null) {
			log.info("商户绑定信息不存在");
			return JsonResult.successJsonResult(new Enterprisereginfoadd());
		}
		if(merchantNo.getBindStatus() != 1) {
			log.info("商户信息审核不通过");
			return JsonResult.successJsonResult(new Enterprisereginfoadd());
		}
		Enterprisereginfoadd enterprisereginfo = clientEnterpriseRegInfoMapper.selectEnterpriseInfoByMerchantNo(merchantNo.getYeeMerchantNo());
		if(enterprisereginfo == null) {
			log.info("商户信息为空");
			return JsonResult.successJsonResult(new Enterprisereginfoadd());
		}
		return JsonResult.successJsonResult(enterprisereginfo);
	}
	
	/**
	 * <p>
	 * 支付列表
	 * </p>
	 * 
	 * @param param
	 * @return
	 * @author 刘建麟 2018年10月31日 上午11:29:49
	 */
	public JsonResult<Pagination<PayListInfo>> searchParamsList(@RequestBody PayOrderListParam pl) {
		PageHelper.startPage(pl.getPageNum(), pl.getPageSize());
		List<PayListInfo> ss = ppm.selectPayList(pl);
		return JsonResult.successJsonResult(new Pagination<>(ss));
	}

	

	/**
	 * 获取订单状态
	 * 
	 * @param map
	 * @return
	 */
	private boolean getOrderStatus(Map<String, Object> map) {
		int i = ppm.selectOrderStatus(map);
		if (i > 0) {
			return false;
		}
		return true;
	}
	/**
	 * <p>
	 * 创建订单
	 * </p>
	 * 
	 * @param req
	 * @return
	 * @author 刘建麟 2018年12月17日 下午2:05:32
	 */
	private com.hefa.order.pojo.yeepay.OrderInfo createOrder(OrderInfo corderInfo) {
		if (null == corderInfo || StringUtils.isBlank(corderInfo.getUserCode())) {
			return null;
		}
		com.hefa.order.pojo.yeepay.OrderInfo orderInfo = new com.hefa.order.pojo.yeepay.OrderInfo();
		orderInfo.setOrderId(LLPayUtil.getCurrentDateTimeStrE());// 订单编号
		orderInfo.setTimestamp(LLPayUtil.getCurrentDateTimeStr());// 订单时间戳
		orderInfo.setOrderAmount(corderInfo.getGrandTotal().toPlainString());// 订单金额
		orderInfo.setGoodsName("零件购买");// TODO fix
		orderInfo.setGoodsDesc("");
		orderInfo.setRequestDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));// 下单时间
		orderInfo.setUserType("USER_ID"); // 用户标示类型 默认USER_ID
		orderInfo.setUserNo(corderInfo.getUserCode());// 用户CODE
		log.info("订单创建成功----->" + orderInfo);
		return orderInfo;
	}

	/**
	 * 
	 * <p>上图文件</p>
	 * @param pic
	 * @param moduleCode
	 * @return
	 * @author 黄智聪  2018年11月1日 下午4:49:22
	 */
	private Map<String,String> uploadModulePic(List<YeeModulePic> pic,String name) {
		//创建OS存储空间
		Map<String,String> fileMap = new HashMap<String,String>();
		if(!pic.isEmpty()) {
			for (YeeModulePic yeeModulePic : pic) {
				String fileName = yeeModulePic.getFileName();
				String fileDate = yeeModulePic.getFileBase64Str();
				if(StringUtils.isBlank(fileName)) {
					throw new ValidationException( "文件名不能为空");
				}
				if(yeeModulePic.getFileSize() > MerchantConstants.GOODS_MODULE_FILE_SIZE_LIMIT) {
			    	throw new ValidationException( "文件大小不能超过2M");
			    }
				if(StringUtils.isBlank(fileDate)) {
			    	throw new ValidationException( "图片内容为空");
			    }
				LocalDateTime now = LocalDateTime.now();
				String string = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
				//组装新文件名
				String type = yeeModulePic.getType();
				String newFileName = string+"_"+name+"_"+type;
				String suffix = fileName.substring(fileName.indexOf(".")+1, fileName.length());
				log.info("文件后缀为--------->"+suffix);
				
				if(type.equals(PayConstants.RegYee.legalFrontPic.getCode())) {
					JsonResult<String> jr = systemImageUploadService.uploadImage(new UploadImageParam(FileConstantsYeepay.IMAGE_BUCKETNAME, newFileName, suffix, fileDate,FileConstantsYeepay.AZZ_YEE,
							FileConstantsYeepay.AZZ_LEGAL_IMAGE_TYPE));
					if(jr.getCode() == SystemErrorCode.SUCCESS.getCode()) {
						fileMap.put(yeeModulePic.getType(), jr.getData());
				    }
				}
				if(type.equals(PayConstants.RegYee.legalBackPic.getCode())) {
					JsonResult<String> jr = systemImageUploadService.uploadImage(new UploadImageParam(FileConstantsYeepay.IMAGE_BUCKETNAME, newFileName, suffix, fileDate,FileConstantsYeepay.AZZ_YEE,
							FileConstantsYeepay.AZZ_LEGAL_IMAGE_TYPE));
					if(jr.getCode() == SystemErrorCode.SUCCESS.getCode()) {
						fileMap.put(yeeModulePic.getType(), jr.getData());
				    }
				}
				if(type.equals(PayConstants.RegYee.businessPic.getCode())) {
					JsonResult<String> jr = systemImageUploadService.uploadImage(new UploadImageParam(FileConstantsYeepay.IMAGE_BUCKETNAME, newFileName, suffix, fileDate,FileConstantsYeepay.AZZ_YEE,
							FileConstantsYeepay.AZZ_TRADING_CERTIFICATE_IMAGE_TYPE));
					if(jr.getCode() == SystemErrorCode.SUCCESS.getCode()) {
						fileMap.put(yeeModulePic.getType(), jr.getData());
				    }
				}
				if(type.equals(PayConstants.RegYee.icpAuthPic.getCode())) {
					JsonResult<String> jr = systemImageUploadService.uploadImage(new UploadImageParam(FileConstantsYeepay.IMAGE_BUCKETNAME, newFileName, suffix, fileDate,FileConstantsYeepay.AZZ_YEE,
							FileConstantsYeepay.AZZ_ICP_IMAGE_TYPE));
					if(jr.getCode() == SystemErrorCode.SUCCESS.getCode()) {
						fileMap.put(yeeModulePic.getType(), jr.getData());
				    }
				}
				if(type.equals(PayConstants.RegYee.openAccountPic.getCode())) {
					JsonResult<String> jr = systemImageUploadService.uploadImage(new UploadImageParam(FileConstantsYeepay.IMAGE_BUCKETNAME, newFileName, suffix, fileDate,FileConstantsYeepay.AZZ_YEE,
							FileConstantsYeepay.AZZ_OPEN_IMAGE_TYPE));
					if(jr.getCode() == SystemErrorCode.SUCCESS.getCode()) {
						fileMap.put(yeeModulePic.getType(), jr.getData());
				    }
				}
			}
			return fileMap;
		}
		return null;
	}

	
}
