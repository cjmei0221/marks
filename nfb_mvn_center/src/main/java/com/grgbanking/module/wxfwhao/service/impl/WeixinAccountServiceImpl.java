package com.grgbanking.module.wxfwhao.service.impl;

import java.util.List;

import com.grgbanking.module.system.data.WeChatAccountHelper;
import com.grgbanking.module.wxfwhao.dao.WeixinAccountDao;
import com.grgbanking.module.wxfwhao.entity.AccessTokenVo;
import com.grgbanking.module.wxfwhao.entity.WeChatAccount;
import com.grgbanking.module.wxfwhao.service.WeixinAccountService;

public class WeixinAccountServiceImpl implements WeixinAccountService {
	
	private WeixinAccountDao weixinAccountDao;

	public void setWeixinAccountDao(WeixinAccountDao weixinAccountDao) {
		this.weixinAccountDao = weixinAccountDao;
	}

	public void loadData() {
		List<WeChatAccount> list=weixinAccountDao.getWXAccountList();
		for(WeChatAccount account:list){
			WeChatAccountHelper.put(account);
		}
	}

	public void saveOrUpdateAccessTokenVo(AccessTokenVo vo) {
		AccessTokenVo old=weixinAccountDao.getAccessTokenVoByAccountid(vo.getAccountid());
		if(null !=old){
			weixinAccountDao.updateAccessTokenVo(vo);
		}else{
			weixinAccountDao.saveAccessTokenVo(vo);
		}
	}

	public AccessTokenVo getAccessTokenVoByAccountid(String accountid) {
		return weixinAccountDao.getAccessTokenVoByAccountid(accountid);
	}
	
	

}
