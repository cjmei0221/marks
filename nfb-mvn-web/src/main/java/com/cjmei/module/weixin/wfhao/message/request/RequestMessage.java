package com.cjmei.module.weixin.wfhao.message.request;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Node;

import com.cjmei.module.system.core.listener.DatabaseHelper;
import com.cjmei.module.weixin.wfhao.dao.WeixinAccountDao;
import com.cjmei.module.weixin.wfhao.message.Message;
import com.cjmei.module.weixin.wfhao.pojo.WxUser;
import com.cjmei.module.weixin.wfhao.threadPool.UpdateWxUserhreadPool;

/**
 * 请求类型消息的抽象类，请求类型的消息必须实现该抽象类。
 * 
 * @author
 * @createTime
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public abstract class RequestMessage extends Message {

	private static Log log = LogFactory.getLog(RequestMessage.class);

	private static final long USERINFO_UPDATE_TIME = 7 * 24 * 60 * 60 * 1000L;

	protected String localAddr;

	protected String firstSubscribeflag = "N";// 首次关注标识 N:不是首次关注 Y:是首次关注

	/**
	 * 构造方法
	 * 
	 * @param accountId
	 * @param xmlDoc
	 */
	public RequestMessage(String accountId, Document xmlDoc) {
		this.accountId = accountId;
		this.toUserName = xmlDoc.selectSingleNode("/xml/ToUserName").getText();
		this.fromUserName = xmlDoc.selectSingleNode("/xml/FromUserName").getText();
		Node nd = xmlDoc.selectSingleNode("/xml/MsgId");
		if (nd != null) {
			this.msgId = nd.getText();
		}
		this.msgType = xmlDoc.selectSingleNode("/xml/MsgType").getText();
		this.content = xmlDoc.selectSingleNode("/xml/Content") == null ? ""
				: xmlDoc.selectSingleNode("/xml/Content").getText();
		this.PicUrl = xmlDoc.selectSingleNode("/xml/PicUrl") == null ? ""
				: xmlDoc.selectSingleNode("/xml/PicUrl").getText();
		this.MediaId = xmlDoc.selectSingleNode("/xml/MediaId") == null ? ""
				: xmlDoc.selectSingleNode("/xml/MediaId").getText();

		try {

			WeixinAccountDao weixinAccountDao = (WeixinAccountDao) DatabaseHelper.getBean(WeixinAccountDao.class);

			WxUser user = weixinAccountDao.queryWxUserByOpenID(accountId, fromUserName);
			Node node = xmlDoc.selectSingleNode("/xml/Event");
			boolean subs = true;
			if (node != null) {
				// 关注/取消事件
				if ("subscribe".equalsIgnoreCase(node.getText()) || "unsubscribe".equalsIgnoreCase(node.getText())) {
					log.info("关注/取消事件");
					subs = false;
					if (user == null) {
						firstSubscribeflag = "Y";
					}
				}
			}
			// 非关注/取消事件
			if (subs) {
				log.info("非关注/取消事件");
				if (user == null) {
					log.info("user is null");
					user = new WxUser();
					user.setOpenid(fromUserName);
					user.setAccountid(accountId);
					UpdateWxUserhreadPool.updateWxUser(accountId, fromUserName);
				} else if (System.currentTimeMillis() - user.getUpdatetime().getTime() > USERINFO_UPDATE_TIME
						|| user.getUpdatetime() == null || user.getIssubscribe() == 0) {// 超过7天，更新一次用户信息
					log.info("超过7天，更新一次用户信息");
					UpdateWxUserhreadPool.updateWxUser(accountId, fromUserName);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	/**
	 * 获取属性：请求的地址(IP)
	 * 
	 * @return
	 */
	public String getLocalAddr() {
		return localAddr;
	}

	/**
	 * 设置属性：请求的地址(IP)
	 * 
	 * @param localAddr
	 */
	public void setLocalAddr(String localAddr) {
		this.localAddr = localAddr;
	}

	/**
	 * 获取消息渠道
	 */
	@Override
	protected int getUserSend() {
		return 1;
	}

	/**
	 * 转换为xml字符串
	 */
	@Override
	public final String toString() {
		StringBuilder out = new StringBuilder();
		out.append("\n<xml>\n");
		out.append("	<ToUserName>").append(this.toUserName).append("</ToUserName>\n");
		out.append("	<FromUserName>").append(this.fromUserName).append("</FromUserName>\n");
		out.append("	<MsgId>").append(this.msgId).append("</MsgId>\n");
		out.append("	<MsgType>").append(this.msgType).append("</MsgType>\n");
		out.append("	<PicUrl>").append(this.PicUrl).append("</PicUrl>\n");
		out.append("	<CreateTime>").append(this.getCreateTime().getTime()).append("</CreateTime>\n");
		out.append("	<MediaId>").append(this.MediaId).append("</MediaId>\n");
		this.toString(out);
		out.append("</xml>\n");
		return out.toString();
	}

	/**
	 * 转换为xml字符串
	 * 
	 * @param out
	 */
	protected abstract void toString(StringBuilder out);

	public String getFirstSubscribeflag() {
		return firstSubscribeflag;
	}

	public void setFirstSubscribeflag(String firstSubscribeflag) {
		this.firstSubscribeflag = firstSubscribeflag;
	}

}
