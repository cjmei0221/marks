package com.cjmei.module.weixin.wfhao.config;

import com.cjmei.common.util.properties.PropsUtil;

public class WxFwConfig {

	public static String weixin_connect_oauth2_authorize_info=PropsUtil.getValue("wxConfig.properties").getProperty("weixin_connect_oauth2_authorize_info");

	public static String weixin_connect_oauth2_authorize_base=PropsUtil.getValue("wxConfig.properties").getProperty("weixin_connect_oauth2_authorize_base");

	public static String weixin_connect_oauth2_access_token=PropsUtil.getValue("wxConfig.properties").getProperty("weixin_connect_oauth2_access_token");

	public static String weixin_qrcode_show_url=PropsUtil.getValue("wxConfig.properties").getProperty("weixin_qrcode_show_url");

	public static String weixin_connect_oauth2_userinfo=PropsUtil.getValue("wxConfig.properties").getProperty("weixin_connect_oauth2_userinfo");


}
