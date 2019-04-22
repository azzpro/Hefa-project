/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月23日 下午1:52:04
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.system.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.ObjectMetadata;
import com.hefa.common.base.JsonResult;
import com.hefa.common.constants.FileConstants;
import com.hefa.common.exception.ValidationException;
import com.hefa.system.bo.UploadImageParam;
import com.hefa.utils.AzzImageUtil;
import com.hefa.utils.Base64;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年10月23日 下午1:52:04
 */
@Service
public class SystemImageService {
	
	private static final Logger LOG = LoggerFactory.getLogger(SystemImageService.class);
	
	@Value("${aliyun.endpoint}")
	private String endpoint;
	
	@Value("${aliyun.accessKeyId}")
	private String accessKeyId;
	
	@Value("${aliyun.accessKeySecret}")
	private String accessKeySecret;
	
	public JsonResult<String> uploadImage(@RequestBody UploadImageParam up){
		if(!bucketNameExist(up.getBucketname())) {
			throw new ValidationException("存储空间名称不存在");
		}
		//后缀
		boolean contains = FileConstants.AZZ_IMAGE_SUFFIX.contains(up.getSuffix());
		
		if(!contains) {
			throw new ValidationException("不支持的文件后缀");
		}
		
		//返回图片Url
		StringBuilder imageurl = new StringBuilder(endpoint);
		//文件名
		StringBuilder finalName = new StringBuilder();
		//获取平台名 ：平台端 商户断 客户端
		String type = AzzImageUtil.getPlatByType(up.getPlattype());
		if(StringUtils.isBlank(type) || type.length() <= 0) {
			throw new ValidationException("平台类型错误");
		}else {
			finalName.append(type);
		}
		//获取图片类型：营业执照  法人照片 图像 其他
		String imagetype = AzzImageUtil.getImageByType(up.getImagetype());
		if(StringUtils.isBlank(imagetype) || imagetype.length() <= 0) {
			throw new ValidationException("图片类型错误");
		}else {
			finalName.append("/");
			finalName.append(imagetype);
			finalName.append("/");
		}
		finalName.append(up.getFilename()).append(".").append(up.getSuffix());
		LOG.info("生成的图片名称------->["+finalName.toString()+"]");
		//base64 
		/**生产环境使用****/
		byte[] decode = Base64.decode(up.getFiledata());
		InputStream is = new ByteArrayInputStream(decode);
		//判断文件大小 不能超过20MB
		try {
			if(FileConstants.IMAGE_SIZE < is.available()/1024/1024) {
				throw new ValidationException("图片超过20MB");
			}
		}catch (IOException e) {
			throw new ValidationException("获取图片大小失败");
		}
		
		//设置文件元信息
		ObjectMetadata meta = new ObjectMetadata();
		try {
			meta.setContentLength(is.available());
		}catch (IOException e) {
			throw new ValidationException("文件无效");
		}
		
		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		// 上传文件流。
		ossClient.putObject(up.getBucketname(), finalName.toString(), is);
		// 关闭OSSClient。
		ossClient.shutdown();
		imageurl.insert(7, up.getBucketname()+".");
		imageurl.append("/").append(finalName.toString());
		return JsonResult.successJsonResult(imageurl.toString());
	}
	
	
	/**
	 * <p>创建存储空间</p>
	 * @author 刘建麟  2018年10月23日 下午2:12:49
	 */
	public String createBucketName(String bucketname) {
		if(StringUtils.isBlank(bucketname)) {
    		throw new ValidationException("存储空间名称不能为空");
    	}
		boolean b = bucketNameExist(bucketname);
		if(!b) {
			OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
			Bucket bucket = ossClient.createBucket(bucketname);
			return bucket.getName();
		}else {
			throw new ValidationException("存储空间名称已存在");
		}
		
	}
	
	/**
	 * <p>存储空间是否存在</p>
	 * @author 刘建麟  2018年10月23日 下午2:12:49
	 */
	public Boolean bucketNameExist(String bucketname) {
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		boolean exist = ossClient.doesBucketExist(bucketname);
		ossClient.shutdown();
		return exist;
	}
	
	/**
	 * <p>删除存储空间</p>
	 * @author 刘建麟  2018年10月23日 下午2:12:49
	 */
	public void deleteBucketName(String bucketname) {
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		ossClient.deleteBucket(bucketname);
		ossClient.shutdown();
	}
}

