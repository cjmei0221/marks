package com.marks.smart.count.acct.info.controller;

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
import com.marks.common.util.JsonUtil;
import com.marks.common.util.string.IStringUtil;
import com.marks.common.util.IDUtil;
import com.marks.common.util.Code;
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

import com.marks.smart.count.acct.info.pojo.AcctInfo;
import com.marks.smart.count.acct.info.service.AcctInfoService;

 /**
	 * 帐户信息: 
	 */
@Controller
public class AcctInfoController extends SupportContorller{
    private static Logger logger = Logger.getLogger( AcctInfoController.class);
    
    @Autowired
    private AcctInfoService  acctInfoService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询帐户信息
	 */
    @RequestMapping("/inner/acctInfo/findById")
    public void findAcctInfoById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    AcctInfo info = getModel(AcctInfo.class,request.getParameterMap());
		    
		    logger.info("findAcctInfoById > param>"+info.getUserid());
		    
			AcctInfo vo = acctInfoService.findById(info.getUserid());
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
	 * 保存帐户信息
	 */
    @RequestMapping("/inner/acctInfo/save")
    public void saveAcctInfo(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
	    	AcctInfo info = getModel(AcctInfo.class,request.getParameterMap());
	        info.setUserid(IDUtil.getUUID());
	 		
	 		logger.info("saveAcctInfo > param>"+info.toLog());
	 
			 AcctInfo ori=null;
	 		if(info.getUserid() != null){
	 			ori=acctInfoService.findById(info.getUserid());
	 		}
	 		
	 		if(ori==null){
	 			acctInfoService.save(info);
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
	 * 更改帐户信息
	 */
    @RequestMapping("/inner/acctInfo/update")
    public void updateAcctInfo(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		    AcctInfo info = getModel(AcctInfo.class,request.getParameterMap());
		    
		    logger.info(" updateAcctInfo> param>"+info.toLog());
		    
		    AcctInfo ori=acctInfoService.findById(info.getUserid());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	acctInfoService.update(info);
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
	 * 删除帐户信息
	 */
    @RequestMapping("/inner/acctInfo/delete")
    public void deleteAcctInfoById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	AcctInfo info = getModel(AcctInfo.class,request.getParameterMap());
		   	
		   	logger.info("deleteAcctInfoById > param>"+info.getUserid());
		   	
			acctInfoService.delete(info.getUserid());
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
	 * 查询全部帐户信息
	 */

    /*
    @RequestMapping("/inner/acctInfo/findAllAcctInfo")
    public void findAllAcctInfo(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<AcctInfo> allList = acctInfoService.findAll();
			result.getData().put("allList",allList);
			result.setMessage("findAll acctInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll acctInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	} 
	*/
	
	/**
	 * 删除多个帐户信息
	 */
	/*
	@RequestMapping("/inner/acctInfo/deleteIds")
	public void deleteAcctInfo(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("userid");
			logger.info("delete batch> param>"+id);
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				acctInfoService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete acctInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	*/
	
	/**
	 * 列表查询
	 */
	@RequestMapping("/inner/acctInfo/list")
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
			PojoDomain<AcctInfo> list = acctInfoService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find acctInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find acctInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}