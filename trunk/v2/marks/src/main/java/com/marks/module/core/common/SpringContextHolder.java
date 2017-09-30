/**
 * 文件名：SpringContextHolder.java
 * 创建日期： 2017-06-27
 * Copyright (c) 2011-2017 广电运通
 * All rights reserved.
 */
package com.marks.module.core.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 实现ApplicationContextAware类，spring根据set方法自动注入上下文; 以静态变量保存Spring
 * ApplicationContext,可在任意代码中取出ApplicaitonContext.
 * 
 * @author lxue
 */
public class SpringContextHolder implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	/**
	 * 非web应用中加载公共基础信息模块
	 */
	public static void loadApplicationContext() {
		// applicationContext = new
		// ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}

	/**
	 * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.
	 * 
	 * @param applicationContext
	 *            applicationContext
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextHolder.applicationContext = applicationContext;
	}

	/**
	 * 取得存储在静态变量中的ApplicationContext.
	 * 
	 * @return applicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return applicationContext;
	}

	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 * 
	 * @param <T>
	 *            泛型参数对象
	 * @param name
	 *            bean的名字
	 * @return Bean
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}

	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 * 
	 * @param <T>
	 *            泛型参数对象
	 * @param clazz
	 *            类的名字
	 * @return bean
	 */
	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();
		return (T) applicationContext.getBean(clazz);
	}

	private static void checkApplicationContext() {
		if (applicationContext == null)
			throw new IllegalStateException(
					"applicaitonContext未注入,请在applicationContext.xml中定义SpringContextUtil");
	}
}
