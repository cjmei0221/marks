package com.marks.smart.market.mall.pay.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.market.mall.pay.pojo.PayAcct;

@MapperScan
public interface PayAcctDao {

	PayAcct findById(@Param("id") String id);

	void save(@Param("info") PayAcct payAcct);
	
	void saveBatch(@Param("list") List<PayAcct> list);

	void update(@Param("info") PayAcct payAcct);
	
	void updateBatch(@Param("list") List<PayAcct> list);

	void delete(@Param("id") String id);

	List<PayAcct> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<PayAcct> list(PageBounds pageBounds, Map<String,Object> param);
}