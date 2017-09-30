package com.marks.module.pay.wxpay.pay;

public class WxConfig {
	private static WxConfig util = null;

	private WxConfig() {
	};

	public static WxConfig getInstance() {
		if (util == null) {
			util = new WxConfig();
		}
		return util;
	}
	
	public String unifiedorder=WxPayPropUtil.getProperty("unifiedorder");
	public static final String mch_id="mch_id";
	public static final String key="key";
	public static String notify_url=WxPayPropUtil.getProperty("notify_url");
	
}
