package com.marks.module.user.vipinfo.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.user.vipinfo.pojo.VipInfo;
@MapperScan
public interface VipInfoDao {

	VipInfo findById(String userid);

	void save(VipInfo vipInfo);

	void update(VipInfo vipInfo);

	void delete(String userid);

	List<VipInfo> findAll();

	void deleteBatch(List<String> list);

	List<VipInfo> list(PageBounds pageBounds, Map<String,Object> param);
	VipInfo findVipDetailInfoById(String userid);
}