package com.marks.module.mall.dispatch.controller;

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
import com.marks.common.util.string.IStringUtil;
import com.marks.common.util.IDUtil;
import com.marks.common.util.Code;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

import com.marks.module.mall.dispatch.pojo.DispatchLog;
import com.marks.module.mall.dispatch.service.DispatchLogService;

 /**
	 * 配送记录: 采购和配送商品记录
	 */
@Controller
public class DispatchLogController extends SupportContorller{
    private static Logger logger = Logger.getLogger( DispatchLogController.class);
    
    @Autowired
    private DispatchLogService  dispatchLogService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询配送记录
	 */
    @RequestMapping("/inner/dispatchLog/findById")
    public void findDispatchLogById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    DispatchLog info = getModel(DispatchLog.class);
		    
		    logger.info("findDispatchLogById > param>"+info.getLogId());
		    
			DispatchLog vo = dispatchLogService.findById(info.getLogId());
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
	 * 保存配送记录
	 */
    @RequestMapping("/inner/dispatchLog/save")
    public void saveDispatchLog(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
	    	DispatchLog info = getModel(DispatchLog.class);
	        info.setLogId(IDUtil.getUUID());
	 		
	 		logger.info("saveDispatchLog > param>"+info.toLog());
	 
			 DispatchLog ori=null;
	 		if(info.getLogId() != null){
	 			ori=dispatchLogService.findById(info.getLogId());
	 		}
	 		
	 		if(ori==null){
	 			dispatchLogService.save(info);
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
	 * 更改配送记录
	 */
    @RequestMapping("/inner/dispatchLog/update")
    public void updateDispatchLog(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		    DispatchLog info = getModel(DispatchLog.class);
		    
		    logger.info(" updateDispatchLog> param>"+info.toLog());
		    
		    DispatchLog ori=dispatchLogService.findById(info.getLogId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	dispatchLogService.update(info);
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
	 * 删除配送记录
	 */
    @RequestMapping("/inner/dispatchLog/delete")
    public void deleteDispatchLogById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	DispatchLog info = getModel(DispatchLog.class);
		   	
		   	logger.info("deleteDispatchLogById > param>"+info.getLogId());
		   	
			dispatchLogService.delete(info.getLogId());
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
	 * 查询全部配送记录
	 */

    /*
    @RequestMapping("/inner/dispatchLog/findAllDispatchLog")
    public void findAllDispatchLog(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<DispatchLog> allList = dispatchLogService.findAll();
			result.getData().put("allList",allList);
			result.setMessage("findAll dispatchLog successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll dispatchLog fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	} 
	*/
	
	/**
	 * 删除多个配送记录
	 */
	/*
	@RequestMapping("/inner/dispatchLog/deleteIds")
	public void deleteDispatchLog(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("logId");
			logger.info("delete batch> param>"+id);
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				dispatchLogService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete dispatchLog fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	*/
	
	/**
	 * 列表查询
	 */
	@RequestMapping("/inner/dispatchLog/list")
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
			PojoDomain<DispatchLog> list = dispatchLogService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find dispatchLog successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find dispatchLog fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}