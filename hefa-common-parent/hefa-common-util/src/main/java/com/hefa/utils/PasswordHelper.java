package com.hefa.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.Assert;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.hefa.common.base.Password;

/**
 * 
 * <P>密码工具类</P>
 * @version 1.0
 * @author 黄智聪  2019年4月15日 下午1:55:44
 */
public class PasswordHelper {

	/**
	 * <p>根据用户设置的密码获取加密后的密码以及加密使用的盐值 </p>
	 * 
	 * @param password
	 * @return
	 * @return Password
	 * @author 黄智聪
	 */
	public static Password encryptPasswordByModel(String password) {
		Assert.hasText(password, "密码不能为空");
		String salt = RandomStringUtils.randomAlphanumeric(16);
		Password pwd = new Password();
		pwd.setSalt(salt);
		pwd.setPassword(Hashing.md5().hashString(password + salt, Charsets.UTF_8).toString());
		return pwd;
	}

	/**
	 * <p>根据用户输入的密码和已有的盐值获取加密字符串 </p>
	 * 
	 * @param password
	 * @param salt
	 * @return
	 * @return String
	 * @author 黄智聪
	 */
	public static String getEncryptPassword(String password, String salt) {
		Assert.hasText(password, "密码不能为空");
		Assert.hasText(salt, "盐值不能为空");
		return Hashing.md5().hashString(password + salt, Charsets.UTF_8).toString();
	}

	/**
	 * <p>校验输入的密码和指定密码的一致性</p>
	 * 
	 * @param inputPassword 用户输入的密码
	 * @param savePassword 数据库存储的hash密码值
	 * @param salt 数据库存储的盐值
	 * @return
	 * @return boolean
	 * @author 黄智聪
	 */
	public static boolean checkPassword(String inputPassword, String salt, String savePassword) {
		Assert.hasText(salt, "盐值不能为空");
		Assert.hasText(savePassword, "校验密码不能为空");
		Assert.hasText(salt, "盐值不能为空");
		String inputPass = Hashing.md5().hashString(inputPassword + salt, Charsets.UTF_8).toString();
		if (inputPass.equals(savePassword)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Password p = encryptPasswordByModel("8NgpOIngA@nqG1hA");
		System.out.println(p.getPassword());
		System.out.println(p.getSalt());
	}
}
