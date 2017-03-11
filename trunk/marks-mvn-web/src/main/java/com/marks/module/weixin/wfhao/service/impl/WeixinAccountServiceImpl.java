package com.marks.module.weixin.wfhao.service.impl;

import java.sql.Timestamp;

import com.marks.module.weixin.wfhao.dao.WeixinAccountDao;
import com.marks.module.weixin.wfhao.dao.WxUserDao;
import com.marks.module.weixin.wfhao.pojo.WxUser;
import com.marks.module.weixin.wfhao.service.WeixinAccountService;

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
		WxUser old = weixinAccountDao.queryWxUserByOpenID(wxUser.getAccountid(), wxUser.getOpenid());
		if (old == null) {
			wxUser.setUseflag(1);
			wxUserDao.save(wxUser);
		} else {
			wxUserDao.update(wxUser);
			if(null == old.getFanId() || "".equals(old.getFanId())){
				String fanId=wxUserDao.getFanId();
				wxUserDao.updateFanIdForWxUser(wxUser.getAccountid(),wxUser.getOpenid(),fanId);
			}
		}
	}

	@Override
	public void updateWxUser(WxUser wxUser) {
		wxUserDao.update(wxUser);
	}

	@Override
	public void updateResultForModuleMsg(String accountid,String msgId, Timestamp createtime, String status) {
		String resultCode="0";
		if(status.indexOf("success")>=0){
			resultCode="1";
		}
		weixinAccountDao.updateResultForModuleMsg(accountid,msgId,createtime,resultCode,status);
	}
	
	

}
