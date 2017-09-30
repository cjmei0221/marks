package com.marks.module.wx.manage.msg.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.wx.manage.msg.pojo.WxAutoReplay;
@MapperScan
public interface WxAutoReplayDao {

	WxAutoReplay findById(String cparentType);

	void save(WxAutoReplay wxAutoReplay);

	void update(WxAutoReplay wxAutoReplay);

	void delete(String cparentType);

	List<WxAutoReplay> findAll();

	void deleteBatch(List<String> list);

	List<WxAutoReplay> list(PageBounds pageBounds, Map<String,Object> param);

	List<WxAutoReplay> findByCkey(@Param("ckey") String ckey, @Param("ckeyName") String ckeyName,
			@Param("accountid") String accountid);

	List<WxAutoReplay> getWxAutoReplayByKey(@Param("ckey")String ckey, @Param("accountId")String accountId);

	String getKeyCode(@Param("accountid") String accountid);
}