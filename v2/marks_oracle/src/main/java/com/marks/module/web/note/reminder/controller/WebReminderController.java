package com.marks.module.web.note.reminder.controller;

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
import com.marks.common.util.JsonUtil;
import com.marks.module.inner.note.reminder.pojo.Reminder;
import com.marks.module.inner.note.reminder.service.ReminderService;
import com.marks.module.inner.system.sys.controller.SupportContorller;
import com.marks.module.inner.user.sysuser.pojo.SysUser;
import com.marks.module.web.user.login.util.LoginUtil;

 /**
	 * 事务提醒: 1，事务提醒 ，特殊日子可设置每年提醒，普通事务提醒，默认明天；<br/>2，提醒时间是9点提醒<br/>3，可设置提前提醒
	 */
@Controller
public class WebReminderController extends SupportContorller{
    private static Logger logger = Logger.getLogger( WebReminderController.class);
    
    @Autowired
    private ReminderService  reminderService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询事务提醒
	 */
    @RequestMapping("/web/reminder/findReminderById")
    public void findReminderById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    Reminder reminder = getModel(Reminder.class);
		    
		    logger.info("findReminderById > param>"+reminder.getId());
		    
			Reminder requestReminder = reminderService.findById(reminder.getId());
			result.getData().put("reminder",requestReminder);
			result.setMessage("findById reminder successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存事务提醒
	 */
    @RequestMapping("/web/reminder/save")
    public void saveReminder(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
	    	Reminder reminder = getModel(Reminder.class);
	 		logger.info("saveReminder > param>"+reminder.toLog());
	 
			 Reminder ori=null;
	 		if(reminder.getId() != null){
	 			ori=reminderService.findById(reminder.getId());
	 		}
	 		
	 		if(ori==null){
	 			reminder.setCreator(admin.getUserid());
	 			reminderService.save(reminder);
	 			result.setMessage("保存成功");
				result.setCode(Code.CODE_SUCCESS);
	 		}else{
	 			reminderService.update(reminder);
	    	}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 更改事务提醒
	 */
    @RequestMapping("/web/reminder/update")
    public void updateReminder(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		    Reminder reminder = getModel(Reminder.class);
		    
		    logger.info(" updateReminder> param>"+reminder.toLog());
		    
		    Reminder ori=reminderService.findById(reminder.getId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	reminderService.update(reminder);
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
	 * 删除事务提醒
	 */
    @RequestMapping("/web/reminder/delete")
    public void deleteReminderById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	Reminder reminder = getModel(Reminder.class);
		   	
		   	logger.info("deleteReminderById > param>"+reminder.getId());
		   	
			reminderService.delete(reminder.getId());
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
	 * 查询全部事务提醒
	 */
    @RequestMapping("/web/reminder/findAllReminder")
    public void findAllReminder(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<Reminder> reminderList = reminderService.findAll();
			result.getData().put("reminderList",reminderList);
			result.setMessage("findAll reminder successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll reminder fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个事务提醒
	 */
	@RequestMapping("/web/reminder/deleteIds")
	public void deleteReminder(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("id");
			logger.info("delete batch> param>"+id);
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				reminderService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete reminder fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/web/reminder/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword=request.getParameter("keyword");
			if(keyword==null){
				keyword="";
			}
			logger.info("list> param>"+page_number+"-"+page_size+"-"+keyword);
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			param.put("userid", admin.getUserid());
			PojoDomain<Reminder> list = reminderService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find reminder successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find reminder fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}