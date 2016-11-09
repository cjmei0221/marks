package com.cjmei.module.weixin.wfhao.service.impl.event;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.cjmei.module.weixin.wfhao.message.request.RequestMessage;
import com.cjmei.module.weixin.wfhao.message.request.impl.LocationEventRequestMessage;
import com.cjmei.module.weixin.wfhao.message.response.ResponseMessage;
import com.cjmei.module.weixin.wfhao.message.response.impl.TextResponseMessage;
import com.cjmei.module.weixin.wfhao.service.impl.normal.AbstractRequestService;



/**
 * 上报菜单事件请求服务
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class LocationEventRequestServiceImpl extends AbstractRequestService {	

	private static Logger logger = Logger.getLogger(LocationEventRequestServiceImpl.class);
	
	/**
	 * 请求消息处理
	 * 
	 * @param requestMessage
	 *            请求消息对象
	 * @return 响应消息对象
	 * @throws Exception
	 */
	@Override
	public ResponseMessage handle(HttpServletRequest request,RequestMessage requestMessage) throws Exception {
		logger.info("LocationEventRequestServiceImpl deal start");
		LocationEventRequestMessage locationRequestMessage = (LocationEventRequestMessage) requestMessage;
		TextResponseMessage responseMessage = new TextResponseMessage(
				requestMessage);
		responseMessage.setContent("暂不支持");
		return responseMessage;
	}
	
}
