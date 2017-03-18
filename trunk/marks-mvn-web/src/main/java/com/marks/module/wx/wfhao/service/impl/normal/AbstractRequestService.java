package com.marks.module.wx.wfhao.service.impl.normal;

import java.util.List;

import org.apache.log4j.Logger;

import com.marks.common.util.Constants;
import com.marks.module.system.core.listener.DatabaseHelper;
import com.marks.module.wx.wfhao.dao.WxAutoReplayDao;
import com.marks.module.wx.wfhao.message.request.WechatRequest;
import com.marks.module.wx.wfhao.message.response.WechatResponse;
import com.marks.module.wx.wfhao.module.ModuleController;
import com.marks.module.wx.wfhao.pojo.WxAutoReplay;
import com.marks.module.wx.wfhao.service.RequestService;
import com.marks.module.wx.wfhao.service.impl.NewsHelper;

/**
 * 请求消息对象分发接口的抽象类实现 核心功能：提供统一请求消息处理
 * 
 * @author
 * @createTime
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public abstract class AbstractRequestService implements RequestService {

	private static Logger logger = Logger.getLogger(AbstractRequestService.class);

	/**
	 * 业务组件处理接口
	 * 
	 * @param requestMessage
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public WechatResponse handle(WechatRequest requestMessage, String key) throws Exception {
		WechatResponse responseMessage =null;
		WxAutoReplayDao wxAutoReplayDao = (WxAutoReplayDao) DatabaseHelper.getBean(WxAutoReplayDao.class);
		List<WxAutoReplay> replyList = wxAutoReplayDao.getWxAutoReplayByKey(key.toLowerCase(), requestMessage.getAccountId());
		if(null != replyList && replyList.size()==1){
			WxAutoReplay reply=replyList.get(0);
			responseMessage = new WechatResponse(requestMessage);
			String content = reply.getCreplay();
			if (Constants.weixin_replay_type_news.equals(reply.getReplayType())) {
				content = Constants.weixin_replay_type_news + ":" + reply.getCreplay();
				responseMessage = NewsHelper.Handle(requestMessage, content);
			} else if (Constants.weixin_replay_type_module.equals(reply.getReplayType())) {
				responseMessage = moduleProcess(requestMessage, content);
			} else {
				responseMessage.setContent(toFormat(content));
			}
			return responseMessage;
		}else if(null != replyList && replyList.size()>1){
			responseMessage = new WechatResponse(requestMessage);
			StringBuffer sb=new StringBuffer();
			sb.append("亲，您可以换种方式试试，输入以下关键词：\r\n");
			for(WxAutoReplay vo:replyList){
				sb.append(" ["+vo.getCkey()+"] "+vo.getCkeyName()+"\r");
			}
			responseMessage.setContent(sb.toString());
			return responseMessage;
		}
		
		return responseMessage;
	}
	private String toFormat(String content){
		return content.replaceAll("\r\n", "<br/>");
	}

	/**
	 * 业务组件处理
	 * 
	 * @param requestMessage
	 * @param content
	 * @return
	 */
	private WechatResponse moduleProcess(WechatRequest requestMessage, String content) {
		logger.info("Module path:" + content);
		return ModuleController.moduleHandle(content, requestMessage);
	}
}
