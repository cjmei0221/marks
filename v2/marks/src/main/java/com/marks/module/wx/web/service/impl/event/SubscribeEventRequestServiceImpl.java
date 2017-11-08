package com.marks.module.wx.web.service.impl.event;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.marks.module.wx.api.wxInterface.mp.user.entity.WxUser;
import com.marks.module.wx.web.message.request.WechatRequest;
import com.marks.module.wx.web.message.response.WechatResponse;
import com.marks.module.wx.web.service.impl.normal.AbstractRequestService;
import com.marks.module.wx.web.threadPool.WxhreadPool;
import com.marks.module.wx.web.util.WxConstants;

/**
 * 关注事件请求服务
 * 
 * @author lwgang
 * @createTime 2015-02-05
 * @history 1.修改时间,修改;修改内容：
 * 
 */
@Service("subscribeEventRequestService")
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
	public WechatResponse handle(HttpServletRequest request, WechatRequest requestMessage) throws Exception {
		WxUser user = new WxUser();
		String scene = "";

		logger.info("SubscribeRequestServiceImpl:accountid:" + requestMessage.getAccountId() + "-openid:"
				+ requestMessage.getFromUserName());
		String eventkey = requestMessage.getEventKey();
		if (null != eventkey && eventkey.indexOf("_") >= 0) {
			scene = eventkey.split("_")[1];
		}
		user.setIssubscribe(1);

		try {
			logger.info("-----------------ticket=" + requestMessage.getTicket());
			if (requestMessage.getTicket() != null) {
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
		
		WxhreadPool.updateWxUser(user);
		
		return handle(requestMessage, WxConstants.SubscribeReplay);
	}
}
