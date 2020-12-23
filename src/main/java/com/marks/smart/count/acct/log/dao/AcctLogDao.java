package com.marks.smart.count.acct.log.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.count.acct.log.pojo.AcctLog;

@MapperScan
public interface AcctLogDao {

	AcctLog findById(@Param("id") String id);

	void save(@Param("info") AcctLog acctLog);
	void delete(@Param("id") String id);

	List<AcctLog> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<AcctLog> list(PageBounds pageBounds, Map<String,Object> param);
}