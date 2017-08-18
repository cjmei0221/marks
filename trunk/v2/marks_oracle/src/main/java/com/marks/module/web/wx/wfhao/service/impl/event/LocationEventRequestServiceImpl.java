package com.marks.module.web.wx.wfhao.service.impl.event;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.marks.module.web.wx.wfhao.message.request.WechatRequest;
import com.marks.module.web.wx.wfhao.message.response.WechatResponse;
import com.marks.module.web.wx.wfhao.service.impl.normal.AbstractRequestService;



/**
 * 上报菜单事件请求服务
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
@Service("locationEventRequestService")
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
	public WechatResponse handle(HttpServletRequest request,WechatRequest requestMessage) throws Exception {
		logger.info("LocationEventRequestServiceImpl deal start");

		WechatResponse responseMessage = new WechatResponse(
				requestMessage);
		responseMessage.setContent("暂不支持");
		
		return null;
	}
	
}
