package com.marks.module.note.vipinfo.dao;


import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import com.marks.module.note.vipinfo.pojo.VipInfo;

public interface VipInfoDao {

	VipInfo findById(String userid);

	void save(VipInfo vipInfo);

	void update(VipInfo vipInfo);

	void delete(String userid);

	List<VipInfo> findAll();

	void deleteBatch(List<String> list);

	List<VipInfo> list(PageBounds pageBounds, Map<String,Object> param);
}