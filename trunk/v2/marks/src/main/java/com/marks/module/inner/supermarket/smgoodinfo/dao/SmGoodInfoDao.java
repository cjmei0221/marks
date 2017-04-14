package com.marks.module.inner.supermarket.smgoodinfo.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.inner.supermarket.smgoodinfo.pojo.SmGoodInfo;

public interface SmGoodInfoDao {

	SmGoodInfo findById(@Param("goodId") String goodId);

	void save(SmGoodInfo smGoodInfo);

	void update(SmGoodInfo smGoodInfo);

	void delete(@Param("goodId") String goodId);

	List<SmGoodInfo> findAll();

	void deleteBatch(List<String> list);

	List<SmGoodInfo> list(PageBounds pageBounds, Map<String,Object> param);

	SmGoodInfo findByskuAndOrgId(@Param("companyId")String companyId,@Param("barCode") String barCode);

	int updateByExcel(SmGoodInfo info);
}