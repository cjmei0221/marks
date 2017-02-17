package com.marks.module.weixin.wfhao.dao;

import org.apache.ibatis.annotations.Param;

import com.marks.module.weixin.wfhao.pojo.WxUser;

public interface WeixinAccountDao {

	WxUser queryWxUserByOpenID(@Param("accountid")String accountid, @Param("openid")String openid);

}
