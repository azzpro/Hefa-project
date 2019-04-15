package com.hefa.common.base;

/**
 * <P>TODO</P>
 * 
 * @version $Id$
 * @user slsy 2015-10-21 下午4:50:39
 * @author 赵晓林
 */
public class Password {

	/**
	 * 加密后的密码
	 */
	private String password;

	/**
	 * 加密使用的盐值
	 */
	private String salt;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "Password [password=*** salt=** ]";
	}
}
