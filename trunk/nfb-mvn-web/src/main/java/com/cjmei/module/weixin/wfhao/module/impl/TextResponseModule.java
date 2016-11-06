package com.cjmei.module.weixin.wfhao.module.impl;

import com.cjmei.module.weixin.wfhao.message.request.RequestMessage;
import com.cjmei.module.weixin.wfhao.message.response.ResponseMessage;
import com.cjmei.module.weixin.wfhao.message.response.impl.TextResponseMessage;
import com.cjmei.module.weixin.wfhao.module.Module;

/**
 * 回复文本消息
 * @author lhyan3
 * 2015年7月15日下午2:47:11
 */
public class TextResponseModule extends Module{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1000L;

	@Override
	public ResponseMessage syncRequest(RequestMessage requestMessage) {
		TextResponseMessage textResponseMessage = new TextResponseMessage(requestMessage);
		textResponseMessage.setContent(requestMessage.getContent());
		return textResponseMessage;
	}

	@Override
	public String getOperate() {
		return "回复文本消息";
	}

}
