package com.marks.module.wx.api.mp.base.service;

import com.marks.module.wx.api.mp.base.entity.AccessTokenVo;

public interface AccessTokenService {
	public void saveOrUpdateAccessTokenVo(AccessTokenVo vo);
	public AccessTokenVo getAccessTokenVoByAccountid(String accountid);
}
