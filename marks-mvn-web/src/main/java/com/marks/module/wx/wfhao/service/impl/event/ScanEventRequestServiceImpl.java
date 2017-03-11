package com.marks.module.wx.wfhao.service.impl.event;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.marks.common.util.Constants;
import com.marks.module.wx.wfhao.message.request.WechatRequest;
import com.marks.module.wx.wfhao.message.response.WechatResponse;
import com.marks.module.wx.wfhao.service.impl.normal.AbstractRequestService;
import com.marks.module.wx.wfhao.threadPool.WxhreadPool;

/**
 * 扫一扫
 * 
 * @author lhyan3 2015年3月28日上午9:42:02
 */
public class ScanEventRequestServiceImpl extends AbstractRequestService {

	private static Logger logger = Logger.getLogger(ScanEventRequestServiceImpl.class);

	@Override
	public WechatResponse handle(HttpServletRequest request, WechatRequest requestMessage) throws Exception {
		logger.info("ScanEventRequestServiceImpl deal start");
		WxhreadPool.updateWxUser(requestMessage.getAccountId(), requestMessage.getFromUserName());

		return handle(requestMessage, Constants.SubscribeReplay);
	}

}
