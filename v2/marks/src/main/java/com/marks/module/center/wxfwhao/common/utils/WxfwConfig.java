package com.marks.module.center.wxfwhao.common.utils;

public class WxfwConfig {

	public static String weixin_server_prefix = WxfwUtil.getProperty("weixin_server_prefix");
	public static String materialList = WxfwUtil.getProperty("materialList");
	public static String materialCount = WxfwUtil.getProperty("materialCount");
	public static String access_token_db_flag = WxfwUtil.getProperty("access_token_db_flag");
	
	public static String downloadImagePath = WxfwUtil.getProperty("downloadImagePath");
	public static String view_image_url = WxfwUtil.getProperty("view_image_url");
	
	public static String downloadMediaPath = WxfwUtil.getProperty("downloadMediaPath");
	public static String view_media_url = WxfwUtil.getProperty("view_media_url");

	public static final String access_token_db_flag_Y = "Y";
	public static final String access_token_db_flag_N = "N";
}
