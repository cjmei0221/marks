package com.marks.module.wx.api.service;

import com.marks.module.wx.api.wxInterface.mp.base.entity.AccessTokenVo;

public interface AccessTokenService {
	public void saveOrUpdateAccessTokenVo(AccessTokenVo vo);
	public AccessTokenVo getAccessTokenVoByAccountid(String accountid);
}
