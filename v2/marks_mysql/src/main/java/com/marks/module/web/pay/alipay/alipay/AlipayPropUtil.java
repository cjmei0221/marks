package com.marks.module.web.pay.alipay.alipay;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;


public class AlipayPropUtil {


	private static Properties props = new Properties();
	static{
		InputStream in = AlipayPropUtil.class.getClassLoader().getResourceAsStream("props/pay/alipay/alipay.properties");
		try {
			props.load(in);
		} catch (IOException e) {

		}
	}
	
	public static String getProperty(String key){
		return props.getProperty(key);
	}
	public	static Properties getValue(String fileSrc){
		try {
			Properties props = PropertiesLoaderUtils.loadAllProperties(fileSrc);
			return props;
		} catch (IOException e) {
		}
		return null;
	}
}
