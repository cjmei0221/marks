package com.marks.module.work.info.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.work.base.pojo.WorkType;
import com.marks.module.work.info.pojo.WorkInfo;

@MapperScan
public interface WorkInfoDao {

	WorkInfo findById(@Param("workId") String workId);

	void save(@Param("info") WorkInfo workInfo);
	
	void saveBatch(@Param("list") List<WorkInfo> list);

	void update(@Param("info") WorkInfo workInfo);
	
	void updateBatch(@Param("list") List<WorkInfo> list);

	void delete(@Param("workId") String workId);

	List<WorkInfo> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<WorkInfo> list(PageBounds pageBounds, Map<String,Object> param);

	void updateCheck(@Param("info") WorkType type);

	List<WorkInfo> listByUserId(PageBounds pageBounds, Map<String, Object> param);
}