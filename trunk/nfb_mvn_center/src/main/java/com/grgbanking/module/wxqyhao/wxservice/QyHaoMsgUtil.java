package com.grgbanking.module.wxqyhao.wxservice;

import org.json.JSONException;
import org.json.JSONObject;

import com.grgbanking.common.util.JsonResult;
import com.grgbanking.common.util.SysCode;
import com.grgbanking.module.wxqyhao.entity.QyHaoMsg;
import com.grgbanking.module.wxqyhao.util.QyAccessTokenUtil;
import com.grgbanking.module.wxqyhao.util.WxQyHttpUtils;
import com.grgbanking.module.wxqyhao.util.WxqyConfig;

public class QyHaoMsgUtil {
	// 通知企业号用户
	public static JsonResult sendQyMsg(QyHaoMsg qyHaoMsg, String qyAccount) throws Exception {
		JSONObject objx = new JSONObject();
		JsonResult result = new JsonResult();
		try {
			objx.accumulate("agentid", qyHaoMsg.getAgentid());
			objx.accumulate("touser", qyHaoMsg.getTouser());
			objx.accumulate("msgtype", qyHaoMsg.getMsgtype());
			objx.accumulate("toparty", qyHaoMsg.getToparty());
			objx.accumulate("totag", qyHaoMsg.getTotag());
			objx.accumulate("safe", qyHaoMsg.getSafe());
			objx.accumulate("text", new JSONObject().accumulate("content", qyHaoMsg.getContent()));
		} catch (JSONException e) {

		}

		String url = WxqyConfig.qyhao_sendmsg;
		url = url + QyAccessTokenUtil.getInstance().getQyAccessToken(qyAccount);
		result = WxQyHttpUtils.doPostJson(qyAccount, url, objx, null);
		if (SysCode.C9980.equals(result.getErrorCode())) {
			sendQyMsg(qyHaoMsg, qyAccount);
		}
		return result;
	}
}
