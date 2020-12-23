package com.marks.smart.count.note.plan.controller;

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
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.count.note.plan.pojo.Plan;
import com.marks.smart.count.note.plan.service.PlanService;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

 /**
	 * 计划: 个人工作计划
	 */
@Controller
public class PlanController extends SupportContorller{
    private static Logger logger = Logger.getLogger( PlanController.class);
    
    @Autowired
    private PlanService  planService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询计划
	 */
    @RequestMapping("/inner/plan/findPlanById")
    public void findPlanById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    Plan plan = getModel(Plan.class);
		    
		    logger.info("findPlanById > param>"+plan.getId());
		    
			Plan requestPlan = planService.findById(plan.getId());
			result.getData().put("plan",requestPlan);
			result.setMessage("findById plan successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存计划
	 */
    @RequestMapping("/inner/plan/save")
    public void savePlan(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
	    	Plan plan = getModel(Plan.class);
	 //     plan.setId(IDUtil.getUUID());
	 		
	 		logger.info("savePlan > param>"+plan.toLog());
	 
			 Plan ori=null;
	 		if(plan.getId() != null){
	 			ori=planService.findById(plan.getId());
	 		}
	 		
	 		if(ori==null){
	 			plan.setId(IDUtil.getUUID());
	 			plan.setCreator(admin.getUserid());
	 			plan.setMobile(admin.getBind_mobile());
	 			planService.save(plan);
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
	 * 更改计划
	 */
    @RequestMapping("/inner/plan/update")
    public void updatePlan(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		    Plan plan = getModel(Plan.class);
		    
		    logger.info(" updatePlan> param>"+plan.toLog());
		    
		    Plan ori=planService.findById(plan.getId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	planService.update(plan);
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
	 * 删除计划
	 */
    @RequestMapping("/inner/plan/delete")
    public void deletePlanById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	Plan plan = getModel(Plan.class);
		   	
		   	logger.info("deletePlanById > param>"+plan.getId());
		   	
			planService.delete(plan.getId());
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
	 * 查询全部计划
	 */
    @RequestMapping("/inner/plan/findAllPlan")
    public void findAllPlan(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<Plan> planList = planService.findAll();
			result.getData().put("planList",planList);
			result.setMessage("findAll plan successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll plan fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个计划
	 */
	@RequestMapping("/inner/plan/deleteIds")
	public void deletePlan(HttpServletRequest request,
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
				planService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete plan fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/plan/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword=request.getParameter("keyword");
			String s_isComplete=request.getParameter("s_isComplete");
			logger.info("list> param>"+page_number+"-"+page_size+"-"+keyword);
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			param.put("s_isComplete", s_isComplete);
			param.put("creator", admin.getUserid());
			PojoDomain<Plan> list = planService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find plan successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find plan fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}