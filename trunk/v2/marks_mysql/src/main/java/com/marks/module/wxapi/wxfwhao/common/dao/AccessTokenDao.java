package com.marks.module.wxapi.wxfwhao.common.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.marks.module.wxapi.wxfwhao.common.entity.AccessTokenVo;

@MapperScan
public interface AccessTokenDao {
	
	public AccessTokenVo getAccessTokenVoByAccountid(@Param("accountid")String accountid);

	public void updateAccessTokenVo(@Param("vo")AccessTokenVo vo);

	public void saveAccessTokenVo(@Param("vo")AccessTokenVo vo);
}
