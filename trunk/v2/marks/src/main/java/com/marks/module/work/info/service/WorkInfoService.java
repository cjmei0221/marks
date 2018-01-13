package com.marks.module.work.info.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.work.info.pojo.WorkFlow;
import com.marks.module.work.info.pojo.WorkInfo;
import com.marks.module.work.info.pojo.WorkStep;

public interface WorkInfoService{

	public WorkInfo findById(String workId);

	public boolean save(WorkFlow info);
	public void update(WorkInfo info);
	public void delete(String id);
	public List<WorkInfo> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<WorkInfo> list(int page_number, int page_size,Map<String,Object> param);

	public void saveWorkStep(WorkStep info);

	public PojoDomain<WorkInfo> listByUserId(int page_number, int page_size, Map<String, Object> param);
}