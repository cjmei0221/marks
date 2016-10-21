package com.grgbanking.common.util;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.sun.net.ssl.internal.www.protocol.https.HttpsURLConnectionOldImpl;

public class UrlUtils {
	private final static Logger logger = Logger.getLogger(UrlUtils.class);

	/**
	 * 忽视证书HostName
	 */
	private static HostnameVerifier ignoreHostnameVerifier = new HostnameVerifier() {
		public boolean verify(String s, SSLSession sslsession) {
			System.out.println("WARNING: Hostname is not matched for cert.");
			return true;
		}
	};
	/**
	 * Ignore Certification
	 */
	private static TrustManager ignoreCertificationTrustManger = new X509TrustManager() {

		private X509Certificate[] certificates;

		public void checkClientTrusted(X509Certificate certificates[],
				String authType) throws CertificateException {
			if (this.certificates == null) {
				this.certificates = certificates;
				System.out.println("init at checkClientTrusted");
			}
		}

		public void checkServerTrusted(X509Certificate[] ax509certificate,
				String s) throws CertificateException {
			if (this.certificates == null) {
				this.certificates = ax509certificate;
				System.out.println("init at checkServerTrusted");
			}

		}

		public X509Certificate[] getAcceptedIssuers() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	public JsonResult doPostJson(String urlString,JSONObject jsonObj,Map<String,String> header,String charSet) {
		JsonResult jsonObject = new JsonResult();
		jsonObject.setSuccess(true);
		jsonObject.setErrorCode(SysCode.SUCCESS);
		InputStream is = null;
		OutputStream out = null;
		HttpsURLConnectionOldImpl conn = null;
		try {
			// URL url = new URL(urlString);
			URL url = new URL(null, urlString,
					new com.sun.net.ssl.internal.www.protocol.https.Handler());
			/*
			 * use ignore host name verifier
			 */
			HttpsURLConnection
					.setDefaultHostnameVerifier(ignoreHostnameVerifier);
			conn = (HttpsURLConnectionOldImpl) url.openConnection();

			// Prepare SSL Context
			TrustManager[] tm = { ignoreCertificationTrustManger };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());

			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			conn.setSSLSocketFactory(ssf);

			out = conn.getOutputStream();
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(10000);
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			is = conn.getInputStream();
			DataOutputStream httpOut = new DataOutputStream(out);
			httpOut.write(jsonObj.toString().getBytes(charSet));
			httpOut.flush();
			is = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,
					charSet));
			String ret = null;
			String str_return = "";
			while ((ret = br.readLine()) != null) {
				str_return = str_return + ret;
			}
			jsonObject.setResult(str_return);
			logger.info("result=" + str_return);

		} catch (ConnectException e) {
			logger.error("ConnectException",e);
			jsonObject.setSuccess(false);
			jsonObject.setErrorCode("1001");
			jsonObject.setErrorMsg("连接微信服务器异常");
	    } catch (IOException e) {
	    	logger.error("IOException",e);
	    	jsonObject.setSuccess(false);
			jsonObject.setErrorCode("1002");
			jsonObject.setErrorMsg("读取微信服务器IO异常");
	    } catch (Exception e) {
	    	jsonObject.setSuccess(false);
			jsonObject.setErrorCode("1003");
			jsonObject.setErrorMsg("读取微信服务器异常");
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					logger.error("Exception:", e);
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (Exception e) {
					logger.error("Exception:", e);
				}
			}
			if (conn != null) {
				try {
					conn.disconnect();
				} catch (Exception e) {
					logger.error("Exception", e);
				}
			}
		}
		return jsonObject;
	}

}
