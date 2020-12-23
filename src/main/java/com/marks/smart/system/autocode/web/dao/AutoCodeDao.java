package com.marks.smart.system.autocode.web.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.system.autocode.web.pojo.AutoCode;
import com.marks.smart.system.autocode.web.pojo.AutoCodeAttr;

@MapperScan
public interface AutoCodeDao {

	AutoCode findById(String idNo);

	void save(AutoCode autoCode);

	void update(AutoCode autoCode);

	void delete(String idNo);

	List<AutoCode> findAll();

	void deleteBatch(List<String> list);

	List<AutoCode> list(PageBounds pageBounds, Map<String,Object> param);

	List<AutoCodeAttr> attrList(Map<String, Object> param);

	void deleteAttr(String idNo);

	void saveAttr(AutoCodeAttr info);
}