package com.marks.module.acct.info.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.acct.info.pojo.AcctPoint;

@MapperScan
public interface AcctPointDao {

	AcctPoint findById(@Param("userid") String userid);

	void save(@Param("info") AcctPoint acctPoint);
	
	void saveBatch(@Param("list") List<AcctPoint> list);

	void update(@Param("info") AcctPoint acctPoint);
	
//	void updateBatch(@Param("list") List<AcctPoint> list);

	void delete(@Param("userid") String userid);

	List<AcctPoint> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<AcctPoint> list(PageBounds pageBounds, Map<String,Object> param);
}