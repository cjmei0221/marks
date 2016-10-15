package com.cjmei.module.teacher.controller;

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
import com.cjmei.common.util.syscode.Code;
import com.cjmei.module.system.sys.controller.SupportContorller;

import com.cjmei.module.teacher.pojo.Teacher;
import com.cjmei.module.teacher.service.TeacherService;

@Controller
public class TeacherController extends SupportContorller{
    private static Logger logger = Logger.getLogger( TeacherController.class);
    
    @Autowired
    private TeacherService  teacherService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询老师
	 */
    @RequestMapping("/teacher/findTeacherById")
    public void findTeacherById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    Teacher teacher = getModel(Teacher.class);
			Teacher requestTeacher = teacherService.findById(teacher.getTeacherId());
			result.getData().put("teacher",requestTeacher);
			result.setMessage("findById teacher successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存老师
	 */
    @RequestMapping("/teacher/save")
    public void saveTeacher(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
	    	Teacher teacher = getModel(Teacher.class);
	 //     teacher.setTeacherId(IDUtil.getTimeID());
			teacherService.save(teacher);
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
	 * 更改老师
	 */
    @RequestMapping("/teacher/update")
    public void updateTeacher(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		    Teacher teacher = getModel(Teacher.class);
			teacherService.update(teacher);
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
	 * 删除老师
	 */
    @RequestMapping("/teacher/delete")
    public void deleteTeacherById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	Teacher teacher = getModel(Teacher.class);
			teacherService.delete(teacher.getTeacherId());
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
	 * 查询全部老师
	 */
    @RequestMapping("/teacher/findAllTeacher")
    public void findAllTeacher(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<Teacher> teacherList = teacherService.findAll();
			result.getData().put("teacherList",teacherList);
			result.setMessage("findAll teacher successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("findAll teacher fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个老师
	 */
	@RequestMapping("/teacher/deleteIds")
	public void deleteTeacher(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("teacherId");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				teacherService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("delete teacher fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/teacher/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			Teacher teacher = getModel(Teacher.class);
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("teacher", teacher);
			PojoDomain<Teacher> list = teacherService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find teacher successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("find teacher fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}