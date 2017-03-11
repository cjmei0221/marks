package com.marks.module.wx.wfhao.module;

import org.apache.log4j.Logger;

import com.marks.module.wx.wfhao.message.request.WechatRequest;
import com.marks.module.wx.wfhao.message.response.WechatResponse;

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
	public static WechatResponse moduleHandle(String module_path,WechatRequest requestMessage){
		Module module =null;
		WechatResponse responseMessage=new WechatResponse(requestMessage);
		try {
			logger.info("module_path>>"+module_path );
			//采用反射创建具体的业务逻辑模块实例对象，调用同步请求消息处理
			Class c=Class.forName(module_path);
			module=(Module)c.newInstance();
			responseMessage=module.syncRequest(requestMessage);
			logger.info("returnMsg>>"+responseMessage.getContent() );
		} catch (Exception e) {
			logger.info("Exception:",e);			
			responseMessage.setContent("");
		}
		return responseMessage;
	}	
}
