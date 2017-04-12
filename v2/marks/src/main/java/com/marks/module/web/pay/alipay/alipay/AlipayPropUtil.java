package com.marks.module.web.pay.alipay.alipay;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class AlipayPropUtil {


	private static Properties props = new Properties();
	static{
		InputStream in = AlipayPropUtil.class.getClassLoader().getResourceAsStream("props/web/pay/alipay.properties");
		try {
			props.load(in);
		} catch (IOException e) {

		}
	}
	
	public static String getProperty(String key){
		return props.getProperty(key);
	}
}
