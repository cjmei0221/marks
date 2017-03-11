package com.marks.module.weixin.wfhao.service.impl.event;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.marks.module.weixin.wfhao.message.request.WechatRequest;
import com.marks.module.weixin.wfhao.message.response.WechatResponse;
import com.marks.module.weixin.wfhao.service.impl.normal.AbstractRequestService;
import com.marks.module.weixin.wfhao.threadPool.UpdateWxUserhreadPool;



/**
 * 上报菜单事件请求服务
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
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
		UpdateWxUserhreadPool.updateWxUser(requestMessage.getAccountId(), requestMessage.getFromUserName());
		return handle(requestMessage,requestMessage.getEventKey());
	}
	
}
