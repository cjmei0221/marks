package com.marks.module.acct.info.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.acct.info.pojo.AcctInfo;

@MapperScan
public interface AcctInfoDao {

	AcctInfo findById(@Param("userid") String userid);

	void save(@Param("info") AcctInfo acctInfo);
	
	void saveBatch(@Param("list") List<AcctInfo> list);

	void update(@Param("info") AcctInfo acctInfo);
	
//	void updateBatch(@Param("list") List<AcctInfo> list);

	void delete(@Param("userid") String userid);

	List<AcctInfo> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<AcctInfo> list(PageBounds pageBounds, Map<String,Object> param);
}