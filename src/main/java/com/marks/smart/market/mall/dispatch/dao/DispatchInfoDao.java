package com.marks.smart.market.mall.dispatch.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.market.mall.dispatch.pojo.DispatchInfo;

@MapperScan
public interface DispatchInfoDao {

	DispatchInfo findById(@Param("orderId") String orderId);

	void save(@Param("info") DispatchInfo dispatchInfo);

	void update(@Param("info") DispatchInfo dispatchInfo);
	
//	void updateBatch(@Param("list") List<DispatchInfo> list);

	void delete(@Param("orderId") String orderId);

	List<DispatchInfo> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<DispatchInfo> list(PageBounds pageBounds, Map<String,Object> param);

	void updateCheckStatus(Map<String, String> map);

	void updateRecevieNums(@Param("info") DispatchInfo info);

	void updateDispatchNums(@Param("info") DispatchInfo info);
}