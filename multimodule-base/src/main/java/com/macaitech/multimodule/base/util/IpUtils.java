/**
 * 
 */
package com.macaitech.multimodule.base.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yuhui.tang  
 * 2018年9月25日 下午3:04:04
 *  
 */
public class IpUtils {

	/**
	 * 活动客户端ip
	 * @param request
	 * @return
	 */
	public static String getClientIp(HttpServletRequest request) {
		String realIP = request.getHeader("x-forwarded-for"); 
		String ip = request.getRemoteAddr(); 
		Enumeration<String> enums = request.getHeaderNames(); 
		while(enums.hasMoreElements()) 
		{ 
			String name = (String)enums.nextElement(); 
			String value = request.getHeader(name); 
			System.err.println(name+" "+value);
		} 

		if(!StringUtils.isEmpty(realIP)) {
			return realIP;
		}
		return ip;
	}
}
