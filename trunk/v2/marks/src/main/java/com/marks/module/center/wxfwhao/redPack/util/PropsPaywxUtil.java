package com.marks.module.center.wxfwhao.redPack.util;

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
public class PropsPaywxUtil {
	private static Logger logger = Logger.getLogger(PropsPaywxUtil.class);

	private static Properties props = new Properties();
	static{
		try {
			props.load(new InputStreamReader(PropsPaywxUtil.class.getClassLoader().getResourceAsStream("props/center/payWx_common.properties"), "UTF-8"));  ;
		} catch (IOException e) {
			logger.error("IOException:",e);
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
