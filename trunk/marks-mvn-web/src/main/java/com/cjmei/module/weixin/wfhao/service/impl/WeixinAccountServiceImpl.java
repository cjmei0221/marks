package com.cjmei.module.weixin.wfhao.service.impl;

import com.cjmei.module.weixin.wfhao.dao.WeixinAccountDao;
import com.cjmei.module.weixin.wfhao.dao.WxUserDao;
import com.cjmei.module.weixin.wfhao.pojo.WxUser;
import com.cjmei.module.weixin.wfhao.service.WeixinAccountService;

public class WeixinAccountServiceImpl implements WeixinAccountService {

	private WeixinAccountDao weixinAccountDao;
	private WxUserDao wxUserDao;

	public void setWeixinAccountDao(WeixinAccountDao weixinAccountDao) {
		this.weixinAccountDao = weixinAccountDao;
	}

	public void setWxUserDao(WxUserDao wxUserDao) {
		this.wxUserDao = wxUserDao;
	}

	@Override
	public WxUser queryWxUserByOpenID(String accountid, String openid) {
		return weixinAccountDao.queryWxUserByOpenID(accountid, openid);
	}

	@Override
	public void updateOrUpdateWxUser(WxUser wxUser) {
		WxUser wx = weixinAccountDao.queryWxUserByOpenID(wxUser.getAccountid(), wxUser.getOpenid());
		if (wx == null) {
			wxUser.setUseflag(1);
			wxUserDao.save(wxUser);
		} else {
			wxUserDao.update(wxUser);
		}
	}

	@Override
	public void updateWxUser(WxUser wxUser) {
		wxUserDao.update(wxUser);
	}

}
