package com.cjmei.module.weixin.wfhao.service.impl.event;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.cjmei.common.util.Constants;
import com.cjmei.module.system.core.data.StaticData;
import com.cjmei.module.system.core.listener.DatabaseHelper;
import com.cjmei.module.weixin.wfhao.message.request.EventRequestMessage;
import com.cjmei.module.weixin.wfhao.message.request.RequestMessage;
import com.cjmei.module.weixin.wfhao.message.response.ResponseMessage;
import com.cjmei.module.weixin.wfhao.message.response.impl.NewsResponseMessage;
import com.cjmei.module.weixin.wfhao.pojo.NewsItem;
import com.cjmei.module.weixin.wfhao.pojo.WxUser;
import com.cjmei.module.weixin.wfhao.service.impl.normal.AbstractRequestService;
import com.cjmei.module.weixin.wfhao.threadPool.UpdateWxUserhreadPool;

/**
 * 关注事件请求服务
 * 
 * @author lwgang
 * @createTime 2015-02-05
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class SubscribeEventRequestServiceImpl extends AbstractRequestService {

	private static Logger logger = Logger.getLogger(SubscribeEventRequestServiceImpl.class);

	/**
	 * 关注的处理
	 * 
	 * @param requestMessage
	 *            请求消息对象
	 * @return 响应消息对象
	 * @throws Exception
	 */
	@Override
	public ResponseMessage handle(HttpServletRequest request, RequestMessage requestMessage) throws Exception {
		EventRequestMessage eventRequestMessage = (EventRequestMessage) requestMessage;
		WxUser user = new WxUser();
		String scene = "";

		logger.info("SubscribeRequestServiceImpl:accountid:" + requestMessage.getAccountId() + "-openid:"
				+ requestMessage.getFromUserName());
		String eventkey = eventRequestMessage.getEventKey();
		if (null != eventkey && eventkey.indexOf("_") >= 0) {
			scene = eventkey.split("_")[1];
		}
		user.setIssubscribe(1);

		try {
			logger.info("-----------------ticket=" + eventRequestMessage.getTicket());
			if (eventRequestMessage.getTicket() != null) {
				// 扫码关注
				user.setSubscribetype(1);
			} else {
				// 搜索关注
				user.setSubscribetype(2);
			}
		} catch (Exception e) {
			logger.error("Exception:", e);
		}
		user.setOpenid(requestMessage.getFromUserName());
		user.setAccountid(requestMessage.getAccountId());
		user.setQrNo(scene);
		logger.info("保存关注者信息" + user.getNickname() + "-" + user.getOpenid() + "-" + scene);

		// 判断是否首次关注
		logger.info("requestMessage.getFirstflag()==" + requestMessage.getFirstSubscribeflag());
		if ("Y".equals(requestMessage.getFirstSubscribeflag())) {
			
		}
		UpdateWxUserhreadPool.updateWxUser(user);
		return handle(requestMessage, Constants.SubscribeReplay);
	}
}
