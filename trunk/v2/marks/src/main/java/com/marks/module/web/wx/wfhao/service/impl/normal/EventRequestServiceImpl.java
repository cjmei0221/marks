package com.marks.module.web.wx.wfhao.service.impl.normal;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.marks.module.sys.system.core.common.SpringContextHolder;
import com.marks.module.web.wx.wfhao.message.request.WechatRequest;
import com.marks.module.web.wx.wfhao.message.response.WechatResponse;
import com.marks.module.web.wx.wfhao.service.RequestService;

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
		
		try {
			RequestService requestService =  (RequestService) SpringContextHolder
					.getBean(requestMessage.getEvent().toLowerCase() + "EventRequestService");
			if (requestService != null) {
				WechatResponse responseMessage = requestService.handle(request, requestMessage);
				return responseMessage;
			}
		} catch (Exception e) {
			logger.info(requestMessage.getEvent().toLowerCase() + "EventRequestService 的事件不支持");
			logger.error("Exception", e);
		}
		
		return null;
	}
}
