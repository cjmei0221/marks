package com.cjmei.module.note.question.service.impl;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import com.cjmei.module.note.question.pojo.Question;
import com.cjmei.module.note.question.dao.QuestionDao;
import com.cjmei.module.note.question.service.QuestionService;

public class QuestionServiceImpl implements QuestionService{
   

    private QuestionDao questionDao;

    public QuestionDao getQuestionDao(){
        return questionDao;
    }
    public void setQuestionDao(QuestionDao questionDao){
        this.questionDao =questionDao;
    }

    
    /**
    *根据ID查找工作问题记录
    */
    @Override
    public Question findById(String id){
        return questionDao.findById(id);
    }
    
    /**
    *保存工作问题记录
    */
    @Override
    public void save(Question question){
        questionDao.save(question);
    }
    
    /**
    *更新工作问题记录
    */
    @Override
    public void update(Question question){
        questionDao.update(question);
    }
    
    /**
    *删除工作问题记录
    */
    @Override
    public void delete(String id){
        questionDao.delete(id);       
    }
    
    /**
    *查找所有工作问题记录
    */
    @Override
    public List<Question> findAll(){
        return questionDao.findAll();   
    }
    
    /**
    *删除多个工作问题记录
    */
    @Override
   public void deleteBatch(List<String> ids) {
		questionDao.deleteBatch(ids);
	}
	
	public PojoDomain<Question> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<Question> pojoDomain = new PojoDomain<Question>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<Question> list = questionDao.list(pageBounds,param);
		PageList<Question> pageList = (PageList<Question>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	@Override
	public Question findByQuestion(String question) {
		return questionDao.findByQuestion(question);
	}
}