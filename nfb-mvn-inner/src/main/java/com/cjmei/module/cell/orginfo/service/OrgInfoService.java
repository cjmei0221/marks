package com.cjmei.module.cell.orginfo.service;


import com.cjmei.module.cell.orginfo.pojo.OrgInfo;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.cjmei.common.domain.TreeVo;

public interface OrgInfoService{

	public OrgInfo findById(String orgid);
	public void save(OrgInfo orgInfo);
	public void update(OrgInfo orgInfo);
	public void delete(String orgid);
	public List<OrgInfo> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<OrgInfo> list(int page_number, int page_size,Map<String,Object> param);
	public List<TreeVo> getChildListByParentId(String parentId);
}