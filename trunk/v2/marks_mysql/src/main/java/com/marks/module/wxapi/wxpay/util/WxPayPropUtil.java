package com.marks.module.wxapi.wxpay.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * config工具类
 * 读取payWx.properties
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class WxPayPropUtil {
	private static Logger logger = Logger.getLogger(WxPayPropUtil.class);

	private static Properties props = new Properties();
	static{
		try {
			props.load(new InputStreamReader(WxPayPropUtil.class.getClassLoader().getResourceAsStream("props/pay/wx/wxpay.properties"), "UTF-8"));  ;
		} catch (IOException e) {
			logger.error("IOException:",e);
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
