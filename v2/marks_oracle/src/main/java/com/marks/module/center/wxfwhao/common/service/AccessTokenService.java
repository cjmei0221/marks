package com.marks.module.center.wxfwhao.common.service;

import com.marks.module.center.wxfwhao.common.entity.AccessTokenVo;

public interface AccessTokenService {
	public void saveOrUpdateAccessTokenVo(AccessTokenVo vo);
	public AccessTokenVo getAccessTokenVoByAccountid(String accountid);
}
