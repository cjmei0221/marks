/**
 * 
 */
package com.marks.smart.wx.manage.web.event;

/**
 * 微信消息类型,大小写对应微信接口，msgType的枚举值
 * @author ChengNing
 * @date   2014-12-4
 */
public enum MType {
	event,        //事件
	text,         //文本消息
	image,
	location,
	link,
	voice,
	video,
	shortvideo,	  //小视频消息
	music,
	news,
	transfer_customer_service;//客服系统
}
