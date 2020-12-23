package com.marks.smart.market.pay.alipay.alipay;

import java.util.Map;

import com.marks.smart.market.pay.alipay.alipay.config.AlipayConfig;
import com.marks.smart.market.pay.alipay.alipay.util.AlipaySubmit;

public class Alipay_Wap {

	public static String wap_consume(Map<String,String> paramMap,int type,String accountId) throws Exception{
		String html="";
		paramMap.put("service", AlipayConfig.getInstance().getService(accountId));//接口名称
		paramMap.put("partner", AlipayConfig.getInstance().getPartner(accountId));//合作者身份ID
		paramMap.put("_input_charset", AlipayConfig.getInstance().getInput_charset(accountId));//参数编码字符集
		paramMap.put("notify_url", AlipayConfig.getInstance().getNotify_url(accountId));//服务器异步通知页面路径
		paramMap.put("return_url", AlipayConfig.getInstance().getReturn_url(accountId));//页面跳转同步通知页面路径
		paramMap.put("seller_id", AlipayConfig.getInstance().getSeller_id(accountId));//卖家支付宝用户号
		paramMap.put("payment_type", AlipayConfig.getInstance().getPayment_type(accountId));//支付类型
		paramMap.put("show_url", AlipayConfig.getInstance().getShow_url(accountId));//商品展示网址
		paramMap.put("rn_check", AlipayConfig.getInstance().getRn_check(accountId));//是否发起实名校验
		paramMap.put("goods_type", AlipayConfig.getInstance().getGoods_type(accountId));//商品类型
		paramMap.put("app_pay", AlipayConfig.getInstance().getApp_pay(accountId));//是否使用支付宝客户端支付
		if(type==1){
			html=AlipaySubmit.buildUrl(paramMap, "get", "支付",accountId);
		}else{
			html=AlipaySubmit.buildRequest(paramMap, "get", "支付",accountId);
		}
		return html;
	}
	
	
}
