package com.marks.module.note.gains.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.note.gains.pojo.Gains;

public interface GainsService{

	public Gains findById(String id);
	public void save(Gains gains);
	public void update(Gains gains);
	public void delete(String id);
	public List<Gains> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Gains> list(int page_number, int page_size,Map<String,Object> param);
	public Gains findByTitle(String title);
	/**
	 * 导出txt文件
	 * @param param
	 * @param basePath
	 * @return
	 */
	public String exportTxt(Map<String, Object> param, String basePath);
}