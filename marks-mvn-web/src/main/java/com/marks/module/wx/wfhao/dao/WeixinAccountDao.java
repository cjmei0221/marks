package com.marks.module.wx.wfhao.dao;

import java.sql.Timestamp;

import org.apache.ibatis.annotations.Param;

import com.marks.module.wx.wfhao.pojo.WxUser;

public interface WeixinAccountDao {

	WxUser queryWxUserByOpenID(@Param("accountid") String accountid, @Param("openid") String openid);

	void updateResultForModuleMsg(@Param("accountid") String accountid, @Param("msgId") String msgId,@Param("createtime") Timestamp createtime,@Param("resultCode") String resultCode,
			@Param("status")String status);

}
