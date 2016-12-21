package com.cjmei.module.weixin.wfhao.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.cjmei.module.system.core.data.StaticData;
import com.cjmei.module.weixin.mp.DataDicUtil;
import com.cjmei.module.weixin.mp.aes.AesException;
import com.cjmei.module.weixin.mp.aes.WXBizMsgCrypt;
import com.cjmei.module.weixin.wfhao.message.MessageConverter;
import com.cjmei.module.weixin.wfhao.message.request.RequestMessage;
import com.cjmei.module.weixin.wfhao.message.response.ResponseMessage;
import com.cjmei.module.weixin.wfhao.pojo.WxAccount;
import com.cjmei.module.weixin.wfhao.service.RequestDispatchService;
import com.cjmei.module.weixin.wfhao.util.WxUtil;

/**
 * 处理微信服务号请求与响应的类 核心类
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
@Controller
public class WeixinChatController {

	private static Logger logger = Logger.getLogger(WeixinChatController.class);

	@Autowired
	private RequestDispatchService requestDispatchService;	

	/**
	 * 微信调用doGet接口的校验
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/WECHAT/HANDLER", method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("----------------------------doGet:");
		request.setAttribute("result_note", "check_service");
		String accountid = request.getParameter("accountid");
		if (accountid == null || "".equals(accountid)) {
			logger.info("----------accountid is null,check url has accountid,for return");
			return;
		}
		
		WxAccount account =  StaticData.getWxAccount(accountid);
		if(account==null){
			logger.info("----------check wxb_wechat_account table has data accountid="+accountid+",for return");
			return;
		}		
		
		String token = account.getToken();
		if (token != null) {
			String signature = request.getParameter("signature");
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
			String echostr = request.getParameter("echostr");
			logger.info("--------------accountid="+accountid+",signature=" + signature + ",timestamp=" + timestamp
					+ ",nonce=" + nonce + ",echostr=" + echostr);

			if (echostr != null) {
				try {
					if (this.checkSignature(request, token) && DataDicUtil.doField(echostr)) {
						response.getWriter().print(echostr+"");
					}
				} catch (NoSuchAlgorithmException e) {
					logger.info("NoSuchAlgorithmException:",e);
				}
			}
		}
	}

	/**
	 * 微信调用doPost接口
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/WECHAT/HANDLER", method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		logger.info("----------------------------doPost:");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		String accountId = request.getParameter("accountid");
		if (accountId == null || "".equals(accountId)) {
			logger.info("----------accountid is null,check url has accountid,for return");
			return;
		}
		
		WxAccount account =  StaticData.getWxAccount(accountId);
		if(account==null){
			logger.info("----------check wxb_wechat_account table has data accountid="+accountId+",for return");
			return;
		}else{
			logger.info("----------check wxb_wechat_account table has data accountid="+accountId);
			
		}
		
//		if(!checkSha(request,account.getToken())){
//			return;
//		}
		
		String xml = "";
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(
					request.getInputStream(), "UTF-8"));
			String line = in.readLine();
			while (line != null) {
				xml += line;
				line = in.readLine();
			}
		} catch (Exception e) {
			logger.info(e);
			return;
		}finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					logger.info("IOException",e);
				}
			}
		}
		
		//安全模式(解密)
		if("aes".equals(request.getParameter("encrypt_type"))){
			logger.info("--------------encrypt_type:" + request.getParameter("encrypt_type"));
			logger.info("--------------aes data:" + xml);
			xml = decryptXml(xml, request,account);
		}
		if (xml == null) {
			return;
		}

		// 消息转换
		RequestMessage requestMessage = MessageConverter.convertMessage(
				accountId, xml);
		WxUtil.getInstance().setCurrentOpenid(request, requestMessage.getFromUserName());
		WxUtil.getInstance().setCurrentAccountid(request, accountId);
		logger.info("==============="+requestMessage);
		ResponseMessage responseMessage = null;
		try {
			requestMessage.setLocalAddr(request.getLocalAddr());
			requestMessage.setAccountId(accountId);
			responseMessage = requestDispatchService.dispatch(request,requestMessage);
		}catch (Exception e) {
			logger.info("Exception:", e);
		}

		String responseXml ="success";
		if(null != responseMessage){
			responseXml=responseMessage.toString();
			//安全模式(加密)
			if("aes".equals(request.getParameter("encrypt_type"))){
				logger.info("--------------raw result data:" + responseXml);			
				responseXml = encryptXml(responseXml, request,account);			
				logger.info("--------------aes result data:" + responseXml);
			}
		}
		
		//最终判断
		if (responseXml == null || "".equals(responseXml) || "null".equals(responseXml)) {
			responseXml="success";
		}
		logger.info("-------------raw result data:" + responseXml);
		try {
			response.getWriter().print(responseXml);
			response.getWriter().close();
		} catch (Exception e) {
			logger.info("返回微信报文失败:", e);
		}
	}
	
	/**
	 * 校验Sha
	 * @param request
	 * @param token
	 * @return
	 */
	public boolean checkSha(HttpServletRequest request,String token){		
		try {
			return this.checkSignature(request, token);
		} catch (NoSuchAlgorithmException e) {
			logger.info("NoSuchAlgorithmException:",e);
			return false;
		}
	}

	/**
	 * 验证签名
	 * @param request
	 * @param token
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private boolean checkSignature(HttpServletRequest request, String token)
			throws NoSuchAlgorithmException {
		logger.info("--------------------checkSignature,token:"+token);
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		
		logger.info("--------------signature=" + signature + ",timestamp=" + timestamp
				+ ",nonce=" + nonce );
		
		long timefromdb =999*1000;
		long systimes = (new Date()).getTime();
		long revtimes = Long.parseLong(timestamp)*1000;
		long starttimes = systimes-timefromdb;
		long endtimes = systimes+timefromdb;
		

		String[] tempArr = new String[] { token, timestamp, nonce };
		Arrays.sort(tempArr);
		String tempStr = tempArr[0] + tempArr[1] + tempArr[2];
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(tempStr.getBytes());
		tempStr = this.byteArrayToHex(md.digest());
		logger.info("----------sha1 String:" + tempStr);

		if (tempStr.equalsIgnoreCase(signature)) {
			logger.info("--------------checkSignature:true");
			return true;
		} else {
			logger.info("--------------checkSignature:false");
			return false;
		}
	}

	/**
	 * 用于将字节数组换成成16进制的字符串
	 * @param byteArray
	 * @return
	 */
	public String byteArrayToHex(byte[] byteArray) {
		// 首先初始化一个字符数组，用来存放每个16进制字符
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };

		// new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
		char[] resultCharArray = new char[byteArray.length * 2];

		// 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
		int index = 0;
		for (byte b : byteArray) {
			resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
			resultCharArray[index++] = hexDigits[b & 0xf];
		}

		// 字符数组组合成字符串返回
		return new String(resultCharArray);
	}
	
	/**
	 * 对加密字符串进行解密
	 * @param xmlstr
	 * @param request
	 * @return
	 */
	public String decryptXml(String xmlstr, HttpServletRequest request,WxAccount account){
		String result = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			StringReader sr = new StringReader(xmlstr);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);

			Element root = document.getDocumentElement();
			NodeList nodelist1 = root.getElementsByTagName("Encrypt");
			String encrypt = nodelist1.item(0).getTextContent();
			
			//NodeList nodelist2 = root.getElementsByTagName("MsgSignature");
			//String msgSignature = nodelist2.item(0).getTextContent();
			String msgSignature = request.getParameter("msg_signature");

			String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
			String fromXML = String.format(format, encrypt);

			String token = account.getToken();
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
			
			String appId = account.getAppid();
			String encodingAesKey = account.getAeskey();
			
			WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
			result = pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
		} catch (DOMException e) {
			logger.info("DOMException",e);
		} catch (ParserConfigurationException e) {
			logger.info("ParserConfigurationException",e);
		} catch (SAXException e) {
			logger.info("SAXException",e);
		} catch (IOException e) {
			logger.info("IOException",e);
		}catch (Exception e) {
			logger.info("Exception",e);
		}
		return result;
	}
	
	/**
	 * 对明文字符串进行加密
	 * @param xmlstr
	 * @param request
	 * @return
	 */
	public String encryptXml(String xmlstr, HttpServletRequest request,WxAccount account){
		String result = null;
		try {
			String token = account.getToken();
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
		
			String appId = account.getAppid();
			String encodingAesKey = account.getAeskey();
			
			WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
			result = pc.encryptMsg(xmlstr, timestamp, nonce);
		} catch (AesException e) {
			logger.info("AesException",e);
		}catch (Exception e) {
			logger.info("Exception",e);
		}
		return result;
	}	
}
