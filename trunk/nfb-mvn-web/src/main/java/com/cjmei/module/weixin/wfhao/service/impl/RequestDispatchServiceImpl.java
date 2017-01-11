package com.cjmei.module.weixin.wfhao.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.cjmei.module.system.core.listener.DatabaseHelper;
import com.cjmei.module.weixin.wfhao.message.request.WechatRequest;
import com.cjmei.module.weixin.wfhao.message.response.WechatResponse;
import com.cjmei.module.weixin.wfhao.service.RequestDispatchService;
import com.cjmei.module.weixin.wfhao.service.RequestService;

/**
 * 请求消息对象分发接口实现
 * 
 * @author
 * @createTime
 * @history 1.修改时间,修改;修改内容：
 * 
 */
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

		RequestService requestService = (RequestService) DatabaseHelper
				.getBean(requestMessage.getMsgType().toLowerCase() + "RequestService");
		if (requestService != null) {
			WechatResponse responseMessage = requestService.handle(request, requestMessage);
			return responseMessage;
		}
		return null;
	}

}
