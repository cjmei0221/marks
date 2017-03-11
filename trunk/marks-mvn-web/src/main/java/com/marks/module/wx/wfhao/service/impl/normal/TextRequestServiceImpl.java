package com.marks.module.wx.wfhao.service.impl.normal;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.marks.module.wx.wfhao.message.request.WechatRequest;
import com.marks.module.wx.wfhao.message.response.WechatResponse;
import com.marks.module.wx.wfhao.threadPool.WxhreadPool;
import com.marks.module.wx.wxchatmsg.pojo.WxChatMsg;

/**
 * 文本消息对象服务
 * 
 * @author
 * @createTime
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class TextRequestServiceImpl extends AbstractRequestService {
	private static Logger logger = Logger.getLogger(TextRequestServiceImpl.class);
	/**
	 * 请求消息处理
	 * 
	 * @param requestMessage
	 *            请求消息对象
	 * @return 响应消息对象
	 * @throws Exception
	 */
	@Override
	public WechatResponse handle(HttpServletRequest request, WechatRequest requestMessage) throws Exception {
		logger.info("TextRequestServiceImpl > "+requestMessage.getContent());
		
		WxhreadPool.updateWxUser(requestMessage.getAccountId(), requestMessage.getFromUserName());
		
		WxChatMsg msg=new WxChatMsg();
		msg.setAccountid(requestMessage.getAccountId());
		msg.setC_content(requestMessage.getContent());
		msg.setOpenid(requestMessage.getFromUserName());
		msg.setSession_id(requestMessage.getMsgId());
		WxhreadPool.saveWxChatMsg(msg);
		return handle(requestMessage, requestMessage.getContent());
	}
}
