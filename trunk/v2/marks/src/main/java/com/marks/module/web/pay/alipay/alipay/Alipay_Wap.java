package com.marks.module.web.pay.alipay.alipay;

import java.util.Map;

import com.marks.module.web.pay.alipay.alipay.config.AlipayConfig;
import com.marks.module.web.pay.alipay.alipay.util.AlipaySubmit;

public class Alipay_Wap {

	public static String wap_consume(Map<String,String> paramMap,int type) throws Exception{
		String html="";
		paramMap.put("service", AlipayConfig.service);//接口名称
		paramMap.put("partner", AlipayConfig.partner);//合作者身份ID
		paramMap.put("_input_charset", AlipayConfig.input_charset);//参数编码字符集
		paramMap.put("notify_url", AlipayConfig.notify_url);//服务器异步通知页面路径
		paramMap.put("return_url", AlipayConfig.return_url);//页面跳转同步通知页面路径
		paramMap.put("seller_id", AlipayConfig.seller_id);//卖家支付宝用户号
		paramMap.put("payment_type", AlipayConfig.payment_type);//支付类型
		paramMap.put("show_url", AlipayConfig.show_url);//商品展示网址
		paramMap.put("rn_check", AlipayConfig.rn_check);//是否发起实名校验
		paramMap.put("goods_type", AlipayConfig.goods_type);//商品类型
		paramMap.put("app_pay", AlipayConfig.app_pay);//是否使用支付宝客户端支付
		if(type==1){
			html=AlipaySubmit.buildUrl(paramMap, "get", "支付");
		}else{
			html=AlipaySubmit.buildRequest(paramMap, "get", "支付");
		}
		return html;
	}
	
	
}
