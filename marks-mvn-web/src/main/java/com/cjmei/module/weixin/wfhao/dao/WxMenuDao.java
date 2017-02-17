package com.cjmei.module.weixin.wfhao.dao;

import org.apache.ibatis.annotations.Param;

import com.cjmei.module.weixin.wfhao.pojo.WxMenu;

public interface WxMenuDao {

	WxMenu queryMenuById( @Param("id")String id);

}
