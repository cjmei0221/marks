package com.marks.common.util.http;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.marks.common.domain.JsonResult;
import com.marks.common.util.center.SysCode;
import com.sun.net.ssl.SSLContext;
import com.sun.net.ssl.TrustManager;
import com.sun.net.ssl.internal.www.protocol.https.Handler;
import com.sun.net.ssl.internal.www.protocol.https.HttpsURLConnectionOldImpl;

/**
 * Created with IntelliJ IDEA. User: sunshine Date: 13-7-24 Time: 上午11:11 To
 * change this template use File | Settings | File Templates.
 */
public class HttpUtils {
	private static Logger logger = Logger.getLogger(HttpUtils.class);

	private static HttpUtils httpProtocolHandler = new HttpUtils();

	private class MyX509TrustManager implements X509TrustManager, TrustManager {

		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[] {};
		}
	}

	/**
	 * 工厂方法
	 * 
	 * @return
	 */

	public static HttpUtils getInstance() {
		return httpProtocolHandler;
	}

	/**
	 * 私有的构造方法
	 */
	private HttpUtils() {

	}

	public JsonResult doGet(String url, Map<String, String> params, Map<String, String> header, String charSet)
			throws IOException {
		JsonResult jsonObject = null;
		String requestUrl = "";
		if (params != null && params.size() > 0) {
			StringBuffer paramUrl = new StringBuffer("");
			Set<String> keySet = params.keySet();
			Iterator<String> it = keySet.iterator();
			while (it.hasNext()) {
				String key = it.next();
				String value = params.get(key);
				paramUrl.append("&" + key + "=" + value);
			}
			if (url.indexOf("?") == -1) {
				requestUrl = url + "?" + paramUrl;
			} else {
				requestUrl = url + paramUrl;
			}
			logger.info(requestUrl);
		} else {
			requestUrl = url;
		}
		jsonObject = requestHttp(requestUrl, "GET", null);
		return jsonObject;
	}

	public JsonResult doPost(String url, Map<String, String> params, Map<String, String> header, String charSet)
			throws IOException {
		JsonResult jsonObject = null;
		String requestUrl = "";
		if (params != null && params.size() > 0) {
			StringBuffer paramUrl = new StringBuffer("");
			Set<String> keySet = params.keySet();
			Iterator<String> it = keySet.iterator();
			while (it.hasNext()) {
				String key = it.next();
				String value = params.get(key);
				paramUrl.append("&" + key + "=" + value);
			}
			if (url.indexOf("?") == -1) {
				requestUrl = url + "?" + paramUrl;
			} else {
				requestUrl = url + paramUrl;
			}
			logger.info(requestUrl);
		} else {
			requestUrl = url;
		}
		jsonObject = requestHttp(requestUrl, "GET", null);
		return jsonObject;
	}

	public JsonResult doPostJson(String url, JSONObject jsonObj, Map<String, String> header, String charSet)
			throws IOException {
		JsonResult jsonObject = null;
		String requestUrl = url;
		String data=null;
		if(jsonObj !=null){
			data=jsonObj.toString();
		}
		jsonObject = requestHttp(requestUrl, "POST", data);
		return jsonObject;
	}

	private JsonResult requestHttp(String requestUrl, String requestMethod, String outStr) {
		JsonResult jsonObject = new JsonResult();
		BufferedInputStream ins = null;
		HttpsURLConnectionOldImpl httpUrlConn = null;
		OutputStream outputStream =null;
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(null, requestUrl, new Handler());
			httpUrlConn =  (HttpsURLConnectionOldImpl) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);
			httpUrlConn.setConnectTimeout(10000);
			httpUrlConn.setReadTimeout(10000);
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			// if ("GET".equalsIgnoreCase(requestMethod))
			httpUrlConn.connect();
			String charSet="UTF-8";
			// 当有数据需要提交时
			if (null != outStr && outStr.length()>0) {
				outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outStr.getBytes(charSet));
				outputStream.close();
			}
			// 将返回的输入流转换成字符串    
			String searchResult = "";
			ins = new BufferedInputStream(httpUrlConn.getInputStream());
			byte resultBytes[] = readUrlStream(ins);
			if (resultBytes != null && resultBytes.length > 0) {
				searchResult = new String(resultBytes, charSet);
			}
			
			jsonObject.setResult(searchResult);
			logger.info("腾讯返回报文>>" + jsonObject.getResult());
		} catch (KeyManagementException e) {
			jsonObject.setErrorCode("2001");
			jsonObject.setSuccess(false);
			jsonObject.setErrorMsg("KeyManagementException");
		} catch (NoSuchAlgorithmException e) {
			jsonObject.setErrorCode("2002");
			jsonObject.setSuccess(false);
			jsonObject.setErrorMsg("KeyManagementException");
		} catch (NoSuchProviderException e) {
			jsonObject.setErrorCode("2003");
			jsonObject.setSuccess(false);
			jsonObject.setErrorMsg("KeyManagementException");
		} catch (MalformedURLException e) {
			jsonObject.setErrorCode("2004");
			jsonObject.setSuccess(false);
			jsonObject.setErrorMsg("KeyManagementException");
		} catch (ProtocolException e) {
			jsonObject.setErrorCode("2005");
			jsonObject.setSuccess(false);
			jsonObject.setErrorMsg("KeyManagementException");
		} catch (UnsupportedEncodingException e) {
			jsonObject.setErrorCode("2006");
			jsonObject.setSuccess(false);
			jsonObject.setErrorMsg("KeyManagementException");
		} catch (IOException e) {
			jsonObject.setErrorCode("2007");
			jsonObject.setSuccess(false);
			jsonObject.setErrorMsg("KeyManagementException");
		}finally{
			
			try {
				if(outputStream !=null){
					outputStream.close();
				}
			} catch (IOException e) {
				
			}
			try {
				if(ins !=null){
					ins.close();
				}
			} catch (IOException e) {
				
			}
			try {
				if(httpUrlConn !=null){
					httpUrlConn.disconnect();
				}
			} catch (Exception e) {
				
			}
		}

		
		return jsonObject;

	}

	private static byte[] readUrlStream(BufferedInputStream bufferedInputStream) throws IOException {
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		int byteNum = 1024;
		byte[] buff = new byte[byteNum]; // buff用于存放循环读取的临时数据
		int rc = 0;
		while ((rc = bufferedInputStream.read(buff, 0, byteNum)) > 0) {
			swapStream.write(buff, 0, rc);
		}

		return swapStream.toByteArray();
	}

	public JsonResult download(String url, String fileName) {
		JsonResult jsonObject = new JsonResult();
		GetMethod method = null;
		FileOutputStream output = null;
		File saveFile = null;
		try {

			method = new GetMethod(url);
			HttpClient httpClient = new HttpClient();
			// 链接超时
			httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
			httpClient.getHttpConnectionManager().getParams().setSoTimeout(15000);
			// 设置等待ConnectionManager释放connection的时间
			httpClient.getParams().setConnectionManagerTimeout(3000);
			/* method.releaseConnection(); */
			// 设置Http Header中的User-Agent属性
			method.addRequestHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");

			int statusCode = httpClient.executeMethod(method);
			jsonObject.setErrorCode(statusCode + "");
			if (statusCode != HttpStatus.SC_OK) {
				jsonObject.setSuccess(Boolean.FALSE);
				jsonObject.setErrorMsg("服务器繁忙，请稍等···");
			} else {
				jsonObject.setSuccess(Boolean.TRUE);
				jsonObject.setErrorCode(SysCode.SUCCESS);
				BufferedInputStream ins = new BufferedInputStream(method.getResponseBodyAsStream());
				saveFile = new File(fileName);
				output = new FileOutputStream(saveFile, true);
				/*
				 * int size = 0; byte[] buf = new byte[1024 * 1024 * 10]; while
				 * ((size = ins.read(buf)) != -1) { output.write(buf, 0, size);
				 * output.flush(); }
				 */
				byte resultBytes[] = readUrlStream(ins);
				output.write(resultBytes);
				output.flush();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			jsonObject.setSuccess(Boolean.FALSE);
			jsonObject.setErrorCode("4000");
			jsonObject.setErrorMsg("系统异常·");
		} finally {
			try {
				if (output != null) {
					output.close();
				}
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
			method.releaseConnection();
		}

		return jsonObject;

	}

}
