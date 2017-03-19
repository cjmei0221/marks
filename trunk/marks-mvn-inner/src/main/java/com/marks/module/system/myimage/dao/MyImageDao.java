package com.marks.module.system.myimage.dao;


import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import com.marks.module.system.myimage.pojo.MyImage;

public interface MyImageDao {

	MyImage findById(String picId);

	void save(MyImage myImage);

	void update(MyImage myImage);

	void delete(String picId);

	List<MyImage> findAll();

	void deleteBatch(List<String> list);

	List<MyImage> list(PageBounds pageBounds, Map<String,Object> param);
}