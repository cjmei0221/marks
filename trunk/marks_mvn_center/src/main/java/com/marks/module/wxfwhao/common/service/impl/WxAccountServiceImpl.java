package com.marks.module.wxfwhao.common.service.impl;

import java.util.List;

import com.marks.module.system.core.data.WeChatAccountHelper;
import com.marks.module.wxfwhao.common.dao.WxAccountDao;
import com.marks.module.wxfwhao.common.entity.AccessTokenVo;
import com.marks.module.wxfwhao.common.entity.WxAccount;
import com.marks.module.wxfwhao.common.service.WxAccountService;

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
