package com.cjmei.module.weixin.wfhao.message;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.cjmei.module.weixin.wfhao.message.request.RequestMessage;
import com.cjmei.module.weixin.wfhao.message.request.impl.ClickEventRequestMessage;
import com.cjmei.module.weixin.wfhao.message.request.impl.DefaultEventRequestMessage;
import com.cjmei.module.weixin.wfhao.message.request.impl.DefaultRequestMessage;
import com.cjmei.module.weixin.wfhao.message.request.impl.ImageRequestMessage;
import com.cjmei.module.weixin.wfhao.message.request.impl.LinkRequestMessage;
import com.cjmei.module.weixin.wfhao.message.request.impl.LocationEventRequestMessage;
import com.cjmei.module.weixin.wfhao.message.request.impl.LocationRequestMessage;
import com.cjmei.module.weixin.wfhao.message.request.impl.ScanEventRequestMessage;
import com.cjmei.module.weixin.wfhao.message.request.impl.SubscribeEventRequestMessage;
import com.cjmei.module.weixin.wfhao.message.request.impl.TextRequestMessage;
import com.cjmei.module.weixin.wfhao.message.request.impl.VideoRequestMessage;
import com.cjmei.module.weixin.wfhao.message.request.impl.ViewEventRequestMessage;
import com.cjmei.module.weixin.wfhao.message.request.impl.VoiceRequestMessage;

/**
 * 微信服务器发送的XML到对象的转化
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class MessageConverter {
	
	private static Logger logger = Logger.getLogger(MessageConverter.class);
	
	/**
	 * 将xml转换为请求消息对象
	 * @param accountid
	 * @param xml
	 * @return
	 */
	public static RequestMessage convertMessage(String accountid,String xml){
		RequestMessage returnRequestMessage = null;
		
		try {
			Document doc = DocumentHelper.parseText(xml);
			String MsgType = ((Element)doc.selectNodes("/xml/MsgType").get(0)).getText();
			//判断消息类型
			if(MsgType.equalsIgnoreCase("event")){
				//事件
				String event = ((Element) doc.selectNodes("/xml/Event").get(0)).getText();
				
				//判断事件消息类型
				if(event.equalsIgnoreCase("click")){
					returnRequestMessage =  new ClickEventRequestMessage(accountid,doc);
				}else if(event.equalsIgnoreCase("view")){
					returnRequestMessage =  new ViewEventRequestMessage(accountid,doc);
				}else if(event.equalsIgnoreCase("subscribe") || event.equalsIgnoreCase("unsubscribe")){
					returnRequestMessage =  new SubscribeEventRequestMessage(accountid,doc);
				}else if(event.equalsIgnoreCase("scan")){
					returnRequestMessage = new ScanEventRequestMessage(accountid, doc);
				}else if(event.equalsIgnoreCase("location")){
					returnRequestMessage = new LocationEventRequestMessage(accountid, doc);
				}else{
					returnRequestMessage = new DefaultEventRequestMessage(accountid,doc);
				}
			}else{
				//普通消息
			
					//正常接受普通消息
					if(MsgType.equalsIgnoreCase("text")){
						returnRequestMessage = new TextRequestMessage(accountid,doc);
					}else if(MsgType.equalsIgnoreCase("voice")){
						returnRequestMessage=new VoiceRequestMessage(accountid,doc);
					}else if(MsgType.equalsIgnoreCase("location")){
						returnRequestMessage = new LocationRequestMessage(accountid,doc);
					}else if(MsgType.equalsIgnoreCase("image")){
						returnRequestMessage = new ImageRequestMessage(accountid,doc);
					}else if(MsgType.equalsIgnoreCase("link")){
						returnRequestMessage = new LinkRequestMessage(accountid,doc);
					}else if(MsgType.equalsIgnoreCase("video")){
						returnRequestMessage = new VideoRequestMessage(accountid,doc);
					}else{
						returnRequestMessage = new DefaultRequestMessage(accountid,doc);
					}
				
			}
		} catch (DocumentException e) {
			logger.error("parse error\n"+xml,e);
		}

		return returnRequestMessage;
	}
}
