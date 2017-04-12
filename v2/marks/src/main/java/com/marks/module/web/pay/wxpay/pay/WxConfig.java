package com.marks.module.web.pay.wxpay.pay;

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
	
	public String unifiedorder=WxPropUtil.getProperty("unifiedorder");
	public static final String mch_id="mch_id";
	public static final String key="key";
	public static String notify_url=WxPropUtil.getProperty("notify_url");
	public String getValueByAccountid(String accountid,String key){
		if(null !=accountid && accountid.length()>1){
			return WxPropUtil.getValue("props/web/pay/wxpay_ctest.properties").getProperty(key);
		}
		return WxPropUtil.getProperty(key);
	}
}
