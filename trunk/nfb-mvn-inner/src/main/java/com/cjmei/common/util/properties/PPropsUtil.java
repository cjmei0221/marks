package com.cjmei.common.util.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * config工具类
 * 读取config.properties
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class PPropsUtil {
	private static Properties props = new Properties();
	static{
		InputStream in = PPropsUtil.class.getClassLoader().getResourceAsStream("config.properties");
		try {
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
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
