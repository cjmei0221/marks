package com.marks.module.work.base.controller;

import java.util.HashMap;
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
import com.marks.common.enums.Enums;
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.string.IStringUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.work.base.pojo.WorkType;
import com.marks.module.work.base.service.WorkTypeService;

 /**
	 * 工作类型: 工作流类型
	 */
@Controller
public class WorkTypeController extends SupportContorller{
    private static Logger logger = Logger.getLogger( WorkTypeController.class);
    
    @Autowired
    private WorkTypeService  workTypeService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询工作类型
	 */
    @RequestMapping("/inner/workType/findById")
    public void findWorkTypeById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    WorkType info = getModel(WorkType.class);
		    
		    logger.info("findWorkTypeById > param>"+info.getTypeId());
		    
			WorkType vo = workTypeService.findById(info.getTypeId());
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
	 * 保存工作类型
	 */
    @RequestMapping("/inner/workType/save")
    public void saveWorkType(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
	    	WorkType info = getModel(WorkType.class);
			info.setCompanyId(admin.getCompanyId());
			info.setTypeId(admin.getCompanyId() + "_" + info.getTypeCode());
	 		
	 		logger.info("saveWorkType > param>"+info.toLog());
	 
			 WorkType ori=null;
	 		if(info.getTypeId() != null){
	 			ori=workTypeService.findById(info.getTypeId());
	 		}
	 		
	 		if(ori==null){
				info.setUpdater(admin.getUserCode() + " - " + admin.getUsername());
				info.setStatus(Enums.Status.Unable.getValue());
	 			workTypeService.save(info);
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
	 * 更改工作类型
	 */
    @RequestMapping("/inner/workType/update")
    public void updateWorkType(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		    WorkType info = getModel(WorkType.class);
		    
		    logger.info(" updateWorkType> param>"+info.toLog());
		    
		    WorkType ori=workTypeService.findById(info.getTypeId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
				info.setUpdater(admin.getUserCode() + " - " + admin.getUsername());
				info.setStatus(ori.getStatus());
		    	workTypeService.update(info);
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
	 * 删除工作类型
	 */
    @RequestMapping("/inner/workType/delete")
    public void deleteWorkTypeById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	WorkType info = getModel(WorkType.class);
		   	
		   	logger.info("deleteWorkTypeById > param>"+info.getTypeId());
		   	
			workTypeService.delete(info.getTypeId());
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
	 * 查询全部工作类型
	 */

    /*
    @RequestMapping("/inner/workType/findAllWorkType")
    public void findAllWorkType(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<WorkType> allList = workTypeService.findAll();
			result.getData().put("allList",allList);
			result.setMessage("findAll workType successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll workType fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	} 
	*/
	
	/**
	 * 删除多个工作类型
	 */
	/*
	@RequestMapping("/inner/workType/deleteIds")
	public void deleteWorkType(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("typeId");
			logger.info("delete batch> param>"+id);
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				workTypeService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete workType fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	*/
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/workType/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			if (page_size > 200) {
				page_size = 200;
			}
			String keyword=IStringUtil.getUTF8(request.getParameter("keyword"));
			logger.info("list> param>"+page_number+"-"+page_size+"-"+keyword);
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			PojoDomain<WorkType> list = workTypeService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find workType successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find workType fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}