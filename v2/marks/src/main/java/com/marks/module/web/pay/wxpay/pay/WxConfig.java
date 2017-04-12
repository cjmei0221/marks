package com.marks.module.web.pay.wxpay.pay;

public class WxConfig {

	public static String unifiedorder=WxPropUtil.getProperty("unifiedorder");
	public static final String mch_id="mch_id";
	public static final String key="key";
	public static String notify_url=WxPropUtil.getProperty("notify_url");
	public static String getValueByAccountid(String accountid,String key){
		return WxPropUtil.getProperty(key);
	}
}
