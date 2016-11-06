package com.cjmei.module.weixin.wfhao.service.impl.normal;

import org.apache.log4j.Logger;

import com.cjmei.common.util.Constants;
import com.cjmei.module.system.core.listener.DatabaseHelper;
import com.cjmei.module.weixin.wfhao.dao.WxAutoReplayDao;
import com.cjmei.module.weixin.wfhao.message.request.RequestMessage;
import com.cjmei.module.weixin.wfhao.message.response.ResponseMessage;
import com.cjmei.module.weixin.wfhao.message.response.impl.TextResponseMessage;
import com.cjmei.module.weixin.wfhao.module.ModuleController;
import com.cjmei.module.weixin.wfhao.pojo.WxAutoReplay;
import com.cjmei.module.weixin.wfhao.service.RequestService;
import com.cjmei.module.weixin.wfhao.service.impl.NewsHelper;

/**
 * 请求消息对象分发接口的抽象类实现
 * 核心功能：提供统一请求消息处理
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public abstract class AbstractRequestService implements RequestService{
	
	private static Logger logger = Logger.getLogger(AbstractRequestService.class);
	
	

	/**
	 * 业务组件处理接口
	 * @param requestMessage
	 * @param content
	 * @return
	 * @throws Exception 
	 */
	public ResponseMessage handle(RequestMessage requestMessage,String key) throws Exception {
		TextResponseMessage textResponseMessage = new TextResponseMessage(requestMessage);
		ResponseMessage responseMessage=null;
		WxAutoReplayDao wxAutoReplayDao=(WxAutoReplayDao) DatabaseHelper.getBean(WxAutoReplayDao.class);
		WxAutoReplay reply = wxAutoReplayDao.getWxAutoReplayByKey(key,requestMessage.getAccountId());
		String content="";
		if(null != reply){
			content=reply.getCreplay();
			if(Constants.weixin_replay_type_news.equals(reply.getReplayType())){
				content=Constants.weixin_replay_type_news+":"+reply.getCreplay();
				responseMessage=NewsHelper.Handle(requestMessage, content);	
			}else if(Constants.weixin_replay_type_module.equals(reply.getReplayType())){
				responseMessage = moduleProcess(requestMessage,content);
			}else{
				textResponseMessage.setContent(content);
				responseMessage=textResponseMessage;
			}
		}else{
			textResponseMessage.setContent(content);
			responseMessage=textResponseMessage;
		}
		logger.info("AbstractRequestService>>returnMSG>>"+responseMessage.getContent());
		return responseMessage;
	}

	/**
	 * 业务组件处理
	 * @param requestMessage
	 * @param content
	 * @return
	 */
	private ResponseMessage moduleProcess(RequestMessage requestMessage,String content){
		logger.info("Module path:"+content);
		return ModuleController.moduleHandle(content, requestMessage);
	}	
}
