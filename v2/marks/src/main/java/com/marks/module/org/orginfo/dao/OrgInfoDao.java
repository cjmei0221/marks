package com.marks.module.org.orginfo.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.org.orginfo.pojo.OrgInfo;

@MapperScan
public interface OrgInfoDao {

	OrgInfo findById(String orgid);

	void save(OrgInfo orgInfo);

	void update(OrgInfo orgInfo);

	void delete(String orgid);

	List<OrgInfo> findAll(@Param("companyId") String companyId, @Param("orgType") String orgType);

	void deleteBatch(List<String> list);

	List<OrgInfo> list(PageBounds pageBounds, Map<String,Object> param);

	List<OrgInfo> getTreeGridByParentId(Map<String, Object> param);

	List<OrgInfo> getChildList(@Param("orgid")String orgid);

	List<OrgInfo> frameCombo(Map<String, Object> param);

	void updateOrgChildNum(@Param("orgid") String orgid);

	void updateMoreLvlName(@Param("orgid") String orgid, @Param("orgname")  String orgname,@Param("lvl") int lvl);

	String getOrgId();

	String getCompanyId();

}