package com.nfb.module.wxfwhao.service;

import com.nfb.module.wxfwhao.entity.AccessTokenVo;

public interface WxAccountService {

	public void loadData();
	public void saveOrUpdateAccessTokenVo(AccessTokenVo vo);
	public AccessTokenVo getAccessTokenVoByAccountid(String accountid);
}
