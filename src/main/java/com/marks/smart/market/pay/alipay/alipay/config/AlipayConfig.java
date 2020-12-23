package com.marks.smart.market.pay.alipay.alipay.config;

import com.marks.smart.market.pay.alipay.alipay.AlipayPropUtil;

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
	
	private static AlipayConfig util = null;

	private AlipayConfig() {
	};

	public static AlipayConfig getInstance() {
		if (util == null) {
			util = new AlipayConfig();
		}
		return util;
	}
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
	private String partner = "partner";
	
	// 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
	private String seller_id = "seller_id";

	//商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	private String private_key = "private_key";
	
	// 支付宝的公钥,查看地址：https://b.alipay.com/order/pidAndKey.htm
	private String alipay_public_key  = "alipay_public_key";
	

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	private String notify_url = "notify_url";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	private String return_url = "return_url";

	// 签名方式
	private String sign_type = "sign_type";
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	private String log_path = "log_path";
		
	// 字符编码格式 目前支持utf-8
	private String input_charset = "_input_charset";
		
	// 支付类型 ，无需修改
	private String payment_type = "payment_type";
		
	// 调用的接口名，无需修改
	private String service = "pay_service";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	/**
	 * 商品展示网址
	 */
	private String show_url= "show_url";
	/**
	 * 是否发起实名校验
	 * T：发起实名校验； F：不发起实名校验
	 */
	private String rn_check= "rn_check";
	/**
	 * 商品类型。

	1：实物类商品
	0：虚拟类商品
	不传默认为实物类商品。
	 */
	private String goods_type= "goods_type";
	/**
	 * 	是否使用支付宝客户端支付
	 * app_pay=Y：尝试唤起支付宝客户端进行支付，若用户未安装支付宝，则继续使用wap收银台进行支付。商户若为APP，则需在APP的webview中增加alipays协议处理逻辑。
	 */
	private String app_pay= "app_pay";
	private String pay_fail_page_url= "pay_fail_page_url";
	private String pay_success_page_url= "pay_success_page_url";
	private String prefix_conf = "props/pay/alipay_";
	private String end_conf=".properties";
	
	public String getValue(String accountId,String key){
		if(accountId !=null && accountId.length()>3){
			return AlipayPropUtil.getValue(prefix_conf+accountId+end_conf).getProperty(key);
		}
		return AlipayPropUtil.getProperty(key);
	}

	public String getPartner(String accountId) {
		return getValue(accountId, partner);
	}

	

	public String getSeller_id(String accountId) {
		return getValue(accountId, seller_id);
	}

	public String getPrivate_key(String accountId) {
		return getValue(accountId, private_key);
	}

	public String getAlipay_public_key(String accountId) {
		return getValue(accountId, alipay_public_key);
	}

	
	public String getNotify_url(String accountId) {
		return getValue(accountId, notify_url);
	}

	

	public String getReturn_url(String accountId) {
		return getValue(accountId, return_url);
	}
	public String getSign_type(String accountId) {
		return getValue(accountId, sign_type);
	}

	

	public String getLog_path(String accountId) {
		return getValue(accountId, log_path);
	}

	public String getInput_charset(String accountId) {
		return getValue(accountId, input_charset);
	}
	public String getPayment_type(String accountId) {
		return getValue(accountId, payment_type);
	}

	public String getService(String accountId) {
		return getValue(accountId, service);
	}

	
	public String getShow_url(String accountId) {
		return getValue(accountId, show_url);
	}

	public String getRn_check(String accountId) {
		return getValue(accountId, rn_check);
	}
	public String getGoods_type(String accountId) {
		return getValue(accountId, goods_type);
	}
	public String getApp_pay(String accountId) {
		return getValue(accountId, app_pay);
	}

	public String getPay_fail_page_url(String accountId) {
		return getValue(accountId, pay_fail_page_url);
	}

	public String getPay_success_page_url(String accountId) {
		return getValue(accountId, pay_success_page_url);
	}
}

