package com.marks.module.weixin.wfhao.dao;


import org.apache.ibatis.annotations.Param;

import com.marks.module.weixin.wfhao.pojo.WxUser;

public interface WxUserDao {


	void save(WxUser wxUser);

	void update(WxUser wxUser);

	void updateFanIdForWxUser(@Param("accountid")String accountid, @Param("openid")String openid);

}