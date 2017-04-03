package com.marks.module.inner.autocode.core.produced.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.marks.common.util.properties.PropsUtil;

/**
 * config工具类
 * 读取config.properties
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class AutoCodePropsUtil {
	private static Properties props = new Properties();
	static{
		InputStream in = PropsUtil.class.getClassLoader().getResourceAsStream("template/autocode/autocode.properties");
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
