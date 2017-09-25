package com.marks.module.wx.api.wxfwhao.common.service;

import com.marks.module.wx.api.wxfwhao.common.entity.AccessTokenVo;

public interface AccessTokenService {
	public void saveOrUpdateAccessTokenVo(AccessTokenVo vo);
	public AccessTokenVo getAccessTokenVoByAccountid(String accountid);
}
