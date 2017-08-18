package com.marks.module.web.pay.unionpay.util;

import java.util.Map;

import com.marks.module.web.pay.unionpay.sdk.SDKConfig;

/**
 * 银联支付测试<br>
 * @author zqsheng<br>
 * @createTime 2015-04-13 <br>
 */
public class UnionPayTest {

	
	public UnionPayTest() {
		super();
	}
	
	
	/**
	 * 网关支付产品-交易状态查询
	 */
	public static void deal_query_test() {
		String orderId = "2015041620";
		String txnTime = "20150617144246";
		Map<String, String> result = UnionPay_Wap.deal_query(orderId, txnTime);
		System.out.println(result);
	}
	
	
	
	/**
	 * 手机wap支付产品
	 */
	public static void wap_consume() {
		String orderId = "2015041620";
		String txnAmt = "1";
		String html = UnionPay_Wap.wap_consume(orderId, txnAmt);
		System.out.println(html);
	}
	
	public static void main(String[] args) {
		SDKConfig.getConfig().loadPropertiesFromSrc();//加载acp_sdk.properties文件,初始化参数,证书等
		//deal_query_test();
		wap_consume();
	}
}



