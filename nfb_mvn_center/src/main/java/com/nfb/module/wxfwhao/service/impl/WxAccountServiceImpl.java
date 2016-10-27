package com.nfb.module.wxfwhao.service.impl;

import java.util.List;

import com.nfb.module.system.data.WeChatAccountHelper;
import com.nfb.module.wxfwhao.dao.WxAccountDao;
import com.nfb.module.wxfwhao.entity.AccessTokenVo;
import com.nfb.module.wxfwhao.entity.WxAccount;
import com.nfb.module.wxfwhao.service.WxAccountService;

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
