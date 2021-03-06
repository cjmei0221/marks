package com.marks.smart.wx.manage.web.service.impl.normal;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.marks.smart.wx.manage.web.message.request.WechatRequest;
import com.marks.smart.wx.manage.web.message.response.WechatResponse;

/**
 * 语音消息对象服务
 * 
 * @author
 * @createTime
 * @history 1.修改时间,修改;修改内容：
 * 
 */
@Service("voiceRequestService")
public class VoiceRequestServiceImpl extends AbstractRequestService{

	private static Logger logger = Logger.getLogger(VoiceRequestServiceImpl.class);

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
		
		logger.info("VoiceRequestServiceImpl 语音解析结果：" + requestMessage.getRecognition());
		WechatResponse responseMessage = new WechatResponse(requestMessage);
		responseMessage.setContent("暂不支持");
		return responseMessage;
	}

}
