package com.cjmei.module.system.orginfo.service;


import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.cjmei.common.domain.TreeVo;
import com.cjmei.module.system.orginfo.pojo.OrgInfo;

public interface OrgInfoService{

	public OrgInfo findById(String orgid);
	public void save(OrgInfo orgInfo);
	public void update(OrgInfo orgInfo);
	public void delete(String orgid);
	public List<OrgInfo> findAll();
	public void deleteBatch(List<String> ids);
	public List<OrgInfo> list(String parentId);
	public List<TreeVo> getChildListByParentId(String parentId);
	public PojoDomain<OrgInfo> framelist(int page_number, int page_size, Map<String, Object> param);

}