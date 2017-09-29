package com.marks.module.wx.api.mp.base.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class WxfwUtil {
	private static final Logger log = Logger.getLogger(WxfwUtil.class);

	private static Properties props = new Properties();
	static{
		InputStream in = WxfwUtil.class.getClassLoader().getResourceAsStream("props/wxapi/wxFwConfig.properties");
		try {
			props.load(in);
		} catch (IOException e) {
			log.error("IOException:",e);
		}
	}
	
	public static String getProperty(String key){
		return props.getProperty(key);
	}
}
