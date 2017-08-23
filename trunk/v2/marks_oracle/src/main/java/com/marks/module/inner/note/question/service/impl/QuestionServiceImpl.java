package com.marks.module.inner.note.question.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.util.Constants;
import com.marks.common.util.IDUtil;
import com.marks.module.inner.note.question.dao.QuestionDao;
import com.marks.module.inner.note.question.pojo.Question;
import com.marks.module.inner.note.question.service.QuestionService;
import com.marks.module.inner.note.util.NoteConstants;
import com.marks.module.inner.system.upload.util.FTPUtil;

@Service
public class QuestionServiceImpl implements QuestionService{
   
	@Autowired
    private QuestionDao questionDao;

   /* public QuestionDao getQuestionDao(){
        return questionDao;
    }
    public void setQuestionDao(QuestionDao questionDao){
        this.questionDao =questionDao;
    }*/

    
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
	@Override
	public String exportTxt(Map<String, Object> param, String basePath) {
		PageBounds pageBounds = new PageBounds(1, 100000);
		List<Question> list = questionDao.list(pageBounds, param);
		String fileName="question_"+IDUtil.getTimeID()+".txt";
		FileOutputStream fos=null;
		PrintWriter pw=null;
		String filePath=null;
		try {
			File file = new File(basePath+fileName);
			if (!file.exists()) {
				file.createNewFile();
				fos = new FileOutputStream(file);
				pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(fos,NoteConstants.charaterSet)));
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < list.size(); i++) {	
					Question info=list.get(i);
//					sb.append(System.getProperty("line.separator"));
					//写入文件
					sb.append("===========================================");
					sb.append(System.getProperty("line.separator"));
					sb.append(info.getQuestion());
					sb.append(System.getProperty("line.separator"));
					sb.append(System.getProperty("line.separator"));
					sb.append(DateUtil.formatDate(info.getCreatetime(), "yyyy-MM-dd HH:mm:ss")+" - "+info.getLvlName()+" - "+info.getLabels());
					sb.append(System.getProperty("line.separator"));
					sb.append("---------------------");
					sb.append(System.getProperty("line.separator"));
					sb.append(info.getSolution());
					sb.append(System.getProperty("line.separator"));
					sb.append(System.getProperty("line.separator"));
				}
				pw.write(sb.toString());
				pw.flush();
				filePath= FTPUtil.ftp_url+fileName;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(pw !=null){
				pw.close();
			}
		}
		return filePath;
	}
}