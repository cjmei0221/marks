package com.cjmei.module.weixin.wfhao.service.impl.normal;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.cjmei.module.system.core.listener.DatabaseHelper;
import com.cjmei.module.weixin.wfhao.message.request.WechatRequest;
import com.cjmei.module.weixin.wfhao.message.response.WechatResponse;
import com.cjmei.module.weixin.wfhao.service.RequestService;

/**
 * 事件请求服务
 * 
 * @author
 * @createTime
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class EventRequestServiceImpl implements RequestService {
	private static Logger logger = Logger.getLogger(EventRequestServiceImpl.class);

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
		
		logger.info("EventRequestServiceImpl deal start event>"+requestMessage.getEvent().toLowerCase());
		
		RequestService requestService =  (RequestService) DatabaseHelper
				.getBean(requestMessage.getEvent().toLowerCase() + "EventRequestService");
		if (requestService != null) {
			WechatResponse responseMessage = requestService.handle(request, requestMessage);
			return responseMessage;
		}
		WechatResponse textResponseMessage = new WechatResponse(requestMessage);
		textResponseMessage.setContent("");
		return textResponseMessage;
	}
}
