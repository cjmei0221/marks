package com.cjmei.module.system.autocode.config;

import com.cjmei.common.util.properties.PPropsUtil;

public class AutoConfig {

	//public static String rootPath=PPropsUtil.getValue("template/autocode/autocode.properties").getProperty("root.src");
	public static String rootPath=System.getProperty("user.dir");
	public static String oracle_seq=PPropsUtil.getValue("template/autocode/autocode.properties").getProperty("oracle.seq");
	
	public static String oracle_uuid=PPropsUtil.getValue("template/autocode/autocode.properties").getProperty("oracle.uuid");
	public static String mysql_seq=PPropsUtil.getValue("template/autocode/autocode.properties").getProperty("mysql.seq");
	public static String mysql_uuid=PPropsUtil.getValue("template/autocode/autocode.properties").getProperty("mysql.uuid");
	
	public static String jdbc_url=PPropsUtil.getValue("jdbc.properties").getProperty("jdbc.jdbcUrl");
	public static String jdbc_user=PPropsUtil.getValue("jdbc.properties").getProperty("jdbc.user");
	public static String jdbc_password=PPropsUtil.getValue("jdbc.properties").getProperty("jdbc.password");
	/**
	 * 模板路径*/
	public static String template_path="template/autocode";
	/**
	 * 模板后缀名
	 */
	public static String template_end="template";
	/**
	 * 模板文件路径
	 */
	public static String AUTOCODE_CONFIG_PACKAGE="com.cjmei.module.system.autocode";
	/**
	 * java代码路径
	 */
	public static String DEFAULT_JAVA_PACKAGE_URL="com.cjmei.module.autocode.";
	
	public static String FILE_JAVA_SRC="/src/main/java/";
	public static String FILE_XML_SRC="/src/main/java/";
	public static String FILE_WEB_SRC="/src/main/webapp/page/autocode/";
	public static String FILE_Menu_SRC="page/autocode/";


}
