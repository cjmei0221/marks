package com.marks.smart.wx.manage.web.service.impl.event;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.marks.smart.wx.manage.web.message.request.WechatRequest;
import com.marks.smart.wx.manage.web.message.response.WechatResponse;
import com.marks.smart.wx.manage.web.service.impl.normal.AbstractRequestService;
import com.marks.smart.wx.manage.web.threadPool.WxhreadPool;



/**
 * 上报菜单事件请求服务
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
@Service("clickEventRequestService")
public class ClickEventRequestServiceImpl extends AbstractRequestService {	

	private static Logger logger = Logger.getLogger(ClickEventRequestServiceImpl.class);

	/**
	 * 请求消息处理
	 * 
	 * @param requestMessage
	 *            请求消息对象
	 * @return 响应消息对象
	 * @throws Exception
	 */
	@Override
	public WechatResponse handle(HttpServletRequest request,WechatRequest requestMessage) throws Exception {
		logger.info("ClickEventRequestServiceImpl deal start eventkey > "+requestMessage.getEventKey());
		WxhreadPool.updateWxUser(requestMessage.getAccountId(), requestMessage.getFromUserName());
		return handle(request, requestMessage, requestMessage.getEventKey());
	}
	
}
