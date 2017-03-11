package com.marks.module.wx.wfhao.dao;

import org.apache.ibatis.annotations.Param;

import com.marks.module.wx.wfhao.pojo.WxMenu;

public interface WxMenuDao {

	WxMenu queryMenuById( @Param("id")String id);

}
