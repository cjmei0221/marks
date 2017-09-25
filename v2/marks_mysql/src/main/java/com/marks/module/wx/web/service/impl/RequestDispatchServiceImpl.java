package com.marks.module.wx.web.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.marks.module.core.common.SpringContextHolder;
import com.marks.module.wx.web.message.request.WechatRequest;
import com.marks.module.wx.web.message.response.WechatResponse;
import com.marks.module.wx.web.service.RequestDispatchService;
import com.marks.module.wx.web.service.RequestService;

/**
 * 请求消息对象分发接口实现
 * 
 * @author
 * @createTime
 * @history 1.修改时间,修改;修改内容：
 * 
 */
@Service("requestDispatchService")
public class RequestDispatchServiceImpl implements RequestDispatchService {
	private static Logger logger = Logger.getLogger(RequestDispatchServiceImpl.class);

	/**
	 * 请求消息分发处理
	 * 
	 * @param requestMessage
	 *            请求消息对象
	 * @return 响应消息对象
	 * @throws Exception
	 */
	@Override
	public WechatResponse dispatch(HttpServletRequest request, WechatRequest requestMessage) throws Exception {

		try {
			RequestService requestService = (RequestService) SpringContextHolder
					.getBean(requestMessage.getMsgType().toLowerCase() + "RequestService");
			if (requestService != null) {
				WechatResponse responseMessage = requestService.handle(request, requestMessage);
				return responseMessage;
			}
		} catch (Exception e) {
			logger.info(requestMessage.getMsgType().toLowerCase() + "RequestService 的bean不存在");
			logger.error("Exception", e);
		}
		return null;
	}

}
