package com.marks.module.center.wxfwhao.common.dao;

import org.apache.ibatis.annotations.Param;

import com.marks.module.center.wxfwhao.common.entity.AccessTokenVo;

public interface AccessTokenDao {
	
	public AccessTokenVo getAccessTokenVoByAccountid(@Param("accountid")String accountid);

	public void updateAccessTokenVo(@Param("vo")AccessTokenVo vo);

	public void saveAccessTokenVo(@Param("vo")AccessTokenVo vo);
}
