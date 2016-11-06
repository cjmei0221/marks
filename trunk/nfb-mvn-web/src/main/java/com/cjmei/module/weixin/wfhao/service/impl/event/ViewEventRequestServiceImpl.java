package com.cjmei.module.weixin.wfhao.service.impl.event;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONException;

import com.cjmei.module.weixin.wfhao.message.request.RequestMessage;
import com.cjmei.module.weixin.wfhao.message.request.impl.ViewEventRequestMessage;
import com.cjmei.module.weixin.wfhao.message.response.ResponseMessage;
import com.cjmei.module.weixin.wfhao.service.impl.normal.AbstractRequestService;

/**
 * 点击菜单跳转链接的事件请求服务
 * 
 * @author lwgang
 * @createTime 2015-02-04
 * @history 1.修改时间,修改;修改内容：
 * 
 */
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
	public ResponseMessage handle(HttpServletRequest request, RequestMessage requestMessage) throws JSONException {
		ResponseMessage responseMessage = null;
		ViewEventRequestMessage viewEventRequestMessage = (ViewEventRequestMessage) requestMessage;
		logger.info("----------url:" + viewEventRequestMessage.getEventKey());
		// 返回的响应请求对象为null，为了让微信端直接跳转到URL
		return responseMessage;
	}

}
