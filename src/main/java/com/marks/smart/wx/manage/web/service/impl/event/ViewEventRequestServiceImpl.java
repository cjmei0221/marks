package com.marks.smart.wx.manage.web.service.impl.event;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.marks.smart.wx.manage.web.message.request.WechatRequest;
import com.marks.smart.wx.manage.web.message.response.WechatResponse;
import com.marks.smart.wx.manage.web.service.impl.normal.AbstractRequestService;
import com.marks.smart.wx.manage.web.threadPool.WxhreadPool;

/**
 * 点击菜单跳转链接的事件请求服务
 * 
 * @author lwgang
 * @createTime 2015-02-04
 * @history 1.修改时间,修改;修改内容：
 * 
 */
@Service("viewEventRequestService")
public class ViewEventRequestServiceImpl extends AbstractRequestService {

	private static Logger logger = Logger.getLogger(ViewEventRequestServiceImpl.class);

	/**
	 * 请求消息处理
	 * 
	 * @param requestMessage
	 *            请求消息对象
	 * @return 响应消息对象
	 * @throws Exception
	 */
	@Override
	public WechatResponse handle(HttpServletRequest request, WechatRequest requestMessage) throws JSONException {
		
		logger.info("----------url:" + requestMessage.getEventKey());
		// 返回的响应请求对象为null，为了让微信端直接跳转到URL
		WxhreadPool.updateWxUser(requestMessage.getAccountId(), requestMessage.getFromUserName());
		return null;
	}

}
