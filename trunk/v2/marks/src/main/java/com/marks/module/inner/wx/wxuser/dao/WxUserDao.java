package com.marks.module.inner.wx.wxuser.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.center.wxfwhao.common.entity.WxUser;

public interface WxUserDao {

	WxUser findById(String accountid,String openid);

	void save(WxUser wxUser);

	void update(WxUser wxUser);

	void delete(String openid);

	List<WxUser> findAll();

	void deleteBatch(List<String> list);

	List<WxUser> list(PageBounds pageBounds, Map<String,Object> param);

	List<WxUser> findWxUserListForDairy();

	void udateDairyFlag( @Param("openid")String openid, @Param("dairyFlag")int dairyFlag);

}