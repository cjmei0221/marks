package com.marks.module.wxfwhao.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.marks.module.system.core.entity.SysConf;
import com.marks.module.wxfwhao.common.entity.AccessTokenVo;
import com.marks.module.wxfwhao.common.entity.WxAccount;

public interface WxAccountDao {
	
	public List<WxAccount> getWXAccountList();
	
	public AccessTokenVo getAccessTokenVoByAccountid(@Param("accountid")String accountid);

	public void updateAccessTokenVo(@Param("vo")AccessTokenVo vo);

	public void saveAccessTokenVo(@Param("vo")AccessTokenVo vo);

	public List<SysConf> getWxConf();
}
