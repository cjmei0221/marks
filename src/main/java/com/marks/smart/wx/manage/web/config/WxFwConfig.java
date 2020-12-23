package com.marks.smart.wx.manage.web.config;

import com.marks.common.util.properties.PropsUtil;

public class WxFwConfig {
	private static String filePath="props/web/wxConfig.properties";

	public static String weixin_connect_oauth2_authorize_info=PropsUtil.getValue(filePath).getProperty("weixin_connect_oauth2_authorize_info");

	public static String weixin_connect_oauth2_authorize_base=PropsUtil.getValue(filePath).getProperty("weixin_connect_oauth2_authorize_base");

	public static String weixin_connect_oauth2_access_token=PropsUtil.getValue(filePath).getProperty("weixin_connect_oauth2_access_token");

	public static String weixin_qrcode_show_url=PropsUtil.getValue(filePath).getProperty("weixin_qrcode_show_url");

	public static String weixin_connect_oauth2_userinfo=PropsUtil.getValue(filePath).getProperty("weixin_connect_oauth2_userinfo");


}
