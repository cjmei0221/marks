package com.marks.module.wx.api.wxInterface.pay.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import org.apache.log4j.Logger;

import com.sun.net.ssl.internal.www.protocol.https.HttpsURLConnectionOldImpl;

//用于现金红包支付验证证书
public class HttpService {
	private final static Logger logger = Logger.getLogger(HttpService.class);

	public static String doSendMoney(String requestUrl, String data, String accountid) throws Exception {
		// 证书文件(微信商户平台-账户设置-API安全-API证书-下载证书)
		String keyStorePath = WxPayPropUtil.getProperty("keyStorePath");
		// 证书密码（默认为商户ID）
		String password = WxPayPropUtil.getProperty("password");
		if (null == accountid || "".equals(accountid)) {
			logger.info("accountid is null ");
			return "";
		}

		keyStorePath = WxPayPropUtil.getValueByAccountId(accountid,"keyStorePath");
		password =WxPayPropUtil.getValueByAccountId(accountid,"password");

		logger.info("keyStorePath" + keyStorePath + "-" + password);
		// 实例化密钥库
		KeyStore ks = KeyStore.getInstance("PKCS12");
		// 获得密钥库文件流
		FileInputStream fis = new FileInputStream(keyStorePath);
		// 加载密钥库
		ks.load(fis, password.toCharArray());
		// 关闭密钥库文件流
		fis.close();
		// 实例化密钥库
		KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
		// 初始化密钥工厂
		kmf.init(ks, password.toCharArray());

		// 创建SSLContext
		SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
		sslContext.init(kmf.getKeyManagers(), null, new SecureRandom());
		// 获取SSLSocketFactory对象
		SSLSocketFactory ssf = sslContext.getSocketFactory();

		// URL url = new URL(requestUrl);
		URL url = new URL(null, requestUrl, new com.sun.net.ssl.internal.www.protocol.https.Handler());
		// HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		HttpsURLConnectionOldImpl conn = (HttpsURLConnectionOldImpl) url.openConnection();
		// conn.setRequestMethod(method)
		conn.setRequestMethod("POST");
		// 设置当前实例使用的SSLSocketFactory
		conn.setSSLSocketFactory(ssf);
		conn.setDoOutput(true);
		// conn.setDoInput(true);
		// conn.connect();
		DataOutputStream out = new DataOutputStream(conn.getOutputStream());
		if (data != null)
			out.write(data.getBytes("utf-8"));
		// out.writeBytes(data);
		// out.writeBytes(new String(data.getBytes(), "gb2312"));
		String result = null;
		// 获取输入流
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
		int code = conn.getResponseCode();
		if (HttpsURLConnection.HTTP_OK == code) {
			// String temp = in.readLine().getBytes("utf-8").toString();
			String temp = new String(in.readLine().getBytes(), "utf-8");
			/* 连接成一个字符串 */
			while (temp != null) {
				if (result != null)
					result += temp;
				else
					result = temp;
				temp = in.readLine();
			}
		}
		out.flush();
		out.close();
		logger.info(result);
		return result;

	}
}
