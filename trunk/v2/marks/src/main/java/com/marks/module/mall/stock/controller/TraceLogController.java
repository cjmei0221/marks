package com.marks.module.mall.stock.controller;

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
import com.marks.common.util.JsonUtil;
import com.marks.common.util.IDUtil;
import com.marks.common.util.Code;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.user.login.helper.ManageUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

import com.marks.module.mall.stock.pojo.TraceLog;
import com.marks.module.mall.stock.service.TraceLogService;

 /**
	 * 追踪日志: 追踪日志
	 */
@Controller
public class TraceLogController extends SupportContorller{
    private static Logger logger = Logger.getLogger( TraceLogController.class);
    
    @Autowired
    private TraceLogService  traceLogService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询追踪日志
	 */
    @RequestMapping("/inner/traceLog/findById")
    public void findTraceLogById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    TraceLog reqVo = getModel(TraceLog.class);
		    
		    logger.info("findTraceLogById > param>"+reqVo.getId());
		    
			TraceLog info = traceLogService.findById(reqVo.getId());
			result.getData().put("info",info);
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
	 * 保存追踪日志
	 */
    @RequestMapping("/inner/traceLog/save")
    public void saveTraceLog(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
	    	TraceLog reqVo = getModel(TraceLog.class);
	        reqVo.setId(IDUtil.getUUID());
	 		
	 		logger.info("saveTraceLog > param>"+reqVo.toLog());
	 
			 TraceLog ori=null;
	 		if(reqVo.getId() != null){
	 			ori=traceLogService.findById(reqVo.getId());
	 		}
	 		
	 		if(ori==null){
	 			traceLogService.save(reqVo);
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
	 * 更改追踪日志
	 */
    @RequestMapping("/inner/traceLog/update")
    public void updateTraceLog(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
		    TraceLog reqVo = getModel(TraceLog.class);
		    
		    logger.info(" updateTraceLog> param>"+reqVo.toLog());
		    
		    TraceLog ori=traceLogService.findById(reqVo.getId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	traceLogService.update(reqVo);
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
	 * 删除追踪日志
	 */
    @RequestMapping("/inner/traceLog/delete")
    public void deleteTraceLogById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	TraceLog reqVo = getModel(TraceLog.class);
		   	
		   	logger.info("deleteTraceLogById > param>"+reqVo.getId());
		   	
			traceLogService.delete(reqVo.getId());
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
	 * 查询全部追踪日志
	 */

    /*@RequestMapping("/inner/traceLog/findAllTraceLog")
    public void findAllTraceLog(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<TraceLog> allList = traceLogService.findAll();
			result.getData().put("allList",allList);
			result.setMessage("findAll traceLog successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll traceLog fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	} */
	
	/**
	 * 删除多个追踪日志
	 */
	/*@RequestMapping("/inner/traceLog/deleteIds")
	public void deleteTraceLog(HttpServletRequest request,
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
				traceLogService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete traceLog fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}*/
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/traceLog/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			if (page_size > 200) {
				page_size = 200;
			}
			String keyword=request.getParameter("keyword");
			if(keyword==null){
				keyword="";
			}
			logger.info("list> param>"+page_number+"-"+page_size+"-"+keyword);
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			PojoDomain<TraceLog> list = traceLogService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find traceLog successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find traceLog fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}