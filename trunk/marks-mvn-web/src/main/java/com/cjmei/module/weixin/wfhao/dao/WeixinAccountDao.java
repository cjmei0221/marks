package com.cjmei.module.weixin.wfhao.dao;

import org.apache.ibatis.annotations.Param;

import com.cjmei.module.weixin.wfhao.pojo.WxUser;

public interface WeixinAccountDao {

	WxUser queryWxUserByOpenID(@Param("accountid")String accountid, @Param("openid")String openid);

}
