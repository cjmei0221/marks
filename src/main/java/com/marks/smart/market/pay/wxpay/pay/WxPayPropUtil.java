package com.marks.smart.market.pay.wxpay.pay;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;


public class WxPayPropUtil {


	private static Properties props = new Properties();
	static{
		InputStream in = WxPayPropUtil.class.getClassLoader().getResourceAsStream("props/pay/wx/wxpay.properties");
		try {
			props.load(in);
		} catch (IOException e) {

		}
	}
	
	public static String getProperty(String key){
		return props.getProperty(key);
	}
	private	static Properties getValue(String fileSrc){
		try {
			Properties props = PropertiesLoaderUtils.loadAllProperties(fileSrc);
			return props;
		} catch (IOException e) {
		}
		return null;
	}
	
	public static String getValueByAccountId(String accountid,String key){
		if(null !=accountid && accountid.length()>1){
			return getValue("props/pay/wx/acctNo/acct_" + accountid + ".properties").getProperty(key);
		}
		return getProperty(key);
	}
}
