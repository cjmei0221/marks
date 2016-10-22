package com.cjmei.module.system.orginfo.dao;


import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.TreeVo;
import com.cjmei.module.system.orginfo.pojo.OrgInfo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface OrgInfoDao {

	OrgInfo findById(String orgid);

	void save(OrgInfo orgInfo);

	void update(OrgInfo orgInfo);

	void delete(String orgid);

	List<OrgInfo> findAll();

	void deleteBatch(List<String> list);

	List<OrgInfo> list(PageBounds pageBounds, Map<String,Object> param);

	List<TreeVo> getChildListByParentId(String parentId);

	List<OrgInfo> getTreeGridByParentId(String parentId);

}