package com.marks.module.inner.wx.modulemsg.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.marks.common.domain.JsonResult;
import com.marks.common.domain.Result;
import com.marks.common.util.center.SysCode;
import com.marks.module.center.wxfwhao.common.wxservice.SendMsgUtils;
import com.marks.module.inner.wx.modulemsg.dao.ModuleMsgDao;
import com.marks.module.inner.wx.modulemsg.pojo.ModuleContentMsg;
import com.marks.module.inner.wx.modulemsg.pojo.ModuleMsg;
import com.marks.module.inner.wx.modulemsg.pojo.Msg;
import com.marks.module.inner.wx.modulemsg.pojo.WxMsg;
import com.marks.module.inner.wx.wxtemplate.dao.WxTemplateDao;
import com.marks.module.inner.wx.wxtemplate.pojo.WxTemplate;
import com.marks.module.sys.system.core.common.SpringContextHolder;

/**
 * 微信模版消息推送工具类
 * 
 * @author cjmei
 *
 */
public class WxMsgUtil {
	private static Logger logger = Logger.getLogger(WxMsgUtil.class);
	private WxTemplateDao wxTemplateDao = SpringContextHolder.getBean(WxTemplateDao.class);
	private ModuleMsgDao moduleMsgDao = SpringContextHolder.getBean(ModuleMsgDao.class);
	private static WxMsgUtil util = null;

	private WxMsgUtil() {
	}

	public static WxMsgUtil getInstance() {
		if (util == null) {
			util = new WxMsgUtil();
		}
		return util;
	}

	/**
	 * key为keyword1、2等微信模版消息推送入口
	 * 
	 * @param accountid
	 * @param tempType
	 * @param openidList
	 * @param keywordList keyword 列表
	 * @param note
	 * @param isLiji
	 *            true 立即推送 false 延迟推送
	 * @return
	 */
	public Result pushModuleMsgByKeywordList(boolean isLiji, String accountid, String tempType, List<String> openidList,
			List<String> keywordList, String note) {
		Result result = new Result();
		List<Msg> msgList = new ArrayList<Msg>();
		if (keywordList.size() > 0) {
			Msg msg=new Msg();
			for (int i = 0; i < keywordList.size(); i++) {
				msg.setKey("keyword" + (i + 1));
				msg.setValue(keywordList.get(i));
				msgList.add(msg);
			}
			result=pushModuleMsgByMsgList(isLiji,  accountid,  tempType, openidList,
					msgList,  note);
		}else{
			result.setCode("4003");
			result.setMessage("模版内容为空");
			logger.info("模版内容为空");
		}

		return result;
	}
	/**
	 * key自定义微信模版消息入口
	 * @param isLiji
	 * @param accountid
	 * @param tempType
	 * @param openidList
	 * @param msgList
	 * @param note
	 * @return
	 */
	public Result pushModuleMsgByMsgList(boolean isLiji, String accountid, String tempType, List<String> openidList,
			List<Msg> msgList, String note) {
		Result result = new Result();
		if (null != openidList && openidList.size() > 0) {
			WxTemplate temp = wxTemplateDao.findById(tempType, accountid);
			if (null != temp) {
				for (String openid : openidList) {

					String firstMsg = temp.getFirst_content();
					String remarkMsg = temp.getRemark_content();
					String detailUrl = temp.getDetailUrl();
					ModuleContentMsg wxMsg = new ModuleContentMsg();
					wxMsg.setFirst(firstMsg);
					wxMsg.setRemark(remarkMsg);

					wxMsg.setKeywordList(msgList);

					ModuleMsg mmsg = new ModuleMsg();
					mmsg.setAccountid(accountid);
					mmsg.setCreatetime(new Date());
					mmsg.setData(wxMsg.toJsonStringByKey());
					mmsg.setNote(note + " " + temp.getTemplate_name());
					mmsg.setTemplate_id(temp.getTemplate_id());
					mmsg.setTouser(openid);
					mmsg.setUrl(detailUrl);
					pustModuleMsg(mmsg, isLiji);
				}
			} else {
				result.setCode("4002");
				result.setMessage("模板不存在");
				logger.info("模板不存在");
			}
		} else {
			logger.info("openid 为空");
		}

		return result;
	}

	/**
	 * 保存或立即推送模版消息
	 * 
	 * @param mmsg
	 * @param b
	 *            true 立即推送 false 稍后推送
	 */
	private void pustModuleMsg(ModuleMsg mmsg, boolean b) {
		mmsg.setNeedFlag(1);
		mmsg.setSendFlag(0);
		mmsg.setSendTimes(0);
		mmsg.setCreate_stamp(System.currentTimeMillis() / 1000);
		if (b) {
			this.sendTemplateMsg(mmsg.getAccountid(), mmsg.getTouser(), mmsg.getTemplate_id(), mmsg.getUrl(),
					mmsg.getData(), mmsg.getNote());
		} else {
			this.moduleMsgDao.save(mmsg);
		}
	}
	/**
	 * 调用接口推送消息
	 * @param accountid
	 * @param toUser
	 * @param templateCode
	 * @param url
	 * @param data
	 * @param note
	 * @return
	 */
	public JsonResult sendTemplateMsg(String accountid, String toUser, String templateCode, String url, String data,
			String note) {
		JsonResult result = SendMsgUtils.getInstance().sendTemplateMsg(accountid, toUser, templateCode, url, data);
		ModuleMsg msg = new ModuleMsg();
		int isSend = 0;// 未发送
		String msgid = "";
		if (SysCode.SUCCESS.equals(result.getErrorCode())) {
			msgid = String.valueOf(result.getResult());
			isSend = 1;// 发送成功
		} else {
			isSend = 2;// 发送失败
		}
		msg.setSendFlag(isSend);
		msg.setMsgId(msgid);
		msg.setPush_code(result.getErrorCode());
		msg.setPush_msg(result.getErrorMsg());
		msg.setSendTimes(1);

		msg.setAccountid(accountid);
		msg.setData(data);
		msg.setNeedFlag(1);
		msg.setTemplate_id(templateCode);
		msg.setTouser(toUser);
		msg.setUrl(url);
		msg.setNote(note);
		msg.setCreate_stamp(System.currentTimeMillis() / 1000);
		moduleMsgDao.save(msg);
		result.setErrorCode(SysCode.SUCCESS);
		result.setErrorMsg("已推送，若未推送成功，将启动定时器，进行推送，共推送3次");
		return result;
	}

}
