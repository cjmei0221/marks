package com.marks.smart.wx.manage.mp.service;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.JsonResult;
import com.marks.common.domain.Result;
import com.marks.smart.wx.manage.mp.entity.Msg;

public interface TemplateMsgService {

	/**
	 * 
	 * @param isLiji
	 *            是否立即发送
	 * @param accountid
	 *            公众号ID
	 * @param tempType
	 *            模版主键
	 * @param openidList
	 *            用户集合
	 * @param keywordList
	 * @param note
	 *            备注
	 * @param replaceParams
	 *            替换参数
	 * @return
	 */
	public Result pushModuleMsgByKeywordList(boolean isLiji, String accountid, String tempType, List<String> openidList,
			List<String> keywordList, String note, Map<String, String> replaceParams);

	/**
	 * 
	 * @param isLiji
	 *            是否立即发送
	 * @param accountid
	 *            公众号ID
	 * @param tempType
	 *            模版主键
	 * @param openidList
	 *            用户集合
	 * @param keywordList
	 * @param note
	 *            备注
	 * @param replaceParams
	 *            替换参数
	 * @return
	 */
	public Result pushModuleMsgByMsgList(boolean isLiji, String accountid, String tempType, List<String> openidList,
			List<Msg> msgList, String note, Map<String, String> replaceParams);

	public JsonResult sendTemplateMsg(String accountid, String toUser, String templateCode, String url, String data,
			String note);
}
