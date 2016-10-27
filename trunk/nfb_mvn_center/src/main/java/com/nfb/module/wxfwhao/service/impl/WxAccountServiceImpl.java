package com.nfb.module.wxfwhao.service.impl;

import java.util.List;

import com.nfb.module.system.data.WeChatAccountHelper;
import com.nfb.module.wxfwhao.dao.WxAccountDao;
import com.nfb.module.wxfwhao.entity.AccessTokenVo;
import com.nfb.module.wxfwhao.entity.WxAccount;
import com.nfb.module.wxfwhao.service.WxAccountService;

public class WxAccountServiceImpl implements WxAccountService {
	
	private WxAccountDao wxAccountDao;

	public WxAccountDao getWxAccountDao() {
		return wxAccountDao;
	}

	public void setWxAccountDao(WxAccountDao wxAccountDao) {
		this.wxAccountDao = wxAccountDao;
	}

	public void loadData() {
		List<WxAccount> list=wxAccountDao.getWXAccountList();
		for(WxAccount account:list){
			WeChatAccountHelper.put(account);
		}
	}

	public void saveOrUpdateAccessTokenVo(AccessTokenVo vo) {
		AccessTokenVo old=wxAccountDao.getAccessTokenVoByAccountid(vo.getAccountid());
		if(null !=old){
			wxAccountDao.updateAccessTokenVo(vo);
		}else{
			wxAccountDao.saveAccessTokenVo(vo);
		}
	}

	public AccessTokenVo getAccessTokenVoByAccountid(String accountid) {
		return wxAccountDao.getAccessTokenVoByAccountid(accountid);
	}
	
	

}
