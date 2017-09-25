package com.marks.module.wx.web.service.impl.normal;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.marks.module.wx.web.message.request.WechatRequest;
import com.marks.module.wx.web.message.response.WechatResponse;

/**
 * 视频消息对象服务
 * 
 * @author
 * @createTime
 * @history 1.修改时间,修改;修改内容：
 * 
 */
@Service("videoRequestService")
public class VideoRequestServiceImpl extends AbstractRequestService {
	private static Logger logger = Logger.getLogger(VideoRequestServiceImpl.class);
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
		logger.info("VideoRequestServiceImpl start >");
		WechatResponse responseMessage = new WechatResponse(requestMessage);
		responseMessage.setContent("暂不支持");
		return responseMessage;
	}

}
