package com.marks.module.wx.web.service.impl.normal;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.marks.module.core.common.SpringContextHolder;
import com.marks.module.core.data.StaticData;
import com.marks.module.wx.manage.enums.WXEnums;
import com.marks.module.wx.manage.wxchat.dao.WxChatSessionDao;
import com.marks.module.wx.manage.wxchat.pojo.WxChatSession;
import com.marks.module.wx.web.message.request.WechatRequest;
import com.marks.module.wx.web.message.response.WechatResponse;
import com.marks.module.wx.web.threadPool.WxhreadPool;
import com.marks.module.wx.web.util.WxConstants;

/**
 * 文本消息对象服务
 * 
 * @author
 * @createTime
 * @history 1.修改时间,修改;修改内容：
 * 
 */
@Service("textRequestService")
public class TextRequestServiceImpl extends AbstractRequestService {
	private static Logger logger = Logger.getLogger(TextRequestServiceImpl.class);
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
		logger.info("TextRequestServiceImpl > "+requestMessage.getContent());
		//更新粉丝信息
		WxhreadPool.updateWxUser(requestMessage.getAccountId(), requestMessage.getFromUserName());
		
		WxChatSession msg=new WxChatSession();
		msg.setAccountid(requestMessage.getAccountId());
		msg.setC_content(requestMessage.getContent());
		msg.setOpenid(requestMessage.getFromUserName());
		String isOpenRg="N";//是否开通系统自带人工服务 N：不开通  Y：开通  默认不开通
		String isOpenRgStr = StaticData.getSysConf("is_open_session");
		if(null !=isOpenRgStr){
			isOpenRg=isOpenRgStr;
		}
		logger.info("是否开通系统自带人工服务: "+isOpenRg);
		//开通人工服务
		if("Y".equals(isOpenRg)){
			WxChatSessionDao wxChatSessionDao = (WxChatSessionDao) SpringContextHolder
					.getBean(WxChatSessionDao.class);
			long timeLong = System.currentTimeMillis() / 1000;
			String sessionStr = StaticData.getSysConf("session_time");
			int sessionTimes = 15 ;
			if (sessionStr != null) {
				sessionTimes = Integer.parseInt(sessionStr);
			}
			int flag=WXEnums.SessionType.PEOPLE.getValue();
			//查询是否为人工服务 不为空则为人工服务
			WxChatSession sessionVo = wxChatSessionDao.findByAccountidAndOpenid(msg.getAccountid(), msg.getOpenid(), timeLong,
					sessionTimes*60,flag);
			msg.setFlag(WXEnums.SessionType.AUTO.getValue());
			if("0".equals(requestMessage.getContent())){
				msg.setFlag(WXEnums.SessionType.PEOPLE.getValue());
				logger.info("回话时间: "+sessionTimes+" 分钟");
			}
			
			if(sessionVo != null){
				sessionVo.setC_content(msg.getC_content());
				sessionVo.setSessionFlag(WXEnums.SessionType.PEOPLE.getValue());
				WxhreadPool.saveWxChatMsg(sessionVo);
				return null;
			}
		}
		msg.setSessionFlag(WXEnums.SessionType.AUTO.getValue());
		WxhreadPool.saveWxChatMsg(msg);
		WechatResponse resp=handle(requestMessage, requestMessage.getContent());
		if(null != resp){
			return resp;
		}
		return handle(requestMessage, WxConstants.defaultReplay);
		
	}
}
