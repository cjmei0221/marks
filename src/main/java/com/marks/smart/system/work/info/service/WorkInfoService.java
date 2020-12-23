package com.marks.smart.system.work.info.service;


import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.smart.system.work.info.pojo.WorkFlow;
import com.marks.smart.system.work.info.pojo.WorkInfo;
import com.marks.smart.system.work.info.pojo.WorkStep;

public interface WorkInfoService{

	public WorkInfo findById(String workId);

	public boolean save(WorkFlow info);
	
	public PojoDomain<WorkInfo> list(int page_number, int page_size,Map<String,Object> param);

	public void saveWorkStep(WorkStep info);

	public PojoDomain<WorkInfo> listByUserId(int page_number, int page_size, Map<String, Object> param);

	/**
	 * 更新提交对象的审批状态
	 * @param work
	 * @param map
	 */
	public void updateTargetCheckStatus(WorkFlow work, Map<String, String> map);

	public boolean check(String companyId, String typeCode);
}