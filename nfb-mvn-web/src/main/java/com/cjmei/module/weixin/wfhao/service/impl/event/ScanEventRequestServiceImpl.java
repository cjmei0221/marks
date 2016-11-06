package com.cjmei.module.weixin.wfhao.service.impl.event;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.cjmei.common.util.Constants;
import com.cjmei.module.system.core.listener.DatabaseHelper;
import com.cjmei.module.weixin.wfhao.message.request.RequestMessage;
import com.cjmei.module.weixin.wfhao.message.response.ResponseMessage;
import com.cjmei.module.weixin.wfhao.message.response.impl.TextResponseMessage;
import com.cjmei.module.weixin.wfhao.pojo.WxUser;
import com.cjmei.module.weixin.wfhao.service.WeixinAccountService;
import com.cjmei.module.weixin.wfhao.service.impl.normal.AbstractRequestService;
import com.cjmei.module.weixin.wfhao.threadPool.UpdateWxUserhreadPool;

/**
 * 扫一扫
 * 
 * @author lhyan3 2015年3月28日上午9:42:02
 */
public class ScanEventRequestServiceImpl extends AbstractRequestService {

	private static Logger logger = Logger.getLogger(ScanEventRequestServiceImpl.class);

	@Override
	public ResponseMessage handle(HttpServletRequest request, RequestMessage requestMessage) throws Exception {

		UpdateWxUserhreadPool.updateWxUser(requestMessage.getAccountId(), requestMessage.getFromUserName());

		return handle(requestMessage, Constants.SubscribeReplay);
	}

}
