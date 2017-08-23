package com.marks.module.inner.note.question.service;


import com.marks.module.inner.note.question.pojo.Question;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface QuestionService{

	public Question findById(String id);
	public void save(Question question);
	public void update(Question question);
	public void delete(String id);
	public List<Question> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Question> list(int page_number, int page_size,Map<String,Object> param);
	public Question findByQuestion(String question);
	public String exportTxt(Map<String, Object> param, String basePath);
}