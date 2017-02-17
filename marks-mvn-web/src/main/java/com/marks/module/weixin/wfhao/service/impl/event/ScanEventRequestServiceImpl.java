package com.marks.module.weixin.wfhao.service.impl.event;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.marks.common.util.Constants;
import com.marks.module.weixin.wfhao.message.request.WechatRequest;
import com.marks.module.weixin.wfhao.message.response.WechatResponse;
import com.marks.module.weixin.wfhao.service.impl.normal.AbstractRequestService;
import com.marks.module.weixin.wfhao.threadPool.UpdateWxUserhreadPool;

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
		UpdateWxUserhreadPool.updateWxUser(requestMessage.getAccountId(), requestMessage.getFromUserName());

		return handle(requestMessage, Constants.SubscribeReplay);
	}

}
