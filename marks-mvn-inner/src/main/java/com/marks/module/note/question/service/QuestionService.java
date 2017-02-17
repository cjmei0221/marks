package com.cjmei.module.note.question.service;


import com.cjmei.module.note.question.pojo.Question;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;

public interface QuestionService{

	public Question findById(String id);
	public void save(Question question);
	public void update(Question question);
	public void delete(String id);
	public List<Question> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Question> list(int page_number, int page_size,Map<String,Object> param);
	public Question findByQuestion(String question);
}