package com.marks.smart.system.work.base.controller;

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
import com.marks.common.util.string.IStringUtil;
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;
import com.marks.smart.system.work.base.pojo.WorkTypeStep;
import com.marks.smart.system.work.base.service.WorkTypeStepService;

 /**
	 * 工作流步骤配置: 工作流步骤配置
	 */
@Controller
public class WorkTypeStepController extends SupportContorller{
    private static Logger logger = Logger.getLogger( WorkTypeStepController.class);
    
    @Autowired
    private WorkTypeStepService  workTypeStepService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询工作流步骤配置
	 */
    @RequestMapping("/inner/workTypeStep/findById")
    public void findWorkTypeStepById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    WorkTypeStep info = getModel(WorkTypeStep.class);
		    
		    logger.info("findWorkTypeStepById > param>"+info.getStepId());
		    
			WorkTypeStep vo = workTypeStepService.findById(info.getStepId());
			result.getData().put("info",vo);
			result.setMessage("findById successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存工作流步骤配置
	 */
    @RequestMapping("/inner/workTypeStep/save")
    public void saveWorkTypeStep(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			String status = request.getParameter("status");
			String typeId = request.getParameter("typeId");
			String[] stepName = request.getParameterValues("stepName");
			String[] roleId = request.getParameterValues("roleId");
			String[] dealType = request.getParameterValues("dealType");
			List<WorkTypeStep> list = new ArrayList<WorkTypeStep>();
			if (null != roleId && roleId.length > 0) {
				WorkTypeStep item = null;
				for (int i = 0; i < roleId.length; i++) {
					if (null != roleId[i] && roleId[i].length() > 4) {
						item = new WorkTypeStep();
						item.setCompanyId(admin.getCompanyId());
						item.setDealType(dealType[i]);
						item.setRoleId(roleId[i]);
						item.setStepName(stepName[i]);
						item.setTypeId(typeId);
						list.add(item);
					}
				}
			}
			workTypeStepService.saveStep(typeId, status, list);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 更改工作流步骤配置
	 */
    @RequestMapping("/inner/workTypeStep/update")
    public void updateWorkTypeStep(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		    WorkTypeStep info = getModel(WorkTypeStep.class);
		    
		    logger.info(" updateWorkTypeStep> param>"+info.toLog());
		    
		    WorkTypeStep ori=workTypeStepService.findById(info.getStepId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	workTypeStepService.update(info);
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
	 * 删除工作流步骤配置
	 */
    @RequestMapping("/inner/workTypeStep/delete")
    public void deleteWorkTypeStepById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	WorkTypeStep info = getModel(WorkTypeStep.class);
		   	
		   	logger.info("deleteWorkTypeStepById > param>"+info.getStepId());
		   	
			workTypeStepService.delete(info.getStepId());
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
	 * 查询全部工作流步骤配置
	 */

    /*
    @RequestMapping("/inner/workTypeStep/findAllWorkTypeStep")
    public void findAllWorkTypeStep(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<WorkTypeStep> allList = workTypeStepService.findAll();
			result.getData().put("allList",allList);
			result.setMessage("findAll workTypeStep successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll workTypeStep fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	} 
	*/
	
	/**
	 * 删除多个工作流步骤配置
	 */
	/*
	@RequestMapping("/inner/workTypeStep/deleteIds")
	public void deleteWorkTypeStep(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("stepId");
			logger.info("delete batch> param>"+id);
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				workTypeStepService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete workTypeStep fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	*/
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/workTypeStep/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = 1;
			int page_size = 200;
			if (page_size > 200) {
				page_size = 200;
			}
			String keyword = IStringUtil.getUTF8(request.getParameter("typeId"));
			logger.info("list> param>"+page_number+"-"+page_size+"-"+keyword);
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("typeId", keyword);
			param.put("companyId", admin.getCompanyId());
			PojoDomain<WorkTypeStep> list = workTypeStepService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find workTypeStep successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find workTypeStep fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}