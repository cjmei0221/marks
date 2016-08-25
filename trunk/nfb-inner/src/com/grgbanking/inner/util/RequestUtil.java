package com.grgbanking.inner.util;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
	/**
	 * 
	 * TODO 获取请求Ip地址
	 *
	 * @author: wujie
	 * @creatTime: 2015年4月10日 上午8:53:13
	 * @param request
	 * @return String
	 */
	public static String getIpAddr(HttpServletRequest request){
		String ip = request.getHeader("X-Forwarded-For");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }
        if(ip!=null&&ip.length()>0&&ip.split(",").length>0){
        	for(String ips:ip.split(",")){
        		if(!"".equals(ips)&&!"unknown".equals(ips)){
        			ip = ips;
        			break;
        		}
        	}
        }
        return ip;  
	}
}
