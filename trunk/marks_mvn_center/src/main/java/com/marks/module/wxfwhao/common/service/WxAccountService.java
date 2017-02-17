package com.marks.module.wxfwhao.common.service;

import com.marks.module.wxfwhao.common.entity.AccessTokenVo;

public interface WxAccountService {

	public void loadData();
	public void saveOrUpdateAccessTokenVo(AccessTokenVo vo);
	public AccessTokenVo getAccessTokenVoByAccountid(String accountid);
}
