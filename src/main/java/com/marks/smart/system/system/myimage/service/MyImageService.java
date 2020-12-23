package com.marks.smart.system.system.myimage.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.smart.system.system.myimage.pojo.MyImage;

public interface MyImageService{

	public MyImage findById(String picId);
	public void save(MyImage myImage);
	public void update(MyImage myImage);
	public void delete(String picId);
	public List<MyImage> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<MyImage> list(int page_number, int page_size,Map<String,Object> param);
}