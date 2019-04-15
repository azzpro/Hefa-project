package com.azz.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

public class IpUtils {
	static String UNKNOW = "unknown";
	static String LOCALHOST = "localhost";

	public static String getIp(HttpServletRequest request) {
		String ipAddress = request.getHeader("x-forwarded-for");
		if ((ipAddress == null) || (ipAddress.length() <= 0) || (UNKNOW.equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if ((ipAddress == null) || (ipAddress.length() <= 0) || (UNKNOW.equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if ((ipAddress == null) || (ipAddress.length() == 0) || (UNKNOW.equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getHeader("HTTP_CLIENT_IP");
		}
		if ((ipAddress == null) || (ipAddress.length() == 0) || (UNKNOW.equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if ((ipAddress == null) || (ipAddress.length() <= 0) || (UNKNOW.equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getRemoteAddr();
			if (("127.0.0.1".equalsIgnoreCase(ipAddress)) || (LOCALHOST.equalsIgnoreCase(ipAddress))) {
				try {
					InetAddress inet = InetAddress.getLocalHost();
					ipAddress = inet.getHostAddress();
				} catch (UnknownHostException e) {
					throw new IllegalStateException("依据网卡获取本机配置IP地址异常", e);
				}
			}
		}
		if ((ipAddress != null) && (ipAddress.length() > 15) && (ipAddress.indexOf(",") > 0)) {
			ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
		}
		return ipAddress;
	}

	/**
	 * <p>
	 * IP地址校验
	 * </p>
	 * 
	 * @param text
	 * @return
	 * @author 彭斌（15112300056） 2018年8月23日 上午10:58:59
	 */
	public static boolean ipCheck(String text) {
		if (text != null && !text.isEmpty()) {
			// 定义正则表达式
			String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
					+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
					+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
			// 判断ip地址是否与正则表达式匹配
			if (text.matches(regex)) {
				// 返回判断信息
				return true;
			} else {
				// 返回判断信息
				return false;
			}
		}
		return false;
	}
}
