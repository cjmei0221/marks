package com.marks.module.system.core.listener;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;

public class DatabaseHelper {
	
	private static ApplicationContext context;
	
	private static DataSource dataSource;

	public static void init(ApplicationContext ac){
		context=ac;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object getBean(Class c){
		return context.getBean(c);
	}

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

	public static DataSource getDataSource(){
		return dataSource = (DataSource) context.getBean("dataSource");
	}
}
