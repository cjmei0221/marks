package com.cjmei.module.note.question.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjmei.common.domain.PaginationResult;
import com.cjmei.common.domain.PojoDomain;
import com.cjmei.common.domain.Result;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.common.util.IDUtil;
import com.cjmei.module.autocode.core.util.Code;
import com.cjmei.module.autocode.core.produced.SupportContorller;
import com.cjmei.module.system.core.data.StaticData;
import com.cjmei.module.system.core.helper.SysUserHelper;
import com.cjmei.module.system.sysuser.pojo.SysUser;

import com.cjmei.module.note.question.pojo.Question;
import com.cjmei.module.note.question.service.QuestionService;

@Controller
public class QuestionController extends SupportContorller{
    private static Logger logger = Logger.getLogger( QuestionController.class);
    
    @Autowired
    private QuestionService  questionService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询工作问题记录
	 */
    @RequestMapping("/question/findQuestionById")
    public void findQuestionById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    Question question = getModel(Question.class);
			Question requestQuestion = questionService.findById(question.getId());
			result.getData().put("question",requestQuestion);
			result.setMessage("findById question successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存工作问题记录
	 */
    @RequestMapping("/question/save")
    public void saveQuestion(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
	    	Question question = getModel(Question.class);
	 //     question.setId(IDUtil.getTimeID());
			 Question ori=null;
	 		if(question.getId() != null){
	 			ori=questionService.findByQuestion(question.getQuestion());
	 		}
	 		
	 		if(ori==null){
	 			question.setMobile(admin.getBind_mobile());
	 			question.setLvlName(StaticData.getDatadirValue("question_level", question.getLvl()));
	 			question.setCreator(admin.getUserid());
	 			question.setUpdater(admin.getUserid());
	 			questionService.save(question);
	 			result.setMessage("保存成功");
				result.setCode(Code.CODE_SUCCESS);
	 		}else{
	    		result.setMessage("此记录已存在");
				result.setCode(Code.CODE_FAIL);
	    	}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 更改工作问题记录
	 */
    @RequestMapping("/question/update")
    public void updateQuestion(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
		    Question question = getModel(Question.class);
		    Question ori=questionService.findById(question.getId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	question.setUpdater(admin.getUserid());
		    	question.setLvlName(StaticData.getDatadirValue("question_level", question.getLvl()));
		    	questionService.update(question);
				result.setMessage("更新成功!");
				result.setCode(Code.CODE_SUCCESS);
		    }
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("更新失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除工作问题记录
	 */
    @RequestMapping("/question/delete")
    public void deleteQuestionById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	Question question = getModel(Question.class);
			questionService.delete(question.getId());
			result.setMessage("删除成功!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("删除失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 查询全部工作问题记录
	 */
    @RequestMapping("/question/findAllQuestion")
    public void findAllQuestion(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<Question> questionList = questionService.findAll();
			result.getData().put("questionList",questionList);
			result.setMessage("findAll question successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll question fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个工作问题记录
	 */
	@RequestMapping("/question/deleteIds")
	public void deleteQuestion(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("id");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				questionService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete question fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/question/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword=request.getParameter("keyword");
			if(keyword==null){
				keyword="";
			}
			Map<String,Object> param=new HashMap<String,Object>();
			String userid=admin.getUserid();
			if("admin".equals(admin.getUserid())){
				userid=null;
			}
			param.put("userid", userid);
			param.put("keyword", keyword);
			PojoDomain<Question> list = questionService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find question successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find question fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}