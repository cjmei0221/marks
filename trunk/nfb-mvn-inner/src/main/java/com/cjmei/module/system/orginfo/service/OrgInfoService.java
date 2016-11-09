package com.cjmei.module.system.orginfo.service;


import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.cjmei.module.system.orginfo.pojo.OrgInfo;

public interface OrgInfoService{

	public OrgInfo findById(String orgid);
	public void save(OrgInfo orgInfo);
	public void update(OrgInfo orgInfo);
	public void delete(String orgid);
	public List<OrgInfo> findAll();
	public void deleteBatch(List<String> ids);
	public List<OrgInfo> list(List<String> list);
	public PojoDomain<OrgInfo> framelist(int page_number, int page_size, Map<String, Object> param);
	public List<OrgInfo> getChildList(String orgid);
	public List<OrgInfo> listGrid(List<String> plist);

}