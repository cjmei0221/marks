package com.marks.module.system.core.listener;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.marks.common.util.EncrypUtil;

public class EncryptablePropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer{

	private static final String c_username="jdbc.user";
	private static final String c_jdbcUrl="jdbc.jdbcUrl";
	private static final String c_driverClass="jdbc.driverClass";
	private static final String c_password="jdbc.password";
	private static final String c_dialect="jdbc.dialect";
	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactoryToProcess,
			Properties props) throws BeansException {
		String username=props.getProperty(c_username);
		if(null !=username && username.length()>6){
			props.setProperty(c_username, EncrypUtil.decrypt(username));
		}
		String password=props.getProperty(c_password);
		if(null !=password && password.length()>6){
			props.setProperty(c_password, EncrypUtil.decrypt(password));
		}
	/*	String jdbcUrl=props.getProperty(c_jdbcUrl);
		if(null != jdbcUrl && jdbcUrl.length() > 6){
			props.setProperty(c_jdbcUrl, EncrypUtil.decrypt(jdbcUrl));
		}
		String driverClass=props.getProperty(c_driverClass);
		if(null !=driverClass && driverClass.length() > 6){
			props.setProperty(c_driverClass, EncrypUtil.decrypt(driverClass));
		}
		String dialect=props.getProperty(c_dialect);
		if(null != dialect && dialect.length() > 6){
			props.setProperty(c_dialect, EncrypUtil.decrypt(dialect));
		}*/
		super.processProperties(beanFactoryToProcess, props);
	}
	

}
