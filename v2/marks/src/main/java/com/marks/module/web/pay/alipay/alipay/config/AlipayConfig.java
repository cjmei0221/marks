package com.marks.module.web.pay.alipay.alipay.config;

import com.marks.module.web.pay.alipay.alipay.AlipayPropUtil;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.4
 *修改日期：2016-03-08
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
	public static String partner = AlipayPropUtil.getProperty("partner");
	
	// 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
	public static String seller_id = AlipayPropUtil.getProperty("seller_id");

	//商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	public static String private_key = AlipayPropUtil.getProperty("private_key");
	
	// 支付宝的公钥,查看地址：https://b.alipay.com/order/pidAndKey.htm
	public static String alipay_public_key  = AlipayPropUtil.getProperty("alipay_public_key");
	

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = AlipayPropUtil.getProperty("notify_url");

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = AlipayPropUtil.getProperty("return_url");

	// 签名方式
	public static String sign_type = AlipayPropUtil.getProperty("sign_type");
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path = AlipayPropUtil.getProperty("log_path");
		
	// 字符编码格式 目前支持utf-8
	public static String input_charset = AlipayPropUtil.getProperty("_input_charset");
		
	// 支付类型 ，无需修改
	public static String payment_type = AlipayPropUtil.getProperty("payment_type");
		
	// 调用的接口名，无需修改
	public static String service = AlipayPropUtil.getProperty("pay_service");


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	/**
	 * 商品展示网址
	 */
	public static String show_url= AlipayPropUtil.getProperty("show_url");
	/**
	 * 是否发起实名校验
	 * T：发起实名校验； F：不发起实名校验
	 */
	public static String rn_check= AlipayPropUtil.getProperty("rn_check");
	/**
	 * 商品类型。

	1：实物类商品
	0：虚拟类商品
	不传默认为实物类商品。
	 */
	public static String goods_type= AlipayPropUtil.getProperty("goods_type");
	/**
	 * 	是否使用支付宝客户端支付
	 * app_pay=Y：尝试唤起支付宝客户端进行支付，若用户未安装支付宝，则继续使用wap收银台进行支付。商户若为APP，则需在APP的webview中增加alipays协议处理逻辑。
	 */
	public static String app_pay= AlipayPropUtil.getProperty("app_pay");
}

