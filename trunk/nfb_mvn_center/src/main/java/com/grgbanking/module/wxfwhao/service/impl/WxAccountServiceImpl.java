package com.grgbanking.module.wxfwhao.service.impl;

import java.util.List;

import com.grgbanking.module.system.data.WeChatAccountHelper;
import com.grgbanking.module.wxfwhao.dao.WxAccountDao;
import com.grgbanking.module.wxfwhao.entity.AccessTokenVo;
import com.grgbanking.module.wxfwhao.entity.WxAccount;
import com.grgbanking.module.wxfwhao.service.WxAccountService;

public class WxAccountServiceImpl implements WxAccountService {
	
	private WxAccountDao WxAccountDao;

	public WxAccountDao getWxAccountDao() {
		return WxAccountDao;
	}

	public void setWxAccountDao(WxAccountDao wxAccountDao) {
		WxAccountDao = wxAccountDao;
	}

	public void loadData() {
		List<WxAccount> list=WxAccountDao.getWXAccountList();
		for(WxAccount account:list){
			WeChatAccountHelper.put(account);
		}
	}

	public void saveOrUpdateAccessTokenVo(AccessTokenVo vo) {
		AccessTokenVo old=WxAccountDao.getAccessTokenVoByAccountid(vo.getAccountid());
		if(null !=old){
			WxAccountDao.updateAccessTokenVo(vo);
		}else{
			WxAccountDao.saveAccessTokenVo(vo);
		}
	}

	public AccessTokenVo getAccessTokenVoByAccountid(String accountid) {
		return WxAccountDao.getAccessTokenVoByAccountid(accountid);
	}
	
	

}
