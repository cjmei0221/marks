package com.cjmei.module.weixin.wfhao.message.request.impl;

import org.dom4j.Document;

import com.cjmei.module.weixin.wfhao.message.request.RequestMessage;

/**
 * 点击菜单拉取消息事件类型请求消息
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class DefaultRequestMessage extends RequestMessage{	
	
	/**
	 * 构造方法
	 * @param xmlDoc
	 */
	public DefaultRequestMessage(String accountid,Document xmlDoc){
		super(accountid,xmlDoc);	
	}

	@Override
	protected void toString(StringBuilder out) {
		// TODO Auto-generated method stub
		
	}	
}
