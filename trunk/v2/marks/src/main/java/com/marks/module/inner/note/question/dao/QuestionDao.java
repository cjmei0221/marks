package com.marks.module.inner.note.question.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.marks.module.inner.note.question.pojo.Question;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface QuestionDao {

	Question findById(String id);

	void save(Question question);

	void update(Question question);

	void delete(String id);

	List<Question> findAll();

	void deleteBatch(List<String> list);

	List<Question> list(PageBounds pageBounds, Map<String,Object> param);

	Question findByQuestion(@Param("question")String question);
}