package com.grgbanking.module.wxqyhao.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class WxqyUtil {
	private static final Logger log = Logger.getLogger(WxqyUtil.class);

	private static Properties props = new Properties();
	static{
		InputStream in = WxqyUtil.class.getClassLoader().getResourceAsStream("wxQyConfig.properties");
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
