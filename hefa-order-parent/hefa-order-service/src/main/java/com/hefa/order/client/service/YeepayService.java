package com.hefa.order.client.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.hefa.common.constants.Configuration;
import com.hefa.utils.Md5Utils;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.g3.sdk.yop.client.YopRsaClient;
import com.yeepay.g3.sdk.yop.encrypt.CertTypeEnum;
import com.yeepay.g3.sdk.yop.encrypt.DigestAlgEnum;
import com.yeepay.g3.sdk.yop.encrypt.DigitalEnvelopeDTO;
import com.yeepay.g3.sdk.yop.encrypt.DigitalSignatureDTO;
import com.yeepay.g3.sdk.yop.utils.DigitalEnvelopeUtils;
import com.yeepay.g3.sdk.yop.utils.InternalConfig;
import com.yeepay.g3.yop.sdk.api.StdApi; //是yos-java-sdk-1.0里的

import sun.misc.BASE64Decoder;

public class YeepayService {

	//yop接口应用URI地址
	public static final String BASE_URL = "baseURL";
	public static final String TRADEORDER_URL = "tradeOrderURI";
	public static final String ORDERQUERY_URL = "orderQueryURI";
	public static final String REFUND_URL = "refundURI";
	public static final String REFUNDQUERY_URL = "refundQueryURI";
	public static final String MULTIORDERQUERY_URL = "multiOrderQueryURI";
	public static final String ORDERCLOSE_URL = "orderCloseURI";
	public static final String SETTLEMENTSQUERY_URL = "settlementsqueryURI";
	public static final String BALANCEQUERY_URL = "balancequeryURI";
	public static final String HMACKEYQUERY_URL = "hmackeyqueryURI";
	public static final String APICASHIER_URI = "APICASHIER";
	public static final String CASHWITHDRALWAL_URL = "cashWithdralwalURL";
	
	public static final String TRADEDIVIDE_URL = "tradedivideURI";
	public static final String TRADEDIVIDEQUERY_URL = "tradedividequeryURI";
	public static final String TRADEFULLSETTLE_URL = "tradefullsettleURI";
	
	//新文件上传uri
	public static final String NEWUPLOAD_URL = "newUploadURI";

	//对账文件下载uri
	public static final String NEWDOWNLOADBYDAY_URL = "newDownloadByDayURI";
	public static final String NEWDOWNLOADBYMONTH_URL = "newDownloadByMonthURI";
	
	
	
	
	public static final String PERSON_URL = "personURI";
	public static final String INDIVIDUAL_URL = "individualURI";
	public static final String ENTERPRISE_URL = "enterpriseURI";
	public static final String AGREEINFOQUERY_URL = "agreeinfoqueryURI";
	public static final String BANKBRANCHINFO_URL = "bankBranchInfoURI";
	public static final String REGSTATUSQUERY_URL = "regstatusqueryURI";
	public static final String UPLOAD_URL = "uploadURI";
	public static final String SENDAUTHORIZENUM_URL = "sendauthorizenumURI";
	public static final String SENDMERSMSNOTIFY_URL = "sendmersmsnotifyURI";
	public static final String MERPRODUCTFEEUPDATEFORO2O_URL = "merproductfeeupdateforo2oURI";
	public static final String MERSETTLEINFOUPDATEFORO2O_URL = "mersettleinfoupdateforo2oURI";
	public static final String AUTHORIZEURLQUERY_URL = "authorizeurlqueryURI";
	public static final String RECEIVEAUTHORIZENUM_URL = "receiveauthorizenumURI";

	//接口参数
	public static final String[] TRADEORDER = {"parentMerchantNo","merchantNo","orderId","orderAmount","timeoutExpress","requestDate","redirectUrl","notifyUrl","goodsParamExt","paymentParamExt","industryParamExt","memo","riskParamExt","csUrl","fundProcessType"};
	public static final String[] ORDERQUERY = {"parentMerchantNo","merchantNo","orderId","uniqueOrderNo"};
	public static final String[] REFUND = {"parentMerchantNo","merchantNo","orderId","uniqueOrderNo","refundRequestId","refundAmount","description","memo","notifyUrl"};
	public static final String[] REFUNDQUERY = {"parentMerchantNo","merchantNo","refundRequestId","orderId","uniqueRefundNo"};
	public static final String[] MULTIORDERQUERY = {"status","parentMerchantNo","merchantNo","requestDateBegin","requestDateEnd","pageNo","pageSize"};
	public static final String[] ORDERCLOSE = {"parentMerchantNo","merchantNo","orderId","uniqueOrderNo","description"};
	public static final String[] SETTLEMENTSQUERY = {"parentMerchantNo","merchantNo","startSettleDate","endSettleDate"};
	public static final String[] BALANCEQUERY = {"parentMerchantNo","merchantNo"};
	public static final String[] HMACKEYQUERY = {"parentMerchantNo","merchantNo"};
	public static final String[] CASHWITHDRALWALKEY = {"customerNumber","amount","orderId","cashType","feeType","leaveWord","bankCardId","notifyUrl"};
	
	public static final String[] TRADEDIVIDE = {"parentMerchantNo","merchantNo","divideRequestId","orderId","uniqueOrderNo","contractNo","divideDetail","infoParamExt"};
	public static final String[] TRADEDIVIDEQUERY = {"parentMerchantNo","merchantNo","divideRequestId","orderId","uniqueOrderNo"};
	public static final String[] TRADEFULLSETTLE = {"parentMerchantNo","merchantNo","orderId","uniqueOrderNo"};
	
	//商户入网接口参数
	public static final String[] PERSON = {"requestNo","parentMerchantNo","merShortName","legalName","legalIdCard","merLegalPhone","merLegalEmail","merLevel1No","merLevel2No","merProvince","merCity","merDistrict","merAddress","merScope","cardNo","headBankCode","bankCode","bankProvince","bankCity","productInfo","fileInfo","businessFunction","notifyUrl","merAuthorizeType"};
	public static final String[] INDIVIDUAL = {"requestNo","parentMerchantNo","merFullName","merShortName","merCertNo","legalName","legalIdCard","merLegalPhone","merLegalEmail","merLevel1No","merLevel2No","merProvince","merCity","merDistrict","merAddress","cardNo","headBankCode","bankCode","bankProvince","bankCity","productInfo","fileInfo","businessFunction","notifyUrl","merAuthorizeType"};
	public static final String[] ENTERPRISE = {"requestNo","parentMerchantNo","merFullName","merShortName","merCertType","merCertNo","legalName","legalIdCard","merLevel1No","merLevel2No","merProvince","merCity","merDistrict","merAddress","merContactName","merContactPhone","merContactEmail","taxRegistCert","accountLicense","orgCode","isOrgCodeLong","orgCodeExpiry","cardNo","headBankCode","bankCode","bankProvince","bankCity","productInfo","fileInfo","businessFunction","notifyUrl","merAuthorizeType"};
	public static final String[] AGREEINFOQUERY = {"parentMerchantNo","merchantNo"};
	public static final String[] BANKBRANCHINFO = {"headBankCode","provinceCode","cityCode"};
	public static final String[] REGSTATUSQUERY = {"parentMerchantNo","merchantNo"};
	public static final String[] UPLOAD = {"fileType","_file"};
	public static final String[] SENDAUTHORIZENUM = {"parentMerchantNo","merchantNo","phone"};
	public static final String[] SENDMERSMSNOTIFY = {"parentMerchantNo","merchantNo","phone","sourceType"};
	public static final String[] MERPRODUCTFEEUPDATEFORO2O = {"parentMerchantNo","merchantNo","requestNo","merAuthorizeNum","payProductMap"};
	public static final String[] MERSETTLEINFOUPDATEFORO2O = {"parentMerchantNo","merchantNo","requestNo","merAuthorizeNum","bankcardNo","headBankName","bankName","bankProvince","bankCity","callbackurl"};
	public static final String[] AUTHORIZEURLQUERY = {"parentMerchantNo","merchantNo"};
	public static final String[] RECEIVEAUTHORIZENUM = {"parentMerchantNo","merchantNo","phone","merAuthorizeNum"};
	
	//验签顺序
	public static final String[] TRADEORDER_HMAC = {"parentMerchantNo","merchantNo","orderId","orderAmount","notifyUrl"};	
	public static final String[] ORDERQUERY_HMAC = {"parentMerchantNo","merchantNo","orderId","uniqueOrderNo"};	
	public static final String[] REFUND_HMAC = {"parentMerchantNo","merchantNo","orderId","uniqueOrderNo","refundRequestId","refundAmount"};	
	public static final String[] REFUNDQUERY_HMAC = {"parentMerchantNo","merchantNo","refundRequestId","orderId","uniqueRefundNo"};
	public static final String[] MULTIORDERQUERY_HMAC = {"parentMerchantNo","merchantNo","requestDateBegin","requestDateEnd","pageNo","pageSize"};
	public static final String[] ORDERCLOSE_HMAC = {"parentMerchantNo","merchantNo","orderId","uniqueOrderNo"};
	public static final String[] SETTLEMENTSQUERY_HMAC = {"parentMerchantNo","merchantNo","startSettleDate","endSettleDate"};
   public static final String[] TRADEDIVIDE_HMAC={"parentMerchantNo","merchantNo","orderId","uniqueOrderNo","divideRequestId"};
	public static final String[] TRADEDIVIDEQUERY_HMAC={"parentMerchantNo","merchantNo","orderId","uniqueOrderNo","divideRequestId"};
   public static final String[] TRADEFULLSETTLE_HMAC={"parentMerchantNo","merchantNo","orderId","uniqueOrderNo"};
	//支付方式
	public static final String[] CASHIER = {"merchantNo","token","timestamp","directPayType","cardType","userNo","userType","ext"};
	public static final String[] APICASHIER = {"token","payTool","payType","userNo","userType","appId","openId","payEmpowerNo","merchantTerminalId","merchantStoreNo","userIp","version"};

	//获取对账类型
	public static final String TRADEDAYDOWNLOAD = "tradedaydownload";
	public static final String TRADEMONTHDOWNLOAD = "trademonthdownload";
		
	//获取对应的请求地址
	public static String getUrl(String payType){
		return Configuration.getInstance().getValue(payType);
	}

	//拼接支付链接
	public static String getUrl(Map<String,String> paramValues) throws Exception{
		StringBuffer url = new StringBuffer();
		url.append(getUrl("CASHIER"));
		paramValues.put("merchantNo", getParentMerchantNo());
		StringBuilder stringBuilder = new StringBuilder();
		System.out.println(paramValues);
		for (int i = 0; i < CASHIER.length; i++) {
			String name = CASHIER[i];
			String value = paramValues.get(name);
			if(i != 0){
				stringBuilder.append("&");
			}
			stringBuilder.append(name+"=").append(value);
		}
		System.out.println(stringBuilder);
		String sign = getSign(stringBuilder.toString());
		url.append("?sign="+sign+"&"+stringBuilder);
		return url.toString();
	}
	
	//获取父商编
	public static String getParentMerchantNo(){
		return Configuration.getInstance().getValue("parentMerchantNo");
	}
	
	//获取子商编
	public static String getMerchantNo(){
		return Configuration.getInstance().getValue("merchantNo");
	}
	
	//获取父商编密钥
	public static String getParentKey(){
		return Configuration.getInstance().getValue("privatekey");
	}
	
	//获取父商编公钥
	public static String getPKey(){
		return Configuration.getInstance().getValue("publickey");
	}	
	
	
	//获取父商编私钥
	public static PrivateKey getSecretKey(){
		PrivateKey isvPrivateKey = InternalConfig.getISVPrivateKey(CertTypeEnum.RSA2048);
		return isvPrivateKey;
	}
	
	//获取子商户密钥
	public static String getMerchantKey() throws IOException{
		String merchantNo = getMerchantNo();
		Map<String, String> params = new HashMap<>();
		params.put("parentMerchantNo", getParentMerchantNo());
		params.put("merchantNo", merchantNo);
		
		Map<String, String> result = new HashMap<>();
		String uri = getUrl(HMACKEYQUERY_URL);
		result = YeepayService.requestYOP(params, uri, HMACKEYQUERY);
		
		System.out.println("result:"+result);
		return result.get("merHmacKey");
	}
	
	//获取公钥
	public static PublicKey getPublicKey(){
		PublicKey isvPublicKey = InternalConfig.getYopPublicKey(CertTypeEnum.RSA2048);
		return isvPublicKey;
	}
	public static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = (new BASE64Decoder()).decodeBuffer(key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
  }
	public static PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = (new BASE64Decoder()).decodeBuffer(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
  }
	//获取sign
	public static String getSign(String stringBuilder) throws Exception{
		String appKey = "OPR:"+getParentMerchantNo();
		PrivateKey isvPrivateKey = getPrivateKey(YeepayService.getParentKey());
		DigitalSignatureDTO digitalSignatureDTO = new DigitalSignatureDTO();
		digitalSignatureDTO.setAppKey(appKey);
		digitalSignatureDTO.setCertType(CertTypeEnum.RSA2048);
		digitalSignatureDTO.setDigestAlg(DigestAlgEnum.SHA256);
		digitalSignatureDTO.setPlainText(stringBuilder.toString());
		String sign = DigitalEnvelopeUtils.sign0(digitalSignatureDTO,isvPrivateKey);
		return sign;
	}
	
	/**
	 * 请求YOP接口---其他接口使用
	 * params 请求参数,parentMerchantNo除外
	 * uri 请求yop的应用URI地址
	 * paramSign 请求参数的验签顺序
	 * hmackey 子商编私钥
	 * paramHmac 验签参数
	 * @throws IOException 
	 */
	public static Map<String, String> requestYOP(Map<String, String> params, String uri, String[] paramSign, String[] paramHmac) throws IOException{
		Map<String, String> result = new HashMap<String, String>();
		System.out.println("请求进入");
		String BASE_URL = getUrl("baseURL");
		String parentMerchantNo = YeepayService.getParentMerchantNo();
		System.out.println("parentMerchantNo---->"+parentMerchantNo);
		String hmackey = getMerchantKey();
		System.out.println("hmackey---->"+hmackey);
		System.out.println("privatekey---->"+YeepayService.getParentKey());
		YopRequest request = new YopRequest("OPR:" + parentMerchantNo,YeepayService.getParentKey());
		
		for (int i = 0; i < paramSign.length; i ++) {
			String key = paramSign[i];
			System.out.println("name:"+key);
			System.out.println("value:"+params.get(key));
			request.addParam(key, params.get(key)==null?"":params.get(key));
		}
		System.out.println("yoprui:"+uri);
		System.out.println("yopRequest:"+request.getParams());
		
		StringBuffer hmacBuffer = new StringBuffer();
		for(int i = 0; i < paramHmac.length; i++){
			String key = paramHmac[i];
			hmacBuffer.append(key).append("=").append(params.get(key)).append("&");
		}
		
		String hmacStr = hmacBuffer.subSequence(0, hmacBuffer.length()-1).toString();
		System.out.println("hmacStr:"+hmacStr);
		System.out.println("hmackey:"+hmackey);
		String hmac = Md5Utils.encoderHmacSha256(hmacStr, hmackey);
		System.out.println("hmac:"+hmac);
		request.addParam("hmac", hmac);
		
		System.out.println(request.getParams());
		YopResponse response = YopRsaClient.post(uri, request);
		
		System.out.println(response.toString());
		if("FAILURE".equals(response.getState())){
			if(response.getError() != null)
			result.put("code",response.getError().getCode());
			result.put("message",response.getError().getMessage());
			return result;
		}
		if (response.getStringResult() != null) {
			result = parseResponse(response.getStringResult());
		}
		
		return result;
	}
	
	/**
	 * 请求YOP接口-----子商户注册接口使用
	 * params 请求参数,parentMerchantNo除外
	 * uri 请求yop的应用URI地址
	 * paramSign 请求参数的验签顺序
	 * @throws IOException 
	 */
	public static Map<String, String> requestYOP(Map<String, String> params, String uri, String[] paramSign) throws IOException{
		Map<String, String> result = new HashMap<String, String>();
		String BASE_URL = getUrl("baseURL");
		
		String parentMer = getParentMerchantNo();
		YopRequest request = new YopRequest("OPR:"+parentMer,YeepayService.getParentKey());
		System.out.println(BASE_URL);
		for (int i = 0; i < paramSign.length; i ++) {
			String key = paramSign[i];
			System.out.println("name:"+key);
			System.out.println("value:"+params.get(key));
			request.addParam(key, params.get(key)==null?"":params.get(key));
		}
		System.out.println("yoprui:"+uri);
		System.out.println("yopRequest:"+request.getParams());
				
		YopResponse response = YopRsaClient.post(uri, request);
		
		System.out.println(response.toString());
		if("FAILURE".equals(response.getState())){
			if(response.getError() != null)
			result.put("returnCode",response.getError().getCode());
			result.put("returnMsg",response.getError().getMessage());
			return result;
		}
		if (response.getStringResult() != null) {
			result = parseResponse(response.getStringResult());
		}
		
		return result;
	}

	//将获取到的response转换成json格式
	public static Map<String, String> parseResponse(String response){
		
		Map<String,String> jsonMap  = new HashMap<>();
		jsonMap	= JSON.parseObject(response, 
				new TypeReference<TreeMap<String,String>>() {});
		
		return jsonMap;
	}
	
	/**
	 *  获取支行信息
	 *  headBankCode 银行总称
	 *  provinceCode 省编码
	 * 	cityCode     市编码 
	 * @throws IOException 
	 */
	public static Map<String, String> getBankBranchInfo(String headBankCode, String provinceCode, String cityCode) throws IOException{
		Map<String, String> result = new HashMap<>();
		Map<String, String> params = new HashMap<>();
		params.put("headBankCode", headBankCode);
		params.put("provinceCode", provinceCode);
		params.put("cityCode", cityCode);
		
		String uri = YeepayService.getUrl(YeepayService.BANKBRANCHINFO_URL);
		System.out.println(uri);
		result = YeepayService.requestYOP(params, uri, YeepayService.BANKBRANCHINFO);
		System.out.println(result);
		
		return result;
	}
	
	/**
	 *	商户产品协议获取
	 * @throws IOException 
	 */
	public static Map<String, String> getAgreeInfoQuery() throws IOException{
		Map<String, String> result = new HashMap<>();
		String parentMerchantNo = getParentMerchantNo();
		String merchantNo = getMerchantNo();
		Map<String, String> params = new HashMap<>();
		params.put("parentMerchantNo", parentMerchantNo);
		params.put("merchantNo", merchantNo);
		String uri = YeepayService.getUrl(YeepayService.AGREEINFOQUERY_URL);
		System.out.println(uri);
		result = YeepayService.requestYOP(params, uri, YeepayService.AGREEINFOQUERY);
		System.out.println(result);
		return result;
	}
	
	/**
	 * 文件上传，获取地址
	 * @param
	 * @return
	 * @throws IOException 
	 */
	public static Map<String,String> upload(String fileType, String file) throws IOException {
		Map<String, String> result = new HashMap<>();
		String uri = YeepayService.getUrl(YeepayService.NEWUPLOAD_URL);
		System.out.println(uri);
		YopRequest request = new YopRequest("OPR:"+getParentMerchantNo(),YeepayService.getParentKey());
		
		
		request.addParam("fileType", fileType);
	    //request.addParam("_file", "file:"+file);
		//request.addParam("_file", file);

		// 本地文件参数传递
		request.addFile(new File(file));
	    System.out.println(request.toQueryString());
		YopResponse response = YopRsaClient.upload(uri, request);

	    System.out.println(response.toString());
		if("FAILURE".equals(response.getState())){
			if(response.getError() != null)
			result.put("code",response.getError().getCode());
			result.put("message",response.getError().getMessage());
			return result;
		}
		if (response.getStringResult() != null) {
			result = parseResponse(response.getStringResult());
		}
		return result;
	}
	/**
	 * 上传本地文件流
	 * @param
	 * @return
	 */
	public static Map<String,String> uploadStream(String fileType, String file) throws IOException {
		Map<String, String> result = new HashMap<>();
		String uri = YeepayService.getUrl(YeepayService.NEWUPLOAD_URL);
		System.out.println(uri);
		YopRequest request = new YopRequest("OPR:"+getParentMerchantNo(),YeepayService.getParentKey());
		request.addParam("fileType", fileType);

		// 本地文件流参数传递
		//FileInputStream stream = new FileInputStream(new File(file));
		InputStream inputStream = new BufferedInputStream(new FileInputStream(new File(file)));
		request.addFile(inputStream);

		System.out.println(request.toQueryString());


	    YopResponse response = YopRsaClient.upload(uri, request);
	    System.out.println(response.toString());
		if("FAILURE".equals(response.getState())){
			if(response.getError() != null)
			result.put("code",response.getError().getCode());
			result.put("message",response.getError().getMessage());
			return result;
		}
		if (response.getStringResult() != null) {
			result = parseResponse(response.getStringResult());
		}
		return result;
	}
	/**
	 * 上传远程文件
	 * @param
	 * @return
	 * */
	public static Map<String,String> uploadUrlStream(String fileType, String file) throws IOException {
		Map<String, String> result = new HashMap<>();
		String uri = YeepayService.getUrl(YeepayService.NEWUPLOAD_URL);
		System.out.println(uri);
		YopRequest request = new YopRequest("OPR:"+getParentMerchantNo(),YeepayService.getParentKey());
		request.addParam("fileType", fileType);
	    //request.addParam("_file", "file:"+file);
		//request.addParam("_file", file);
		// 本地远程文件参数
		request.addFile("merQual",new URL(file).openStream());
	    System.out.println(request.toQueryString());

	    YopResponse response = YopRsaClient.upload(uri, request);
	    System.out.println(response.toString());
		if("FAILURE".equals(response.getState())){
			if(response.getError() != null)
			result.put("code",response.getError().getCode());
			result.put("message",response.getError().getMessage());
			return result;
		}
		if (response.getStringResult() != null) {
			result = parseResponse(response.getStringResult());
		}
		return result;
	} 
	
	/**
	 * 新接口的文件上传，获取地址
	 * @param
	 * @return
	 * @throws IOException 
	 */
	public static Map<String,String> newupload(String fileType, String file) throws IOException {
		Map<String, String> result = new HashMap<>();
		String uri = YeepayService.getUrl(YeepayService.NEWUPLOAD_URL);
		System.out.println(uri);
		YopRequest request = new YopRequest("OPR:"+getParentMerchantNo());
		
		// 本地文件参数传递
		request.addParam("fileType", fileType);
		//新接口文件上传的方式
        request.addFile("merQual",new File(file)); 

	    System.out.println(request.toQueryString());
		YopResponse response = YopRsaClient.upload(uri, request);

	    System.out.println(response.toString());
		if("FAILURE".equals(response.getState())){
			if(response.getError() != null)
			result.put("code",response.getError().getCode());
			result.put("message",response.getError().getMessage());
			return result;
		}
		if (response.getStringResult() != null) {
			result = parseResponse(response.getStringResult());
		}
		return result;
	}
	
	
	//回调
	public static Map<String, String> callback(String response){
		System.out.println("进入回调处理");
		DigitalEnvelopeDTO dto = new DigitalEnvelopeDTO();
		dto.setCipherText(response);
		Map<String,String> jsonMap  = new HashMap<>();
	    try {
	        PrivateKey privateKey = getPrivateKey(YeepayService.getParentKey());
	        PublicKey publicKey = getPublicKey(YeepayService.getPKey());
	        dto = DigitalEnvelopeUtils.decrypt(dto, privateKey, publicKey);
	        System.out.println(dto.getPlainText());
	        jsonMap = parseResponse(dto.getPlainText());
        } catch (Exception e) {
        	e.printStackTrace();
        }
	    System.out.println("回调处理结束");
		return jsonMap;
	}
	
	public static boolean verifyCallback(Map<String,String> responseMap){
		boolean flag = false;
		String merchantNo = responseMap.get("merchantNo");
		String parentMerchantNo = responseMap.get("parentMerchantNo");
		String orderId = responseMap.get("orderId");
		String signResp = responseMap.get("sign");
	    String s = "merchantNo="+merchantNo+"&parentMerchantNo="+parentMerchantNo+"&orderId="+orderId;
	    System.out.println("s===="+s);
	    String appKey = "OPR:"+getMerchantNo();
		PublicKey isvPublicKey = getPublicKey();
		DigitalSignatureDTO digitalSignatureDTO = new DigitalSignatureDTO();
		digitalSignatureDTO.setAppKey(appKey);
		digitalSignatureDTO.setCertType(CertTypeEnum.RSA2048);
		digitalSignatureDTO.setDigestAlg(DigestAlgEnum.SHA256);
		digitalSignatureDTO.setPlainText(s.toString());
		digitalSignatureDTO.setSignature(signResp);
		try {
			DigitalEnvelopeUtils.verify0(digitalSignatureDTO,isvPublicKey);
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}


	/**
	 * 下载对账单
	 * @param
	 * @return
	 */
	public static String yosFile(Map<String, String> params, String path) {
		StdApi apidApi = new StdApi();
		InputStream inputStream = null;
		OutputStream outputStream = null;
		String merchantNo = getMerchantNo();
		String method = params.get("method");
		String date = params.get("date");
		
		String fileName = ""; 
		String filePath = "";
		try {
			if (method.equals(YeepayService.TRADEDAYDOWNLOAD)) {
				System.out.println("1");
				inputStream = apidApi.tradeDayBillDownload(merchantNo, date);
				fileName = "tradeday-"+date+".csv";
				
			}else if(method.equals(YeepayService.TRADEMONTHDOWNLOAD)){
				System.out.println("2");
				inputStream = apidApi.tradeMonthBillDownload(merchantNo, date);
				fileName = "trademonth-"+date+".csv";
				
			}
			filePath	= path + File.separator + fileName;
			System.out.println("filePath====="+filePath);
			outputStream = new FileOutputStream(new File(filePath));
			byte[] bs = new byte[1024];
			int readNum;
			while ((readNum = inputStream.read(bs)) != -1) {
				outputStream.write(bs, 0, readNum);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			return null;
		} finally {
			try {
				outputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				inputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return filePath;
	}
	
	/**
	 * 新的下载对账单接口
	 * @param
	 * @return
	 */
	public static String newdownload(Map<String, String> params, String path) {
		InputStream returnStream = null; //从yop返回的请求对账文件的流
		OutputStream outputStream = null; //输出到项目中的流
		String parentMerchantNo=getParentMerchantNo();
		String merchantNo = getMerchantNo();
		String method = params.get("method");
		//日期格式  yyyy-mm-dd 或者月的格式 yyyy-mm
		String date = params.get("date"); 

		String OPRkey=getParentKey();  //父商编私钥
	//	String OPRkey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDKLgI+64mmJdNg1TwlCPBnNH3b3qfw2TdHVc2uDd4LTyQI8nRr0heFhhdj0OZi6agqekIyzAH/XmO9PdLrTi4YXJXOfiO/dYwKA6gSktRe6FKY4C2WzX1yA4fGfqJMV7RYVoL6In50Hur6rGnavNSQZqbiDJOgy5yokJ14Mey1iMqqqWvADtKN9SqxtbyIxYD/jj/6qLWwmu88wSwSaGdO3wNFgzajsHgRJe9G9IhD0zr5d72HvJGoedq7VaPn3jhIszcPQE6oqbXAddZRGKBehA4WSCjLEl87XH33zZPrxrQlBTHVVGzfxjbB4QvYz0hlEoWh1ntxeDHTfgyhdPQpAgMBAAECggEATmxMSLW6Xe08McpkmwT9ozq0Oy4BvKW1EIGS15nfcEmRc7sAN7Z1k0BxIDGuu91gcqGbvfJuL+0gCQ7LGqTnsmFvZnp9SU3CNTw33ISBxhKdv1jtthodN7Vw3CjQsYYvmThtc7Mfk9FOWk+4e7VVSnHW98XjGbMBIE2AF1heNgeZ40ubdgzuz9+4g4pphjWncPpwcaMfsDZm3JtFyvUp0+LME0CmUqrxvONZAkpFR/PyejGHnIh3ptHzhe/VjNcuIC4PphkCNBakCBCrtohTy0YeeWfDAUTAO4tPXF/JUhlxjPuqR6rpQY/0uQdMAtTpiWHVJar7eGdK81QnuuOFRQKBgQDrklUPM0pkvGG/wREa0bgUI+ki+1/wv7O8X94/8onomJqPpkD8z4hv/Lev/wD5gDcgmgLC36u/XDuhFfVNOmw4eUWenU6pzonroEjhi91AKcRRfzDfOfWg3wPm1J9WQOn5A033tNRydCpVcX/Ot4qDbKcAwLiPNPXXMTn4LUQE/wKBgQDbtmE0KS/kSfjscWJOqwv1XbxckipkxncqIbdiSdU+DzaLd+Vuaco7TLQJRFp7S7WJW4Tz6KBX2UiA7O7ezXY9PwlgXxXiZDDtneXNAqk7DNxmTTZHrF2C7qdU98klppCFiFx9bysGY6lFWofWmg3Pu5IiPqO3iLRPTvZgQOE+1wKBgQC9SCgmfYzyIlfcjtIinY5uSGiEnjz5od9WpiVbdpOPHEdc0zZ2rH6xlPs3ZAuxbm9dN8KuOLC0ovSau50Nv7rDKdZh234gfP9fH7xP1mUhsC25Why30MdnyqpE6GVbFe+qERitx1PI30RAwWDzhZC7hystNK1XDDPZBAnTOvPjmwKBgDFuujX7IkxRnFDOPdkHQNyGp2+Ib0NXJ85x4YmapQCeeZ4tbpBF+vsWidcf6t+crA5oaeRarWC2gUqIhEHapkSnXxuwqQLTmfKMOPzEIYEoppnZu2Gq1Ss1OK60RSxUamWwxWZvUZXRbG8vLCrLZFodkIZl433SowbI9EO5tTPnAoGAJRsy1z95Q1GPkKrFtKivkxZy1k7zJXjM0VWDc7lT9fBnoeGUyt+vuq+lC5i2aiWKJK7pe8MM9QFDGlWPnly+J8jbyMfm99k5oJtCWDfF0or1pAQ4mw0kjL9TvDVXdojgYA+rxSMQ09hwsYukQ4bblrwfBUmRjLN5WibcRzIW5ZA=";

		YopRequest request = new YopRequest("OPR:"+parentMerchantNo,OPRkey);
		YopResponse response=null; //获得一个yop response

		//配置参数，按月对账和按日对账后边的参数不同
//		request.addParam("parentMerchantNo", "10000466938");
//		request.addParam("merchantNo", "10000466938");

		request.addParam("parentMerchantNo", parentMerchantNo);
		request.addParam("merchantNo", merchantNo);

		//按照月和日参数的不同向yop发起对账文件流的请求
		//arg0:接口的uri（参见手册）
		//arg1:配置好参数的请求对象
	
		String fileName = ""; 
		String filePath = "";
		try {
			if (method.equals(YeepayService.TRADEDAYDOWNLOAD)) {
				System.out.println("1");
				//本日交易次日生成对账文件，请勿用当日做参数，以日作为参数
				request.addParam("dayString",date);
				response=YopRsaClient.post(getUrl(NEWDOWNLOADBYDAY_URL),request);
				fileName = "tradeday-"+date+".csv";
				
			}else if(method.equals(YeepayService.TRADEMONTHDOWNLOAD)){
				System.out.println("2");
				request.addParam("monthString",date);
				response=YopRsaClient.post(getUrl(NEWDOWNLOADBYMONTH_URL), request);
				fileName = "trademonth-"+date+".csv";				
			}
			System.out.println(response.toString());
			 returnStream= response.getFile();
			if(returnStream==null) {
				System.out.println("kongkongkong"+filePath);
			}
			filePath	= path + File.separator + fileName;
			System.out.println("filePath====="+filePath);
			File file=new File(filePath);
			if(!file.exists()) {
				file.createNewFile();
			}
			String result = new BufferedReader(new InputStreamReader(returnStream)).lines().collect(Collectors.joining(System.lineSeparator()));
			
			
			System.out.println(result);
			
			outputStream = new FileOutputStream(file);
			byte[] bs = new byte[1024];
			int readNum;
			while ((readNum = returnStream.read(bs)) != -1) {
				outputStream.write(bs, 0, readNum);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			return null;
		} finally {
			try {
				outputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				returnStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return filePath;
	}
	
}
