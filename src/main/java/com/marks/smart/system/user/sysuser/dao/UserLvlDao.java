package com.marks.smart.system.user.sysuser.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.system.user.sysuser.pojo.UserLvl;

@MapperScan
public interface UserLvlDao {

	UserLvl findById(@Param("lvlId") String lvlId);

	void save(@Param("info") UserLvl userLvl);
	
	void saveBatch(@Param("list") List<UserLvl> list);

	void update(@Param("info") UserLvl userLvl);
	
//	void updateBatch(@Param("list") List<UserLvl> list);

	void delete(@Param("lvlId") String lvlId);

	List<UserLvl> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<UserLvl> list(PageBounds pageBounds, Map<String,Object> param);
}