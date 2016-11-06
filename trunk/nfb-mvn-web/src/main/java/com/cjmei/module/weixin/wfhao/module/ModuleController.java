package com.cjmei.module.weixin.wfhao.module;

import org.apache.log4j.Logger;

import com.cjmei.module.system.core.data.StaticData;
import com.cjmei.module.weixin.wfhao.message.request.RequestMessage;
import com.cjmei.module.weixin.wfhao.message.response.ResponseMessage;
import com.cjmei.module.weixin.wfhao.message.response.impl.TextResponseMessage;

/**
 * 业务逻辑模块处理控制器
 * 
 * @author lwgang
 * @createTime 2014-11-25
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class ModuleController {
	private static Logger logger = Logger.getLogger(ModuleController.class);
	
	/**
	 * 业务逻辑模块处理
	 * @param module_id
	 * @param requestMessage
	 * @return
	 */
	public static ResponseMessage moduleHandle(String module_path,RequestMessage requestMessage){
		Module module =null;
		ResponseMessage responseMessage=null;
		try {
			logger.info("module_path>>"+module_path );
			//采用反射创建具体的业务逻辑模块实例对象，调用同步请求消息处理
			Class c=Class.forName(module_path);
			module=(Module)c.newInstance();
			responseMessage=module.syncRequest(requestMessage);
			logger.info("returnMsg>>"+responseMessage.getContent() );
		} catch (Exception e) {
			logger.info("Exception:",e);
			TextResponseMessage textResponseMessage = new TextResponseMessage(requestMessage);			
			textResponseMessage.setContent("");
			responseMessage=textResponseMessage;			
		}
		return responseMessage;
	}	
}
