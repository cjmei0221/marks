package com.marks.module.system.orginfo.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.marks.module.system.orginfo.pojo.OrgInfo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface OrgInfoDao {

	OrgInfo findById(String orgid);

	void save(OrgInfo orgInfo);

	void update(OrgInfo orgInfo);

	void delete(String orgid);

	List<OrgInfo> findAll(@Param("companyId")String companyId);

	void deleteBatch(List<String> list);

	List<OrgInfo> list(PageBounds pageBounds, Map<String,Object> param);

	List<OrgInfo> getTreeGridByParentId(@Param("plist")List<String>  plist,@Param("companyId")String companyId);

	List<OrgInfo> getChildList(@Param("orgid")String orgid);

	List<OrgInfo> frameCombo(Map<String, Object> param);

}