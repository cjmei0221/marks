package com.marks.smart.wx.manage.mp.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.wx.api.mp.wxInteface.user.entity.WxUser;
@MapperScan
public interface WxUserDao {

	WxUser findById(@Param("accountid") String accountid,@Param("openid") String openid);

	void save(WxUser wxUser);

	void update(WxUser wxUser);

	void delete(String openid);

	List<WxUser> findAll();

	void deleteBatch(List<String> list);

	List<WxUser> list(PageBounds pageBounds, Map<String,Object> param);

	List<WxUser> findWxUserListForDairy();

	void udateDairyFlag( @Param("openid")String openid, @Param("dairyFlag")int dairyFlag);

}