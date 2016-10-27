package com.nfb.module.system.listener;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;

/**
 * 数据源帮助类
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class DatabaseHelper {
	
	private static ApplicationContext context;
	
	@SuppressWarnings("unused")
	private static DataSource dataSource;

	public static void init(ApplicationContext ac){
		context=ac;
	}
	
	@SuppressWarnings("unchecked")
	public static Object getBean(Class c){
		return context.getBean(c);
	}
	
	public static Object getBeanByName(String name){
		return context.getBean(name);
	}
	
	public static DataSource getDataSource(){
		return dataSource = (DataSource) context.getBean("dataSource");
	}
}
