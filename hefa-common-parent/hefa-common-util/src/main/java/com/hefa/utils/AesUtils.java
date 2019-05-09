/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年5月9日 上午11:59:49
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.hefa.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * <P>
 * TODO
 * </P>
 * 
 * @version 1.0
 * @author 黄智聪 2019年5月9日 上午11:59:49
 */
public class AesUtils {
	
	/**
	 *  
	 * <p>加密</p>
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 * @author 黄智聪  2019年5月9日 下午12:03:34
	 */
	public static String encrypt(String data, String key) {
		try {
			if (key == null) {
				System.out.print("Key为空null");
				return null;
			}
			byte[] raw = key.getBytes("utf-8");
			SecretKeySpec keySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// "算法/模式/补码方式"
			cipher.init(Cipher.ENCRYPT_MODE, keySpec);
			byte[] encrypted = cipher.doFinal(data.getBytes("utf-8"));
			return new String(Base64.encodeBase64(encrypted));// 此处使用BASE64做转码功能，同时能起到2次加密的作用。
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * <p>解密</p>
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 * @author 黄智聪  2019年5月9日 下午12:03:39
	 */
	public static String decrypt(String data, String key) {
		try {
			// 判断Key是否正确
			if (key == null) {
				System.out.print("Key为空null");
				return null;
			}
			byte[] raw = key.getBytes("utf-8");
			SecretKeySpec keySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, keySpec);
			byte[] encrypted1 = Base64.decodeBase64(data.getBytes());// 先用base64解密
			try {
				byte[] original = cipher.doFinal(encrypted1);
				String originalString = new String(original, "utf-8");
				return originalString;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

}
