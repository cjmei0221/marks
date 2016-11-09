package com.cjmei.module.weixin.wfhao.service.impl.normal;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.cjmei.module.weixin.wfhao.message.request.EventRequestMessage;
import com.cjmei.module.weixin.wfhao.message.request.RequestMessage;
import com.cjmei.module.weixin.wfhao.message.response.ResponseMessage;
import com.cjmei.module.weixin.wfhao.message.response.impl.TextResponseMessage;
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
	private Map<String, RequestService> componentMap;

	public void setComponentMap(Map<String, RequestService> componentMap) {
		this.componentMap = componentMap;
	}

	/**
	 * 请求消息处理
	 * 
	 * @param requestMessage
	 *            请求消息对象
	 * @return 响应消息对象
	 * @throws Exception
	 */
	@Override
	public ResponseMessage handle(HttpServletRequest request, RequestMessage requestMessage) throws Exception {
		EventRequestMessage eventRequestMessage = (EventRequestMessage) requestMessage;
		logger.info("EventRequestServiceImpl deal start event>"+eventRequestMessage.getEvent().toLowerCase());
		RequestService requestService = componentMap.get(eventRequestMessage.getEvent().toLowerCase());
		if (requestService != null) {
			ResponseMessage responseMessage = requestService.handle(request, eventRequestMessage);
			return responseMessage;
		}
		TextResponseMessage textResponseMessage = new TextResponseMessage(requestMessage);
		textResponseMessage.setContent("");
		return textResponseMessage;
	}
}
