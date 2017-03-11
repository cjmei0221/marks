package com.marks.module.wx.wfhao.service.impl.event;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.marks.common.util.Constants;
import com.marks.module.wx.wfhao.message.request.WechatRequest;
import com.marks.module.wx.wfhao.message.response.WechatResponse;
import com.marks.module.wx.wfhao.pojo.WxUser;
import com.marks.module.wx.wfhao.service.impl.normal.AbstractRequestService;
import com.marks.module.wx.wfhao.threadPool.UpdateWxUserhreadPool;

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
		
		UpdateWxUserhreadPool.updateWxUser(user);
		
		return handle(requestMessage, Constants.SubscribeReplay);
	}
}
