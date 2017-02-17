package com.cjmei.module.weixin.wfhao.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PageConfigUtil {
	private static Properties props = new Properties();
	static{
		InputStream in = PageConfigUtil.class.getClassLoader().getResourceAsStream("pageConfig.properties");
		try {
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key){
		return props.getProperty(key);
	}
}