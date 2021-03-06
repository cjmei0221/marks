package com.marks.smart.wx.manage.web.service.impl.event;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.marks.smart.wx.manage.web.message.request.WechatRequest;
import com.marks.smart.wx.manage.web.message.response.WechatResponse;
import com.marks.smart.wx.manage.web.service.impl.normal.AbstractRequestService;
import com.marks.smart.wx.manage.web.threadPool.WxhreadPool;
import com.marks.smart.wx.manage.web.util.WxConstants;

/**
 * 扫一扫
 * 
 * @author lhyan3 2015年3月28日上午9:42:02
 */
@Service("scanEventRequestService")
public class ScanEventRequestServiceImpl extends AbstractRequestService {

	private static Logger logger = Logger.getLogger(ScanEventRequestServiceImpl.class);

	@Override
	public WechatResponse handle(HttpServletRequest request, WechatRequest requestMessage) throws Exception {
		logger.info("ScanEventRequestServiceImpl deal start");
		String scene = "";
		String eventkey = requestMessage.getEventKey();
		if (null != eventkey && !"".equals(eventkey)) {
			scene = eventkey;
		}
		WxhreadPool.updateWxUser(requestMessage.getAccountId(), requestMessage.getFromUserName());

		return handle(request, requestMessage, WxConstants.SubscribeReplay);
	}

}
