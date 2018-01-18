package com.marks.module.note.diary.controller;

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

import com.marks.common.domain.PaginationResult;
import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.note.diary.pojo.Diary;
import com.marks.module.note.diary.service.DiaryService;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

@Controller
public class DiaryController extends SupportContorller{
    private static Logger logger = Logger.getLogger( DiaryController.class);
    
    @Autowired
    private DiaryService  diaryService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询我的日记
	 */
    @RequestMapping("/inner/diary/findDiaryById")
    public void findDiaryById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    Diary diary = getModel(Diary.class);
			Diary requestDiary = diaryService.findById(diary.getId());
			result.getData().put("diary",requestDiary);
			result.setMessage("findById diary successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存我的日记
	 */
    @RequestMapping("/inner/diary/save")
    public void saveDiary(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
	    	Diary diary = getModel(Diary.class);
	    	diary.setId(IDUtil.getUUID());
	    	diary.setCreator(admin.getUserid());
	    	diary.setMobile(admin.getBind_mobile());
			diaryService.save(diary);
			result.setMessage("保存成功");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.info(e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 更改我的日记
	 */
    @RequestMapping("/inner/diary/update")
    public void updateDiary(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		    Diary diary = getModel(Diary.class);
			diaryService.update(diary);
			result.setMessage("更新成功!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("更新失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除我的日记
	 */
    @RequestMapping("/inner/diary/delete")
    public void deleteDiaryById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	Diary diary = getModel(Diary.class);
			diaryService.delete(diary.getId());
			result.setMessage("删除成功!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("删除失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 查询全部我的日记
	 */
    @RequestMapping("/inner/diary/findAllDiary")
    public void findAllDiary(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<Diary> diaryList = diaryService.findAll();
			result.getData().put("diaryList",diaryList);
			result.setMessage("findAll diary successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("findAll diary fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个我的日记
	 */
	@RequestMapping("/inner/diary/deleteIds")
	public void deleteDiary(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("ID");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				diaryService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("delete diary fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/diary/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			Map<String,Object> param=new HashMap<String,Object>();
			String keyword=request.getParameter("keyword");
			String statedate=request.getParameter("statedate");
			String enddate=request.getParameter("enddate");
			String userid=admin.getUserid();
			param.put("userid", userid);
			param.put("keyword", keyword);
			param.put("statedate", statedate);
			param.put("enddate", enddate);
			PojoDomain<Diary> list = diaryService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find diary successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("find diary fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}