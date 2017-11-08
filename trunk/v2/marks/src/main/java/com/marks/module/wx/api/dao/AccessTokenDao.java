package com.marks.module.wx.api.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.marks.module.wx.api.wxInterface.mp.base.entity.AccessTokenVo;

@MapperScan
public interface AccessTokenDao {
	
	public AccessTokenVo getAccessTokenVoByAccountid(@Param("accountid")String accountid);

	public void updateAccessTokenVo(@Param("vo")AccessTokenVo vo);

	public void saveAccessTokenVo(@Param("vo")AccessTokenVo vo);
}
