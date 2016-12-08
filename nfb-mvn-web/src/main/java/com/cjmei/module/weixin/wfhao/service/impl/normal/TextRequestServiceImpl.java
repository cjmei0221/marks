package com.cjmei.module.weixin.wfhao.service.impl.normal;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.cjmei.module.weixin.wfhao.message.request.RequestMessage;
import com.cjmei.module.weixin.wfhao.message.request.impl.TextRequestMessage;
import com.cjmei.module.weixin.wfhao.message.response.ResponseMessage;

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
	public ResponseMessage handle(HttpServletRequest request, RequestMessage requestMessage) throws Exception {
		
		TextRequestMessage textRequestMessage = (TextRequestMessage) requestMessage;
		logger.info("TextRequestServiceImpl deal start  content>"+textRequestMessage.getContent());
		return handle(requestMessage, textRequestMessage.getContent().toLowerCase());
	}
}
