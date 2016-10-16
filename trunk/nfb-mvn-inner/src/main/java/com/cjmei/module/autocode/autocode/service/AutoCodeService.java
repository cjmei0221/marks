package com.cjmei.module.autocode.autocode.service;


import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.cjmei.module.autocode.autocode.pojo.AutoCode;
import com.cjmei.module.autocode.autocode.pojo.AutoCodeAttr;

public interface AutoCodeService{

	public AutoCode findById(String tableName);
	public void save(AutoCode autoCode, String attrList );
	public void update(AutoCode autoCode, String attrList);
	public void delete(String tableName);
	public List<AutoCode> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<AutoCode> list(int page_number, int page_size,Map<String,Object> param);
	public PojoDomain<AutoCodeAttr> attrList(int page_number, int page_size, Map<String, Object> param);
	public AutoCode findDetailById(String tableName);

}