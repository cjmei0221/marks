package com.marks.module.mall.dispatch.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.mall.dispatch.pojo.DispatchGood;
import com.marks.module.mall.dispatch.pojo.DispatchInfo;
import com.marks.module.work.info.service.CheckService;

public interface DispatchInfoService extends CheckService {

	public DispatchInfo findById(String orderId);

	public void save(DispatchInfo info, List<DispatchGood> goodList);

	public void update(DispatchInfo info, List<DispatchGood> goodList);
	public void delete(String id);
	public List<DispatchInfo> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<DispatchInfo> list(int page_number, int page_size,Map<String,Object> param);

	/**
	 * 更新审核信息
	 * 
	 * @param map
	 */
	public void updateCheckStatus(Map<String, String> map);

	/**
	 * 采购收货
	 * 
	 * @param info
	 * @param goodList
	 */
	public void updateReceiveGood(DispatchInfo info, List<DispatchGood> goodList);

	/**
	 * 配货收货
	 * 
	 * @param ori
	 * @param goodList
	 */
	public void updateReceiveGoodForPh(DispatchInfo ori, List<DispatchGood> goodList);
}