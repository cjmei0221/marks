package com.marks.module.web.pay.wxpay.pay;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class WxPropUtil {


	private static Properties props = new Properties();
	static{
		InputStream in = WxPropUtil.class.getClassLoader().getResourceAsStream("props/web/pay/wxpay.properties");
		try {
			props.load(in);
		} catch (IOException e) {

		}
	}
	
	public static String getProperty(String key){
		return props.getProperty(key);
	}
}
