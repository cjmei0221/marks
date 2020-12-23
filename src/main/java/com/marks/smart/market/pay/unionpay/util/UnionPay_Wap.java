package com.marks.smart.market.pay.unionpay.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.marks.common.util.properties.PropsUtil;
import com.marks.smart.market.pay.unionpay.sdk.AcpService;
import com.marks.smart.market.pay.unionpay.sdk.SDKConfig;
import com.marks.smart.market.pay.unionpay.thread.pool.PayThreadPool;

/**
 * 银联支付接口封装<br>
 * 产品： 手机wap支付
 * @author zqsheng<br>
 * @createTime 2015-06-17 <br>
 */
public class UnionPay_Wap {
	private static String configPath="props/pay/union/acp_sdk.properties";
	private static Logger logger = Logger.getLogger(UnionPay_Wap.class);
	private static String version = "5.0.0";//版本号
	private static String encoding = "UTF-8";//编码方式
	private static String signMethod = "01";//签名方法 01 RSA
	private static String vpn_merId = PropsUtil.getValue(configPath).get("vpn_merId").toString();;//网关支付商户号
	private static String backUrl = PropsUtil.getValue(configPath).get("backUrl").toString();//交易后台通知地址
	private static String frontUrl = PropsUtil.getValue(configPath).get("frontUrl").toString();//交易前台通知地址
	
	public static String wan_consume_new(String orderId,String txnAmt){
		
		Map<String, String> requestData = new HashMap<String, String>();
		String txnTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		/***银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改***/
		requestData.put("version", version);   			  //版本号，全渠道默认值
		requestData.put("encoding", encoding); 			  //字符集编码，可以使用UTF-8,GBK两种方式
		requestData.put("signMethod", "01");            			  //签名方法，只支持 01：RSA方式证书加密
		requestData.put("txnType", "01");               			  //交易类型 ，01：消费
		requestData.put("txnSubType", "01");            			  //交易子类型， 01：自助消费
		requestData.put("bizType", "000201");           			  //业务类型，B2C网关支付，手机wap支付
		requestData.put("channelType", "08");           			  //渠道类型，这个字段区分B2C网关支付和手机wap支付；07：PC,平板  08：手机
		
		/***商户接入参数***/
		requestData.put("merId", vpn_merId);    	          			  //商户号码，请改成自己申请的正式商户号或者open上注册得来的777测试商户号
		requestData.put("accessType", "0");             			  //接入类型，0：直连商户 
		requestData.put("orderId",orderId);             //商户订单号，8-40位数字字母，不能含“-”或“_”，可以自行定制规则		
		requestData.put("txnTime", txnTime);        //订单发送时间，取系统时间，格式为YYYYMMDDhhmmss，必须取当前时间，否则会报txnTime无效
		requestData.put("currencyCode", "156");         			  //交易币种（境内商户一般是156 人民币）		
		requestData.put("txnAmt", txnAmt);             			      //交易金额，单位分，不要带小数点
		//requestData.put("reqReserved", "透传字段");        		      //请求方保留域，如需使用请启用即可；透传字段（可以实现商户自定义参数的追踪）本交易的后台通知,对本交易的交易状态查询交易、对账文件中均会原样返回，商户可以按需上传，长度为1-1024个字节		
		
		//前台通知地址 （需设置为外网能访问 http https均可），支付成功后的页面 点击“返回商户”按钮的时候将异步通知报文post到该地址
		//如果想要实现过几秒中自动跳转回商户页面权限，需联系银联业务申请开通自动返回商户权限
		//异步通知参数详见open.unionpay.com帮助中心 下载  产品接口规范  网关支付产品接口规范 消费交易 商户通知
		requestData.put("frontUrl", frontUrl);
		
		//后台通知地址（需设置为【外网】能访问 http https均可），支付成功后银联会自动将异步通知报文post到商户上送的该地址，失败的交易银联不会发送后台通知
		//后台通知参数详见open.unionpay.com帮助中心 下载  产品接口规范  网关支付产品接口规范 消费交易 商户通知
		//注意:1.需设置为外网能访问，否则收不到通知    2.http https均可  3.收单后台通知后需要10秒内返回http200或302状态码 
		//    4.如果银联通知服务器发送通知后10秒内未收到返回状态码或者应答码非http200，那么银联会间隔一段时间再次发送。总共发送5次，每次的间隔时间为0,1,2,4分钟。
		//    5.后台通知地址如果上送了带有？的参数，例如：http://abc/web?a=b&c=d 在后台通知处理程序验证签名之前需要编写逻辑将这些字段去掉再验签，否则将会验签失败
		requestData.put("backUrl", backUrl);
		
		//////////////////////////////////////////////////
		//
		//       报文中特殊用法请查看 PCwap网关跳转支付特殊用法.txt
		//
		//////////////////////////////////////////////////
		
		/**请求参数设置完毕，以下对请求参数进行签名并生成html表单，将表单写入浏览器跳转打开银联页面**/
		Map<String, String> submitFromData = AcpService.sign(requestData,encoding);  //报文中certId,signature的值是在signData方法中获取并自动赋值的，只要证书配置正确即可。
		
		String requestFrontUrl = SDKConfig.getConfig().getFrontRequestUrl();  //获取请求银联的前台地址：对应属性文件acp_sdk.properties文件中的acpsdk.frontTransUrl
		String html = AcpService.createAutoFormHtml(requestFrontUrl, submitFromData,encoding);   //生成自动跳转的Html表单
		return html;
	}
	/**
	 * 产品：手机支付 ——手机网页wap支付产品<br>
	 * 功能：消费交易<br>
	 * 类型：前台交易类<br>
	 * 
	 * 生成跳转到银联支付页面的表单<br>
	 * 日期： 2015-06-17<br>
	 * 作者： zqsheng<br>
	 * 
	 * @param orderId 订单号
	 * @param txnAmt 交易金额，单位分
	 * @return
	 */
	public static String wap_consume(String orderId,String txnAmt) {
		logger.info("-------生成手机wap支付页面的表单[begin]------");
		String txnTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		Map<String,String> data = new HashMap<String,String>();//组装请求报文
		data.put("version", version);//版本号
		data.put("encoding", encoding);//字符集编码 默认"UTF-8"
		data.put("signMethod", signMethod);//签名方法 01 RSA
		data.put("txnType", "01");//交易类型 01-消费
		data.put("txnSubType", "01");//交易子类型  01-自助消费;02-订购;03-分期付款
		data.put("bizType", "000201");//产品类型  000201-B2C网关支付
		data.put("channelType", "08");//渠道类型 08-手机
		data.put("frontUrl", frontUrl);//前台通知地址 ，控件接入方式无作用
		data.put("backUrl", backUrl);//商户后台接收地址,必送
		data.put("accessType", "0");//接入类型: 0-商户 ， 1： 收单， 2：平台商户
		data.put("merId", vpn_merId);//商户号码
		data.put("orderId", orderId);//订单号 商户根据自己规则定义生成，每订单日期内不重复
		data.put("txnTime", txnTime);//订单发送时间 格式： YYYYMMDDhhmmss 商户发送交易时间，根据自己系统或平台生成
		data.put("txnAmt", txnAmt);//交易金额，单位分
		data.put("currencyCode", "156");//交易币种,默认156
		data.put("reqReserved", "wap");//请求方保留域，交易应答时会原样返回
		String requestFrontUrl = SDKConfig.getConfig().getFrontRequestUrl();//交易请求url 从配置文件读取
		data = UnionPayUtil.signData(data);//签名
		if(data == null) {
			return null;
		}
		PayThreadPool.saveUnionPayLog(data,"0");//保存交易报文信息
		logger.info("-------生成手机wap支付页面的表单[end]------");
		return UnionPayUtil.createHtml(requestFrontUrl,data);//创建表单
	}
	
	/**
	 * 产品：跳转网关支付产品<br>
	 * 功能：交易状态查询交易<br>
	 * 类型：查询交易类<br>
	 * 
	 * 日期： 2015-04-13<br>
	 * 作者： zqsheng<br>
	 * 
	 * @param orderId 商户订单号，被查询的交易的订单号
	 * @param txnTime 订单发送时间，被查询的交易的订单发送时间
	 * @return
	 */
	public static Map<String, String> deal_query(String orderId,String txnTime) {
		logger.info("-------调银联交易状态查询接口,查询原始交易状态[begin]");
		Map<String,String> data = new HashMap<String,String>();//组装请求报文
		data.put("version", version);//版本号
		data.put("encoding", encoding);//字符集编码 默认"UTF-8"
		data.put("signMethod", signMethod);//签名方法 01 RSA
		data.put("txnType", "00");//交易类型   00-查询交易
		data.put("txnSubType", "00");//交易子类型  01-自助消费;02-订购;03-分期付款
		data.put("bizType", "000000");//产品类型  000000-默认
		data.put("accessType", "0");//接入类型: 0-商户 ， 1： 收单， 2：平台商户
		data.put("merId", vpn_merId);//商户号码
		data.put("orderId", orderId);//商户订单号，请修改为被查询的交易的订单号
		data.put("txnTime", txnTime);//订单发送时间，请修改为被查询的交易的订单发送时间
		//data.put("queryId", "");//待查询交易的流水号,可传可不传
		data = UnionPayUtil.signData(data);//签名
		Map<String, String> resmap = null;
		if(data != null) {
			String requestQueryUrl = SDKConfig.getConfig().getSingleQueryUrl();//交易请求url 从配置文件读取
			resmap = UnionPayUtil.submitUrl(data, requestQueryUrl);
		}
		logger.info("-------调银联交易状态查询接口,查询原始交易状态[end]");
		return resmap;
	}
}



