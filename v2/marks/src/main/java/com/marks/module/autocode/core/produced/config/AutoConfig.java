package com.marks.module.autocode.core.produced.config;

public class AutoConfig {

	private static AutoConfig util=null;
	public AutoConfig(){}
	public static AutoConfig getInstance(){
		if(util==null){
			util=new AutoConfig();
		}
		return util;
	}
	//public static String rootPath=PropsUtil.getValue("template/autocode/autocode.properties").getProperty("root.src");
	
	public static String oracle_seq=AutoCodePropsUtil.getProperty("oracle.seq");
	
	public static String oracle_uuid=AutoCodePropsUtil.getProperty("oracle.uuid");
	public static String mysql_seq=AutoCodePropsUtil.getProperty("mysql.seq");
	public static String mysql_uuid=AutoCodePropsUtil.getProperty("mysql.uuid");
	
	public static String jdbc_url=AutoCodePropsUtil.getValue("jdbc.properties").getProperty("jdbc.jdbcUrl");
	public static String jdbc_user=AutoCodePropsUtil.getValue("jdbc.properties").getProperty("jdbc.user");
	public static String jdbc_password=AutoCodePropsUtil.getValue("jdbc.properties").getProperty("jdbc.password");
	public static String jdbc_dialect=AutoCodePropsUtil.getValue("jdbc.properties").getProperty("jdbc.dialect");
	/**
	 * 模板路径*/
	public static String template_path = AutoCodePropsUtil.getProperty("template_filepath");
	/**
	 * 模板后缀名
	 */
	public static String template_end="template";
	/**
	 * 模板文件路径
	 */
	public static String AUTOCODE_CONFIG_PACKAGE=AutoCodePropsUtil.getProperty("autocode_core_package");
	/**
	 * java代码路径
	 */
	public static String DEFAULT_JAVA_PACKAGE_URL=AutoCodePropsUtil.getProperty("default_java_package_url")+".";
	
	public static String FILE_JAVA_SRC=AutoCodePropsUtil.getProperty("FILE_JAVA_SRC");
	public static String FILE_XML_SRC=AutoCodePropsUtil.getProperty("FILE_mybatis_XML_SRC");
	public static String FILE_WEB_SRC=AutoCodePropsUtil.getProperty("FILE_WEB_SRC");
	public static String config_menu_src=AutoCodePropsUtil.getProperty("config_menu_src");

	public static String FILE_SPRING_SRC=AutoCodePropsUtil.getProperty("FILE_SPRING_SRC");
	public static String SPRING_NAME=AutoCodePropsUtil.getProperty("spring_base_path");
	public static String role_id=AutoCodePropsUtil.getProperty("role_id");
	
	public String getRootPath(){  
		String type=AutoCodePropsUtil.getProperty("bushu_type");
		if("1".equals(type)){
			return AutoCodePropsUtil.getProperty("root.src");
		}
		String returnPath="";
		String clsPath=getClass().getResource("").getPath();
		int num=clsPath.indexOf("/src/main");
		returnPath=clsPath.substring(0, num);
		return returnPath;
	}
	public static String FILE_Intro_SRC=AutoCodePropsUtil.getProperty("FILE_Intro_SRC");
}
