package com.grgbanking.module.wxfwhao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.grgbanking.module.wxfwhao.entity.AccessTokenVo;
import com.grgbanking.module.wxfwhao.entity.WeChatAccount;

public interface WeixinAccountDao {
	
	public List<WeChatAccount> getWXAccountList();
	
	public AccessTokenVo getAccessTokenVoByAccountid(@Param("accountid")String accountid);

	public void updateAccessTokenVo(@Param("vo")AccessTokenVo vo);

	public void saveAccessTokenVo(@Param("vo")AccessTokenVo vo);
}
