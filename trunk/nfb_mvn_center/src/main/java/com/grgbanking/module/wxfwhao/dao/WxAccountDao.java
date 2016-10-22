package com.grgbanking.module.wxfwhao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.grgbanking.module.wxfwhao.entity.AccessTokenVo;
import com.grgbanking.module.wxfwhao.entity.WxAccount;

public interface WxAccountDao {
	
	public List<WxAccount> getWXAccountList();
	
	public AccessTokenVo getAccessTokenVoByAccountid(@Param("accountid")String accountid);

	public void updateAccessTokenVo(@Param("vo")AccessTokenVo vo);

	public void saveAccessTokenVo(@Param("vo")AccessTokenVo vo);
}
