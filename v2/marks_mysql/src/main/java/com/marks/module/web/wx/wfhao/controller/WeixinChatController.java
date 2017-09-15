package com.marks.module.web.wx.wfhao.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marks.module.inner.wx.wxaccount.pojo.WxAccount;
import com.marks.module.sys.data.StaticData;
import com.marks.module.web.wx.mp.DataDicUtil;
import com.marks.module.web.wx.util.StreamUtils;
import com.marks.module.web.wx.util.encrypt.CheckSign;
import com.marks.module.web.wx.util.encrypt.MsgEncriptUtil;
import com.marks.module.web.wx.wfhao.message.MessageConverter;
import com.marks.module.web.wx.wfhao.message.request.WechatRequest;
import com.marks.module.web.wx.wfhao.message.response.WechatResponse;
import com.marks.module.web.wx.wfhao.service.RequestDispatchService;
import com.marks.module.web.wx.wfhao.util.WxUtil;

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
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/web/wechat", method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("----------------------------doGet:");
		request.setAttribute("result_note", "check_service");
		String accountid = request.getParameter("accountid");
		if (accountid == null || "".equals(accountid)) {
			logger.info("----------accountid is null,check url has accountid,for return");
			return;
		}

		WxAccount account = StaticData.getWxAccount(accountid);
		if (account == null) {
			logger.info("----------check wxb_wechat_account table has data accountid=" + accountid + ",for return");
			return;
		}

		String token = account.getToken();
		if (token != null) {
			String signature = request.getParameter("signature");
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
			String echostr = request.getParameter("echostr");
			logger.info("--------------accountid=" + accountid + ",signature=" + signature + ",timestamp=" + timestamp
					+ ",nonce=" + nonce + ",echostr=" + echostr);

			if (echostr != null) {
				try {
					if (CheckSign.checkSignature(request, token) && DataDicUtil.doField(echostr)) {
						response.getWriter().print(echostr + "");
					}
				} catch (NoSuchAlgorithmException e) {
					logger.info("NoSuchAlgorithmException:", e);
				}
			}
		}
	}

	/**
	 * 微信调用doPost接口
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/web/wechat", method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		logger.info("----------------------------doPost:");

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		String accountId = request.getParameter("accountid");
		if (accountId == null || "".equals(accountId)) {
			logger.info("----------accountid is null,check url has accountid,for return");
			return;
		}

		WxAccount account = StaticData.getWxAccount(accountId);
		if (account == null) {
			logger.info("----------check wxb_wechat_account table has data accountid=" + accountId + ",for return");
			return;
		} else {
			logger.info("----------check wxb_wechat_account table has data accountid=" + accountId);

		}
		int isSafe=0;//是否为安全模式 1：是
		if("aes".equals(request.getParameter("encrypt_type"))){
			isSafe=1;
		}
		
		// 安全模式 // 消息体签名验证
		if (1 == isSafe && !CheckSign.checkSha(request, account.getToken())) {
			return;
		}

		// 解析输入流
		String xml = "";
		try {
			xml = StreamUtils.streamToString(request.getInputStream());
		} catch (IOException e) {
			logger.error("post data deal failed!");
		}
		if (xml == null || "".equals(xml)) {
			return;
		}
		// 安全模式 消息体解密
		if (1 == isSafe) {
			try {
				MsgEncriptUtil.descriptXML(request, xml, account);
			} catch (Exception e) {
				logger.error("descriptXML failed!", e);
			}
		}
		// 请求封装
		WechatRequest requestMessage = MessageConverter.convertRequest(accountId, xml);

		WxUtil.getInstance().setCurrentOpenid(request, requestMessage.getFromUserName());
		WxUtil.getInstance().setCurrentAccountid(request, accountId);

		WechatResponse wechatResponse = null;
		try {
			wechatResponse = requestDispatchService.dispatch(request, requestMessage);
		} catch (Exception e) {
			logger.info("Exception:", e);
		}
		

		String responseXml = MessageConverter.convertResponse(wechatResponse);

		// 最终判断
		if (responseXml == null || "".equals(responseXml) || "null".equals(responseXml)) {
			responseXml = "success";
		}else{
			// 安全模式 消息体加密
			if (1 == isSafe && responseXml.length()>10) {
				try {
					MsgEncriptUtil.encryptXML(request, responseXml, account);
				} catch (Exception e) {
					logger.error("encryptXML failed!", e);
				}
			}
		}

		logger.info("-------------raw result data:" + responseXml);
		try {
			response.getWriter().print(responseXml);
			response.getWriter().close();
		} catch (Exception e) {
			logger.info("返回微信报文失败:", e);
		}
	}
}
