package com.marks.smart.market.pay.unionpay.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.marks.smart.market.pay.unionpay.sdk.AcpService;
import com.marks.smart.market.pay.unionpay.sdk.HttpClient;
import com.marks.smart.market.pay.unionpay.sdk.SDKConstants;
import com.marks.smart.market.pay.unionpay.sdk.SDKUtil;
import com.marks.smart.market.pay.unionpay.sdk.SecureUtil;

/**
 * 银联支付工具类<br>
 * @author zqsheng<br>
 * @createTime 2015-06-29 <br>
 */
public class UnionPayUtil {

	private static Logger logger = Logger.getLogger(UnionPayUtil.class);
	
	public static String encoding = "UTF-8";//编码方式

	public UnionPayUtil() {
		super();
	}

	/**
	 * 构造HTTP POST交易表单的方法
	 * @param action 表单提交地址
	 * @param hiddens 以MAP形式存储的表单键值，而且已经经过签名
	 * @return 构造好的HTTP POST交易表单
	 */
	public static String createHtml(String action, Map<String, String> hiddens) {
		StringBuffer sf = new StringBuffer();
		sf.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/></head><body>");
		sf.append("<form id = \"pay_form\" action=\""+action+"\" method=\"post\">");
		if (null != hiddens && 0 != hiddens.size()) {
			Set<Entry<String, String>> set = hiddens.entrySet();
			Iterator<Entry<String, String>> it = set.iterator();
			while (it.hasNext()) {
				Entry<String, String> ey = it.next();
				String key = ey.getKey();
				String value = ey.getValue();
				sf.append("<input type=\"hidden\" name=\"" + key + "\" id=\""
						+ key + "\" value=\"" + value + "\"/>");
			}
		}
		sf.append("</form>");
		sf.append("</body>");
		sf.append("<script type=\"text/javascript\">");
		sf.append("window.parent.document.getElementById('pay_form').submit()");
		sf.append("</script>");
		sf.append("</html>");
		return sf.toString();
		
	}

	/**
	 * 对数据进行签名
	 * @param contentData
	 * @return　签名后的map对象
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> signData(Map<String, ?> contentData) {
		Entry<String, String> obj = null;
		Map<String, String> submitFromData = new HashMap<String, String>();
		for (Iterator<?> it = contentData.entrySet().iterator(); it.hasNext();) {
			obj = (Entry<String, String>) it.next();
			String value = obj.getValue();
			if (StringUtils.isNotBlank(value)) {
				submitFromData.put(obj.getKey(), value.trim());// 对value值进行去除前后空处理
			}
		}
		logger.info("验证签名-签名前报文:"+submitFromData);
		Boolean signResult  = SDKUtil.sign(submitFromData, encoding);//签名
		if(signResult) { 
			logger.info("签名成功-签名后报文:"+submitFromData);
			return submitFromData;
		} else { 
			logger.error("签名失败");
		}
		return null;
	}


	/**
	 * 数据提交到银联服务器
	 * @param contentData
	 * @return 返回报文 map
	 */
	public static Map<String, String> submitUrl(
			Map<String, String> submitFromData,String requestUrl) {
		String resultString = "";
		logger.info("请求银联服务器地址:"+requestUrl);
		logger.info("请求数据:"+submitFromData.toString());
		HttpClient hc = new HttpClient(requestUrl, 30000, 30000);//发送
		try {
			int status = hc.send(submitFromData, encoding);
			logger.info("返回的status:"+status);
			if (200 == status) { 
				resultString = hc.getResult();
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("返回报文："+ resultString);
		/**
		 * 验证签名
		 */
		Map<String, String> resData = new HashMap<String, String>();
		if (null != resultString && !"".equals(resultString)) {
			resData = SDKUtil.convertResultStringToMap(resultString);//将返回结果转换为map
			if (AcpService.validate(resData, encoding)) {
				logger.info("验证签名成功");
			} else {
				logger.info("验证签名失败");
			}
		}
		logger.info("返回报文转换为map并签名后："+ resData.toString());
		return resData;
	}

	/**
	 * 解析返回文件
	 */
	public static void deCodeFileContent(Map<String, String> resData) {
		// 解析返回文件
		String fileContent = resData.get(SDKConstants.param_fileContent);
		if (null != fileContent && !"".equals(fileContent)) {
			try {
				byte[] fileArray = SecureUtil.inflater(SecureUtil
						.base64Decode(fileContent.getBytes(encoding)));
				String root = "D:\\";
				String filePath = null;
				if (SDKUtil.isEmpty(resData.get("fileName"))) {
					filePath = root + File.separator + resData.get("merId")
							+ "_" + resData.get("batchNo") + "_"
							+ resData.get("txnTime") + ".txt";
				} else {
					filePath = root + File.separator + resData.get("fileName");
				}
				File file = new File(filePath);
				if (file.exists()) {
					file.delete();
				}
				file.createNewFile();
				FileOutputStream out = new FileOutputStream(file);
				out.write(fileArray, 0, fileArray.length);
				out.flush();
				out.close();

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 数据组装签名后进行提交
	 * @param contentData
	 * @return 返回报文 map
	 */
	public static Map<String, String> submitDate(Map<String, ?> contentData,String requestUrl) {
		Map<String, String> submitFromData = (Map<String, String>) signData(contentData);
		return submitUrl(submitFromData,requestUrl);
	}
	
	/**
	 * 持卡人信息域操作
	 * 
	 * @param encoding  编码方式
	 * @return base64后的持卡人信息域字段
	 */
	public static String getCustomer(String encoding) {
		StringBuffer sf = new StringBuffer("{");
		String certifTp = "01";//证件类型
		String certifId = "341126197709218366";//证件号码
		String customerNm = "全渠道";//姓名
		String phoneNo = "13552535506";//手机号
		String smsCode = "111111";//短信验证码
		String pin = "123456";//持卡人密码
		String cvn2 = "400";//cvn2
		String expired = "1212";//有效期
		sf.append("certifTp=" + certifTp + SDKConstants.AMPERSAND);
		sf.append("certifId=" + certifId + SDKConstants.AMPERSAND);
		sf.append("customerNm=" + customerNm + SDKConstants.AMPERSAND);
		sf.append("phoneNo=" + phoneNo + SDKConstants.AMPERSAND);
		sf.append("smsCode=" + smsCode + SDKConstants.AMPERSAND);
		sf.append("pin=" + AcpService.encryptPin("622188123456789", pin, encoding)
				+ SDKConstants.AMPERSAND);//密码加密
		//sf.append("pin="+pin + SDKConstants.AMPERSAND);//密码不加密
		// sf.append(SDKUtil.encrptCvn2(cvn2, encoding) +
		// SDKConstants.AMPERSAND);//cvn2加密
		sf.append("cvn2=" + cvn2 + SDKConstants.AMPERSAND);//cvn2不加密
		// sf.append(SDKUtil.encrptAvailable(expired, encoding));//有效期加密
		sf.append("expired=" + expired);//有效期不加密
		sf.append("}");
		String customerInfo = sf.toString();
		logger.info("持卡人信息域customerInfo:"+customerInfo);
		try {
			String  base64Str = new String(SecureUtil.base64Encode(sf.toString().getBytes(encoding)));
			return base64Str;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return customerInfo;
	}
	
	/**
	 * 代付产品-代付交易-持卡人信息域
	 * @return
	 */
	public static String getTakePayCustomer(String customerNm) { 
		StringBuffer sf = new StringBuffer("{");
		sf.append("customerNm=" + customerNm);//姓名
		sf.append("}");
		String  base64Str = null;
		try {
			base64Str = new String(SecureUtil.base64Encode(sf.toString().getBytes(encoding)));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return base64Str;
	}
	
	/**
	 * 持卡人信息域-短信验证码
	 * @return
	 */
	public static String getCustomerCode(String smsCode) {
		StringBuffer sf = new StringBuffer("{");
		sf.append("smsCode=" + smsCode);//短信验证码
		sf.append("}");
		String  base64Str = null;
		try {
			base64Str = new String(SecureUtil.base64Encode(sf.toString().getBytes(encoding)));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return base64Str;
	}

	/**
	 * 持卡人信息域-手机号
	 * @return
	 */
	public static String getCustomerPhoneNo(String phoneNo) {
		StringBuffer sf = new StringBuffer("{");
		sf.append("phoneNo=" + phoneNo);//手机号
		sf.append("}");
		String  base64Str = null;
		try {
			base64Str = new String(SecureUtil.base64Encode(sf.toString().getBytes(encoding)));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return base64Str;
	}
}