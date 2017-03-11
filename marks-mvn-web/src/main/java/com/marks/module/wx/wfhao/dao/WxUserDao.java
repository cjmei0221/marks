package com.marks.module.wx.wfhao.dao;


import org.apache.ibatis.annotations.Param;

import com.marks.module.wx.wfhao.pojo.WxUser;

public interface WxUserDao {


	void save(WxUser wxUser);

	void update(WxUser wxUser);

	void updateFanIdForWxUser(@Param("accountid")String accountid, @Param("openid")String openid,@Param("fanId") String fanId);
	
	String getFanId();
}