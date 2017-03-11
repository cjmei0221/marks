package com.marks.module.wx.wfhao.service;

import java.sql.Timestamp;

import com.marks.module.wx.wfhao.pojo.WxUser;

public interface WeixinAccountService {

	public WxUser queryWxUserByOpenID(String accountid, String openid);

	public void updateOrUpdateWxUser(WxUser wxUser);
	
	public void updateWxUser(WxUser wxUser);

	public void updateResultForModuleMsg(String accountid,String msgId, Timestamp time, String status);
}
