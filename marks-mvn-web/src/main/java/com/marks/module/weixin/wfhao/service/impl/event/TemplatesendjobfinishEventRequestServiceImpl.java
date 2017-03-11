package com.marks.module.weixin.wfhao.service.impl.event;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.marks.module.system.core.listener.DatabaseHelper;
import com.marks.module.weixin.wfhao.message.request.WechatRequest;
import com.marks.module.weixin.wfhao.message.response.WechatResponse;
import com.marks.module.weixin.wfhao.service.WeixinAccountService;
import com.marks.module.weixin.wfhao.service.impl.normal.AbstractRequestService;



/**
 * 上报菜单事件请求服务
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class TemplatesendjobfinishEventRequestServiceImpl extends AbstractRequestService {	

	private static Logger logger = Logger.getLogger(TemplatesendjobfinishEventRequestServiceImpl.class);

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
		logger.info("TemplatesendjobfinishEventRequestServiceImpl deal start  > msgId: "+requestMessage.getMsgID()+" - result: "+requestMessage.getStatus());
		WeixinAccountService weixinAccountService=(WeixinAccountService) DatabaseHelper.getBean(WeixinAccountService.class);
		String createtimeStr=requestMessage.getCreateTime();
		Timestamp time=new Timestamp(Long.parseLong(createtimeStr)*1000);
		weixinAccountService.updateResultForModuleMsg(requestMessage.getAccountId(),requestMessage.getMsgID(),time,requestMessage.getStatus());
		return null;
	}
	
}
