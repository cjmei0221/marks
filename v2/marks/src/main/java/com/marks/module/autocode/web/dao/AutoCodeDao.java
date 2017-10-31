package com.marks.module.autocode.web.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.autocode.web.pojo.AutoCode;
import com.marks.module.autocode.web.pojo.AutoCodeAttr;

@MapperScan
public interface AutoCodeDao {

	AutoCode findById(String tableName);

	void save(AutoCode autoCode);

	void update(AutoCode autoCode);

	void delete(String tableName);

	List<AutoCode> findAll();

	void deleteBatch(List<String> list);

	List<AutoCode> list(PageBounds pageBounds, Map<String,Object> param);

	List<AutoCodeAttr> attrList(Map<String, Object> param);

	void deleteAttr(String tableName);

	void saveAttr(AutoCodeAttr info);
}