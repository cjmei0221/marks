package com.marks.module.wxapi.wxfwhao.common.service;

import com.marks.module.wxapi.wxfwhao.common.entity.AccessTokenVo;

public interface AccessTokenService {
	public void saveOrUpdateAccessTokenVo(AccessTokenVo vo);
	public AccessTokenVo getAccessTokenVoByAccountid(String accountid);
}
