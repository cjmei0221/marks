package com.marks.module.wx.wfhao.service.impl.normal;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONException;

import com.marks.module.wx.wfhao.message.request.WechatRequest;
import com.marks.module.wx.wfhao.message.response.WechatResponse;

/**
 * 地理位置消息对象服务
 * 
 * @author
 * @createTime
 * @history 1.修改时间,修改;修改内容：
 * 
 */
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
