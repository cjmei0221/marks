package com.marks.smart.wx.manage.web.service.impl.normal;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.marks.smart.wx.manage.web.message.request.WechatRequest;
import com.marks.smart.wx.manage.web.message.response.WechatResponse;

/**
 * 地理位置消息对象服务
 * 
 * @author
 * @createTime
 * @history 1.修改时间,修改;修改内容：
 * 
 */
@Service("locationRequestService")
public class LocationRequestServiceImpl extends AbstractRequestService {

	private static Logger logger = Logger.getLogger(LocationRequestServiceImpl.class);

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
		logger.info("LocationRequestServiceImpl > 您的位置是 ： "+ requestMessage.getLabel());
		WechatResponse responseMessage = new WechatResponse(requestMessage);

		responseMessage.setContent("您的位置是 ：" + requestMessage.getLabel());

		return responseMessage;
	}

}
