package com.marks.smart.count.note.question.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.smart.count.note.question.pojo.Question;

public interface QuestionService{

	public Question findById(String id);
	public void save(Question question);
	public void update(Question question);
	public void delete(String id);
	public List<Question> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Question> list(int page_number, int page_size,Map<String,Object> param);
	public Question findByQuestion(String question);
	/**
	 * 导出问题txt文件
	 * @param param
	 * @param basePath
	 * @return
	 */
	public String exportTxt(Map<String, Object> param, String basePath);
}