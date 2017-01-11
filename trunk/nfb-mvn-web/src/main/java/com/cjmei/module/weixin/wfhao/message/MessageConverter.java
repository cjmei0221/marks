package com.cjmei.module.weixin.wfhao.message;

import org.apache.log4j.Logger;

import com.cjmei.module.weixin.util.JaxbParser;
import com.cjmei.module.weixin.wfhao.message.request.WechatRequest;
import com.cjmei.module.weixin.wfhao.message.response.WechatResponse;

/**
 * 微信服务器发送的XML到对象的转化
 * 
 * @author
 * @createTime
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class MessageConverter {

	private static Logger logger = Logger.getLogger(MessageConverter.class);

	/**
	 * 将xml转换为请求消息对象
	 * 
	 * @param accountid
	 * @param xml
	 * @return
	 */
	public static WechatRequest convertRequest(String accountid, String xmlStr) {
		logger.info("parse post data:" + xmlStr);
		WechatRequest wechatRequest = null;
		try {
			JaxbParser jaxbParser = new JaxbParser(WechatRequest.class);
			wechatRequest = (WechatRequest) jaxbParser.toObj(xmlStr);
			wechatRequest.setAccountId(accountid);
		} catch (Exception e) {
			logger.error("convertRequest", e);
		}
		return wechatRequest;
	}

	/**
	 * 将xml转换为请求消息对象
	 * 
	 * @param accountid
	 * @param xml
	 * @return
	 */
	public static String convertResponse(WechatResponse wechatResponse) {
		String result = null;
		if(null !=wechatResponse){
			try {
				JaxbParser jaxbParser = new JaxbParser(WechatResponse.class);
				// 设置
				jaxbParser.setCdataNode(WechatResponse.CDATA_TAG);
				result = jaxbParser.toXML(wechatResponse);
			} catch (Exception e) {
				logger.error("convertResponse", e);
			}
		}
		return result;
	}
}
