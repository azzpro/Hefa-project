package com.azz.util;

import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

/**
 * <P>TODO</P>
 * 
 * @version 1.0
 * @author 黄雄星（13077862552） 2014-1-8 下午2:46:31
 */
@Slf4j
public final class NetUtils {

	/**
	 * 
	 * <p>依据域名获取ip地址</p>
	 * 
	 * @param domain
	 * @return
	 * @author 黄雄星（13077862552） 2014-1-16 上午8:43:28
	 */
	public static Set<String> getDomain(String domain) {
		try {
			InetAddress[] addresses = InetAddress.getAllByName(domain);
			Set<String> domainSet = new HashSet<String>();
			for (InetAddress inetAddress : addresses) {
				String ip = inetAddress.getHostAddress();
				domainSet.add(ip);
			}
			return domainSet;
		} catch (Exception e) {
			log.error("获取域名异常", e);
		}
		return null;
	}

}
