package com.marks.module.mall.stock.controller;

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
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.mall.stock.pojo.Trace;
import com.marks.module.mall.stock.service.TraceService;
import com.marks.module.user.login.helper.ManageUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

 /**
	 * 追踪码管理: 追踪码管理
	 */
@Controller
public class TraceController extends SupportContorller{
    private static Logger logger = Logger.getLogger( TraceController.class);
    
    @Autowired
    private TraceService  traceService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询追踪码管理
	 */
    @RequestMapping("/inner/trace/findById")
    public void findTraceById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    Trace reqVo = getModel(Trace.class);
		    
		    logger.info("findTraceById > param>"+reqVo.getTraceId());
		    
			Trace info = traceService.findById(reqVo.getTraceId());
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
	 * 保存追踪码管理
	 */
    @RequestMapping("/inner/trace/save")
    public void saveTrace(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
	    	Trace reqVo = getModel(Trace.class);
	        reqVo.setTraceId(IDUtil.getUUID());
	 		
	 		logger.info("saveTrace > param>"+reqVo.toLog());
	 
			 Trace ori=null;
	 		if(reqVo.getTraceId() != null){
	 			ori=traceService.findById(reqVo.getTraceId());
	 		}
	 		
	 		if(ori==null){
	 			traceService.save(reqVo);
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
	 * 更改追踪码管理
	 */
    @RequestMapping("/inner/trace/update")
    public void updateTrace(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
		    Trace reqVo = getModel(Trace.class);
		    
		    logger.info(" updateTrace> param>"+reqVo.toLog());
		    
		    Trace ori=traceService.findById(reqVo.getTraceId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	traceService.update(reqVo);
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
	 * 删除追踪码管理
	 */
    @RequestMapping("/inner/trace/delete")
    public void deleteTraceById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	Trace reqVo = getModel(Trace.class);
		   	
		   	logger.info("deleteTraceById > param>"+reqVo.getTraceId());
		   	
			traceService.delete(reqVo.getTraceId());
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
	 * 查询全部追踪码管理
	 */

    /*@RequestMapping("/inner/trace/findAllTrace")
    public void findAllTrace(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<Trace> allList = traceService.findAll();
			result.getData().put("allList",allList);
			result.setMessage("findAll trace successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll trace fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	} */
	
	/**
	 * 删除多个追踪码管理
	 */
	/*@RequestMapping("/inner/trace/deleteIds")
	public void deleteTrace(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("traceId");
			logger.info("delete batch> param>"+id);
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				traceService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete trace fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}*/
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/trace/list")
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
			param.put("companyId", admin.getCompanyId());
			PojoDomain<Trace> list = traceService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find trace successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find trace fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}