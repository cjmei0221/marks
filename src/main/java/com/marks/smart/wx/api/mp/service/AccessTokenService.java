package com.marks.smart.wx.api.mp.service;

import com.marks.smart.wx.api.mp.wxInteface.base.entity.AccessTokenVo;

public interface AccessTokenService {
	public void saveOrUpdateAccessTokenVo(AccessTokenVo vo);
	public AccessTokenVo getAccessTokenVoByAccountid(String accountid);
}
