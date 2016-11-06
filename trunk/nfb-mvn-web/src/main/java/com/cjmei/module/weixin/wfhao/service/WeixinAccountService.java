package com.cjmei.module.weixin.wfhao.service;

import com.cjmei.module.weixin.wfhao.pojo.WxUser;

public interface WeixinAccountService {

	public WxUser queryWxUserByOpenID(String accountid, String openid);

	public void updateOrUpdateWxUser(WxUser wxUser);
	
	public void updateWxUser(WxUser wxUser);
}
